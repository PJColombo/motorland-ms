/**
 * 
 */
package Presentacion.vistas.vistaAcercaDe;

import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaAcercaDeImp extends VistaAcercaDe {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private AcercaDe vAcercaDe;
	
	public VistaAcercaDeImp(){
		vAcercaDe = new AcercaDe();
	}

	@Override
	public void update(Context contexto) {
		if(contexto.getEvent() == ListaComandos.VISTAACERCADE){
			vAcercaDe.setVisible(true);
		}
		
	}
}