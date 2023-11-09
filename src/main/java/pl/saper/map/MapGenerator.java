package pl.saper.map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class MapGenerator {

    public List<List<Area>> createMap(Area clickArea, int sizex, int sizey , int bombs) {
        List<List<Area>> board = new ArrayList<>();
        for (int y = 0; y <= sizey -1 ; y++ ) {
            List<Area> line = new ArrayList<>();
            for (int x = 0; x <= sizex -1 ;x++) {
                line.add(x,new Area(x,y,"emptySpace",0));
            }
            board.add(y,line);
        }

        List<Area> line = board.get(clickArea.getY());
        line.set(clickArea.getX(), clickArea);
        board.set(clickArea.getY(),line);
        board = checkAroundAreaAndModify(board, clickArea);

        board = mineGenerator(board,bombs);

        return board;
    }

    public List<List<Area>> mineGenerator(List<List<Area>> board,int quantity){

        Random random = new Random();

        for (int i = 0; i <= quantity-1; i++){

            List<Area> line = board.get(random.nextInt(0,board.size()));
            Area area = line.get(random.nextInt(0, line.size()));
            if (!area.getName().equals("bomb") && !area.getName().equals("click")) {
                area.setName("bomb");


                line.set(area.getX(), area);
                board.set(area.getY(),line);
                board = checkAroundAreaAndModify(board, area);
            }else {
                i--;
            }

        }
        return board;
    }

    public List<List<Area>> checkAroundAreaAndModify(List<List<Area>> board, Area area){
        List<Area> line = board.get(area.getY());

        if  (area.getX()-1 >=0  && area.getY()-1 >=0) {
           board = modifyArea(board, area, area.getX()-1,area.getY()-1 );
        }
        if (area.getX()-1 >=0 ) {
            board = modifyArea(board, area, area.getX()-1,area.getY() );
        }
        if (area.getX()-1 >=0 && area.getY()+1 < board.size()) {
            board = modifyArea(board, area, area.getX()-1,area.getY()+1 );
        }
        if ( area.getY()-1 >=0) {
            board = modifyArea(board, area, area.getX(),area.getY()-1 );
        }
        if (area.getY()+1 < board.size()) {
            board = modifyArea(board, area, area.getX(),area.getY()+1 );
        }
        if (area.getX()+1 < line.size()&& area.getY()-1 >=0) {
            board = modifyArea(board, area, area.getX()+1,area.getY()-1 );
        }
        if (area.getX()+1 < line.size() ) {
            board = modifyArea(board, area, area.getX()+1,area.getY() );
        }
        if (area.getX()+1 < line.size() && area.getY()+1 < board.size()) {
            board = modifyArea(board, area, area.getX()+1,area.getY()+1 );
        }
        return board;
    }

    public List<List<Area>> modifyArea(List<List<Area>> board, Area area ,int x, int y){
        List<Area> line = board.get(y);
        Area newArea = line.get(x);
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
        line.set(newArea.getX(), newArea);
        board.set(newArea.getY(),line);
        return board;
    }


}
