import java.io.Serializable;

public class lab6p implements Comparable<Product>, Serializable {
    private final int id;
    private final String name; // Наименование
    private final String upc; // UPC
    private final String manufacturer; // Производитель
    private final double price; // Цена
    private final int shelfLife; // Срок хранения (в днях)
    private final int quantity; // Количество

    public lab6p(int id, String name, String upc, String manufacturer, double price, int shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Наименование: %s, UPC: %s, Производитель: %s, Цена: %.2f, Срок хранения: %d, Количество: %d",
                id, name, upc, manufacturer, price, shelfLife, quantity);
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name); // Сравнение по наименованию
    }
}