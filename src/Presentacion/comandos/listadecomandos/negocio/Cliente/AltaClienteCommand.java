/**
 * 
 */
package Presentacion.comandos.listadecomandos.negocio.Cliente;

import Negocio.FactoriaSA.ASFactory;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;
import Negocio.Cliente.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class AltaClienteCommand implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Class data)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Context execute(Object data) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int id = 0;
		try {
			id = ASFactory.getInstance().createSACliente().altaCliente((TCliente) data);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return new Context (ListaComandos.MOSTRARALTACLIENTE, id);
		// end-user-code
	}
}