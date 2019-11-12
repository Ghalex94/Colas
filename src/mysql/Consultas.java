package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import mysql.MySQLConexion;

public class Consultas {

	Consultas consultas = null;

	
	public void RegistrarError(String error){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		try {
			st = con.createStatement();
			String sql = "insert into tb_errores (error, fecha)" + " values (?, default)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, error);
			prepareStmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR al registrar ventanilla: " + e.getMessage());
		}
	}
	public ResultSet ObtenerUltNroTicket(){		
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas order by turno desc LIMIT 1");
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener ultimo ticket  " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ObtenerUltNroTicketHoy(int tipo){		
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas  where fecha = CURDATE() and tipo = " + tipo + " order by turno desc LIMIT 1;");
			
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener ultimo ticket hoy  " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ObtenerUltimaPantallaTurnos(){		
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from tb_colas where estado != 0 and fecha = CURDATE() order by turno desc LIMIT 8");
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener ultima pantalla " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ObtenerTicketProximo(int tipo){		
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas where estado = 0 and fecha = CURDATE() and tipo = " + tipo + " order by turno asc LIMIT 1");
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener proximo ticket " + e.getMessage());
		}
		return rs;
	}
	
	
	public void RegistrarAtencion(int nroticket, int tipo){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		java.util.Date date = new Date();
		try {
			st = con.createStatement();
			String sql = "insert into tb_colas (turno, fecha, tipo, estado)" + " values (?, ?, ?, ?)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, nroticket);
			prepareStmt.setObject(2, date);
			prepareStmt.setInt(3, tipo);
			prepareStmt.setInt(4, 0);
			prepareStmt.execute();
			//JOptionPane.showMessageDialog(null, "TICKET REGISTRADO");
		} catch (Exception e) {
			consultas.RegistrarError("ERROR al registrar ticket: " + e.getMessage());
		}
	}
	
	public void RegistrarVentanilla(String ipRecibida, int tipo, int nventanilla){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		try {
			st = con.createStatement();
			String sql = "insert into tb_ventanilla (ip, tipo, ventanilla)" + " values (?, ?, ?)";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setString(1, ipRecibida);
			prepareStmt.setInt(2, tipo);
			prepareStmt.setInt(3, nventanilla);
			prepareStmt.execute();
			//JOptionPane.showMessageDialog(null, "TICKET REGISTRADO");
		} catch (Exception e) {
			consultas.RegistrarError("ERROR al registrar ventanilla: " + e.getMessage());
		}
	}
	
	public void ActualizarEstadoTicket(int nticket, int estado, int ventanilla, int tipo){
		Connection con = MySQLConexion.getConection();
		java.sql.Statement st;
		java.util.Date date = new Date();		
		try {
			st = con.createStatement();
			String sql = "update tb_colas set estado=?, ventanilla=? where turno = ? and fecha = CURDATE()  and tipo = ?";
			PreparedStatement prepareStmt = con.prepareStatement(sql);
			prepareStmt.setInt(1, estado);
			prepareStmt.setInt(2, ventanilla);
			prepareStmt.setInt(3, nticket);
			prepareStmt.setInt(4, tipo);
			prepareStmt.execute();
			//JOptionPane.showMessageDialog(null, "Actualizado");
		} catch (Exception e) {
			consultas.RegistrarError("ERROR al actualizar ticket: " + e.getMessage());
		}
	}	
}
