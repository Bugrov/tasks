package Task6;

/**  Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
 *   Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
 *   Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.
 */
import java.util.*;


public class Task6 {
    private static int MAX_THINGS = 5;
    private static int MAX_THING_WEIGHT = 9;
    private static int MAX_THING_PRICE = 9;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input max backpack weight");
        int maxWeight;
        try {
            maxWeight = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input numbers must be integers");
            return;
        }
//      generating an initial set of things
        ArrayList<Thing> things=generateTestThings(MAX_THINGS);
//      sorting a set of things to optimize enumeration of values
        Collections.sort(things);
        System.out.println("Things");
        System.out.println(things);
//      calculating all possible combinations of placing things in a backpack
        ArrayList<Backpack> backpacks = new ArrayList<>();
        calculateBackPack(backpacks, null, things, maxWeight, 0);
        if (backpacks.isEmpty()) {
            System.out.println("Backpack is empty");
        } else {
            System.out.println("Best backpack");
            System.out.println(findMax(backpacks));
        }

    }
/*      generating an initial set of things
 */
    private static ArrayList<Thing> generateTestThings(int maxThings) {
        ArrayList<Thing> things = new ArrayList<>(maxThings);
        Random random = new Random();
        for (int i = 0; i < maxThings; i++) {

            things.add(new Thing(random.nextInt(MAX_THING_WEIGHT)+1, random.nextInt(MAX_THING_PRICE)+1 ));
        }
        return things;
    }
/*      calculating all possible combinations of placing things in a backpack
 */
    private static void calculateBackPack(ArrayList<Backpack> backpacks, Backpack backpack, ArrayList<Thing> things, int maxWeight, int i) {
        if (i == things.size()) return;
        calculateBackPack(backpacks, backpack, things, maxWeight, i + 1);
        if ((backpack == null || (backpack.getWeight() + things.get(i).getWeight() <= maxWeight)) && things.get(i).getWeight() <= maxWeight) {
            Backpack newBackpack = (backpack == null) ? new Backpack() : backpack.clone();
            newBackpack.addThing(things.get(i));
            backpacks.add(newBackpack);
            if (newBackpack.getWeight() == maxWeight) return;
            calculateBackPack(backpacks, newBackpack, things, maxWeight, i + 1);
        }
    }
/*      search for a backpack with maximum cargo value
*/
    private static Backpack findMax(ArrayList<Backpack> backpacks) {
        Collections.sort(backpacks);
        return backpacks.get(backpacks.size()-1);
    }
}