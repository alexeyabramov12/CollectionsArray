package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
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