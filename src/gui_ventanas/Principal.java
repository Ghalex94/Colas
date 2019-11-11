package gui_ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.player.Player;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSeleccioneUnaOpcin;
	private JButton btnPantalla;
	private JButton btnReportes;

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
		
		setTitle("Selecci\u00F3n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 260);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(SystemColor.control);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.panel = new JPanel();
		this.panel.setBackground(Color.DARK_GRAY);
		this.panel.setBounds(0, 0, 564, 61);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		this.lblSeleccioneUnaOpcin = new JLabel("Seleccione una opci\u00F3n:");
		this.lblSeleccioneUnaOpcin.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblSeleccioneUnaOpcin.setForeground(Color.WHITE);
		this.lblSeleccioneUnaOpcin.setBounds(10, 11, 544, 39);
		this.panel.add(this.lblSeleccioneUnaOpcin);
		
		this.btnPantalla = new JButton("PANTALLA");
		this.btnPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnPantalla(arg0);
			}
		});
		this.btnPantalla.setForeground(Color.WHITE);
		this.btnPantalla.setBackground(new Color(30, 144, 255));
		this.btnPantalla.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.btnPantalla.setBounds(47, 109, 200, 70);
		this.contentPane.add(this.btnPantalla);
		
		this.btnReportes = new JButton("REPORTES");
		this.btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnReportes(e);
			}
		});
		this.btnReportes.setForeground(Color.WHITE);
		this.btnReportes.setBackground(new Color(30, 144, 255));
		this.btnReportes.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.btnReportes.setBounds(299, 109, 200, 70);
		this.contentPane.add(this.btnReportes);
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
	
}
