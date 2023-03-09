package Practica1;

/**
 * Implementacion de un CityBikeParkingPoint
 * 
 * @author CQFidalgo
 *
 */
public class CityBikeParkingPoint {
	/*
	 * Atributos de la clase
	 */
	private int totalAnclajes;// numero total de anclajes de un aparcamiento
	private boolean anclajes[];// vector en el que se almacenan si los anclajes
								// estan ocupados o no
	private int id;// identificador de un aparcamiento

	private double gps[];// vector que guarda la posicion gps de un aparcamiento
							// en grados decimales

	/**
	 * Inicializacion por defecto de un aparcamiento
	 */
	public CityBikeParkingPoint() {
		totalAnclajes = 0;
		anclajes = new boolean[totalAnclajes];
		id = 0;
		gps = new double[2];
	}

	/**
	 * Inicializacion de un aparcamiento vacio con argumentos (coordenadas GD)
	 * 
	 * @param totalAnclajes: Numero de anclajes disponibles en el aparcamiento
	 * @param id: Numero de identificacion del aparcamiento distinto de 0
	 * @param gd: Coordenada del aparcamiento en GD
	 * 
	 * @assert.pre El numero total de anclajes ha de ser mayor que 0
	 * @assert.pre El numero de identificacion ha de ser mayor que 0
	 * @assert.pre Las coordenadas han de cumplir unas condiciones (rango,
	 *             tamaño) para ser validas
	 */

	public CityBikeParkingPoint(int totalAnclajes, int id, double[] gd) {
		assert totalAnclajes > 0;
		assert id > 0;
		assert (validarGD(gd));

		this.totalAnclajes = totalAnclajes;
		anclajes = new boolean[totalAnclajes]; // Se crean en false
		this.id = id;
		gps = new double[2];

		for (int i = 0; i < 2; i++) {
			gps[i] = gd[i];
		}
	}

	/**
	 * Inicializacion de un aparcamiento vacio con argumentos (coordenadas GMS)
	 * 
	 * @param totalAnclajes: Numero de anclajes disponibles en el aparcamiento
	 * @param id: Numero de identificacion del aparcamiento distinto de 0
	 * @param gd: Coordenada del aparcamiento en GMS
	 * 
	 * @assert.pre El numero total de anclajes ha de ser mayor que 0
	 * @assert.pre El numero de identificacion ha de ser mayor que 0
	 * @assert.pre Las coordenadas han de cumplir unas condiciones (rango,
	 *             tamaño) para ser validas
	 */
	public CityBikeParkingPoint(int totalAnclajes, int id, String[][] gms) {
		assert totalAnclajes > 0;
		assert id > 0;
		assert validarGMS(gms);
		gps = new double[2];

		for (int i = 0; i < 2; i++) {
			gps[i] = convertirGMSaGD(gms)[i];
		}

		this.totalAnclajes = totalAnclajes;
		anclajes = new boolean[totalAnclajes]; // Se crean en false
		this.id = id;
	}

	/**
	 * Devuelve el numero de anclajes de {@code this}
	 * 
	 * @return Numero de anclajes
	 */
	public int getTotalAnclajes() {
		return totalAnclajes;
	}

	/**
	 * Devuelve el identificador de {@code this}
	 * 
	 * @return Identificador
	 */
	public int getId() {
		return id;
	}

	/**
	 * Devuelve posicion GPS del aparcamiento
	 * 
	 * @return Posicion GPS en grados decimales
	 */
	public double[] getGPS() {
		return gps;
	}

	/**
	 * Devuelve el array que contiene si los anclajes esán llenos o vacíos
	 * 
	 * @return anclajes: Array de booleans según si el anclaje está ocupado
	 *         (true) o no (false).
	 */
	public boolean[] getAnclajes() {
		return anclajes;
	}

