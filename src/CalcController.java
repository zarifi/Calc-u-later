import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalcController
{
	/**
	 * String for sum command.
	 */
	public static final String SUM = "SUM";
	
	/**
	 * String for subtract command.
	 */
	public static final String SUBTRACT = "SUBTRACT";
	
	/**
	 * String for multiply command.
	 */
	public static final String MULTIPLY = "MULTIPLY";
	
	/**
	 * String for divide command.
	 */
	public static final String DIVIDE = "DIVIDE";
	
	/**
	 * String for clear command.
	 */
	public static final String CLEAR = "CLEAR";
	
	private CalcModel model;
	private CalcView view;

	/**
	 * Creates a controller for the given view and model.
	 * 
	 * @param view
	 *            The view.
	 * @pre. view != null
	 * @param theModel
	 *            The model the controller uses
	 * @pre. model != null
	 */
	public CalcController()
	{
		model = new CalcModel();
		view = new CalcView(this);
        view.setVisible(true);
		model.clear();
	}
	
	public CalcController(CalcModel modelIn){
		
		model = modelIn;
		view = new CalcView(this);
        view.setVisible(true);
		model.clear();
		
	}
//	  NTD: should be bigint array
public void sum(BigInteger number) {
	model.sum(number);
	showValue();
}
	  
public void subtract(BigInteger userValue) {
	model.subtract(userValue);
	showValue();
}

public void multiply(BigInteger userValue) {
	model.multiply(userValue);
	showValue();
}

public void divide(BigInteger userValue) {
	if(!userValue.equals(BigInteger.ZERO)) {
		model.divide(userValue);
	}
	showValue();
}

public void clear() {
	model.clear();
	showValue();
	view.setHistory("Start a new calculation");
	view.setButtonClicked();
}

public void setValue(int value) {
	
}

private void showValue() {
    BigInteger calcValue = model.getCalcValue();
    view.setCalcValue(calcValue.toString());
    
}



}
