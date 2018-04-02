package arbol;

import java.io.Serializable;

public class Nodo implements Serializable {

	/**
	 * Serial usado para hacer persistir el nodo.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Referencia al nodo anterior.
	 */
	private int padre;

	/**
	 * Acción que se va a realizar.
	 */
	private int accion;

	/**
	 * Índice de la fila donde se pondrá el objeto.
	 */
	private int calle;

	/**
	 * Índice de la columna donde se pondrá el objeto.
	 */
	private int carrera;

	/**
	 * Dirección que tendrá el vehículo.
	 */
	private String direccion;

	/**
	 * Constructor que permite crear un objeto de tipo nodo vacío.
	 */
	public Nodo() {

	}

	/**
	 * Constructor para crear un nuevo nodo.
	 * 
	 * @param padre
	 *            el nodo anterior
	 * @param accion
	 *            la acción que realizara el vehículo.
	 * @param calle
	 *            el índice de la fila donde se pondrá el objeto.
	 * @param carrera
	 *            el índice de la fila donde se pondrá el objeto.
	 * @param orientacion
	 *            la dirección que tendrá el vehículo.
	 */
	public Nodo(int padre, int accion, int calle, int carrera, String orientacion) {

		this.padre = padre;

		this.accion = accion;

		this.calle = calle;
		this.carrera = carrera;

		this.direccion = orientacion;

	}

	/**
	 * Permite referenciar el nodo anterior.
	 * 
	 * @return el nodo anterior
	 */
	public int obtenerPadre() {

		return padre;

	}

	/**
	 * Permite establecer el nodo padre.
	 * 
	 * @param padre
	 *            la referencia al nodo anterior.
	 */
	public void darPadre(int padre) {

		this.padre = padre;

	}

	/**
	 * Permite conocer la acción que va a realizar el vehículo.
	 * 
	 * @return la acción que se realizara.
	 */
	public int obtenerAccion() {

		return accion;

	}

	/**
	 * Permite establecer la acción que realizara el vehículo.
	 * 
	 * @param accion
	 *            la acción a realizar por el vehículo.
	 */
	public void darMovimiento(int accion) {

		this.accion = accion;

	}

	/**
	 * Retorna el índice de la fila donde se pondrá el objeto.
	 * 
	 * @return el índice de la fila donde se pondrá el objeto.
	 */
	public int obtenerCalle() {

		return calle;

	}

	/**
	 * Establece el índice de la fila donde se pondrá el objeto.
	 * 
	 * @param calle
	 *            el índice de la fila donde se pondrá el objeto.
	 */
	public void darCalle(int calle) {

		this.calle = calle;

	}

	/**
	 * Retorna el índice de la columna donde se pondrá el objeto.
	 * 
	 * @return el índice de la columna donde se pondrá el objeto.
	 */
	public int obtenerCarrera() {

		return carrera;

	}

	/**
	 * Establece el índice de la columna donde se pondrá el objeto.
	 * 
	 * @param carrera
	 *            el índice de la columna donde se pondrá el objeto.
	 */
	public void darCarrera(int carrera) {

		this.carrera = carrera;

	}

	/**
	 * Retorna la dirección actual que tiene el vehículo.
	 * 
	 * @return la dirección del vehículo.
	 */
	public String obtenerOrientacion() {

		return direccion;

	}

	/**
	 * Cambia la dirección del vehículo.
	 * 
	 * @param nuevaDireccion
	 *            la nueva dirección del vehículo.
	 */
	public void darOrientacion(String nuevaDireccion) {

		this.direccion = nuevaDireccion;

	}
}