	/**
	 * Devuelve las coordenadas gps en GMS
	 * 
	 * @return gms: coordenadas en formato GMS
	 */
	public String[][] coordenadasEnGMS() { // tenemos el gps en GD = double []
		String[][] gms = new String[2][4];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				gms[i][j] = convertirGDaGMS(gps)[i][j];

			}
		}
		return gms;
	}

	/**
	 * Cambia la identificacion del aparcamiento
	 * 
	 * @param newId: Nueva identificacion
	 * 
	 * @assert.pre La nueva id ha de ser mayor que 0.
	 */

	public void setId(int newId) {
		assert newId > 0;

		id = newId;
	}

	/**
	 * Conocer el estado de un modulo de anclaje concreto de {@code this}
	 * 
	 * @param modulo: Numero que identifica el modulo de anclaje del aparcamiento
	 * 
	 * @return Estado del modulo de anclaje
	 * 
	 * @assert.pre El modulo al que se accede ha de estar en el aparcamiento.
	 */
	public boolean estadoModulo(int modulo) {
		assert (modulo > 0 && modulo <= totalAnclajes);

		return anclajes[modulo - 1];
	}

	/**
	 * Devuelve el numero de anclajes ocupados de {@code this}
	 * 
	 * @return Numero de anclajes ocupados
	 */
	public int numeroAnclajesOcupados() {
		int ocupados = 0;
		for (int i = 0; i <= totalAnclajes - 1; i++) {
			if (anclajes[i]) { // Si el anclaje esta ocupado es TRUE
				ocupados++;
			}
		}
		return ocupados;
	}

	/**
	 * Desanclar bici del modulo de anclaje
	 * 
	 * @param modulo: Numero que identifica el modulo de anclaje del aparcamiento
	 * 
	 * @assert.pre El modulo al que se accede ha de estar en el aparcamiento
	 * @assert.pre El modulo ha de tener una bici para poder desanclarla
	 */
	public void desanclarBici(int modulo) {
		assert (modulo > 0 && modulo <= totalAnclajes);
		assert estadoModulo(modulo);

		anclajes[modulo - 1] = false;
	}

	/**
	 * Anclar bici del modulo de anclaje
	 * 
	 * @param modulo: Numero que identifica el modulo de anclaje del aparcamiento
	 * 
	 * @assert.pre El modulo al que se accede ha de estar en el aparcamiento
	 * @assert.pre El modulo ha de estar libre para poder ocuparse
	 * 
	 */
	public void anclarBici(int modulo) {
		assert (modulo > 0 && modulo <= totalAnclajes);
		assert !estadoModulo(modulo);

		anclajes[modulo - 1] = true;
	}

	/**
	 * Conocer distancia desde el aparcamiento actual hasta otro aparcamiento
	 * dado
	 * 
	 * @param otro:
	 *            Aparcamiento hasta el que se quiere calcular la distancia
	 * @return d: Distancia entre ambos aparcamientos
	 * 
	 * @assert.pre El parking ha de tener anclajes para poder aparecer en la
	 *             busqueda
	 */
	// Todos los gps son en grados decimales
	public double distancia(CityBikeParkingPoint otro) {
		assert otro.getTotalAnclajes() != 0;

		double gpsOtro[] = otro.gps; // GPS del parking que nos interesa: es en GD

		double d = distanciaDesdeCoordenada(gpsOtro);

		return d;

	}

	/**
	 * Conocer distancia desde el aparcamiento actual hasta unas coordenadas
	 * dadas en GD
	 * 
	 * @param gd: coordenadas en grados decimales hasta la que se quiere
	 *            calcular la distancia
	 * @return d: distancia entre ambos aparcamientos
	 * @assert.pre Las coordenadas han de cumplir unas condiciones (rango,
	 *             tamaño) para ser validas
	 */
	public double distanciaDesdeCoordenada(double[] gd) {
		assert (validarGD(gd));

		double r = 6371;// Km, radio de la tierra
		double dlong = Math.toRadians(gps[1]) - Math.toRadians(gd[1]);
		double dlat = Math.toRadians(gps[0]) - Math.toRadians(gd[0]);

		double a = Math.pow(Math.sin(dlat / 2), 2)
				+ Math.cos(Math.toRadians(gd[0])) * Math.cos(Math.toRadians(gps[0])) * Math.pow(Math.sin(dlong / 2), 2);
		double c = 2 * Math.asin(Math.min(1, Math.sqrt(a)));
		double d = r * c;

		return d;
	}

	/**
	 * Conocer distancia desde el aparcamiento actual hasta unas coordenadas
	 * dadas en GMS
	 * 
	 * @param gms:
	 *            coordenadas en GMS hasta las que se quiere calcular la
	 *            distancia
	 * @return d: distancia entre ambos aparcamientos
	 * @assert.pre Las coordenadas han de cumplir unas condiciones (rango,
	 *             tamaño) para ser validas
	 */
	public double distanciaDesdeCoordenada(String[][] gms) {
		assert (validarGMS(gms));

		double gd[] = new double[2];

		for (int i = 0; i < 2; i++) {
			gd[i] = convertirGMSaGD(gms)[i];
		}

		double d = distanciaDesdeCoordenada(gd);

		return d;
	}

	// Paso de GMS a GD
	// GD se establece como dos doubles
	// GMS se establece como A grados, B minutos, C segundos y la letra N/S o
	// E/O
	/**
	 * Convierte las coordenadas GMS introducidas en coordenadas GD.
	 * 
	 * @param gms:
	 *            coordenadas del parking en gms
	 * @return gd: coordenadas del parking en gd
	 * 
	 * @assert.pre Las coordenadas han de cumplir unas condiciones (rango,
	 *             tamaño) para ser validas
	 */
	public double[] convertirGMSaGD(String[][] gms) {
		assert (validarGMS(gms));

		double[] gd = new double[2];
		int signo;

		for (int i = 0; i < 2; i++) {
			signo = 0;
			if (gms[i][3].equalsIgnoreCase("s") || gms[i][3].equalsIgnoreCase("o")) {
				signo = -1;
			} else {
				if (gms[i][3].equalsIgnoreCase("n") || gms[i][3].equalsIgnoreCase("e")) {
					signo = 1;
				}
			}
			gd[i] = signo * (Double.valueOf(gms[i][0]).doubleValue() + (Double.valueOf(gms[i][1]).doubleValue() / 60)
					+ (Double.valueOf(gms[i][2]).doubleValue() / 3600));
		}

		return gd;
	}

	// Paso de GD a GMS
	// GD se establece como dos doubles
	// GMS se establece como A grados, B minutos, C segundos y la letra N/S o
	// E/O
	/**
	 * Convierte las coordenadas GD introducidas en coordenadas GMS.
	 * 
	 * @param Coordenadas del parking en GD
	 * @return Coordenadas del parking en GMS
	 * @assert.pre Las coordenadas han de cumplir unas condiciones (rango,
	 *             tamaño) para ser validas
	 */
	public String[][] convertirGDaGMS(double[] gd) {
		assert (validarGD(gd));

		String[][] gms = new String[2][4];
		double[] aux2 = new double[2];
		String letra = "";
		int g, m;
		double s, aux;

		for (int i = 0; i < 2; i++) {

			if (gd[i] > 0) {
				if (i == 0) {
					letra = "N";
				} else {
					letra = "E";
				}
				aux2[i] = gd[i];
			} else if (gd[i] < 0) {
				if (i == 0) {
					letra = "S";
				} else {
					letra = "O";
				}
				aux2[i] = gd[i] * (-1);
			} else {// gd[i]==0
				if (i == 0) {
					letra = "N";
				} else {
					letra = "E";
				}
				aux2[i] = Math.abs(gd[i]);
			}
			gms[i][3] = letra;
		}

		for (int i = 0; i < 2; i++) {
			g = (int) aux2[i];
			aux = (aux2[i] - g) * 60;
			m = (int) aux;
			s = (aux - m) * 60;
			;
			s = Math.floor(s * 10000) / 10000;

			gms[i][0] = String.valueOf(g);
			gms[i][1] = String.valueOf(m);
			gms[i][2] = String.valueOf(s);
		}
		return gms;
	}

	private boolean validarGD(double[] gps) {
		assert gps.length == 2; //Las coordenadas en grados decimales constan de dos numeros
		assert (gps[0] >= -90.0000) && (gps[0] <= 90.0000);  //La latitud ha de estar en el rango [-90,90]
		assert (gps[1] >= -180.0000) && (gps[1] <= 180.0000);  //La longitud ha de estar en el rango [-180,180]

		return true;
	}

	private boolean validarGMS(String[][] gms) {
		assert gms.length == 2; // Las coordenadas GMS se dividen en dos grupos, uno para latitud y otro para longitud
		assert gms[0].length == 4 && gms[1].length == 4; // Las coordenadas GMS constan de 4 elementos: grados, minutos, segundos y punto cardinal
		assert (gms[0][3].equalsIgnoreCase("n") || gms[0][3].equalsIgnoreCase("s")); // La latitud ha de ser norte o sur
		assert (gms[1][3].equalsIgnoreCase("e") || gms[1][3].equalsIgnoreCase("o")); // La longitud ha de ser este u oeste
		assert !(gms[0][0].equalsIgnoreCase("") || gms[0][1].equalsIgnoreCase("") || gms[0][2].equalsIgnoreCase("")); // Ningun elemento puede estar vacio
		assert !(gms[1][0].equalsIgnoreCase("") || gms[1][1].equalsIgnoreCase("") || gms[1][2].equalsIgnoreCase("")); // Ningun elemento puede estar vacio
		assert (Integer.parseInt(gms[0][0]) >= 0 && Integer.parseInt(gms[0][1]) >= 0 && Double.parseDouble(gms[0][2]) >= 0.0000);
		assert (Integer.parseInt(gms[1][0]) >= 0 && Integer.parseInt(gms[1][1]) >= 0 && Double.parseDouble(gms[1][2]) >= 0.0000);
		assert (Integer.parseInt(gms[0][0]) <= 90 && Integer.parseInt(gms[0][1]) <= 59 && Double.parseDouble(gms[0][2]) <= 59.9999);
		assert (Integer.parseInt(gms[1][0]) <= 180 && Integer.parseInt(gms[1][1]) <= 59 && Double.parseDouble(gms[1][2]) <= 59.9999);
		// Los grados han de ser enteros y deben estar en el rango [0,90) para la latitud y en el rango [0,180) para la longitud.
		// Los minutos han de ser enteros y deben estaren el rango [0,60)
		// Los segundos pueden contener cifras decimales y deben estaren el rango [0,60)

		return true;
	}

}