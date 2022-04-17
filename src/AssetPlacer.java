package src;

import java.util.Random;

public class AssetPlacer{
    GamePanel gp;
    public AssetPlacer(GamePanel gp){
        this.gp = gp;
    }
    public void placeBad(){
        for(int i = 0; i<gp.bad.length;i++){
            boolean[][] taken = new boolean[gp.worldCol][gp.worldRow];
            Random rand = new Random();
            gp.bad[i] = new Bad(gp);
            int tempX = rand.nextInt(gp.worldCol);
            int tempY = rand.nextInt(gp.worldRow);
            while(taken[tempX][tempY] || gp.th.world[tempX][tempY]==1){
                tempX = rand.nextInt(gp.worldCol);
                tempY = rand.nextInt(gp.worldRow);
            }
            gp.bad[i].worldX = tempX*gp.size;
            gp.bad[i].worldY = tempY*gp.size;

        }
    }
}