import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*; // ActionListener

public class FirstLevelPage extends JFrame implements ActionListener{

    public FirstLevelPage()
    {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,0,800,600);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
