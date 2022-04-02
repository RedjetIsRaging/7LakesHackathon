package src;
import java.awt.image.BufferedImage;


public class Tile {
    public BufferedImage image;
    public boolean solid;
    public Tile(BufferedImage image,boolean solid){
        this.image = image;
        this.solid = solid;
    }
}
