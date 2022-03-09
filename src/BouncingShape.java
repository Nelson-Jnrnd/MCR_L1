import java.awt.*;

public abstract class BouncingShape extends Shape{

    private Rectangle bounds;
    public BouncingShape(int size, Vector start, Vector velocity, Rectangle bounds) {
        super(size, start, velocity);
        this.bounds = bounds;
    }

    @Override
    public void move() {
        Vector pos = position().add(velocity);

        if(!bounds.contains(pos.getI(), pos.getJ()))
            bounce();
        super.move();
    }

    private void bounce() {

        if(position().getI() -  size / 2 < bounds.x){
            velocity.setI(Math.abs(velocity.getI()));
        } else if(position.getI() + size / 2 > bounds.getMaxX()){
            velocity.setI(-Math.abs(velocity.getI()));
        } else if (position.getJ() - size / 2 < bounds.y){
            velocity.setJ(Math.abs(velocity.getJ()));
        } else if(position.getJ() + size / 2 > bounds.getMaxY()){
            velocity.setJ(-Math.abs(velocity.getJ()));
        }
    }
}
