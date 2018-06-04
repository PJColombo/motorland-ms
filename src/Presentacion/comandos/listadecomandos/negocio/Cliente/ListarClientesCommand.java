/**
 * 
 */
package Presentacion.comandos.listadecomandos.negocio.Cliente;

import java.util.ArrayList;

import Negocio.Cliente.TCliente;
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
public class ListarClientesCommand implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Class data)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Context execute(Object data) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ArrayList<TCliente> lista = null;
		try {
			lista = ASFactory.getInstance().createSACliente().listaCliente();
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return new Context(ListaComandos.MOSTRARLISTACLIENTE, lista);
		// end-user-code
	}
}