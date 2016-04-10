package javaselast.lessons.lesson08.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class First extends JFrame {


    public First() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setTitle("My java swing app");

        JButton button = new JButton("my button");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Eggs are not supposed to be green.",
                        "Inane error",
                        JOptionPane.WARNING_MESSAGE);
//                System.out.println( JOptionPane.showInputDialog(null,
//                        "Input something"));
            }
        });

        JButton butt = new JButton("open file dialog");
        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                if( fileChooser.showDialog(null,"sdf") == JFileChooser.APPROVE_OPTION ) {
                   String path = fileChooser.getSelectedFile().toString();
                    JOptionPane.showMessageDialog(null,path);
                }

            }
        });

        add(butt,BorderLayout.PAGE_END);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(237, 242, 223));

        panel.addMouseMotionListener(new MouseAdapter() {


            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("sdf");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = panel.getGraphics();
                g.setColor(new Color(147, 58, 92));
                g.fillOval(e.getX(), e.getY(), 10, 10);
            }
        });

//        panel.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//
//            }
//
//        });


        add(panel);
        add(button, BorderLayout.PAGE_START);
    }


    public static void main(String[] args) {
        First first = new First();
        first.setVisible(true);
    }

}
