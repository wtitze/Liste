public class Sala {

	private String nome;
	private int capienza, spettatori;

	// costruttore vuoto
	public Sala() {
		nome = "";
		capienza = 0;
		spettatori = 0;
	}

	// costruttore per assegnare valori agli attributi
	public Sala(String n, int c, int s) {
		nome = n;
		capienza = c;
		spettatori = s;
	}

	// metodi
	public String getNome() {
		return nome;
	}

	public void setNome(String n) {
		nome = n;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int c) {
		capienza = c;
	}

	public int getSpettatori() {
		return spettatori;
	}

	public void setSpettatori(int s) {
		spettatori = s;
	}

	public boolean prenota(int posti) {
		boolean esito = false;
		if (capienza - spettatori >= posti) {
			spettatori = spettatori + posti;
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}

	public boolean cancella(int posti) {
		boolean esito = false;
		if (posti <= spettatori) {
			spettatori = spettatori - posti;
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}

}
