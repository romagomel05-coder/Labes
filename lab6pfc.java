import java.io.*;
import java.util.ArrayList;

public class lab6pfc {
    public static void lab6main(String[] args) {
        ArrayList<Product> productsToSave = new ArrayList<>();
        
        productsToSave.add(new Product(1, "Товар A", "123456", "Производитель A", 50.99, 365, 10));
        productsToSave.add(new Product(2, "Товар B", "654321", "Производитель B", 29.99, 30, 15));
        productsToSave.add(new Product(3, "Товар C", "456789", "Производитель A", 75.50, 60, 5));
        productsToSave.add(new Product(4, "Товар D", "987654", "Производитель C", 19.99, 120, 20));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.dat"))) {
            for (Product product : productsToSave) {
                oos.writeObject(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}