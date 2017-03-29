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
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Shoukhin
 */
public class CreateVideoList extends JFrame implements ActionListener {
    
    private ArrayList<String> playList;

    JTextField trackNo = new JTextField(2);
    TextArea information = new TextArea(6, 50);
    JButton reset = new JButton("Reset playlist");
    JButton addToPlaylist = new JButton("Add to playlist");
    JButton play = new JButton("play video");

    public CreateVideoList()  {
        setLayout(new BorderLayout());
        setBounds(100, 100, 500, 200);
        setTitle("Create video playlist");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter Video Number:"));
        top.add(trackNo);
        top.add(addToPlaylist);        
        top.add(play);
        top.add(reset);
        reset.addActionListener(this);
        addToPlaylist.addActionListener(this);        
        play.addActionListener(this);
        add("North", top);
        JPanel middle = new JPanel();
        information.setText("");
        middle.add(information);
        add("Center", middle);

        setResizable(false);
        setVisible(true);
        
        playList = new ArrayList<>();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addToPlaylist){
            String key = trackNo.getText();
            String name = VideoData.getName(key);
            
            if (name == null) {
                information.setText("No such video number");
            } else {
                information.setText(" ");
                
                playList.add(key);
                
                System.out.println(playList.size());
                for(int i = 0; i < playList.size(); i++)
                {
                    String tempKey = playList.get(i);
                    String tempName = VideoData.getName(tempKey);
                    information.append(tempName + "\n");
                }
            }
                        
        }
        
        else if(e.getSource() == reset)
        {
            information.setText(null);
            playList.clear();
        }
        else if(e.getSource() == play){
            for(int i = 0; i < playList.size(); i++)
            {
                String key = playList.get(i);
                VideoData.incrementPlayCount(key);
            }
        }
    }
}
