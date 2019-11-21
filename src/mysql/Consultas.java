package mysql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			//JOptionPane.showMessageDialog(null, "Error al registrar error1: " + ObtenerFechaHora() + " " + e.getMessage());
		}
        finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
            	//JOptionPane.showMessageDialog(null, "Error al registrar error2: " + ObtenerFechaHora() + " " + ex.getMessage());
            }
        }
	}	

	/*public void RegistrarError(String error){
		try {
			st = con.createStatement();
			String sql = "insert into tb_errores (error, fecha)" + " values (?, default)";
			pst = con.prepareStatement(sql);
			pst.setString(1, error);
			pst.execute();
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "ERROR al registrar error: " + e.getMessage());
		}
	}*/
	
	public ResultSet ObtenerUltNroTicketHoy(int tipo){		
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas where DATE(fecha) = CURDATE() and tipo = " + tipo + " order by turno desc LIMIT 1;");		
		} catch (Exception e) {
			//consultas.RegistrarError("Error al obtener ultimo ticket hoy  " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet ObtenerUltimaPantallaTurnos(){	
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from tb_colas where estado != 0 and DATE(fecha) = CURDATE() order by turno desc LIMIT 8");
		} catch (Exception e) {
			RegistrarError("Error al cargar ultima pantalla: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		}
		return rs;
	}
	
	public ResultSet ObtenerTicketProximo(int tipo){
		try {
			st = con.createStatement();
			rs = st.executeQuery("select turno from tb_colas where estado = 0 and DATE(fecha) = CURDATE() and tipo = " + tipo + " order by turno asc LIMIT 1");
		} catch (Exception e) {
			RegistrarError("Error al obtener proximo ticket: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		}
		return rs;
	}
	
	public void RegistrarAtencion(int nroticket, int tipo){
		try {
			st = con.createStatement();
			String sql = "insert into tb_colas (turno, fecha, tipo, estado)" + " values (?, default, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, nroticket);
			pst.setInt(2, tipo);
			pst.setInt(3, 0);
			pst.execute();
		} catch (Exception e) {
			RegistrarError("Error al registrar ticket: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		}
	}
	
	public void ActualizarEstadoTicket(int nticket, int estado, int ventanilla, int tipo){		
		try {
			st = con.createStatement();
			String sql = "update tb_colas set ventanilla=?, estado = ? where turno = ? and DATE(fecha) = CURDATE()  and tipo = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, ventanilla);
			pst.setInt(2, estado);
			pst.setInt(3, nticket);
			pst.setInt(4, tipo);
			pst.execute();
		} catch (Exception e) {
			RegistrarError("Error al actualizar ticket: " + ObtenerFechaHora() + " " + e.getMessage() + "\n");
		}
	}	
}
