package mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import arbol.Nodo;
import controlador.Controlador;
import util.Constantes;

public class Hilo extends Thread implements Serializable {

	/**
	 * Serial usado para hacer persistir la ciudad.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Permite ejecutar las acciones asociadas al controlador.
	 */
	private Controlador controlador;

	/**
	 * La ciudad en la cual se verán reflejados los cambios.
	 */
	private Ciudad ciudad;

	/**
	 * Ruta a encontrar.
	 */
	private Hashtable<String, String> caminoEjecucion;

	/**
	 * Árbol para guardar los datos del camino.
	 */
	ArrayList<Nodo> arbol;

	/**
	 * Movimientos que hará el vehículo.
	 */
	private ArrayList<String> camino;

	/**
	 * Dirección del vehículo en el eje x.
	 */
	private String direccionCalle;

	/**
	 * Dirección del vehículo en el eje y.
	 */
	private String direccionCarrera;

	/**
	 * Variable de control para saber si es posible alcanzar la meta.
	 */
	private int meta;

	/**
	 * Crea un nuevo hilo para ejecutar procesos en simultaneo.
	 * 
	 * @param ciudad
	 *            la ciudad donde se reflejarán los cambios.
	 * @param controlador
	 *            permite ejecutar los eventos asociados a la clase.
	 */
	public Hilo(Ciudad ciudad, Controlador controlador) {

		this.controlador = controlador;
		this.ciudad = ciudad;

		this.camino = new ArrayList<String>();

	}

	/**
	 * Ejecuta el thread.
	 */
	public void run() {

		int opcion;

		boolean esNecesarioMoverse = true;
		boolean seEncontroLaMeta = false;

		while (seEncontroLaMeta == false) {

			while (esNecesarioMoverse == true) {

				try {

					if (camino.size() > 0) {

						opcion = Integer.parseInt((String) camino.get(0));

						if (opcion == 0) {

							esNecesarioMoverse = controlador.mover();

						} else if (opcion == 1) {

							controlador.girarIzquierda();

						} else if (opcion == 2) {

							controlador.girarDerecha();

						}

						sleep(200);

						if (esNecesarioMoverse == true) {

							if (!controlador.esLaMeta()) {

								camino.remove(0);

							} else {

								esNecesarioMoverse = false;
								seEncontroLaMeta = true;

							}

						} else {

							camino.clear();

						}

					} else {

						esNecesarioMoverse = false;

					}

				} catch (InterruptedException interruptedException) {

					interruptedException.printStackTrace();

				}

			}

			if (seEncontroLaMeta == false && meta == 0) {

				busquedaInformada(direccionCalle, direccionCarrera);
				esNecesarioMoverse = true;

			}

		}

	}

