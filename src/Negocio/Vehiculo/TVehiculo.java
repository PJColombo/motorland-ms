/**
 * 
 */
package Negocio.Vehiculo;


public class TVehiculo {
	private int id;
	private String modelo;
	private String matricula;
	private String color;
	private int numBaterias;
	private Boolean activo;
	private double coste;
	public TVehiculo(int id, String modelo, String matricula, String color, int numBaterias,double coste, boolean activo){
		this.id = id;
		this.modelo = modelo;
		this.matricula = matricula;
		this.color = color;
		this.numBaterias = numBaterias;
		this.coste= coste;
		this.activo = activo; 
	}
	public int getId(){
		return this.id;
	}
	
	public String getModelo(){
		return this.modelo;
	}
	
	public String getMatricula(){
		return this.matricula;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public int getNumBaterias(){
		return this.numBaterias;
	}
	public double getCoste(){
		return this.coste;
	}
	
	public boolean getActivo(){
		return this.activo;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public void setMatricula(String matricula){
		this.matricula = matricula;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setNumBaterias(int numBaterias){
		this.numBaterias = numBaterias;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
        public void setId(int id){
		this.id = id;
	}
    public void setCoste(double coste){
    		this.coste= coste;
    }
	@Override
	public String toString() {
		String s; 
		s = modelo +
		", " + color +
		", " +numBaterias + " baterias" +
		", " + coste + "€\n"; 
		
		return s; 
	}
    
    
}