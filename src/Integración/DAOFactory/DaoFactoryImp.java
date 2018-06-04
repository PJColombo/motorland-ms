/**
 * 
 */
package Integraci�n.DAOFactory;

import Integraci�n.Vehiculo.DAOVehiculo;
import Integraci�n.Vehiculo.DAOVehiculoImp;
import Integraci�n.Alquiler.DAOAlquiler;
import Integraci�n.Alquiler.DAOAlquilerImp;
import Integraci�n.Cliente.DAOCliente;
import Integraci�n.Cliente.DAOClienteImp;


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