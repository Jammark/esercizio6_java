package esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numero = leggiNumero(sc);
		Set<String> lista = new HashSet<>();
		Set<String> duplicate = new HashSet<>();
		do {
			log.info("Inserire una parola.");
			String input = sc.nextLine();
			if (lista.contains(input)) {
				duplicate.add(input);
				lista.remove(input);
			} else {
				lista.add(input);
			}

		} while (--numero > 0);
		for (String s : duplicate) {
			log.info("duplicate: " + s);
		}
		log.info("numero parole distinte: " + lista.size());
		for (String s : lista) {
			log.info("distinta: " + s);
		}
		sc.close();

	}

	public static int leggiNumero(Scanner sc) {
		try {
			log.info("Inserire un numero.");
			int n = Integer.parseInt(sc.nextLine());
			return n;
		} catch (NumberFormatException e) {
			log.info("valore inserito non valido.");
			log.error(e.getMessage());
			return leggiNumero(sc);
		}
	}

}
