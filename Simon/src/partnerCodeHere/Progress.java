package partnerCodeHere;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import GUI.Components.Components;
import SimonKristyLo.ProgressInterfaceKristyLo;

public class Progress extends Components implements ProgressInterfaceKristyLo {
	private boolean gameOver;
	private int round;
	private int sequence;

	public Progress() {
		super(325, 150, 200, 100);
		gameOver = false;
	}


	@Override
	public void setSequenceLength(int size) {
		this.sequence = size;
		update();
	}

	@Override
	public void setRound(int x) {
		this.round = x;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameOver){
			g.setColor(Color.red);
			g.fillRoundRect(0, 0, 198, 98, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,198,98,20,20);	
			g.drawString("Yikes. Game over!",5,35);
			g.drawString("Round: "+round,5,55);
			g.drawString("Sequence Length: "+sequence,5,75);
		}
		else{
			g.setColor(Color.gray);
			g.fillRoundRect(0, 0, 198, 98, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,198,98,20,20);
			
			g.drawString("Round:"+round,5,35);
			g.drawString("Sequence Length:"+sequence,5,65);
		}
	}


	@Override
	public void gameOver() {
		gameOver = true;
	}

}
