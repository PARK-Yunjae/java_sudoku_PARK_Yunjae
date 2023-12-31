package Frame;

import javax.swing.JFrame;

import dao.FileDAO;
import panel.GamePanel;
import panel.JoinPanel;
import panel.LobbyPanel;
import panel.MainPanel;
import panel.RankPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MainFrame instance = new MainFrame();
	private String id;
	private String name;

	public static MainFrame getInstance() {
		return instance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MainFrame() {
		MainPanel mp = MainPanel.getInstance();
		JoinPanel jp = JoinPanel.getInstance();
		LobbyPanel lp = LobbyPanel.getInstance();
		RankPanel rp = RankPanel.getInstance();
		GamePanel gp = GamePanel.getInstance();

		setBounds(100, 100, 480, 640);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		add(mp);
		add(jp);
		add(lp);
		add(rp);
		add(gp);
		
		FileDAO.getInstance(); // 불러오면 생성자에서 init실행
	}

}
