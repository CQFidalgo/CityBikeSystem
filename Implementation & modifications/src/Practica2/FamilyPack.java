package Practica2;

import java.util.ArrayList;

/**
 * Implementacion de FamilyPack como tipo particular de la clase Pack
 * 
 * @author CQFidalgo
 *
 */

public class FamilyPack extends Pack {

	/**
	 * Inicializacion de FamilyPark
	 * 
	 * @param nBike
	 * 
	 * @assert.pre En los packs de familia han de alquilarse minimo 4 bicis
	 * @assert.pre En los packs de familia ha de haber como minimo 2 bicis de
	 *             nino
	 */
	public FamilyPack(ArrayList<Bike> Bikes) {
		super(Bikes);
		assert Bikes.size() > 3;
		assert bicisNino(Bikes.size());

	}

	// Metodo que comprueba si hay suficientes bicis de niño en un pack
	private boolean bicisNino(int nBike) {
		int nInfantiles = 0;
		boolean suficientesBicis = false;

		for (int i = 0; i < nBike; i++) {
			if (Integer.valueOf(super.getPack().get(i).getTalla()) == 12
					|| Integer.valueOf(super.getPack().get(i).getTalla()) == 14
					|| Integer.valueOf(super.getPack().get(i).getTalla()) == 16
					|| Integer.valueOf(super.getPack().get(i).getTalla()) == 18
					|| Integer.valueOf(super.getPack().get(i).getTalla()) == 20
					|| Integer.valueOf(super.getPack().get(i).getTalla()) == 22
					|| Integer.valueOf(super.getPack().get(i).getTalla()) == 24
					|| Integer.valueOf(super.getPack().get(i).getTalla()) == 26) {
				nInfantiles++;
				if (nInfantiles >= 2) {
					return true;
				}
			}
		}

		return suficientesBicis;

	}

	/**
	 * Metodo que convierte un pack a String
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "\n  Tipo de pack: Familiar" + super.toString();
	}

	/**
	 * Indica si cualquiera que sea el objeto es "igual a" nuestro objeto
	 * 
	 * @param Objeto a comparar
	 * 
	 * @return Si es el mismo objeto o no
	 */
	@Override
	public boolean equals(Object otra) {
		return super.equals(otra);
	}

	/**
	 * Devuelve el deposito que hay que pagar segun el descuento que proceda
	 * 
	 * @param deposito que se ha establedido de antemano por el ayuntamiento
	 * 
	 * @return deposito a pagar segun el descuento que proceda
	 * 
	 * @assert.pre El deposito ha de ser mayor de 0
	 */
	@Override
	public double getDepositToPay(double deposit) {
		// Descuento: -50% sobre la suma de las fianzas
		assert deposit > 0.0;

		double depositFinal = 0;
		double suma = 0;// Suma de fianzas

		for (int i = 0; i < this.getNBike(); i++) {
			suma += this.getPack().get(i).getDepositToPay(deposit);
		}

		depositFinal = suma * 0.5;
		return depositFinal;
	}

	/**
	 * Elimina una bicicleta del pack
	 * 
	 * @assert.pre La bicicleta debe pertenecer al pack
	 * @assert.pre Debe de habercomo minimo 5 bicicletas
	 */
	@Override
	public void removeBike(Bike bici) {
		assert pertenece(bici.getId());
		assert super.getNBike() > 4;

		super.getPack().remove(bici);
	}
}
