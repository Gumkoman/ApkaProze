/**
 * 
 */
package Generator;

import java.io.FileReader;
import java.util.Properties;

/**
 * Klasa przechowujaca g�owny parametr gry. Singleton. Nie wolno samodzielnie modyfikowac
 * tej klasy poza zmiana:
 * <ol>
 * <li>kodowania,</li>
 * <li>zdania pakietyzacji,</li>
 * <li>komentarzy,</li>
 * <li>sciezki do pliku {@code ./pin.txt}.</li>
 * </ol>
 * @author kmi
 * @version 1.0.0  6 marca 2019 04:11
 */
public enum PIN {
	/**
	 * Singleton tej klasy.
	 */
	PIN;
	
	/**
	 * Pin gry.
	 */
	final public int pin;
	
	/**
	 * Autorzy ca�ego projektu.
	 */
	final public String autorzy;
	
	/**
	 * W�asnosci wczytane z pliku pin.txt. 
	 */
	private Properties w�asnosci = null;
	
	/**
	 * Konstruktor wczytujacy pin. Od razu uruchamia leniwa inicjacje.
	 */
	private PIN() {
		initializeLazy();
		String pin$ = null;
		try {
			pin$ = w�asnosci.getProperty("pin").trim();
			Integer.parseInt(pin$);
		} catch (Throwable thr) {
			wypiszKomunikatyIZakoncz("B�ad parsowania pinu", "pin=" + pin$, thr);
		}
		pin = Integer.parseInt(pin$);
		if (pin < 1000 | pin > 9999) { // dlaczego tu jest | a nie || ?!
			wypiszKomunikatyIZakoncz("Pin poza dopuszczalnym zakresem", pin);
		}
		autorzy = w�asnosci.getProperty("autorzy").trim();
	}
	
	/**
	 * Leniwe �adowanie pliku w�asnosci. Wzorzec leniwej inicjacji. Metoda powinna
	 * byc uzyta dopiero w momencie potrzeby pierwszego skorzystania z w�asnosci
	 * tu przechowywanych, poniewaz jednak projekt nie moze dzia�ac bez pinu - metoda
	 * jest wywo�ywana od razu w konstruktorze. Nasladuj leniwa inicjacje - inicjuj
	 * obiekty dopiero wtedy, gdy to jest potrzebne. Inicjacja rozumiana jest tu jako
	 * odwo�anie sie do g�ebszych warstw np. systemu operacyjnego, systemu plikow, bazy
	 * danych itp. W tym przypadku jest to odczyt pliku.
	 */
	private void initializeLazy() {
		if (w�asnosci == null) {
			try (FileReader fr = new FileReader("src\\pin.txt")) {
				(w�asnosci = new Properties()).load(fr);
			} catch (Throwable thr) {
				wypiszKomunikatyIZakoncz("Nie uda�o sie wczytac pinu gry.", thr);
			}
		}
	}
	
	/**
	 * Wypisuje komunikaty i konczy dzia�anie programu przez {@link java.lang.System#exit}.
	 * Dodatkowo, jesli komunikat jest wyjatkiem zostanie wywo�ana metoda
	 * {@link java.lang.Throwable#printStackTrace} tego wyjatku.
	 * @param tablicaKomunikatow
	 */
	void wypiszKomunikatyIZakoncz(Object... tablicaKomunikatow) {
		for (int i = 0; i < tablicaKomunikatow.length; i++) {
			System.err.print((i+1) + ": " );
			if (tablicaKomunikatow[i] instanceof Throwable) {
				((Throwable)tablicaKomunikatow[i]).printStackTrace();
			} else {
				System.err.println(tablicaKomunikatow[i].toString());
			}
		}
		System.exit(-1);
	}
	
	public String toString() {
		return "pin: " + pin + ", autorzy: " + autorzy; 
	}
	
	/**
	 * Test klasy. Argumenty nieuzywane.
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(java.nio.file.Paths.get(".").toAbsolutePath());
		System.out.println(PIN);
	}
}