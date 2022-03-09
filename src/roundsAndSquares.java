import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

public class roundsAndSquares extends JPanel {

    LinkedList<Shape> shapes;
    Timer updateShapes;
    Timer refresh;
    private int canvasWidth;
    private int canvasHeight;
    private static final Random rnd = new Random();

    public roundsAndSquares(int canvasWidth, int canvasHeight) {
        shapes = new LinkedList<>();
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        generateShapes(1000, 1000);
        updateShapes = new Timer(10, new ActionListener() { // 100 times per s
            public void actionPerformed(ActionEvent evt) {
                update();
                repaint();
            }
        });

        updateShapes.setRepeats(true);
        updateShapes.start();

        refresh = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                repaint();
            }
        });

        refresh.setRepeats(true);
        //refresh.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Shape s: shapes) {
            s.draw(g2d);
        }
        g2d.drawRect(100, 100, this.canvasWidth, this.canvasHeight);
        g2d.dispose();
    }

    public void update(){
        for (Shape s: shapes) {
            s.move();
        }
    }

    private void generateShapes(int nbCircles, int nbSquares){
        for (int i = 0; i < nbCircles; i++) {
            shapes.add(new Circle(rnd.nextInt(30),
                    new Vector(rnd.nextInt(this.canvasWidth) + 100, rnd.nextInt(this.canvasHeight) + 100),
                    new Vector(-10 + rnd.nextInt(20), -10 + rnd.nextInt(20)),
                    new Vector(100, 100), new Vector(this.canvasWidth + 100, this.canvasHeight + 100))); // TODO change upper bounds to be relative to lower bounds
        }
        for (int i = 0; i < nbSquares; i++) {
            shapes.add(new Square(rnd.nextInt(30),
                    new Vector(rnd.nextInt(this.canvasWidth) + 100, rnd.nextInt(this.canvasHeight) + 100),
                    new Vector(-10 + rnd.nextInt(20), -10 + rnd.nextInt(20)),
                    new Vector(100, 100), new Vector(this.canvasWidth + 100, this.canvasHeight + 100)));
        }
    }

    private Vector randomPointOnRectangleEdge(int x, int y, int width , int height){
        int pos = rnd.nextInt(2*width + 2*height);
        if(pos < width + height){
            if(pos < width){
                return new Vector(pos + x, y);
            } else{
                return new Vector(width + x, pos + y - width);
            }
        } else{
            pos -= width + height;
            if(pos < width){
                return new Vector(width - pos + x, height + y);
            } else{
                return new Vector(x, height - (pos - width) + y);
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1000, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        roundsAndSquares main = new roundsAndSquares(500, 500);
        f.add(main);
        f.setVisible(true);
    }
}
