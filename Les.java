import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Les {
	public static void main(String[] args) {
		System.out.println("welkom bij Scrabble. De letters op uw plankje zijn: ");
		Speler speler1 = new Speler();
		speler1.plank.plankjeVullen();
		System.out.println(speler1.toonPlankje());
		//speler1.woordUitleggen();
		//System.out.println(speler1.toonPlankje());
		System.out.println("wilt u ruilen (r) of woord uitleggen (w) of stoppen (q)");
		speler1.keuze();
		System.out.println(speler1.toonPlankje());
		System.out.println("Bedankt voor het spelen");
		
	}
}
class Speler{
	String naam;
	Plankje plank = new Plankje();
	Scanner invoer = new Scanner(System.in);	
	
	public String toonPlankje() {
		String antwoord = "";
		for(int i = 0 ; i < plank.stenenOpPlankje.size() ; i++) {
			antwoord = antwoord + plank.stenenOpPlankje.get(i).letter;
		}
		return antwoord;
	}
	
	public void woordUitleggen() {
		System.out.println("welke letters wilt u uitleggen?");
		int gekozenLetter = invoer.nextInt() - 1;
		plank.stenenOpPlankje.remove(gekozenLetter);
		System.out.println(toonPlankje());
	}
	
	public void letterPakken() {
		plank.stenenOpPlankje.add( Stenenzakje.stenen.get(0) );
		Stenenzakje.stenen.remove(0);
		System.out.println(toonPlankje());
	}
	
	public void keuze() {
		int eindeKeuze = 0;
			
		while(eindeKeuze == 0) {
			String mogelijkheden = invoer.nextLine();
			
			switch(mogelijkheden) {
			case "r":
				toonPlankje();
				plank.ruilenLetter();
				toonPlankje();
				break;
			case "w":
				woordUitleggen();
				//System.out.println("Leg uw woord uit");
				//String uitTeLeggenWoord = invoer.nextLine();
				//System.out.println("ingevoerd is "+ uitTeLeggenWoord);
				toonPlankje();
				break;
			case "p":
				letterPakken();
				break;
			case "q":
				System.out.println("u wilt stoppen");
				return;
			default:
				System.out.println("wilt u ruilen (r) of woord uitleggen (w) of stoppen (q)");
			}
		}
	}
	
}
class Plankje{
	ArrayList<Steen> stenenOpPlankje = new ArrayList();
	void plankjeVullen() {
		for(int i = 0 ; i < 7; i ++) {
			stenenOpPlankje.add(  Stenenzakje.stenen.get(0)   );
			Stenenzakje.stenen.remove(0);
		}
	}
	void ruilenLetter() {
		
		stenenOpPlankje.remove(0);
		stenenOpPlankje.add( Stenenzakje.stenen.get(0) );
		Stenenzakje.stenen.remove(0);
		
	}
}
class Steen{
	char letter;
	Steen(char eenLetter){
		letter = eenLetter;
	}
}
class Stenenzakje{
	static ArrayList<Steen> stenen = new ArrayList();
	static Random husselaar = new Random();
	static{
		for( int i = 0; i < 200 ; i++) {
			char getal = (char)(husselaar.nextInt(26) + 65);
			Steen steentje = new Steen(getal);
			stenen.add(steentje);
		}
	}
	static void toonAlleStenen() {
		for(Steen s : stenen) {  // tijdelijk
			System.out.print(s.letter);  
		}
	}
}











