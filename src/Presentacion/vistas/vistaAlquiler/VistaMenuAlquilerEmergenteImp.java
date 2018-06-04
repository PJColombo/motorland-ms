package Presentacion.vistas.vistaAlquiler;





import java.util.ArrayList;

import javax.swing.JOptionPane;

import Negocio.Alquiler.TAlquiler;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;
import Presentacion.vistas.vistaCliente.VistaMenuClientes;
import Presentacion.vistas.vistaVehiculo.Vehiculo;
import Presentacion.vistas.vistaVehiculo.VistaMenuVehiculoImp;

public class VistaMenuAlquilerEmergenteImp extends VistaMenuAlquilerEmergente{
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private AltaAlquilerEmergente vAltaAlquilerEmergente;
	//private static final String SEPARATOR = "----------------------------------";	

	public VistaMenuAlquilerEmergenteImp(){
		vAltaAlquilerEmergente = new AltaAlquilerEmergente();
	}


	@SuppressWarnings("unchecked")
	public void update(Context contexto) {
		
		
		switch(contexto.getEvent()) 
		{
			case ListaComandos.VISTAMENUALTAALQUILEREMERGENTE:
				vAltaAlquilerEmergente.setTAlquiler((TAlquiler) contexto.getData()); 
				vAltaAlquilerEmergente.configuraFechas();
				vAltaAlquilerEmergente.setVisible(true);
				break; 
			case ListaComandos.MOSTRAR_VEHICULOS_DISPONIBLES:
				vAltaAlquilerEmergente.muestraVehiculosDisponibles((ArrayList<TVehiculo>) contexto.getData());
				break; 
			case ListaComandos.CERRAR_ALTA_ALQUILER_EMERGENTE:
				vAltaAlquilerEmergente.setVisible(false);
				break;
		}
		/*
		if(contexto.getEvent() == ListaComandos.VISTAMENUALQUILEREMERGENTE){
			vAlquilerEmergente.setVisible(true);
		}
		else if(contexto.getEvent() == ListaComandos.NEGOCIOAGREGARVEHICULOCARRITO){
		}
		else if(contexto.getEvent() == ListaComandos.ELIMINARVEHICULOCARRITO){
		}
		else if(contexto.getEvent() == ListaComandos.NEGOCIOFINALIZARCARRITO){
		}
		*/
	}
}
