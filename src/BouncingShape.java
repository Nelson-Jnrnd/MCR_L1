import java.awt.*;

public abstract class BouncingShape extends Shape{
    private Vector lowerBounds;
    private Vector higherBounds;
    public BouncingShape(int size, double speed, double time, Vector start, Vector destination,
                         Vector lowerBounds, Vector higherBounds) {
        super(size, speed, time, start, destination);
        this.lowerBounds = lowerBounds;
        this.higherBounds = higherBounds;
    }

    @Override
    public void move() {
        super.move();
        Vector pos = position();
        if(pos.getI() < lowerBounds.getI() || pos.getJ() < lowerBounds.getJ() || pos.getI() > higherBounds.getI()
                || pos.getJ() > higherBounds.getJ() ){
            bounce();
        }
    }

    private void bounce() {

       /*Vector wall;
        if(position().getI() < lowerBounds.getI() || position().getI() > higherBounds.getI()){
            // top or bottom wall
            //destination = start.sub(position()).getMirrorXVector();
            wall = new Vector(lowerBounds.getI(), higherBounds.getI());
        } else{
            // left or right wall
            wall = new Vector(lowerBounds.getJ(), higherBounds.getJ());
            //destination = start.sub(position()).getMirrorYVector();
        }
        destination.add(position().reflectionAcrossLine(wall));
        */
       destination = start;
       start = position();

        this.time = 0;
    }
}
