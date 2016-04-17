
package javaselast.examples.editor;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class MainFile extends JFrame {

    public MainFile() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setTitle("File editor by Eugene_Shpetny v.0.01");

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0x97B7C9));
        add(topPanel);
        add(topPanel, BorderLayout.PAGE_START);

        JEditorPane editorPane = new JEditorPane();

        JPanel middle = new JPanel();
        middle.setBackground(new Color(0xD0FCC7));
        middle.setLayout(new BorderLayout());
        middle.add(editorPane, BorderLayout.CENTER);
        add(middle, BorderLayout.CENTER);


        JButton openFile = new JButton("Open File");

        JButton saveFile = new JButton("Save File");


        openFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedReader br=null;
                JFileChooser jFileChooser = new JFileChooser();
                int ret = jFileChooser.showDialog(null, "File Open");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    String str = String.valueOf(jFileChooser.getSelectedFile());
                    try {
                        br = new BufferedReader(new FileReader(str));

                        // TODO не смотри на это, лучше делать циклом
                        String text = br.lines().reduce((x, y) -> x + "\n" + y).get();

                        editorPane.setText(text);

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } finally {
                        try {
                            br.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Error !");
                }
            }
        });

         topPanel.add(openFile);
        topPanel.add(saveFile);
        //JLabel jLabel = new JLabel();
        //jLabel.setText("Open");
        //topPanel.add(jLabel);


    }

  public static void main(String[] args) {
    MainFile main = new MainFile();
    main.setVisible(true);
  }
}