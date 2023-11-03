package pl.coderslab;

import pl.coderslab.map.Area;
import pl.coderslab.map.Map;
import pl.coderslab.map.MapGenerator;
import pl.coderslab.score.ScoreDao;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       MapGenerator mapGenerator = new MapGenerator();
       Area area = new Area(27,6,"click",0);
        List<List<Area>> board =mapGenerator.createMap(area,30,16,99);
        System.out.println(board);

    }
}
