package mundo;

import java.io.Serializable;
import java.util.Arrays;

import util.Constantes;

public class Ciudad implements Serializable {

	/**
	 * Serial usado para hacer persistir la ciudad.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Representa la ciudad actual.
	 */
	private String ciudad[][];

	/**
	 * Representa el vehículo a poner en la ciudad.
	 */
	private Vehiculo vehiculo;

	/**
	 * Permite construir una nueva ciudad.
	 */
	public Ciudad() {

		ciudad = new String[30][30];
		inicializarCiudad("");

	}

	/**
	 * Da el estado inicial de la matriz.
	 * 
	 * @param elContenido
	 *            contenido incial de la matriz.
	 */
	public void inicializarCiudad(String elContenido) {

		for (String cuadra[] : ciudad) {

			Arrays.fill(cuadra, elContenido);

		}

	}

	/**
	 * Permite saber si enfrente del vehículo hay un edificio.
	 * 
	 * @param calleActual
	 *            el indice de la fila donde se buscará el objeto.
	 * @param carreraActual
	 *            el indice de la columna donde se buscará el objeto.
	 * @return si hay un edificio en frente.
	 */
	public boolean estaBloqueado(int calleActual, int carreraActual) {

		if (ciudad[calleActual][carreraActual].equalsIgnoreCase(Constantes.SIMBOLO_EDIFICIO)) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Permite determinar si la meta fue encontrada.
	 * 
	 * @param calle
	 *            el índice de la fila donde se buscará el objeto.
	 * @param carrera
	 *            el índice de la fila donde se buscará el objeto.
	 * @return si el vehículo llego a la meta.
	 */
	public boolean esLaMeta(int calle, int carrera) {

		if (ciudad[calle][carrera].equalsIgnoreCase(Constantes.SIMBOLO_META)) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Permite ubicar el vehículo en la ciudad.
	 * 
	 * @param elVehiculo
	 *            el vehículo a ubicar.
	 */
	public void darVehiculo(Vehiculo elVehiculo) {

		this.vehiculo = elVehiculo;
	}

	/**
	 * Retorna la ciudad actual.
	 * 
	 * @return la ciudad actual.
	 */
	public String[][] obtenerCiudad() {

		return ciudad;

	}

	/**
	 * Permite obtener el elemento que está en la posición (calle, carrera) de la
	 * ciudad.
	 * 
	 * @param calle
	 *            el índice de la fila donde se buscará el objeto.
	 * @param carrera
	 *            el índice de la columna donde se buscar el objeto.
	 * @return el elemento en la posición (calle, carrera).
	 */
	public String obtenerElementoPosicion(int calle, int carrera) {

		String elElemento = ciudad[calle][carrera];

		return elElemento;

	}

	/**
	 * Permite poner un objeto en la matriz.
	 * 
	 * @param calle
	 *            el índice de la fila donde se pondrá el objeto.
	 * @param carrera
	 *            el índice de la columna donde se pondrá el objeto.
	 * @param elObjeto
	 *            el objeto que se pondrá en la posición (calle, carrera) de la
	 *            ciudad.
	 */
	public void darElemento(int calle, int carrera, String elObjeto) {

		ciudad[calle][carrera] = elObjeto;

	}

	/**
	 * Retorna el índice de la fila donde se pondrá el objeto.
	 * 
	 * @return el índice de la fila donde se pondrá el objeto.
	 */
	public int obtenerCalle() {

		return vehiculo.obtenerCalle();

	}

	/**
	 * Retorna el índice de la columna donde se pondrá el objeto.
	 * 
	 * @return el índice de la columna donde se pondrá el objeto.
	 */
	public int obtenerCarrera() {

		return vehiculo.obtenerCarrera();

	}

	/**
	 * Retorna la dirección actual que tiene el vehículo.
	 * 
	 * @return la dirección del vehículo.
	 */
	public String obtenerDireccionVehiculo() {

		return vehiculo.obtenerDireccionVehiculo();

	}

	/**
	 * Cambia la dirección del vehículo.
	 * 
	 * @param nuevaDireccion
	 *            la nueva dirección del vehículo.
	 */
	public void darDireccionVehiculo(String nuevaDireccion) {

		vehiculo.darDireccionVehiculo(nuevaDireccion);

	}

}
