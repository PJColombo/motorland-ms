package main;

import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Controller;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controller.getInstance().run(ListaComandos.VISTAMENUPRINCIPAL, null);
	}

}
