package Practica2;

import java.util.ArrayList;

/**
 * Implementacion de GroupPack como tipo particular de la clase Pack
 * 
 * @author CQFidalgo
 *
 */

public class GroupPack extends Pack {

	/**
	 * Inicializacion de GroupPack
	 * 
	 * @param nBike
	 * 
	 * @assert.pre En los packs de grupos han de alquilarse minimo 10 bicis
	 */
	public GroupPack(ArrayList<Bike> Bikes) {
		super(Bikes);
		assert Bikes.size() > 9;
	}

	/**
	 * Metodo que convierte un pack a String
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "\n  Tipo de pack: Grupo " + super.toString();
	}

	/**
	 * Indica si cualquiera que sea el objeto es "igual a" nuestro objeto
	 * 
	 * @param objeto a comparar
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
		// Descuento: -20% sobre la suma de las fianzas
		assert deposit > 0.0;

		double depositFinal = 0;
		double suma = 0;// Suma de fianzas

		for (int i = 0; i < this.getNBike(); i++) {
			suma += this.getPack().get(i).getDepositToPay(deposit);
		}

		depositFinal = suma * 0.8;
		return depositFinal;
	}

	/**
	 * Eliminar una bicicleta del pack
	 * 
	 * @assert.pre La bicicleta debe pertenecer al pack
	 * @assert.pre Debe de haber como minimo 11 bicicletas
	 */
	@Override
	public void removeBike(Bike bici) {
		assert pertenece(bici.getId());
		assert super.getNBike() > 10;

		super.getPack().remove(bici);
	}
}
