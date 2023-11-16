import java.util.Scanner;

public class TextReader {// <-- class 1: TextReader

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);      // <-- en scanner behövs när en användare uppmanas skriva in egen text
        TextCounter counter = new TextCounter();    // <-- skapar en instans av klassen TextCounter med namnet counter,
                                                    // detta gör det möjligt att använda metoder och variabler från
                                                    // TextCounter-klassen för att räkna tecken och rader
        System.out.println("Skriv en text, för att avsluta skriv ordet 'stop' på en separat rad.");
        while (true) {                              // <-- här är en while-loop som fortsätter att köras så länge det matas in text
            String input = scan.nextLine();         // <-- en scanner scannar av texten som matas in och lagrar denna i strängen input
            counter.processLine(input);             // <-- anropar metoden counter från TextCounter för att bearbeta den inmatade raden
                                                    // och räkna tecken och rader
                                                    // för att avbryta loopen ska användaren, som beskrivet ovan, skriva ordet "stop"
            if (input.equalsIgnoreCase("stop")) { // <-- här kontrolleras genom en if-loop om "stop" skrivs in på en separat rad
                break;                                       // <-- när ordet stop skrivs in så avbryts loopen.
            }
        }
        System.out.println("Antal tecken: " + counter.getCharacters()); // <-- Hämtar metoden getCharacters från TextCounter och skriver ut totala antal tecknen
        System.out.println("Antal rader: " + counter.getLines()); // <-- Hämtar metoden getLines från TextCounter och skriver ut antal rader
        System.out.println("Antal ord: " + counter.getWords()); // <-- Hämtar metoden getWords från TextCounter och skriver ut antal ord
        System.out.println("Längsta ordet: " + counter.getLongestWord()); // <-- Hämtar metoden getLongestWord från TextCounter och skriver ut vilket ord som är längst
        System.out.println();
        System.out.println("Raden för 'stop' är inte medräknad i varken tecken eller antal ord."); // <-- bara ett förtydligande att just ordet "stop" inte är medräknat någonstans!
    }
}
