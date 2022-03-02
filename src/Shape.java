import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Shape {

    protected int size;
    protected double time;
    protected double speed;
    protected Vector start;
    protected Vector destination;
    private Vector position;

    public Shape(int size, double speed, double time, Vector start, Vector destination) {
        this.size = size;
        this.speed = speed;
        this.time = time;
        this.start = start;
        this.destination = destination;
    }

    public Vector position(){
        return position;
    }

    public void move(){
        time += speed;
        position = start.add(destination.sub(start).multiply(time));
    }

    abstract void draw(Graphics g);
}
