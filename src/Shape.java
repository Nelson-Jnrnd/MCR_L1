import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Shape {

    protected int size;
    protected Point position;
    protected Point velocity;

    public Shape(int size, Point start, Point velocity) {
        this.size = size;
        this.position = start;
        this.velocity = velocity;
    }

    public Point position(){
        return position;
    }

    public void move(){
        position.translate(velocity.x, velocity.y);
    }

    abstract void draw(Graphics g);
}
