import java.awt.*;

public class Square extends BouncingShape{

    public Square(int size, double speed, double time, Vector start, Vector destination,
                  Vector lowerBounds, Vector higherBounds){
        super(size, speed, time, start, destination, lowerBounds, higherBounds);
    }

    @Override
    public void draw(Graphics g) {
        Vector positionNow = position();
        g.drawRect(positionNow.getI() - size / 2, positionNow.getJ() - size / 2, size, size);
        g.drawLine(start.getI(), start.getJ(), destination.getI(), destination.getJ());
        g.setColor(Color.yellow);
        g.fillRect(positionNow.getI() - size / 2, positionNow.getJ() - size / 2, size, size);
    }

}