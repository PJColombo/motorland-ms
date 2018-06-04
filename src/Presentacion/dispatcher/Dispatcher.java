/**
 * 
 */
package Presentacion.dispatcher;

import Presentacion.controlador.Context;

public abstract class Dispatcher {
	
	private static Dispatcher dispatcher;

	public synchronized static Dispatcher getInstance() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		if (dispatcher == null)
			dispatcher = new DispatcherImp();
		return dispatcher;
	}

	public abstract void run(Context context);
}