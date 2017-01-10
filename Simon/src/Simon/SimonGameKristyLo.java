package Simon;

import GUI.GUIApplication;

public class SimonGameKristyLo extends GUIApplication{

	public SimonGameKristyLo(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenKristyLo s = new SimonScreenKristyLo(getWidth(), getHeight());
		setScreen(s);
		
	}
	public static void main(String[] args)
	{
		SimonGameKristyLo game = new SimonGameKristyLo(800, 500);
		Thread app = new Thread(game);
		app.start();
	}

}
