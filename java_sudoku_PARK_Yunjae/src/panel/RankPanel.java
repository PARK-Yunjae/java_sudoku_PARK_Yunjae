package panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import dao.FileDAO;
import dao.RankDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankPanel extends JPanel {

	private static RankPanel instance = new RankPanel();
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String[] title = {"RANK", "NAME", "SCORE", "TIME"};
	private JTable easyTable;

	public RankPanel() {
		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);
		
		JLabel rankLabel = new JLabel("RANK");
		rankLabel.setFont(new Font("맑은 고딕", Font.BOLD, 72));
		rankLabel.setBounds(130, 20, 202, 67);
		add(rankLabel);
		
		JButton exitButton = new JButton("");
		// 종료 버튼 클릭시 
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDAO fDAO = FileDAO.getInstance();
				fDAO.AutoSave();
				System.exit(0);
			}
		});
		exitButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Green.jpg"));
		exitButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Blue.jpg"));
		exitButton.setIconTextGap(0);
		exitButton.setBounds(12, 541, 100, 50);
		add(exitButton);
		
		JButton lobbyButton = new JButton("");
		// 로비 버튼 클릭 시 
		lobbyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				LobbyPanel.getInstance().setVisible(true);
			}
		});
		lobbyButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Green_Rank.jpg"));
		lobbyButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Blue_Rank.jpg"));
		lobbyButton.setIconTextGap(0);
		lobbyButton.setBounds(352, 541, 100, 50);
		add(lobbyButton);
		// 쉬움 랭크 보기 클릭 시
		JRadioButton easyRankButton = new JRadioButton("");
		easyRankButton.setSelectedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Easy_Green_Rank.jpg"));
		easyRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		easyRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Easy_Blue_Rank.jpg"));
		easyRankButton.setIconTextGap(0);
		easyRankButton.setBounds(61, 480, 100, 50);
		buttonGroup.add(easyRankButton);
		add(easyRankButton);
		
		JRadioButton highRankButton = new JRadioButton("");
		highRankButton.setSelectedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Green_Rank.jpg"));
		highRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		highRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Blue_Rank.jpg"));
		highRankButton.setIconTextGap(0);
		highRankButton.setBounds(301, 480, 100, 50);
		buttonGroup.add(highRankButton);
		add(highRankButton);
		
		JRadioButton normalRankButton = new JRadioButton("");
		normalRankButton.setSelectedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Green_Rank.jpg"));
		normalRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		normalRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Blue_Rank.jpg"));
		normalRankButton.setIconTextGap(0);
		normalRankButton.setBounds(181, 480, 100, 50);
		buttonGroup.add(normalRankButton);
		add(normalRankButton);
		
		JPanel easyPanel = new JPanel();
		easyPanel.setBounds(61, 110, 340, 340);
		add(easyPanel);
		easyPanel.setLayout(null);
		
		easyTable = new JTable();
		easyTable.setBounds(0, 0, 340, 340);
		
		for(int i=0 ; i<RankDAO.getrList().size() ; i+=1) {
			if(RankDAO.getrList().get(i).getLevel() == 1) {
				Object easy = RankDAO.getrList().get(i);
				easyTable.add(easy);
			}
		}
		
		easyPanel.add(easyTable);
		
		setVisible(false);
	}

	public static RankPanel getInstance() {
		return instance;
	}
}
