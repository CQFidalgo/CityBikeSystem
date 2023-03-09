package Practica1;

import static org.junit.Assert.*;

import org.junit.Test;

import Practica1.CityBikeParkingPoint;

public class CityBikeParkingPointTest {

	// http://www.arumeinformatica.es/utiles/convertir-coordenadas-gps/
	// https://www.coordenadas-gps.com/sistema-de-coordenadas **Explicacion**

	@Test
	public void testCityBikeParkingPointSinArgumento() {

		CityBikeParkingPoint c = new CityBikeParkingPoint();
		assertEquals(c.getTotalAnclajes(), 0);
		assertEquals(c.getId(), 0);
		assertArrayEquals(c.getAnclajes(), new boolean[0]);
		assertArrayEquals(c.getGPS(), new double[2], 0.0);
	}

	@Test
	public void testCityBikeParkingPointConArgumentosValidos() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, 9.9 });
		assertEquals(c.getTotalAnclajes(), 12);
		assertEquals(c.getId(), 2);
		assertArrayEquals(c.getAnclajes(), new boolean[12]);
		assertArrayEquals(c.getGPS(), new double[] { -9.9, 9.9 }, 0.0001);
	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPointCon0Anclajes() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(0, 2, new double[] { -9.9, 9.9 });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPointConAnclajesNegativos() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(-1, 2, new double[] { -9.9, 9.9 });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPointConId0() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 0, new double[] { -9.9, 9.9 });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPointConIdNegativa() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, -1, new double[] { -9.9, 9.9 });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPointConGDNoValido() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 3, new double[] { -9.9 });

	}

	@Test
	public void testCityBikeParkingPoint2ConArgumentosValidosPositivos() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });
		assertEquals(c.getTotalAnclajes(), 12);
		assertEquals(c.getId(), 2);
		assertArrayEquals(c.getGPS(), new double[] { 2.067778, 6.102500 }, 0.0001);
		assertArrayEquals(c.coordenadasEnGMS(), new String[][] { { "2", "4", "4.0", "N" }, { "6", "6", "9.0", "E" } });
	}

	@Test
	public void testCityBikeParkingPoint2ConArgumentosValidosNegativos() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "s" }, { "6", "6", "9.0000", "o" } });
		assertEquals(c.getTotalAnclajes(), 12);
		assertEquals(c.getId(), 2);
		assertArrayEquals(c.getGPS(), new double[] { -2.067778, -6.102500 }, 0.0001);
		assertArrayEquals(c.coordenadasEnGMS(), new String[][] { { "2", "4", "4.0", "S" }, { "6", "6", "9.0", "O" } });

	}

	@Test
	public void testCityBikeParkingPoint2ConArgumentosValidos0GMS() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "0", "0", "0.0000", "s" }, { "0", "0", "0.0000", "e" } });
		assertEquals(c.getTotalAnclajes(), 12);
		assertEquals(c.getId(), 2);
		assertArrayEquals(c.getGPS(), new double[] { 0.000000, 0.000000 }, 0.0001);
		assertArrayEquals(c.coordenadasEnGMS(), new String[][] { { "0", "0", "0.0", "N" }, { "0", "0", "0.0", "E" } });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPoint2Con0Anclajes() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(0, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPoint2ConAnclajesNegativos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(-1, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPoint2ConId0() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 0, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPoint2ConIdNegativa() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, -1, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });
	}

	@Test(expected = AssertionError.class)
	public void testCityBikeParkingPoint2ConGMSArrayNoValido() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 3, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "9.0000", "e" } });
	}

	@Test
	public void testSetIdCorrecta() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { 0.0, 0.0 });
		c.setId(3);
		assertEquals(c.getId(), 3);
	}

	@Test(expected = AssertionError.class)
	public void testSetId0() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, 9.9 });
		c.setId(0);
	}

	@Test(expected = AssertionError.class)
	public void testSetIdNegativa() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, 9.9 });
		c.setId(-1);
	}

	@Test
	public void testEstadoModuloValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		assertEquals(c.estadoModulo(2), false);
		assertEquals(c.estadoModulo(1), false);
	}

	@Test(expected = AssertionError.class)
	public void testEstadoModulo0() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.estadoModulo(0);
	}

	@Test(expected = AssertionError.class)
	public void testEstadoModuloNegativo() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.estadoModulo(-1);
	}

	@Test
	public void testEstadoModuloMaximo() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.estadoModulo(3);
	}

	@Test(expected = AssertionError.class)
	public void testEstadoModuloFueraDeRangoSuperior() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.estadoModulo(4);
	}

	@Test
	public void testNumeroAnclajesOcupadosAlCrear() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		assertEquals(c.numeroAnclajesOcupados(), 0);
	}

	@Test
	public void testNumeroAnclajesOcupadosConBicis() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.anclarBici(2);
		assertEquals(c.numeroAnclajesOcupados(), 1);
	}

	@Test
	public void testDesanclarBiciValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.anclarBici(1);
		assertTrue(c.estadoModulo(1));
		c.desanclarBici(1);
		assertFalse(c.estadoModulo(1));
	}

	@Test(expected = AssertionError.class)
	public void testDesanclarBiciModulo0() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.desanclarBici(0);
	}

	@Test(expected = AssertionError.class)
	public void testDesanclarBiciModuloNegativo() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.desanclarBici(-1);
	}

	@Test
	public void testDesanclarBiciModuloMaximo() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.anclarBici(3);
		assertTrue(c.estadoModulo(3));
		c.desanclarBici(3);
	}

	@Test(expected = AssertionError.class)
	public void testDesanclarBiciModuloFueraDeRangoSuperior() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.desanclarBici(4);
	}

	@Test(expected = AssertionError.class)
	public void testDesanclarBiciEstadoModuloFalse() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		assertFalse(c.estadoModulo(1));
		c.desanclarBici(1);
	}

	@Test
	public void testAnclarBiciValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		assertFalse(c.estadoModulo(1));
		c.anclarBici(1);
		assertTrue(c.estadoModulo(1));
	}

	@Test(expected = AssertionError.class)
	public void testAnclarBiciModulo0() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });

		c.anclarBici(0);
	}

	@Test(expected = AssertionError.class)
	public void testAnclarBiciModuloNegativo() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });

		c.anclarBici(-1);
	}

	@Test
	public void testAnclarBiciModuloMaximo() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		assertFalse(c.estadoModulo(3));
		c.anclarBici(3);
		assertTrue(c.estadoModulo(3));
	}

	@Test(expected = AssertionError.class)
	public void testAnclarBiciModuloFueraDeRangoSuperior() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.anclarBici(4);
	}

	@Test(expected = AssertionError.class)
	public void testAnclarBiciEstadoModuloTrue() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { -9.9, 9.9 });
		c.anclarBici(1);
		assertTrue(c.estadoModulo(1));
		c.anclarBici(1);
	}

	@Test
	public void testDistancia() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { 0.0, 0.0 });
		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 2, new double[] { 1.0, 1.0 });

		double distanciaFinal = 157.40;
		assertEquals(c.distancia(d), distanciaFinal, 0.2);

	}

	@Test(expected = AssertionError.class)
	public void testDistanciaOtroParkingNoInicializado() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { 0.0, 0.0 });
		CityBikeParkingPoint d = new CityBikeParkingPoint();

		c.distancia(d);
	}

	// http://www.arumeinformatica.es/utiles/convertir-coordenadas-gps/
	@Test
	public void testDistanciaDesdeCoordenadaGDValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { 0.0, 0.0 });
		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 2, new String[][] { { "1", "0", "0.0000", "n" }, { "1", "0", "0.0000", "e" } });

		double distanciaFinal = 157.40;
		assertEquals(c.distanciaDesdeCoordenada(d.coordenadasEnGMS()), distanciaFinal, 0.2);

	}

	@Test(expected = AssertionError.class)
	public void testDistanciaDesdeCoordenadaGDArrayNoValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new double[] { 0.0, 0.0 });
		double[] gd = new double[1];
		gd[0] = 0.0;

		c.distanciaDesdeCoordenada(gd);
	}

	@Test
	public void testDistanciaDesdeCoordenadaGMSValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new String[][] { { "0", "0", "0.0000", "n" }, { "0", "0", "0.0000", "o" } });
		CityBikeParkingPoint d = new CityBikeParkingPoint(3, 2, new String[][] { { "1", "0", "0.0000", "s" }, { "1", "0", "0.0000", "e" } });
		double distanciaFinal = 157.40;

		assertEquals(c.distanciaDesdeCoordenada(d.coordenadasEnGMS()), distanciaFinal, 0.2);
	}

	@Test(expected = AssertionError.class)
	public void testDistanciaDesdeCoordenadaGMSArrayNoValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(3, 2, new String[][] { { "0", "0", "0.0000", "s" }, { "0", "0", "0.0000", "o" } });
		String[][] gms = new String[][] { { "0", "0", "0.0000", "n" } };

		c.distanciaDesdeCoordenada(gms);
	}

	@Test
	public void testConvertirGMSaGDValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "s" }, { "6", "6", "9.0000", "e" } });
		CityBikeParkingPoint d = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "o" } });

		assertArrayEquals(c.convertirGMSaGD(c.coordenadasEnGMS()), new double[] { -2.067778, 6.102500 }, 0.0001);
		assertArrayEquals(d.convertirGMSaGD(d.coordenadasEnGMS()), new double[] { 2.067778, -6.102500 }, 0.0001);

	}

	@Test(expected = AssertionError.class)
	public void testConvertirGMSaGDNoValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint();
		String[][] gms = { { "2", "4", "4.0000", "n" } };
		c.convertirGMSaGD(gms);
	}

	@Test
	public void testConvertirGDaGMSValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, -9.9 });
		assertArrayEquals(c.convertirGDaGMS(c.getGPS()), new String[][] { { "9", "54", "0.0", "S" }, { "9", "54", "0.0", "O" } });

	}

	@Test(expected = AssertionError.class)
	public void testConvertirGDaGMSNoValido() {
		CityBikeParkingPoint c = new CityBikeParkingPoint();
		double[] gd = { 0.0 };
		c.convertirGDaGMS(gd);

	}

	@Test
	public void testValidarGDConArgumentosValidosLatitudYLongitudMinima() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -90.0000, -180.0000 });
		assertArrayEquals(c.getGPS(), new double[] { -90.0000, -180.0000 }, 0.0);
	}

	@Test
	public void testValidarGDConArgumentosValidosLatitudYLongitudMaximas() {

		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { 90.0000, 180.0000 });
		assertArrayEquals(c.getGPS(), new double[] { 90.0000, 180.0000 }, 0.0001);
	}

	@Test(expected = AssertionError.class)
	public void testValidarGDLatitudFueraDeRangoMinimo() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -90.1, 9.9 });
	}

	@Test(expected = AssertionError.class)
	public void testValidarGDLongitudFueraDeRangoMinimo() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, -180.1 });
	}

	@Test(expected = AssertionError.class)
	public void testValidarGDLatitudFueraDeRangoMaximo() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { 90.1, 9.9 });
	}

	@Test(expected = AssertionError.class)
	public void testValidarGDLongitudFueraDeRangoMaximo() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { -9.9, 180.1 });
	}

	@Test(expected = AssertionError.class)
	public void testValidarGDTamanoArrayDiferentede2() {

		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new double[] { 9.0 });
	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSDireccionLatitudLetraIncorrecta() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "t" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSDireccionLatitudLetraNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "" }, { "6", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSDireccionLatitudSinLetra() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "8" }, { "6", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSGradosLatitudGMSNegativos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "-2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSMinutosLatitudGMSNegativos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "-4", "4.0000", "s" }, { "6", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSSegundosLatitudGMSNegativos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "-4.0000", "s" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSGradosLatitudGMSDemasiadoAltos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "91", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSMinutosLatitudGMSDemasiadoAltos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "60", "4.0000", "n" }, { "6", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSSegundosLatitudGMSDemasiadoAltos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "60.0000", "s" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSGradosLatitudGMSNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "", "4", "4.0000", "n" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSMinutosLatitudGMSNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "", "4.0000", "n" }, { "6", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSSegundosLatitudGMSNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "", "s" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSTamanoLatitudDiferentede4() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "s" }, { "6", "6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSDireccionLongitudLetraIncorrecta() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "t" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSDireccionLongitudLetraNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSDireccionLongitudSinLetra() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "9.0000", "6" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSGradosLongitudGMSNegativos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "-6", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSMinutosLongitudGMSNegativos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "s" }, { "6", "-6", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSSegundosLongitudGMSNegativos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "-9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSGradosLongitudGMSDemasiadoAltos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "s" }, { "181", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSMinutosLongitudGMSDemasiadoAltos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "s" }, { "6", "60", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSSegundosLongitudGMSDemasiadoAltos() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "60.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSGradosLongitudGMSNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "s" }, { "", "6", "9.0000", "o" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSMinutosLongitudGMSNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "s" }, { "6", "", "9.0000", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSSegundosLongitudGMSNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSTamanoLongitudDiferentede4() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" }, { "6", "6", "e" } });

	}

	@Test(expected = AssertionError.class)
	public void testValidarGMSTamanoFilasMatrizDiferentede2() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint c = new CityBikeParkingPoint(12, 2, new String[][] { { "2", "4", "4.0000", "n" } });

	}

}