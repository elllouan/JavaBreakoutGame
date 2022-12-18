import Entities.*;

import java.awt.*;
import javax.swing.*;

public class LevelWindow extends JFrame{

    public LevelWindow(String playerName)
    {
		this.setTitle("Level 1 : " + playerName);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(0,0,1500,830);
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH); // set a full screen JFrame
        this.setLayout(null);
        this.setResizable(true);
    }

    public static int nbLevel = 3;
	private int id;
	private Brick[] bricks;
	private Board board;
	private Ball ball;
    private static GamePanel gamePanel;

	public int getId(){ return id; }

	public Dimension getBoardDimension(){ return board.getDimension(); }

    public static void createLevel1(String playerName) {
        LevelWindow level1 = new LevelWindow(playerName);
		level1.id = 1;
        gamePanel = GamePanel.setUp();
        level1.add(gamePanel);
        level1.setVisible(true);
    }

    public static void createLevel2() {
    }

    public static void createLevel3() {
    }

}
