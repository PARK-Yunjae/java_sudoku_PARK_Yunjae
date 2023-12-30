package panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;

public class GamePanel extends JPanel {

	private static GamePanel instance = new GamePanel();
	private static final long serialVersionUID = 1L;
	private JButton[][] map;

	public GamePanel() {
		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);
		
		JButton exitButton = new JButton("");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Green.jpg"));
		exitButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Blue.jpg"));
		exitButton.setIconTextGap(0);
		exitButton.setBounds(12, 541, 100, 50);
		add(exitButton);
		
		JButton lobbyButton = new JButton("");
		lobbyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				LobbyPanel.getInstance().setVisible(true);
			}
		});
		lobbyButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Blue_Rank.jpg"));
		lobbyButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Green_Rank.jpg"));
		lobbyButton.setIconTextGap(0);
		lobbyButton.setBounds(352, 541, 100, 50);
		add(lobbyButton);
		
		JLabel levelLabel = new JLabel("");
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setBounds(12, 10, 100, 30);
		add(levelLabel);
		
		JLabel missLabel = new JLabel("");
		missLabel.setHorizontalAlignment(SwingConstants.CENTER);
		missLabel.setBounds(124, 10, 100, 30);
		add(missLabel);
		
		JLabel scoreLabel = new JLabel("");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setBounds(238, 10, 100, 30);
		add(scoreLabel);
		
		JLabel timeLabel = new JLabel("");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(352, 10, 100, 30);
		add(timeLabel);
		
		JPanel mapPanel = new JPanel();
		mapPanel.setBackground(new Color(0, 0, 0));
		mapPanel.setBounds(31, 50, 400, 400);
		mapPanel.setLayout(null);
		
		map = new JButton[9][9];
		int size = 43;
		int gap = 0;
		for(int y=0 ; y<9 ; y+=1) {
			for(int x=0 ; x<9 ; x+=1) {
				if(y%3 == 0 || x%3 == 0) {
					gap = 3;
				}else {
					gap = 0;
				}
				map[y][x] = new JButton("");
				map[y][x].setBounds(gap+(size*y), gap+(size*x), size, size);
				mapPanel.add(map[y][x]);
			}
		}

		add(mapPanel);
		

		setVisible(false);
	}

	public static GamePanel getInstance() {
		return instance;
	}
	
	public JButton[][] getMap() {
		return map;
	}

}
