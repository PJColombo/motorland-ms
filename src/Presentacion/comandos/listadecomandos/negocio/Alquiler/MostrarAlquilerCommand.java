/**
 * 
 */
package Presentacion.comandos.listadecomandos.negocio.Alquiler;

import Negocio.Alquiler.TAlquiler;
import Negocio.FactoriaSA.ASFactory;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;
import Presentacion.controlador.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MostrarAlquilerCommand implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Class data)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Context execute(Object data) {
		TAlquiler t = null; 
		try {
			t = ASFactory.getInstance().createSAAlquiler().buscaAlquiler((int) data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Context(ListaComandos.MOSTRARBUSCARALQUILER, t);
		// end-user-code
	}
}