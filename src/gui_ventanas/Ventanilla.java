package gui_ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.PaqueteDatos;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Ventanilla extends JFrame implements Runnable, MouseListener  {

	private JPanel contentPane;
	private JButton btnLlamarSiguiente;
	private JButton btnRellamar;
	private JButton btnMarcarAusente;
	private JButton btnMarcarAtendido;
	private JTextField txtNroAtencion;
	private JLabel lblA;
	private JTextField txtNroVentanilla;
	private JPanel panel;
	private JComboBox cbTipo;
	private JTextField txtTipoAtencion;
	private JLabel lblNewLabel;
	private JLabel lblsistemaDesarrolladoPor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanilla frame = new Ventanilla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventanilla() {
		setTitle("Sistema de Colas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 421);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(SystemColor.controlHighlight);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.btnLlamarSiguiente = new JButton("<html><center>Llamar siguiente<br>ticket</center></html>");
		this.btnLlamarSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLlamarSiguiente(e);
			}
		});
		this.btnLlamarSiguiente.setForeground(Color.WHITE);
		this.btnLlamarSiguiente.setBackground(new Color(70, 130, 180));
		this.btnLlamarSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnLlamarSiguiente.setBounds(10, 68, 210, 60);
		this.contentPane.add(this.btnLlamarSiguiente);
		
		this.btnRellamar = new JButton("<html><center>Rellamar<br>ticket</center></html>");
		btnRellamar.setEnabled(false);
		this.btnRellamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRellamar(e);
			}
		});
		this.btnRellamar.setForeground(Color.DARK_GRAY);
		this.btnRellamar.setBackground(new Color(240, 230, 140));
		this.btnRellamar.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnRellamar.setBounds(233, 68, 210, 60);
		this.contentPane.add(this.btnRellamar);
		
		this.btnMarcarAusente = new JButton("<html><center>Marcar ticket<br>como ausente</center></html>");
		this.btnMarcarAusente.setEnabled(false);
		this.btnMarcarAusente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnMarcarAusente(e);
			}
		});
		this.btnMarcarAusente.setForeground(Color.WHITE);
		this.btnMarcarAusente.setBackground(new Color(220, 20, 60));
		this.btnMarcarAusente.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnMarcarAusente.setBounds(10, 139, 210, 60);
		this.contentPane.add(this.btnMarcarAusente);
		
		this.btnMarcarAtendido = new JButton("<html><center>Marcar ticket<br>como atendido</center></html>");
		this.btnMarcarAtendido.setEnabled(false);
		this.btnMarcarAtendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnMarcarAtendido(e);
			}
		});
		this.btnMarcarAtendido.setForeground(Color.WHITE);
		this.btnMarcarAtendido.setBackground(new Color(60, 179, 113));
		this.btnMarcarAtendido.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnMarcarAtendido.setBounds(233, 139, 210, 60);
		this.contentPane.add(this.btnMarcarAtendido);
		
		this.txtNroAtencion = new JTextField();
		this.txtNroAtencion.setForeground(new Color(220, 20, 60));
		this.txtNroAtencion.setFont(new Font("Tahoma", Font.BOLD, 25));
		this.txtNroAtencion.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtNroAtencion.setText("0");
		this.txtNroAtencion.setEditable(false);
		this.txtNroAtencion.setBounds(240, 269, 114, 84);
		this.contentPane.add(this.txtNroAtencion);
		this.txtNroAtencion.setColumns(10);
		
		this.lblA = new JLabel("TICKET EN ATENCI\u00D3N:");
		this.lblA.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblA.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblA.setBounds(99, 225, 247, 33);
		this.contentPane.add(this.lblA);
		
		this.panel = new JPanel();
		this.panel.setBackground(Color.DARK_GRAY);
		this.panel.setBounds(0, 0, 453, 57);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		this.cbTipo = new JComboBox();
		cbTipo.setEnabled(false);
		cbTipo.setForeground(new Color(220, 20, 60));
		this.cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un tipo", "VENTANILLA", "CAJA", "TURNO"}));
		this.cbTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.cbTipo.setBackground(SystemColor.control);
		this.cbTipo.setBounds(233, 11, 210, 36);
		this.panel.add(this.cbTipo);
		
		this.txtNroVentanilla = new JTextField();
		this.txtNroVentanilla.setBounds(10, 12, 210, 35);
		this.panel.add(this.txtNroVentanilla);
		this.txtNroVentanilla.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtNroVentanilla.setText("Ingrese su nro");
		this.txtNroVentanilla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNroVentanilla(e);
			}
		});
		this.txtNroVentanilla.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.txtNroVentanilla.setBackground(SystemColor.control);
		this.txtNroVentanilla.setForeground(new Color(220, 20, 60));
		this.txtNroVentanilla.setColumns(10);
		
		this.txtTipoAtencion = new JTextField();
		this.txtTipoAtencion.setText("0");
		this.txtTipoAtencion.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtTipoAtencion.setForeground(new Color(220, 20, 60));
		this.txtTipoAtencion.setFont(new Font("Tahoma", Font.BOLD, 25));
		this.txtTipoAtencion.setEditable(false);
		this.txtTipoAtencion.setColumns(10);
		this.txtTipoAtencion.setBounds(99, 269, 114, 84);
		this.contentPane.add(this.txtTipoAtencion);
		
		this.lblNewLabel = new JLabel("-");
		this.lblNewLabel.setForeground(new Color(220, 20, 60));
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel.setBounds(214, 303, 27, 14);
		this.contentPane.add(this.lblNewLabel);
		
		lblsistemaDesarrolladoPor = new JLabel("<html><center>Sistema desarrollado por BYTE X BYTE PER\u00DA E.I.R.L<br>Click para m\u00E1s informaci\u00F3n.</center></html>");
		lblsistemaDesarrolladoPor.addMouseListener(this);
		lblsistemaDesarrolladoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblsistemaDesarrolladoPor.setForeground(SystemColor.controlShadow);
		lblsistemaDesarrolladoPor.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblsistemaDesarrolladoPor.setBounds(10, 364, 433, 28);
		contentPane.add(lblsistemaDesarrolladoPor);
		cargar();
	}
	String ipPantalla = "192.168.70.100";
	//String ipPantalla = "192.168.1.46";
	String ipVentanilla = null;
	int tipo = -1;
	int nroVentanilla = -1;
	
	int puertoPantalla = 9000;
	int puertoCliente = 9001;
	int puertoVentanilla = 9002;
	
	public void cargar(){
		this.setLocationRelativeTo(null);
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			ipVentanilla = address.getHostAddress();
		} catch (UnknownHostException e) {
			//JOptionPane.showMessageDialog(null, "Error al cargar ip " + e.getMessage());
		}
		
		Thread mihilo = new Thread(this);
		mihilo.start();
		cbTipo.setSelectedIndex(3);
	}
	
	protected void keyTypedTxtNroVentanilla(KeyEvent e) {
		char c = e.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER))
			e.consume();
		if(txtNroVentanilla.getText().equals("Ingrese su nro"))
			txtNroVentanilla.setText(null);
	}
	
	public void ActivarLlamar(){
		btnLlamarSiguiente.setEnabled(true);
		btnRellamar.setEnabled(false);
		btnMarcarAusente.setEnabled(false);
		btnMarcarAtendido.setEnabled(false);
	}
	
	public void DesactivarLlamar(){
		btnLlamarSiguiente.setEnabled(false);
		btnRellamar.setEnabled(true);
		btnMarcarAusente.setEnabled(true);
		btnMarcarAtendido.setEnabled(true);
	}
	
	protected void actionPerformedBtnLlamarSiguiente(ActionEvent ex) {
		if(txtNroVentanilla.getText().equals("Ingrese su nro"))
			JOptionPane.showMessageDialog(null, "Por favor, ingrese su número de ventanilla.", "Alerta", JOptionPane.ERROR_MESSAGE);
		if(cbTipo.getSelectedIndex() == 0)
			JOptionPane.showMessageDialog(null, "Por favor, indique el tipo de ventanilla", "Alerta", JOptionPane.ERROR_MESSAGE);
		else{
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			if(nroVentanilla >= 30)
				JOptionPane.showMessageDialog(null, "No tiene permiso para crear mas de 30 módulos", "Alerta", JOptionPane.ERROR_MESSAGE);
			else{
			
				tipo = cbTipo.getSelectedIndex();
				nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
				
				try {
					Socket socketSolicitarTicket = new Socket(ipPantalla, puertoPantalla);			
					
					PaqueteDatos pd = new PaqueteDatos();
					pd.setComando(1); // ATENDIENDO
					pd.setIp(ipVentanilla);
					pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
					pd.setTipo(tipo);
					
					ObjectOutputStream oos_llamar_nticket = new ObjectOutputStream(socketSolicitarTicket.getOutputStream());
					oos_llamar_nticket.writeObject(pd);		
					oos_llamar_nticket.close();
					
				} catch (UnknownHostException e) {
					//JOptionPane.showMessageDialog(null, "Error al llamar al Siguiente " + e.getMessage());
				} catch (IOException e) {
					//JOptionPane.showMessageDialog(null, "Error al llamar al siguiente " + e.getMessage());
				}
			}
		}
	}
	
	protected void actionPerformedBtnRellamar(ActionEvent ex) {
		
		if(cbTipo.getSelectedIndex() == 0 || txtNroVentanilla.getText().equals("Ingrese nro"))
			JOptionPane.showMessageDialog(null, "Seleccione los datos correctamente", "Alerta", JOptionPane.ERROR_MESSAGE);
		else{
			tipo = cbTipo.getSelectedIndex();
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			
			int ticketactual = Integer.parseInt(txtNroAtencion.getText());
			try {
				Socket socketActualizarTicket = new Socket(ipPantalla, puertoPantalla);
				
				PaqueteDatos pd = new PaqueteDatos();
				pd.setComando(4); // RELLAMAR
				pd.setIp(ipVentanilla);
				pd.setTicket(ticketactual);
				pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
				pd.setTipo(tipo);
				
				ObjectOutputStream oos_indicar_ausente = new ObjectOutputStream(socketActualizarTicket.getOutputStream());
				oos_indicar_ausente.writeObject(pd);	 
				oos_indicar_ausente.close();
				
			} catch (UnknownHostException e) {
				//JOptionPane.showMessageDialog(null, "Error al Rellamar " + e.getMessage());
			} catch (IOException e) {
				//JOptionPane.showMessageDialog(null, "Error al rellamar " + e.getMessage());
			}
		}
	}
	
	protected void actionPerformedBtnMarcarAusente(ActionEvent ex) {
		
		if(cbTipo.getSelectedIndex() == 0 || txtNroVentanilla.getText().equals("Ingrese nro"))
			JOptionPane.showMessageDialog(null, "Seleccione los datos correctamente", "Alerta", JOptionPane.ERROR_MESSAGE);
		else{
			tipo = cbTipo.getSelectedIndex();
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			
			int ticketactual = Integer.parseInt(txtNroAtencion.getText());
			try {
				Socket socketActualizarTicket = new Socket(ipPantalla, puertoPantalla);
				
				PaqueteDatos pd = new PaqueteDatos();
				pd.setComando(2); // AUSENTE
				pd.setIp(ipVentanilla);
				pd.setTicket(ticketactual);
				pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
				pd.setTipo(tipo);
				
				ObjectOutputStream oos_indicar_ausente = new ObjectOutputStream(socketActualizarTicket.getOutputStream());
				oos_indicar_ausente.writeObject(pd);		 
				oos_indicar_ausente.close();
				ActivarLlamar();
				txtTipoAtencion.setText("");
				txtNroAtencion.setText("");
				
			} catch (UnknownHostException e) {
				//JOptionPane.showMessageDialog(null, "Error al Marcar como ausente " + e.getMessage());
			} catch (IOException e) {
				//JOptionPane.showMessageDialog(null, "Error al marcar como ausente" + e.getMessage());
			}
		}
	}
	
	protected void actionPerformedBtnMarcarAtendido(ActionEvent ex) {
		
		if(cbTipo.getSelectedIndex() == 0 || txtNroVentanilla.getText().equals("Ingrese nro"))
			JOptionPane.showMessageDialog(null, "Seleccione los datos correctamente", "Alerta", JOptionPane.ERROR_MESSAGE);
		else{
			tipo = cbTipo.getSelectedIndex();
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			
			int ticketactual = Integer.parseInt(txtNroAtencion.getText());
			try {
				Socket socketActualizarTicket = new Socket(ipPantalla, puertoPantalla);
				
				PaqueteDatos pd = new PaqueteDatos();
				pd.setComando(3); // ATENDIDO
				pd.setIp(ipVentanilla);
				pd.setTicket(ticketactual);
				pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
				pd.setTipo(tipo);
				
				ObjectOutputStream oos_indicar_atendido = new ObjectOutputStream(socketActualizarTicket.getOutputStream());
				oos_indicar_atendido.writeObject(pd);		 
				oos_indicar_atendido.close();
				ActivarLlamar();
				txtTipoAtencion.setText("");
				txtNroAtencion.setText("");
				
			} catch (UnknownHostException e) {
			//	JOptionPane.showMessageDialog(null, "Error al Marcar como atendido" + e.getMessage());
			} catch (IOException e) {
			//	JOptionPane.showMessageDialog(null, "Error al marcar como atendido" + e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		try {
			ServerSocket serverVentanilla = new ServerSocket(puertoVentanilla);
			
			while(true){
				Socket socketVentanilla = serverVentanilla.accept();
				DataInputStream dis_flujo_entrada = new DataInputStream(socketVentanilla.getInputStream());
				int ticket = dis_flujo_entrada.readInt();
				
				if(ticket == -1){
					txtTipoAtencion.setText("COLA");
					txtNroAtencion.setText("VACÍA");
				}
				else{
					switch (cbTipo.getSelectedIndex()) {
					case 1:
						txtTipoAtencion.setText("VE");
						break;
					case 2:
						txtTipoAtencion.setText("CA");
						break;
					case 3:
						txtTipoAtencion.setText("TU");
						break;
					default:
						break;
					}
					
					txtNroAtencion.setText(""+ticket);
					DesactivarLlamar();
				}
			}
		}
		catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al escuchar " + e.getMessage());
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblsistemaDesarrolladoPor) {
			mouseClickedLabel(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabel(MouseEvent arg0) {
		Creditos el = new Creditos();
		el.setLocationRelativeTo(null);
		el.setVisible(true);
	}
}
