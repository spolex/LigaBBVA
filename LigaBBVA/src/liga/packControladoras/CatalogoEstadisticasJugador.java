package liga.packControladoras;
import java.util.ArrayList;

import  liga.packGestorBD.*;

public class CatalogoEstadisticasJugador 
{
	private static CatalogoEstadisticasJugador miCatalogoEstJug=new CatalogoEstadisticasJugador();
	
	private CatalogoEstadisticasJugador(){
		
	}
	
	public static CatalogoEstadisticasJugador getMiCatalogoEstJug()
	{
		return miCatalogoEstJug;
	}
	
	public ArrayList<String> obtenerJugadorFairPlay(int codTemp)
	{
		ArrayList<String> jugFairPlay = new ArrayList<String>();
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM estadisticasjugador AS e INNER JOIN jugador AS j ON e.codjug = j.codjug WHERE numtemporada='"+codTemp+"' ORDER BY e.numsanciones ASC");
		if(RdoSQL.next())
		{
			jugFairPlay.add(RdoSQL.get("nombre"));
			jugFairPlay.add(RdoSQL.get("nombreequipo"));
			jugFairPlay.add(RdoSQL.get("numsanciones"));
			
		}
		return jugFairPlay;
				
	}
	
	public int[] obtenerEstadisticasJugador(int pJugador)
	{
		int[]estadistica=new int[2];
		ResultadoSQL RdoSQL= SGBD.getSGBD().consultaSQL("SELECT numgoles,"
				+ "numsanciones FROM estadisticasjugador WHERE codjug='"+pJugador+"'");
		if(RdoSQL.next()){
			estadistica[0]=RdoSQL.getInt("numgoles");
			estadistica[1]=RdoSQL.getInt("numsanciones");
		}
		return estadistica;		
	}

}
