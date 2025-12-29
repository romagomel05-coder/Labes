class Manager {
    private final int age;
    private final boolean isResponsible;

    public Manager(String surname, int age, boolean isResponsible) {
        this.age = age;
        this.isResponsible = isResponsible;
    }

    public int getAge() {
        return age;
    }

    public boolean isResponsible() {
        return isResponsible;
    }
}

public class lab4 {
    public static void main(String[] args) {
        Manager[] managers = new Manager[]{
            new Manager("Иванов", 35, true),
            new Manager("Петров", 42, false),
            new Manager("Сидоров", 29, true),
            new Manager("Кузнецов", 50, true),
            new Manager("Александров", 30, false),
            new Manager("Дмитриев", 38, true),
            new Manager("Федоров", 45, true),
            new Manager("Смирнов", 55, false),
            new Manager("Николаев", 27, true),
            new Manager("Андреев", 40, true)
        };

        int totalAge = 0;
        int responsibleCount = 0;

        for (Manager manager : managers) {
            totalAge += manager.getAge();
            if (manager.isResponsible()) {
                responsibleCount++;
            }
        }

        double averageAge = (double) totalAge / managers.length;

        System.out.printf("Средний возраст управляющих: %.2f%n", averageAge);
        System.out.println("Количество управляющих, которые справляются с обязанностями: " + responsibleCount);
    }
}