package pl.saper;

import pl.saper.map.Area;
import pl.saper.map.MapGenerator;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {
       MapGenerator mapGenerator = new MapGenerator();
       Area area = new Area(27,6,"click",0);
        List<List<Area>> board =mapGenerator.createMap(area,30,16,99);
        System.out.println(board);

    }


}
