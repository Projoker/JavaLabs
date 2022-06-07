package core;

import graphics.Block;

import javax.swing.*;
import java.awt.*;

public class Console {
    Block block;
    JTextField input;
    JTextArea output;

    Console(JFrame container, Block block) {
        this.block = block;

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

    private void command() {
        String line = input.getText();
        input.setText("");

        String out = output.getText();
        if (!out.equals("")) {
            out += "\n";
        }
        output.setText(out + line);

        String[] command = line.split(" ");
        switch (command.length) {
            case 1:
            case 2:
                switch (command[0]) {
                    case "rem":
                        try {
                            block.removeSoldier();

                            output.setText(out + "cmd: successful removed");
                        } catch (NumberFormatException e) {
                            output.setText(out + "cmd: wrong command argument.");
                        }
                        Main.frame.repaint();
                        break;
                    case "add":
                        try {
                            int number = Integer.parseInt(command[1]);
                            block.createSoldiers(number);

                            output.setText(out + String.format("cmd: successful added %s", number));
                        } catch (NumberFormatException e) {
                            output.setText(out + "cmd: wrong command argument.");
                        }
                        break;
                    case "rotate":
                        try {
                            int angle = Integer.parseInt(command[1]);
                            block.rotate(angle);

                            output.setText(out + String.format("cmd: successful rotation %s", angle));
                        } catch (NumberFormatException e) {
                            output.setText(out + "cmd: wrong command argument.");
                        }
                        break;
                }
                break;
        }
    }
}
