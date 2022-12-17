import javax.imageio.ImageIO;
import javax.swing.*; // JComponents
import javax.swing.border.Border;

import java.awt.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener, KeyListener
{
	/* --------------- CONSTRUCTOR SECTION ---------------- */
	public MyFrame()
	{
		addMenu();
		addLabel();
		//this.pack(); // adapts automatically to Components (must be integrated beforehand !)
		/* Dimension, ImageIcon, Point, Border, JLabel, Font, Color  */
		
		addPanel();

		addButton();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Breakout Game !");
		this.setLayout(null);
		this.setSize(1200,800);
		this.setLocation(200,0);
		this.setVisible(true); // always at the end !!
	}
	
	/* --------------- PUBLIC SECTION ---------------- */
	public void addMenu()
	{
		// create new MenuBar
		menuBar = new JMenuBar();

		// create new Menu
		JMenu ShapesMenu = new JMenu("Display Shapes");
		MenuListener listener = new MenuListener() {
			@Override
			public void menuCanceled(MenuEvent e){}
			@Override
			public void menuDeselected(MenuEvent e){}
			@Override
			public void menuSelected(MenuEvent e){System.out.println("Menu selected : 'Display Shapes'");}

		};
		ShapesMenu.addMenuListener(listener);

		// create new MenuItem
		RectMenu = new JMenuItem("Print a Rectangle.");
		CirMenu = new JMenuItem("Print a Circle.");

		ShapesMenu.add(RectMenu);
		ShapesMenu.add(CirMenu);
		ShapesMenu.setMnemonic(KeyEvent.VK_A); // access via alt + a
		RectMenu.setMnemonic(KeyEvent.VK_Z); // access via alt + z
		RectMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				displayShape();
			}
		});

		menuBar.add(ShapesMenu);
		
		// add JMenuBar to the JFrame
		this.setJMenuBar(menuBar);
	}

	public void addLabel() // Text, Image or both
	{
		label = new JLabel("Welcome to my NEW game !");
		label.setVerticalTextPosition(JLabel.TOP);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setSize(100,100);
		label.setFont(new Font("Brut",Font.ITALIC,22));
		label.setForeground(Color.WHITE); //
		label.setBackground(new Color(0x553020));
		label.setOpaque(true); // need to be set opaque for changing the bg and also to be seen

		enib = new ImageIcon("Images/enib.png");
		label.setIcon(enib); // only png
		label.setIconTextGap(40);
		label.setVerticalAlignment(JLabel.CENTER); // of the whole label (images+text)
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(100,100,300,300); // set Size and Location of JLabel
		label.setSize(350,350);

		// BorderFactory is a class which contains plenty of static methods intended to create different types of borders
		Border panelBorder = BorderFactory.createLineBorder(Color.MAGENTA,2); 
		label.setBorder(panelBorder); // disp the label's border

		// this.add(label);
	}

	public void addPanel() // Container
	{
		panel1 = new JPanel();
		panel1.setBackground(Color.BLUE);
		panel1.setBounds(0,0,600,600);
		// panel1.setLayout(new BorderLayout()); allow us to move the JLabel inside as we want : default Layout is FlowLayout()
		panel1.setLayout(null); // necessary to set Label's bounds !

		panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		panel2.setBounds(600,0,300,300);
		panel2.setLayout(null); // necessary to set Label's bounds !

		panel3 = new JPanel();
		panel3.setBackground(Color.PINK);
		panel3.setBounds(350,600,400,100);
		panel3.setLayout(null); // necessary to set Label's bounds !

		panel1.add(label);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}

	public void addButton()
	{
		startButton = new JButton("BOOM");
		startButton.setBounds(150,150,75,75);
		// startButton.setBackground(Color.MAGENTA);
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		startButton.addKeyListener(this);

		// reshape the size of an Image with BufferedImage  /!\ does not work
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Images/boom.png"));
		} catch (Exception e) {
			e.getStackTrace();
		}
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		boom = new ImageIcon(img);
		startButton.setIcon(boom);

		panel2.add(startButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==startButton)
		{
		startButton.setEnabled(false);
		startButton.setLocation(100,50);
		System.out.println("BOOOOOM !");
		createGameFrame();
		}
	}

	private void createGameFrame() {
		JFrame newFrame = new JFrame();
		newFrame.setBounds(300,200,1000,500);
		newFrame.setLayout(new BorderLayout(10,10)); // fragment the frame into SOUTH, NORTH, EAST, WEST, CENTER(default)
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setVisible(true);

		JLabel boomText = new JLabel("BOOOOOM !");
		boomText.setFont(new Font("Georgia", Font.BOLD, 25));
		boomText.setLocation(400,250);

		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.red);
		panelWest.setPreferredSize(new Dimension(50,50));

		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.green);
		panelNorth.setPreferredSize(new Dimension(50,50));

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.blue);
		panelCenter.setPreferredSize(new Dimension(200,200));
		panelCenter.setLayout(new BorderLayout(10,10));

		newFrame.add(panelNorth,BorderLayout.NORTH);
		newFrame.add(panelWest,BorderLayout.WEST);
		newFrame.add(panelCenter,BorderLayout.CENTER);

		JPanel subNorthPanelCenter = new JPanel();
		subNorthPanelCenter.setBackground(Color.gray);
		subNorthPanelCenter.setPreferredSize(new Dimension(50,50));

		panelCenter.add(subNorthPanelCenter,BorderLayout.NORTH);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		// if(e.getKeyChar() == KeyEvent.VK_E) 
		System.out.println("EEE");		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* --------------- PRIVATE SECTION ---------------- */
	private void displayShape()
	{
		
	}
	
	private JMenuBar menuBar;
	private JLabel label;
	private JPanel panel1, panel2, panel3;
	private JMenuItem RectMenu, CirMenu;
	private JButton startButton;
	private ImageIcon enib, boom;
}
