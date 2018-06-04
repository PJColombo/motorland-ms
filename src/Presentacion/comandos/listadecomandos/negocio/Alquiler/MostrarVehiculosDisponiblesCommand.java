package Presentacion.comandos.listadecomandos.negocio.Alquiler;

import java.util.ArrayList;

import Negocio.Alquiler.TAlquiler;
import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.ASFactory;
import Negocio.Vehiculo.TVehiculo;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

public class MostrarVehiculosDisponiblesCommand implements Command {

	@Override
	public Context execute(Object data) {
		ArrayList<TVehiculo> v = new ArrayList<>();
		
		try {
			v = ASFactory.getInstance().createSAAlquiler().iniciarAlquiler((TAlquiler) data);
					
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return new Context (ListaComandos.MOSTRAR_VEHICULOS_DISPONIBLES, v);
	}

}
