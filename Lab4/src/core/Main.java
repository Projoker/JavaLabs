package core;

import graphics.Block;

import javax.swing.*;

public class Main extends JFrame {
    static Main frame;
    static Console c;
    public static Block b;

    Main(String title) {
        super(title);

        setSize(1024, 768);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b = new Block(this);
        c = new Console(this, b);

        setVisible(true);
    }

    public static void main(String[] args) {
        frame = new Main("Lab4");
    }
}