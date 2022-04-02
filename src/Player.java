package src;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
public class Player extends Entity {
    KeyPresses kp;
    public Player(GamePanel gp,KeyPresses kp) {
        super(gp);
        this.kp = kp;
        images = new BufferedImage[4];
        setDefault();
        getImg();
    }
    public void setDefault(){
        hp = 100;
        atk = 10;
        x = (gp.maxCol*24)-(gp.size/2);
        y = (gp.maxRow*24)-(gp.size/2);
        worldX = 400;
        worldY = 300;
        speed = 4;
        solidArea = new Rectangle(8,16,32,32);
    }
    public void getImg(){
        try{
            images[0] = ImageIO.read(getClass().getResourceAsStream("/res/OneUp.png"));
            images[1] = ImageIO.read(getClass().getResourceAsStream("/res/OneLeft.png"));
            images[2] = ImageIO.read(getClass().getResourceAsStream("/res/OneDown.png"));
            images[3] = ImageIO.read(getClass().getResourceAsStream("/res/OneRight.png"));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(kp.w || kp.a || kp.s || kp.d){
        if(kp.w){
            dir = 0;
        }
        else if(kp.a){
 
            dir = 1;
        }
        else if(kp.s){

            dir = 2;
        }
        else if(kp.d){

            dir = 3;
        }
        colliding = false;
        gp.cd.checkTile(this);
        int num = gp.cd.checkEntity(this,gp.bad);
        contact(num);
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
    }
    public void draw(Graphics2D g2){
        
        g2.drawImage(images[dir], x, y, gp.size, gp.size, null);
    }
    
}
