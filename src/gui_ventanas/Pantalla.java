package gui_ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.PaqueteDatos;
import javazoom.jl.player.Player;
import mysql.Consultas;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import javax.swing.JTextArea;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

public class Pantalla extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField txtCola1;
	private JTextField txtCola2;
	private JTextField txtCola3;
	private JTextField txtCola4;
	private JLabel lblNewLabel;
	private JTextField txtCola5;
	private JTextField txtCola6;
	private JTextField txtCola7;
	private JTextField txtCola8;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
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
	public Pantalla() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int anchoventana = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int altoventana = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        //JOptionPane.showMessageDialog(null, anchoventana + " * " + altoventana);
		
        //anchoventana = 1360;
        //altoventana = 768;
        
        setUndecorated(true);
		setResizable(false);
		
		setBounds(0, ((altoventana/4)*3), anchoventana, ((altoventana/4)*3));
		
		this.contentPane = new JPanel();
		this.contentPane.setBackground(SystemColor.textInactiveText);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		int anchoColas = anchoventana/4;
		int altoColas = altoventana/8;
		
		this.txtCola1 = new JTextField();
		this.txtCola1.setText(" ");
		this.txtCola1.setEditable(false);
		this.txtCola1.setForeground(Color.BLACK);
		this.txtCola1.setBackground(SystemColor.controlHighlight);
		this.txtCola1.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola1.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola1.setBounds(0, 0, anchoColas, altoColas);
		this.contentPane.add(this.txtCola1);
		this.txtCola1.setColumns(10);
		
		this.txtCola2 = new JTextField();
		this.txtCola2.setText(" ");
		this.txtCola2.setEditable(false);
		this.txtCola2.setForeground(Color.BLACK);
		this.txtCola2.setBackground(SystemColor.controlHighlight);
		this.txtCola2.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola2.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola2.setBounds(anchoColas, 0, anchoColas, altoColas);
		this.contentPane.add(this.txtCola2);
		this.txtCola2.setColumns(10);
		
		this.txtCola3 = new JTextField();
		this.txtCola3.setText(" ");
		this.txtCola3.setEditable(false);
		this.txtCola3.setForeground(Color.BLACK);
		this.txtCola3.setBackground(SystemColor.controlHighlight);
		this.txtCola3.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola3.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola3.setBounds(anchoColas*2, 0, anchoColas, altoColas);
		this.contentPane.add(this.txtCola3);
		this.txtCola3.setColumns(10);
		
		this.txtCola4 = new JTextField();
		this.txtCola4.setText(" ");
		this.txtCola4.setEditable(false);
		this.txtCola4.setForeground(Color.BLACK);
		this.txtCola4.setBackground(SystemColor.controlHighlight);
		this.txtCola4.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola4.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola4.setBounds(anchoColas*3, 0, anchoColas, altoColas);
		this.contentPane.add(this.txtCola4);
		this.txtCola4.setColumns(10);
		
		this.txtCola5 = new JTextField();
		this.txtCola5.setText(" ");
		this.txtCola5.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola5.setForeground(Color.BLACK);
		this.txtCola5.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola5.setEditable(false);
		this.txtCola5.setColumns(10);
		this.txtCola5.setBackground(SystemColor.controlHighlight);
		this.txtCola5.setBounds(0, altoColas, anchoColas, altoColas);
		this.contentPane.add(this.txtCola5);
		
		this.txtCola6 = new JTextField();
		this.txtCola6.setText(" ");
		this.txtCola6.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola6.setForeground(Color.BLACK);
		this.txtCola6.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola6.setEditable(false);
		this.txtCola6.setColumns(10);
		this.txtCola6.setBackground(SystemColor.controlHighlight);
		this.txtCola6.setBounds(anchoColas, altoColas, anchoColas, altoColas);
		this.contentPane.add(this.txtCola6);
		
		this.txtCola7 = new JTextField();
		this.txtCola7.setText(" ");
		this.txtCola7.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola7.setForeground(Color.BLACK);
		this.txtCola7.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola7.setEditable(false);
		this.txtCola7.setColumns(10);
		this.txtCola7.setBackground(SystemColor.controlHighlight);
		this.txtCola7.setBounds(anchoColas*2, altoColas, anchoColas, altoColas);
		this.contentPane.add(this.txtCola7);
		
		this.txtCola8 = new JTextField();
		this.txtCola8.setText(" ");
		this.txtCola8.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCola8.setForeground(Color.BLACK);
		this.txtCola8.setFont(new Font("Dialog", Font.BOLD, 40));
		this.txtCola8.setEditable(false);
		this.txtCola8.setColumns(10);
		this.txtCola8.setBackground(SystemColor.controlHighlight);
		this.txtCola8.setBounds(anchoColas*3, altoColas, anchoColas, altoColas);
		this.contentPane.add(this.txtCola8);
		
		cargar();
	}
	
	String ipPantalla = null;
	String ipRecibida = null;;
	
	int puertoPantalla = 9000;
	int puertoCliente = 9001;
	int puertoVentanilla = 9002;
	
	int ordenCuadros = 1;
	
	
	
	public void cargar(){
		InetAddress address;
		Consultas consultas = new Consultas();
		consultas.iniciar();
		try {
			address = InetAddress.getLocalHost();
			ipPantalla = address.getHostAddress();
			//System.out.println("IP Local :"+address.getHostAddress());
		} catch (UnknownHostException e) {
			consultas.RegistrarError("Error al cargar ip " + e.getMessage());
		}
		
		CargarAtenciones();
		
		Thread mihilo = new Thread(this);
		mihilo.start();	
		

		try {
			Runtime.getRuntime().exec("C:\\ReproductorVideo\\Video.exe", null);
		} catch (IOException e) {
			consultas.RegistrarError("Error al cargar el reproductor " + e.getMessage());
		}
		this.setAlwaysOnTop(true);	
		consultas.reset();
	}
	
	public void CargarAtenciones(){
		Consultas consulta = new Consultas();
		consulta.iniciar();
		ResultSet rs = consulta.ObtenerUltimaPantallaTurnos();
		try {
			rs.last();
			ImprimirMensajeEnPantalla(rs.getInt("turno"), rs.getInt("ventanilla"), rs.getInt("tipo"));
			while(rs.previous()){
				ImprimirMensajeEnPantalla(rs.getInt("turno"), rs.getInt("ventanilla"), rs.getInt("tipo"));
			}
		} catch (SQLException e) {
			consulta.RegistrarError("Error al cargar Atenciones " + e.getMessage());
		}
		try {
			rs.close();
			consulta.reset();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Consultas consultas = new Consultas();
		consultas.iniciar();
			
		try {
			ServerSocket serverPantalla = new ServerSocket(puertoPantalla);

			while(true){
				Socket socketPantalla = serverPantalla.accept();
				
				int comando = -1;
				PaqueteDatos pd_recibido = new PaqueteDatos();
				
				ObjectInputStream ois_paquete_datos = new ObjectInputStream(socketPantalla.getInputStream());
				pd_recibido = (PaqueteDatos) ois_paquete_datos.readObject();
				
				comando = pd_recibido.getComando();
				ipRecibida = pd_recibido.getIp();
				
				if(comando == 10){ // VIENE DE CLIENTE - SOLICITA NRO TICKET PARA VENTANILLA
					int nticketnew = ObtenerUltNroTicket(1) + 1;
					RegistrarAtencion(nticketnew, 1); //VENTANILLA 1
					
					PaqueteDatos pd_enviar = new PaqueteDatos();
					pd_enviar.setTicket(nticketnew);
					pd_enviar.setTipo(1);
					
					Socket socketEnviarNticket = new Socket(ipRecibida, puertoCliente);
					ObjectOutputStream oos_enviar_nticket = new ObjectOutputStream(socketEnviarNticket.getOutputStream());
					oos_enviar_nticket.writeObject(pd_enviar);
					//txtCola.append("Ticket n° " + nticketnew + "\n");
					
					oos_enviar_nticket.close();
					socketEnviarNticket.close();
				}
				
				if(comando == 11){ // VIENE DE CLIENTE - SOLICITA NRO TICKET PARA CAJA
					int nticketnew = ObtenerUltNroTicket(2) + 1;
					RegistrarAtencion(nticketnew, 2); //CAJA 2
					
					PaqueteDatos pd_enviar = new PaqueteDatos();
					pd_enviar.setTicket(nticketnew);
					pd_enviar.setTipo(2);
					
					Socket socketEnviarNticket = new Socket(ipRecibida, puertoCliente);
					ObjectOutputStream oos_enviar_nticket = new ObjectOutputStream(socketEnviarNticket.getOutputStream());
					oos_enviar_nticket.writeObject(pd_enviar);
					//txtCola.append("Turno n° " + nticketnew + "\n");
					
					oos_enviar_nticket.close();
					socketEnviarNticket.close();
				}
				
				if(comando == 12){ // VIENE DE CLIENTE - SOLICITA NRO TICKET PARA TURNO
					int nticketnew = ObtenerUltNroTicket(3) + 1; //TURNO 3
					RegistrarAtencion(nticketnew, 3); //TURNO 3
					
					PaqueteDatos pd_enviar = new PaqueteDatos();
					pd_enviar.setTicket(nticketnew);
					pd_enviar.setTipo(3); //TURNO 3
					
					Socket socketEnviarNticket = new Socket(ipRecibida, puertoCliente);
					ObjectOutputStream oos_enviar_nticket = new ObjectOutputStream(socketEnviarNticket.getOutputStream());
					oos_enviar_nticket.writeObject(pd_enviar);
					//txtCola.append("Turno n° " + nticketnew + "\n");
					
					oos_enviar_nticket.close();
					socketEnviarNticket.close();
				}
				
				if(comando == 0){ // VIENE DE VENTANILLA - Registrar
					int nventanilla = pd_recibido.getVentanilla();
					int tipo = pd_recibido.getTipo();
					RegistrarVentanilla(ipRecibida, tipo, nventanilla);
				}
				
				if(comando == 1){ // VIENE DE VENTANILLA - SOLICITA NRO TICKET
					int tipo = pd_recibido.getTipo();
					int nticketprox = ObtenerTicketProximo(tipo);
					if(nticketprox != -1){
						int ventanilla = pd_recibido.getVentanilla();
						ActualizarEstadoTicket(nticketprox, 1, ventanilla, tipo); // 1 = ATENDIENDO
						ImprimirMensajeEnPantalla(nticketprox, ventanilla, tipo);
					}
					Socket socketEnviarNticket = new Socket(ipRecibida, 9002);
					DataOutputStream dos_enviar_nticket = new DataOutputStream(socketEnviarNticket.getOutputStream());
					dos_enviar_nticket.writeInt(nticketprox);
					//txtCola.append("Ticket n° " + nticketprox + "\n");
					
					if(nticketprox != -1)
						ReproducirAlerta();
					
					dos_enviar_nticket.close();
					socketEnviarNticket.close();					
				}
				
				if(comando == 2){ // VIENE DE VENTANILLA - INDICA QUE ESTÁ AUSENTE
					int tipo = pd_recibido.getTipo();
					int ticket_ausente = pd_recibido.getTicket();
					int ventanilla = pd_recibido.getVentanilla();
					ActualizarEstadoTicket(ticket_ausente, 2, ventanilla, tipo); // 2 = AUSENTE
				}
				
				if(comando == 3){ // VIENE DE VENTANILLA - INDICA QUE SE ATENDIÓ
					int tipo = pd_recibido.getTipo();
					int ticket_atendido = pd_recibido.getTicket();
					int ventanilla = pd_recibido.getVentanilla();
					ActualizarEstadoTicket(ticket_atendido, 3, ventanilla, tipo); // 3 = ATENDIDO					
				}
				
				if(comando == 4){ // VIENE DE VENTANILLA - RELLAMAR
					int tipo = pd_recibido.getTipo();
					int ticket_atendido = pd_recibido.getTicket();
					int ventanilla = pd_recibido.getVentanilla();
					ImprimirMensajeEnPantalla(ticket_atendido, ventanilla, tipo);	
					ReproducirAlerta();
				}
				
				socketPantalla.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			consultas.RegistrarError("Error al escuchar " + e.getMessage());
		}
		consultas.reset();
	}
	
	public int ObtenerUltNroTicket(int tipo){
		ResultSet rs = null;
		Consultas consulta = new Consultas();
		consulta.iniciar();
		rs = consulta.ObtenerUltNroTicketHoy(tipo);
		int ultnroticket = -1;
		int newnroticket = 0;
		try {
			rs.next();
			ultnroticket = rs.getInt("turno");
			newnroticket = ultnroticket;
		} catch (Exception e) {
			consulta.RegistrarError("No existe ningun ticket registrado, este será el primero. Para ultnroTicket" + e.getMessage());
		}
		try {
			rs.close();
			consulta.reset();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newnroticket;
	}
	
	public int ObtenerTicketProximo(int tipo){
		ResultSet rs = null;
		Consultas consulta = new Consultas();
		consulta.iniciar();
		rs = consulta.ObtenerTicketProximo(tipo);
		int nticketprox = -1;
		try {
			rs.next();
			nticketprox = rs.getInt("turno");
			//JOptionPane.showMessageDialog(null, "Ultimo ingresado: " + ultnroticket);
		} catch (Exception e) {
			consulta.RegistrarError("No existe ninguna ticket registrado, este será el primero. Para TicketProximo " + e.getMessage());
		}
		try {
			rs.close();
			consulta.reset();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nticketprox;
	}
	
	public void RegistrarAtencion(int nroticket, int tipo){
		Consultas consulta = new Consultas();
		consulta.iniciar();
		consulta.RegistrarAtencion(nroticket, tipo);
		consulta.reset();
	}
	
	public void ActualizarEstadoTicket(int nticketprox, int estado, int ventanilla, int tipo){
		Consultas consulta = new Consultas();
		consulta.iniciar();
		consulta.ActualizarEstadoTicket(nticketprox, estado, ventanilla, tipo);
		consulta.reset();
	}
	
	public void RegistrarVentanilla(String ipRecibida, int tipo, int nventanilla){
		Consultas consulta = new Consultas();
		consulta.iniciar();
		RegistrarVentanilla(ipRecibida, tipo, nventanilla);
		consulta.reset();
	}
	
	public void ImprimirMensajeEnPantalla(int nticketprox, int ventanilla, int tipo){
		String tipoVentanilla = "";
		switch (tipo) {
		case 1:
			tipoVentanilla = "VE-";
			break;
		case 2:
			tipoVentanilla = "CA-";
			break;
		case 3:
			tipoVentanilla = "TU-";
			break;
		default:
			break;
		}
		

		PintarCuadros();
		
		switch (ordenCuadros) {
		case 1:
			txtCola1.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros++;
			break;
		case 2:
			txtCola2.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros++;
			break;
		case 3:
			txtCola3.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros++;
			break;
		case 4:
			txtCola4.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros++;
			break;
		case 5:
			txtCola5.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros++;
			break;
		case 6:
			txtCola6.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros++;
			break;
		case 7:
			txtCola7.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros++;
			break;
		case 8:
			txtCola8.setText(tipoVentanilla + nticketprox + "  ->  " + ventanilla);
			ordenCuadros = 1;
			break;
		}
	}
	
	public void PintarCuadros(){
		switch (ordenCuadros) {
		case 1:
			txtCola1.setForeground(new Color(220, 20, 60));
			txtCola2.setForeground(Color.BLACK);
			txtCola3.setForeground(Color.BLACK);
			txtCola4.setForeground(Color.BLACK);
			txtCola5.setForeground(Color.BLACK);
			txtCola6.setForeground(Color.BLACK);
			txtCola7.setForeground(Color.BLACK);
			txtCola8.setForeground(Color.BLACK);
			break;
		case 2:
			txtCola1.setForeground(Color.BLACK);
			txtCola2.setForeground(new Color(220, 20, 60));
			txtCola3.setForeground(Color.BLACK);
			txtCola4.setForeground(Color.BLACK);
			txtCola5.setForeground(Color.BLACK);
			txtCola6.setForeground(Color.BLACK);
			txtCola7.setForeground(Color.BLACK);
			txtCola8.setForeground(Color.BLACK);
			break;
		case 3:
			txtCola1.setForeground(Color.BLACK);
			txtCola2.setForeground(Color.BLACK);
			txtCola3.setForeground(new Color(220, 20, 60));
			txtCola4.setForeground(Color.BLACK);
			txtCola5.setForeground(Color.BLACK);
			txtCola6.setForeground(Color.BLACK);
			txtCola7.setForeground(Color.BLACK);
			txtCola8.setForeground(Color.BLACK);
			break;
		case 4:
			txtCola1.setForeground(Color.BLACK);
			txtCola2.setForeground(Color.BLACK);
			txtCola3.setForeground(Color.BLACK);
			txtCola4.setForeground(new Color(220, 20, 60));
			txtCola5.setForeground(Color.BLACK);
			txtCola6.setForeground(Color.BLACK);
			txtCola7.setForeground(Color.BLACK);
			txtCola8.setForeground(Color.BLACK);
			break;
		case 5:
			txtCola1.setForeground(Color.BLACK);
			txtCola2.setForeground(Color.BLACK);
			txtCola3.setForeground(Color.BLACK);
			txtCola4.setForeground(Color.BLACK);
			txtCola5.setForeground(new Color(220, 20, 60));
			txtCola6.setForeground(Color.BLACK);
			txtCola7.setForeground(Color.BLACK);
			txtCola8.setForeground(Color.BLACK);
			break;
		case 6:
			txtCola1.setForeground(Color.BLACK);
			txtCola2.setForeground(Color.BLACK);
			txtCola3.setForeground(Color.BLACK);
			txtCola4.setForeground(Color.BLACK);
			txtCola5.setForeground(Color.BLACK);
			txtCola6.setForeground(new Color(220, 20, 60));
			txtCola7.setForeground(Color.BLACK);
			txtCola8.setForeground(Color.BLACK);
			break;
		case 7:
			txtCola1.setForeground(Color.BLACK);
			txtCola2.setForeground(Color.BLACK);
			txtCola3.setForeground(Color.BLACK);
			txtCola4.setForeground(Color.BLACK);
			txtCola5.setForeground(Color.BLACK);
			txtCola6.setForeground(Color.BLACK);
			txtCola7.setForeground(new Color(220, 20, 60));
			txtCola8.setForeground(Color.BLACK);
			break;
		case 8:
			txtCola1.setForeground(Color.BLACK);
			txtCola2.setForeground(Color.BLACK);
			txtCola3.setForeground(Color.BLACK);
			txtCola4.setForeground(Color.BLACK);
			txtCola5.setForeground(Color.BLACK);
			txtCola6.setForeground(Color.BLACK);
			txtCola7.setForeground(Color.BLACK);
			txtCola8.setForeground(new Color(220, 20, 60));
			break;

		default:
			break;
		}
	}
	
	public void ReproducirAlerta(){
		Consultas consultas = new Consultas();
		consultas.iniciar();
		try {
			FileInputStream direccion;
			//ClassLoader classLoader = getClass().getClassLoader();
			File file = new File("C:/ReproductorVideo/turno.mp3");
			//System.out.println(file);
			direccion = new FileInputStream(file);
			Player player;
			BufferedInputStream bis = new BufferedInputStream(direccion);
			
			player = new Player(bis);
			player.play();
			
		} catch (Exception e) {
			consultas.RegistrarError("No se encontro el sonido " + e.getMessage());
		}
		consultas.reset();
	}
}