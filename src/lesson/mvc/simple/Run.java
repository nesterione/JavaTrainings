package lesson.mvc.simple;

import javax.swing.*;

/**
 * Created by igor on 17.09.2015.
 */
public class Run {

    // ��� ���������� ������ MVC, ����� �������� �������� ����, ��� ������������ ����� ���� ��������
    // ���������� ����� http://www.oracle.com/technetwork/articles/javase/index-142890.html

    public static void main(String[] args) {
        View view = new View();
        view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        view.setSize(640,480);
        view.setVisible(true);
    }
}
