package vista;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import eventos.EventosMouse;
import util.Constantes;

public class PanelCiudad extends JPanel {

	/**
	 * Serial usado para hacer persistir la ciudad.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Icono del vehículo mirando hacia el norte.
	 */
	private ImageIcon imgIconoNorte;

	/**
	 * Icono del vehículo mirando hacia el sur.
	 */
	private ImageIcon imgIconoSur;

	/**
	 * Icono del vehículo mirando hacia el este.
	 */
	private ImageIcon imgIconoEste;

	/**
	 * Icono del vehículo mirando hacia el oeste.
	 */
	private ImageIcon imgIconoOeste;

	/**
	 * Icono de un edificio.
	 */
	private ImageIcon imgIconoEdificio;

	/**
	 * Matriz que representa la ciudad
	 */
	private JLabel lblCiudad[][];

	/**
	 * Permite saber si el icono del vehículo esta puesto en la ciudad.
	 */
	private boolean vehiculoPuesto;

	/**
	 * Construye una nueva ciudad.
	 * 
	 * @param controlador
	 *            permite ejecutar las instrucciones asociadas al controlador.
	 */
	public PanelCiudad(Controlador controlador) {

		inicializarComponentes();
		anadirEventos(controlador);

	}

	/**
	 * Inicializa los componentes del panel.
	 */
	public void inicializarComponentes() {

		setLayout(new GridLayout(30, 30));

		lblCiudad = new JLabel[30][30];

		darEstadoVehiculo(false);

		imgIconoNorte = new ImageIcon(Constantes.RUTA_ICONO_NORTE);
		imgIconoSur = new ImageIcon(Constantes.RUTA_ICONO_SUR);
		imgIconoOeste = new ImageIcon(Constantes.RUTA_ICONO_OESTE);
		imgIconoEste = new ImageIcon(Constantes.RUTA_ICONO_ESTE);
		imgIconoEdificio = new ImageIcon(Constantes.RUTA_ICONO_EDIFICIO);

		for (int calle = 0; calle < lblCiudad.length; calle++) {

			for (int carrera = 0; carrera < lblCiudad[calle].length; carrera++) {

				lblCiudad[calle][carrera] = new JLabel("");

				lblCiudad[calle][carrera]
						.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new TitledBorder("")));

				lblCiudad[calle][carrera].setHorizontalAlignment(JLabel.CENTER);
				lblCiudad[calle][carrera].setVerticalAlignment(JLabel.CENTER);

				add(lblCiudad[calle][carrera]);

			}

		}

	}

	/**
	 * Añade eventos de mouse a cada casilla de la ciudad.
	 * 
	 * @param controlador
	 *            ejecuta los eventos asociados al controlador en cada casilla.
	 */
	public void anadirEventos(Controlador controlador) {

		for (int calle = 0; calle < lblCiudad.length; calle++) {

			for (int carrera = 0; carrera < lblCiudad[calle].length; carrera++) {

				lblCiudad[calle][carrera].addMouseListener(
						new EventosMouse(controlador, this, lblCiudad[calle][carrera], calle, carrera));

			}

		}

	}

	/**
	 * Pone el icono correspondiente en una casilla de la ciudad.
	 * 
	 * @param calle
	 *            índice de la fila donde se pondrá el objeto.
	 * @param carrera
	 *            índice de la columna donde se pondrá el objeto.
	 * @param elElemento
	 *            elemento en la fila y la columna indicada.
	 * @param direccion
	 *            si el elemento es el vehículo, es la dirección del icono a cargar.
	 */
	public void ponerIcono(int calle, int carrera, String elElemento, String direccion) {

		if (elElemento.equalsIgnoreCase(Constantes.SIMBOLO_CASILLA_VACIA) && direccion == null) {

			lblCiudad[calle][carrera].setText(Constantes.SIMBOLO_CASILLA_VACIA);

		} else if (elElemento.equalsIgnoreCase(Constantes.SIMBOLO_EDIFICIO) && direccion == null) {

			lblCiudad[calle][carrera].setIcon(imgIconoEdificio);

		} else if (elElemento.equalsIgnoreCase(Constantes.SIMBOLO_VEHICULO) && direccion != null) {

			if (direccion.equalsIgnoreCase(Constantes.NORTE)) {

				lblCiudad[calle][carrera].setIcon(imgIconoNorte);

			} else if (direccion.equalsIgnoreCase(Constantes.SUR)) {

				lblCiudad[calle][carrera].setIcon(imgIconoSur);

			} else if (direccion.equalsIgnoreCase(Constantes.OESTE)) {

				lblCiudad[calle][carrera].setIcon(imgIconoOeste);

			} else if (direccion.equalsIgnoreCase(Constantes.ESTE)) {

				lblCiudad[calle][carrera].setIcon(imgIconoEste);

			} else {

				lblCiudad[calle][carrera].setIcon(null);

			}

			darEstadoVehiculo(true);

		}

	}

	/**
	 * Retorna si el vehículo fue puesto en la ciudad.
	 * 
	 * @return si el vehículo esta puesto.
	 */
	public boolean obtenerEstadoVehiculo() {

		return vehiculoPuesto;

	}

	/**
	 * Cambia el estado del vehículo en la ciudad.
	 * 
	 * @param estaPuesto
	 *            poner vehículo en la ciudad.
	 */
	public void darEstadoVehiculo(boolean estaPuesto) {

		vehiculoPuesto = estaPuesto;

	}

}
