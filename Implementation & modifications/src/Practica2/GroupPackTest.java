package Practica2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import Practica2.Bike;

/**
 * Test de un GroupPack
 * 
 * @author CQFidalgo
 *
 */
public class GroupPackTest {

	@Test
	public void testGroupPack() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		GroupPack pack = new GroupPack(bicis);
		assertEquals(pack.getPack(), bicis);
	}

	@Test(expected = AssertionError.class)
	public void testGroupPackPocasBicis() {

		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);

		@SuppressWarnings("unused")
		GroupPack pack = new GroupPack(bicis);
	}

	@Test
	public void testToString() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);

		String esperado = "\n  Tipo de pack: Grupo \n  Número de bicicletas = " + pack.getNBike() + "\n  packCompleto: "
				+ pack.getPack() + "\n";
		assertEquals(esperado, pack.toString());

	}

	@Test
	public void testEqualsObjectTrue() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		assertTrue(pack.equals(pack));
	}

	@Test(expected = AssertionError.class)
	public void testEqualsObjectUnaBiciMas() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici11 = new AdultBike("BH", "xyz", 13.12, 3, 6, "XL");

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);

		bicis.add(bici11);
		Pack pack2 = new GroupPack(bicis);

		assertTrue(pack.equals(pack2));

	}

	@Test(expected = AssertionError.class)
	public void testEqualsObjectArrayDiferente() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici11 = new AdultBike("BH", "xyz", 13.12, 3, 6, "XL");

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);

		bicis.remove(bici10);
		bicis.add(bici11);
		Pack pack2 = new GroupPack(bicis);

		assertTrue(pack.equals(pack2));

	}

	@Test
	public void testRemoveBike() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici11 = new AdultBike("BH", "xyz", 13.12, 3, 6, "XL");

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);
		bicis.add(bici11);

		Pack pack = new GroupPack(bicis);
		pack.removeBike(bici11);
		bicis.remove(bici11);
		assertEquals(pack.getPack(), bicis);
	}

	@Test(expected = AssertionError.class)
	public void testRemoveBikeNoPertenece() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici11 = new AdultBike("BH", "xyz", 13.12, 3, 6, "XL");
		Bike bici12 = new AdultBike("BH", "xyz", 13.12, 3, 6, "XL");

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);
		bicis.add(bici11);

		Pack pack = new GroupPack(bicis);
		pack.removeBike(bici12);
	}

	@Test(expected = AssertionError.class)
	public void testRemoveBikePocasBicis() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		pack.removeBike(bici1);
	}

	@Test
	public void testGetDepositToPayGroupPack() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		double deposit = 3.3;
		double suma = 0;

		for (int i = 0; i < bicis.size(); i++) {
			suma += bicis.get(i).getDepositToPay(deposit);
		}

		suma *= 0.8; // porque es GroupPack

		Pack pack = new GroupPack(bicis);
		assertEquals(pack.getDepositToPay(3.3), suma, 0);
	}

	@Test(expected = AssertionError.class)
	public void testGetDepositToPayGroupPack0() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		pack.getDepositToPay(0.0);
	}

	@Test
	public void testPack() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		assertEquals(pack.getPack(), bicis);
	}

	@Test
	public void testPertenece() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		assertTrue(pack.pertenece(bici1.getId()));
	}

	@Test(expected = AssertionError.class)
	public void testNoPertenece() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici200 = new ElectricBike("Bh", "mko", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		assertTrue(pack.pertenece(bici200.getId()));
	}

	@Test(expected = AssertionError.class)
	public void testPertenece0() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		assertTrue(pack.pertenece(0));
	}

	@Test
	public void testAddBikeNoPertenece() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici11 = new AdultBike("BH", "xyz", 13.12, 3, 6, "XL");

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		pack.addBike(bici11);
		bicis.add(bici11);
		assertEquals(pack.getPack(), bicis);
	}

	@Test(expected = AssertionError.class)
	public void testAddBikePertenece() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "S", 10.3, 2.4, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 2.4, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 2.4, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 2.4, 4.55);

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);
		bicis.add(bici5);
		bicis.add(bici6);
		bicis.add(bici7);
		bicis.add(bici8);
		bicis.add(bici9);
		bicis.add(bici10);

		Pack pack = new GroupPack(bicis);
		pack.addBike(bici10);
	}

}
