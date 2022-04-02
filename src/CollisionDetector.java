package src;

public class CollisionDetector {
    GamePanel gp;
    public CollisionDetector(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity){
        int entityLeft = entity.worldX+entity.solidArea.x;
        int entityRight = entity.worldX+entity.solidArea.x+entity.solidArea.width;
        int entityTop = entity.worldY+entity.solidArea.y;
        int entityBottom = entity.worldY+entity.solidArea.y+entity.solidArea.height;
        
        int entityLeftCol = entityLeft/gp.size;
        int entityRightCol = entityRight/gp.size;
        int entityTopCol = entityTop/gp.size;
        int entityBottomCol = entityBottom/gp.size;

        int tileNum1, tileNum2;

        switch(entity.dir){
            case 0:
            entityTopCol = (entityTop-entity.speed)/gp.size;
            tileNum1 = gp.th.world[entityLeftCol][entityTopCol];
            tileNum2 = gp.th.world[entityRightCol][entityTopCol];
            if(gp.th.tiles[tileNum1].solid || gp.th.tiles[tileNum2].solid){
                entity.colliding = true;
            }
            break;
            case 1:
            entityLeftCol = (entityLeft-entity.speed)/gp.size;
            tileNum1 = gp.th.world[entityLeftCol][entityTopCol];
            tileNum2 = gp.th.world[entityLeftCol][entityBottomCol];
            if(gp.th.tiles[tileNum1].solid || gp.th.tiles[tileNum2].solid){
                entity.colliding = true;
            }
            break;
            case 2:
            entityBottomCol = (entityBottom+entity.speed)/gp.size;
            tileNum1 = gp.th.world[entityLeftCol][entityBottomCol];
            tileNum2 = gp.th.world[entityRightCol][entityBottomCol];
            if(gp.th.tiles[tileNum1].solid || gp.th.tiles[tileNum2].solid){
                entity.colliding = true;
            }
            break;
            case 3:
            entityRightCol = (entityRight+entity.speed)/gp.size;
            tileNum1 = gp.th.world[entityRightCol][entityTopCol];
            tileNum2 = gp.th.world[entityRightCol][entityBottomCol];
            if(gp.th.tiles[tileNum1].solid || gp.th.tiles[tileNum2].solid){
                entity.colliding = true;
            }
            break;
        }
    }
    public int checkEntity(Entity entity, Entity arr[]){
        int index = 999;
        
        for(int i = 0; i<arr.length;i++){
            if(arr[i]!=null){
        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;

        arr[i].solidArea.x = arr[i].worldX+arr[i].solidArea.x;
        arr[i].solidArea.y = arr[i].worldY+arr[i].solidArea.y;

        switch(entity.dir){
            case 0:
            entity.solidArea.y-=entity.speed;
            if(entity.solidArea.intersects(arr[i].solidArea)){
                index = i;
            }
            break;
            case 1:
            entity.solidArea.x-=entity.speed;
            if(entity.solidArea.intersects(arr[i].solidArea)){
                index = i;
            }
            break;
            case 2:
            entity.solidArea.y+=entity.speed;
            if(entity.solidArea.intersects(arr[i].solidArea)){
                index = i;
            }
            break;
            case 3:
            entity.solidArea.x+=entity.speed;
            if(entity.solidArea.intersects(arr[i].solidArea)){
                index = i;
            }
            break;
        }
        entity.solidArea.x = 8;
        entity.solidArea.y = 16;
        arr[i].solidArea.x = 8;
        arr[i].solidArea.y = 16;
        }
    }
        return index;
    
    }
}
