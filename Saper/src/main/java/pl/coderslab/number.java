package pl.coderslab;

public class number {
    private int x;
    private  int y;
    private int number;
    private String name;

    public number(int x, int y, int number, String name) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.name = name;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addNumber() {
        this.number++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
