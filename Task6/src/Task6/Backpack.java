package Task6;
import java.util.ArrayList;

public class Backpack implements Comparable<Backpack>{

    private int weight;
    private int price;
    private ArrayList<Thing> things;

    public Backpack() {
        things = new ArrayList<>();
    }

    public void addThing(Thing thing) {
        things.add(thing);
        weight += thing.getWeight();
        price += thing.getPrice();
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setThings(ArrayList<Thing> things) {
        this.things = things;
    }

    public Backpack clone() {
        Backpack backpack = new Backpack();
        backpack.setPrice(this.price);
        backpack.setWeight(this.weight);
        backpack.setThings((ArrayList)this.things.clone());
        return backpack;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "weight=" + weight +
                ", price=" + price +
                ", things=" + things +
                "}\n";
    }
    @Override
    public int compareTo(Backpack o) {
        return this.getPrice() - o.getPrice();
    }
}