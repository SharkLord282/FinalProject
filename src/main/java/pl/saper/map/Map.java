package pl.saper.map;


public class Map {

    private String difficulty;

    private int  xSize;

    private int ySize;

    private String viewMode;

    public Map( String difficulty, int xSize, int ySize, String viewMode) {

        this.difficulty = difficulty;
        this.xSize = xSize;
        this.ySize = ySize;
        this.viewMode = viewMode;
    }


    public Map(){

    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public String getVievMode() {
        return viewMode;
    }

    public void setVievMode(String vievMode) {
        this.viewMode = vievMode;
    }
}
