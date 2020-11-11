package com.shpp.p2p.cs.lmyetolkina.assignment7.Assignment7Part1;

/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import com.shpp.cs.a.simple.SimpleProgram;

import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends SimpleProgram implements NameSurferConstants {

    /* Method: init() */
    private final NameSurferDataBase surferDataBase = new NameSurferDataBase(NAMES_DATA_FILE);;
    private final JTextField textField = new JTextField(30);
    private final NameSurferGraph graph = new NameSurferGraph();

    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */
    public void init() {
        add(new JLabel("Name:"), NORTH);
        add(textField, NORTH);
        textField.setActionCommand("EnterWasPressed");
        textField.addActionListener(this);
        add(new JButton("Graph"), NORTH);
        add(new JButton("Clear"), NORTH);
        add(new JButton("Delete"), NORTH);
        add(graph);
        addActionListeners();
    }

    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Graph") || e.getActionCommand().equals("EnterWasPressed")) {
            NameSurferEntry findEntry = surferDataBase.findEntry(textField.getText());
            if (findEntry != null) graph.addEntry(findEntry);
        } else if (e.getActionCommand().equals("Clear")) {
            graph.clear();
        } else if (e.getActionCommand().equals("Delete")) {
            graph.removeEntry(textField.getText());
        }
        textField.setText("");
    }
}
