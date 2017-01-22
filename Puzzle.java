/*Student Name: Zihao Zheng
 * Program: Image Puzzle
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Puzzle extends JFrame implements ActionListener 
{
    //Creating variables
    private static JPanel pane;
    private static JButton button;
    private static JLabel label;
    private static Image source,image;
    int[][] structure;    
    
    public static String finalChoice = "";
    //Creating variables
    public Puzzle() 
    {      
            
            structure = new int[][]{    {0, 1, 2},  //Postion, structure of the puzzle
                                        {3, 4, 5}, 
                                        {6, 7, 8}, 
                                        {9, 10, 11}};
    
            pane = new JPanel(); //Panel
            pane.setLayout(new GridLayout(4, 4, 0, 0));//Panel
            
            //Ask for input 
            JOptionPane.showMessageDialog(null, "There's 8 different kinds of picture you can play with", "Make your choice",JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "What kind the fruit picture you want to play?", "Make your choice",JOptionPane.PLAIN_MESSAGE);           
            finalChoice = JOptionPane.showInputDialog(null, "Enter the fruit you want to play with: \nWatermelon,Orange,Cherry,Peach.Apple,Grape,Strawberry,Cantaloupe");
            //Ask for input 
            
            //Conditions when different types of fruit typed in 
            if(finalChoice.equalsIgnoreCase("Watermelon"))
            {
                finalChoice = "1.jpg";
            }
            else if(finalChoice.equalsIgnoreCase("Peach"))
            {
                finalChoice = "2.jpg";
            }
            else if(finalChoice.equalsIgnoreCase("Apple"))
            {
                finalChoice = "3.jpg";
            }
            else if(finalChoice.equalsIgnoreCase("Orange"))
            {
                finalChoice = "4.jpg";
            }
            else if(finalChoice.equalsIgnoreCase("Grape"))
            {
                finalChoice = "5.jpg";
            }
            else if(finalChoice.equalsIgnoreCase("Cherry"))
            {
                finalChoice = "6.jpg";
            }
            else if(finalChoice.equalsIgnoreCase("Strawberry"))
            {
                finalChoice = "7.jpg";
            }
            else if(finalChoice.equalsIgnoreCase("Cantaloupe"))
            {
                finalChoice = "8.jpg";
            }
            //Conditions when different types of fruit typed in
            
            //When the choice are made, start to find the file 
            if(!finalChoice.equals("")){
                ImageIcon i1 = new ImageIcon(Puzzle.class.getResource(finalChoice)); //Get the file
                source = i1.getImage(); //Get the source
        
                int width = i1.getIconWidth(); //Width of puzzle
                int height = i1.getIconHeight(); //Height of puzzle
        
        
                add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.NORTH);    
                add(pane, BorderLayout.CENTER);
        
                
                for ( int i = 0; i < 4; i++) 
                {
                    for ( int k = 0; k < 3; k++) 
                    {
                        if ( k == 2 && i == 3) 
                        {
                            label = new JLabel("");
                            pane.add(label);            //Blank place
                        } 
                        else 
                        {
                            //Crop the images
                            button = new JButton();
                            button.addActionListener(this);
                            pane.add(button);
                            image = createImage(new FilteredImageSource(source.getSource(),
                                                new CropImageFilter(k*width/3, i*height/4, (width/3)+1, height/4)));
                            button.setIcon(new ImageIcon(image));
                        }
                    }
                }
        
                //Setting of Frame
                setSize(800, 600);
                setTitle("Puzzle");
                setResizable(false);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setVisible(true);
                //Setting of Frame
            }

    }
    

    public void actionPerformed(ActionEvent e)
    {               
        if(!finalChoice.equals("")){
            JButton button = (JButton) e.getSource();
            Dimension size = button.getSize();
            
            
            int lx = label.getX(); //x and y position of label, button, button index
            int ly = label.getY();
            int bx = button.getX();
            int by = button.getY();
            int bPosX = bx / size.width;
            int bPosY = by / size.height;
            int buttonIndex = structure[bPosY][bPosX];
            
            //When the image is pressed, the movement of the button f puzzle to the blank //
            if (lx == bx && (ly - by) == size.height ) {
    
                 int labelIndex = buttonIndex + 3;
    
                 pane.remove(buttonIndex);
                 pane.add(label, buttonIndex);
                 pane.add(button,labelIndex);
                 pane.validate();
            }
            else if (lx == bx && (ly - by) == -size.height ) 
            {
                 int labelIndex = buttonIndex - 3;
                 pane.remove(labelIndex);
                 pane.add(button,labelIndex);
                 pane.add(label, buttonIndex);
                 pane.validate();
            }
            else if (ly == by && (lx - bx) == size.width ) 
            {
    
                 int labelIndex = buttonIndex + 1;
    
                 pane.remove(buttonIndex);
                 pane.add(label, buttonIndex);
                 pane.add(button,labelIndex);
                 pane.validate();
            }
            else if (ly == by && (lx - bx) == -size.width ) 
            {
    
                 int labelIndex = buttonIndex - 1;
    
                 pane.remove(buttonIndex);
                 pane.add(label, labelIndex);
                 pane.add(button,labelIndex);
                 pane.validate();
            }
        }
        //When the image is pressed, the movement of the button f puzzle to the blank //
    }
}
