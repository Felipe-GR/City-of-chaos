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
	 * Representa el veh�culo a poner en la ciudad.
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
	 * Permite saber si enfrente del veh�culo hay un edificio.
	 * 
	 * @param calleActual
	 *            el indice de la fila donde se buscar� el objeto.
	 * @param carreraActual
	 *            el indice de la columna donde se buscar� el objeto.
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
	 *            el �ndice de la fila donde se buscar� el objeto.
	 * @param carrera
	 *            el �ndice de la fila donde se buscar� el objeto.
	 * @return si el veh�culo llego a la meta.
	 */
	public boolean esLaMeta(int calle, int carrera) {

		if (ciudad[calle][carrera].equalsIgnoreCase(Constantes.SIMBOLO_META)) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Permite ubicar el veh�culo en la ciudad.
	 * 
	 * @param elVehiculo
	 *            el veh�culo a ubicar.
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
	 * Permite obtener el elemento que est� en la posici�n (calle, carrera) de la
	 * ciudad.
	 * 
	 * @param calle
	 *            el �ndice de la fila donde se buscar� el objeto.
	 * @param carrera
	 *            el �ndice de la columna donde se buscar el objeto.
	 * @return el elemento en la posici�n (calle, carrera).
	 */
	public String obtenerElementoPosicion(int calle, int carrera) {

		String elElemento = ciudad[calle][carrera];

		return elElemento;

	}

	/**
	 * Permite poner un objeto en la matriz.
	 * 
	 * @param calle
	 *            el �ndice de la fila donde se pondr� el objeto.
	 * @param carrera
	 *            el �ndice de la columna donde se pondr� el objeto.
	 * @param elObjeto
	 *            el objeto que se pondr� en la posici�n (calle, carrera) de la
	 *            ciudad.
	 */
	public void darElemento(int calle, int carrera, String elObjeto) {

		ciudad[calle][carrera] = elObjeto;

	}

	/**
	 * Retorna el �ndice de la fila donde se pondr� el objeto.
	 * 
	 * @return el �ndice de la fila donde se pondr� el objeto.
	 */
	public int obtenerCalle() {

		return vehiculo.obtenerCalle();

	}

	/**
	 * Retorna el �ndice de la columna donde se pondr� el objeto.
	 * 
	 * @return el �ndice de la columna donde se pondr� el objeto.
	 */
	public int obtenerCarrera() {

		return vehiculo.obtenerCarrera();

	}

	/**
	 * Retorna la direcci�n actual que tiene el veh�culo.
	 * 
	 * @return la direcci�n del veh�culo.
	 */
	public String obtenerDireccionVehiculo() {

		return vehiculo.obtenerDireccionVehiculo();

	}

	/**
	 * Cambia la direcci�n del veh�culo.
	 * 
	 * @param nuevaDireccion
	 *            la nueva direcci�n del veh�culo.
	 */
	public void darDireccionVehiculo(String nuevaDireccion) {

		vehiculo.darDireccionVehiculo(nuevaDireccion);

	}

}
