package liga.packControladoras;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoJugadores {
	private static CatalogoJugadores miCatalogoJugadores = new CatalogoJugadores();
	
	private CatalogoJugadores() {}
	
	public static CatalogoJugadores getCatalogoJugadores() {
		return miCatalogoJugadores;
	}
	
	@SuppressWarnings("null")
	public String[][] getListaJugadores(String equipo) {
		String[][] listaJugadores = null;
		int i = 0;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT codjug, nombre, dorsal, estaenventa, numsanciones FROM jugador WHERE estaretirado = 0 AND nombreequipo = " + equipo);
		while (RdoSQL.next()) {
			listaJugadores[i][0] = RdoSQL.get("codjug");
			listaJugadores[i][1] = RdoSQL.get("nombre");
			listaJugadores[i][2] = RdoSQL.get("dorsal");
			listaJugadores[i][3] = RdoSQL.get("estaenventa");
			listaJugadores[i][4] = RdoSQL.get("numsanciones");
			i++;
		}
		return listaJugadores;
	}
	
	@SuppressWarnings("null")
	public String[][] getJugadoresConvocables(int temporada, int jornada, String equipo) {
		String[][] listaJugadores = getListaJugadores(equipo);
		String[][] listaJugadoresConvocables = null;
		int i, cont = 0;
		for (i = 0; i < listaJugadores.length; i++) { // Hay que comprobar cada jugador.
			int estaEnVenta = Integer.parseInt(listaJugadores[i][3]);
			if (estaEnVenta == 0) { // Solo puede ser convocado si no esta en venta...
				ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT COUNT(*) as cont FROM tarjetas WHERE numtemporada = " + temporada + " AND numjornada = " + jornada + " codjug = " + listaJugadores[i][0] + " AND esamarilla = 0");
				RdoSQL.next();
				if (RdoSQL.getInt("cont") == 0) { // ...ademas de no haber tenido tarjeta roja la jornada anterior.
					listaJugadoresConvocables[cont][0] = listaJugadores[i][0]; // CodJug.
					listaJugadoresConvocables[cont][1] = listaJugadores[i][1]; // Nombre.
					listaJugadoresConvocables[cont][2] = listaJugadores[i][2]; // Dorsal.
					cont++;
				}
			}
		}
		return listaJugadoresConvocables;
	}
	
	private boolean estaJugador(String nombreEquipo, String nombreJugador) {
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT COUNT(*) as cont FROM jugador WHERE nombreequipo = " + nombreEquipo + " AND nombre = " + nombreJugador);
		RdoSQL.next();
		if (RdoSQL.getInt("cont") != 0)
			return true;
		return false;
	}
	
	public boolean anadirJugadoresConvocados() {
		return true;
	}
	
	public boolean anadirJugador(String nombreEquipo, String nombreJugador, String dorsal) {
		if (!this.estaJugador(nombreEquipo, nombreJugador)) {
			SGBD.getSGBD().execSQL("INSERT INTO jugador (nombre, dorsal, nombreequipo) VALUES (" + nombreJugador + ", " + dorsal + ", " + nombreEquipo + ")");
			return true;
		}
		return false;
	}
	
	public boolean modificarJugador(String codJug, String nombreEquipo, String nombreJugador) {
		if (!this.estaJugador(nombreEquipo, nombreJugador)) {
			SGBD.getSGBD().execSQL("UPDATE jugador SET nombre = " + nombreJugador + " WHERE codjug = " + codJug);
			return true;
		}
		return false;
	}
	
	public void darDeBajaJugador(String codJug) {
		SGBD.getSGBD().execSQL("UPDATE jugador SET estaretirado = 1 WHERE codjug = " + codJug);
	}
}
