import javax.imageio.ImageIO;
import javax.swing.*; // JComponents
import javax.swing.border.Border;

import java.awt.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;

public class WelcomePage extends JFrame implements ActionListener, KeyListener
{
	private JMenuBar menuBar;
	private JLabel title, menu;
	private JLayeredPane layer;
	private JPanel westPanel, eastPanel, backPanel;
	private JButton[] buttons;
	private SettingsSection settings;
	private LevelWindow first;
	private Player player;
	/* --------------- CONSTRUCTOR SECTION ---------------- */
	public WelcomePage()
	{
		createButons();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Breakout Game !");
		this.setLayout(new BorderLayout());
		this.setSize(1200,800);
		this.setLocation(200,0);

		addPanels();
		addLabels();

		this.setVisible(true); // always at the end !!
	}

	public static void create(){
		WelcomePage welcomePage = new WelcomePage();
	}
	
	/* --------------- PRIVATE SECTION ---------------- */
	private void createButons() {
		JButton startButton = new JButton("START");
		JButton settingsButton = new JButton("SETTINGS");
		JButton rulesButton = new JButton("RULES");
		JButton plusButton = new JButton("+");

		buttons = new JButton[]{startButton,settingsButton,rulesButton,plusButton};
		for (JButton b : buttons) {
			b.setFont(new Font("Bold",Font.BOLD,20));
			b.setBackground(new Color(0xD0D0D0));
			b.addActionListener(this);
		}
	}

	private void addPanels() {
		backPanel = new JPanel();
		backPanel.setBackground(new Color(0x000099));
		backPanel.setOpaque(true);
		backPanel.setLayout(null);
		backPanel.setBounds(150,0,250,200);
		this.add(backPanel, BorderLayout.CENTER);
		
		westPanel = new JPanel();
		eastPanel = new JPanel();
		
		westPanel.setPreferredSize(new Dimension(100, 200));
		westPanel.setBackground(new Color(0xD0D0D0));

		eastPanel.setPreferredSize(new Dimension(100, 200));
		eastPanel.setBackground(new Color(0xD0D0D0));

		eastPanel.setOpaque(true);
		westPanel.setOpaque(true);

		this.add(eastPanel, BorderLayout.EAST);
		this.add(westPanel, BorderLayout.WEST);
	}

	private void addLabels() // Text, Image or both
	{
		title = new JLabel("Welcome to my NEW game !\n The BreakoutGame");
		title.setBounds(225,100,500,100);
		title.setFont(new Font("Brut",Font.ITALIC,22));
		title.setForeground(Color.WHITE); //
		title.setBackground(new Color(0x000099));
		title.setOpaque(true); // need to be set opaque for changing the bg and also to be seen
		// BorderFactory is a class which contains plenty of static methods intended to create different types of borders
		Border panelBorder = BorderFactory.createLineBorder(Color.WHITE,2); 
		title.setBorder(panelBorder); // disp the label's border

		backPanel.add(title);

		menu = new JLabel();
		menu.setLayout(new GridLayout(4,1,50,20));
		
		menu.setSize(250,200);
		double newX = (this.getSize().getWidth()-menu.getHeight())/2 - 150;
		double newY = (this.getSize().getHeight()-menu.getHeight())/2;
		menu.setLocation(new Point((int)newX,(int)newY));
		
		menu.setBackground(new Color(0x000099));
		menu.setOpaque(true);
		backPanel.add(menu);
		
		for (JButton b : buttons) {
			menu.add(b);
		}
	}
/*
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
*/
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for (JButton b : buttons) {
			if(e.getSource()==b && b.getText()=="START"){
			System.out.println("START THE GAME !");
			createFirstLevel();
			this.dispose();
			}
			if(e.getSource()==b && b.getText()=="SETTINGS"){
				System.out.println("SETTINGS !");
				this.dispose();
				createSettingsFrame();
			}
		}
	}

	private void createSettingsFrame() {
	}

	private void createFirstLevel() {
		// WelcomePage.dispose();
		String name =  JOptionPane.showInputDialog("Please type your pseudo in :");
		Player.create(name); 
		LevelWindow.createLevel1(name);
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
}
