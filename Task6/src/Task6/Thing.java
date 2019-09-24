package Task6;


public class Thing implements Comparable<Thing> {

    private int weight;
    private int price;

    public Thing(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "weight=" + weight +
                ", price=" + price +
                "}\n";
    }
    @Override
    public int compareTo(Thing o) {
        return this.getWeight() - o.getWeight();
    }
}