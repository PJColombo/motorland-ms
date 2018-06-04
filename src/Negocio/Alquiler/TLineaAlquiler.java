package Negocio.Alquiler;


public class TLineaAlquiler {
	
	//solo para facilitar la creacion de la lista de vehiculos alquilados.
	private int idVehiculo;
	
	private double coste;
	//Facilita los updates de alquileres en la base de datos. 
	private Operacion operacion; 
	
	public TLineaAlquiler (double coste, Operacion operacion) {
		this.coste = coste;
		this.operacion = operacion; 
	}
	public TLineaAlquiler (double coste) {
		this.coste = coste;
	}
	
	public int getIdVehiculo() {
		return idVehiculo;
	}
	
	public void setIdVehiculo(int idvehiculo) {
		this.idVehiculo = idvehiculo;
	}
	public double getCoste(){
		return this.coste;
	}
	
	public void setCoste(double coste){
		this.coste = coste;
	}
	
	
	public Operacion getOperacion() {
		return operacion;
	}
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}
	
	@Override
	public String toString() {
		return "Coste: " + coste;
	}
	
	
}
