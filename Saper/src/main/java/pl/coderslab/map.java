package pl.coderslab;

import java.util.List;

public class map<T> {

    private List<List<T>> board;
    private String difficulty;

    public map(List<List<T>> board, String difficulty) {
        this.board = board;
        this.difficulty = difficulty;
    }

    public List<List<T>> getBoard() {
        return board;
    }

    public void setBoard(List<List<T>> board) {
        this.board = board;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
