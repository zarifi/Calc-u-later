import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.math.BigInteger;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CalcView extends JFrame
{
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	private static final long serialVersionUID = -8730447125113729547L;
	
	private static JTextField userValueText;
	private static JTextField calcText;
	
	@SuppressWarnings("serial")
	public CalcView(final CalcController theController)
	{
		super("Simple Calculator");
		
		addComponentsToPane(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}

	public static void addComponentsToPane(Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
	//natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		calcText = new JTextField(20);
		calcText.setEditable(false);
		userValueText = new JTextField(5);
		
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		pane.add(calcText, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 2;
		pane.add(new JLabel("History"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		pane.add(userValueText, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 2;
		pane.add(new JLabel("Input"), c);
		
		int x = 0;
		int y = 2;

		for (int i=0; i < 10; i++) {
			JButton button1 = new JButton(""+i);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = x;
			c.gridwidth = 1;
			c.gridy = y;
			if (x == 4) {
				y += 1;
				x = 0;
			} else {
				x += 1;
			}
			pane.add(button1, c);
		}
		
		button = new JButton(".");
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = y+1;
		pane.add(button, c);
		
		button = new JButton("+");
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = y+1;
		pane.add(button, c);
		
		button = new JButton("-");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = y+1;
		pane.add(button, c);
		
		button = new JButton("*");
		c.gridx = 3;
		c.gridwidth = 1;
		c.gridy = y+1;
		pane.add(button, c);
		
		button = new JButton("/");
		c.gridx = 4;
		c.gridwidth = 1;
		c.gridy = y+1;
		pane.add(button, c);
		
		y += 1;


		button = new JButton("Submit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = y + 1;       //third row
		pane.add(button, c);
		
		button = new JButton("Clear");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 3;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = y + 1;       //third row
		pane.add(button, c);
}

	/**
	 * Get the string value of the user input text field.
	 * 
	 * @return The string in the user input text field.
	 */
	public BigInteger getUserValue()
	{
		return new BigInteger(userValueText.getText());
	}
	
	/**
	 * Set the string for the user input text field.
	 * 
	 * @param value The new value for the user input text field.
	 * @pre. value is not null
	 */
	public void setUserValue(String value)
	{
		userValueText.setText(value);
	}
	
	/**
	 * Set the string for the calculated value text field.
	 * 
	 * @param value The new value for the calculated value text field.
	 * @pre. value is not null
	 */
	public void setCalcValue(String value)
	{
		calcText.setText(value);
	}

}
