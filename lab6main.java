import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lab6main {
    private static final String INPUT_FILE = "products.dat";
    private static final String OUTPUT_FILE = "sorted_products.txt";

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        // Чтение объектов из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INPUT_FILE))) {
            while (true) {
                try {
                    Product product = (Product) ois.readObject();
                    products.add(product);
                } catch (EOFException e) {
                    break; // Конец файла
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }

        // Сортировка
        Collections.sort(products);

        // Запись отсортированных объектов в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (Product lab6p : products) {
                writer.write(lab6p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
        }

        // Пример фильтрации
        String searchName = "Товар"; // Задайте нужное наименование
        double maxPrice = 100.0; // Задайте максимальную цену
        int minShelfLife = 30; // Задайте минимальный срок хранения

        System.out.println("Товары с наименованием '" + searchName + "':");
        products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(searchName))
                .forEach(System.out::println);

        System.out.println("\nТовары с наименованием '" + searchName + "' и ценой не выше " + maxPrice + ":");
        products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(searchName) && product.getPrice() <= maxPrice)
                .forEach(System.out::println);

        System.out.println("\nТовары со сроком хранения больше " + minShelfLife + " дней:");
        products.stream()
                .filter(product -> product.getShelfLife() > minShelfLife)
                .forEach(System.out::println);
    }
}