/**
 * 
 */
package Presentacion.comandos.listadecomandos.negocio.Vehiculo;

import java.util.ArrayList;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.ASFactory;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ListarVehiculoCommand implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Class data)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Context execute(Object data) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ArrayList<TVehiculo> lista = null;
		try {
			lista = ASFactory.getInstance().createSAVehiculo().mostarListaVehiculos();
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return new Context(ListaComandos.MOSTRARLISTAVEHICULO, lista);
		// end-user-code
	}
}