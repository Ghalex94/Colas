package gui_ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Control;
import javazoom.jl.player.Player;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSeleccioneUnaOpcin;
	private JButton btnPantalla;
	private JButton btnReportes;
	private JLabel lblSeleccioneUnaOpcin_1;
	private JLabel label;
	private JLabel label_1;
	private JButton btnComandos;
	

	public String pass = "-1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setLocationRelativeTo(null);
		
		setTitle("Sistema de control de turnos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 393);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(SystemColor.control);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.panel = new JPanel();
		this.panel.setBackground(new Color(220, 20, 60));
		this.panel.setBounds(0, 0, 475, 61);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		this.lblSeleccioneUnaOpcin = new JLabel("SISTEMA DE CONTROL DE TURNOS");
		lblSeleccioneUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblSeleccioneUnaOpcin.setFont(new Font("Futura Md BT", Font.BOLD, 20));
		this.lblSeleccioneUnaOpcin.setForeground(Color.WHITE);
		this.lblSeleccioneUnaOpcin.setBounds(0, 0, 475, 61);
		this.panel.add(this.lblSeleccioneUnaOpcin);
		
		this.btnPantalla = new JButton("PANTALLA");
		this.btnPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnPantalla(arg0);
			}
		});
		this.btnPantalla.setForeground(Color.WHITE);
		this.btnPantalla.setBackground(new Color(30, 144, 255));
		this.btnPantalla.setFont(new Font("Futura Md BT", Font.BOLD, 20));
		this.btnPantalla.setBounds(20, 119, 200, 70);
		this.contentPane.add(this.btnPantalla);
		
		this.btnReportes = new JButton("REPORTES");
		this.btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnReportes(e);
			}
		});
		this.btnReportes.setForeground(Color.WHITE);
		this.btnReportes.setBackground(new Color(30, 144, 255));
		this.btnReportes.setFont(new Font("Futura Md BT", Font.BOLD, 20));
		this.btnReportes.setBounds(256, 119, 200, 70);
		this.contentPane.add(this.btnReportes);
		
		lblSeleccioneUnaOpcin_1 = new JLabel("Seleccione una opci\u00F3n:");
		lblSeleccioneUnaOpcin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUnaOpcin_1.setForeground(Color.BLACK);
		lblSeleccioneUnaOpcin_1.setFont(new Font("Futura Md BT", Font.BOLD, 20));
		lblSeleccioneUnaOpcin_1.setBounds(10, 66, 455, 44);
		contentPane.add(lblSeleccioneUnaOpcin_1);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logoVentanilla.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(186, 244, 100, 71);
		contentPane.add(label);
		
		label_1 = new JLabel("<html><center>Sistema desarrollado por BYTE X BYTE PER\u00DA E.I.R.L<br>Toque para m\u00E1s informaci\u00F3n.</center></html>");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedLabel_1(arg0);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(SystemColor.controlShadow);
		label_1.setFont(new Font("Futura Md BT", Font.ITALIC, 13));
		label_1.setBounds(0, 313, 475, 51);
		contentPane.add(label_1);
		
		btnComandos = new JButton("COMANDOS");
		btnComandos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnComandos(arg0);
			}
		});
		btnComandos.setForeground(Color.WHITE);
		btnComandos.setFont(new Font("Futura Md BT", Font.BOLD, 20));
		btnComandos.setBackground(new Color(30, 144, 255));
		btnComandos.setBounds(137, 200, 200, 33);
		contentPane.add(btnComandos);
		
		
		
		cargar();
	}
	
	public void cargar(){

		this.setLocationRelativeTo(null);
	}
	
	protected void actionPerformedBtnPantalla(ActionEvent arg0) {
		Pantalla p = new Pantalla();
		p.setVisible(true);
		this.dispose();
	}
	
	protected void actionPerformedBtnReportes(ActionEvent e) {
		Reportes r = new Reportes();
		r.setVisible(true);
		r.setLocationRelativeTo(null);
		this.dispose();		
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		Creditos el = new Creditos();
		el.setLocationRelativeTo(null);
		el.setVisible(true);
	}
	
	protected void actionPerformedBtnComandos(ActionEvent arg0) {
		pass = "-1";
		this.setEnabled(false);
		numeros n = new numeros(null, this);
		n.setVisible(true);
		n.setAlwaysOnTop(true);	
		n.setLocationRelativeTo(null);
	}
	
	public void verificarPass(){
		if(pass.equals("1571")){
			try { // LICENCIA ILIMITADA
				String ruta = "C:\\SistemaDeTurnos\\Configuraciones\\lic.txt";
			    File archivo = new File(ruta);
			    BufferedWriter bw;
			    if(archivo.exists()) {
			    	bw = new BufferedWriter(new FileWriter(archivo));
			        bw.write("01/01/2050");
			        bw.close();
			        
			        JOptionPane.showMessageDialog(null, "Su licencia ahora es permanente"); 
			        new Control().cerrarApp();
					System.exit(0);
			    }
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al realizar el cambio");
			}
		}
	}
}
