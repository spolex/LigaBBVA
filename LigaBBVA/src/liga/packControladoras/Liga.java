package liga.packControladoras;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import liga.packModelo.ListaArbitros;
import liga.packModelo.ListaEquipos;

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
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaTemporada();
		
	}
	
	public ArrayList<String> obtenerJugadorFairplay(int pNumTemporada)
	{
		return CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerJugadorFairPlay(pNumTemporada);
	}
	public ArrayList<String> obtenerEquipoFairPlay(int pNumTemporada){
		return CatalogoEquipos.getMisEquipos().obtenerEquipoFairPlay(pNumTemporada);
	}
	
	/*****************************************/
	/* Métodos para la gestión de jugadores. */
	/*****************************************/
	
	private int obtenerJornadaAnterior(Date fecha) {
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerJornadaAnterior(fecha); 
	}
	
	private int obtenerJornadaAAJugar(Date fecha) {
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerJornadaAJugar(fecha); 
	}
	
	private String[] obtenerEquiposJornada(int temporada, int jornada, String equipo) {
		String[] equipos = new String[2];
		return equipos;
	}
	
	public String[][] getListaJugadores(String equipo) {
		return CatalogoJugadores.getCatalogoJugadores().getListaJugadores(equipo);
	}
	
	public String[][] getJugadoresConvocables(Date fecha, String equipo) {
		return CatalogoJugadores.getCatalogoJugadores().getJugadoresConvocables(this.obtenerUltimaTemporada(), this.obtenerJornadaAnterior(fecha), equipo);
	}
	
	public String[][] getJugadoresConvocados(Date fecha, String equipo) {
		return CatalogoJugadores.getCatalogoJugadores().getListaJugadoresConvocados(this.obtenerUltimaTemporada(), this.obtenerJornadaAAJugar(fecha), equipo);
	}
	
	public String[][] getJugadoresTitulares(Date fecha, String equipo) {
		return CatalogoJugadores.getCatalogoJugadores().getListaJugadoresTitulares(this.obtenerUltimaTemporada(), this.obtenerJornadaAAJugar(fecha), equipo);
	}
	
	public void anadirJugadoresTitulares(String[] jugadoresTitulares, Date fecha, String equipo) {
		int temporada = this.obtenerUltimaTemporada(), jornada = this.obtenerJornadaAAJugar(fecha);
		String[] equipos = this.obtenerEquiposJornada(temporada, jornada, equipo);
		CatalogoJugadores.getCatalogoJugadores().anadirJugadoresTitulares(jugadoresTitulares, equipos[1], equipos[2], temporada, jornada);
	}
	
	public void anadirJugadoresConvocados(String[] jugadoresConvocados, Date fecha, String equipo) {
		int temporada = this.obtenerUltimaTemporada(), jornada = this.obtenerJornadaAAJugar(fecha);
		String[] equipos = this.obtenerEquiposJornada(temporada, jornada, equipo);
		CatalogoJugadores.getCatalogoJugadores().anadirJugadoresTitulares(jugadoresConvocados, equipos[1], equipos[2], temporada, jornada);
	}
	
	public boolean anadirJugador(String equipo, String nombreJugador, String dorsal) {
		return CatalogoJugadores.getCatalogoJugadores().anadirJugador(equipo, nombreJugador, dorsal);
	}
	
	public boolean modificarJugador(String codJug, String equipo, String nombreJugador, String dorsal) {
		return CatalogoJugadores.getCatalogoJugadores().modificarJugador(codJug, equipo, nombreJugador, dorsal);
	}
	
	public void darDeBajaJugador(String codJug) {
		CatalogoJugadores.getCatalogoJugadores().darDeBajaJugador(codJug);
	}
	
	/************************************************/
	
	public ArrayList<Integer> obtenerTemporadas() {
		
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerTemporadas();
	}
	public int obtenerUltimaJornadaDe(int pLaTemporada)
	{
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerUltimaJornadaDe(pLaTemporada);
	}
	public String[] obtenerClasificacion(int pNumTemporada,int pNumJornada){
		return CatalogoClasificacion.getMiCatalogoClasificacion().obtenerClasificacion(pNumTemporada, pNumJornada);
	}
	public int[] obtenerEstadisticas(int elJugador){
		return CatalogoEstadisticasJugador.getMiCatalogoEstJug().obtenerEstadisticasJugador(elJugador);
	}
	public ArrayList<Integer> obtenerJornadasDe(int pNumTemporada){
		return CatalogoTemporadas.getMiCatalogoTemporadas().obtenerJornadasDe(pNumTemporada);
	}
	
	public void inicializarTemporada(ListaEquipos pListaEquipos, ListaArbitros pListaArbitros, GregorianCalendar pFecha, int pNumTemp)
	{
		CatalogoTemporadas.getMiCatalogoTemporadas().inicializarTemporada(pListaEquipos, pListaArbitros, pFecha, pNumTemp);
	}
	
	public boolean identificarse(String id, String pass)
	{
		return CatalogoUsuarios.getMiCatalogoUsuarios().identificarse(id, pass);
	}
	
	public String obtenerTipo(String id)
	{
		return CatalogoUsuarios.getMiCatalogoUsuarios().obtenerTipo(id);
	}
	
	public String obtenerPregunta(String id)
	{
		return CatalogoUsuarios.getMiCatalogoUsuarios().obtenerPregunta(id);
	}
	
	public String recuperarPass(String id, String resp)
	{
		return CatalogoUsuarios.getMiCatalogoUsuarios().recuperarPass(id, resp);
	}
	
	public boolean cambiarPass(String id, String passAnt, String passN, String preg, String resp)
	{
		return CatalogoUsuarios.getMiCatalogoUsuarios().cambiarPass(id, passAnt, passN, preg, resp);
	}
	
	public String obtenerEquipoDe(String id)
	{
		return CatalogoUsuarios.getMiCatalogoUsuarios().obtenerEquipoDe(id);
	}
	
	/**
	 * Buscamos si existe o no un equipo basado en el nombre que recibe
	 * @param nombreEquipo el nombre del equipo
	 */
	
	public boolean buscarSiExiste(String pNombreEquipo) {
		return CatalogoEquipos.getMisEquipos().buscarSiExiste(pNombreEquipo);
	}
	
	/**
	 * Añadimos un nuevo equipo en la BD
	 * @param pNombreEquipo el nombre del equipo
	 * @param pNombreProvincia la provincia de procedencia
	 * @param pPresupuesto el presupuesto del equipo
	 */
	
	public void anadirEquipo(String pNombreEquipo,String pNombreProvincia, String pPresupuesto) {
		CatalogoEquipos.getMisEquipos().anadirEquipo(pNombreEquipo, pNombreProvincia, pPresupuesto);
	}
	
	/**
	 * Se encarga de obtener todos lo nombres de los equipos
	 * 
	**/
	
	public ArrayList<String> obtenerNombresEquipos() {
		return CatalogoEquipos.getMisEquipos().obtenerNombresEquipos();
	}
	

	/**
	 * Obtiene los datos relativos a un equipo dado su nombre.
	 * 
	 * @param pNombre el nombre del equipo.
	 */
	
	public ArrayList<String> buscarEquipo(String pNombre) {
		return CatalogoEquipos.getMisEquipos().buscarEquipo(pNombre);
	}
	
	/**
	 * Se encarga de buscar si existe o no un usuario en el sistema.
	 * 
	 * @param pUnUsuario el nombre del usuario que deseamos buscar.
	 */
	
	public boolean buscarUnUsuario(String pUnUsuario) {
		return CatalogoUsuarios.getMiCatalogoUsuarios().buscarUnUsuario(pUnUsuario);
	}
	
	/**
	 * Actualizamos el admin y password de un equipo determinado
	 * 
	 * @param pUnUsuario el nombre del usuario
	 * @param pUnaContraseña la contraseña
	 * @param pNombreUsuario el nombre del anterior usuario.
	 */
	public void actualizarAdminEquipo(String pUnUsuario,String pUnaContrasena,String pNombreUsuario) {
		CatalogoUsuarios.getMiCatalogoUsuarios().actualizarAdminEquipo(pUnUsuario, pUnaContrasena, pNombreUsuario);
	}
	
	/**
	 * Obtiene los arbitros de la temporada en forma de objetos del modelo
	 * @param numUltimaTemporada
	 * la temporada deseada
	 * @return
	 * los arbitros que la conforman
	 */
	public ListaArbitros obtenerArbitrosTemporada(int pNumTemp) {
		// TODO Auto-generated method stub
		return CatalogoArbitros.getMiCatalogoArbitros().obtenerArbitrosTemporada(pNumTemp);
	}
	
	/**
	 * Obtiene todos los arbitros de la liga en una matriz
	 * @return
	 */
	public ArrayList<String[]> obtenerArbitros() {
		return CatalogoArbitros.getMiCatalogoArbitros().obtenerArbitros();
	}
	
	/**
	 * Obtiene todoslos equipos de la liga en una matriz
	 * @return
	 */
	public ArrayList<String[]> obtenerEquipos() {
		return CatalogoEquipos.getMisEquipos().obtenerEquipos();
	}
}
