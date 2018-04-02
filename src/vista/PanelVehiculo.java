package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controlador.Controlador;
import util.Constantes;

public class PanelVehiculo extends JDialog implements ActionListener {

	/**
	 * Serial usado para hacer persistir el panel vehículo.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Permite ejecutar las acciones asociadas al controlador.
	 */
	private Controlador controlador;

	/**
	 * Etiqueta para orientar el índice de la fila en donde se colocará el vehículo.
	 */
	private JLabel lblCalle;

	/**
	 * Etiqueta para orientar el índice de la columna en donde se colocara el
	 * vehiculo.
	 */
	private JLabel lblCarrera;

	/**
	 * Etiqueta para orientar la dirección del vehículo.
	 */
	private JLabel lblDireccionVehiculo;

	/**
	 * Etiqueta para orientar la región en donde va a buscar la meta en el eje x.
	 */
	private JLabel lblCalleMeta;

	/**
	 * Etiqueta para orientar la región en donde va a buscar la meta en el eje y.
	 */
	private JLabel lblCarreraMeta;

	/**
	 * Permite seleccionar la orientación del vehículo.
	 */
	private JComboBox<String> cmbDireccionVehiculo;

	/**
	 * Permite seleccionar la región de búsqueda en el eje x.
	 */
	private JComboBox<String> cmbRegionBusquedaX;

	/**
	 * Permite seleccionar la región de búsqueda en el eje y.
	 */
	private JComboBox<String> cmbRegionBusquedaY;

	/**
	 * Permite dar el índice de la fila donde se ubicará el vehículo.
	 */
	private JSpinner spnCalle;

	/**
	 * Permite dar el índice de la columna donde se ubicará el vehículo.
	 */
	private JSpinner spnCarrera;

	/**
	 * Da un modelo numérico para obtener el índice de la fila.
	 */
	private SpinnerNumberModel snmCalle;

	/**
	 * Da un modelo numérico para obtener el índice de la columna.
	 */
	private SpinnerNumberModel snmCarrera;

	/**
	 * Botón aceptar para establecer los datos dados.
	 */
	private JButton btnAceptar;

	/**
	 * Permite construir un nuevo panel.
	 * 
	 * @param controlador
	 *            relaciona el controlador a las acciones necesarias.
	 * @param calle
	 *            el índice de la fila en donde se colocará el vehículo.
	 * @param avenida
	 *            el índice de la columna en donde se colocara el vehículo.
	 */
	public PanelVehiculo(Controlador controlador, int calle, int avenida) {

		inicializarComponentes(controlador, calle, avenida);

	}

	/**
	 * Permite inicializar los componentes del panel.
	 * 
	 * @param controlador
	 *            relaciona el controlador a las acciones necesarias.
	 * @param calle
	 *            el indice de la fila en donde se colocora el vehiculo.
	 * @param avenida
	 *            el indice de la columna en donde se colocora el vehiculo.
	 */
	public void inicializarComponentes(Controlador controlador, int calle, int avenida) {

		setTitle("Dar datos");
		setLayout(new GridLayout(6, 2));

		this.controlador = controlador;

		lblCalle = new JLabel("Calle:");
		lblCarrera = new JLabel("Carrera:");

		lblDireccionVehiculo = new JLabel("Direccion vehiculo:");

		lblCalleMeta = new JLabel("Región de busqueda en x:");
		lblCarreraMeta = new JLabel("Región de busqueda en el eje y:");

		snmCalle = new SpinnerNumberModel(avenida, 0, 29, 1);
		snmCarrera = new SpinnerNumberModel(calle, 0, 29, 1);

		spnCalle = new JSpinner(snmCalle);
		spnCalle.setOpaque(true);
		spnCarrera = new JSpinner(snmCarrera);
		spnCarrera.setOpaque(true);

		cmbDireccionVehiculo = new JComboBox<String>();
		cmbRegionBusquedaY = new JComboBox<String>();
		cmbRegionBusquedaX = new JComboBox<String>();

		cmbDireccionVehiculo.addItem(Constantes.NORTE);
		cmbDireccionVehiculo.addItem(Constantes.SUR);
		cmbDireccionVehiculo.addItem(Constantes.ESTE);
		cmbDireccionVehiculo.addItem(Constantes.OESTE);

		cmbRegionBusquedaX.addItem(Constantes.ESTE);
		cmbRegionBusquedaX.addItem(Constantes.OESTE);

		cmbRegionBusquedaY.addItem(Constantes.NORTE);
		cmbRegionBusquedaY.addItem(Constantes.SUR);

		btnAceptar = new JButton(Constantes.ACEPTAR);
		btnAceptar.setActionCommand(Constantes.ACEPTAR);
		btnAceptar.addActionListener(this);

		add(lblCalle);
		add(spnCalle);

		add(lblCarrera);
		add(spnCarrera);

		add(lblDireccionVehiculo);
		add(cmbDireccionVehiculo);

		add(lblCalleMeta);
		add(cmbRegionBusquedaX);

		add(lblCarreraMeta);
		add(cmbRegionBusquedaY);

		add(btnAceptar);

		pack();
		setResizable(false);
		setModal(true);

	}

	/**
	 * Permite obtener el índice de la fila donde se ubicó el vehículo.
	 * 
	 * @return el índice de la fila que se estableció.
	 */
	public int obtenerCalle() {

		return snmCalle.getNumber().intValue();

	}

	/**
	 * Permite obtener el índice de la columna donde se ubicó el vehículo.
	 * 
	 * @return el índice de la columna que se estableció.
	 */
	public int ObtenerCarrera() {

		return snmCarrera.getNumber().intValue();

	}

	/**
	 * Permite obtener la dirección inicial del vehículo.
	 * 
	 * @return la dirección inicial del vehículo.
	 */
	public String obtenerDireccion() {

		return cmbDireccionVehiculo.getSelectedItem().toString();

	}

	/**
	 * Permite obtener la dirección en el eje x del cuadrante a buscar.
	 * 
	 * @return la dirección de la búsqueda en el eje x.
	 */
	public String obtenerCuadranteBusquedaX() {

		return cmbRegionBusquedaX.getSelectedItem().toString();

	}

	/**
	 * Permite obtener la dirección en el eje y del cuadrante a buscar
	 * 
	 * @return la dirección de la búsqueda en el eje y.
	 */
	public String obtenerCuadranteBusquedaY() {

		return cmbRegionBusquedaY.getSelectedItem().toString();

	}

	/**
	 * Permite ejecutar las acciones del botón.
	 */
	public void actionPerformed(ActionEvent evento) {

		String comando = evento.getActionCommand();

		if (comando.equalsIgnoreCase(Constantes.ACEPTAR)) {

			controlador.ponerVehiculo(obtenerCalle(), ObtenerCarrera(), obtenerDireccion(), obtenerCuadranteBusquedaY(),
					obtenerCuadranteBusquedaX());

			dispose();

		}

	}

}
