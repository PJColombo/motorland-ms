/**
 * 
 */
package Presentacion.comandos.listadecomandos.negocio.Alquiler;

import Negocio.Alquiler.TAlquiler;
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
public class AltaAlquilerCommand implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Class data)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Context execute(Object data) {
		int id = 0; 
		try {
			id = ASFactory.getInstance().createSAAlquiler().altaAlquiler((TAlquiler) data); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new Context (ListaComandos.CERRAR_ALTA_ALQUILER_EMERGENTE, id);
	}
}