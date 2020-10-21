import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroceryShopping {

	private static Map<String, Double> menu = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Guenther's Market!");
		setMenu(menu);
		
		boolean isItem = true;
		List<String> itemNames = new ArrayList<>();
		List<Double> itemsPrices = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);
		do {

			do {
				displayMenu(menu);
				String itemName = Validator.getString(scnr, "What Item would you like to Order ? ");

				if (menu.containsKey(itemName)) {
					isItem = true;
					itemNames.add(itemName);
					itemsPrices.add(menu.get(itemName));
				} else {

					isItem = false;
					System.out.println("Invalid Item.");
				}
			} while (!isItem);
		} while (Validator.getYesNo(scnr, "Would you like to order anything else?"));

		System.out.println("Thanks for your order!");
		System.out.println("Guenther's Market!");
		System.out.println("==================");
		System.out.println("Here's what you got :");
		displayList(itemNames, itemsPrices);
		System.out.println("Total amount is $" + getTotal(itemsPrices));
		System.out.println("Average of the total bill is " + getAverage(itemsPrices));
		System.out.println("Costliest Item that you bought is " + getHighestCostItem(itemNames, itemsPrices));
		System.out.println("Cheapest item that you bought is " + getLowestCostItem(itemNames, itemsPrices));
	}

	private static void setMenu(Map<String, Double> menu) {
		menu.put("Apple", 0.99);
		menu.put("Banana", 0.59);
		menu.put("Cauliflower", 1.59);
		menu.put("Dragonfruit", 2.19);
		menu.put("Elderberry", 1.79);
		menu.put("Figs", 2.09);
		menu.put("Grapefuit", 1.99);
		menu.put("Honeydew", 3.49);
	}

	private static void displayMenu(Map<String, Double> menu) {
		System.out.printf("%-15s  %-15s\n", "Item", "Price");
		System.out.printf("%-15s  %-15s\n", "====", "=====");
		for (Map.Entry<String, Double> entry : menu.entrySet()) {
			System.out.printf("%-15s  %-15s\n", entry.getKey(), "$" + entry.getValue());

		}
	}

	private static void displayList(List<String> itemNames, List<Double> itemsPrices) {
		// System.out.printf("%-15s %-15s\n", "Item", "Price");
		// System.out.printf("%-15s %-15s\n", "====", "=====");
		for (int i = 0; i < itemNames.size(); i++) {
			System.out.printf("%-15s  %-15s\n", itemNames.get(i), "$" + itemsPrices.get(i));
		}
	}

	private static double getTotal(List<Double> itemsPrices) {
		double sum = 0;
		for (double itemPrice : itemsPrices) {
			sum += itemPrice;
		}
		return sum;
	}

	private static double getAverage(List<Double> itemsPrices) {
		double sum = getTotal(itemsPrices);
		return (sum / itemsPrices.size());
	}

	private static String getHighestCostItem(List<String> itemNames, List<Double> itemsPrices) {
		double maxPrice = itemsPrices.get(0);
		for (Double itemsPrice : itemsPrices) {
			maxPrice = Math.max(itemsPrice, maxPrice);
		}
		String maxItemName = itemNames.get(itemsPrices.indexOf(maxPrice));
		return maxItemName + " $" + maxPrice;
	}

	private static String getLowestCostItem(List<String> itemNames, List<Double> itemsPrices) {
		double minPrice = itemsPrices.get(0);
		for (Double itemsPrice : itemsPrices) {
			minPrice = Math.min(itemsPrice, minPrice);
		}
		String minItemName = itemNames.get(itemsPrices.indexOf(minPrice));
		return minItemName + " $" + minPrice;
	}
}
