/**
 * 
 */
package Negocio.Vehiculo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TCoche extends TVehiculo {
	public TCoche(int id, String modelo, String matricula, String color,
			int numBaterias, double coste, boolean activo, int puertas, boolean gps) {
		super(id, modelo, matricula, color, numBaterias, coste, activo);
		this.puertas = puertas;
		this.gps = gps; 
	}

	private int puertas;
	private boolean gps;
	
	public void setPuertas(int p) {
		this.puertas = p;
	}

	public int getPuertas(){
		return this.puertas;
	}
	
    
     public boolean getGps(){
		return this.gps;
	}
	
    public void setnumGps(boolean gps){
            this.gps = gps;
    }
    public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.getId() + " ");
		sb.append("Modelo coche: " + this.getModelo() + " ");
		sb.append("Matricula: " + this.getMatricula() + " ");
		/*sb.append("Color: " + this.getColor() + "\n");
		sb.append("Numero Baterias: " + this.getNumBaterias() + "\n");
		sb.append("Numero de puertas: " + this.getPuertas() + "\n");
		sb.append("GPS: ");
		sb.append(this.getGps());
		sb.append("\n");
		sb.append("Estado: ");
		sb.append(this.getActivo());*/
		sb.append("\n");
		return sb.toString();
	}
}
    
     