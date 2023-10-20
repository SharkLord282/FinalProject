package pl.coderslab.map;

public class Area {
    private int x;
    private int y;
    private String name;
    private  int number;


    public Area(int x, int y, String name, int number) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.number = number;
    }

    public Area() {
    }

    @Override
    public String toString() {
        return "Area{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void increaseNumber() {
        this.number++;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
