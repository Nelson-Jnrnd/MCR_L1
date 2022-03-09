import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

public class roundsAndSquares {

    private LinkedList<Shape> shapes;
    private Timer updateShapes;

    private Dimension bounds;
    private MainWindow window;

    private static final Random rnd = new Random();

    public roundsAndSquares(Dimension bounds) {
        this.bounds = bounds;
        shapes = new LinkedList<>();
        this.window = new MainWindow();
        generateShapes(10, 10);
        // TODO retry separated timer
        updateShapes = new Timer(10, new ActionListener() { // 100 times per s
            public void actionPerformed(ActionEvent evt) {
                update();
                window.repaint();
            }
        });

        updateShapes.setRepeats(true);
        updateShapes.start();
    }

    public void update(){
        for (Shape s: shapes) {
            s.move();
            s.draw(window.getGraphics());
        }
        window.getGraphics().setColor(Color.black);
        window.getGraphics().drawRect(100, 100, bounds.width, bounds.height);
    }

    private void generateShapes(int nbCircles, int nbSquares){
        for (int i = 0; i < nbCircles; i++) {
            shapes.add(new Circle(rnd.nextInt(30),
                    new Point(rnd.nextInt(bounds.width) + 100, rnd.nextInt(bounds.height) + 100),
                    new Point(-10 + rnd.nextInt(20), -10 + rnd.nextInt(20)),
                    new Rectangle(100, 100, bounds.width, bounds.height))); // TODO change upper bounds to be relative to lower bounds
        }
        for (int i = 0; i < nbSquares; i++) {
            shapes.add(new Square(rnd.nextInt(30),
                    new Point(rnd.nextInt(bounds.width) + 100, rnd.nextInt(bounds.height) + 100),
                    new Point(-10 + rnd.nextInt(20), -10 + rnd.nextInt(20)),
                    new Rectangle(100, 100, bounds.width, bounds.height)));
        }
    }


    public static void main(String[] args) {
        roundsAndSquares main = new roundsAndSquares(new Dimension(500, 500));
    }
}
