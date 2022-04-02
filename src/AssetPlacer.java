package src;


public class AssetPlacer{
    GamePanel gp;
    public AssetPlacer(GamePanel gp){
        this.gp = gp;
    }
    public void placeBad(){
        for(int i = 0; i<gp.bad.length;i++){
            gp.bad[i] = new Bad(gp);
            gp.bad[i].worldX = i*48+48;
            gp.bad[i].worldY = i*36+48;
        }
    }
}