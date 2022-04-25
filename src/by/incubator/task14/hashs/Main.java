package by.incubator.task14.hashs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int most;

        HashMap<String, Integer> products = initProducts();
        ProductManager manager = new ProductManager();

        most = manager.mostFrequent(products);
        printMost(most);

        Set<String> allProducts = transferKeys(products);
        print(allProducts);
    }

    public static void printMost(int most) {
        System.out.print("The biggest amount of products is ");
        System.out.println(most);
    }

    public static HashMap<String, Integer> initProducts() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Milk", 48);
        map.put("Bread", 35);
        map.put("Salad", 70);
        map.put("Broccoli", 53);
        map.put("Pineapples", 69);
        map.put("Butter", 54);

        return map;
    }

    public static Set<String> transferKeys(Map<String, Integer> oldProducts) {
        Set<String> newProducts = new HashSet<>(oldProducts.keySet());

        newProducts.add("Sweets");
        newProducts.add("Chocolate");
        newProducts.add("Cookies");
        newProducts.add("Marmalade");

        return newProducts;
    }

    public static void print(Set<String> set) {
        System.out.println("Your store contains:");
        System.out.println(set);
    }
}
