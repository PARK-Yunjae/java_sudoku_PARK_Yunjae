package panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.FileDAO;
import dao.RankDAO;
import dto.Rank;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class RankPanel extends JPanel {

	private static RankPanel instance = new RankPanel();
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String[] title = {"RANK", "NAME", "TIME", "SCORE"};
	private JTable easyTable;
	private JTable normalTable;
	private JTable hardTable;
	private JPanel easyPanel;
	private JPanel normalPanel;
	private JPanel hardPanel;

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
		// 이지 버튼
		easyRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Rank> easyList = new ArrayList<Rank>();
				RankDAO rDAO = RankDAO.getInstance();
				easyList = rDAO.RankList(1);
				// 이게 있어야 클래스를 테이블에 넣을 수 있다
				DefaultTableModel easyDtm = new DefaultTableModel(title, 0);
				easyTable = new JTable(easyDtm);
				for(int i=0 ; i<easyList.size() ; i+=1) {
					Object[] o = new Object[5];
					o[0] = i+1;
					o[1] = easyList.get(i).getName();
					o[2] = easyList.get(i).getTime();
					o[3] = easyList.get(i).getScore();
					easyDtm.addRow(o);
				}
				easyTable.setBounds(0, 20, 320, 320);
				easyPanel.add(easyTable);
				easyPanel.setVisible(true);
				normalPanel.setVisible(false);
				hardPanel.setVisible(false);
			}
		});
		easyRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Easy_Blue_Rank.jpg"));
		easyRankButton.setIconTextGap(0);
		easyRankButton.setBounds(61, 480, 100, 50);
		buttonGroup.add(easyRankButton);
		add(easyRankButton);
		
		JRadioButton normalRankButton = new JRadioButton("");
		normalRankButton.setSelectedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Green_Rank.jpg"));
		// 노말 버튼
		normalRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Rank> normalList = new ArrayList<Rank>();
				RankDAO rDAO = RankDAO.getInstance();
				normalList = rDAO.RankList(2);
				// 이게 있어야 클래스를 테이블에 넣을 수 있다
				DefaultTableModel normalDtm = new DefaultTableModel(title, 0);
				for(int i=0 ; i<normalList.size() ; i+=1) {
					Object[] o = new Object[5];
					o[0] = i+1;
					o[1] = normalList.get(i).getName();
					o[2] = normalList.get(i).getTime();
					o[3] = normalList.get(i).getScore();
					normalDtm.addRow(o);
				}
				normalTable = new JTable(normalDtm);
				normalTable.setBounds(0, 0, 340, 340);
				normalPanel.add(normalTable);
				easyPanel.setVisible(false);
				normalPanel.setVisible(true);
				hardPanel.setVisible(false);
			}
		});
		normalRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Normal_Blue_Rank.jpg"));
		normalRankButton.setIconTextGap(0);
		normalRankButton.setBounds(181, 480, 100, 50);
		buttonGroup.add(normalRankButton);
		add(normalRankButton);
		
		JRadioButton highRankButton = new JRadioButton("");
		highRankButton.setSelectedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Green_Rank.jpg"));
		// 하드 버튼
		highRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Rank> hardList = new ArrayList<Rank>();
				RankDAO rDAO = RankDAO.getInstance();
				hardList = rDAO.RankList(3);
				// 이게 있어야 클래스를 테이블에 넣을 수 있다
				DefaultTableModel hardDtm = new DefaultTableModel(title, 0);
				for(int i=0 ; i<hardList.size() ; i+=1) {
					Object[] o = new Object[5];
					o[0] = i+1;
					o[1] = hardList.get(i).getName();
					o[2] = hardList.get(i).getTime();
					o[3] = hardList.get(i).getScore();
					hardDtm.addRow(o);
				}
				hardTable = new JTable(hardDtm);
				hardTable.setBounds(0, 0, 340, 340);
				hardPanel.add(hardTable);
				easyPanel.setVisible(false);
				normalPanel.setVisible(false);
				hardPanel.setVisible(true);
			}
		});
		highRankButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Hard_Blue_Rank.jpg"));
		highRankButton.setIconTextGap(0);
		highRankButton.setBounds(301, 480, 100, 50);
		buttonGroup.add(highRankButton);
		add(highRankButton);
		
		
		easyPanel = new JPanel();
		easyPanel.setBounds(61, 110, 340, 340);
		easyPanel.setLayout(null);
		easyPanel.setVisible(false);
		add(easyPanel);
		
		
		normalPanel = new JPanel();
		normalPanel.setBounds(61, 110, 340, 340);
		normalPanel.setLayout(null);
		
		normalPanel.setVisible(false);
		add(normalPanel);
		
		hardPanel = new JPanel();
		hardPanel.setBounds(61, 110, 340, 340);
		hardPanel.setLayout(null);
		
		hardPanel.setVisible(false);
		add(hardPanel);
		
		setVisible(false);
	}

	public static RankPanel getInstance() {
		return instance;
	}
}
