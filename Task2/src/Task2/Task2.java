package Task2;

/**      Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
*        и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
*        Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
*/
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        System.out.println("Enter two integers:");
        Scanner sc = new Scanner(System.in);
        BigInteger numA;
        BigInteger numB;
        try {
            numA = sc.nextBigInteger();
            numB = sc.nextBigInteger();
        } catch (InputMismatchException e) {
            System.out.println("Input numbers must be integers");
            return;
        }
        //https://ru.m.wikipedia.org/wiki/%D0%9D%D0%B0%D0%B8%D0%B1%D0%BE%D0%BB%D1%8C%D1%88%D0%B8%D0%B9_%D0%BE%D0%B1%D1%89%D0%B8%D0%B9_%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D0%B5%D0%BB%D1%8C
        if (numA.compareTo(BigInteger.ZERO) != 0 || numB.compareTo(BigInteger.ZERO) != 0) {
            System.out.printf("Greatest Common Divisor of %d and %d is %d.\n", numA, numB, numA.gcd(numB));
        } else {
            System.out.println("For GCD, both parameters must not be zero");
        }
        if (numA.compareTo(BigInteger.ZERO) != 0 && numB.compareTo(BigInteger.ZERO) != 0) {
            System.out.printf("Least Common Multiple of %d and %d is %d.", numA, numB, lcm(numA, numB));
        } else {
            System.out.println("For LCM, none of the parameters should be equal to zero");
        }
    }

    private static BigInteger lcm(BigInteger numA, BigInteger numB) {
        return (numA.abs().multiply(numB.abs()).divide(numA.gcd(numB)));
    }
}
