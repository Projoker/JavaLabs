package graphics;

import core.Main;

import java.util.List;

public class Render {
    List<Image> images;
    Thread thread;

    Render(List<Image> images) {
        this.images = images;

        thread = animate();
    }

    private Thread animate() {
        Thread thread = new Thread(() -> {
            while (true) {
                for (var image : images) {
                    image.animate();
                }
                Main.b.mainImage.rotate(3);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        return thread;
    }
}
