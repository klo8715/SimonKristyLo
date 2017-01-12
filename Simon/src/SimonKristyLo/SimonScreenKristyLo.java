package SimonKristyLo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUI.ClickableScreen;
import GUI.Components.Action;
import GUI.Components.TextLabel;
import GUI.Components.Visible;
import partnerCodeHere.Button;
import partnerCodeHere.Move;
import partnerCodeHere.Progress;


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
		addButtons(viewObjects);
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
		int random = (int) (Math.random() * button.length);
		if (random == lastSelectedButton) {
			random = (int) (Math.random() * button.length);
		}
		lastSelectedButton = random;
		return new Move(button[lastSelectedButton]);
	}

	private ProgressInterfaceKristyLo getProgress() {
		return new Progress(40,40,200,60);
	}

	public ButtonInterfaceKristyLo getAButton(){
		return new Button();
	}

	private void addButtons(List<Visible> viewObjects) {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		 */
		int numOfButtons = 4;
		Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
		button = new ButtonInterfaceKristyLo[numOfButtons];
		progress = getProgress();
		for (int i = 0; i < numOfButtons; i++) {
			button[i] = getAButton();
			button[i].setColor(colors[i]);
			final ButtonInterfaceKristyLo b = button[i];
			b.dim();
			button[i].setAction(new Action(){

				public void act(){
					if(acceptingInput && b == sequence.get(sequenceIndex).getAButton())
					{
						sequenceIndex++;
					}
					else
					{
						progress.gameOver();
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

						}
					});
					blink.start();
					viewObjects.add(b);


				}



			});
		}
	}
}
