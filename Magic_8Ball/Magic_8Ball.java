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
    private JButton ask;
    private JButton clear;
    
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
        input.setBounds(140, 20, 400, 20);
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

        contentPane.add(inputJLabel);
        contentPane.add(input);
        contentPane.add(outputLabel);
        contentPane.add(outputText);
        contentPane.add(ask);
        contentPane.add(clear);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == ask) {
        String question = input.getText();
        if (!question.isEmpty()) {
            String answer = getRandomAnswer();
            outputText.setText(answer);
        }
        else{
            JOptionPane.showMessageDialog(this, "Bonk, please enter a question");
        }
       }
       if (e.getSource() == clear) {
        input.setText(null);
        outputText.setText(null);
    }
    }
    
    private String getRandomAnswer(){
    String[] answers = {
        "It is certain.",
        "It is decidedly so.",
        "Without a doubt.",
        "Yes – definitely.",
        "You may rely on it.",
        "As I see it, yes.",
        "Most likely.",
        "Outlook good.",
        "Yes.",
        "Signs point to yes.",
        "Reply hazy, try again.",
        "Ask again later.",
        "Better not tell you now.",
        "Cannot predict now.",
        "Concentrate and ask again.",
        "Don't count on it.",
        "My reply is no.",
        "My sources say no.",
        "Outlook not so good.",
        "Very doubtful.",
        "Are you serious?",
        "This...hmmm"
    };
    Random random = new Random();
    int index = random.nextInt(answers.length);
    return answers[index];
    }
}

public class Magic_8Ball {
    public static void main(String[] args) {
        new frame();
    }
}
