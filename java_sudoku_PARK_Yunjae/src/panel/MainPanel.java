package panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import Frame.MainFrame;
import dao.FileDAO;
import dao.MemberDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {

	private static MainPanel instance = new MainPanel();
	private static final long serialVersionUID = 1L;
	private JTextField idText;
	private JPasswordField pwText;
	private String txtid = "ID 입력";

	public MainPanel() {

		setBackground(new Color(245, 245, 245));
		setSize(464, 601);
		setLayout(null);

		JLabel titleLavel = new JLabel("SUDOKU");
		titleLavel.setFont(new Font("맑은 고딕", Font.BOLD, 72));
		titleLavel.setBounds(80, 20, 304, 120);
		add(titleLavel);

		ImageIcon mainImage = new ImageIcon("img/sudoku_main.jpg");
		Image img1 = mainImage.getImage();
		Image img2 = img1.getScaledInstance(304, 304, Image.SCALE_DEFAULT);
		mainImage = new ImageIcon(img2);
		JLabel imageLavel = new JLabel("");
		imageLavel.setIcon(mainImage);

		imageLavel.setBounds(80, 145, 304, 304);
		add(imageLavel);

		idText = new JTextField(txtid);
		idText.setForeground(Color.gray);
		idText.setBounds(80, 460, 189, 25);
		// 커서 가 있을때 이벤트
		idText.addFocusListener(new FocusAdapter() {
			@Override // 없을 때
			public void focusLost(FocusEvent e) {
				if (idText.getText().isEmpty()) {
					idText.setForeground(Color.GRAY);
					idText.setText(txtid);
				}
			}

			@Override // 있을 때
			public void focusGained(FocusEvent e) {
				if (idText.getText().equals(txtid)) {
					idText.setText("");
					idText.setForeground(Color.BLACK);
				}
			}
		});
		add(idText);
		idText.setColumns(10);

		pwText = new JPasswordField(txtid);
		pwText.setForeground(Color.gray);
		pwText.setBounds(80, 484, 189, 25);
		// 커서거 있을때 없을때 이벤트
		pwText.addFocusListener(new FocusAdapter() {
			String pwstr = new String(pwText.getPassword());

			@Override // 없을 때
			public void focusLost(FocusEvent e) {
				if (pwstr.isEmpty()) {
					pwText.setForeground(Color.GRAY);
					pwText.setToolTipText(txtid);
				}
			}

			@Override // 있을 때
			public void focusGained(FocusEvent e) {
				if (pwstr.equals(txtid)) {
					pwText.setText("");
					pwText.setForeground(Color.BLACK);
				}
			}
		});

		add(pwText);
		
		JButton loginButton = new JButton("");
		loginButton.setIconTextGap(0);

		loginButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Login_Green.jpg"));
		loginButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Login_Blue.jpg"));
		loginButton.setBounds(281, 459, 100, 50);

		// 로그인 버튼 클릭 이벤트
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mDAO = MemberDAO.getInstance();
				int idIdx = mDAO.idValue(idText.getText());
				String pwTxt = new String(pwText.getPassword());
				int pwIdx = mDAO.pwValue(pwTxt);
				
				if(idIdx == -1) {
					JOptionPane.showMessageDialog(null, "ID가 존재하지 않습니다", "로그인", JOptionPane.PLAIN_MESSAGE);
				}else if(idIdx != -1 && idIdx != pwIdx) {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다", "로그인", JOptionPane.PLAIN_MESSAGE);
				}else {	
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.PLAIN_MESSAGE);
					MainFrame mf = MainFrame.getInstance();
					
					LobbyPanel lp = LobbyPanel.getInstance();
					lp.getNameLabel().setText(MemberDAO.getmList().get(idIdx).getName());
					mf.setId(MemberDAO.getmList().get(idIdx).getId());
					mf.setName(MemberDAO.getmList().get(idIdx).getName());
					
					idText.setText("");
					pwText.setText("");
					instance.setVisible(false);
					LobbyPanel.getInstance().setVisible(true);
				}
			}
		});

		add(loginButton);

		JButton joinButton = new JButton("");
		joinButton.setIconTextGap(0);
		joinButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Join_Blue_main.jpg"));
		joinButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Join_Green_main.jpg"));
		joinButton.setBounds(352, 541, 100, 50);
		// 회원 가입 버튼 클릭 시
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				JoinPanel.getInstance().setVisible(true);
			}
		});
		add(joinButton);

		// 종료 버튼
		JButton exitButton = new JButton("");
		exitButton.setIconTextGap(0);
		exitButton.setIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Blue.jpg"));
		exitButton.setPressedIcon(new ImageIcon("C:\\gitWorkspace\\.git\\java_sudoku_PARK_Yunjae\\java_sudoku_PARK_Yunjae\\img\\Exit_Green.jpg"));

		// 종료 버튼 클릭 시
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDAO fDAO = FileDAO.getInstance();
				fDAO.AutoSave();
				System.exit(0);
			}
		});
		exitButton.setBounds(12, 541, 100, 50);
		add(exitButton);

		setVisible(true); // 메인만 처음에 트루
	}

	public static MainPanel getInstance() {
		return instance;
	}

}
