package pl.coderslab;

import pl.coderslab.map.MapGenerator;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MapGenerator mapGenerator = new MapGenerator();
        List<List<Area>> map = mapGenerator.createEasyMap(2,2);
        for (List<Area> line : map) {
            System.out.println(line);
        }

        System.out.println("*".repeat(10));
        Random random = new Random();

    }
}
