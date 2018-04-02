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
	 * �ndice de la fila donde se pondr� el objeto.
	 */
	private int calle;

	/**
	 * �ndice de la columna donde se pondr� el objeto.
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
	 *            representaci�n de la ciudad.
	 * @param calle
	 *            �ndice de la fila donde se ejecutar� el evento.
	 * @param carrera
	 *            �ndice de la fila donde se ejecutar� el evento.
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
	 * Permite poner un edificio en la posici�n dada.
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
	 * Permite dar los datos del veh�culo.
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

				// Shif+Bot�n derecho
				if (evento.isMetaDown()) {

					ponerMeta();

					// Shift+Bot�n Izquierdo
				} else {

					ponerVehiculo();

				}

			} else {

				// bot�n derecho del rat�n - Coloca muros
				if (evento.isMetaDown()) {

					ponerEdificios();

				}

			}

		}

	}

}
