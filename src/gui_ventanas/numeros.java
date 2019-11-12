package gui_ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class numeros extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JButton btnOn;
	private JButton btnBorrar;
	private JButton boton3;
	private JButton boton6;
	private JButton boton9;
	private JButton boton0;
	private JButton boton2;
	private JButton boton5;
	private JButton boton8;
	private JButton boton1;
	private JButton boton4;
	private JButton boton7;

	Cliente c = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					numeros frame = new numeros(null);
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
	public numeros(Cliente temp) {
		c= temp;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 395);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.GRAY);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.txtNumero = new JTextField();
		this.txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				keyTypedTxtNumero(arg0);
			}
		});
		this.txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtNumero.setForeground(Color.WHITE);
		this.txtNumero.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.txtNumero.setColumns(10);
		this.txtNumero.setBackground(Color.DARK_GRAY);
		this.txtNumero.setBounds(10, 11, 276, 37);
		this.contentPane.add(this.txtNumero);
		
		this.btnOn = new JButton("ACEPTAR");
		this.btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOn(e);
			}
		});
		this.btnOn.setForeground(Color.WHITE);
		this.btnOn.setBackground(Color.GREEN);
		this.btnOn.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btnOn.setBounds(194, 283, 92, 75);
		this.contentPane.add(this.btnOn);
		
		this.btnBorrar = new JButton("BORRAR");
		this.btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBorrar(e);
			}
		});
		this.btnBorrar.setForeground(Color.WHITE);
		this.btnBorrar.setBackground(Color.RED);
		this.btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.btnBorrar.setBounds(10, 283, 92, 75);
		this.contentPane.add(this.btnBorrar);
		
		this.boton3 = new JButton("3");
		this.boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton3(e);
			}
		});
		this.boton3.setBackground(Color.WHITE);
		this.boton3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton3.setBounds(194, 207, 92, 75);
		this.contentPane.add(this.boton3);
		
		this.boton6 = new JButton("6");
		this.boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton6(e);
			}
		});
		this.boton6.setBackground(Color.WHITE);
		this.boton6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton6.setBounds(194, 131, 92, 75);
		this.contentPane.add(this.boton6);
		
		this.boton9 = new JButton("9");
		this.boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton9(e);
			}
		});
		this.boton9.setBackground(Color.WHITE);
		this.boton9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton9.setBounds(194, 56, 92, 75);
		this.contentPane.add(this.boton9);
		
		this.boton0 = new JButton("0");
		this.boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedButton_0(arg0);
			}
		});
		this.boton0.setBackground(Color.WHITE);
		this.boton0.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton0.setBounds(102, 283, 92, 75);
		this.contentPane.add(this.boton0);
		
		this.boton2 = new JButton("2");
		this.boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedButton_5(e);
			}
		});
		this.boton2.setBackground(Color.WHITE);
		this.boton2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton2.setBounds(102, 207, 92, 75);
		this.contentPane.add(this.boton2);
		
		this.boton5 = new JButton("5");
		this.boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton5(e);
			}
		});
		this.boton5.setBackground(Color.WHITE);
		this.boton5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton5.setBounds(102, 131, 92, 75);
		this.contentPane.add(this.boton5);
		
		this.boton8 = new JButton("8");
		this.boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton8(e);
			}
		});
		this.boton8.setBackground(Color.WHITE);
		this.boton8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton8.setBounds(102, 56, 92, 75);
		this.contentPane.add(this.boton8);
		
		this.boton1 = new JButton("1");
		this.boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton1(e);
			}
		});
		this.boton1.setBackground(Color.WHITE);
		this.boton1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton1.setBounds(10, 207, 92, 75);
		this.contentPane.add(this.boton1);
		
		this.boton4 = new JButton("4");
		this.boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton4(e);
			}
		});
		this.boton4.setBackground(Color.WHITE);
		this.boton4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton4.setBounds(10, 131, 92, 75);
		this.contentPane.add(this.boton4);
		
		this.boton7 = new JButton("7");
		this.boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBoton7(e);
			}
		});
		this.boton7.setBackground(Color.WHITE);
		this.boton7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.boton7.setBounds(10, 56, 92, 75);
		this.contentPane.add(this.boton7);
	}
	
	protected void keyTypedTxtNumero(KeyEvent arg0) {
		
	}
	protected void actionPerformedButton_0(ActionEvent arg0) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="0";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton1(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="1";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedButton_5(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="2";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton3(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="3";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton4(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="4";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton5(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="5";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton6(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="6";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton7(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="7";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton8(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="8";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBoton9(ActionEvent e) {
		if (txtNumero.getText().length() >= 0 && txtNumero.getText().length() <= 3) {
			String num="9";
			txtNumero.setText(txtNumero.getText() + num);
			keyTypedTxtNumero(null);
		}
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtNumero.setText("");
	}
	protected void actionPerformedBtnOn(ActionEvent e) {
		c.nro = Integer.parseInt(txtNumero.getText());
		c.verificarPass();
		this.setAlwaysOnTop(false);
		this.dispose();
	}
}
