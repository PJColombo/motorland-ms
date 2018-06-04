/**
 * 
 */
package Negocio.Cliente;


public class TCliente {
	
	private int idCliente;	
	private String nombre;	
	private String dni;	
	private String domicilio;	
	private long tarjeta;	
	private boolean activo;
	
	public TCliente(){};
	
	public TCliente(int idCliente, String nombre, String dni, String domicilio, long tarjeta, boolean activo){
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.dni = dni; 
		this.domicilio = domicilio;
		this.tarjeta = tarjeta;
		this.activo = activo;
	}
	
	public int getId() {		
		return this.idCliente;		
	}
	public void setId(int id){
		this.idCliente = id; 
	}
	public void setNombre(String n) {
		this.nombre = n; 
	}	
	public String getNombre() {		
		return this.nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	
	public void setDomicilio(String d) {
		this.domicilio = d;
	}

	public String getDomicilio() {
		
		return this.domicilio;
	}

	
	public void setTarjeta(long t) {
		this.tarjeta = t;
	}

	
	public long getTarjeta() {
		
		return this.tarjeta;
		
	}
	public void setActivo(boolean a) {
		this.activo = a;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(); 
		sb.append("Cliente " + this.getId() + " ");
		sb.append("Nombre: " + this.getNombre() + " ");
		sb.append("DNI: " + this.getDni() + " ");
		sb.append("Domicilio: " + this.getDomicilio() + " ");
		sb.append("Tarjeta: " + this.getTarjeta() + " ");
		sb.append("Estado: ");
		sb.append(this.getActivo());
		sb.append("\n");
		return sb.toString();
	}
}