package gui_ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.util.HSSFColor.BLACK;

import clases.PaqueteDatos;
import mysql.MySQLConexion;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Cliente extends JFrame implements Runnable, MouseListener, ActionListener {

	private JPanel contentPane;
	private JButton btnSolicitarTicketVentanilla;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente() {
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int anchoventana = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int altoventana = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        
        anchoventana = 1024;
        altoventana = 768;

		int anchoboton = 600;
		int altoboton = 150;
		
        setUndecorated(true);
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, anchoventana, altoventana);
		
		this.contentPane = new JPanel();
		this.contentPane.setBackground(SystemColor.control);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(25, 10, 284, 177);
		contentPane.add(lblLogo);
		
		int informacioX = altoventana/2 - altoboton;
		this.lblInformacion = new JLabel("Presione un bot\u00F3n para obtener ticket de atenci\u00F3n.");
		this.lblInformacion.setForeground(new Color(30, 144, 255));
		this.lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblInformacion.setBounds(-5, 206, anchoventana, 109);
		this.contentPane.add(this.lblInformacion);

		this.panelTitulo = new JPanel();
		this.panelTitulo.setBackground(Color.DARK_GRAY);
		this.panelTitulo.setBounds(-5, -5, 1029, 200);
		this.contentPane.add(this.panelTitulo);
		panelTitulo.setLayout(null);
		
		btnCerrar = new JButton("X");
		btnCerrar.addActionListener(this);
		btnCerrar.setBackground(new Color(220, 20, 60));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBounds(964, 11, 55, 23);
		panelTitulo.add(btnCerrar);
		
		this.lblTitulo = new JLabel("<html><center>GERENCIA REGIONAL DE TRANSPORTES <br>Y COMUNICACIONES - AREQUIPA</center></html>");
		lblTitulo.setBounds(336, 59, 672, 74);
		panelTitulo.add(lblTitulo);
		this.lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblTitulo.setForeground(Color.WHITE);
		this.lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		
		int xbotonV = (anchoventana/2) - (anchoboton/2);
		int ybotonV = (altoventana/2) - (altoboton/2);
		this.btnSolicitarTicketVentanilla = new JButton("VENTANILLA");
		this.btnSolicitarTicketVentanilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnSolicitarTicket(arg0);
			}
		});
		this.btnSolicitarTicketVentanilla.setForeground(new Color(255, 255, 255));
		this.btnSolicitarTicketVentanilla.setBackground(new Color(30, 144, 255));
		this.btnSolicitarTicketVentanilla.setFont(new Font("Tahoma", Font.BOLD, 40));
		this.btnSolicitarTicketVentanilla.setBounds(257, 583, 500, 100);
		this.contentPane.add(this.btnSolicitarTicketVentanilla);
		

		int xbotonC = (anchoventana/2) - (anchoboton/2);
		int ybotonC = (altoventana/2) - (altoboton/2) + altoboton + 25;
		this.btnSolicitarTicketCaja = new JButton("CAJA");
		this.btnSolicitarTicketCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnSolicitarTicketCaja(arg0);
			}
		});
		this.btnSolicitarTicketCaja.setForeground(new Color(255, 255, 255));
		this.btnSolicitarTicketCaja.setFont(new Font("Tahoma", Font.BOLD, 40));
		this.btnSolicitarTicketCaja.setBackground(new Color(30, 144, 255));
		this.btnSolicitarTicketCaja.setBounds(256, 444, 500, 100);
		this.contentPane.add(this.btnSolicitarTicketCaja);
		
		this.textField = new JTextField();
		this.textField.setBounds(0, altoventana-10, anchoventana, 10);
		this.contentPane.add(this.textField);
		this.textField.setColumns(10);
		
		this.btnTurno = new JButton("TURNOS");
		this.btnTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnTurno(arg0);
			}
		});
		this.btnTurno.setForeground(Color.WHITE);
		this.btnTurno.setFont(new Font("Tahoma", Font.BOLD, 40));
		this.btnTurno.setBackground(new Color(30, 144, 255));
		this.btnTurno.setBounds(257, 309, 500, 100);
		this.contentPane.add(this.btnTurno);
		
		lblsistemaDesarrolladoPor = new JLabel("<html><center>Sistema desarrollado por BYTE X BYTE PER\u00DA E.I.R.L<br>Toque para m\u00E1s informaci\u00F3n.</center></html>");
		lblsistemaDesarrolladoPor.addMouseListener(this);
		lblsistemaDesarrolladoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblsistemaDesarrolladoPor.setForeground(SystemColor.controlShadow);
		lblsistemaDesarrolladoPor.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblsistemaDesarrolladoPor.setBounds(208, 717, 597, 30);
		contentPane.add(lblsistemaDesarrolladoPor);
		
		
		
		cargar();
	}
	
	//String ipPantalla = "192.168.70.100";
	String ipPantalla = "192.168.0.200";
	String ipCliente = null;
	
	int puertoPantalla = 9000;
	int puertoCliente = 9001;
	int puertoVentanilla = 9002;
	private JLabel lblTitulo;
	private JLabel lblInformacion;
	private JButton btnSolicitarTicketCaja;
	private JTextField textField;
	private JPanel panelTitulo;
	private JButton btnTurno;
	private JLabel lblsistemaDesarrolladoPor;
	private JButton btnCerrar;
	
	private void cargar(){
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			ipCliente = address.getHostAddress();
			//System.out.println("IP Local :"+address.getHostAddress());
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar " + e.getMessage());
		}
		
		
		Thread mihilo = new Thread(this);
		mihilo.start();
	}

	protected void actionPerformedBtnSolicitarTicket(ActionEvent arg0) {
		try {
			Socket socketSolicitarTicket = new Socket(ipPantalla, puertoPantalla);
			
			PaqueteDatos pd = new PaqueteDatos();
			pd.setComando(10); // 10 VENTANILLA
			pd.setIp(ipCliente);
			
			ObjectOutputStream oos_llamar_nticket = new ObjectOutputStream(socketSolicitarTicket.getOutputStream());
			oos_llamar_nticket.writeObject(pd);
			oos_llamar_nticket.close();
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar ticket " + e.getMessage());
		}
	}

	protected void actionPerformedBtnSolicitarTicketCaja(ActionEvent arg0) {
		try {
			Socket socketSolicitarTicket = new Socket(ipPantalla, puertoPantalla);
			
			PaqueteDatos pd = new PaqueteDatos();
			pd.setComando(11); // 11 CAJA
			pd.setIp(ipCliente);
			
			ObjectOutputStream oos_llamar_nticket = new ObjectOutputStream(socketSolicitarTicket.getOutputStream());
			oos_llamar_nticket.writeObject(pd);	
			oos_llamar_nticket.close();
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Caja " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket caja" + e.getMessage());
		}	
	}
	
	protected void actionPerformedBtnTurno(ActionEvent arg0) {
		try {
			Socket socketSolicitarTicket = new Socket(ipPantalla, puertoPantalla);
			
			PaqueteDatos pd = new PaqueteDatos();
			pd.setComando(12); // 12 TURNO
			pd.setIp(ipCliente);
			
			ObjectOutputStream oos_llamar_nticket = new ObjectOutputStream(socketSolicitarTicket.getOutputStream());
			oos_llamar_nticket.writeObject(pd);	
			oos_llamar_nticket.close();
		
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Turno " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket turno " + e.getMessage());
		}	
	}

	@Override
	public void run() {
		try{
			ServerSocket server_Cliente = new ServerSocket(puertoCliente);
			Socket socket_recibir_nticket;
			int nticket;
			int tipo;
			while(true){
				socket_recibir_nticket = server_Cliente.accept();
				PaqueteDatos pd_recibido = new PaqueteDatos();
				ObjectInputStream ois_recibir = new ObjectInputStream(socket_recibir_nticket.getInputStream());
				pd_recibido = (PaqueteDatos) ois_recibir.readObject();
				
				nticket = pd_recibido.getTicket();
				tipo = pd_recibido.getTipo();
				
				ImprimirTicket(nticket, tipo);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener Nro ticket " + e.getMessage());
		}
	}
	
	public void ImprimirTicket(int nticket, int tipo){
		try {
			String tipoNombre = null;
			
			switch (tipo) {
			case 1:
				tipoNombre = "VE";
				break;
			case 2:
				tipoNombre = "CA";
				break;
			case 3:
				tipoNombre = "TU";
				break;
			default:
				break;
			}
			
			Connection con = null;
			Map<String, Object> parameters = new HashMap();
			parameters.put("prtNTicket", nticket);
			parameters.put("prtTipo", tipoNombre);
			try{
				JasperPrint impressao = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("rTicket.jasper"), parameters, new JREmptyDataSource());
				JasperPrintManager.printReport(impressao, false);
			}
			catch (JRException ex){
				JOptionPane.showMessageDialog(null, "Error iReport: " + ex.getMessage() );
			}
			JOptionPane.showMessageDialog(null, "\nNRO ATENCIÓN:   " + tipoNombre + " - " + nticket + "\n \nSi la máquina no imprimió su ticket, por favor llame a un encargado", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR2 "+ e.getMessage());
		}	
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblsistemaDesarrolladoPor) {
			mouseClickedLabel(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLabel(MouseEvent e) {
		Creditos el = new Creditos();
		el.setLocationRelativeTo(null);
		el.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		String pass = JOptionPane.showInputDialog(null, "Ingrese contraseña", null, JOptionPane.INFORMATION_MESSAGE);
		if(pass.equals("grtc"))
			System.exit(0);
		
	}
}
