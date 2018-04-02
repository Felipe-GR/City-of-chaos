package controlador;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import mundo.Ciudad;
import mundo.Hilo;
import mundo.Vehiculo;
import util.Constantes;
import vista.PanelCiudad;

public class Controlador implements Serializable {

	/**
	 * Serial usado para hacer persistir el controlador.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * La ciudad donde se ejecutaran los eventos.
	 */
	private Ciudad ciudad;

	/**
	 * Veh�culo que se pondr� en la ciudad.
	 */
	private Vehiculo vehiculo;

	/**
	 * Representaci�n grafica de la ciudad donde se visualizaran los eventos de
	 * forma grafica.
	 */
	private PanelCiudad panelCiudad;

	/**
	 * Permite crear una nueva ciudad vinculada al controlador.
	 */
	public Controlador() {

		ciudad = new Ciudad();

	}

	/**
	 * Permite ejecutar los eventos asociados al controlador en la interfaz grafica.
	 * 
	 * @param panelCiudad
	 *            la representaci�n grafica de la ciudad donde se ejecutar�n los
	 *            eventos.
	 */
	public void conectarCiudad(PanelCiudad panelCiudad) {

		this.panelCiudad = panelCiudad;

	}

	/**
	 * Poner un elemento en la ciudad.
	 * 
	 * @param calle
	 *            el �ndice de la fila donde se pondr� el objeto.
	 * @param carrera
	 *            el �ndice de la columna donde se pondr� el objeto.
	 * @param elElemento
	 *            el elemento que se pondr� en la ciudad en la posici�n (calle,
	 *            carrera).
	 */
	public void ponerElemento(int calle, int carrera, String elElemento) {

		ciudad.darElemento(calle, carrera, elElemento);

	}

	/**
	 * Permite poner el veh�culo en la ciudad.
	 * 
	 * @param calle
	 *            el �ndice de la fila donde se pondr� el objeto.
	 * @param carrera
	 *            el �ndice de la columna donde se pondr� el objeto.
	 * @param direccion
	 *            la direcci�n que tiene el veh�culo.
	 * @param regionBusquedaCalle
	 *            la regi�n en el eje x donde va a buscar.
	 * @param regionBusquedaCarrera
	 *            la regi�n en el eje y donde va a buscar.
	 */
	public void ponerVehiculo(int calle, int carrera, String direccion, String regionBusquedaCalle,
			String regionBusquedaCarrera) {

		panelCiudad.ponerIcono(calle, carrera, Constantes.SIMBOLO_CASILLA_VACIA, null);
		panelCiudad.ponerIcono(calle, carrera, Constantes.SIMBOLO_VEHICULO, direccion);

		vehiculo = new Vehiculo(ciudad, calle, carrera, direccion);
		ciudad.darVehiculo(vehiculo);

		panelCiudad.darEstadoVehiculo(true);

		Hilo hilo = new Hilo(ciudad, this);

		hilo.busquedaInformada(regionBusquedaCalle, regionBusquedaCarrera);
		hilo.start();

	}

	/**
	 * Permite identificar si el veh�culo llego a la meta.
	 * 
	 * @return si el veh�culo llego a la meta.
	 */
	public boolean esLaMeta() {

		return vehiculo.esLaMeta();

	}

	/**
	 * Permite mover el veh�culo por el mundo si es posible.
	 * 
	 * @return si es posible mover el veh�culo.
	 */
	public boolean mover() {

		int avenida = vehiculo.obtenerCalle();
		int calle = vehiculo.obtenerCarrera();

		boolean esPosible;

		panelCiudad.ponerIcono(vehiculo.obtenerCalle(), vehiculo.obtenerCarrera(), Constantes.SIMBOLO_VEHICULO, "");

		esPosible = vehiculo.moverVehiculo(vehiculo.obtenerDireccionVehiculo());

		panelCiudad.ponerIcono(vehiculo.obtenerCalle(), vehiculo.obtenerCarrera(), Constantes.SIMBOLO_CASILLA_VACIA,
				null);
		panelCiudad.ponerIcono(vehiculo.obtenerCalle(), vehiculo.obtenerCarrera(), Constantes.SIMBOLO_VEHICULO,
				vehiculo.obtenerDireccionVehiculo());
		panelCiudad.ponerIcono(avenida, calle, ciudad.obtenerElementoPosicion(avenida, calle), null);

		return esPosible;

	}

	/**
	 * Permite girar a la izquierda el veh�culo.
	 */
	public void girarIzquierda() {

		vehiculo.giraIzquierda(vehiculo.obtenerDireccionVehiculo());
		panelCiudad.ponerIcono(vehiculo.obtenerCalle(), vehiculo.obtenerCarrera(), Constantes.SIMBOLO_VEHICULO,
				vehiculo.obtenerDireccionVehiculo());

	}

	/**
	 * Permite girar a la derecha el veh�culo.
	 */
	public void girarDerecha() {

		vehiculo.girarDerecha(vehiculo.obtenerDireccionVehiculo());
		panelCiudad.ponerIcono(vehiculo.obtenerCalle(), vehiculo.obtenerCarrera(), Constantes.SIMBOLO_VEHICULO,
				vehiculo.obtenerDireccionVehiculo());

	}

	/**
	 * Permite guardar una ciudad.
	 * 
	 * @throws IOException
	 *             ha habido un error guardando la ciudad.
	 */
	public void guardarCiudad() throws IOException {

		ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("./ciudad/ciudad.data"));
		archivo.writeObject(ciudad);
		archivo.close();

	}

	/**
	 * Permite cargar la ciudad.
	 * 
	 * @throws FileNotFoundException
	 *             no se encontr� el archivo.
	 * @throws IOException
	 *             se produjo un error leyendo el archivo.
	 * @throws ClassNotFoundException
	 *             la clase ciudad ha sufrido cambios.
	 */
	public void cargarCiudad() throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream archivo = new ObjectInputStream(new FileInputStream("./ciudad/ciudad.data"));

		while (true) {

			try {

				ciudad = (Ciudad) archivo.readObject();

			} catch (EOFException e) {

				break;

			}

		}

		archivo.close();

		dibujarCiudad();

	}

	/**
	 * Dibuja la ciudad.
	 */

	public void dibujarCiudad() {

		String laCiudad[][] = ciudad.obtenerCiudad();

		for (int i = 0; i < laCiudad.length; i++) {

			for (int j = 0; j < laCiudad[i].length; j++) {

				if (laCiudad[i][j].equalsIgnoreCase(Constantes.SIMBOLO_EDIFICIO)) {

					ponerElemento(i, j, Constantes.SIMBOLO_EDIFICIO);
					panelCiudad.ponerIcono(i, j, Constantes.SIMBOLO_EDIFICIO, null);

				}

			}

		}

	}

}