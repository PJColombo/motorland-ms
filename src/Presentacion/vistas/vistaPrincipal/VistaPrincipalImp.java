/**
 * 
 */
package Presentacion.vistas.vistaPrincipal;

import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;
import Presentacion.vistas.vistaAlquiler.AltaAlquilerEmergente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaPrincipalImp extends VistaPrincipal {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Principal vPrincipal;
	
	public VistaPrincipalImp() 
	{
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	vPrincipal = new Principal();
            }
        });
	}

	/** 
	 * (sin Javadoc)
	 * @see VistaPrincipal#update(Context contexto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(Context contexto) {
		if(contexto.getEvent() == ListaComandos.VISTAMENUPRINCIPAL){
			java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	vPrincipal.setVisible(true);
	            }
	        });
		}
	}
}