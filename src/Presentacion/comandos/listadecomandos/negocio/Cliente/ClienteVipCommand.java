package Presentacion.comandos.listadecomandos.negocio.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.ASFactory;
import Presentacion.comandos.Command;
import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Context;

public class ClienteVipCommand implements Command {

	@Override
	public Context execute(Object data) {
		// TODO Auto-generated method stub
		TCliente t = ASFactory.getInstance().createSACliente().clienteVip();
		return new Context (ListaComandos.MOSTRARCLIENTEVIP, null);
	}

}
