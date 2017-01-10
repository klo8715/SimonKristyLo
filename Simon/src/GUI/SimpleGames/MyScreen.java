package GUI.SimpleGames;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import GUI.Screen;
import GUI.Components.Action;
import GUI.Components.Button;
import GUI.Components.ClickableGraphics;
import GUI.Components.Graphics;
import GUI.Components.Visible;

public class MyScreen extends Screen implements MouseListener
{
	private Graphics link;
	private Button back;
	

	public MyScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		link = new ClickableGraphics(200,200,.25,"resources/sampleImages/toon_link.jpg");
		back = new Button(50,50,100,60,"Back", 
				Color.GRAY, new Action() {
			
			public void act() {
				MouseFollower.game.
				setScreen(MouseFollower.cs);
			}
		});
		viewObjects.add(link);
		viewObjects.add(back);
		
	}
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent arg0) {
		
	}

	public void mouseClicked(MouseEvent e) {
		if(back.isHovered(e.getX(), e.getY())){
			back.act();
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public MouseListener getMouseListener(){
		return this;
	}
}
