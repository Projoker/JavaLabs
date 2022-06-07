package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class Image extends JPanel {
    ImageIcon img;
    BufferedImage myPicture;
    Raster[] rasters;
    int sprite = 0;
    float angle;

    Image(String[] names) {
        rasters = new Raster[names.length];

        for (int i = 0; i < names.length; i++) {
            try {
                myPicture = ImageIO.read(new File(String.format("D:/Desktop/IT/JetBrains/IdeaProjects/JavaLabs/Lab4/resources/%s.png", names[i])));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            rasters[i] = myPicture.getRaster();
        }

        img = new ImageIcon(myPicture);
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

        repaint();
    }

    public void animate() {
        sprite = (sprite + 1) % rasters.length;

        myPicture.setData(rasters[sprite]);

        repaint();
    }
}
