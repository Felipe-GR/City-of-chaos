package eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlador.Controlador;
import util.Constantes;
import vista.PanelCiudad;
import vista.PanelVehiculo;

public class EventosMouse extends MouseAdapter implements Serializable {

	/**
	 * Serial usado para hacer persistir los eventos del mouse.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Permite ejecutar las actividades del controlador asociados al mouse.
	 */
	private Controlador controlador;

	/**
	 * Instancia de la ciudad.
	 */
	private PanelCiudad panelCiudad;

	/**
	 * Icono de un edificio.
	 */
	private ImageIcon imgIconoEdificio;

	/**
	 * Icono de la meta.
	 */
	private ImageIcon imgIconoMeta;

	/**
	 * Representa la ciudad.
	 */
	private JLabel lblCiudad;

	/**
	 * Índice de la fila donde se pondrá el objeto.
	 */
	private int calle;

	/**
	 * Índice de la columna donde se pondrá el objeto.
	 */
	private int carrera;

	/**
	 * Constructor para ejecutar los eventos del mouse-
	 * 
	 * @param controlador
	 *            permite ejecutar las actividades asociadas a los eventos del
	 *            mouse.
	 * @param panelCiudad
	 *            instancia para manejar los componentes de la ciudad.
	 * @param lblCiudad
	 *            representación de la ciudad.
	 * @param calle
	 *            Índice de la fila donde se ejecutará el evento.
	 * @param carrera
	 *            Índice de la fila donde se ejecutará el evento.
	 */
	public EventosMouse(Controlador controlador, PanelCiudad panelCiudad, JLabel lblCiudad, int calle, int carrera) {

		this.controlador = controlador;
		this.panelCiudad = panelCiudad;

		this.lblCiudad = lblCiudad;

		this.imgIconoEdificio = new ImageIcon(Constantes.RUTA_ICONO_EDIFICIO);
		this.imgIconoMeta = new ImageIcon(Constantes.RUTA_ICONO_META);

		this.calle = calle;
		this.carrera = carrera;

	}

	/**
	 * Permite poner un edificio en la posición dada.
	 */
	public void ponerEdificios() {

		if ((lblCiudad.getText()).equalsIgnoreCase("") && lblCiudad.getIcon() == null) {

			lblCiudad.setIcon(imgIconoEdificio);
			controlador.ponerElemento(calle, carrera, Constantes.SIMBOLO_EDIFICIO);

		} else {

			lblCiudad.setIcon(null);
			controlador.ponerElemento(calle, carrera, Constantes.SIMBOLO_CASILLA_VACIA);

		}

	}

	/**
	 * Permite dar los datos del vehículo.
	 */
	public void ponerVehiculo() {

		PanelVehiculo panelVehiculo = new PanelVehiculo(this.controlador, carrera, calle);
		panelVehiculo.setVisible(true);

	}

	/**
	 * Establece la meta.
	 */
	public void ponerMeta() {

		if ((lblCiudad.getText()).equalsIgnoreCase(Constantes.SIMBOLO_CASILLA_VACIA) && lblCiudad.getIcon() == null) {

			lblCiudad.setIcon(imgIconoMeta);
			controlador.ponerElemento(calle, carrera, Constantes.SIMBOLO_META);

		} else {

			lblCiudad.setIcon(null);
			controlador.ponerElemento(calle, carrera, Constantes.SIMBOLO_CASILLA_VACIA);

		}

	}

	/**
	 * Permite ejecutar los eventos asociados al mouse.
	 */
	@Override
	public void mouseClicked(MouseEvent evento) {

		if (panelCiudad.obtenerEstadoVehiculo() == false) {

			if (evento.isShiftDown()) {

				// Shif+Botón derecho
				if (evento.isMetaDown()) {

					ponerMeta();

					// Shift+Botón Izquierdo
				} else {

					ponerVehiculo();

				}

			} else {

				// botón derecho del ratón - Coloca muros
				if (evento.isMetaDown()) {

					ponerEdificios();

				}

			}

		}

	}

}
