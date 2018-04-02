package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.Controlador;
import util.Constantes;

public class PanelPrincipal extends JFrame implements ActionListener {

	/**
	 * Serial usado para hacer persistir la aplicación.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia de la clase controlador para crear la relación entre la interfaz y
	 * la lógica.
	 */
	private Controlador controlador;

	/**
	 * Instancia de la ciudad para representarla en el frame principal.
	 */
	private PanelCiudad panelCiudad;

	/**
	 * La barra de menús que aparece en la parte superior.
	 */
	private JMenuBar menuBarra;

	/**
	 * Menú de opciones disponibles para manejar el juego.
	 */
	private JMenu menuOpciones;

	/**
	 * Opción que permite guardar la ciudad.
	 */
	private JMenuItem menuItemGuardar;

	/**
	 * Opción que permite cargar la ciudad.
	 */
	private JMenuItem menuItemCargar;

	/**
	 * Permite construir una nueva aplicación.
	 * 
	 * @param controlador
	 *            relaciona la interfaz y la lógica.
	 */
	public PanelPrincipal(Controlador controlador) {

		this.controlador = controlador;

		panelCiudad = new PanelCiudad(controlador);
		controlador.conectarCiudad(panelCiudad);

		inicializarComponentes();

	}

	/**
	 * Inicializar los componentes del frame principal.
	 */
	public void inicializarComponentes() {

		setTitle("Ciudad del caos");

		menuBarra = new JMenuBar();

		menuOpciones = new JMenu();
		menuOpciones.setText(Constantes.CIUDAD);
		menuOpciones.setActionCommand(Constantes.CIUDAD);

		menuItemGuardar = new JMenuItem();
		menuItemGuardar.setText(Constantes.GUARDAR);
		menuItemGuardar.setActionCommand(Constantes.GUARDAR);
		menuItemGuardar.addActionListener(this);

		menuItemCargar = new JMenuItem();
		menuItemCargar.setText(Constantes.CARGAR);
		menuItemCargar.setActionCommand(Constantes.CARGAR);
		menuItemCargar.addActionListener(this);

		menuOpciones.add(menuItemGuardar);
		menuOpciones.add(menuItemCargar);

		menuBarra.add(menuOpciones);

		setJMenuBar(menuBarra);

		add(panelCiudad);

		setSize(650, 650);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Ejecuta los eventos del menú.
	 */
	public void actionPerformed(ActionEvent evento) {

		String comando = evento.getActionCommand();

		if (evento.getActionCommand().equals(Constantes.GUARDAR)) {

			try {

				controlador.guardarCiudad();

			} catch (IOException ioException) {

				ioException.printStackTrace();

			}

		} else if (comando.equalsIgnoreCase(Constantes.CARGAR)) {

			try {

				this.controlador.cargarCiudad();

			} catch (FileNotFoundException notFoundException) {

				notFoundException.printStackTrace();

			} catch (ClassNotFoundException classNotFoundException) {

				classNotFoundException.printStackTrace();

			} catch (IOException ioException) {

				ioException.printStackTrace();

			}

		}

	}

	/**
	 * Ejecuta la aplicación.
	 * 
	 * @param args
	 *            parámetros de ser necesarios.
	 */
	public static void main(String args[]) {

		PanelPrincipal principal = new PanelPrincipal(new Controlador());
		principal.setVisible(true);

	}

}
