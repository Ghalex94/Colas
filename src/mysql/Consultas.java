package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import mysql.MySQLConexion;

public class Consultas {
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	Consultas consultas = null;

	public void iniciar(){
		try {
			con = MySQLConexion.getConection();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void reset(){
		try {
			if(con!=null)con.close();
			if(st!=null)st.close();
			if(rs!=null)rs.close();
			if(pst!=null)pst.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public void RegistrarError(String error){
		try {
			st = con.createStatement();
			String sql = "insert into tb_errores (error, fecha)" + " values (?, default)";
			pst = con.prepareStatement(sql);
			pst.setString(1, error);
			pst.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR al registrar ventanilla: " + e.getMessage());
		}
	}
	public ResultSet ObtenerUltNroTicket(){	
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas order by turno desc LIMIT 1");
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener ultimo ticket  " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ObtenerUltNroTicketHoy(int tipo){		
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas  where fecha = CURDATE() and tipo = " + tipo + " order by turno desc LIMIT 1;");
			
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener ultimo ticket hoy  " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ObtenerUltimaPantallaTurnos(){	
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from tb_colas where estado != 0 and fecha = CURDATE() order by turno desc LIMIT 8");
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener ultima pantalla " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ObtenerTicketProximo(int tipo){
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas where estado = 0 and fecha = CURDATE() and tipo = " + tipo + " order by turno asc LIMIT 1");
		} catch (Exception e) {
			consultas.RegistrarError("Error al obtener proximo ticket " + e.getMessage());
		}
		return rs;
	}
	
	
	public void RegistrarAtencion(int nroticket, int tipo){
		java.util.Date date = new Date();
		try {
			st = con.createStatement();
			String sql = "insert into tb_colas (turno, fecha, tipo, estado)" + " values (?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, nroticket);
			pst.setObject(2, date);
			pst.setInt(3, tipo);
			pst.setInt(4, 0);
			pst.execute();
			//JOptionPane.showMessageDialog(null, "TICKET REGISTRADO");
		} catch (Exception e) {
			consultas.RegistrarError("ERROR al registrar ticket: " + e.getMessage());
		}
	}
	
	public void RegistrarVentanilla(String ipRecibida, int tipo, int nventanilla){
		try {
			st = con.createStatement();
			String sql = "insert into tb_ventanilla (ip, tipo, ventanilla)" + " values (?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, ipRecibida);
			pst.setInt(2, tipo);
			pst.setInt(3, nventanilla);
			pst.execute();
			//JOptionPane.showMessageDialog(null, "TICKET REGISTRADO");
		} catch (Exception e) {
			consultas.RegistrarError("ERROR al registrar ventanilla: " + e.getMessage());
		}
	}
	
	public void ActualizarEstadoTicket(int nticket, int estado, int ventanilla, int tipo){
		//JOptionPane.showMessageDialog(null, nticket + " " + estado + " " + ventanilla + " " + tipo);		
		
		try {
			st = con.createStatement();
			String sql = "update tb_colas set ventanilla=?, estado = ? where turno = ? and fecha = CURDATE()  and tipo = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, ventanilla);
			pst.setInt(2, estado);
			pst.setInt(3, nticket);
			pst.setInt(4, tipo);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Actualizado " + estado);
		} catch (Exception e) {
			consultas.RegistrarError("ERROR al actualizar ticket: " + e.getMessage());
		}
	}	
}
