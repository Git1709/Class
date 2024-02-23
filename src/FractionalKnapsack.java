import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//Rachit_22csu306
class Item {
    int value;
    int weight;
    double cost;
    int index;

    public Item(int value, int weight, int index) {
        this.value = value;
        this.weight = weight;
        this.cost = (double) value / weight;
        this.index = index;
    }
}

public class FractionalKnapsack {
    public static List<Item> fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        List<Item> selectedItems = new ArrayList<>();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i], i);
        }

        // Sort items based on cost (value / weight) in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> item.cost).reversed());

        int i = 0;
        while (i < n && capacity > 0) {
            if (items[i].weight <= capacity) {
                capacity -= items[i].weight;
                selectedItems.add(items[i]);
            } else {
                double fraction = (double) capacity / items[i].weight;
                int fractionalValue = (int) (items[i].value * fraction);
                int fractionalWeight = (int) (items[i].weight * fraction);
                selectedItems.add(new Item(fractionalValue, fractionalWeight, items[i].index));
                capacity = 0; // Knapsack is full
            }
            i++;
        }

        return selectedItems;
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120, 625, 36};
        int[] weights = {10, 20, 30, 1, 2};
        int capacity = 50;

        List<Item> selectedItems = fractionalKnapsack(values, weights, capacity);
        int totalValue = 0;

        System.out.println("Selected Items:");
        for (Item item : selectedItems) {
            System.out.println("Index: " + item.index + ", Value: " + item.value + ", Weight: " + item.weight);
            totalValue += item.value;
        }

        System.out.println("Maximum value that can be obtained: " + totalValue);
    }
}
