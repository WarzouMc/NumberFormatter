import java.util.*;

/**
 * This class consist to transform number in another format number.
 * @author WarzouMc
 * @version 3.0
 */
public class NumberFormatter {

    /**
     * Call this class for make more readable number
     * Example : 156215 -> 156 215
     */
    public static class NumberSeparator {
        /**
         * Default separator character
         */
        private char separator = ' ';

        /**
         * Call class whit default separator character
         */
        public NumberSeparator(){}


        /**
         * @param separator
         * Call class whit custom separator character
         */
        public NumberSeparator(char separator){
            this.separator = separator;
        }

        /**
         * @param i
         * This method return a String after have do a separation every 3 number for a int type number
         * 154861345 -> 154 861 345
         * @return
         */
        public String transformer(int i) {
            return this.transformer((long) i);
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

    /**
     * Format your number with different units approximations
     * 1546463 -> 1.547M
     */
    public enum LanguageFormatter {

        FRENCH("K", "Mio", "Mia", "T"),
        USA("K", "M", "B", "T");

        private List<String> format;

        LanguageFormatter(String... format) {
            this.format = Arrays.asList(format);
        }

        /**
         * Do conversion from integer
         * @param i
         * @param afterPoint
         * @return
         */
        public String convert(int i, double afterPoint) {
            return convert((long) i, afterPoint);
        }

        /**
         * Do conversion from long
         * @param l
         * @param afterPoint
         * @return
         */
        public String convert(long l, double afterPoint) {
            int size = format.size() - 1;
            afterPoint = Math.pow(10, afterPoint);
            String string = l + "";
            for (int i = 0; i < format.size(); i++) {
                double length = Math.pow(10, 3 * ((size + 1) - i));
                if (l >= length) {
                    string = Math.round((l / length) * afterPoint) / afterPoint + format.get(size - i);
                    break;
                }
            }
            return string;
        }
    }

    /**
     * Convert your number into another numeral writing format
     * 1378 -> ϡυοη or MCCCLXXVIII
     */
    public enum WritingFormat {

        /**
         * Max number limit (for readable number) : 10 000 000
         */
        ROMAN(Arrays.asList(1000000, 900000, 500000, 400000, 100000, 90000, 50000, 40000, 10000, 9000, 5000, 4000, 1000,
                900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1), Arrays.asList("[M]", "[CM]", "[D]", "[CD]", "[C]", "[XC]",
                "[L]", "[XL]", "[X]", "M[X]","[V]", "M[V]", "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")),
        /**
         * Max number limit : 1 000
         */
        GREEK(Arrays.asList(900, 800, 700, 600, 500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1),
                Arrays.asList("ϡ", "ω", "ψ", "χ", "φ", "υ", "τ", "σ", "ρ", "ϟ", "π", "ο", "ξ", "ν", "μ", "λ", "κ", "ι", "θ", "η", "ζ", "ϛ", "ε", "δ", "γ", "β", "α"));

        private Map<Integer, String> map = new HashMap<>();
        WritingFormat(List<Integer> from, List<String> to) {
            from.forEach(integer -> this.map.put(integer, to.get(from.indexOf(integer))));
        }

        /**
         * Do conversion from integer
         * @param i
         * @return
         */
        public String convert(int i) {
            return convert((long) i);
        }

        /**
         * Do conversion from long
         * @param l
         * @return
         */
        public String convert(long l) {
            StringBuilder stringBuilder = new StringBuilder();
            while (l > 0) {
                List<Integer> list = new ArrayList<>(this.map.keySet());
                Collections.sort(list);
                Collections.reverse(list);
                for (Integer integer : list) {
                    if (!(l - integer >= 0))
                        continue;
                    stringBuilder.append(map.get(integer));
                    l -= integer;
                    break;
                }
            }
            return stringBuilder.toString();
        }
    }

}
