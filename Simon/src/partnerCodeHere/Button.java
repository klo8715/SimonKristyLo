package partnerCodeHere;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import GUI.Components.Action;
import GUI.Components.Components;

public class Button extends Components implements SimonKristyLo.ButtonInterfaceKristyLo {

	private Action action;
	private Color c;
	private boolean highlight;
	private static int x;
	private static int y;
	
	
	public Button() {
		super(x+20, y+100, 100, 100);
		highlight = false;
	}

	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}

	public void act() {
		action.act();
	}
	
	public void setColor(Color color) {
		this.c = color;
		update();
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(highlight) {
			g.setColor(this.c);
			g.fillOval(0, 0, 65, 65);
			g.setColor(Color.black);
			g.drawOval(0, 0, 65, 65);
		}
		else {
			g.setColor(Color.gray);
			g.fillOval(0, 0, 65, 65);
			g.setColor(Color.black);
			g.drawOval(0, 0, 65, 65);
		}
	}

	
	private String name;
	public void setName(String s){
		this.name = s;
	}
	
	public String toString(){
		return name;
	}

	@Override
	public void highlight() {
		highlight = true;
		update();
	}

	@Override
	public void dim() {
		highlight = false;
		update();
	}

	@Override
	public void setX(int i) {
		this.x = i;
		update();

	}

	@Override
	public void setY(int i) {
		this.y = i;
		update();
	}
}
