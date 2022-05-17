import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Image extends JPanel {
    ImageIcon img;
    JLabel label;
    float angle;

    Image(String name) {
        img = new ImageIcon(String.format("D:/Desktop/IT/JetBrains/IdeaProjects/JavaLabs/Lab2/resources/%s.png", name));
        label = new JLabel(name, img, JLabel.CENTER);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        AffineTransform at = g2D.getTransform();
        at.rotate(Math.toRadians(angle), img.getIconWidth() / 2, img.getIconHeight() / 2);
        g2D.setTransform(at);

        g.drawImage(img.getImage(), 0, 0, null);
    }

    public void rotate(int rot) {
        angle += rot;
        this.repaint();
    }
}
