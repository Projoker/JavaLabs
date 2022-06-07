package graphics;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Block {
    JFrame container;
    Image mainImage;
    Render render;
    List<Image> animImages;

    public Block(JFrame container) {
        this.container = container;

        mainImage = new Image(new String[]{"Wings"});
        mainImage.setBounds(340, 0, 400, 400);
        mainImage.setOpaque(false);
        this.container.add(mainImage);

        var bgImg = new Image(new String[]{"WindMill"});
        bgImg.setBounds(405, 160, 400, 400);
        bgImg.setOpaque(false);
        this.container.add(bgImg);

        animImages = new ArrayList<>();
        createSoldiers(5);

        render = new Render(animImages);
    }

    public void createSoldiers(int n) {
        for (int i = 0; i < n; i++) {
            var soldier = new Image(new String[]{"Walk1", "Walk2", "Walk3", "Walk4"});
            soldier.setBounds(10 + animImages.size() * 80, 500, 80, 80);
            soldier.setOpaque(false);

            animImages.add(soldier);
            this.container.add(soldier);
        }
    }

    public void removeSoldier() {
        System.out.println(animImages.size());
        System.out.println(render.images.size());

        if (animImages.size() == 0)
            return;

        this.container.remove(animImages.get(animImages.size() - 1));

        animImages.remove(animImages.size() - 1);
    }

    public void rotate(int angle) {
        mainImage.rotate(angle);
    }
}
