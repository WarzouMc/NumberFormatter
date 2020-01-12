import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersSeparator {

    private char separator = ' ';
    public NumbersSeparator(char separator){
        this.separator = separator;
    }

    public NumbersSeparator(){}

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
