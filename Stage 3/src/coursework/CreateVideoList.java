/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Shoukhin
 */
public class CreateVideoList extends JFrame implements ActionListener {

    JTextField trackNo = new JTextField(2);
    TextArea information = new TextArea(6, 50);
    JButton list = new JButton("Reset playlist");
    JButton check = new JButton("Add to playlist");
    JButton play = new JButton("play video");

    public CreateVideoList()  {
        setLayout(new BorderLayout());
        setBounds(100, 100, 500, 200);
        setTitle("Create video playlist");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter Video Number:"));
        top.add(trackNo);
        top.add(check);        
        top.add(play);
        top.add(list);
        list.addActionListener(this);
        check.addActionListener(this);        
        play.addActionListener(this);
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
