package liga.Junits;

import static org.junit.Assert.*;
import liga.packControladoras.CatalogoJugadores;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoJugadoresTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetListaJugadores() {
		String[][] jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores[0][1].toString().equals("Erik Morán"));
		assertTrue(jugadores.length == 1);
	}

	@Test
	public void testGetJugadoresConvocables() {
		String[][] jugadores = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadores[0][1].toString().equals("Erik Morán"));
		assertTrue(jugadores.length == 1);
	}

	@Test
	public void testGetListaJugadoresConvocados() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListaJugadoresTitulares() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirJugadoresTitulares() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirJugadoresConvocados() {
		String[] jugadores = new String[1];
		jugadores[0] = "1";
		CatalogoJugadores.getCatalogoJugadores().anadirJugadoresConvocados(jugadores, "Athletic", "Real Sociedad", 1, 2);
		String[][] jugadoresConvocados = CatalogoJugadores.getCatalogoJugadores().getListaJugadores("Athletic");
		assertTrue(jugadoresConvocados[0][1].toString().equals("Erik Morán"));
		assertTrue(jugadoresConvocados.length == 1);
	}

	@Test
	public void testAnadirJugador() {
		assertFalse(CatalogoJugadores.getCatalogoJugadores().anadirJugador("Athletic", "Erik Morán", "5"));
	}

	@Test
	public void testModificarJugador() {
		assertFalse(CatalogoJugadores.getCatalogoJugadores().modificarJugador("1", "Athletic", "Erik Morán", "5"));
	}

	@Test
	public void testDarDeBajaJugador() {
		fail("Not yet implemented");
	}

}
