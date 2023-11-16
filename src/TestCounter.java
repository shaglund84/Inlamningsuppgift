
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestCounter {// class 3: TestCounter
    @Test
    public void testGetLongestWord() { // Testar funktionen att ta fram längsta ordet

        // Arrange - Här skapar jag en instans av TextCounter som heter myCounter,
                 // samt skapar en String-array och tilldelar denna ett antal ord
                // då jag måste skriva in orden manuellt i TextReader så får jag
             // tilldela orden manuellt här.
        TextCounter myCounter = new TextCounter();
        String[] wordsArray = {"päron", "applikationsprogrammeringsgränssnitt", "spelare", "bubbelmaskin"};
        String expected = "applikationsprogrammeringsgränssnitt";

        // Act - Går igenom varje ord i arrayet med en for-loop
                // inuti loopen skickas varje ord genom metoden processLine
                 // för att sedan jämföras för att få fram längsta ordet
                    // Jag skrev först såhär:
                    // for (int i = 0; i < wordsArray.length; i++) {String word = wordsArray[i];
                    // men valde det lite snyggare sättet med en "enchanced" for-loop som jag fick förslag om
        for (String word : wordsArray) {
            myCounter.processLine(word);
        }
        String actual = myCounter.getLongestWord();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWords() {
        // Arrange
        TextCounter myCounter = new TextCounter();
        String[] wordsArray = {"päron", "applikationsprogrammeringsgränssnitt", "spelare", "bubbelmaskin"};
        int expected = 4;

        // Act - skickar en sammanslagen sträng (join) med alla ord från arrayet till processLine-metoden
            // och hämtar sedan totala antalet ord genom getWords-metoden
        myCounter.processLine(String.join(" ", wordsArray));
        int actual = myCounter.getWords();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testHasStop() {
        // Arrange
        TextCounter myCounter = new TextCounter();
        boolean expected = true;

        // Act - skickar tre rader för bearbetning i processLine
            // och hämtar om ordet "stop" har angetts genom metoden hasStop
        myCounter.processLine("en rad för päron, spelare och bubbelmaskin");
        myCounter.processLine("en helt egen rad för applikationsprogrammeringsgränssnitt");
        myCounter.processLine("stop");
        boolean actual = myCounter.getHasStop();

        // Assert
        assertEquals(expected, actual);

    }
}
