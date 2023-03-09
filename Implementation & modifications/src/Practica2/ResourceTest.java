package Practica2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Test de un Resource
 * 
 * @author CQFidalgo
 *
 */
public class ResourceTest {

	@Test
	public void testAdultBike() {
		Resource bici = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		assertEquals(bici.getDepositToPay(3.3), 3.3, 0);
	}

	@Test
	public void testChildBike() {
		Resource bici = new ChildBike("BH", "xyz", 12.55, 3, 7, "20");
		assertEquals(bici.getDepositToPay(3.3), 2.8, 0.02);
	}

	@Test
	public void testElectricBike() {
		Resource bici = new ElectricBike("BH", "xyz", 12.55, 3, 7, "L", 2.5, 24, 3.2);
		assertEquals(bici.getDepositToPay(3.3), 4, 0.1);
	}

	@Test
	public void testBike() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 24, 4.55);

		List<Resource> recursos = new LinkedList<Resource>();

		recursos.add(bici1);
		recursos.add(bici3);
		recursos.add(bici5);

		List<Double> depositosEsperados = new LinkedList<Double>();

		depositosEsperados.add(3.3);
		depositosEsperados.add(2.8);
		depositosEsperados.add(4.0);

		int i = 0;
		for (Resource recurso : recursos)
			assertEquals(depositosEsperados.get(i++), recurso.getDepositToPay(3.3), 0.1);
	}

	@Test
	public void testGroupPack() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "S");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 24, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 24, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 36, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 36, 4.55);

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

		Resource pack = new GroupPack(bicis);
		assertEquals(pack.getDepositToPay(3.3), suma, 0);
	}

	@Test
	public void testFamilyPack() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "S");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");

		ArrayList<Bike> bicis = new ArrayList<Bike>();
		bicis.add(bici1);
		bicis.add(bici2);
		bicis.add(bici3);
		bicis.add(bici4);

		double deposit = 3.3;
		double suma = 0;

		for (int i = 0; i < bicis.size(); i++) {
			suma += bicis.get(i).getDepositToPay(deposit);
		}

		suma *= 0.5; // porque es FamilyPack

		Resource pack = new FamilyPack(bicis);
		assertEquals(pack.getDepositToPay(3.3), suma, 0);
	}

	@Test
	public void testPack() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "S");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 24, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 24, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 36, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 36, 4.55);

		ArrayList<Bike> bicisFamily = new ArrayList<Bike>();
		bicisFamily.add(bici1);
		bicisFamily.add(bici2);
		bicisFamily.add(bici3);
		bicisFamily.add(bici4);

		ArrayList<Bike> bicisGroup = new ArrayList<Bike>();
		bicisGroup.add(bici1);
		bicisGroup.add(bici2);
		bicisGroup.add(bici3);
		bicisGroup.add(bici4);
		bicisGroup.add(bici5);
		bicisGroup.add(bici6);
		bicisGroup.add(bici7);
		bicisGroup.add(bici8);
		bicisGroup.add(bici9);
		bicisGroup.add(bici10);

		double deposit = 3.3;

		double suma1 = 0;

		for (int i = 0; i < bicisFamily.size(); i++) {
			suma1 += bicisFamily.get(i).getDepositToPay(deposit);
		}

		suma1 *= 0.5; // porque es FamilyPack

		double suma2 = 0;

		for (int i = 0; i < bicisGroup.size(); i++) {
			suma2 += bicisGroup.get(i).getDepositToPay(deposit);
		}

		suma2 *= 0.8; // porque es GroupPack

		Pack packFamily = new FamilyPack(bicisFamily);
		Pack packGroup = new GroupPack(bicisGroup);

		List<Resource> recursos = new LinkedList<Resource>();

		recursos.add(packFamily);
		recursos.add(packGroup);

		List<Double> depositosEsperados = new LinkedList<Double>();

		depositosEsperados.add(suma1);
		depositosEsperados.add(suma2);

		int i = 0;
		for (Resource recurso : recursos)
			assertEquals(depositosEsperados.get(i++), recurso.getDepositToPay(3.3), 0.1);

	}

	@Test
	public void testResource() {
		Bike bici1 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici2 = new AdultBike("BH", "xyz", 12.55, 3, 7, "S");
		Bike bici3 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici4 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici5 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 24, 4.55);
		Bike bici6 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "XL", 10.3, 24, 4.55);
		Bike bici7 = new AdultBike("BH", "xyz", 12.55, 3, 7, "L");
		Bike bici8 = new ChildBike("Bh", "abc", 7.5, 3, 5, "18");
		Bike bici9 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "L", 10.3, 36, 4.55);
		Bike bici10 = new ElectricBike("Bh", "abc", 7.5, 3, 5, "M", 10.3, 36, 4.55);

		ArrayList<Bike> bicisFamily = new ArrayList<Bike>();
		bicisFamily.add(bici1);
		bicisFamily.add(bici2);
		bicisFamily.add(bici3);
		bicisFamily.add(bici4);

		ArrayList<Bike> bicisGroup = new ArrayList<Bike>();
		bicisGroup.add(bici1);
		bicisGroup.add(bici2);
		bicisGroup.add(bici3);
		bicisGroup.add(bici4);
		bicisGroup.add(bici5);
		bicisGroup.add(bici6);
		bicisGroup.add(bici7);
		bicisGroup.add(bici8);
		bicisGroup.add(bici9);
		bicisGroup.add(bici10);

		double deposit = 3.3;

		double suma1 = 0;

		for (int i = 0; i < bicisFamily.size(); i++) {
			suma1 += bicisFamily.get(i).getDepositToPay(deposit);
		}

		suma1 *= 0.5; // porque es FamilyPack

		double suma2 = 0;

		for (int i = 0; i < bicisGroup.size(); i++) {
			suma2 += bicisGroup.get(i).getDepositToPay(deposit);
		}

		suma2 *= 0.8; // porque es GroupPack

		Pack packFamily = new FamilyPack(bicisFamily);
		Pack packGroup = new GroupPack(bicisGroup);

		List<Resource> recursos = new LinkedList<Resource>();

		recursos.add(bici1);
		recursos.add(bici3);
		recursos.add(bici5);
		recursos.add(packFamily);
		recursos.add(packGroup);

		List<Double> depositosEsperados = new LinkedList<Double>();

		depositosEsperados.add(3.3);
		depositosEsperados.add(2.8);
		depositosEsperados.add(4.0);
		depositosEsperados.add(suma1);
		depositosEsperados.add(suma2);

		int i = 0;
		for (Resource recurso : recursos)
			assertEquals(depositosEsperados.get(i++), recurso.getDepositToPay(3.3), 0.1);

	}

}
