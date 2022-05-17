import javax.swing.*;
import java.awt.*;

public class Console {
    Image bgImg;
    Image img;
    JTextField input;
    JTextArea output;

    Console(JFrame container) {
        img = new Image("Wings");
        img.setBounds(340, 0, 400, 400);
        img.setOpaque(false);
        container.add(img);
        bgImg = new Image("WindMill");
        bgImg.setBounds(405, 160, 400, 400);
        container.add(bgImg);

        input = new JTextField(85);
        input.addActionListener(e -> command());

        JButton button = new JButton(">");
        button.addActionListener(e -> command());

        output = new JTextArea(5, 90);
        JScrollPane scrollOutput = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(input);
        panel.add(button);
        panel.add(scrollOutput);
        panel.setBounds(5, 603, 999, 120);
        container.add(panel);
    }

    void command() {
        String line = input.getText();
        input.setText("");

        String out = output.getText();
        if (!out.equals("")) {
            out += "\n";
        }
        output.setText(out + line);

        String[] command = line.split(" ");
        if (command.length == 2 && command[0].equals("rotate")) {
            try {
                int angle = Integer.parseInt(command[1]);
                img.rotate(angle);
                output.setText(out + String.format("cmd: successful rotation %s", angle));
            } catch (NumberFormatException e) {
                output.setText(out + "cmd: wrong command argument.");
            }
        }
    }
}
