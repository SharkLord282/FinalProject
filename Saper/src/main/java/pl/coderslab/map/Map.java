package pl.coderslab.map;

import org.springframework.stereotype.Component;
import pl.coderslab.Area;

import java.util.List;


public class Map {

    private List<List<Area>> board;
    private String difficulty;

    public Map(List<List<Area>> board, String difficulty) {
        this.board = board;
        this.difficulty = difficulty;
    }

    public List<List<Area>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Area>> board) {
        this.board = board;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
