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
        super.move();
        Vector pos = position();
        if(pos.getI() - size / 2 < lowerBounds.getI() || pos.getJ() - size / 2 < lowerBounds.getJ() || pos.getI() + size / 2 > higherBounds.getI()
                || pos.getJ() + size / 2 > higherBounds.getJ() ){
            bounce();
        }
    }

    private void bounce() {
       /*Vector wall;*/
        if(position().getI() < lowerBounds.getI() || position().getI() > higherBounds.getI()){
            // top or bottom wall
            velocity = velocity.getMirrorYVector();
        } else{
            // left or right wall
            velocity = velocity.getMirrorXVector();
        }
        //destination.add(position().reflectionAcrossLine(wall));
      /* destination = start;
       start = position();

        this.time = 0;*/
    }
}
