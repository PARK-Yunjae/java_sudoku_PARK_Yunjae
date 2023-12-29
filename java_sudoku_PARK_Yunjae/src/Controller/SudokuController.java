package Controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import panel.*;

public class SudokuController {
	private static SudokuController instance = new SudokuController();
	private Map<String, JPanel> map;
	
	public void init() {
		map = new HashMap<String, JPanel>();
		map.put("MainPanel", new MainPanel());
		map.put("JoinPanel", new JoinPanel());
		map.put("GamePanel", new GamePanel());
		map.put("LobbyPanel", new LobbyPanel());
		map.put("RankPanel", new RankPanel());
	}
	
}
