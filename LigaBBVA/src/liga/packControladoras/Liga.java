package liga.packControladoras;

/**MAE patron fachadas
 *
 */
public class Liga 
{
	private static Liga miLiga=new Liga();
	
	private Liga(){
		
	}
	public static Liga getMiLiga(){
		return miLiga;
	}
	
	public int obtenerUltimaTemporada(){
		return 0;
		
	}
	
	public Jugador obtenerJugadorFairplay(int codTemporada)
	{
		return CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerjugadorFairPlay(codTemporada);
	}
}
