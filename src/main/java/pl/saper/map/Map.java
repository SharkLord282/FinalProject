package pl.saper.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Map {

    private String difficulty;

    private int  xSize;

    private int ySize;

    private String viewMode;


}
