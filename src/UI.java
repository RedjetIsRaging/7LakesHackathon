package src;
import java.awt.*;
import java.text.DecimalFormat;
public class UI {
    boolean victory = false;
    GamePanel gp;
    double time =0;
    DecimalFormat df = new DecimalFormat("#0.00");
    public UI(GamePanel gp){
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        g2.setFont(new Font("Engravers MT",Font.BOLD,60));
        if(gp.player.speed==gp.bad.length+4){
            g2.drawString("YOU WIN", 200, 200);
            victory = true;
        }
        if(!victory){
        time+=1/60d;
        }
        g2.setFont(new Font("Arial",Font.PLAIN,20));
        g2.drawString("Time: "+ df.format(time),600, 50);
    }
    
}
