package pl.coderslab;

import pl.coderslab.map.MapGenerator;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        MapGenerator mapGenerator = new MapGenerator();
        List<List<Area>> map = mapGenerator.createEasyMap(random.nextInt(0,8),random.nextInt(0,8));
        for (List<Area> line : map) {
            System.out.println(line);
        }

        System.out.println("*".repeat(10));

    }
}
