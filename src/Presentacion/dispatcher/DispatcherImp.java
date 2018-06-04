/**
 * 
 */
package Presentacion.dispatcher;

import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;
import Presentacion.vistas.VistaAlquilerEmergente.AlquilerEmergente;
import Presentacion.vistas.vistaAcercaDe.VistaAcercaDe;
import Presentacion.vistas.vistaAlquiler.VistaMenuAlquiler;
import Presentacion.vistas.vistaAlquiler.VistaMenuAlquilerEmergente;
import Presentacion.vistas.vistaCliente.VistaMenuClientes;
import Presentacion.vistas.vistaPrincipal.VistaPrincipal;
import Presentacion.vistas.vistaVehiculo.VistaMenuVehiculo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispatcherImp extends Dispatcher {

	@Override
	public void run(Context context) {
		// TODO Auto-generated method stub
		switch (context.getEvent()) 
		{
			// Vista Principal
	
			case ListaComandos.VISTAMENUPRINCIPAL:
				VistaPrincipal.getInstance().update(context);
			break;
			
			//VISTA CLIENTES
			case ListaComandos.VISTAMENUCLIENTE:
			case ListaComandos.MOSTRARALTACLIENTE:
			case ListaComandos.MOSTRARBAJACLIENTE:
			case ListaComandos.MOSTRARCONSULTARCLIENTE:
			case ListaComandos.MOSTRARLISTACLIENTE:
			case ListaComandos.MOSTRARMODIFICARCLIENTE:
			case ListaComandos.MOSTRARCLIENTEVIP:
				VistaMenuClientes.getInstance().update(context);
			break;
			
			//VISTA VEHICULO
			case ListaComandos.VISTAMENUVEHICULO:
			case ListaComandos.MOSTRARALTAVEHICULO:
			case ListaComandos.MOSTRARBAJAVEHICULO:
			case ListaComandos.MOSTRARBUSCARVEHICULO:
			case ListaComandos.MOSTRARMODIFICARVEHICULO:
			case ListaComandos.MOSTRARLISTAVEHICULO:
			case ListaComandos.MOSTRARCOMPROBARAUTONOMIA:
				VistaMenuVehiculo.getInstance().update(context);
			break;
			
			//VISTA ALQUILER
			case ListaComandos.VISTAMENUALQUILER:
			case ListaComandos.CERRAR_ALTA_ALQUILER_EMERGENTE:
				VistaMenuAlquilerEmergente.getInstance().update(context);
			case ListaComandos.MOSTRARLISTAALQUILER:
			case ListaComandos.MOSTRARMODIFICARALQUILER:
			case ListaComandos.MOSTRARBAJAALQUILER:
			case ListaComandos.MOSTRARBUSCARALQUILER:
				VistaMenuAlquiler.getInstance().update(context);
			break;
		
		
			//VISTA ACERCADE
			case ListaComandos.VISTAACERCADE:
				VistaAcercaDe.getInstance().update(context);
			break;
			
			//VISTA ALQUILER EMERGENTE
			case ListaComandos.VISTAMENUALTAALQUILEREMERGENTE:
			case ListaComandos.MOSTRAR_VEHICULOS_DISPONIBLES:
				VistaMenuAlquilerEmergente.getInstance().update(context);
			break;
		}
	}
}