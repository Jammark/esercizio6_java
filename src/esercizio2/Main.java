package esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		List<Integer> lista1 = numeri(20);
		List<Integer> lista2 = nuovaLista(lista1);
		log.info("stampa");
		stampa(lista1);
		stampa(lista2);
		log.info("stampa1");
		stampa(lista1, true);
		log.info("stampa2");
		stampa(lista1, false);
		log.info("stampa3");
		stampa(lista2, true);
		log.info("stampa4");
		stampa(lista2, false);

	}

	public static List<Integer> numeri(int l) {
		List<Integer> lista = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < l; i++) {
			lista.add(r.nextInt(101));
		}
		lista.sort(Integer::compare);
		return lista;
	}

	public static <T> List<T> nuovaLista(List<T> lista) {
		List<T> risultato = new ArrayList<T>();
		risultato.addAll(lista);
		for (int i = lista.size(); i > 0; i--) {
			risultato.add(lista.get(i - 1));
		}
		return risultato;
	}

	@SuppressWarnings("rawtypes")
	public static void stampa(List lista) {

		for (int i = 0; i < lista.size(); i++) {

			log.info("elemento numero: " + i + " con valore: " + lista.get(i));

		}
	}

	@SuppressWarnings("rawtypes")
	public static void stampa(List lista, boolean cond) {
		int resto = cond ? 0 : 1;
		for (int i = 0; i < lista.size(); i++) {
			if (i % 2 == resto) {
				continue;
			} else {
				log.info("elemento numero: " + i + " con valore: " + lista.get(i));
			}
		}
	}

}
