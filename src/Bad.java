package src;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;
public class Bad extends Entity{
    int locked;
    public Bad(GamePanel gp){
        super(gp);
        images = new BufferedImage[4];
        setDefault();
        getImg();
    }
    public void setDefault(){
        hp = 100;
        atk = 10;
        speed = 4;
        solidArea = new Rectangle(8,18,32,32);
        locked = 0;
        
    }
    public void getImg(){
        try{
            images[0] = ImageIO.read(getClass().getResourceAsStream("/res/BadUp.png"));
            images[1] = ImageIO.read(getClass().getResourceAsStream("/res/BadLeft.png"));
            images[2] = ImageIO.read(getClass().getResourceAsStream("/res/BadDown.png"));
            images[3] = ImageIO.read(getClass().getResourceAsStream("/res/BadRight.png"));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void act(){
        locked++;
        if(locked==90){
            Random rand = new Random();
            int r = rand.nextInt(100);
            if(r<=25){
                dir = 0;
            }
            else if(r>25&&r<=50){
                dir = 1;
            }
            else if(r>50 && r<=75){
                dir = 2;
            }
            else if(r>75 && r<=100){
                dir = 3;
            }
            locked = 0;
        }
    }

    }
