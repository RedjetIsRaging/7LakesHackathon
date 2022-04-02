package src;
import java.awt.*;
import javax.swing.*;
public class GamePanel extends JPanel implements Runnable{
    //Initialiation of Variables
    final int size = 48;
    final int maxCol = 16;
    final int maxRow = 12;
    final int screenHeight = size*maxRow;
    final int screenWidth = size*maxCol;
    final int worldCol = 48;
    final int worldRow = 36;
    int worldX = 400;
    int worldY = 200;
    int speed = 4;
    int fps = 60;
    Thread thread;
    public KeyPresses kp = new KeyPresses();
    public TileHandler th = new TileHandler(this);
    public CollisionDetector cd = new CollisionDetector(this);
    public AssetPlacer ap = new AssetPlacer(this);
    public UI ui = new UI(this);
    Player player = new Player(this,kp);
    Entity[] bad = new Entity[25];
    public void setGame(){
        ap.placeBad();
    }
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.BLUE);
        this.setDoubleBuffered(true);
        this.addKeyListener(kp);
        this.setFocusable(true);
        setGame();
    }
    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        double interval = 1000000000/fps;
        double execute = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(thread!=null){
            currentTime = System.nanoTime();
            execute+=(currentTime-lastTime)/interval;
            lastTime = currentTime;
            if(execute>=1){
            update();
            repaint();
            execute--;
            }
        }
    }
    public void update(){
        player.update();
        for(int i = 0; i<bad.length;i++){
            if(bad[i] != null){
                bad[i].update();
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        th.draw(g2);
        ui.draw(g2);
        player.draw(g2);
        for(int i = 0; i<bad.length;i++){
            if(bad[i]!= null){
                bad[i].draw(g2);
            }
        }
        
        g2.dispose();
    }
}
