package pl.coderslab;

import pl.coderslab.map.MapGenerator;
import pl.coderslab.score.ScoreDao;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ScoreDao scoreDao = new ScoreDao();

        System.out.println(scoreDao.bestTenEasyScore());

    }
}
