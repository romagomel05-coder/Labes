import java.util.ArrayList;
import java.util.Scanner;

class Toy {
    private String name;
    private double price;
    private String manufacturer;
    private int quantity;
    private int minAge;

    public Toy(String name, double price, String manufacturer, int quantity, int minAge) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.minAge = minAge;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinAge() {
        return minAge;
    }

    public void displayToyDetails() {
        System.out.println("Название: " + name);
        System.out.println("Цена: " + price);
        System.out.println("Изготовитель: " + manufacturer);
        System.out.println("Количество: " + quantity);
        System.out.println("Минимальная возрастная граница: " + minAge);
        System.out.println("--------------------------");
    }
}

class ToyStore {
    private ArrayList<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
        // Пример добавления игрушек
        toys.add(new Toy("Мячи", 10.50, "Производитель 1", 100, 3));
        toys.add(new Toy("Куклы", 15.75, "Производитель 2", 50, 4));
        toys.add(new Toy("Конструктор", 20.0, "Производитель 3", 75, 5));
    }

    public void displayToysForAge(int age) {
        System.out.println("Игрушки, подходящие для возраста " + age + " лет:");
        for (Toy toy : toys) {
            if (toy.getMinAge() <= age && toy.getQuantity() > 0) {
                toy.displayToyDetails();
            }
        }
    }
}

public class Main {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    private static boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        String username = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToyStore toyStore = new ToyStore();

        if (authenticate()) {
            System.out.println("Добро пожаловать, администратор!");
            // Здесь может быть функционал администратора
        } else {
            System.out.println("Авторизация не удалась. Выход.");
            return;
        }

        System.out.print("Введите возраст ребенка: ");
        int age = scanner.nextInt();

        toyStore.displayToysForAge(age);
    }
}