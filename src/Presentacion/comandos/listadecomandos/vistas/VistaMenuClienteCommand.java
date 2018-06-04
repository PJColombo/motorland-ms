/**
 * 
 */
package Presentacion.comandos.listadecomandos.vistas;

import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaMenuClienteCommand implements Command {

	@Override
	public Context execute(Object data) {
		// TODO Auto-generated method stub
		return new Context(ListaComandos.VISTAMENUCLIENTE, data);
	}
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Class data)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
}