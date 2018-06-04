/**
 * 
 */
package Negocio.FactoriaSA;

import Negocio.Alquiler.ASAlquiler;
import Negocio.Alquiler.ASAlquilerImp;
import Negocio.Cliente.ASCliente;
import Negocio.Cliente.ASClienteImp;
import Negocio.Vehiculo.ASVehiculo;
import Negocio.Vehiculo.ASVehiculoImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ASFactoryImp extends ASFactory {

	@Override
	public ASVehiculo createSAVehiculo() {
		return new ASVehiculoImp();
	}

	@Override
	public ASCliente createSACliente() {
		return new ASClienteImp();
	}

	@Override
	public ASAlquiler createSAAlquiler() {
		return new ASAlquilerImp();
	}
}