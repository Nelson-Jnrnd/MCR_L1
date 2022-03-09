import java.awt.*;

public abstract class BouncingShape extends Shape{

    private Rectangle bounds;
    public BouncingShape(int size, Point start, Point velocity, Rectangle bounds) {
        super(size, start, velocity);
        this.bounds = bounds;
    }

    @Override
    public void move() {
        if(!bounds.contains(position()))
            bounce();
        super.move();
    }

    private void bounce() {

        if(position().x -  size / 2 < bounds.x){
            velocity.x = Math.abs(velocity.x);
        } else if(position.x + size / 2 > bounds.getMaxX()){
            velocity.x = -Math.abs(velocity.x);
        } else if (position.y - size / 2 < bounds.y){
            velocity.y = Math.abs(velocity.y);
        } else if(position.y + size / 2 > bounds.getMaxY()){
            velocity.y = (-Math.abs(velocity.y));
        }
    }
}
