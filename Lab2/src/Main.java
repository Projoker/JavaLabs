import javax.swing.*;

public class Main extends JFrame {
    static Console c;

    Main(String title) {
        super(title);

        setSize(1024, 768);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        c = new Console(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        Main frame = new Main("Lab2");
    }
}