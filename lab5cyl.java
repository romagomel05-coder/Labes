import java.io.Serializable;

public class Cylinder implements Comparable<Cylinder>, Serializable {
    private double height;
    private double radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public double volume() {
        return Math.PI * radius * radius * height; // Формула объема цилиндра: πr²h
    }

    @Override
    public String toString() {
        return String.format("Цилиндр: высота = %.2f, радиус = %.2f, объем = %.2f", height, radius, volume());
    }

    @Override
    public int compareTo(Cylinder other) {
        return Double.compare(this.volume(), other.volume()); // Сравнение по объему
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static final String INPUT_FILE = "cylinders.dat";
    private static final String OUTPUT_FILE = "sorted_cylinders.txt";

    public static void main(String[] args) {
        ArrayList<Cylinder> cylinders = new ArrayList<>();

        // Чтение объектов из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INPUT_FILE))) {
            while (true) {
                try {
                    Cylinder cylinder = (Cylinder) ois.readObject();
                    cylinders.add(cylinder);
                } catch (EOFException e) {
                    break; // Конец файла
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Сортировка
        Collections.sort(cylinders);

        // Запись отсортированных объектов в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (Cylinder cylinder : cylinders) {
                writer.write(cylinder.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class CylinderFileCreator {
    public static void main(String[] args) {
        ArrayList<Cylinder> cylindersToSave = new ArrayList<>();
        cylindersToSave.add(new Cylinder(10, 2));
        cylindersToSave.add(new Cylinder(5, 3));
        cylindersToSave.add(new Cylinder(7, 1.5));
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cylinders.dat"))) {
            for (Cylinder cylinder : cylindersToSave) {
                oos.writeObject(cylinder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}