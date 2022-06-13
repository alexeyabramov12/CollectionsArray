package practice.reverseArray;


public class ReverseArray {

    public static String[] reverse(String[] strings) {
        //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
        int start = 0;
        String string = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            if (start >= i) {
                break;
            }
            string = strings[start];
            strings[start] = strings[i];
            strings[i] = string;
            start++;

        }
        return strings;
    }

}