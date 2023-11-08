package pl.saper.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.saper.score.Score;
import pl.saper.score.ScoreDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/saper")
public class SaperController {

    public MapGenerator mapGenerator;

    private final ScoreDao scoreDao;

    @Autowired
    public SaperController(MapGenerator mapGenerator, ScoreDao scoreDao) {
        this.mapGenerator = mapGenerator;
        this.scoreDao = scoreDao;
    }

    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String cookieValue = "bright";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("viewModel".equals(cookie.getName())) {
                   cookieValue = cookie.getValue();
                }
            }
        } else {
            Cookie cookie = new Cookie("viewModel", "bright");
            cookie.setMaxAge(34128000);
            response.addCookie(cookie);
            cookieValue = cookie.getValue();
        }
        return cookieValue;
    }

    @GetMapping
    public  String menu(Model model,HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("viewModel", getCookie(request,response));
        return "/menu";
    }


    @GetMapping("/easy")
    public String getEasyMap(Model model,HttpServletRequest request, HttpServletResponse response){

        Map map = new Map("easy", 7 , 7 , getCookie(request,response));
        model.addAttribute("map", map);
        return "saper";
    }

    @PostMapping("/easy")
    @ResponseBody
    public ResponseEntity<List<List<Area>>> postEasyMap(@RequestBody Area area) {
        List<List<Area>> board = mapGenerator.createMap(area,8,8,10);
        return ResponseEntity.ok(board);
    }

    @GetMapping("/normal")
    public String getNormalMap(Model model,HttpServletRequest request, HttpServletResponse response){
        Map map = new Map("normal", 15 , 15 , getCookie(request,response));
        model.addAttribute("map", map);
        return "saper";
    }

    @PostMapping("/normal")
    @ResponseBody
    public ResponseEntity<List<List<Area>>> postNormalMap(@RequestBody Area area) {
        List<List<Area>> board = mapGenerator.createMap(area,16,16,40);
        return ResponseEntity.ok(board);
    }

    @GetMapping("/hard")
    public String getHardMap(Model model,HttpServletRequest request, HttpServletResponse response){
        Map map = new Map("hard", 29 , 15 , getCookie(request,response));
        model.addAttribute("map", map);
        return "saper";
    }

    @PostMapping("/hard")
    @ResponseBody
    public ResponseEntity<List<List<Area>>> postHardMap(@RequestBody Area area) {
        List<List<Area>> board = mapGenerator.createMap(area,30,16,99);
        return ResponseEntity.ok(board);
    }

    @GetMapping("/options")
    public String options(Model model,HttpServletRequest request, HttpServletResponse response) {

        model.addAttribute("viewModel", getCookie(request,response));
        return "options";
    }

    @PostMapping("/options")
    public String changeSettings(@CookieValue(value = "viewModel", defaultValue = "bright") String viewModelCookieValue,
                                 @RequestParam String view, HttpServletResponse response, HttpServletRequest request) {

        Cookie viewModelCookie = new Cookie("viewModel", view);
        viewModelCookie.setMaxAge(34128000);
        response.addCookie(viewModelCookie);

        return "redirect:/saper/options";
    }

    @GetMapping("/scoreList")
    public String scoreList(Model model,HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("viewModel", getCookie(request,response));
        model.addAttribute("easyScors", scoreDao.bestTenEasyScore());
        model.addAttribute("normalScors", scoreDao.bestTenNormalScore());
        model.addAttribute("hardScors", scoreDao.bestTenHardScore());
        return "scoreList";
    }

    @PostMapping("/scoreList")
    public String addScore(@RequestParam String nickName,@RequestParam int gameTime, @RequestParam String dificulty) {
        Score score = new Score(nickName,gameTime, dificulty);
        scoreDao.saveScore(score);
        return "redirect: /saper/scoreList";
    }
}
