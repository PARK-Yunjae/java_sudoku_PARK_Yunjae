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
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class RankPanel extends JPanel {

	private static RankPanel instance = new RankPanel();
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String[] title = { "RANK", "NAME", "TIME", "SCORE" };
	private JTable easyTable;
	private JTable normalTable;
	private JTable hardTable;
	private DefaultTableModel easyDtm;
	private DefaultTableModel normalDtm;
	private DefaultTableModel hardDtm;

	public RankPanel() {
		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);

		JLabel rankLabel = new JLabel("RANK");
		rankLabel.setFont(new Font("맑은 고딕", Font.BOLD, 72));
		rankLabel.setBounds(130, 20, 202, 67);
		add(rankLabel);

		easyDtm = new DefaultTableModel(title, 0);
		easyTable = new JTable(easyDtm);
		easyTable.setBounds(61, 110, 340, 340);
		normalDtm = new DefaultTableModel(title, 0);
		normalTable = new JTable(normalDtm);
		normalTable.setBounds(61, 110, 340, 340);
		
		hardDtm = new DefaultTableModel(title, 0);
		hardTable = new JTable(hardDtm);
		hardTable.setBounds(61, 110, 340, 340);
		
		JButton exitButton = new JButton("");
		// 종료 버튼 클릭시
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDAO fDAO = FileDAO.getInstance();
				fDAO.AutoSave();
				System.exit(0);
			}
		});
		
		
		exitButton.setPressedIcon(new ImageIcon(
				"img\\Exit_Green.jpg"));
		exitButton.setIcon(new ImageIcon(
				"img\\Exit_Blue.jpg"));
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
		lobbyButton.setPressedIcon(new ImageIcon(
				"img\\Lobby_Green_Rank.jpg"));
		lobbyButton.setIcon(new ImageIcon(
				"img\\Lobby_Blue_Rank.jpg"));
		lobbyButton.setIconTextGap(0);
		lobbyButton.setBounds(352, 541, 100, 50);
		add(lobbyButton);
		// 쉬움 랭크 보기 클릭 시
		JRadioButton easyRankButton = new JRadioButton("");
		easyRankButton.setSelectedIcon(new ImageIcon(
				"img\\Easy_Green_Rank.jpg"));
		// 이지 버튼
		easyRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankDAO rDAO = RankDAO.getInstance();
				List<Rank> easyList = new ArrayList<Rank>();
				easyList = rDAO.RankList(1);
				Collections.sort(easyList);
				easyDtm.setRowCount(0);
				// 이게 있어야 클래스를 테이블에 넣을 수 있다
				for (int i = 0; i < easyList.size(); i += 1) {
					Object[] o = new Object[4];
					o[0] = i + 1;
					o[1] = easyList.get(i).getName();
					o[2] = easyList.get(i).getTime();
					o[3] = easyList.get(i).getScore();
					easyDtm.addRow(o);
				}
				easyTable.setVisible(true);
				normalTable.setVisible(false);
				hardTable.setVisible(false);
			}
		});

		easyRankButton.setIcon(new ImageIcon(
				"img\\Easy_Blue_Rank.jpg"));
		easyRankButton.setIconTextGap(0);
		easyRankButton.setBounds(61, 480, 100, 50);
		buttonGroup.add(easyRankButton);
		add(easyRankButton);

		JRadioButton normalRankButton = new JRadioButton("");
		normalRankButton.setSelectedIcon(new ImageIcon(
				"img\\Normal_Green_Rank.jpg"));
		// 노말 버튼
		normalRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankDAO rDAO = RankDAO.getInstance();
				List<Rank> normalList = new ArrayList<Rank>();
				normalList = rDAO.RankList(2);
				Collections.sort(normalList);
				normalDtm.setRowCount(0);
				// 이게 있어야 클래스를 테이블에 넣을 수 있다
				for (int i = 0; i < normalList.size(); i += 1) {
					Object[] o = new Object[4];
					o[0] = i + 1;
					o[1] = normalList.get(i).getName();
					o[2] = normalList.get(i).getTime();
					o[3] = normalList.get(i).getScore();
					normalDtm.addRow(o);
				}
				easyTable.setVisible(false);
				normalTable.setVisible(true);
				hardTable.setVisible(false);
			}
		});
		normalRankButton.setIcon(new ImageIcon(
				"img\\Normal_Blue_Rank.jpg"));
		normalRankButton.setIconTextGap(0);
		normalRankButton.setBounds(181, 480, 100, 50);
		buttonGroup.add(normalRankButton);
		add(normalRankButton);

		JRadioButton highRankButton = new JRadioButton("");
		highRankButton.setSelectedIcon(new ImageIcon(
				"img\\Hard_Green_Rank.jpg"));
		// 하드 버튼
		highRankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankDAO rDAO = RankDAO.getInstance();
				List<Rank> hardList = new ArrayList<Rank>();
				hardList = rDAO.RankList(3);
				Collections.sort(hardList);
				hardDtm.setRowCount(0);
				// 이게 있어야 클래스를 테이블에 넣을 수 있다
				for (int i = 0; i < hardList.size(); i += 1) {
					Object[] o = new Object[4];
					o[0] = i + 1;
					o[1] = hardList.get(i).getName();
					o[2] = hardList.get(i).getTime();
					o[3] = hardList.get(i).getScore();
					hardDtm.addRow(o);
				}
				easyTable.setVisible(false);
				normalTable.setVisible(false);
				hardTable.setVisible(true);
			}
		});
		highRankButton.setIcon(new ImageIcon(
				"img\\Hard_Blue_Rank.jpg"));
		highRankButton.setIconTextGap(0);
		highRankButton.setBounds(301, 480, 100, 50);
		buttonGroup.add(highRankButton);
		add(highRankButton);

		add(easyTable);

		add(normalTable);

		add(hardTable);

		setVisible(false);
	}

	public static RankPanel getInstance() {
		return instance;
	}
}
