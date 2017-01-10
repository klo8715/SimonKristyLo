package Simon;

import java.awt.Color;

import GUI.Components.Action;
import GUI.Components.Clickable;

public interface ButtonInterfaceKristyLo extends Clickable{
	void setColor(Color color);

	/**
	 * changes button's displayed color to something brighter
	 */
	void highlight();

	/**
	 * changes button's displayed color to something dimmer
	 */
	void dim();

	void setAction(Action action);

	
	void setName(String name);



}
