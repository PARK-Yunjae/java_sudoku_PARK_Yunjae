package panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LobbyPanel extends JPanel {

	private static LobbyPanel instance = new LobbyPanel();
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;

	public LobbyPanel() {
		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);
		
		nameLabel = new JLabel("");
		nameLabel.setBounds(12, 10, 106, 31);
		add(nameLabel);
		
		JButton hardButton = new JButton("");
		// 어려움 난이도 버튼 클릭 시
		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				instance.setVisible(false);
				GamePanel.getInstance().setVisible(true);
			}
		});
		hardButton.setIconTextGap(0);
		hardButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Green.jpg"));
		hardButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Blue.jpg"));
		hardButton.setBounds(132, 100, 200, 80);
		add(hardButton);
		
		JButton normalButton = new JButton("");
		// 노말 난이도 버튼 클릭 시
		normalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				instance.setVisible(false);
				GamePanel.getInstance().setVisible(true);
			}
		});
		normalButton.setIconTextGap(0);
		normalButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Blue.jpg"));
		normalButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Green.jpg"));
		normalButton.setBounds(132, 200, 200, 80);
		add(normalButton);
		
		JButton easyButton = new JButton("");
		// 쉬움 난이도 버튼 클릭 시
		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				instance.setVisible(false);
				GamePanel.getInstance().setVisible(true);
			}
		});
		easyButton.setIconTextGap(0);
		easyButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Easy_Green.jpg"));
		easyButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Easy_Blue.jpg"));
		easyButton.setBounds(132, 300, 200, 80);
		add(easyButton);
		
		JButton exitButton = new JButton("");
		// 종료 버튼 클릭 시
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Blue.jpg"));
		exitButton.setIconTextGap(0);
		exitButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Green.jpg"));
		exitButton.setBounds(12, 541, 100, 50);
		add(exitButton);
		
		JButton rankButton = new JButton("");
		// 랭크 버튼 클릭 시
		rankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				RankPanel.getInstance().setVisible(true);
			}
		});
		rankButton.setIconTextGap(0);
		rankButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Rank_Green.jpg"));
		rankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Rank_Blue.jpg"));
		rankButton.setBounds(181, 541, 100, 50);
		add(rankButton);
		
		JButton logoutButton = new JButton("");
		// 로그아웃 버튼 클릭 시
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				instance.setVisible(false);
				MainPanel.getInstance().setVisible(true);
			}
		});
		logoutButton.setIconTextGap(0);
		logoutButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Logout_Blue.jpg"));
		logoutButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Logout_Green.jpg"));
		logoutButton.setBounds(352, 541, 100, 50);
		add(logoutButton);
		
		setVisible(false);
	}

	public static LobbyPanel getInstance() {
		return instance;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

}
