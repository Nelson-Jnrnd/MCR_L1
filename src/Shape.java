import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Shape {

    protected int size;
    protected Vector position;
    protected Vector velocity;

    public Shape(int size, Vector start, Vector velocity) {
        this.size = size;
        this.position = start;
        this.velocity = velocity;
    }

    public Vector position(){
        return position;
    }

    public void move(){
        position = position.add(velocity);
    }

    abstract void draw(Graphics g);
}
