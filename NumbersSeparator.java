import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class consist to transform number in String with better number readability.
 * @author WarzouMc
 * @version 2.0
 */
public class NumbersSeparator {
    /**
     * Default separator character
     */
    private char separator = ' ';

    /**
     * Call class whit default separator character
     */
    public NumbersSeparator(){}


    /**
     * @param separator
     * Call class whit custom separator character
     */
    public NumbersSeparator(char separator){
        this.separator = separator;
    }

    /**
     * @param i
     * This method return a String after have do a separation every 3 number for a int type number
     * 154861345 -> 154 861 345
     * @return
     */
    public String transformer(int i) {
        String intToString = Integer.toString(i);
        int length = intToString.length();
        List<Character> characterList = new ArrayList<>();
        int point = 0;
        for (int j = length-1; j > -1 ; j--) {
            point++;
            characterList.add(intToString.charAt(j));
            if (j != 0 && point == 3){
                point = 0;
                characterList.add(this.separator);
            }
        }
        StringBuilder returnString = new StringBuilder();
        Collections.reverse(characterList);
        characterList.forEach(returnString::append);
        return returnString.toString();
    }

    /**
     * @param l
     * This method return a String after have do a separation every 3 number for a long type number
     * 1215348361583515635186515 -> 1 215 348 361 583 515 635 186 515
     * @return
     */
    public String transformer(long l) {
        String longToString = Long.toString(l);
        int length = longToString.length();
        List<Character> characterList = new ArrayList<>();
        int point = 0;
        for (int j = length-1; j > -1 ; j--) {
            point++;
            characterList.add(longToString.charAt(j));
            if (j != 0 && point == 3){
                point = 0;
                characterList.add(this.separator);
            }
        }
        StringBuilder returnString = new StringBuilder();
        Collections.reverse(characterList);
        characterList.forEach(returnString::append);
        return returnString.toString();
    }
}
