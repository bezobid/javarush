package com.javarush.test.mytests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.lang.Override;

/**
 * Created by bezobid on 20.06.2016.
 */
public class SwingTest implements ActionListener{
    JButton button = new JButton("Send message");

    public static void main(String[] args) {
        SwingTest test = new SwingTest();
        test.go();
    }

    public void go(){
        JFrame frame = new JFrame("Hello!");
        JTextField textField = new JTextField(50);
        JTextArea messages = new JTextArea(10, 50);
        JTextArea users = new JTextArea(10, 10);


        textField.setEditable(true);
        messages.setEditable(false);
        users.setEditable(false);

        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(messages), BorderLayout.WEST);
        frame.getContentPane().add(new JScrollPane(users), BorderLayout.EAST);
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        frame.setSize(800, 800);
        frame.setVisible(true);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Message sent");
    }
}
