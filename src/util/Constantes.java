package util;

import java.io.Serializable;

public class Constantes implements Serializable {

	/**
	 * Serial usado para hacer persistir la ciudad.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constante que simboliza una casilla vacía.
	 */
	public final static String SIMBOLO_CASILLA_VACIA = "";

	/**
	 * Constante que simboliza un edificio.
	 */
	public final static String SIMBOLO_EDIFICIO = "Edificio";

	/**
	 * Constante que simboliza la meta.
	 */
	public final static String SIMBOLO_META = "Meta";

	/**
	 * Constante que simboliza la dirección norte.
	 */
	public final static String NORTE = "Norte";

	/**
	 * Constante que simboliza la dirección sur.
	 */
	public final static String SUR = "Sur";

	/**
	 * Constante que simboliza la dirección este.
	 */
	public final static String ESTE = "Este";

	/**
	 * Constante que simboliza la dirección oeste.
	 */
	public final static String OESTE = "Oeste";

	/**
	 * Constante usada para las acciones del botón.
	 */
	public final static String ACEPTAR = "Aceptar";

	/**
	 * Constante que simboliza el vehículo
	 */
	public final static String SIMBOLO_VEHICULO = "Vehiculo";

	/**
	 * Constante que indica la ruta del icono del vehículo mirando hacia el norte.
	 */
	public final static String RUTA_ICONO_NORTE = "./iconos/carro_arriba.jpg";

	/**
	 * Constante que indica la ruta del icono del vehículo mirando hacia el sur.
	 */
	public final static String RUTA_ICONO_SUR = "./iconos/carro_abajo.jpg";

	/**
	 * Constante que indica la ruta del icono del vehículo mirando hacia el este.
	 */
	public final static String RUTA_ICONO_ESTE = "./iconos/carro_derecha.jpg";

	/**
	 * Constante que indica la ruta del icono del vehículo mirando hacia el oeste.
	 */
	public final static String RUTA_ICONO_OESTE = "./iconos/carro_izquierda.jpg";

	/**
	 * Constante que indica la ruta del icono de un edificio.
	 */
	public final static String RUTA_ICONO_EDIFICIO = "./iconos/edificio.jpg";

	/**
	 * Constante que indica la ruta del icono de un edificio.
	 */
	public final static String RUTA_ICONO_META = "./iconos/meta.jpg";

	/**
	 * Constante asociada a la barra de menú para representar una opción.
	 */
	public final static String CIUDAD = "Ciudad";

	/**
	 * Constante asociada a una opción del menú que permite ejecutar la acción de
	 * guardar.
	 */
	public final static String GUARDAR = "Guardar ciudad";

	/**
	 * Constante asociada a una opción del menú que permite ejecutar la acción de
	 * cargar.
	 */
	public final static String CARGAR = "Cargar ciudad";

}