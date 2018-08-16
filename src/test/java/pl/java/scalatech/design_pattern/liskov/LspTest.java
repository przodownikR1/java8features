package pl.java.scalatech.design_pattern.liskov;

import org.junit.Test;

public class LspTest
{
	private static Rectangle getNewRectangle()
	{
		return new Square();
	}
   @Test
	public void test(){
	
		Rectangle r = LspTest.getNewRectangle();        
		r.setHeight(5);
		r.setWidth(10);


		System.out.println(r.getArea());

   }
}