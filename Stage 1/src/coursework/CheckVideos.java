package coursework;
// import the classes of the abstract windows toolkit and
// swing to enable the use of components such as buttons
// and import event to make use of events such as actionPerformed event
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Extending Jframe class for using the functionality of the class and
//implementing ActionListener interface
public class CheckVideos extends JFrame implements ActionListener {
    
    //initializing components for the GUI
    JTextField trackNo = new JTextField(2);
    TextArea information = new TextArea(6, 50);
    JButton list = new JButton("List All Videos");
    JButton check = new JButton("Check	Video");

    public CheckVideos() {
        //set the layout to border layout
        setLayout(new BorderLayout());
        //set the jframe size
        setBounds(100, 100, 400, 200);
        //set the name for the jframe 
        setTitle("Check Videos");
        //This is for disposing jframe by clicking the X button
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Create a Jpanel and add the components for top bar
        JPanel top = new JPanel();
        top.add(new JLabel("Enter Video Number:"));
        top.add(trackNo);
        top.add(check);
        top.add(list);
        //adding action listener to buttons
        list.addActionListener(this);
        check.addActionListener(this);
        //adding panel to the north
        add("North", top);
        
        //create a panel and then add previously initialized textarea
        //information. Then add the panel to the middle of jframe
        JPanel middle = new JPanel();
        information.setText(VideoData.listAll());
        middle.add(information);
        add("Center", middle);
        
        //This is used so that user can not resize the jframe
        setResizable(false);
        //This makes the jframe visible
        setVisible(true);
    }
    //this function is invoked when list or check button is clicked
    public void actionPerformed(ActionEvent e) {
        //if the clicked button is list button then call lisAll function
        //from VideoData class
        if (e.getSource() == list) {
            information.setText(VideoData.listAll());
        }
        //if the clicked button is check button
        else {
            //take the data from trackNo textfield
            String key = trackNo.getText();
            //get the name from VideoData class using getName(Key) class
            String name = VideoData.getName(key);
            //getName(Key) class in VideoData returns null if no name found
            if (name == null) {
                information.setText("No such video number");
            } else {
                //if name found fill up the information textfield using 
                //the data gathered from VideoData class
                information.setText(name + " - " + VideoData.getDirector(key));
                //passes the rating data found from VideoData to the stars function
                information.append("\nRating: "
                        + stars(VideoData.getRating(key)));
                information.append("\nPlay count: " + VideoData.getPlayCount(key));
            }
        }
    }
    //Produces stars for each rating. Ex: 5 rating then ***** will be produced
    private String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;
    }
}
