package GUI.SimpleGames;

import GUI.GUIApplication;
import GUI.Screens.CoordinateScreen;

public class MouseFollower extends GUIApplication {

	//FIELDS
	public static MouseFollower game;//only ONE exists
	public static CoordinateScreen cs;
	public static MyScreen moveScreen;
	
	public MouseFollower(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		cs = new CoordinateScreen(getWidth(), getHeight());
		setScreen(cs);
		moveScreen = new MyScreen(getWidth(),getHeight());
	}

	public static void main(String[] args) {
		game = new MouseFollower(800,600);
		Thread app = new Thread(game);
		app.start();
	}

}
