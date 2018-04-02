package mundo;

import java.io.Serializable;

import util.Constantes;

public class Vehiculo implements Serializable {

	/**
	 * Serial usado para hacer persistir el vehículo.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ciudad en la cual se ubicará el vehículo.
	 */
	private Ciudad ciudad;

	/**
	 * Índice de la fila donde se pondrá el objeto.
	 */
	private int calle;

	/**
	 * Índice de la columna donde se pondrá el objeto.
	 */
	private int carrera;

	/**
	 * Dirección que tiene el vehículo.
	 */
	private String direccionVehiculo;

	/**
	 * Permite crear un nuevo vehículo.
	 * 
	 * @param ciudad
	 *            la ciudad que se está utilizando.
	 * @param calle
	 *            índice de la fila donde se pondrá el objeto.
	 * @param carrera
	 *            índice de la columna donde se pondrá el objeto.
	 * @param direccionVehiculo
	 *            la dirección que tenga el vehículo en los diferentes momentos.
	 */
	public Vehiculo(Ciudad ciudad, int calle, int carrera, String direccionVehiculo) {

		this.ciudad = ciudad;

		this.calle = calle;
		this.carrera = carrera;

		this.direccionVehiculo = direccionVehiculo;

	}

	/**
	 * El vehículo gira a la izquierda dependiendo la dirección que tenga.
	 * 
	 * @param direccion
	 *            la dirección del vehículo.
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
	 * El vehículo gira a la derecha dependiendo la dirección que tenga.
	 * 
	 * @param direccion
	 *            la dirección del vehículo.
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
	 * Mueve el vehículo si es posible.
	 * 
	 * @param direccion
	 *            dirección del vehículo.
	 * @return si es posible mover el vehículo.
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
	 * Determina si está en una posición valida en las filas.
	 * 
	 * @return si está en una posición valida.
	 */
	public boolean puedeAvanzarCalle() {

		if (calle > 0 || calle < 29) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Determina si está en una posición valida en las columnas.
	 * 
	 * @return si está en una posición valida.
	 */
	public boolean puedeAvanzarCarrera() {

		if (carrera > 0 || carrera < 29) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Determina si se alcanzó la meta.
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
	 * Retorna el índice de la fila donde se pondrá el objeto.
	 * 
	 * @return el índice de la fila donde se pondrá el objeto.
	 */
	public int obtenerCalle() {

		return calle;
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
	 * Retorna la dirección actual que tiene el vehículo.
	 * 
	 * @return la dirección del vehículo.
	 */
	public String obtenerDireccionVehiculo() {

		return direccionVehiculo;

	}

	/**
	 * Cambia la dirección del vehículo.
	 * 
	 * @param nuevaDireccion
	 *            la nueva dirección del vehículo.
	 */
	public void darDireccionVehiculo(String nuevaDireccion) {

		this.direccionVehiculo = nuevaDireccion;

	}

}
