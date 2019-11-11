package clases;

import java.io.Serializable;

public class PaqueteDatos implements Serializable{

	private int comando;
	private String ip;
	private int ticket;
	private int ventanilla;
	private int tipo;
	
	public int getComando() {
		return comando;
	}
	public void setComando(int comando) {
		this.comando = comando;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public int getVentanilla() {
		return ventanilla;
	}
	public void setVentanilla(int ventanilla) {
		this.ventanilla = ventanilla;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}