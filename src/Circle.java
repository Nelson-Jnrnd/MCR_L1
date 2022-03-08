import java.awt.*;

public class Circle extends BouncingShape{
    public Circle(int size, Vector start, Vector velocity, Vector lowerBounds, Vector higherBounds) {
        super(size, start, velocity, lowerBounds, higherBounds);
    }

    @Override
    void draw(Graphics g) {
        Vector positionNow = position();
        g.drawOval(positionNow.getI() - size / 2, positionNow.getJ() - size / 2, size, size);
       // g.drawLine(start.getI(), start.getJ(), destination.getI(), destination.getJ());
        g.setColor(Color.blue);
        g.fillOval(positionNow.getI() - size / 2, positionNow.getJ() - size / 2, size, size);
    }
}
