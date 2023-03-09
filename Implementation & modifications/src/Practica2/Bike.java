package Practica2;

/**
 * Abstraccion de Bicicletas como implementacion de un Resource
 * 
 * @author CQFidalgo
 *
 */

public abstract class Bike implements Resource {

	private static int idBici = 1;

	// Atributos
	private int id;// Identificacion de la bicicleta
	private String marca;// Marca de la bicicleta
	private String modelo;// Modelo de la bicicleta
	private double peso;// Peso de la bicicleta
	private int platos;// Numero de platos de la bicicleta
	private int pinones;// Numero de pinones de la bicicleta
	private String talla;// Talla de la bicicleta

	/**
	 * Inicializacion de Bike
	 * 
	 * @param marca de la bicibleta
	 * @param modelo de la bicibleta
	 * @param peso de la bicibleta
	 * @param platos: numero de platos de la bicibleta
	 * @param pinones: numero de pinones de la bicibleta
	 * @param talla de la bicicleta
	 * 
	 * @assert.pre La bicicleta debe pertenecer a una marca
	 * @assert.pre La bicicleta ha de tener un modelo
	 * @assert.pre El peso ha de ser mayor de 0
	 * @assert.pre El numero de platos ha de ser mayor de 0
	 * @assert.pre El numero de piñones ha de ser mayor de 0
	 * @assert.pre La bicicleta ha de tener una talla
	 */
	public Bike(String marca, String modelo, double peso, int platos, int pinones, String talla) {
		assert marca != null;
		assert marca != "";
		assert modelo != null;
		assert modelo != "";
		assert peso > 0.0;
		assert platos > 0;
		assert pinones > 0;
		assert talla != null;
		assert talla != "";

		this.id = idBici++;
		this.marca = marca;
		this.modelo = modelo;
		this.peso = peso;
		this.platos = platos;
		this.pinones = pinones;
		this.talla = talla;
	}

	/**
	 * Devuelve el identificador de {@code this}
	 * 
	 * @return Identificador de la bicicleta
	 */
	public int getId() {
		return id;
	}

	/**
	 * Devuelve la marca de {@code this}
	 * 
	 * @return Marca de la bicicleta
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Devuelve el modelo de {@code this}
	 * 
	 * @return Modelo de la bicicleta
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Devuelve el peso de {@code this}
	 * 
	 * @return Peso de la bicicleta
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Devuelve el numero de platos de {@code this}
	 * 
	 * @return Numero de platos de la bicicleta
	 */
	public int getPlatos() {
		return platos;
	}

	/**
	 * Devuelve el numero de pinones de {@code this}
	 * 
	 * @return Numero de pinones de la bicicleta
	 */
	public int getPinones() {
		return pinones;
	}

	/**
	 * Devuelve la talla de la bicicleta de {@code this}
	 * 
	 * @return talla de la bicicleta
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * Metodo que convierte una bicicleta a String
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "\n  Id = " + getId() + "\n  Marca = " + getMarca() + "\n  Modelo = " + getModelo() + "\n  peso = "
				+ getPeso() + "kg\n  Número de platos = " + getPlatos() + "\n  Número de piñones = " + getPinones()
				+ "\n  Talla = " + getTalla() + "\n";
	}

	/**
	 * Indica si cualquiera que sea el objeto es "igual a" nuestro objeto
	 * 
	 * @param bicicleta a comparar
	 * 
	 * @return Si es el mismo objeto o no
	 */
	@Override
	public boolean equals(Object otra) {
		if (otra instanceof Bike) {
			Bike b = (Bike) otra;
			return getMarca() == b.getMarca() && getModelo() == b.getModelo() && getPeso() == b.getPeso()
					&& getPlatos() == b.getPlatos() && getPinones() == b.getPinones() && getTalla() == b.getTalla()
					&& getId() == b.getId();
		} else
			return false;
	}

	/**
	 * Devuelve el deposito que hay que pagar segun el descuento que proceda
	 * 
	 * @param deposito que se ha establedido de antemano por el ayuntamiento
	 *
	 * @return deposito a pagar segun el descuento que proceda
	 */
	public abstract double getDepositToPay(double deposit);
}
