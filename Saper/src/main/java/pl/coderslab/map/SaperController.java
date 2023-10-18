package pl.coderslab.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.score.Score;
import pl.coderslab.score.ScoreDao;

import java.sql.Time;
import java.util.List;


@Controller
@RequestMapping("/saper")
public class SaperController {

    public MapGenerator mapGenerator;
    private Area area;
    private final ScoreDao scoreDao;

    @Autowired
    public SaperController(MapGenerator mapGenerator, ScoreDao scoreDao) {
        this.mapGenerator = mapGenerator;
        this.scoreDao = scoreDao;
    }

    @GetMapping
    public  String mebu(){
        return "/bright/menu";
    }


    @GetMapping("/easy")
    public String getEasyMap(){
        return "/bright/saperEasyMode";
    }

    @PostMapping("/easy")
    @ResponseBody
    public ResponseEntity<List<List<Area>>> postEasyMap(@RequestBody Area area) {
        Map map = mapGenerator.createMap(area,8,8,10);
        return ResponseEntity.ok(map.getBoard());
    }

    @GetMapping("/scoreList")
    public String scoreList(Model model) {
        model.addAttribute("scors", scoreDao.bestTenEasyScore());
        return "bright/scoreList";
    }

    @PostMapping("/scoreList")
    public String addScore(@RequestParam String nickName,@RequestParam int gameTime, @RequestParam String dificulty) {
        Score score = new Score(nickName,gameTime, dificulty);
        scoreDao.saveScore(score);
        return "redirect: /saper/scoreList";
    }
}
