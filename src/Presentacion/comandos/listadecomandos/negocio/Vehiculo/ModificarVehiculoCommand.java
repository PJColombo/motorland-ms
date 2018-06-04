package Presentacion.comandos.listadecomandos.negocio.Vehiculo;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.ASFactory;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

public class ModificarVehiculoCommand implements Command {

	@Override
	public Context execute(Object data) {
		// TODO Auto-generated method stub
		int id = -1;
		try {
			id = ASFactory.getInstance().createSAVehiculo().modificarVehiculo((TVehiculo) data);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return new Context (ListaComandos.MOSTRARMODIFICARVEHICULO,id);
	}

}
