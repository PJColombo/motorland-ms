/**
 * 
 */
package Presentacion.comandos;

import Presentacion.controlador.Context;


public interface Command {
	
	public abstract Context execute(Object data);
}