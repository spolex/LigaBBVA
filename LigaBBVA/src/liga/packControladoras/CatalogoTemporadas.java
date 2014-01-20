package liga.packControladoras;

import java.sql.Date;

import liga.packGestorBD.ResultadoSQL;
import liga.packGestorBD.SGBD;

public class CatalogoTemporadas 
{
private static CatalogoTemporadas misTemporadas=new CatalogoTemporadas();
	
 	static final int  maxTemporadas=100;
	static final int maxJornadas=38; 
	
	private  CatalogoTemporadas() 
	{		
		
	}
	public static CatalogoTemporadas getMiCatalogoTemporadas(){
		return misTemporadas;
	}
	public int[] obtenerTemporadas() 
	{
		int[] jugFairPlay =new int[maxTemporadas];
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT numtemporada FROM temporada ORDER BY fechainicio DESC");
		int i=0;
		while(RdoSQL.next() && i<maxTemporadas)
		{			
			jugFairPlay[i]=RdoSQL.getInt("numtemporada");
			i++;			
		}
		RdoSQL.close();
		return jugFairPlay;
	}
	public int[] obtenerJornadasDe(int unaTemporada)
	{
		int i=0;
		int[] jornadas= new int[maxJornadas];
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornadas WHERE numtemporada=unatemporada");
		while(RdoSQL.next() && i< maxJornadas){
			jornadas[i]=RdoSQL.getInt("numjornada");
		}
		RdoSQL.close();
		return jornadas;
	}
	public int obtenerJornadaAnterior(Date fecha) {
		int rdo=0;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT numjornada FROM jornada WHERE estajugada = 1 "
				+ "AND fecha < " + fecha + " ORDER BY fecha DESC");		
		if(RdoSQL.next()) rdo=RdoSQL.getInt("numjornada") ;
		RdoSQL.close();
		return rdo;
	}
	
	public int obtenerUltimaTemporada(){
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas()[0];
	}
	
	public int obtenerUltimaJornadaDe(int pLaTemporada)
	//pre:se obtiene la última jornada de la temporada recibida como parametro.
	//pos:si existe última jornada en esa temporada se devuelve, si no devuelve 0.
	{
		int laJornada=0;		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("Select numjornada FROM jornada WHERE numtemporada=pLaTemporada ORDER BY Fecha DESC");
		if(RdoSQL.next()){
			laJornada=RdoSQL.getInt("numjornada");
		}
		RdoSQL.close();
		return laJornada;
	}
	
}
