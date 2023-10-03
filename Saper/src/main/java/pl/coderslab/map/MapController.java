package pl.coderslab.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.coderslab.map.MapGenerator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/saper")
public class MapController {

    public MapGenerator mapGenerator;

    @Autowired
    public MapController(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }



    @GetMapping
    public String boardView(Model model){
        Map map = new Map(mapGenerator.createEasyMap(4,3), "Easy");

        model.addAttribute("map", map);
        return "/saperEasyMode";

    }
}
