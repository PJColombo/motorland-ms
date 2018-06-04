package Presentacion.comandos.listadecomandos.negocio.Vehiculo;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.ASFactory;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

public class AltaVehiculoCommand implements Command {

	@Override
	public Context execute(Object data) {
		int id = -1;
		try {
			id = ASFactory.getInstance().createSAVehiculo().altaVehiculo((TVehiculo)data);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return new Context (ListaComandos.MOSTRARALTAVEHICULO, id);
	}

}
