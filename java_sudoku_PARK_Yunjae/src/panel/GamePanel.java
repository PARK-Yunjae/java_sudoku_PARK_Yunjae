package panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Frame.MainFrame;
import dao.FileDAO;
import dao.GameDAO;
import dao.RankDAO;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class GamePanel extends JPanel implements Runnable {

	private static GamePanel instance = new GamePanel();
	private static final long serialVersionUID = 1L;
	private static JLabel[][] map;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb5;
	private JRadioButton rb6;
	private JRadioButton rb7;
	private JRadioButton rb8;
	private JRadioButton rb9;
	private JRadioButton rbErazer;
	private JLabel levelLabel;
	private JLabel missLabel;
	private JLabel scoreLabel;
	private JLabel timeLabel;
	private int missNum = 1;
	private int scoreNum = 50;
	private int time = 0;
	private Thread th = new Thread();
	private int num;

	public JLabel getLevelLabel() {
		return levelLabel;
	}

	public JLabel getMissLabel() {
		return missLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setMissNum(int missNum) {
		this.missNum = missNum;
	}

	public void setScoreNum(int scoreNum) {
		this.scoreNum = scoreNum;
	}

	public GamePanel() {
		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);

		JButton exitButton = new JButton("");
		// 종료 버튼 클릭 시
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDAO fDAO = FileDAO.getInstance();
				fDAO.AutoSave();
				System.exit(0);
			}
		});
		exitButton.setPressedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Green.jpg"));
		exitButton.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Blue.jpg"));
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
		lobbyButton.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Blue_Rank.jpg"));
		lobbyButton.setPressedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Lobby_Green_Rank.jpg"));
		lobbyButton.setIconTextGap(0);
		lobbyButton.setBounds(352, 541, 100, 50);
		add(lobbyButton);

		levelLabel = new JLabel("");
		levelLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setBounds(12, 10, 100, 30);
		add(levelLabel);

		missLabel = new JLabel(missNum + "/5");
		missLabel.setForeground(new Color(0, 0, 0));
		missLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		missLabel.setHorizontalAlignment(SwingConstants.CENTER);
		missLabel.setBounds(124, 10, 100, 30);
		add(missLabel);

		scoreLabel = new JLabel(scoreNum + "");
		scoreLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setBounds(238, 10, 100, 30);
		add(scoreLabel);

		timeLabel = new JLabel("");
		timeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(352, 10, 100, 30);
		add(timeLabel);

		JPanel mapPanel = new JPanel();
		mapPanel.setBackground(new Color(0, 0, 0));
		mapPanel.setBounds(34, 50, 396, 396);
		mapPanel.setLayout(null);

		add(mapPanel);

		map = new JLabel[9][9];
		// 버튼 사이 간격1 그룹 사이 간격 3
		int size = 42;
		int xgap = 0;
		int ygap = 0;
		int x = 0;
		int y = 0;

		for (int i = 0; i < 9; i += 1) {
			ygap += i % 3 == 0 ? 3 : 1;
			for (int j = 0; j < 9; j += 1) {
				if (j == 0) {
					xgap = 0;
				}
				xgap += j % 3 == 0 ? 3 : 1;
				x = xgap + (size * j);
				y = ygap + (size * i);
				map[i][j] = new JLabel("");
				map[i][j].setOpaque(true);
				map[i][j].setName("%d/%d".formatted(i, j));
				map[i][j].setBounds(x, y, size, size);
				map[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				map[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 20));
				mapPanel.add(map[i][j]);
			}
		}

		// 한나절 고생하고 긁어온 방법 - 마우스 액션을 설정하고
		MouseListener ml = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GameDAO gDAO = GameDAO.getInstance();

				JLabel jb = (JLabel) e.getComponent();
				num = -1;
				if (rb1.isSelected()) {
					num = 1;
				} else if (rb2.isSelected()) {
					num = 2;
				} else if (rb3.isSelected()) {
					num = 3;
				} else if (rb4.isSelected()) {
					num = 4;
				} else if (rb5.isSelected()) {
					num = 5;
				} else if (rb6.isSelected()) {
					num = 6;
				} else if (rb7.isSelected()) {
					num = 7;
				} else if (rb8.isSelected()) {
					num = 8;
				} else if (rb9.isSelected()) {
					num = 9;
				} else if (rbErazer.isSelected()) {
					num = 0;
				}

				if (gDAO.CannotChange(jb.getName())) {
					if (num > 0 && jb.getText().equals("")) {
						// 정답
						if (gDAO.answerNum(jb.getName(), num)) {
							jb.setForeground(Color.BLACK);
							scoreNum += 100;
							scoreLabel.setText(scoreNum + "");
						}
						// 오답
						else {
							jb.setForeground(Color.RED);
							missNum += 1;
							missLabel.setText(missNum + "/5");
						}
						jb.setText(num + "");
					}

					if (num == 0) {
						jb.setText("");
					}
				}
				// 승리
				if (gDAO.SudokuWin()) {
					// 여기서 랭킹 데이터 저장하고 로비로
					JOptionPane.showMessageDialog(null, "WINNER", "SUDOKU", JOptionPane.PLAIN_MESSAGE);
					RankDAO rDAO = RankDAO.getInstance();
					MainFrame mf = MainFrame.getInstance();
					rDAO.joinRank(mf.getName(), scoreNum, time, levelLabel.getText());
					instance.setVisible(false);
					LobbyPanel.getInstance().setVisible(true);
				}
				// 패배
				if (missNum == 5) {
					JOptionPane.showMessageDialog(null, "GAME OVER", "SUDOKU", JOptionPane.PLAIN_MESSAGE);
					instance.setVisible(false);
					LobbyPanel.getInstance().setVisible(true);
				}
			}
		};

		// 그걸 해당 패널에 추가해주고
		for (Component c : mapPanel.getComponents()) {
			c.addMouseListener(ml);
		}

		rb1 = new JRadioButton("");
		rb1.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\one_green.jpg"));
		rb1.setIconTextGap(0);
		rb1.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\one_blue.jpg"));
		rb1.setBounds(12, 452, 40, 40);
		buttonGroup.add(rb1);
		add(rb1);

		rb2 = new JRadioButton("");
		rb2.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\two_green.jpg"));
		rb2.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\two_blue.jpg"));
		rb2.setIconTextGap(0);
		buttonGroup.add(rb2);
		rb2.setBounds(56, 452, 40, 40);
		add(rb2);

		rb3 = new JRadioButton("");
		rb3.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\three_green.jpg"));
		rb3.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\three_blue.jpg"));
		rb3.setIconTextGap(0);
		rb3.setBounds(100, 452, 40, 40);
		buttonGroup.add(rb3);
		add(rb3);

		rb4 = new JRadioButton("");
		rb4.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\four_green.jpg"));
		rb4.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\four_blue.jpg"));
		rb4.setIconTextGap(0);
		rb4.setBounds(144, 452, 40, 40);
		buttonGroup.add(rb4);
		add(rb4);

		rb5 = new JRadioButton("");
		rb5.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\five_green.jpg"));
		rb5.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\five_blue.jpg"));
		rb5.setIconTextGap(0);
		rb5.setBounds(188, 452, 40, 40);
		buttonGroup.add(rb5);
		add(rb5);

		rb6 = new JRadioButton("");
		rb6.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\six_green.jpg"));
		rb6.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\six_blue.jpg"));
		rb6.setIconTextGap(0);
		rb6.setBounds(232, 452, 40, 40);
		buttonGroup.add(rb6);
		add(rb6);

		rb7 = new JRadioButton("");
		rb7.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\seven_green.jpg"));
		rb7.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\seven_blue.jpg"));
		rb7.setBounds(276, 452, 40, 40);
		buttonGroup.add(rb7);
		add(rb7);

		rb8 = new JRadioButton("");
		rb8.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\eight_green.jpg"));
		rb8.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\eight_blue.jpg"));
		rb8.setBounds(320, 452, 40, 40);
		buttonGroup.add(rb8);
		add(rb8);

		rb9 = new JRadioButton("");
		rb9.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\nine_green.jpg"));
		rb9.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\nine_blue.jpg"));
		rb9.setBounds(364, 452, 40, 40);
		buttonGroup.add(rb9);
		add(rb9);

		rbErazer = new JRadioButton("");
		rbErazer.setSelectedIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\eraizer_green.jpg"));
		rbErazer.setIcon(new ImageIcon(
				"C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\eraizer_blue.jpg"));
		rbErazer.setBounds(412, 452, 40, 40);
		buttonGroup.add(rbErazer);
		add(rbErazer);

		th.start();
		setVisible(false);
	}

	public static GamePanel getInstance() {
		return instance;
	}

	public JLabel[][] getMap() {
		return map;
	}

	@Override
	public void run() {
		while (true) {
			time += 1;
			timeLabel.setText(time+"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
