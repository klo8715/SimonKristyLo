package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import GUI.Components.Clickable;
import GUI.Components.Visible;

public abstract class ClickableScreen extends Screen implements MouseListener{
	private ArrayList<Clickable> clickable;
	
	public ClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	public abstract void initAllObjects(List<Visible> viewObjects);
	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		 initAllObjects(viewObjects);
		clickable = new ArrayList<Clickable>();
		for(Visible v:viewObjects)
		{
			if(v instanceof Clickable)
			{
				clickable.add((Clickable)v);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(Clickable c: clickable){
			if(c.isHovered(e.getX(), e.getY())){
				c.act();
				break;
			}
		}
		
	}
	public void addObject(Visible v){
		 super.addObject(v);
		 if(v instanceof Clickable){
		 clickable.add((Clickable) v);
		 }
		 }
		 

		 
		 public void remove(Visible v){
		 super.remove(v);
		 clickable.remove(v);
		 } 

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MouseListener getMouseListener()
	{
		return this;
	}

}
