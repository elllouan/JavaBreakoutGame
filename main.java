import javax.swing.JFrame;

class main 
{
	public static void testFrame()
	{
		WelcomePage welcomePage = new WelcomePage();
	}

	public static void main(String[] args) throws Exception
	{
		testFrame();
	}
	/*
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
	 */
}
