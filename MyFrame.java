import GeometricShapes.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements KeyListener, ActionListener {

	public MyFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,700);
		this.setTitle("A brand new JFrame !");
		this.setLayout(null);
		this.setVisible(true);
		this.addKeyListener(this);

		// create new MenuBar
		menuBar = new JMenuBar();

		// create new Menu
		JMenu menu1 = new JMenu("Display Shapes");
		MenuListener listener = new MenuListener() {
			@Override
			public void menuCanceled(MenuEvent e){}
			@Override
			public void menuDeselected(MenuEvent e){}
			@Override
			public void menuSelected(MenuEvent e){System.out.println("Menu selected : 'Display Shapes'");}

		};
		menu1.addMenuListener(listener);

		// create new MenuItem
		JMenuItem RectMenu = new JMenuItem("Print a Rectangle.");
		JMenuItem CirMenu = new JMenuItem("Print a Circle.");

		menu1.add(RectMenu);
		menu1.add(CirMenu);
		menu1.setMnemonic(KeyEvent.VK_A); // access via alt + a
		RectMenu.setMnemonic(KeyEvent.VK_Z); // access via alt + z

		menuBar.add(menu1);
		
		// add JMenuBar to the JFrame
		this.setJMenuBar(menuBar);
	}

	@Override
	public void keyPressed(KeyEvent k){
		if(k.getKeyChar()==KeyEvent.VK_SPACE) {
		System.out.println(this.menuBar.getComponentCount()); 
		this.menuBar.getSelectionModel().setSelectedIndex(0);
		}
	}
	@Override
	public void keyReleased(KeyEvent k){}
	@Override
	public void keyTyped(KeyEvent k){}

	@Override
	public void actionPerformed(ActionEvent actionEvent){}
	
	private JMenuBar menuBar;
	private Rectangle rect;
	private Circle cir;
}
