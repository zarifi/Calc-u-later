import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class CalcControllerTest {
	
	CalcModel model = new CalcModel();
	CalcController controller = new CalcController(model);
	
	
	@Before
	public void setUp() throws Exception 
	{
		//Should probably set something up here...
	}
	
	@Test
	public void clearTest()
	{
		controller.clear();
		assertEquals(BigInteger.valueOf(0), model.getCalcValue());

	}
	
	@Test
	public void sumTest()
	{
		
		Stack<BigInteger> s = new Stack<BigInteger>();
		s.add(BigInteger.valueOf(1));
		s.add(BigInteger.valueOf(2));
		
		controller.sum(s);
		
		assertEquals(BigInteger.valueOf(3), model.getCalcValue());

	}
	
}
