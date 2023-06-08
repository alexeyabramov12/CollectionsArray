package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char [][] arrayChars = new char[size][size];
        int start = 0;
        int end = arrayChars.length - 1;
        for (int i = 0; i < arrayChars.length; i++) {
            for (int j = 0; j < arrayChars[i].length; j++) {
                if (j == start || j == end) {
                    arrayChars[i][j] = SYMBOL;
                }else arrayChars[i][j] = ' ';
            }
            start++;
            end--;
        }

        return arrayChars;
    }
}