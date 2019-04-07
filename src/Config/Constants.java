package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Maicej-Laptok
 *
 */
public class Constants {
	 public static int mainMenuFrameWidth;
	    /**
	     * Zmienna okreœlaj¹ca wysokoœæ okna menu g³ównego
	     */
	 public static int mainMenuFrameHeight;
	    /**
	     * Zmienna okreœlaj¹ca szerkosc okna menu g³ównego
	     */
	 public static int numberOfLevels;
	    /**
	     * Zmienna okreœlaj¹ca liczbe poziomow
	     */
	 public static int firstLevel;
	    /**
	     * Zmienna okreœlaj¹ca poczatek numeracji poziomow
	     */
	 public static String levelName;
	    /**
	     * Zmienna okreœlaj¹ca nazwe koncowki definijuacej poziom
	     */
	 public static int numberOfDiff;
	    /**
	     * Zmienna okreœlaj¹ca liczbe poziomow
	     */
	 public static int changeBetweenDiff;
	    /**
	     * Zmienna okreœlaj¹ca progresje stopnia trudnosci
	     */
	 public static double objectSizeToWidth;
	    /**
	     * Zmienna okreœlaj¹ca stosunek obiektow gry do poczatkowej szerokosci
	     */
	 public static String background;
	    /**
	     * Zmienna okreœlaj¹ca typ tla
	     */
	 public static String gameName;
	 /**
	  * Zmienna okreœlaj¹ca nazwê gry
	  */
	 public static String RGB;
	 /**
	  * Zmienna okreœlaj¹ca wartoœci RGB
	  */
	 public static int red;
	 /**
	  * Zmienna okreœlaj¹ca wartoœci red
	  */
	 public static int green;
	 /**
	  * Zmienna okreœlaj¹ca wartoœci green
	  */
	 public static int blue;
	 /**
	  * Zmienna okreœlaj¹ca wartoœci blue
	  */
	 public static String plikTla;
	 /**
	  * Metoda ustalaj¹ca wartoœci z pliku tekstowego
	  */
	 public static void setConstants() {
		 	
		 Properties prop = new Properties();
		 InputStream input = null;
		 try {
			 String test="";
			 input = new FileInputStream("par.txt");
			 prop.load(input);
			 System.out.println(prop.getProperty("nazwaBazowaPlikuZOpisemPoziomu"));
			 levelName=prop.getProperty("nazwaBazowaPlikuZOpisemPoziomu");
			 background=prop.getProperty("tlo");
			 mainMenuFrameWidth = Integer.parseInt(prop.getProperty("poczatkowaSzerokoscPlanszy"));
			 mainMenuFrameHeight=Integer.parseInt(prop.getProperty("poczatkowaWysokoscPlanszy"));
			 numberOfLevels=Integer.parseInt(prop.getProperty("liczbaPoziomow"));
			 firstLevel=Integer.parseInt(prop.getProperty("numeracjaPoziomowZaczynaSieOd"));
			 numberOfDiff=Integer.parseInt(prop.getProperty("liczbaStopniTrudnosci"));
			 changeBetweenDiff=Integer.parseInt(prop.getProperty("zmianaStopniaTrudnosci"));
			 objectSizeToWidth=Double.parseDouble(prop.getProperty("poczatkowaSzerokoscObiektuGryJakoProcentPoczatkowejSzerokosciPlanszy"));
			 gameName=prop.getProperty("nazwaGry");
			 System.out.println("Constants: "+background);
			 System.out.println("Essa" + prop.getProperty("tlo") );
			 if(background.contentEquals("jednolite")) {
				 System.out.println("JEDNOLITE TLO");
				 RGB=prop.getProperty("klorTla");
				 transferToRGB();
			 }else{
				 System.out.println("NIEJEDNLITE TLO");
				 plikTla=prop.getProperty("plikTla");
			 }
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}	 

	 }

	 public static void transferToRGB() {
		 int temp=0;
		 char r = ' ';
		 String essa="";
		 for(int i =0;i<RGB.length();i++) {
			if((!(RGB.charAt(i)==r))) {
				// System.out.println("TEMP: "+temp);
				if(temp==0) {
					essa=essa+RGB.charAt(i);
				}
				if(temp==1) {
					essa=essa+RGB.charAt(i);
				}
				if(temp==2) {
					essa=essa+RGB.charAt(i);
				}
				// System.out.println("ESSA: " + essa);
			}else {
				
				if(temp==0) {
					red=Integer.parseInt(essa);
				//	System.out.println("ZAPISANO CZERWONY");
				}
				if(temp==1) {
					green=Integer.parseInt(essa);
				//	System.out.println("ZAPISANO ZIELONY");
				}
				if(temp==2) {
					blue=Integer.parseInt(essa);
				//	System.out.println("ZAPISANO NIEBIESKI");
				}
				temp++;
				essa="";
			}
		 }
		 System.out.println("RED: " + red);
		 System.out.println("GREEN: " + green);
		 System.out.println("BLUE: " + blue);
	 }
	 static{
		 setConstants(); 
	    }
	 Constants(){}
	 
}
