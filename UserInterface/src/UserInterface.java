import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UserInterface {
    private JFrame frame;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;

    public UserInterface() {
        frame = new JFrame("User Interface");
        textArea = new JTextArea(20, 40);
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuItem1 = new JMenuItem("Print Date and Time");
        menuItem2 = new JMenuItem("Write to log.txt");
        menuItem3 = new JMenuItem("Change Background Color");
        menuItem4 = new JMenuItem("Exit");

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);


        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDateAndTime();
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToFile();
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(textArea);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void printDateAndTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        textArea.append(dateFormat.format(date) + "\n");
    }

    private void writeToFile() {
        String content = textArea.getText();
        try {
            FileWriter writer = new FileWriter("log.txt");
            writer.write(content);
            writer.close();
            JOptionPane.showMessageDialog(frame, "Text written to log.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeBackgroundColor() {
        Random rand = new Random();
        float hue = rand.nextFloat();
        Color randomColor = Color.getHSBColor(hue, 0.7f, 0.9f);
        frame.getContentPane().setBackground(randomColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInterface());
    }
}
