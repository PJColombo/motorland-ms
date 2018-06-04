/**
 * 
 */
package Negocio.Vehiculo;

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ASVehiculo {
	
	public int altaVehiculo(TVehiculo t) throws Exception;

	public int bajaVehiculo(int id) throws Exception;

	public int modificarVehiculo(TVehiculo t) throws Exception;

	public ArrayList<TVehiculo> mostarListaVehiculos() throws Exception;

	public TVehiculo buscarVehiculo(int id) throws Exception;

	public int comprobarAutonomia(int t) throws Exception;
	
}