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