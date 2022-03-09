import javax.swing.*;
import java.awt.*;

public class MainWindow implements Displayer {
    private Image image;
    private Dimension imageDimensions;
    private Graphics2D graphics2D;
    private JFrame frame;
    private JPanel panel;

    public MainWindow() {
        frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(true); // TODO recheck double buff
        frame.add(panel);
        frame.setVisible(true);

        image = panel.createImage(getWidth(), getHeight());
        imageDimensions = new Dimension(getWidth(), getHeight());

        graphics2D = (Graphics2D) image.getGraphics();
    }


    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return graphics2D;
    }

    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image, 0, 0, imageDimensions.width,
                imageDimensions.height, null);
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, imageDimensions.width, imageDimensions.height);
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
