package mundo;

import java.io.Serializable;

import util.Constantes;

public class Vehiculo implements Serializable {

	/**
	 * Serial usado para hacer persistir el veh�culo.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ciudad en la cual se ubicar� el veh�culo.
	 */
	private Ciudad ciudad;

	/**
	 * �ndice de la fila donde se pondr� el objeto.
	 */
	private int calle;

	/**
	 * �ndice de la columna donde se pondr� el objeto.
	 */
	private int carrera;

	/**
	 * Direcci�n que tiene el veh�culo.
	 */
	private String direccionVehiculo;

	/**
	 * Permite crear un nuevo veh�culo.
	 * 
	 * @param ciudad
	 *            la ciudad que se est� utilizando.
	 * @param calle
	 *            �ndice de la fila donde se pondr� el objeto.
	 * @param carrera
	 *            �ndice de la columna donde se pondr� el objeto.
	 * @param direccionVehiculo
	 *            la direcci�n que tenga el veh�culo en los diferentes momentos.
	 */
	public Vehiculo(Ciudad ciudad, int calle, int carrera, String direccionVehiculo) {

		this.ciudad = ciudad;

		this.calle = calle;
		this.carrera = carrera;

		this.direccionVehiculo = direccionVehiculo;

	}

	/**
	 * El veh�culo gira a la izquierda dependiendo la direcci�n que tenga.
	 * 
	 * @param direccion
	 *            la direcci�n del veh�culo.
	 */
	public void giraIzquierda(String direccion) {

		if (direccion.equalsIgnoreCase(Constantes.NORTE)) {

			darDireccionVehiculo(Constantes.OESTE);

		} else if (direccion.equalsIgnoreCase(Constantes.OESTE)) {

			darDireccionVehiculo(Constantes.SUR);

		} else if (direccion.equalsIgnoreCase(Constantes.SUR)) {

			darDireccionVehiculo(Constantes.ESTE);

		} else if (direccion.equalsIgnoreCase(Constantes.ESTE)) {

			darDireccionVehiculo(Constantes.NORTE);

		}

	}

	/**
	 * El veh�culo gira a la derecha dependiendo la direcci�n que tenga.
	 * 
	 * @param direccion
	 *            la direcci�n del veh�culo.
	 */
	public void girarDerecha(String direccion) {

		if (direccion.equalsIgnoreCase(Constantes.NORTE)) {

			darDireccionVehiculo(Constantes.ESTE);

		} else if (direccion.equalsIgnoreCase(Constantes.ESTE)) {

			darDireccionVehiculo(Constantes.SUR);

		} else if (direccion.equalsIgnoreCase(Constantes.SUR)) {

			darDireccionVehiculo(Constantes.OESTE);

		} else if (direccion.equalsIgnoreCase(Constantes.OESTE)) {

			darDireccionVehiculo(Constantes.NORTE);

		}

	}

	/**
	 * Mueve el veh�culo si es posible.
	 * 
	 * @param direccion
	 *            direcci�n del veh�culo.
	 * @return si es posible mover el veh�culo.
	 */
	public boolean moverVehiculo(String direccion) {

		if (estaBloqueado()) {

			if ((direccion.equalsIgnoreCase(Constantes.NORTE)) && (puedeAvanzarCalle() == true)) {

				calle--;

			} else if ((direccionVehiculo.equalsIgnoreCase(Constantes.SUR)) && (puedeAvanzarCalle() == true)) {

				calle++;

			} else if ((direccionVehiculo.equalsIgnoreCase(Constantes.ESTE)) && (puedeAvanzarCarrera() == true)) {

				carrera++;

			} else if ((direccionVehiculo.equalsIgnoreCase(Constantes.OESTE)) && (puedeAvanzarCarrera() == true)) {

				carrera--;

			}

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Determina si hay un edificio enfrente.
	 * 
	 * @return si hay un edificio enfrente.
	 */
	public boolean estaBloqueado() {

		if (ciudad.estaBloqueado(calle, carrera) == true) {

			return false;

		} else {

			return true;

		}

	}

	/**
	 * Determina si est� en una posici�n valida en las filas.
	 * 
	 * @return si est� en una posici�n valida.
	 */
	public boolean puedeAvanzarCalle() {

		if (calle > 0 || calle < 29) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Determina si est� en una posici�n valida en las columnas.
	 * 
	 * @return si est� en una posici�n valida.
	 */
	public boolean puedeAvanzarCarrera() {

		if (carrera > 0 || carrera < 29) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Determina si se alcanz� la meta.
	 * 
	 * @return si es la meta.
	 */
	public boolean esLaMeta() {

		if (ciudad.esLaMeta(calle, carrera)) {

			return true;

		} else {

			return false;

		}

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
	 * Retorna el �ndice de la columna donde se pondr� el objeto.
	 * 
	 * @return el �ndice de la columna donde se pondr� el objeto.
	 */
	public int obtenerCarrera() {

		return carrera;

	}

	/**
	 * Retorna la direcci�n actual que tiene el veh�culo.
	 * 
	 * @return la direcci�n del veh�culo.
	 */
	public String obtenerDireccionVehiculo() {

		return direccionVehiculo;

	}

	/**
	 * Cambia la direcci�n del veh�culo.
	 * 
	 * @param nuevaDireccion
	 *            la nueva direcci�n del veh�culo.
	 */
	public void darDireccionVehiculo(String nuevaDireccion) {

		this.direccionVehiculo = nuevaDireccion;

	}

}
