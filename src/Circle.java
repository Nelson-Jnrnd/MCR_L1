import java.awt.*;

public class Circle extends BouncingShape{
    public Circle(int size, Point start, Point velocity, Rectangle bounds) {
        super(size, start, velocity, bounds);
    }

    @Override
    void draw(Graphics g) {
        Point positionNow = position();
        g.drawOval(positionNow.x - size / 2, positionNow.y - size / 2, size, size);
       // g.drawLine(start.getI(), start.getJ(), destination.getI(), destination.getJ());
        g.setColor(Color.blue);
        g.fillOval(positionNow.x - size / 2, positionNow.y - size / 2, size, size);
    }
}
