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
public class TMoto extends TVehiculo {
	private boolean baul;
	public TMoto(int id, String modelo, String matricula, String color,
			int numBaterias, boolean activo,double importe, boolean baul) {
		super(id, modelo, matricula, color, numBaterias,importe, activo);
		this.baul = baul; 
	}
	

	 public boolean getBaul(){
			return this.baul;
	}
		
	 public void setnumGps(boolean baul){
	            this.baul = baul;
	 }
	 public String toString(){
			StringBuilder sb = new StringBuilder(); 
			sb.append("Id: " + this.getId() + " ");
			sb.append("Modelo moto: " + this.getModelo() + " ");
			sb.append("Matricula: " + this.getMatricula() + " ");
			/*sb.append("Color: " + this.getColor() + "\n");
			sb.append("Numero Baterias: " + this.getNumBaterias() + "\n");
			sb.append("Baul: ");
			sb.append(this.getBaul());
			sb.append("\n");
			sb.append("Estado: ");
			sb.append(this.getImporte());
			sb.append(this.getActivo());
			*/
			sb.append("\n");
			return sb.toString();
		}
}