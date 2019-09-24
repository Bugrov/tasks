package Task1;

/**     Создать программу, которая будет сообщать, является ли целое число, введенное пользователем,
*       чётным или нечётным, простым или составным.  Если пользователь введёт не целое число,
*       то сообщать ему об ошибке.
*/
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Enter an integer:");
        Scanner sc = new Scanner(System.in);
        BigInteger num;
        StringBuilder sumMessage = new StringBuilder();

        try {
            num = sc.nextBigInteger();
        } catch (InputMismatchException e) {
            System.out.println("The input number must be an integer");
            return;
        }
        if (isEven(num)) {
            sumMessage.append("The entered number is even");
        }else {
            sumMessage.append("The entered number is odd");
        }

        try {
            if (isPrime(num)) {
                sumMessage.append(" and prime");
            } else {
                sumMessage.append(" and compound");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sumMessage);
    }
    private static boolean isEven (BigInteger num) {
        return !num.testBit(0);
    }


    private static boolean isPrime(BigInteger num) throws IllegalArgumentException {
            BigInteger i = BigInteger.valueOf(2);
            if (num.compareTo(BigInteger.ONE) != 1) {
                throw new IllegalArgumentException("To determine a prime and compound number, the number must be greater than one.");
            }
            while (i.compareTo(num) == -1) {
                if (num.remainder(i).equals(BigInteger.ZERO)) return false;
                i = i.add(BigInteger.ONE);
            }
            return true;
        }
    }