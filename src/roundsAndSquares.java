import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

public class roundsAndSquares {
    private static final int SHAPES_SIZE_RANGE = 30;
    private static final int SHAPES_VELOCITY_RANGE = 30;

    private LinkedList<Shape> shapes;
    private Timer updateShapes;

    private Rectangle bounds;
    private MainWindow window;

    private static final Random rnd = new Random();

    public roundsAndSquares(int nbCircles, int nbSquares, Rectangle bounds) {
        this.bounds = bounds;
        shapes = new LinkedList<>();
        this.window = MainWindow.getInstance();
        generateShapes(nbCircles, nbSquares);
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
        window.getGraphics().drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    private void generateShapes(int nbCircles, int nbSquares){
        for (int i = 0; i < nbCircles; i++) {
            shapes.add(new Circle(rnd.nextInt(SHAPES_SIZE_RANGE),
                    new Point(rnd.nextInt(bounds.width) + bounds.x, rnd.nextInt(bounds.height) + bounds.y),
                    new Point(-SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE),
                            -SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE)),
                    bounds)); // TODO change upper bounds to be relative to lower bounds
        }
        for (int i = 0; i < nbSquares; i++) {
            shapes.add(new Square(rnd.nextInt(SHAPES_SIZE_RANGE),
                    new Point(rnd.nextInt(bounds.width) + bounds.x, rnd.nextInt(bounds.height) + bounds.y),
                    new Point(-SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE),
                            -SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE)),
                    bounds));
        }
    }


    public static void main(String[] args) {
        roundsAndSquares main = new roundsAndSquares(10, 10, new Rectangle(100, 100, 500, 500));
    }
}
