package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GUI.Components.Visible;

public abstract class Screen {

	private BufferedImage image;
	private ArrayList<Visible> viewObjects;


	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width, height);
	}

	public abstract void 
	initObjects(ArrayList<Visible> viewObjects);

	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}

	public BufferedImage getImage(){
		return image;
	}

	public int getWidth(){
		return image.getWidth();
	}

	public int getHeight(){
		return image.getHeight();
	}
	public void addObject(Visible v){
		viewObjects.add(v);
	}

	public void update() {
		Graphics2D g = image.createGraphics();
		//smooth the graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
//		for(int i = 0; i < viewObjects.size(); i++){
//			
//		}
		for(Visible v: viewObjects){
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
	}

	
	//represents ABILITY to listen to mouse
	//but isn't actually doing something
	public MouseMotionListener getMouseMotionListener(){
		return null;
	}
	
	public MouseListener getMouseListener(){
		return null;
	}
	public void remove(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
		}
	}
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(v);
		}
	}
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(0, v);
		}
	}
	
	
}