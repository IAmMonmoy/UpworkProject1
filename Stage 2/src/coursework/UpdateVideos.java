package coursework;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UpdateVideos extends JFrame implements ActionListener {

    JTextField trackNo = new JTextField(2);
    JTextField trackRating= new JTextField(2);
    TextArea information = new TextArea(6, 50);
    JButton enter = new JButton("enter");

    public UpdateVideos(){
        setLayout(new BorderLayout());
        setBounds(100, 100, 500, 200);
        setTitle("Create video playlist");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter Video Number:"));
        top.add(trackNo);
        top.add(new JLabel("Enter Video Rating:"));
        top.add(trackRating);
        top.add(enter);        
        enter.addActionListener(this);
        add("North", top);
        JPanel middle = new JPanel();
        information.setText("");
        middle.add(information);
        add("Center", middle);

        setResizable(false);
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
