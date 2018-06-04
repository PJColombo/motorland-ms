package Negocio.Alquiler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculadorPrecios {
	
	private static final double PORCENTAJE = 0.03; 
	private static double TARIFA; 
	
	public static double calculaPrecioAgregado (double precioBase) {
		return Math.round((precioBase + (precioBase * TARIFA)) * 100.0 ) / 100.0;
	}
	
	public static void calculaTarifa (Calendar fechaI, Calendar fechaF) {
		int dias = diasEntreFechas(fechaI.getTime(), fechaF.getTime());
	    TARIFA = PORCENTAJE * dias; 
	}
	
	private static int diasEntreFechas(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}
