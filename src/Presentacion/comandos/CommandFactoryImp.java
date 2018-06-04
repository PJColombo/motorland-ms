/**
 * 
 */
package Presentacion.comandos;

import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.comandos.listadecomandos.negocio.Alquiler.AltaAlquilerCommand;
import Presentacion.comandos.listadecomandos.negocio.Alquiler.BajaAlquilerCommand;
import Presentacion.comandos.listadecomandos.negocio.Alquiler.ListadoAlquileresCommand;
import Presentacion.comandos.listadecomandos.negocio.Alquiler.ModificarAlquilerCommand;
import Presentacion.comandos.listadecomandos.negocio.Alquiler.MostrarAlquilerCommand;
import Presentacion.comandos.listadecomandos.negocio.Alquiler.MostrarVehiculosDisponiblesCommand;
import Presentacion.comandos.listadecomandos.negocio.Cliente.AltaClienteCommand;
import Presentacion.comandos.listadecomandos.negocio.Cliente.BajaClienteCommand;
import Presentacion.comandos.listadecomandos.negocio.Cliente.BuscarClienteCommand;
import Presentacion.comandos.listadecomandos.negocio.Cliente.ClienteVipCommand;
import Presentacion.comandos.listadecomandos.negocio.Cliente.ListarClientesCommand;
import Presentacion.comandos.listadecomandos.negocio.Cliente.ModificarClienteCommand;
import Presentacion.comandos.listadecomandos.negocio.Vehiculo.AltaVehiculoCommand;
import Presentacion.comandos.listadecomandos.negocio.Vehiculo.BajaVehiculoCommand;
import Presentacion.comandos.listadecomandos.negocio.Vehiculo.BuscarVehiculoCommand;
import Presentacion.comandos.listadecomandos.negocio.Vehiculo.ComprobarAutonomiaCommand;
import Presentacion.comandos.listadecomandos.negocio.Vehiculo.ListarVehiculoCommand;
import Presentacion.comandos.listadecomandos.negocio.Vehiculo.ModificarVehiculoCommand;
import Presentacion.comandos.listadecomandos.vistas.VistaAlquilerEmergenteCommand;
import Presentacion.comandos.listadecomandos.vistas.VistaMenuAcercaDeCommand;
import Presentacion.comandos.listadecomandos.vistas.VistaMenuAlquilerCommand;
import Presentacion.comandos.listadecomandos.vistas.VistaMenuClienteCommand;
import Presentacion.comandos.listadecomandos.vistas.VistaMenuPrincipalCommand;
import Presentacion.comandos.listadecomandos.vistas.VistaMenuVehiculoCommand;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandFactoryImp extends CommandFactory {

	@Override
	public Command getCommand(int event) {
		Command comando = null;
		switch (event){
			//VISTAS
			case ListaComandos.VISTAMENUPRINCIPAL:
				comando = new VistaMenuPrincipalCommand();
			break;
			case ListaComandos.VISTAACERCADE:
				comando = new VistaMenuAcercaDeCommand();
			break;
			case ListaComandos.VISTAMENUVEHICULO:
				comando = new VistaMenuVehiculoCommand();
			break;
			case ListaComandos.VISTAMENUCLIENTE:
				comando = new VistaMenuClienteCommand();
			break;
			case ListaComandos.VISTAMENUALQUILER:
				comando = new VistaMenuAlquilerCommand();
			break;
			case ListaComandos.VISTAMENUALTAALQUILEREMERGENTE:
				comando = new VistaAlquilerEmergenteCommand();
			break; 
			//NEGOCIO CLIENTES
			case ListaComandos.NEGOCIOALTACLIENTE:
				comando = new AltaClienteCommand();
			break;
			case ListaComandos.NEGOCIOBAJACLIENTE:
				comando = new BajaClienteCommand();
			break;
			case ListaComandos.NEGOCIOCONSULTARCLIENTE:
				comando = new BuscarClienteCommand();
			break;
			case ListaComandos.NEGOCIOLISTACLIENTE:
				comando = new ListarClientesCommand();
			break;
			case ListaComandos.NEGOCIOCLIENTEVIP:
				comando = new ClienteVipCommand();
			break;
			
			case ListaComandos.NEGOCIOMODIFICARCLIENTE:
				comando = new ModificarClienteCommand();
			break;
			
			//NEGOCIO ALQUILER
			case ListaComandos.NEGOCIOALTAALQUILER:
				comando = new AltaAlquilerCommand();
			break;
			case ListaComandos.NEGOCIOBAJAALQUILER:
				comando = new BajaAlquilerCommand();
			break;
			case ListaComandos.NEGOCIOMODIFICARALQUILER:
				comando = new ModificarAlquilerCommand();
			break;
			case ListaComandos.NEGOCIOLISTAALQUILER:
				comando = new ListadoAlquileresCommand();
			break;
			case ListaComandos.NEGOCIOBUSCARALQUILER:
				comando = new MostrarAlquilerCommand();
			break;
			case ListaComandos.MOSTRAR_VEHICULOS_DISPONIBLES:
				comando = new MostrarVehiculosDisponiblesCommand();
			break;
			//NEGOCIO VEHICULO
			case ListaComandos.NEGOCIOALTAVEHICULO:
				comando = new AltaVehiculoCommand();
			break;
			case ListaComandos.NEGOCIOBAJAVEHICULO:
				comando = new BajaVehiculoCommand();
			break;
			case ListaComandos.NEGOCIOBUSCARVEHICULO:
				comando = new BuscarVehiculoCommand();
			break;
			case ListaComandos.NEGOCIOLISTAVEHICULO:
				comando = new ListarVehiculoCommand();
			break;
			case ListaComandos.NEGOCIOCOMPROBARAUTONOMIA:
				comando = new ComprobarAutonomiaCommand();
			break;
			case ListaComandos.NEGOCIOMODIFICARVEHICULO:
				comando = new ModificarVehiculoCommand();
			break;
		}
		return comando;
	}
}