package Practica2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test de un AdultBike
 * 
 * @author CQFidalgo
 *
 */
public class AdultBikeTest {

	@Test
	public void testAdultBike() {
		AdultBike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		assertEquals(bici.getMarca(), "BH");
		assertEquals(bici.getModelo(), "xyz");
		assertEquals(bici.getPeso(), 12.55, 0);
		assertEquals(bici.getPlatos(), 3);
		assertEquals(bici.getPinones(), 7);
		assertEquals(bici.getTalla(), "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeMarcaNull() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike(null, "xyz", 12.55, 3, 7, "S");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeMarcaCadenaVacia() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("", "xyz", 12.55, 3, 7, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeModeloNull() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", null, 12.55, 3, 7, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeModeloCadenaVacia() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "", 12.55, 3, 7, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikePeso0() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 0.0, 3, 7, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikePesoNegativo() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", -1.0, 3, 7, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeCon0Platos() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, 0, 7, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeConPlatosNegativos() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, -1, 7, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeCon0Pinones() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 0, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeConPinonesNegativos() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, -1, "L");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeTallaNull() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, null);
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeTallaCadenaVacia() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeTallaDiferenteLetra() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "Y");
	}

	@Test(expected = AssertionError.class)
	public void testAdultBikeTallaChild() {
		@SuppressWarnings("unused")
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "12");
	}

	@Test
	public void testToString() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "S");
		String esperado = "\n  Tipo de bicicleta: Adulto\n  Id = " + bici.getId() + "\n  Marca = " + bici.getMarca()
				+ "\n  Modelo = " + bici.getModelo() + "\n  peso = " + bici.getPeso() + "kg\n  Número de platos = "
				+ bici.getPlatos() + "\n  Número de piñones = " + bici.getPinones() + "\n  Talla = " + bici.getTalla()
				+ "\n";
		assertEquals(esperado, bici.toString());

	}

	@Test
	public void testEquals() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "M");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "M");
		assertFalse(bici.equals(bici2));
	}

	@Test
	public void testEqualsMismoObject() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "XL");
		assertTrue(bici.equals(bici));
	}

	@Test(expected = AssertionError.class)
	public void testEqualsDiferenteMarca() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BA", "xyz", 12.55, 3, 7, "L");
		assertTrue(bici.equals(bici2));
	}

	@Test(expected = AssertionError.class)
	public void testEqualsDiferenteModelo() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xmz", 12.55, 3, 7, "L");
		assertTrue(bici.equals(bici2));
	}

	@Test(expected = AssertionError.class)
	public void testEqualsDiferentePeso() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 13.55, 3, 7, "L");
		assertTrue(bici.equals(bici2));
	}

	@Test(expected = AssertionError.class)
	public void testEqualsDiferentePlatos() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 5, 7, "L");
		assertTrue(bici.equals(bici2));
	}

	@Test(expected = AssertionError.class)
	public void testEqualsDiferentePinones() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 4, "L");
		assertTrue(bici.equals(bici2));
	}

	@Test(expected = AssertionError.class)
	public void testEqualsDiferenteTalla() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "S");
		assertTrue(bici.equals(bici2));
	}

	@Test
	public void testGetDepositToPayCorrecto() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");

		assertEquals(bici.getDepositToPay(3.3), 3.3, 0);
	}

	@Test(expected = AssertionError.class)
	public void testGetDepositToPayDeposito0() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");

		bici.getDepositToPay(0.0);
	}

	@Test(expected = AssertionError.class)
	public void testGetDepositToPayDepositoNegativo() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");

		bici.getDepositToPay(-3.0);
	}

	@Test
	public void testBike() {
		Bike bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		assertEquals(bici.getMarca(), "BH");
		assertEquals(bici.getModelo(), "xyz");
		assertEquals(bici.getPeso(), 12.55, 0);
		assertEquals(bici.getPlatos(), 3);
		assertEquals(bici.getPinones(), 7);
		assertEquals(bici.getTalla(), "L");
	}

}
