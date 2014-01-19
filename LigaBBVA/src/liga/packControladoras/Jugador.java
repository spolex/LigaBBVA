package liga.packControladoras;

public class Jugador 
{
	
	private String nombre;
	private String nombreEquipo;
	private int numSanciones;
	
	public Jugador(String pNom, String pNomEq, int pNumSan) 
	{
		this.nombre=pNom;
		this.nombreEquipo=pNomEq;
		this.numSanciones=pNumSan;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public int getNumSanciones() {
		return numSanciones;
	}
	

}