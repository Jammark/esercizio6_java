package esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	private static Map<String, String> rubrica = new HashMap<>();

	public static void main(String[] args) {

		aggiungi("Paolo", "345676456");
		aggiungi("Pietro", "345676457");
		aggiungi("Piero", "345676458");

		rimuovi("Piero");
		aggiungi("Sandra", "345676459");
		stampa();
		Scanner sc = new Scanner(System.in);
		log.info("inserire numero telefonico");
		String tel = sc.nextLine();
		String res = persona(tel);
		if (res != null) {
			log.info("il numero inserito è di: " + res);
		} else {
			log.error("errore num inesistente");
		}

		log.info("inserire un nome");
		String nome = sc.nextLine();
		res = tel(nome);
		if (res != null) {
			log.info("Il numero di " + nome + " è : " + res);
		} else {
			log.error("errore nome inesistente");
		}

		sc.close();


	}

	public static void aggiungi(String nome, String tel) {
		rubrica.put(nome, tel);
	}

	public static void rimuovi(String nome) {
		rubrica.remove(nome);
	}

	public static String persona(String tel) {
		for (Map.Entry<String, String> e : rubrica.entrySet()) {
			if (e.getValue().equals(tel)) {
				return e.getKey();
			}
		}
		return null;
	}

	public static String tel(String nome) {
		return rubrica.get(nome);
	}

	public static void stampa() {
		for (String chiave : rubrica.keySet()) {
			log.info("-- nome: " + chiave + "-- telefono: " + rubrica.get(chiave));
		}
	}

}
