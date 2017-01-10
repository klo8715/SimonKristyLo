package GUI.Screens;
import GUI.Components.Action;
import GUI.SimpleGames.MyScreen;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


import GUI.Screen;
import GUI.Components.Button;
import GUI.Components.Action;
import GUI.Components.TextLabel;
import GUI.Components.TextArea;
import GUI.Components.Visible;
import GUI.SimpleGames.MouseFollower;
import GUI.Components.Graphics;
public class CoordinateScreen extends Screen 
               implements MouseMotionListener,MouseListener{

	
	//FIELD
	private Button button;
	private TextLabel text;
	private TextArea area;
	private Graphics link;
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		button = new Button(20,100,80,40,
				"The Button",new Color(100,100,250),
				new Action() {
			
			public void act() {
				MouseFollower.game.
				setScreen(MouseFollower.moveScreen);
			}
		});
		viewObjects.add(button);
		text = 
				new TextLabel(20, 200, 500, 40, "Some text");
		
		viewObjects.add(text);
			area= new TextArea (20,200,500,40, "this is really long test. its prints over");
			viewObjects.add(area);
			
//			link = new Graphics(10,20, "resources/sampleImages/toon_link.jpg");
//			viewObjects.add(link);
			
	}

	
	@Override
	public MouseMotionListener getMouseMotionListener(){ 
		return this;
	}
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent m) {
		text.setText("Mouse at" + m.getX()+", "+m.getY());
	}
	
	public MouseListener getMouseListener(){
		return this;
}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(button.isHovered(e.getX(), e.getY()))
		{
			button.act();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
