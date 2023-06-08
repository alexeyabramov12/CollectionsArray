package practice.reverseArray;


public class ReverseArray {

    public static String[] reverse(String[] array) {
        int start = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (start >= i) {
                break;
            }
            String string = array[start];
            array[start] = array[i];
            array[i] = string;
            start++;
        }
        return array;
    }

}