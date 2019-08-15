    private String numbersSeparator(int i) {
        String i_to_string = Integer.toString(i);
        int lenght = i_to_string.length();
        List<Character> l_c = new ArrayList<>();

        int point = 0;
        String returnString = "";
        for (int j = lenght-1; j > -1 ; j--) {
            point++;
            l_c.add(i_to_string.charAt(j));
            if (j != 0 && point == 3){
                point = 0;
                l_c.add(' ');
            }
        }

        for (int j = l_c.size()-1; j > -1; j--) {
            returnString = returnString + l_c.get(j);
        }
        return returnString;
    }
