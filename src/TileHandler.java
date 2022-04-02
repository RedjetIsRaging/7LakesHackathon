package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class TileHandler {
    GamePanel gp;
    Tile[] tiles;
    int[][] world;
    public TileHandler(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[2];
        world = new int[gp.worldCol][gp.worldRow];
        getTiles();
        loadMap();
    }
    public void getTiles(){

        try{
        tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/res/Floor.png")),false);
        tiles[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/res/Wall.png")),true);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try{
            InputStream mapStream = getClass().getResourceAsStream("/res/world.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(mapStream));
            for(int i = 0; i<gp.worldRow;i++){
                String a = br.readLine();
                String[] nums = a.split(" ");
                for(int j = 0; j<gp.worldCol;j++){
                    world[j][i] = Integer.parseInt(nums[j]);
                }
            }
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        int row = 0;
        int col = 0;
        while(row<gp.worldRow && col<gp.worldCol){
            int tileNum =world[col][row];
            int wX = col*gp.size;
            int wY = row*gp.size;
            int sX = wX-gp.player.worldX+gp.player.x;
            int sY = wY-gp.player.worldY+gp.player.y; 
            if(wX>gp.player.worldX-gp.player.x-gp.size && wX<gp.player.worldX+gp.player.x+gp.size && wY>gp.player.worldY-gp.player.y-gp.size && wY<gp.player.worldY+gp.player.y+gp.size){
                g2.drawImage(tiles[tileNum].image,sX,sY ,gp.size, gp.size, null);
            }
            col++;
            if(col==gp.worldCol){
                col=0;
                row++;
            }

        
        }
    }
}
