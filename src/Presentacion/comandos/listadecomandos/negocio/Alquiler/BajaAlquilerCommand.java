/**
 * 
 */
package Presentacion.comandos.listadecomandos.negocio.Alquiler;

import Negocio.FactoriaSA.ASFactory;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class BajaAlquilerCommand implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Class data)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Context execute(Object data) {
		int res; 
		
		res = ASFactory.getInstance().createSAAlquiler().bajaAlquiler((int) data);
		return new Context (ListaComandos.MOSTRARBAJAALQUILER, res);
		// end-user-code
	}
}