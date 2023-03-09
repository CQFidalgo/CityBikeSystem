package Practica2;

import java.util.ArrayList;

/**
 * Abstraccion de Pack como implementacion de un Resource
 * 
 * @author CQFidalgo
 *
 */

public abstract class Pack implements Resource {

	// Atributos
	private ArrayList<Bike> packCompleto;// Array de las bicicletas que componen el pack
	private int nBike;

	/**
	 * Inicializacion de un Pack
	 * 
	 * @param Bikes: lista de bikes que perteneceran al pack
	 */

	public Pack(ArrayList<Bike> Bikes) {
		this.nBike = Bikes.size();
		packCompleto = new ArrayList<Bike>(nBike);

		for (int i = 0; i < Bikes.size(); i++) {
			packCompleto.add(Bikes.get(i));
		}
	}

	/**
	 * Devuelve la lista de bicis en el pack
	 * 
	 * @return lista de bicis en el pack
	 */

	public ArrayList<Bike> getPack() {
		return packCompleto;
	}

	/**
	 * Devuelve el numero de bicicletas que componen el pack
	 * 
	 * @return numero de bicicletas que componen el pack
	 */
	public int getNBike() {
		return nBike;
	}

	/**
	 * Devuelve si pertenece o no una bicicleta, segun su id, al pack
	 * 
	 * @param id: identificador de la bicicleta
	 * 
	 * @return si pertenece o no
	 * 
	 * @assert.pre La id ha de ser positiva
	 */
	public boolean pertenece(int id) {
		assert id > 0;

		boolean pertenece = false;// no existe en el sistema

		for (int i = 0; i < packCompleto.size(); i++) {
			if (packCompleto.get(i).getId() == id) {
				pertenece = true;// existe en el sistema
			}
		}
		return pertenece;
	}

	/**
	 * Metodo que convierte un pack a String
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "\n  Número de bicicletas = " + getNBike() + "\n  packCompleto: " + getPack() + "\n";
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
		if (otra instanceof Pack) {
			Pack p = (Pack) otra;
			return getNBike() == p.getNBike() && getPack() == p.getPack();
		} else
			return false;
	}

	/**
	 * Añade una bici al pack
	 * 
	 * @param bici a añadir
	 * 
	 * @assert.pre La bici a añadir no puede pertenecer aun al pack
	 */
	public void addBike(Bike bici) {
		assert !pertenece(bici.getId());

		packCompleto.add(bici);
	}

	/**
	 * Elimina una bicicleta del pack
	 * 
	 * @param bici
	 */
	public abstract void removeBike(Bike bici);

	/**
	 * Devuelve el deposito que hay que pagar segun el descuento que proceda
	 * 
	 * @param deposito que se ha establedido de antemano por el ayuntamiento
	 * 
	 * @return deposito a pagar segun el descuento que proceda
	 */
	public abstract double getDepositToPay(double deposit);
}
