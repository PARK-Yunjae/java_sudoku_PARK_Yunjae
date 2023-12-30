package panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import dao.MemberDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JoinPanel extends JPanel {

	private static JoinPanel instance = new JoinPanel();
	private static final long serialVersionUID = 1L;
	private JTextField idText;
	private JTextField pwText;
	private JTextField nameText;
	private String id = "ID 입력";
	private String pw = "PW 입력";
	private String name = "이름 입력";

	public JoinPanel() {
		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);

		JLabel textLabel = new JLabel("");
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textLabel.setForeground(new Color(255, 0, 0));
		textLabel.setBounds(71, 150, 320, 27);
		add(textLabel);

		JLabel lblJoin = new JLabel("JOIN");
		lblJoin.setBounds(141, 20, 173, 67);
		lblJoin.setFont(new Font("맑은 고딕", Font.BOLD, 72));
		add(lblJoin);

		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(72, 200, 57, 25);
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(idLabel);

		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(72, 240, 57, 25);
		pwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(pwLabel);

		JLabel nameLabel = new JLabel("NAME");
		nameLabel.setBounds(72, 280, 57, 25);
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(nameLabel);

		idText = new JTextField(id);
		idText.setBounds(141, 200, 173, 25);
		// 커서 있을때 없을때 이벤트
		idText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (idText.getText().equals(id)) {
					idText.setText("");
					idText.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idText.getText().isEmpty()) {
					idText.setForeground(Color.GRAY);
					idText.setText(id);
				}
			}
		});
		idText.setForeground(Color.GRAY);
		idText.setColumns(10);
		add(idText);

		pwText = new JTextField(pw);
		pwText.setBounds(141, 240, 173, 25);
		pwText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwText.getText().equals(pw)) {
					pwText.setText("");
					pwText.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwText.getText().isEmpty()) {
					pwText.setForeground(Color.GRAY);
					pwText.setText(pw);
				}
			}
		});
		pwText.setForeground(Color.GRAY);
		pwText.setColumns(10);
		add(pwText);

		nameText = new JTextField("이름 입력");
		nameText.setBounds(141, 280, 173, 25);
		nameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (nameText.getText().equals(name)) {
					nameText.setText("");
					nameText.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nameText.getText().isEmpty()) {
					nameText.setForeground(Color.GRAY);
					nameText.setText(name);
				}
			}
		});
		nameText.setForeground(Color.GRAY);
		nameText.setColumns(10);
		add(nameText);

		JButton joinButton = new JButton("");
		joinButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Join_Green.jpg"));
		joinButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Join_Blue.jpg"));
		joinButton.setIconTextGap(0);
		// 가입 버튼 클릭 시
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mDAO = MemberDAO.getInstance();
				int idIdx = mDAO.idValue(idText.getText());
				boolean pwPattern = mDAO.pwPattern(pwText.getText());
				
				if (idText.getText().equals(pwText.getText())) {
					textLabel.setText("ID와 비밀번호가 일치 합니다");
				} else if (idIdx != -1) {
					textLabel.setText("중복 ID 입니다");
				} else if (idIdx == -1 && pwPattern) {
					textLabel.setText("비밀번호는 4글자 이상, 숫자 영단어가 포함되어야 합니다");
				} else if (idIdx == -1 && !pwPattern) {
					mDAO.joinMember(idText.getText(), pwText.getText(), nameText.getText());
					idText.setText("");
					pwText.setText("");
					nameText.setText("");
					JOptionPane.showMessageDialog(null, "가입 완료", "회원가입", JOptionPane.PLAIN_MESSAGE);
					instance.setVisible(false);
					MainPanel.getInstance().setVisible(true);
				}
			}
		});
		joinButton.setBounds(141, 350, 173, 75);
		add(joinButton);

		JButton mainButton = new JButton("");
		mainButton.setIconTextGap(0);
		mainButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Main_Blue.jpg"));
		mainButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Main_Green.jpg"));
		// 메인 버튼 클릭 시
		mainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				MainPanel.getInstance().setVisible(true);
			}
		});

		mainButton.setBounds(352, 541, 100, 50);
		add(mainButton);

		// 종료 버튼
		JButton exitButton = new JButton("");
		exitButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Green.jpg"));
		exitButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Blue.jpg"));
		exitButton.setIconTextGap(0);
		// 종료 버튼 클릭 시
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(12, 541, 100, 50);
		add(exitButton);

		setVisible(false);
	}

	public static JoinPanel getInstance() {
		return instance;
	}

}
