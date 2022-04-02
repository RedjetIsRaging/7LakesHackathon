package src;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyPresses implements KeyListener{
    public boolean w,a,s,d;
    @Override
    public void keyTyped(KeyEvent e) {

        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            w = true;
        }
        else if(key == KeyEvent.VK_A){
            a = true;
        }
        else if(key == KeyEvent.VK_S){
            s = true;
        }
        else if(key == KeyEvent.VK_D){
            d = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            w = false;
        }
        else if(key == KeyEvent.VK_A){
            a = false;
        }
        else if(key == KeyEvent.VK_S){
            s = false;
        }
        else if(key == KeyEvent.VK_D){
            d = false;
        }
        
    }
    
}
