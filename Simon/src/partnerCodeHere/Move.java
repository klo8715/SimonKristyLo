package partnerCodeHere;

import SimonKristyLo.ButtonInterfaceKristyLo;
import SimonKristyLo.MoveInterfaceKristyLo;
import SimonKristyLo.ButtonInterfaceKristyLo;

public class Move implements MoveInterfaceKristyLo {

private ButtonInterfaceKristyLo button; 
	
	public Move(ButtonInterfaceKristyLo b) {
		this.button = b;
	}

	public ButtonInterfaceKristyLo getButton() {
		return button;
	}

	@Override
	public ButtonInterfaceKristyLo getAButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// getAButton should not be in ButtonInterface

}
