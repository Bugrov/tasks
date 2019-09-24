package Task3;

/**     Создать программу, которая будет:
*       подсчитывать количество слов в предложении
*       выводить их в отсортированном виде
*       делать первую букву каждого слова заглавной.
*       Предложение вводится вручную. (Разделитель пробел (“ ”)).
*/
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        System.out.println("Enter sentence:");
        Scanner sc= new Scanner(System.in);
        String sentence = sc.nextLine();
        if (sentence == null || sentence.isEmpty()) {
            System.out.println("Sentence can't be empty");
            return;
        }
        String[] words = sentence.trim().split("\\s+");
        System.out.printf("This sentence consists of %d word(s).\n", words.length);
        Arrays.stream(words)
                .map(word -> word.substring(0,1).toUpperCase().concat(word.substring(1)))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);
    }
}
