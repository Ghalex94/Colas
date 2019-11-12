package gui_ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import clases.AbstractJasperReports;
import mysql.MySQLConexion;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {

	private JPanel contentPane;
	private JButton btnVerTotal;
	private JPanel panel;
	private JLabel lblReportes;
	private JDateChooser dchInicio;
	private JDateChooser dchFin;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	public Reportes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 259);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.btnVerTotal = new JButton("Ver total de tickets");
		this.btnVerTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnVerTotal(arg0);
			}
		});
		this.btnVerTotal.setBounds(24, 147, 354, 45);
		this.btnVerTotal.setForeground(Color.WHITE);
		this.btnVerTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.btnVerTotal.setBackground(new Color(30, 144, 255));
		this.contentPane.add(this.btnVerTotal);
		
		this.panel = new JPanel();
		this.panel.setBounds(0, 0, 402, 61);
		this.panel.setLayout(null);
		this.panel.setBackground(Color.DARK_GRAY);
		this.contentPane.add(this.panel);
		
		this.lblReportes = new JLabel("REPORTES");
		this.lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblReportes.setForeground(Color.WHITE);
		this.lblReportes.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblReportes.setBounds(10, 11, 382, 39);
		this.panel.add(this.lblReportes);
		
		this.dchInicio = new JDateChooser();
		this.dchInicio.setBounds(24, 90, 141, 32);
		this.contentPane.add(this.dchInicio);
		
		this.dchFin = new JDateChooser();
		this.dchFin.setBounds(237, 90, 141, 32);
		this.contentPane.add(this.dchFin);
		
		this.label = new JLabel("al:");
		this.label.setHorizontalAlignment(SwingConstants.CENTER);
		this.label.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		this.label.setBounds(165, 84, 72, 38);
		this.contentPane.add(this.label);
	}
	
	protected void actionPerformedBtnVerTotal(ActionEvent arg0) {
		Connection con = null;
		try {
			con = MySQLConexion.getConection();

			int añoi = dchInicio.getCalendar().get(Calendar.YEAR);
			int mesi = dchInicio.getCalendar().get(Calendar.MARCH) + 1;
			int diai = dchInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
			//String fechai = añoi + "-" + mesi + "-" + diai + " 00:00:00";
			String fechai = añoi + "-" + mesi + "-" + diai;

			int añof = dchFin.getCalendar().get(Calendar.YEAR);
			int mesf = dchFin.getCalendar().get(Calendar.MARCH) + 1;
			int diaf = dchFin.getCalendar().get(Calendar.DAY_OF_MONTH);
			//String fechaf = añof + "-" + mesf + "-" + diaf + " 23:59:59";
			String fechaf = añof + "-" + mesf + "-" + diaf;
			
			Map parameters = new HashMap();
			parameters.put("prtFechaI", fechai);
			parameters.put("prtFechaF", fechaf);

			new AbstractJasperReports().createReport(con, "rTicketsTotal.jasper", parameters);	
			AbstractJasperReports.showViewer();
			
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontraron datos registrados en estas fechas" + e);
		}
	}
}
