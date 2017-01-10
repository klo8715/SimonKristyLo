package GUI.Components;

import GUI.Components.Action;
import GUI.Components.Clickable;

public class ClickableGraphics extends Graphics implements Clickable {

	private Action action;
	
	public void setAction(Action a){
		this.action = a;
		update();
	}
	
	public ClickableGraphics(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
	}

	public ClickableGraphics(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
	}

	public ClickableGraphics(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
	}

	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

	public void act() {
		if(action != null)action.act();
	}

}


