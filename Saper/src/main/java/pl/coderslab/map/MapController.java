package pl.coderslab.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Area;

import java.util.List;


@Controller
@RequestMapping("/saper")
public class MapController {

    public MapGenerator mapGenerator;
    private Area area;

    @Autowired
    public MapController(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }



    @GetMapping("/easyMap")
    public String getEasyMap(){
        return "/saperEasyMode";
    }

    @PostMapping("/easyMap")
    @ResponseBody
    public ResponseEntity<List<List<Area>>> postEasyMap(@RequestBody Area area) {
        Map map = mapGenerator.createMap(area,8,8);
        return ResponseEntity.ok(map.getBoard());
    }
}
