package gui_ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Control;
import clases.PaqueteDatos;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

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
	private JTextField txtTipoAtencion;
	private JLabel lblsistemaDesarrolladoPor;
	

	//VARIABLES LOCALES
	
	String ipServer = "192.168.0.100";
	String ipVentanilla = null;
	
	int nroVentanilla = -1;
	int tipoVentanilla = -1;
	int limV = 0;
	
	int puertoServer = 9000;
	int puertoVentanilla = 9002;
	private JLabel lblLogo;
	private JLabel lblSoyLaVentanilla;
	
	
	
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				windowClosingThis(arg0);
			}
		});
		setTitle("SISTEMA DE TURNOS - VENTANILLA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 438);
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
		this.btnLlamarSiguiente.setBackground(new Color(0, 191, 255));
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
		this.btnRellamar.setForeground(new Color(255, 255, 255));
		this.btnRellamar.setBackground(new Color(30, 144, 255));
		this.btnRellamar.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnRellamar.setBounds(233, 68, 210, 60);
		this.contentPane.add(this.btnRellamar);
		
		this.btnMarcarAusente = new JButton("<html><center>Marcar<br>como ausente</center></html>");
		this.btnMarcarAusente.setEnabled(false);
		this.btnMarcarAusente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnMarcarAusente(e);
			}
		});
		this.btnMarcarAusente.setForeground(new Color(255, 255, 255));
		this.btnMarcarAusente.setBackground(new Color(220, 20, 60));
		this.btnMarcarAusente.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnMarcarAusente.setBounds(10, 139, 210, 60);
		this.contentPane.add(this.btnMarcarAusente);
		
		this.btnMarcarAtendido = new JButton("<html><center>Marcar<br>como atendido</center></html>");
		this.btnMarcarAtendido.setEnabled(false);
		this.btnMarcarAtendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnMarcarAtendido(e);
			}
		});
		this.btnMarcarAtendido.setForeground(new Color(255, 255, 255));
		this.btnMarcarAtendido.setBackground(new Color(60, 179, 113));
		this.btnMarcarAtendido.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnMarcarAtendido.setBounds(233, 139, 210, 60);
		this.contentPane.add(this.btnMarcarAtendido);
		
		this.txtNroAtencion = new JTextField();
		txtNroAtencion.setVisible(false);
		this.txtNroAtencion.setForeground(new Color(220, 20, 60));
		this.txtNroAtencion.setFont(new Font("Tahoma", Font.BOLD, 25));
		this.txtNroAtencion.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtNroAtencion.setText("0");
		this.txtNroAtencion.setEditable(false);
		this.txtNroAtencion.setBounds(353, 238, 27, 48);
		this.contentPane.add(this.txtNroAtencion);
		this.txtNroAtencion.setColumns(10);
		
		this.lblA = new JLabel("TICKET ACTUAL:");
		lblA.setForeground(new Color(220, 20, 60));
		this.lblA.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblA.setFont(new Font("Futura Md BT", Font.BOLD, 17));
		this.lblA.setBounds(96, 210, 255, 28);
		this.contentPane.add(this.lblA);
		
		this.panel = new JPanel();
		this.panel.setBackground(new Color(220, 20, 60));
		this.panel.setBounds(0, 0, 453, 57);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		this.txtNroVentanilla = new JTextField();
		this.txtNroVentanilla.setBounds(230, 12, 213, 35);
		this.panel.add(this.txtNroVentanilla);
		this.txtNroVentanilla.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtNroVentanilla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtNroVentanilla(e);
			}
		});
		this.txtNroVentanilla.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.txtNroVentanilla.setBackground(Color.WHITE);
		this.txtNroVentanilla.setForeground(new Color(220, 20, 60));
		this.txtNroVentanilla.setColumns(10);
		
		lblSoyLaVentanilla = new JLabel("Soy la ventanilla nro:");
		lblSoyLaVentanilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoyLaVentanilla.setForeground(Color.WHITE);
		lblSoyLaVentanilla.setFont(new Font("Futura Md BT", Font.BOLD, 18));
		lblSoyLaVentanilla.setBounds(10, 12, 221, 35);
		panel.add(lblSoyLaVentanilla);
		
		this.txtTipoAtencion = new JTextField();
		txtTipoAtencion.setBackground(Color.WHITE);
		this.txtTipoAtencion.setText("0");
		this.txtTipoAtencion.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtTipoAtencion.setForeground(new Color(220, 20, 60));
		this.txtTipoAtencion.setFont(new Font("Futura Md BT", Font.BOLD, 23));
		this.txtTipoAtencion.setEditable(false);
		this.txtTipoAtencion.setColumns(10);
		this.txtTipoAtencion.setBounds(96, 238, 255, 48);
		this.contentPane.add(this.txtTipoAtencion);
		
		lblsistemaDesarrolladoPor = new JLabel("<html><center>Sistema desarrollado por BYTE X BYTE PER\u00DA E.I.R.L<br>Click para m\u00E1s informaci\u00F3n.</center></html>");
		lblsistemaDesarrolladoPor.addMouseListener(this);
		lblsistemaDesarrolladoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblsistemaDesarrolladoPor.setForeground(SystemColor.controlShadow);
		lblsistemaDesarrolladoPor.setFont(new Font("Futura Md BT", Font.ITALIC, 12));
		lblsistemaDesarrolladoPor.setBounds(10, 362, 433, 47);
		contentPane.add(lblsistemaDesarrolladoPor);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logoVentanilla.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(175, 286, 100, 80);
		contentPane.add(lblLogo);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNroVentanilla, btnLlamarSiguiente, btnRellamar, btnMarcarAusente, btnMarcarAtendido}));
				
		cargar();
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
	protected void windowClosingThis(WindowEvent arg0) {
        new Control().cerrarApp();
	}

	
	public void cargar(){
    	this.setLocationRelativeTo(null);
    	InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			ipVentanilla = address.getHostAddress();
			
			if(ipVentanilla.equals("127.0.0.1")){
        		JOptionPane.showMessageDialog(null, "Compruebe su conexión en red");					
				RegistrarError("\n" + ObtenerFechaHora() + " // Error de red al iniciar programa");
				new Control().cerrarApp();
        		System.exit(0);
			}
			else {
				try {
					//PUERTO VENTANILLA
					BufferedReader bfV = new BufferedReader(new FileReader("C:\\SistemaDeTurnos\\Configuraciones\\puertoVentanilla.txt"));
					String sCadena = null;
					while ((sCadena = bfV.readLine())!=null) {
						puertoVentanilla = Integer.parseInt(sCadena);
						//JOptionPane.showMessageDialog(null, puertoCliente);
					}
					
					//PUERTO SERVER
					BufferedReader bfPS = new BufferedReader(new FileReader("C:\\SistemaDeTurnos\\Configuraciones\\puertoServer.txt"));
					sCadena = null;
					while ((sCadena = bfPS.readLine())!=null) {
						puertoServer = Integer.parseInt(sCadena);
						//JOptionPane.showMessageDialog(null, puertoServer);
					}
					
					//IP SERVER
					BufferedReader bfIPS = new BufferedReader(new FileReader("C:\\SistemaDeTurnos\\Configuraciones\\ipServer.txt"));
					sCadena = null;
					while ((sCadena = bfIPS.readLine())!=null) {
						ipServer = sCadena;
						//JOptionPane.showMessageDialog(null, ipServer);
					}

					//LIMITE DE VENTANILLAS
					BufferedReader bfLV = new BufferedReader(new FileReader("C:\\SistemaDeTurnos\\Configuraciones\\venLim.txt"));
					sCadena = null;
					while ((sCadena = bfLV.readLine())!=null) {
						limV = Integer.parseInt(sCadena);
						//JOptionPane.showMessageDialog(null, ipServer);
					}

					//TIPO DE VENTANILLA
					BufferedReader bfTV = new BufferedReader(new FileReader("C:\\SistemaDeTurnos\\Configuraciones\\ventTipo.txt"));
					sCadena = null;
					while ((sCadena = bfTV.readLine())!=null) {
						tipoVentanilla = Integer.parseInt(sCadena);
						//JOptionPane.showMessageDialog(null, ipServer);
					}
					switch (tipoVentanilla) {
					case 1:
						this.setTitle("SISTEMA DE TURNOS - VENTANILLA");
						break;
					case 2:
						this.setTitle("SISTEMA DE TURNOS - CAJA");
						break;
					case 3:
						this.setTitle("SISTEMA DE TURNOS - TURNOS");
						break;

					default:
						break;
					}
								
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No se encontró archivos de configuración en el sistema.\nComuníquese con el desarrollador");
				}
				
				Thread mihilo = new Thread(this);
				mihilo.start();
			}
		} catch (UnknownHostException e) {
			RegistrarError("\n" + ObtenerFechaHora() + " // Error al cargar IP: " + e.getMessage());
		}
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverVentanilla = new ServerSocket(puertoVentanilla);
			Socket socketVentanilla;
			try {
				while(true){
					socketVentanilla = serverVentanilla.accept();
					DataInputStream dis_flujo_entrada = new DataInputStream(socketVentanilla.getInputStream());
					int nticketprox = dis_flujo_entrada.readInt();
					
					if(nticketprox == -1){
						txtTipoAtencion.setText("COLA VACÍA");
						txtNroAtencion.setText("VACÍA");
					}
					else{
						switch (tipoVentanilla) {
						case 1: // VENTANILLLA
							if(nticketprox < 10)
								txtTipoAtencion.setText("VE00"+nticketprox);
							if(nticketprox >= 10 && nticketprox < 100)
								txtTipoAtencion.setText("VE0"+nticketprox);
							if(nticketprox >= 100)
								txtTipoAtencion.setText("VE"+nticketprox);
							break;
						case 2: // CAJA
							if(nticketprox < 10)
								txtTipoAtencion.setText("CA00"+nticketprox);
							if(nticketprox >= 10 && nticketprox < 100)
								txtTipoAtencion.setText("CA0"+nticketprox);
							if(nticketprox >= 100)
								txtTipoAtencion.setText("CA"+nticketprox);
							break;
						case 3: // TURNO
							if(nticketprox < 10)
								txtTipoAtencion.setText("TU00"+nticketprox);
							if(nticketprox >= 10 && nticketprox < 100)
								txtTipoAtencion.setText("TU0"+nticketprox);
							if(nticketprox >= 100)
								txtTipoAtencion.setText("TU"+nticketprox);
							break;
						default:
							break;
						}
						txtNroAtencion.setText(""+nticketprox);
						DesactivarLlamar();
					}
					socketVentanilla.close();
				}
			} catch (Exception e) {
				serverVentanilla.close();
				RegistrarError("\n" + ObtenerFechaHora() + " //Error en run con serverVentanilla: " + e.getMessage());
			}
			
		}
		catch (Exception e) {
			RegistrarError("\n" + ObtenerFechaHora() + " // Error en run: " + e.getMessage());
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
		File directorio=new File("C:\\SistemaDeTurnos\\Logs"); 
		directorio.mkdirs(); 
		String nombreArchivo= "C:\\SistemaDeTurnos\\Logs\\log.txt";
		
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
            	JOptionPane.showMessageDialog(null, "Error al cerrar errores: " + ObtenerFechaHora() + " " + ex.getMessage());
            }
        }
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
	
	protected void keyTypedTxtNroVentanilla(KeyEvent e) {
		char c = e.getKeyChar();
		if ((c<'0' || c>'9') && (c!=(char)KeyEvent.VK_DELETE) && (c!=(char)KeyEvent.VK_BACK_SPACE) && (c!=(char)KeyEvent.VK_ENTER))
			e.consume();
		if(txtNroVentanilla.getText().equals("Ingrese su nro"))
			txtNroVentanilla.setText(null);
	}
	
	protected void actionPerformedBtnLlamarSiguiente(ActionEvent ex) {
		if(txtNroVentanilla.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Por favor, ingrese su número de ventanilla.", "Alerta", JOptionPane.ERROR_MESSAGE);
			txtNroVentanilla.requestFocus();
		}
		/*if(cbTipo.getSelectedIndex() == 0)
			JOptionPane.showMessageDialog(null, "Por favor, indique el tipo de ventanilla", "Alerta", JOptionPane.ERROR_MESSAGE);*/
		else{
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			if(nroVentanilla < 0 || nroVentanilla > limV)
				JOptionPane.showMessageDialog(null, "No tiene permitido usar mas de " + limV, "Alerta", JOptionPane.ERROR_MESSAGE);
			else{
				nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());				
				try {
					Socket socketSolicitarTicket = new Socket(ipServer, puertoServer);			
					
					PaqueteDatos pd = new PaqueteDatos();
					pd.setComando(1); // ATENDIENDO
					pd.setIp(ipVentanilla);
					pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
					pd.setTipo(tipoVentanilla);
					
					ObjectOutputStream oos_llamar_nticket = new ObjectOutputStream(socketSolicitarTicket.getOutputStream());
					oos_llamar_nticket.writeObject(pd);		
					
					socketSolicitarTicket.close();
					oos_llamar_nticket.close();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al llamar al Siguiente Ticket: " + e.getMessage());
	    			RegistrarError("\n" + ObtenerFechaHora() + " // Error al llamar al Siguiente Ticket: " + e.getMessage());
				}
			}
		}
	}
	
	protected void actionPerformedBtnRellamar(ActionEvent ex) {
		if(txtNroVentanilla.getText().equals("Ingrese nro"))
			JOptionPane.showMessageDialog(null, "Seleccione los datos correctamente", "Alerta", JOptionPane.ERROR_MESSAGE);
		else{
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			int ticketactual = Integer.parseInt(txtNroAtencion.getText());
			
			try {
				Socket socketActualizarTicket = new Socket(ipServer, puertoServer);
				
				PaqueteDatos pd = new PaqueteDatos();
				pd.setComando(4); // RELLAMAR
				pd.setIp(ipVentanilla);
				pd.setTicket(ticketactual);
				pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
				pd.setTipo(tipoVentanilla);
				
				ObjectOutputStream oos_indicar_ausente = new ObjectOutputStream(socketActualizarTicket.getOutputStream());
				oos_indicar_ausente.writeObject(pd);	 
				
				socketActualizarTicket.close();
				oos_indicar_ausente.close();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al Rellamar: " + e.getMessage());
    			RegistrarError("\n" + ObtenerFechaHora() + " // Error al Rellamar: " + e.getMessage());
			}
		}
	}
	
	protected void actionPerformedBtnMarcarAusente(ActionEvent ex) {
		if(txtNroVentanilla.getText().equals("Ingrese nro"))
			JOptionPane.showMessageDialog(null, "Seleccione los datos correctamente", "Alerta", JOptionPane.ERROR_MESSAGE);
		else{
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			int ticketactual = Integer.parseInt(txtNroAtencion.getText());
			
			try {
				Socket socketActualizarTicket = new Socket(ipServer, puertoServer);
				
				PaqueteDatos pd = new PaqueteDatos();
				pd.setComando(2); // AUSENTE
				pd.setIp(ipVentanilla);
				pd.setTicket(ticketactual);
				pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
				pd.setTipo(tipoVentanilla);
				
				ObjectOutputStream oos_indicar_ausente = new ObjectOutputStream(socketActualizarTicket.getOutputStream());
				oos_indicar_ausente.writeObject(pd);		 
				socketActualizarTicket.close();
				oos_indicar_ausente.close();
				
				ActivarLlamar();
				txtTipoAtencion.setText("");
				txtNroAtencion.setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al marcar como ausente: " + e.getMessage());
    			RegistrarError("\n" + ObtenerFechaHora() + " // Error al al marcar como ausente: " + e.getMessage());
			}
		}
	}
	
	protected void actionPerformedBtnMarcarAtendido(ActionEvent ex) {
		if(txtNroVentanilla.getText().equals("Ingrese nro"))
			JOptionPane.showMessageDialog(null, "Seleccione los datos correctamente", "Alerta", JOptionPane.ERROR_MESSAGE);
		else{
			nroVentanilla = Integer.parseInt(txtNroVentanilla.getText());
			int ticketactual = Integer.parseInt(txtNroAtencion.getText());
			
			try {
				Socket socketActualizarTicket = new Socket(ipServer, puertoServer);
				
				PaqueteDatos pd = new PaqueteDatos();
				pd.setComando(3); // ATENDIDO
				pd.setIp(ipVentanilla);
				pd.setTicket(ticketactual);
				pd.setVentanilla(Integer.parseInt(txtNroVentanilla.getText()));
				pd.setTipo(tipoVentanilla);
				
				ObjectOutputStream oos_indicar_atendido = new ObjectOutputStream(socketActualizarTicket.getOutputStream());
				oos_indicar_atendido.writeObject(pd);		 
				socketActualizarTicket.close();
				oos_indicar_atendido.close();
				
				ActivarLlamar();
				txtTipoAtencion.setText("");
				txtNroAtencion.setText("");
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al marcar como atendido1 " + e.getMessage());
    			RegistrarError("\n" + ObtenerFechaHora() + " // Error al marcar como atendido: " + e.getMessage());
			}
		}
	}
}
