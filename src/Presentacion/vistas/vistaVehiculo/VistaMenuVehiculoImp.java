/**
 * 
 */
package Presentacion.vistas.vistaVehiculo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Negocio.Cliente.TCliente;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;
import Presentacion.vistas.vistaCliente.Clientes;
import Presentacion.vistas.vistaCliente.VistaMenuClientesImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author José Antonio Garrido Sualdea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaMenuVehiculoImp extends VistaMenuVehiculo {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Vehiculo vVehiculos;
	private static final String SEPARATOR = "----------------------------------";	

	public VistaMenuVehiculoImp(){
		vVehiculos = new Vehiculo();
	}


	@Override
	public void update(Context contexto) {
		if(contexto.getEvent() == ListaComandos.VISTAMENUVEHICULO){
			vVehiculos.setVisible(true);
		}
		else if(contexto.getEvent() == ListaComandos.MOSTRARALTAVEHICULO){
			String mensajeAlta ="";
			switch((int)contexto.getData()){
			case -1: mensajeAlta +="error al dar de alta a un vehiculo"; break;
			case -2: mensajeAlta +="error al dar de alta a vehiculo existente pero dado de baja"; break;
			case -3: mensajeAlta +="error, el vehiculo existe y esta dado de alta"; break;
			default: mensajeAlta += "existo al dar de alta"; break;
			}
			
		}
		else if(contexto.getEvent() == ListaComandos.MOSTRARBAJAVEHICULO){
			String mensajeBaja = "";
			switch((int)contexto.getData()){
			case -1: mensajeBaja +="error al dar de baja a un vehiculo existe dado de alta"; break;
			case -2: mensajeBaja +="error ya esta dado de baja el vehiculo"; break;
			case -3: mensajeBaja +="error, el vehiculo no existe"; break;
			default: mensajeBaja += "existo al dar de baja"; break;
			}
					
		}
		else if(contexto.getEvent() == ListaComandos.MOSTRARMODIFICARVEHICULO){
			String mensajeModificar = "";
			switch((int)contexto.getData()){
			case -1: mensajeModificar +="error al actualizar un vehiculo dado de alta"; break;
			case -2: mensajeModificar +="error al instanciar"; break;
			case -3: mensajeModificar +="error, no existe el vehiculo"; break;
			case -4: mensajeModificar +="error el vehiculo ya etsa dado de baja"; break;
			default: mensajeModificar += "existo al dar de baja"; break;
			}
			
		}
		else if(contexto.getEvent() == ListaComandos.MOSTRARBUSCARVEHICULO){
			
			if((TVehiculo)contexto.getData() != null){
				vVehiculos.setComponentes((TVehiculo)contexto.getData());
			}
			else{
				JOptionPane.showMessageDialog(null,"Error al consultar el vehiculo");
			}
			
		}
		else if(contexto.getEvent() == ListaComandos.MOSTRARLISTAVEHICULO){
			StringBuilder mensajeLista = new StringBuilder();
			ArrayList<TVehiculo> lista = ((ArrayList<TVehiculo>) contexto.getData());
			if (lista.size() > 0){
				String suma  = "";
				for(int i = 0; i < lista.size(); i++){
					suma += lista.get(i).toString() + VistaMenuVehiculoImp.SEPARATOR +"\n";
					vVehiculos.setLista(lista.get(i).toString() + VistaMenuVehiculoImp.SEPARATOR +"\n");
				}
				vVehiculos.setLista(suma);
			}
			
		}
		else if(contexto.getEvent() == ListaComandos.MOSTRARCOMPROBARAUTONOMIA){
			if(Integer.toString((int)contexto.getData()) != null){
				vVehiculos.setAutonomia((int)contexto.getData());
			}
			else{
				JOptionPane.showMessageDialog(null,"Error al consultar el vehiculo");
			}		
			
		}
	}
}