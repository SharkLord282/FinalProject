package pl.saper.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    private int x;
    private int y;
    private String name;
    private  int number;


    public void increaseNumber() {
        this.number++;
    }


}
