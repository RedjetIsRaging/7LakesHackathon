package src;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public class Entity {
    public BufferedImage[] images;
    public int hp,atk,x,y,worldX,worldY,speed,dir;
    public Rectangle solidArea;
    public boolean colliding = false;
    GamePanel gp;
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        int screenX = worldX-gp.player.worldX+gp.player.x;
        int screenY = worldY-gp.player.worldY+gp.player.y;
        if(worldX+gp.size>gp.player.worldX-gp.player.x && worldX-gp.size<gp.player.worldX+gp.player.x && worldY+gp.size>gp.player.worldY-gp.player.y && worldY-gp.size<gp.player.worldY+gp.player.y){
            g2.drawImage(images[dir],screenX,screenY,gp.size,gp.size, null);
        }
    }
    public void act(){
    }
    public void update(){
        act();
        colliding = false;
        gp.cd.checkTile(this);
        if(!colliding){
            switch(dir){
                case 0:
                worldY-=speed;
                break;
                case 1:
                worldX-=speed;
                break;
                case 2:
                worldY+=speed;
                break;
                case 3:
                worldX+=speed;
                break;
            }
        }

        }
        public void contact(int i){
            if(i!=999){
            gp.bad[i] = null;
            speed+=1;
            }
        }

}
