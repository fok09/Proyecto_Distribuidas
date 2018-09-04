package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import app.SistemaCine;
import bean.ProductoView;
import bean.VentaView;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarVenta extends JFrame {

	private SistemaCine sisCin;
	private JPanel contentPane;
	private JTable tproductos;
	private DefaultTableModel modeloTabla;
	private Vector<Vector<String>> datosTabla;
	private RegistrarVenta autoRef;
	private VentaView venta;
	private Vector<String> columnNames;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVenta frame = new RegistrarVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	public RegistrarVenta()
	{
		iniciarRegistrarVenta();
	}
	
	public RegistrarVenta(SistemaCine sc)
	{
		sisCin = sc;
		autoRef = this;
		venta = sisCin.iniciarVenta();
		columnNames = new Vector<String>();
	    columnNames.addElement("Codigo");
	    columnNames.addElement("Descripcion");
	    columnNames.addElement("Cantidad");
	    datosTabla = new Vector<Vector<String>>();
		iniciarRegistrarVenta();
	}
	
	public void agregarItemVenta(ProductoView prod, int cantidad)
	{
		sisCin.agregarProducto(prod,cantidad);
		actualizarTabla();
	}
	
	public void actualizarTabla()
	{
		venta = sisCin.actualizarVistaVenta();
	//	System.out.println(venta.getItems().elementAt(0).);
		datosTabla = venta.getItems();
		modeloTabla.setDataVector(datosTabla, columnNames);
	}

	/**
	 * Create the frame.
	 */
	public void iniciarRegistrarVenta() {
		setTitle("Registrar Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(sisCin != null)
				{
					AgregarProducto agPr = new AgregarProducto(sisCin,autoRef);
					agPr.setVisible(true);
				}
			}
		});
		
		JButton btnRegistrarVenta = new JButton("Registrar Venta");
		btnRegistrarVenta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				float total = sisCin.registrarVenta();
				JOptionPane.showMessageDialog(null, total);
				VentanaInicial vi = new VentanaInicial();
				vi.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Cancelar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAgregarProducto)
							.addPreferredGap(ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
							.addComponent(btnRegistrarVenta)
							.addGap(18)
							.addComponent(btnNewButton))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregarProducto)
						.addComponent(btnNewButton)
						.addComponent(btnRegistrarVenta)))
		);
		
		tproductos = new JTable();
		scrollPane.setViewportView(tproductos);
		contentPane.setLayout(gl_contentPane);
		
		tproductos.setModel(new DefaultTableModel(datosTabla, columnNames));
		modeloTabla = (DefaultTableModel) tproductos.getModel();
		
	}
}
