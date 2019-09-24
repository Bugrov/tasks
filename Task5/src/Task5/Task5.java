package Task5;

/**  Создать программу, которая в последовательности от 0 до N, находит все числа-палиндромы (зеркальное значение равно оригинальному).
*   Длина последовательности N вводится вручную и не должна превышать 100.
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task5{

    public static void main(String[] args) {
        System.out.println("Enter the length of the sequence of numbers");
        int lengthOfSequence;
        try {
            lengthOfSequence = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Sequence length must be an integer");
            return;

        }
        if (lengthOfSequence < 0 || lengthOfSequence > 100) {
            System.out.println("The length of the sequence must be in the range from 0 to 100");
            return;
        }
        for (int i = 0; i < lengthOfSequence; i++) {
            if (i / 10 == 0 || i / 10 == i % 10) {
                System.out.println(i);
            }
        }
    }
}
