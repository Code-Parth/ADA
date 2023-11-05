import java.util.Arrays;
import java.util.Comparator;

// Class to represent an item in the knapsack
class Item {
    int weight;
    int value;

    // Constructor for the Item class
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    // Function to solve the fractional knapsack problem
    public static double fractionalKnapsack(int capacity, Item[] items) {
        // Sort the items by value-to-weight ratio in ascending order
        Arrays.sort(items, Comparator.comparingDouble(item -> (double) item.value / item.weight));

        double maxTotalValue = 0; // Initialize the maximum total value

        // Iterate over the items from highest to lowest value-to-weight ratio
        for (int i = items.length - 1; i >= 0; i--) {
            // If the capacity is 0, break from the loop
            if (capacity == 0) {
                break;
            }

            // If the item's weight is less than or equal to the remaining capacity
            if (items[i].weight <= capacity) {
                // Add the item's value to the total value
                maxTotalValue += items[i].value;
                // Subtract the item's weight from the remaining capacity
                capacity -= items[i].weight;
            } else {
                // If the item's weight is more than the remaining capacity
                // Calculate the fraction of the item's weight that fits in the remaining capacity
                double fraction = (double) capacity / items[i].weight;
                // Add the value of the fraction of the item to the total value
                maxTotalValue += fraction * items[i].value;
                // Set the remaining capacity to 0
                capacity = 0;
            }
        }

        // Return the maximum total value
        return maxTotalValue;
    }

    public static void main(String[] args) {
        int capacity = 50; // The capacity of the knapsack
        Item[] items = { // The items to choose from
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };

        // Solve the fractional knapsack problem
        double maxValue = fractionalKnapsack(capacity, items);

        // Print the maximum value that can be put in the knapsack
        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}