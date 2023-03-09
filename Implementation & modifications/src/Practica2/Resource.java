package Practica2;

/**
 * Interfaz de un Resource
 * 
 * @author CQFidalgo
 *
 */

public interface Resource {

	/**
	 * Devuelve el deposito que hay que pagar segun el descuento que proceda
	 * 
	 * @param deposito que se ha establedido de antemano por el ayuntamiento
	 * 
	 * @return deposito a pagar segun el descuento que proceda
	 */
	double getDepositToPay(double deposit);

}
