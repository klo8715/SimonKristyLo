package partnerCodeHere;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import GUI.Components.Action;
import GUI.Components.Components;
import Simon.ButtonInterfaceKristyLo;

public class Button extends Components implements SimonKristyLo.ButtonInterfaceKristyLo {

	private Action action;
	private Color c;
	private boolean highlight;
	
	public Button() {
		super(0,0,70,70);
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
		}
		else {
			g.setColor(Color.gray);
			g.fillOval(this.getX(), this.getY(), 65, 65);
			g.setColor(Color.black);
			g.drawOval(this.getX(), this.getY(), 65, 65);
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
}