	/**
	 * Búsqueda en profundidad e informada.
	 * 
	 * @param calle
	 *            la dirección donde se va a buscar en el eje x.
	 * @param carrera
	 *            la dirección donde se va a buscar en el eje y.
	 */
	public void busquedaInformada(String calle, String carrera) {

		caminoEjecucion = new Hashtable<String, String>();

		arbol = new ArrayList<Nodo>();
		camino = new ArrayList<String>();

		Nodo nodo = new Nodo();

		String laCiudad[][] = new String[30][30];
		laCiudad = ciudad.obtenerCiudad();

		int padreAux = 0;
		int nodoAnterior = 0;

		int cuadrante = 0;

		this.direccionCarrera = carrera;
		this.direccionCalle = calle;

		int calleAux = ciudad.obtenerCalle();
		int carreraAux = ciudad.obtenerCarrera();

		int calleActual = 0;
		int carreraActual = 0;

		int mover = 0;
		int girar = 0;

		if (carrera.equalsIgnoreCase(Constantes.NORTE) && calle.equalsIgnoreCase(Constantes.ESTE)) {

			cuadrante = 1;

		}

		if (carrera.equalsIgnoreCase(Constantes.NORTE) && calle.equalsIgnoreCase(Constantes.OESTE)) {

			cuadrante = 2;

		}

		if (carrera.equalsIgnoreCase(Constantes.SUR) && calle.equalsIgnoreCase(Constantes.ESTE)) {

			cuadrante = 3;

		}

		if (carrera.equalsIgnoreCase(Constantes.SUR) && calle.equalsIgnoreCase(Constantes.OESTE)) {

			cuadrante = 4;

		}

		if (ciudad.obtenerDireccionVehiculo().equalsIgnoreCase(Constantes.NORTE)
				&& (cuadrante == 3 || cuadrante == 4)) {

			ciudad.darDireccionVehiculo(Constantes.SUR);

		}

		if (ciudad.obtenerDireccionVehiculo().equalsIgnoreCase(Constantes.SUR) && (cuadrante == 1 || cuadrante == 2)) {

			ciudad.darDireccionVehiculo(Constantes.NORTE);

		}

		if (ciudad.obtenerDireccionVehiculo().equalsIgnoreCase(Constantes.ESTE) && (cuadrante == 2 || cuadrante == 4)) {

			ciudad.darDireccionVehiculo(Constantes.OESTE);

		}

		if (ciudad.obtenerDireccionVehiculo().equalsIgnoreCase(Constantes.OESTE)
				&& (cuadrante == 1 || cuadrante == 3)) {

			ciudad.darDireccionVehiculo(Constantes.ESTE);

		}

		String direccionVehiculo = ciudad.obtenerDireccionVehiculo();
		String direccionAux = "";

		nodo.darPadre(-1);

		nodo.darMovimiento(-1);

		nodo.darCalle(new Integer(calleAux));
		nodo.darCarrera(new Integer(carreraAux));

		nodo.darOrientacion(direccionVehiculo);

		arbol.add(nodo);

		caminoEjecucion.put((calleAux + "," + carreraAux + "," + ciudad.obtenerDireccionVehiculo()), "");

		mover = 0;
		girar = 0;

		calleActual = 0; 
		carreraActual = 0;
		
		while (!(laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META))) {

			// Mover vehículo.
			if ((!(laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)))) {

				if (direccionVehiculo.equalsIgnoreCase(Constantes.NORTE) && calleAux > 0 && calleAux <= 29
						&& (caminoEjecucion
								.containsKey(((calleAux - 1) + "," + carreraAux + "," + direccionVehiculo)) == false)
						&& (!(laCiudad[calleAux - 1][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_EDIFICIO)))) {

					calleActual = new Integer(calleAux);
					carreraActual = new Integer(carreraAux);

					calleAux = calleAux - 1;

					mover++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.SUR) && calleAux >= 0 && calleAux < 29
						&& (caminoEjecucion
								.containsKey(((calleAux + 1) + "," + carreraAux + "," + direccionVehiculo)) == false)
						&& (!(laCiudad[calleAux + 1][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_EDIFICIO)))) {

					calleActual = new Integer(calleAux);
					carreraActual = new Integer(carreraAux);

					calleAux = calleAux + 1;

					mover++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.ESTE) && carreraAux >= 0 && carreraAux < 29
						&& (caminoEjecucion
								.containsKey((calleAux + "," + (carreraAux + 1) + "," + direccionVehiculo)) == false)
						&& (!(laCiudad[calleAux][carreraAux + 1].equalsIgnoreCase(Constantes.SIMBOLO_EDIFICIO)))) {

					carreraActual = new Integer(carreraAux);

					calleActual = new Integer(calleAux);
					carreraAux = carreraAux + 1;

					mover++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.OESTE) && carreraAux > 0 && carreraAux <= 29
						&& (caminoEjecucion
								.containsKey((calleAux + "," + (carreraAux - 1) + "," + direccionVehiculo)) == false)
						&& (!(laCiudad[calleAux][carreraAux - 1].equalsIgnoreCase(Constantes.SIMBOLO_EDIFICIO)))) {

					carreraActual = new Integer(carreraAux);
					calleActual = new Integer(calleAux);

					carreraAux = carreraAux - 1;

					mover++;

				}

				if (mover > 0) {

					nodo = new Nodo();

					nodo.darPadre(padreAux);

					nodo.darMovimiento(0);

					nodo.darCalle(new Integer(calleAux));
					nodo.darCarrera(new Integer(carreraAux));

					nodo.darOrientacion(direccionVehiculo);

					arbol.add(nodo);

					caminoEjecucion.put((calleAux + "," + carreraAux + "," + direccionVehiculo), "");

					if (laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)) {

						nodoAnterior = arbol.size() - 1;

					}

					calleAux = calleActual;
					carreraAux = carreraActual;

				}

			}

			// Girar a la derecha el vehículo.
			if ((!(laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)))) {

				girar = 0;

				direccionAux = new String(direccionVehiculo);
				if (direccionVehiculo.equalsIgnoreCase(Constantes.NORTE)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.ESTE))))) {

					direccionVehiculo = Constantes.ESTE;
					girar++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.ESTE)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.SUR))))) {

					direccionVehiculo = Constantes.SUR;
					girar++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.SUR)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.OESTE))))) {

					direccionVehiculo = Constantes.OESTE;
					girar++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.OESTE)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.NORTE))))) {

					direccionVehiculo = Constantes.NORTE;
					girar++;

				}

				if (girar > 0) {

					nodo = new Nodo();

					nodo.darPadre(padreAux);

					nodo.darMovimiento(2);

					nodo.darCalle(calleAux);
					nodo.darCarrera(carreraAux);

					nodo.darOrientacion(direccionVehiculo);

					arbol.add(nodo);

					caminoEjecucion.put((calleAux + "," + carreraAux + "," + direccionVehiculo), "");

					direccionVehiculo = direccionAux;

					if (laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)) {

						nodoAnterior = arbol.size() - 1;

					}

				}

			}

			// Girar vehículo a la izquierda.
			if ((!(laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)))) {

				girar = 0;

				direccionAux = new String(direccionVehiculo);

				if (direccionVehiculo.equalsIgnoreCase(Constantes.NORTE)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.OESTE))))) {

					direccionVehiculo = Constantes.OESTE;
					girar++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.OESTE)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.SUR))))) {

					direccionVehiculo = Constantes.SUR;
					girar++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.SUR)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.ESTE))))) {

					direccionVehiculo = Constantes.ESTE;
					girar++;

				} else if (direccionVehiculo.equalsIgnoreCase(Constantes.ESTE)
						&& (!(caminoEjecucion.containsKey((calleAux + "," + carreraAux + "," + Constantes.NORTE))))) {

					direccionVehiculo = Constantes.NORTE;
					girar++;

				}

				if (girar > 0) {

					nodo = new Nodo();

					nodo.darPadre(padreAux);

					nodo.darMovimiento(1);

					nodo.darCalle(calleAux);
					nodo.darCarrera(carreraAux);

					nodo.darOrientacion(direccionVehiculo);

					arbol.add(nodo);

					caminoEjecucion.put((calleAux + "," + carreraAux + "," + direccionVehiculo), "");

					direccionVehiculo = direccionAux;

					if (laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)) {

						nodoAnterior = arbol.size() - 1;

					}

				}

			}

			if (mover == 0 && girar == 0
					&& (!(laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)) == false)) {

				JOptionPane.showMessageDialog(null, "No se puede encontrar un camino.");

			} else {

				mover = 0;
				girar = 0;

			}

			if (laCiudad[calleAux][carreraAux].equalsIgnoreCase(Constantes.SIMBOLO_META)) {

				nodoAnterior = arbol.size() - 1;

			}

			padreAux++;

			meta = 0;

			if (padreAux < arbol.size()) {

				calleAux = arbol.get(padreAux).obtenerCalle();
				carreraAux = arbol.get(padreAux).obtenerCarrera();

				direccionVehiculo = arbol.get(padreAux).obtenerOrientacion();

			} else {

				if (meta == 0) {

					JOptionPane.showMessageDialog(null, "No se puede encontrar un camino.");
					meta++;

					break;

				}

			}

		}

		if (nodoAnterior > 0) {

			String movimiento = "";

			while (nodoAnterior > 0) {

				movimiento = +arbol.get(nodoAnterior).obtenerAccion() + ",";
				nodoAnterior = arbol.get(nodoAnterior).obtenerPadre();

			}

			String[] movimientoAcutal = movimiento.split(",");
			movimiento = "";

			for (int i = movimientoAcutal.length - 1; i >= 0; i--) {

				movimiento += movimientoAcutal[i] + " ";

			}

			String[] moverVehiculo = movimiento.split(" ");

			for (int i = 0; i < moverVehiculo.length; i++) {

				camino.add(moverVehiculo[i]);

			}

		}

	}

}
