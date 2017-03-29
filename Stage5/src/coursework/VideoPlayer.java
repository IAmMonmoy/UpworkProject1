/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jaggesher
 */

public class VideoPlayer extends JFrame implements ActionListener {
    
    JTextField trackNo = new JTextField(2);
    JTextField trackRating= new JTextField(2);
    TextArea information = new TextArea(6, 50);
    JButton check = new JButton("Check Videos");
    JButton quit = new JButton("Exit");
    JButton Update_rating = new JButton("Update Rating");
    JButton reset = new JButton("Reset playlist");
    JButton addToPlaylist = new JButton("Add to playlist");
    JButton play = new JButton("play video");
    JButton list = new JButton("List All Videos");

    public static void main(String[] args) {
        new VideoPlayer();
    }

    public VideoPlayer() {
        setLayout(new BorderLayout());
        setBounds(100, 100, 615, 200);
        setTitle("Video Player");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

// close application only by clicking the quit button setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel left= new JPanel();
        JPanel right =new JPanel();
        JPanel middle = new JPanel();
        
        top.add(new JLabel("Enter Video Number:"));
        top.add(trackNo);
        top.add(new JLabel("Enter Video Rating:"));
        top.add(trackRating);
        add("North",top);
        
        information.setText("ghsdfhsdgfh");
        middle.add(information);
        add("Center", middle);
        
        bottom.add(Update_rating);
        Update_rating.addActionListener(this);
        bottom.add(quit);
        quit.addActionListener(this);
        add("South", bottom);
        
        left.setLayout(new GridLayout(2,1));
        left.add(check);
        check.addActionListener(this);
        left.add(list);
        list.addActionListener(this);
        add("West", left);
        
        right.setLayout(new GridLayout(3,1));
        right.add(addToPlaylist);
        addToPlaylist.addActionListener(this);
        right.add(play);
        play.addActionListener(this);
        right.add(reset);
        reset.addActionListener(this);
        add("East", right);
        
//        setResizable(false);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
//            new CheckVideos();
        } 
        else if (e.getSource() == quit) {
            VideoData.close();
            System.exit(0);
        }
    }
}
