package javaselast.examples.frames;

import javax.swing.*;

import java.awt.*;

public class Wind extends JFrame {

    public Wind() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(640, 480);

        JPanel top = new JPanel();
        top.setBackground(new Color(0xff0000));
        JPanel middle = new JPanel();
        middle.setBackground(new Color(0x00ff00));
        JPanel bottom = new JPanel();
        bottom.setBackground(new Color(0x0000ff));

        add(top, BorderLayout.PAGE_START);
        add(middle, BorderLayout.CENTER);
        add(bottom, BorderLayout.PAGE_END);


        // Теперь играме с layouts
        top.setLayout(new FlowLayout());
        top.add(new JButton("one"));
        top.add(new JButton("two"));
        top.add(new JButton("three"));


        middle.setLayout(null);
        JButton one = new JButton("one ?");
        one.setSize(200, 20);
        one.setLocation(50, 50);
        middle.add(one);

        JButton two = new JButton("two ?");
        two.setSize(500, 30);
        two.setLocation(5, 200);
        middle.add(two);

        JButton three = new JButton("three ?");
        three.setSize(50, 50);
        three.setLocation(300, 300);
        middle.add(three);


        bottom.setLayout(new GridLayout(1, 3));
        bottom.add(new JButton("one!"));
        bottom.add(new JButton("two!"));
        bottom.add(new JButton("three!"));

    }

    /**
     *
     * @param args sdf
     */
    public static void main(final String[] args) {
        new Wind().setVisible(true);
    }
}
