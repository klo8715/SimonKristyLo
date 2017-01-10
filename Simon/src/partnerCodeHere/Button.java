package partnerCodeHere;

import java.awt.Color;
import java.awt.image.BufferedImage;

import GUI.Components.Action;
import SimonKristyLo.ButtonInterfaceKristyLo;

public class Button implements ButtonInterfaceKristyLo{
	
	private static int width = 100;
	private static int height = 100;
	private Action action;
	private Color color;
	private boolean highlight;

	public Button() {
		super();
	}
	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public BufferedImage getImage() {
		return null;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public boolean isAnimated() {
		return false;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}

	@Override
	public void highlight() {

	}

	@Override
	public void dim() {
		
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void setName(String name) {
		
	}

}
