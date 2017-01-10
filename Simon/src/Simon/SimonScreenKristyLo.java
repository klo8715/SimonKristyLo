package Simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUI.ClickableScreen;
import GUI.Components.Action;
import GUI.Components.TextLabel;
import GUI.Components.Visible;

public class SimonScreenKristyLo extends ClickableScreen implements Runnable{

	private TextLabel label;
	private ButtonInterfaceKristyLo[] button;
	private ProgressInterfaceKristyLo progress;
	private ArrayList<MoveInterfaceKristyLo> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	public SimonScreenKristyLo(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run(){
	    label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber ++;
		sequence.add(randomMove());
		progress.setSequenceLength(sequence.size());
		progress.setRound(roundNumber);
		changeText(" ");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
		
	}

	private void changeText(String string) 
	{
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	private void playSequence()
	{
		ButtonInterfaceKristyLo b = null;
		for(MoveInterfaceKristyLo v: sequence){
			if(b!= null)b.dim();
			b = v.getAButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
			
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceKristyLo>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
		
	}

	private MoveInterfaceKristyLo randomMove() {
		ButtonInterfaceKristyLo b;
		int NewBut = (int) (Math.random()*button.length);
		return getMove[b];
	}

	private ProgressInterfaceKristyLo getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		Color[] color = {Color.blue, Color.red,Color.green,Color.yellow};
		int numberOfButtons = 4;
		button = new ButtonInterfaceKristyLo[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++ )
		{
			

				button.setColor(color[i]);
			    button.setX(160 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			    button.setY(200 - (int)(100*Math.sin(i*2*Math.PI/(numberOfButtons))));
			    final ButtonInterface b = buttons[i];
			    b.dim();
			    button[i].setAction(new Action(){

			    	public void act(){
			    		if(acceptingInput && button == sequence.get(sequenceIndex).getAButton())
			    		{
			    			sequenceIndex++;
			    		}
			    		else
			    		{
			    			gameOver();
			    			return;
			    		}
			    		if( sequenceIndex == sequence.size())
			    		{
			    			Thread nextRound = new Thread(SimonScreenKristyLo.this);
			    			nextRound.start(); 
			    		}
			    		Thread blink = new Thread(new Runnable(){

			    			public void run(){
			    				b.highlight();
			    				try {
			    					Thread.sleep(500);
			    				} catch (InterruptedException e) {
			    					e.printStackTrace();
			    				}
			    				b.dim();
			    			
			    			blink.start();
			    		}
			    });
			    viewObjects.add(button[i]);

			
		}
		public void gameOver() {
			progress.gameOver();
    	}


}
