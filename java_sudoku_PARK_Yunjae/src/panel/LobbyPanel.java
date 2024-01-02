package panel;

import java.awt.Color;

import javax.swing.JPanel;

import dao.FileDAO;
import dao.GameDAO;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import Frame.MainFrame;

public class LobbyPanel extends JPanel {

	private static LobbyPanel instance = new LobbyPanel();
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;

	public LobbyPanel() {
		setForeground(new Color(240, 240, 240));
		setBackground(new Color(240, 240, 240));
		setSize(464, 601);
		setLayout(null);
		
		nameLabel = new JLabel("");
		nameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		nameLabel.setOpaque(true);
		nameLabel.setForeground(new Color(0, 0, 0));
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nameLabel.setBounds(12, 10, 106, 31);
		add(nameLabel);
		
		JButton hardButton = new JButton("");
		// 어려움 난이도 버튼 클릭 시
		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameDAO gDAO = GameDAO.getInstance();
				GamePanel gp = GamePanel.getInstance();
				gDAO.AnswerMap();
				gDAO.LevelMap(3);
				gDAO.SelectMap(gp.getMap());
				gp.getLevelLabel().setText("HARD");
				gp.setMissNum(0);
				gp.getMissLabel().setText("0/5");
				gp.setScoreNum(0);
				gp.getScoreLabel().setText("0");
				instance.setVisible(false);
				GamePanel.getInstance().setVisible(true);
				GamePanel.getInstance().getT().start();
				GamePanel.getInstance().setTime(0);
				GamePanel.getInstance().getTimeLabel().setText("0초");
			}
		});
		hardButton.setIconTextGap(0);
		hardButton.setPressedIcon(new ImageIcon("img\\Hard_Green.jpg"));
		hardButton.setIcon(new ImageIcon("img\\Hard_Blue.jpg"));
		hardButton.setBounds(132, 100, 200, 80);
		add(hardButton);
		
		JButton normalButton = new JButton("");
		// 노말 난이도 버튼 클릭 시
		normalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameDAO gDAO = GameDAO.getInstance();
				GamePanel gp = GamePanel.getInstance();
				gDAO.AnswerMap();
				gDAO.LevelMap(2);
				gDAO.SelectMap(gp.getMap());
				gp.getLevelLabel().setText("NORMAL");
				gp.setMissNum(0);
				gp.getMissLabel().setText("0/5");
				gp.setScoreNum(0);
				gp.getScoreLabel().setText("0");
				instance.setVisible(false);
				GamePanel.getInstance().setVisible(true);
				GamePanel.getInstance().getT().start();
				GamePanel.getInstance().setTime(0);
				GamePanel.getInstance().getTimeLabel().setText("0초");
			}
		});
		normalButton.setIconTextGap(0);
		normalButton.setIcon(new ImageIcon("img\\Normal_Blue.jpg"));
		normalButton.setPressedIcon(new ImageIcon("img\\Normal_Green.jpg"));
		normalButton.setBounds(132, 200, 200, 80);
		add(normalButton);
		
		JButton easyButton = new JButton("");
		// 쉬움 난이도 버튼 클릭 시
		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameDAO gDAO = GameDAO.getInstance();
				GamePanel gp = GamePanel.getInstance();
				gDAO.AnswerMap();
				gDAO.LevelMap(1);
				gDAO.SelectMap(gp.getMap());
				gp.getLevelLabel().setText("EASY");
				gp.setMissNum(0);
				gp.getMissLabel().setText("0/5");
				gp.setScoreNum(0);
				gp.getScoreLabel().setText("0");
				instance.setVisible(false);
				GamePanel.getInstance().setVisible(true);
				GamePanel.getInstance().getT().start();
				GamePanel.getInstance().setTime(0);
				GamePanel.getInstance().getTimeLabel().setText("0초");
			}
		});
		easyButton.setIconTextGap(0);
		easyButton.setPressedIcon(new ImageIcon("img\\Easy_Green.jpg"));
		easyButton.setIcon(new ImageIcon("img\\Easy_Blue.jpg"));
		easyButton.setBounds(132, 300, 200, 80);
		add(easyButton);
		
		JButton exitButton = new JButton("");
		// 종료 버튼 클릭 시
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDAO fDAO = FileDAO.getInstance();
				fDAO.AutoSave();
				System.exit(0);
			}
		});
		exitButton.setIcon(new ImageIcon("img\\Exit_Blue.jpg"));
		exitButton.setIconTextGap(0);
		exitButton.setPressedIcon(new ImageIcon("img\\Exit_Green.jpg"));
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
		rankButton.setPressedIcon(new ImageIcon("img\\Rank_Green.jpg"));
		rankButton.setIcon(new ImageIcon("img\\Rank_Blue.jpg"));
		rankButton.setBounds(181, 541, 100, 50);
		add(rankButton);
		
		JButton logoutButton = new JButton("");
		// 로그아웃 버튼 클릭 시
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = MainFrame.getInstance();
				mf.setId("");
				mf.setName("");
				instance.setVisible(false);
				MainPanel.getInstance().setVisible(true);
			}
		});
		logoutButton.setIconTextGap(0);
		logoutButton.setIcon(new ImageIcon("img\\Logout_Blue.jpg"));
		logoutButton.setPressedIcon(new ImageIcon("img\\Logout_Green.jpg"));
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
