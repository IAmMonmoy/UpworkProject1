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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jaggesher
 */
public class VideoPlayer extends JFrame implements ActionListener {

    private ArrayList<String> playList;
    JTextField trackNo = new JTextField(2);
    JTextField trackRating = new JTextField(2);
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
        setBounds(100, 100, 615, 230);
        setTitle("Video Player");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

// close application only by clicking the quit button setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel middle = new JPanel();

        top.add(new JLabel("Enter Video Number:"));
        top.add(trackNo);
        top.add(new JLabel("Enter Video Rating:"));
        top.add(trackRating);
        add("North", top);

        information.setText("");
        middle.add(information);
        add("Center", middle);

        bottom.add(Update_rating);
        Update_rating.addActionListener(this);
        bottom.add(quit);
        quit.addActionListener(this);
        add("South", bottom);

        left.setLayout(new GridLayout(2, 1));
        left.add(check);
        check.addActionListener(this);
        left.add(list);
        list.addActionListener(this);
        add("West", left);

        right.setLayout(new GridLayout(3, 1));
        right.add(addToPlaylist);
        addToPlaylist.addActionListener(this);
        right.add(play);
        play.addActionListener(this);
        right.add(reset);
        reset.addActionListener(this);
        add("East", right);

        setResizable(false);
        setVisible(true);
        playList = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            String key = trackNo.getText();
            String name = VideoData.getName(key);
            if (name == null) {
                information.setText("No such video number");
            } else {
                information.setText(name + " - " + VideoData.getDirector(key));
                information.append("\nRating: "
                        + stars(VideoData.getRating(key)));
                information.append("\nPlay count: " + VideoData.getPlayCount(key));
            }

        } else if (e.getSource() == list) {
            information.setText(VideoData.listAll());

        } else if (e.getSource() == addToPlaylist) {
            String key = trackNo.getText();
            String name = VideoData.getName(key);

            if (name == null) {
                information.setText("No such video number");
            } else {
                information.setText("");

                playList.add(key);


                for (int i = 0; i < playList.size(); i++) {
                    String tempKey = playList.get(i);
                    String tempName = VideoData.getName(tempKey);
                    information.append(tempName + "\n");
                }
            }
        } else if (e.getSource() == play) {
            for (int i = 0; i < playList.size(); i++) {
                String key = playList.get(i);
                VideoData.incrementPlayCount(key);
            }

        } else if (e.getSource() == reset) {
            information.setText("");
            playList.clear();

        } else if (e.getSource() == Update_rating) {
            String key = trackNo.getText();
            String rating = trackRating.getText();
            String name = VideoData.getName(key);
            if (name == null) {
                information.setText("No such video number");
            } else {
                try {
                    int rating_value = Integer.parseInt(rating);
                    information.setText(name + " - " + VideoData.getDirector(key));
                    information.append("\nRating: "
                            + stars(rating_value));
                    information.append("\nPlay count: " + VideoData.getPlayCount(key));

                    VideoData.setRating(key, rating_value);

                } catch (NumberFormatException ex) {
                    information.setText("Rating is invalid");
                } catch (NullPointerException ex) {
                    information.setText("Rating is invalid");
                }
            }
        } else if (e.getSource() == quit) {
            VideoData.close();
            System.exit(0);
        }
    }

    private String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;
    }
}
