package pl.coderslab.map;

import org.springframework.stereotype.Component;
import pl.coderslab.Area;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class MapGenerator {

    public List<List<Area>> createEasyMap(int areax,int areay) {
        List<List<Area>> board = new ArrayList<>();
        for (int x = 0; x <= 7 ; x++ ) {
            List<Area> line = new ArrayList<>();
            for (int y = 0; y <= 7 ;y++) {
                line.add(y,new Area(x,y,"emptySpace",0));
            }
            board.add(x,line);
        }
        List<Area> line = board.get(areax);
        Area area = line.get(areay);
        area.setName("click");
        line.set(area.getY(), area);
        board.set(area.getX(),line);
        board = checkAroundAreaAndModify(board, area);

        board = mineGenerator(board,10);



        return board;
    }

    public List<List<Area>> mineGenerator(List<List<Area>> board,int quantity){

        Random random = new Random();

        for (int i = 0; i <= quantity-1; i++){

            List<Area> line = board.get(random.nextInt(0,board.size()));
            Area area = line.get(random.nextInt(0, line.size()));
            if (!area.getName().equals("bomb") && !area.getName().equals("click")) {
                area.setName("bomb");


                line.set(area.getY(), area);
                board.set(area.getX(),line);
                board = checkAroundAreaAndModify(board, area);
            }else {
                i--;
            }

        }
        return board;
    }

    public List<List<Area>> checkAroundAreaAndModify(List<List<Area>> board, Area area){
        List<Area> line = board.get(area.getX());

        if  (area.getX()-1 >=0  && area.getY()-1 >=0) {
           board = modifyArea(board, area, area.getX()-1,area.getY()-1 );
        }
        if (area.getX()-1 >=0 ) {
            board = modifyArea(board, area, area.getX()-1,area.getY() );
        }
        if (area.getX()-1 >=0 && area.getY()+1 < line.size()) {
            board = modifyArea(board, area, area.getX()-1,area.getY()+1 );
        }
        if ( area.getY()-1 >=0) {
            board = modifyArea(board, area, area.getX(),area.getY()-1 );
        }
        if (area.getY()+1 < line.size()) {
            board = modifyArea(board, area, area.getX(),area.getY()+1 );
        }
        if (area.getX()+1 < board.size()&& area.getY()-1 >=0) {
            board = modifyArea(board, area, area.getX()+1,area.getY()-1 );
        }
        if (area.getX()+1 < board.size() ) {
            board = modifyArea(board, area, area.getX()+1,area.getY() );
        }
        if (area.getX()+1 < board.size() && area.getY()+1 < line.size()) {
            board = modifyArea(board, area, area.getX()+1,area.getY()+1 );
        }
        return board;
    }

    public List<List<Area>> modifyArea(List<List<Area>> board, Area area ,int x, int y){
        List<Area> line = board.get(x);
        Area newArea = line.get(y);
        if (area.getName().equals("click")) {
            newArea.setName("click");
        }else {
            if ((newArea.getName().equals("number") && !newArea.getName().equals("bomb")) || newArea.getName().equals("click")) {
                newArea.increaseNumber();
            } else if (!newArea.getName().equals("bomb") && !newArea.getName().equals("click")) {
                newArea.setName("number");
                newArea.increaseNumber();
            }
        }
        line.set(newArea.getY(), newArea);
        board.set(newArea.getX(),line);
        return board;
    }


}
