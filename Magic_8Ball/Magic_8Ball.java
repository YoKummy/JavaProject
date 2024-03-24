package Magic_8Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class frame extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JLabel inputJLabel;
    private JLabel outputLabel;
    private JTextField input;
    private JTextField outputText;
    private ArrayList<String> output = new ArrayList<>();
    private JButton ask;
    private JButton clear;
    private JButton play_again;
    
    frame(){
        contentPane = new JPanel();

        setBounds(200, 200, 800, 500);
        setTitle("Magic-8 ball");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        inputJLabel = new JLabel();
        inputJLabel.setText("Ask your question: ");
        inputJLabel.setBounds(20, 20, 150, 20);

        input = new JTextField();

        input.setText("");
        input.setBounds(130, 20, 400, 20);
        input.setColumns(20);
        input.setEditable(true);

        outputLabel = new JLabel();
        outputLabel.setBounds(560, 20, 200, 20);
        outputLabel.setText("Answer:");

        outputText = new JTextField();
        outputText.setBounds(560, 40, 200, 300);
        outputText.setText("");
        outputText.setColumns(20);
        outputText.setEditable(false);

        ask = new JButton();
        ask.setText("Ask");
        ask.setBounds(20, 60, 80, 20);
        ask.addActionListener(this);

        clear = new JButton();
        clear.setText("clear");
        clear.setBounds(110, 60, 80, 20);
        clear.addActionListener(this);

        play_again = new JButton();
        play_again.setText("Play again");
        play_again.setBounds(200, 60, 100, 20);
        play_again.addActionListener(this);

        contentPane.add(inputJLabel);
        contentPane.add(input);
        contentPane.add(outputLabel);
        contentPane.add(outputText);
        contentPane.add(ask);
        contentPane.add(clear);
        contentPane.add(play_again);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}

public class Magic_8Ball {
    public static void main(String[] args) {
        new frame();
    }
}
