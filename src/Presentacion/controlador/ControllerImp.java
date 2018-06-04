/**
 * 
 */
package Presentacion.controlador;

import Presentacion.comandos.Command;
import Presentacion.comandos.CommandFactory;
import Presentacion.dispatcher.Dispatcher;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerImp extends Controller {

	@Override
	public void run(int event, Object datos) {
		CommandFactory factoriaComandos = CommandFactory.getInstance();
		Command comando = factoriaComandos.getCommand(event);
		Context contexto = comando.execute(datos);
		Dispatcher dispatcher = Dispatcher.getInstance();
		dispatcher.run(contexto);
	}
}