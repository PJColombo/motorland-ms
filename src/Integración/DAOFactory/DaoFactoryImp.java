/**
 * 
 */
package Integración.DAOFactory;

import Integración.Vehiculo.DAOVehiculo;
import Integración.Vehiculo.DAOVehiculoImp;
import Integración.Alquiler.DAOAlquiler;
import Integración.Alquiler.DAOAlquilerImp;
import Integración.Cliente.DAOCliente;
import Integración.Cliente.DAOClienteImp;


public class DaoFactoryImp extends DaoFactory {

	public DAOVehiculo createDAOVehiculo() {
		return new DAOVehiculoImp();

	}

	public DAOAlquiler createDAOAlquiler() {
		return new DAOAlquilerImp();
	}

	public DAOCliente createDAOCliente() {
		return new DAOClienteImp();
	}
}