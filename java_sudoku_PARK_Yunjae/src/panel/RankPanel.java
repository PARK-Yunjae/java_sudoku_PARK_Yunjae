package panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankPanel extends JPanel {

	private static RankPanel instance = new RankPanel();
	private static final long serialVersionUID = 1L;
	private JTable rankTable;

	public RankPanel() {
		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);
		
		rankTable = new JTable();
		rankTable.setBounds(61, 130, 340, 340);
		add(rankTable);
		
		JLabel rankLabel = new JLabel("RANK");
		rankLabel.setFont(new Font("맑은 고딕", Font.BOLD, 72));
		rankLabel.setBounds(130, 20, 202, 67);
		add(rankLabel);
		
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
			}
		});
		lobbyButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Green_Rank.jpg"));
		lobbyButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Blue_Rank.jpg"));
		lobbyButton.setIconTextGap(0);
		lobbyButton.setBounds(352, 541, 100, 50);
		add(lobbyButton);
		
		JButton easyRankButton = new JButton("");
		easyRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		easyRankButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Easy_Green_Rank.jpg"));
		easyRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Easy_Blue_Rank.jpg"));
		easyRankButton.setIconTextGap(0);
		easyRankButton.setBounds(61, 480, 100, 50);
		add(easyRankButton);
		
		JButton highRankButton = new JButton("");
		highRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		highRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Blue_Rank.jpg"));
		highRankButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Green_Rank.jpg"));
		highRankButton.setIconTextGap(0);
		highRankButton.setBounds(301, 480, 100, 50);
		add(highRankButton);
		
		JButton normalRankButton = new JButton("");
		normalRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		normalRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Blue_Rank.jpg"));
		normalRankButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Green_Rank.jpg"));
		normalRankButton.setIconTextGap(0);
		normalRankButton.setBounds(181, 480, 100, 50);
		add(normalRankButton);
		
		setVisible(false);
	}

	public static RankPanel getInstance() {
		return instance;
	}
	
	
}
