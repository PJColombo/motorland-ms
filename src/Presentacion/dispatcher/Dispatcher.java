/**
 * 
 */
package Presentacion.dispatcher;

import Presentacion.controlador.Context;

public abstract class Dispatcher {
	
	private static Dispatcher dispatcher;

	public synchronized static Dispatcher getInstance() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (dispatcher == null)
			dispatcher = new DispatcherImp();
		return dispatcher;
	}

	public abstract void run(Context context);
}