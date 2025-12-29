import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class lab5M {
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