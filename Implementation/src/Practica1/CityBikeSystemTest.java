package Practica1;

import static org.junit.Assert.*;
import fabricante.externo.tarjetas.*;
import Practica1.CityBikeParkingPoint;
import Practica1.CityBikeSystem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CityBikeSystemTest {

	@Test
	public void testCityBikeSystemInicializarSinArgumentos() {
		CityBikeSystem sistema = new CityBikeSystem();

		assertEquals(sistema.getPrecio(), 0.0, 0.2);
		assertEquals(sistema.getAparcamientosCiudad().size(), 0);
	}

	@Test
	public void testCityBikeSystemInicializarConArgumentosValidos() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, 9.9 });
		CityBikeParkingPoint d = new CityBikeParkingPoint(11, 3, new double[] { -10.9, 10.9 });
		
		List<CityBikeParkingPoint> aparcamientosCiudad = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCiudad.add(c);
		aparcamientosCiudad.add(d);

		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.addAparcamiento(c);
		sistema.addAparcamiento(d);

		assertEquals(sistema.getPrecio(), 2.2, 0.0);
		assertEquals(sistema.getAparcamientosCiudad().size(), 2);
	}

	@Test(expected = AssertionError.class)
	public void testCityBikeSystemInicializarConPrecioNegativo() {
		@SuppressWarnings("unused")
		CityBikeSystem sistema = new CityBikeSystem(-2.2);
	}

	@Test
	public void testSetPrecio() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.setPrecio(3.3);
		assertEquals(sistema.getPrecio(), 3.3, 0.0);
	}

	@Test(expected = AssertionError.class)
	public void testSetPrecio0() {
		CityBikeSystem sistema = new CityBikeSystem(5.0);
		sistema.setPrecio(0.0);
	}

	@Test(expected = AssertionError.class)
	public void testSetPrecioNegativo() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.setPrecio(-3.3);
	}

	@Test
	public void testNuevoAparcamientoGDConArgumentosValidos() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		assertEquals(sistema.getAparcamientosCiudad().size(), 0);

		sistema.nuevoAparcamientoGD(12, 2, new double[] { -9.9, 9.9 });

		assertEquals(sistema.getAparcamientosCiudad().size(), 1);
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGDConAnclajes0() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(0, 2, new double[] { -9.9, 9.9 });
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGDConAnclajesNegativos() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(-3, 2, new double[] { -9.9, 9.9 });
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGDConId0() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(3, 0, new double[] { -9.9, 9.9 });
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGDConIdNegativa() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(3, -2, new double[] { -9.9, 9.9 });
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGDConIdIncorrecta() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(4, 2, new double[] { -19.9, 19.9 });
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoConGDNoInicializado() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(4, 2, new double[] {});
	}

	@Test
	public void testNuevoAparcamientoGMSConArgumentosValidos() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		assertEquals(sistema.getAparcamientosCiudad().size(), 0);

		sistema.nuevoAparcamientoGMS(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

		assertEquals(sistema.getAparcamientosCiudad().size(), 1);
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGMSConAnclajes0() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGMS(0, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGMSConAnclajesNegativos() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGMS(-4, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGMSConId0() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGMS(4, 0, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGMSConIdNegativa() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGMS(4, -2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoGMSConIdIncorrecta() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGMS(4, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });
		sistema.nuevoAparcamientoGMS(3, 2, new String[][] { { "20", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoConGMSNoInicializado() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGMS(4, 2, new String[][] {});
	}

	@Test(expected = AssertionError.class)
	public void testNuevoAparcamientoConGMSNoInicializadointernamente() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGMS(4, 2, new String[][] { {}, {} });
	}

	@Test(expected = AssertionError.class)
	public void testAddAparcamientoIdRepetida() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, 9.9 });
		sistema.addAparcamiento(c);
		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 2, new double[] { -10.9, 10.9 });
		sistema.addAparcamiento(d);
	}

	@Test
	public void testEliminarAparcamientoIdCorrecta() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 1, new double[] { -10.9, 10.9 });
		
		sistema.addAparcamiento(c);
		sistema.addAparcamiento(d);

		sistema.eliminarAparcamiento(2);

		assertFalse(sistema.comprobarId(2));
	}

	@Test(expected = AssertionError.class)
	public void testEliminarAparcamientoId0() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);

		sistema.eliminarAparcamiento(0);
	}

	@Test(expected = AssertionError.class)
	public void testEliminarAparcamientoIdNegativa() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);

		sistema.eliminarAparcamiento(-1);
	}

	@Test(expected = AssertionError.class)
	public void testEliminarAparcamientoIdNoExiste() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 1, new double[] { -10.9, 10.9 });
		
		sistema.addAparcamiento(c);
		sistema.addAparcamiento(d);

		sistema.eliminarAparcamiento(4);
	}

	@Test
	public void testComprobarIdConArgumentosValidos() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		assertTrue(sistema.comprobarId(2));
	}

	@Test(expected = AssertionError.class)
	public void testComprobarId0() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		assertTrue(sistema.comprobarId(0));
	}

	@Test(expected = AssertionError.class)
	public void testComprobarIdNegativa() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		assertTrue(sistema.comprobarId(-2));
	}

	@Test(expected = AssertionError.class)
	public void testComprobarIdNoExiste() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		assertTrue(sistema.comprobarId(3));
	}

	@Test
	public void testConEspaciosDisponibles() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		sistema.addAparcamiento(c);
		sistema.devolverBicicleta(tarjeta, 2, 1);
		List<CityBikeParkingPoint> aparcamientosConHuecos = new ArrayList<CityBikeParkingPoint>();
		aparcamientosConHuecos.add(c);

		assertEquals(sistema.conEspaciosDisponibles(), aparcamientosConHuecos);
	}

	@Test
	public void testConEspaciosDisponiblesLleno() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);

		assertEquals(sistema.conEspaciosDisponibles().size(), 0.0, 0.0);
		sistema.addAparcamiento(c);
		sistema.devolverBicicleta(tarjeta, 2, 1);
		sistema.devolverBicicleta(tarjeta, 2, 2);
		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(sistema.conEspaciosDisponibles().size(), 0.0, 0.0);

	}

	@Test
	public void testConBicicletasDisponibles() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		sistema.addAparcamiento(c);
		sistema.devolverBicicleta(tarjeta, 2, 2);
		List<CityBikeParkingPoint> aparcamientosConBicis = new ArrayList<CityBikeParkingPoint>();
		aparcamientosConBicis.add(c);

		assertEquals(sistema.conBicicletasDisponibles(), aparcamientosConBicis);
	}

	@Test
	public void testConBicicletasDisponiblesVacio() {
		CityBikeSystem sistema = new CityBikeSystem(2.2);
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });

		assertEquals(sistema.conBicicletasDisponibles().size(), 0.0, 0.0);
		sistema.addAparcamiento(c);
		assertEquals(sistema.conBicicletasDisponibles().size(), 0.0, 0.0);
	}

	@Test
	public void testAparcamientosCercanosGDConArgumentosValidos() {

		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 2, new double[] { 1.0, 1.0 });
		CityBikeParkingPoint e = new CityBikeParkingPoint(3, 5, new double[] { 40.0, 40.0 });

		// La distancia entre d y el 0,0 es 157.40

		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.addAparcamiento(d);
		sistema.addAparcamiento(e);

		List<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCercanos.add(d);

		assertEquals(sistema.aparcamientosCercanosGD(new double[] { 0.0, 0.0 }, 250.50), aparcamientosCercanos);
		assertEquals(sistema.aparcamientosCercanosGD(new double[] { 0.0, 0.0 }, 157.4), aparcamientosCercanos);

	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGDConRadio0() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { 0.0, 0.0 });
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { 1.0, 1.0 });
		List<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCercanos.add(c);
		// La distancia entre esos dos aparcamientos es 157.40

		sistema.aparcamientosCercanosGD(c.getGPS(), 0);
	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGDConRadioNegativo() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { 0.0, 0.0 });
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { 1.0, 1.0 });
		List<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCercanos.add(c);
		// La distancia entre esos dos aparcamientos es 157.40

		sistema.aparcamientosCercanosGD(c.getGPS(), -1);
	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGDDiferente() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);

		sistema.aparcamientosCercanosGD(new double[] { 0.9 }, 3.4);
	}

	@Test
	public void testAparcamientosCercanosGMSConArgumentosValidos() {

		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 2, new String[][] { { "0", "0", "0.0000", "n" }, { "0", "0", "0.0000", "o" } });
		CityBikeParkingPoint e = new CityBikeParkingPoint(3, 5, new String[][] { { "5", "5", "5.0000", "s" }, { "0", "25", "0.0000", "e" } });

		// La distancia entre d y 1,1 es 157.40

		CityBikeSystem sistema = new CityBikeSystem(2.2);
		sistema.addAparcamiento(d);
		sistema.addAparcamiento(e);

		List<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCercanos.add(d);

		assertEquals(sistema.aparcamientosCercanosGMS( new String[][] { { "1", "0", "0.0000", "n" }, { "1", "0", "0.0000", "e" } }, 250.50),aparcamientosCercanos);
		assertEquals(sistema.aparcamientosCercanosGMS( new String[][] { { "1", "0", "0.0000", "n" }, { "1", "0", "0.0000", "e" } }, 157.4),aparcamientosCercanos);
	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGMSConRadio0() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { 0.0, 0.0 });
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "1", "0", "0.0000", "n" }, { "1", "0", "0.0000", "e" } });
		List<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCercanos.add(c);
		// La distancia entre esos dos aparcamientos es 157.40

		sistema.aparcamientosCercanosGMS(c.coordenadasEnGMS(), 0);
	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGMSConRadioNegativo() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { 0.0, 0.0 });
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "1", "0", "0.0000", "n" }, { "1", "0", "0.0000", "e" } });
		List<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCercanos.add(c);
		// La distancia entre esos dos aparcamientos es 157.40

		sistema.aparcamientosCercanosGMS(c.coordenadasEnGMS(), -1);
	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGMSSinElementoEnLatitud() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { 0.0, 0.0 });

		sistema.aparcamientosCercanosGMS(new String[][] { { "2", "3.0000", "n" }, { "0", "0", "0.0000", "e" } }, 250);
	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGMSSinElementoEnLongitud() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { 0.0, 0.0 });

		sistema.aparcamientosCercanosGMS(new String[][] { { "2", "0", "3.0000", "n" }, { "0", "0.0000", "e" } }, 250);
	}

	@Test(expected = AssertionError.class)
	public void testAparcamientosCercanosGMSSinLongitud() {
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { 0.0, 0.0 });

		sistema.aparcamientosCercanosGMS(new String[][] { { "2", "4", "3.0000", "n" } }, 250);
	}

	@Test
	public void testAlquilarBicicletaConArgumentosValidos() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 2, 3);

		assertEquals(tarjeta.getSaldoActual(), 3.0, 0.01);
	}

	@Test
	public void testAlquilarBicicletaIgualPrecioQueSaldo() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 0.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 2.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 2, 3);

		assertEquals(tarjeta.getSaldoActual(), 0.0, 0.01);
	}

	@Test(expected = AssertionError.class)
	public void testAlquilarBicicletaConId0() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 0, 3);
	}

	@Test(expected = AssertionError.class)
	public void testAlquilarBicicletaConIdNegativa() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, -1, 3);

	}

	@Test(expected = AssertionError.class)
	public void testAlquilarBicicletaConIdIncorrecta() { // No existe en el
															// sistema
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 4, 3);
	}

	@Test(expected = AssertionError.class)
	public void testAlquilarBicicletaMasPrecioQueSaldo() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 0.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 2.0, 0.01);

		sistema.setPrecio(4.0);
		assertEquals(sistema.getPrecio(), 4.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 2, 3);

	}

	@Test(expected = AssertionError.class)
	public void testAlquilarBicicletaAnclaje0() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 4, 0);

	}

	@Test(expected = AssertionError.class)
	public void testAlquilarBicicletaAnclajeNegativo() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 4, -1);

	}

	@Test(expected = AssertionError.class)
	public void testAlquilarBicicletaAnclajeRangoMaximo() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 3.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
		assertEquals(tarjeta.getSaldoActual(), 5.0, 0.01);

		sistema.alquilarBicicleta(tarjeta, 4, 4);

	}

	@Test
	public void testDevolverBicicletaConArgumentosValidos() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 3);
	}

	@Test(expected = AssertionError.class)
	public void testDevolverBicicletaConId0() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 0, 3);
	}

	@Test(expected = AssertionError.class)
	public void testDevolverBicicletaConIdNegativa() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, -1, 3);
	}

	@Test(expected = AssertionError.class)
	public void testDevolverBicicletaConIdIncorrecta() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });
		sistema.nuevoAparcamientoGD(3, 1, new double[] { -19.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 4, 3);
	}

	@Test(expected = AssertionError.class)
	public void testDevolverBicicletaConAnclaje0() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 0);
	}

	@Test(expected = AssertionError.class)
	public void testDevolverBicicletaConAnclajeNegativo() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, -1);
	}

	@Test(expected = AssertionError.class)
	public void testDevolverBicicletaConAnclajeRangoMaximo() {
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894", 5.0);
		CityBikeSystem sistema = new CityBikeSystem(2.0);
		sistema.nuevoAparcamientoGD(3, 2, new double[] { -9.9, 9.9 });

		sistema.devolverBicicleta(tarjeta, 2, 4);
	}

}
