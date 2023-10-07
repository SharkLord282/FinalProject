package pl.coderslab.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.map.MapGenerator;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/saper")
public class MapController {

    public MapGenerator mapGenerator;

    @Autowired
    public MapController(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }



    @GetMapping
    public String easyMap(){
        return "/saperEasyMode";
    }

    @PostMapping
    public String easyMap(Model model, @RequestParam int x,@RequestParam int y) {
        Map map = new Map(mapGenerator.createEasyMap(x,y), "Easy");

        model.addAttribute("map", map);
        return "/saperEasyMode";
    }
}
