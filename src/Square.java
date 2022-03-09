import java.awt.*;

public class Square extends BouncingShape{

    public Square(int size, Point start, Point velocity,
                  Rectangle bounds){
        super(size, start, velocity, bounds);
    }

    @Override
    public void draw(Graphics g) {
        Point positionNow = position();
        g.drawRect(positionNow.x - size / 2, positionNow.y - size / 2, size, size);
        //g.drawLine(start.getI(), start.getJ(), destination.getI(), destination.getJ());
        g.setColor(Color.yellow);
        g.fillRect(positionNow.x - size / 2, positionNow.y - size / 2, size, size);
    }

}