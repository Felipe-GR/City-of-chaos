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
	 * Acci�n que se va a realizar.
	 */
	private int accion;

	/**
	 * �ndice de la fila donde se pondr� el objeto.
	 */
	private int calle;

	/**
	 * �ndice de la columna donde se pondr� el objeto.
	 */
	private int carrera;

	/**
	 * Direcci�n que tendr� el veh�culo.
	 */
	private String direccion;

	/**
	 * Constructor que permite crear un objeto de tipo nodo vac�o.
	 */
	public Nodo() {

	}

	/**
	 * Constructor para crear un nuevo nodo.
	 * 
	 * @param padre
	 *            el nodo anterior
	 * @param accion
	 *            la acci�n que realizara el veh�culo.
	 * @param calle
	 *            el �ndice de la fila donde se pondr� el objeto.
	 * @param carrera
	 *            el �ndice de la fila donde se pondr� el objeto.
	 * @param orientacion
	 *            la direcci�n que tendr� el veh�culo.
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
	 * Permite conocer la acci�n que va a realizar el veh�culo.
	 * 
	 * @return la acci�n que se realizara.
	 */
	public int obtenerAccion() {

		return accion;

	}

	/**
	 * Permite establecer la acci�n que realizara el veh�culo.
	 * 
	 * @param accion
	 *            la acci�n a realizar por el veh�culo.
	 */
	public void darMovimiento(int accion) {

		this.accion = accion;

	}

	/**
	 * Retorna el �ndice de la fila donde se pondr� el objeto.
	 * 
	 * @return el �ndice de la fila donde se pondr� el objeto.
	 */
	public int obtenerCalle() {

		return calle;

	}

	/**
	 * Establece el �ndice de la fila donde se pondr� el objeto.
	 * 
	 * @param calle
	 *            el �ndice de la fila donde se pondr� el objeto.
	 */
	public void darCalle(int calle) {

		this.calle = calle;

	}

	/**
	 * Retorna el �ndice de la columna donde se pondr� el objeto.
	 * 
	 * @return el �ndice de la columna donde se pondr� el objeto.
	 */
	public int obtenerCarrera() {

		return carrera;

	}

	/**
	 * Establece el �ndice de la columna donde se pondr� el objeto.
	 * 
	 * @param carrera
	 *            el �ndice de la columna donde se pondr� el objeto.
	 */
	public void darCarrera(int carrera) {

		this.carrera = carrera;

	}

	/**
	 * Retorna la direcci�n actual que tiene el veh�culo.
	 * 
	 * @return la direcci�n del veh�culo.
	 */
	public String obtenerOrientacion() {

		return direccion;

	}

	/**
	 * Cambia la direcci�n del veh�culo.
	 * 
	 * @param nuevaDireccion
	 *            la nueva direcci�n del veh�culo.
	 */
	public void darOrientacion(String nuevaDireccion) {

		this.direccion = nuevaDireccion;

	}
}