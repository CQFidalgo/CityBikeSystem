package Practica2;

/**
 * Implementacion de ElectricBike como tipo particular de la clase AdultBike
 * 
 * @author CQFidalgo
 *
 */

public class ElectricBike extends AdultBike {

	// Atributos
	private double parMotor; // Momento de fuerza del motor (N*m),
	private double voltaje;// Voltaje de la bateria (V)
	private double cargaElectrica;// Carga electrica de la bateria (Ah)

	/**
	 * Inicializacion de ElectricBike
	 * 
	 * @param marca de la bicibleta
	 * @param modelo de la bicibleta
	 * @param peso de la bicibleta
	 * @param platos: numero de platos de la bicibleta
	 * @param pinones: numero de pinones de la bicibleta
	 * @param talla: talla de la bicicleta
	 * @param parMotor: par motor de la bicibleta
	 * @param voltaje: voltaje de la bateria de la bicicleta
	 * @param cargaElectrica: arga electrica de la bateria de la bicicleta
	 * 
	 * @assert.pre El par del motor ha de ser positivo
	 * @assert.pre El voltaje ha de ser mayor de 0
	 * @assert.pre La carga electrica no puede ser negativa
	 * 
	 */
	public ElectricBike(String marca, String modelo, double peso, int platos, int pinones, String talla,
			double parMotor, double voltaje, double cargaElectrica) {
		super(marca, modelo, peso, platos, pinones, talla);

		assert parMotor > 0.0;
		assert voltaje > 0.0;
		assert cargaElectrica >= 0.0;

		this.parMotor = parMotor;
		this.voltaje = voltaje;
		this.cargaElectrica = cargaElectrica;
	}

	/**
	 * Devuelve el parMotor de {@code this}
	 * 
	 * @return parMotor del motor de la bicicleta
	 */
	public double getParMotor() {
		return parMotor;
	}

	/**
	 * Devuelve el voltaje de {@code this}
	 * 
	 * @return Voltaje de la bateria de la bicicleta
	 */
	public double getVoltaje() {
		return voltaje;
	}

	/**
	 * Devuelve la carga electrica de {@code this}
	 * 
	 * @return Carga electrica de la bateria de la bicicleta
	 */
	public double getCargaElectrica() {
		return cargaElectrica;
	}

	/**
	 * Devuelve la energiaAlmacenada de {@code this}
	 * 
	 * @return Energia almacenada en kw/h
	 */
	public double energiaAlmacenada() {
		double energia = 0;

		// calculamos los watiosHora
		energia = voltaje * cargaElectrica;

		// pasamos a kilowatiosHora
		energia /= 1000;

		return energia;
	}

	/**
	 * Metodo que convierte una bicicleta a String
	 * 
	 * @return String
	 */
	public String toString() {
		return "\n  Tipo de bicicleta: Electrica" + super.toString() + "  Par motor: " + getParMotor()
				+ "\n  Voltaje: " + getVoltaje() + "\n  Carga electrica: " + getCargaElectrica() + "\n";
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
		assert deposit > 0.0; 

		double porcentaje = 0;

		porcentaje = 1 + (voltaje / 100);

		deposit *= porcentaje;

		return deposit;
	}

}
