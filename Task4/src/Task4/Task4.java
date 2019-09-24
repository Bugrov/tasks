package Task4;

/**     Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра)
*       Текст и слово вводится вручную.
*/
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence");
        String text = sc.nextLine().toUpperCase();
        System.out.println("Enter the word");
        String word = sc.nextLine().toUpperCase();
        if (text.isEmpty() || word.isEmpty()) {
            System.out.println("Sentence and word can't be empty");
            return;
        }

        int count = countWord(text, word, 0);
        System.out.println("The word is used " + count + " time(s)");
    }

    private static int countWord(String text, String word, int count) {
        int i = text.indexOf(word);
        if (i < 0) return count;
        int nextPos = i+word.length();

        if (nextPos <= text.length()) {


//      we consider only separate words, checking characters before and after the word
            if ((nextPos >= text.length()-1 || !Character.isLetter(text.charAt(nextPos))) &&
                    ((i != 0 && !Character.isLetter(text.charAt(i-1))) || (i == 0 && count == 0))) {
                count++;
            }
            count = countWord(text.substring(nextPos), word, count);
        }
        return count;
    }
}
