package Drawing;

import Config.Constants;
import Generator.GeneratorPlikuParametrycznegoGry;

public class AppStart {
	private static MenuFrame menuFrame;
	/**
	 * zmienna statyzcna sluzaca do tworzenia okna
	 */
	public static void makeMenu() {
		menuFrame=new MenuFrame();
	}
	public static void runGame() {
		GeneratorPlikuParametrycznegoGry.main("");
		Constants.setConstants();
		makeMenu();
		System.out.println("AppStart"+Constants.background);
		System.out.println(Constants.plikTla);
	}
}
