import java.awt.*;

public abstract class BouncingShape extends Shape{
    private Vector lowerBounds;
    private Vector higherBounds;
    public BouncingShape(int size, Vector start, Vector velocity,
                         Vector lowerBounds, Vector higherBounds) {
        super(size, start, velocity);
        this.lowerBounds = lowerBounds;
        this.higherBounds = higherBounds;
    }

    @Override
    public void move() {
        Vector pos = position().add(velocity);

        if(pos.getI() - size / 2 < lowerBounds.getI() || pos.getJ() - size / 2 < lowerBounds.getJ() || pos.getI() + size / 2 > higherBounds.getI()
                || pos.getJ() + size / 2 > higherBounds.getJ() ){
            bounce();
        }
        super.move();
    }

    private void bounce() {

        if(position().getI() -  size / 2 < lowerBounds.getI()){
            velocity.setI(Math.abs(velocity.getI()));
        } else if(position.getI() + size / 2 > higherBounds.getI()){
            velocity.setI(-Math.abs(velocity.getI()));
        } else if (position.getJ() - size / 2 < lowerBounds.getJ()){
            velocity.setJ(Math.abs(velocity.getJ()));
        } else if(position.getJ() + size / 2 > higherBounds.getJ()){
            velocity.setJ(-Math.abs(velocity.getJ()));
        }
    }
}
