/* Student Name: Zihao Zheng
 * Program: Image Puzzle
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IPuzzle implements ActionListener
{
    public static void main(String[] args)
    {
        //Setting the Frame
        JFrame.setDefaultLookAndFeelDecorated(true);                
        JFrame frame = new JFrame("IPuzzle");
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setting the Frame
        
        //Creating, setting panel, Labels//
        JPanel mainPane = new JPanel();
        frame.setContentPane(mainPane);
        mainPane.setLayout(new GridLayout(3,0));
                
        JPanel pane1 = new JPanel();
        pane1.setPreferredSize(new Dimension(600,500));
        pane1.setVisible(true);        
        JPanel pane2 = new JPanel();  
        pane2.setVisible(true);
               
        StringBuilder sb = new StringBuilder(64); //String format
                      sb.append("<html>             Put your deduction and problem-solving skills to solve some picture puzzle!").
                      append(" The rule is very simple, try to put the picture back to original by moving the blocks").
                      append(" to different places! Let get start it! Press the 'Start' button below to choose what").
                      append(" image you want to use!");
                      
        JLabel intro = new JLabel(sb.toString());
        Font font = new Font("Arial",Font.ITALIC|Font.PLAIN,25);
        Font font2 = new Font("Arial",Font.ITALIC|Font.BOLD,22);
        intro.setFont(font);
        
        JButton start = new JButton("Start");
        start.addActionListener(new IPuzzle());
        start.setFont(font2);
        
        ImageIcon source = new ImageIcon("image.png");
        JLabel image = new JLabel(source,JLabel.CENTER);
        //Creating, setting panel, Labels//
        
        //Adding to the panel//
        mainPane.add(pane1);
        mainPane.add(intro);
        mainPane.add(pane2);
        pane1.add(image);                     
        pane2.add(start);                        
        frame.toFront();
        frame.setVisible(true);
        //Adding to the panel//
    }
    
    //Run the Puzzle class when Start is pressed//
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("Start"))
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Puzzle();
                }
           });
        }
    }
    //Run the Puzzle class when Start is pressed//
}
