import java.util.*;

class Item {
    double weight;
    double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    public double getValuePerWeight() {
        return value / weight;
    }
}

public class FractionalKnapsack {
    public static double knapsack(Item[] items, double capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.getValuePerWeight(), a.getValuePerWeight()));

        double totalValue = 0.0;
        double remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity == 0) 
                break;

            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            }
            else {
                totalValue += item.getValuePerWeight() * remainingCapacity;
                remainingCapacity = 0;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of items : ");
        int n = sc.nextInt();

        System.out.println("Enter the capacity of the knapsack : ");
        int capacity = sc.nextInt();

        int[] p = new int[n];
        int[] w = new int[n];
        
        System.out.println("Enter the Profits : ");
        for (int i = 0; i<n; i++) 
            p[i] = sc.nextInt();
        
        System.out.println("Enter the Weights :");
        for (int i = 0; i<n; i++) 
            w[i] = sc.nextInt();    
        
        Item[] items = new Item[n];
        for (int i = 0; i<n; i++) 
            items[i] = new Item(w[i],p[i]);
        
        double maxValue = knapsack(items, capacity);
        System.out.println("Maximum value in the knapsack = " + maxValue);
    }
}
