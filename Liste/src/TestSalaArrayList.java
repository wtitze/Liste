import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;

public class TestSalaArrayList {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		String filepath = System.getProperty("user.dir") + "\\src\\prenotazioni.csv";
		BufferedReader objReader = null;

		// dichiarazione lista che conterrà le informazioni sulle sale

		ArrayList<Sala> sale = new ArrayList<Sala>();
		
		try {
			// dichiarazione delle variabili che permettono la lettura di un file CSV
			String strCurrentLine;
			objReader = new BufferedReader(new FileReader(filepath));
			objReader.readLine(); // per saltare l'intestazione con i nomi dei campi

			// lettura del file CSV e caricamento nella lista

			String[] infoSala;
			while ((strCurrentLine = objReader.readLine()) != null) {
				infoSala = strCurrentLine.split(";");
				sale.add(new Sala(infoSala[0], Integer.parseInt(infoSala[1]), Integer.parseInt(infoSala[2]) ));
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (objReader != null)
					objReader.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		int scelta = 0;
		while (scelta != 4) {
			System.out.println("\nScegli un'opzione:");
			System.out.println("1 -> visualizza posti liberi");
			System.out.println("2 -> prenota");
			System.out.println("3 -> cancella la prenotazione");
			System.out.println("4 -> esci dal programma");
			scelta = tastiera.nextInt();

			switch (scelta) {
			case 1:
				System.out.println("Visualizzazione posti liberi");
				for (int i = 0; i < sale.size(); i++) {
					System.out.println("sala: " + sale.get(i).getNome() + "\tposti liberi: " + (sale.get(i).getCapienza() - sale.get(i).getSpettatori()));
				}
			break;
			case 2:

			break;
			case 3:

			break;
			case 4:
				System.out.println("Grazie per aver utilizzato il nostro servizio");
				try {
					// true => tieni dati e aggiungi
					// false => sovrascrivi dati e aggiungi
					BufferedWriter objWriter = new BufferedWriter(new FileWriter(filepath));
					objWriter.write("nomesala;capienza;postiprenotati;\n");
					for (int i = 0; i < sale.size(); i++)  {
						objWriter.write(sale.get(i).getNome() + ";" + sale.get(i).getCapienza() + ";" + sale.get(i).getSpettatori()+ ";\n");
					}
					objWriter.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Attenzione: l'opzione inserita non e' disponibile");
				break;
			}
		}

		tastiera.close();
	}
}
