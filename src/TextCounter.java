public class TextCounter {  // class 2: TextCounter
    private int countCharacters = 0; // Int-räknare för att lagra antal tecken
    private int countLines = 0; // Int-räknare för att lagra antal rader
    private String[] lines = new String[1000]; // Ett String-array för rader som kan lagra upp till 1000 i sitt array
    private int countWords = 0; // Int-räknare för att lagra antal ord
    private String longestWord = ""; // En string som ska läsa av längsta ordet
    private boolean hasStop = false; // En boolean för ordet "stop", som initierats till standardvärdet false

    public void processLine(String line) {
        if (!line.equalsIgnoreCase("stop")) { // Här är en metod för att bearbeta texten i en rad,
            // inuti metoden kollas inmatningen av strängen "line" av, så länge användaren inte
            // skriver "stop" så fortsätter räknarna öka sina värden

            lines[countLines] = line; // String-arrayet "lines" används för att lägga raderna på rätt plats i arrayet
            countLines++;       // Räknaren för rader ökar med 1, och håller koll på hur många rader som räknats
            countCharacters += line.length(); // Räknaren för tecken ökar med längden av tecknen i raden (strängen line)
            String[] words = line.split(" "); // Delar upp orden för raden med ett mellanslag och lagrar orden i ett array - "words"
            countWords += words.length; // räknare för att öka antalet ord som räknas från arrayet "words"

            for (String word : words) { // Här använder jag en for-loop för att gå igenom varje ord i arrayet "words",
                                        // varje ord tilldelas variabeln "word" för varje genomgång av orden som nu är inlagda i arrayet
                if (word.length() > longestWord.length()) { // här ställer jag villkoret om längden på ordet "word" är större (längre)
                                                            // än längden av det längsta ordet så ska det fortsätta räkna.
                    longestWord = word;          // Inuti loopen uppdateras det längsta ordet om det kommer ett nytt längre ord (enligt villkoret)
                }
            }
        } else {    // Villkoret bryts när ordet stop skrivs in
                    // Eftersom "stop" är initierat till standard false,
                    // så ändras det till true när ordet stop skrivs in
            hasStop = true;
        }
    }

    public int getCharacters() { // metod som hämtar totala antal tecken som räknats hittills
        return countCharacters;
    }

    public int getLines() { // metod som hämtar totala antalet rader som räknats hittills
        return countLines;
    }

    public int getWords() { // metod som hämtar totala antalet ord räknat hittills
        return countWords;
    }

    public String getLongestWord() { // metod som hämtar det längsta ordet
        return longestWord;
    }

    public boolean getHasStop() { // metod som hämtar ifall stop skrivits in eller inte
        return hasStop;
    }
}
