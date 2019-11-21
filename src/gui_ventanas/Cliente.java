package gui_ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Control;
import clases.PaqueteDatos;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class Cliente extends JFrame implements Runnable, MouseListener, ActionListener, WindowListener {

	private JPanel contentPane;
	private JButton btnSolicitarTicketVentanilla;
	private JLabel lblLogo;
	private JLabel lblTitulo;
	private JLabel lblInformacion;
	private JButton btnSolicitarTicketCaja;
	private JTextField textField;
	private JPanel panelTitulo;
	private JButton btnTurno;
	private JLabel lblsistemaDesarrolladoPor;
	private JButton btnCerrar;
	
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
		addWindowListener(this);
		
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
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowClosingThis(arg0);
		}
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
	}
	protected void windowClosingThis(WindowEvent arg0) {
		 new Control().cerrarApp();
	}
	
	
	String ipPantalla = "192.168.70.100";
	//String ipPantalla = "192.168.1.46";
	String ipCliente = null;
	
	int puertoPantalla = 9000;
	int puertoCliente = 9001;
	int puertoVentanilla = 9002;
	
	private void cargar(){
        if( new Control().comprobar() ){
        	int confirma = ComprobarConexion();
        	if(confirma == 0){
        		JOptionPane.showMessageDialog(null, "Por favor verifique su conexión", "Alerta", JOptionPane.ERROR_MESSAGE);
        		new Control().cerrarApp();
        		System.exit(0);
        	}
        	else{
				InetAddress address;
				try {
					address = InetAddress.getLocalHost();
					ipCliente = address.getHostAddress();
				} catch (UnknownHostException e) {
					RegistrarError("Error al cargar IP: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
				}
				Thread mihilo = new Thread(this);
				mihilo.start();
        	}
        }        
        else{
        	new Control().cerrarApp();
            System.exit(0);
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
				socket_recibir_nticket.close();
			}
		} catch (Exception e) {
			RegistrarError("Error en run: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		}
	}
	
	public int ComprobarConexion(){
		int confirma;
        try {
            URL ruta=new URL("http://www.google.com");
            URLConnection rutaC=ruta.openConnection();
            rutaC.connect();
            confirma = 1;
           }catch(Exception e){
        	   confirma = 0;
           }		
		return confirma;
	}

	public static String ObtenerFechaHora(){
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fechahora = hourdateFormat.format(date);
		return fechahora;
	}
	
	public static void RegistrarError(String errorMsj) {
		File directorio=new File("C:\\LogErrores_SistemaColas"); 
		directorio.mkdirs(); 
		String nombreArchivo= "C:\\LogErrores_SistemaColas\\log.txt";
		
		BufferedWriter bw = null;
	    FileWriter fw = null;
        File file = new File(nombreArchivo);
        try {
	        if (!file.exists())
				file.createNewFile();
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(errorMsj);
        } catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar error1: " + ObtenerFechaHora() + " " + e.getMessage());
		}
        finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
            	JOptionPane.showMessageDialog(null, "Error al registrar error2: " + ObtenerFechaHora() + " " + ex.getMessage());
            }
        }
	}	

	protected void actionPerformedBtnSolicitarTicket(ActionEvent arg0) {
		try {
			Socket socketSolicitarTicket = new Socket(ipPantalla, puertoPantalla);
			
			PaqueteDatos pd = new PaqueteDatos();
			pd.setComando(10); // 10 VENTANILLA
			pd.setIp(ipCliente);
			
			ObjectOutputStream oos_llamar_nticket = new ObjectOutputStream(socketSolicitarTicket.getOutputStream());
			oos_llamar_nticket.writeObject(pd);
			socketSolicitarTicket.close();
			oos_llamar_nticket.close();
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Ventanilla1 " + e.getMessage());
			RegistrarError("Error al solicitar Ticket Ventanilla1: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Ventanilla2 " + e.getMessage());
			RegistrarError("Error al solicitar Ticket Ventanilla2: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
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
			socketSolicitarTicket.close();
			oos_llamar_nticket.close();
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Caja1 " + e.getMessage());
			RegistrarError("Error al solicitar Ticket Caja1: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Caja2 " + e.getMessage());
			RegistrarError("Error al solicitar Ticket Caja2: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
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
			socketSolicitarTicket.close();
			oos_llamar_nticket.close();
		
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Turno1 " + e.getMessage());
			RegistrarError("Error al solicitar Ticket Turno1: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al solicitar Ticket Turno2 " + e.getMessage());
			RegistrarError("Error al solicitar Ticket Turno2: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
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
			
			Map<String, Object> parameters = new HashMap();
			parameters.put("prtNTicket", nticket);
			parameters.put("prtTipo", tipoNombre);
			try{
				JasperPrint impressao = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("rTicket.jasper"), parameters, new JREmptyDataSource());
				JasperPrintManager.printReport(impressao, false);
			}
			catch (JRException ex){
				JOptionPane.showMessageDialog(null, "Error iReport: " + ex.getMessage() );
				RegistrarError("Error iReport: " + ObtenerFechaHora() + " " + ex.getMessage() + "\n");
			}
			
			JOptionPane.showMessageDialog(null, "\nNRO ATENCIÓN:   " + tipoNombre + " - " + nticket + "\n\nSi no se imprimió su ticket, por favor llame a un encargado", "Información", JOptionPane.INFORMATION_MESSAGE);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al imprimir "+ e.getMessage());
			RegistrarError("Error al imprimir: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		}	
	}
	
	
	int nro = -1;
	
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		nro = -1;
		this.setEnabled(false);
		numeros n = new numeros(this);
		n.setVisible(true);
		n.setAlwaysOnTop(true);	
		n.setLocationRelativeTo(null);
	}
	
	public void verificarPass(){
		if(nro == 2244){
			new Control().cerrarApp();
			System.exit(0);
			
		}
	}
}
