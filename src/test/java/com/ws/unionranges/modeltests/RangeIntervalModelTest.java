
package com.ws.unionranges.modeltests;



import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import com.ws.unionranges.model.RangeInterval;
import java.util.Collections;
import java.util.ArrayList;


/** Junit Test class for the model class RangeInterval. 
 * @author Mahesh Jain
 * @version 1.0
 * @since 1.0
*/

public class RangeIntervalModelTest{


	//Tests the model with Negative numbers. 
	
	@Test
	public void testBoundsforNegativeNumber() {
		
			RangeInterval rangeInterval1 = new RangeInterval(-5, -10);
			Assert.assertEquals("(-10,-5)",rangeInterval1.toString());
			rangeInterval1 = null;
		
	}

	//Tests the model with switching bound in the pair. 

	@Test
	public void testBoundinPair() {
		
			RangeInterval rangeInterval1 = new RangeInterval(5, 10);
			Assert.assertEquals("(5,10)",rangeInterval1.toString());

			RangeInterval rangeInterval2 = new RangeInterval(10, 5);
			Assert.assertEquals("(5,10)",rangeInterval1.toString());
			
			rangeInterval1 = null;
			rangeInterval2 = null;
	}


	//Tests the Sorting logic based on the custom comparison logic implemented in the Model RangeInterval class

	@Test
	public void testSortRanges() {
		
			RangeInterval rangeInterval1 = new RangeInterval(5, 10);
			RangeInterval rangeInterval2 = new RangeInterval(2, 7);
			RangeInterval rangeInterval3 = new RangeInterval(6, 9);

			ArrayList<RangeInterval> ranges = new ArrayList<RangeInterval>();
			ranges.add(rangeInterval1);
			ranges.add(rangeInterval2);
			ranges.add(rangeInterval3);

			Collections.sort(ranges);

			Assert.assertEquals("(2,7)", ranges.get(0).toString());
			Assert.assertEquals("(5,10)", ranges.get(1).toString());
			Assert.assertEquals("(6,9)", ranges.get(2).toString());

			rangeInterval1 = null;
			rangeInterval2 = null;
			rangeInterval3 = null;

			ranges = null;		
	}

	//Tests the Sorting logic based on the custom comparison logic implemented in the Model RangeInterval class
	@Test
	public void testSortRanges2() {
		
			RangeInterval rangeInterval1 = new RangeInterval(5, 10);
			RangeInterval rangeInterval2 = new RangeInterval(6, 9);
			RangeInterval rangeInterval3 = new RangeInterval(4, 11);

			ArrayList<RangeInterval> ranges = new ArrayList<RangeInterval>();
			ranges.add(rangeInterval1);
			ranges.add(rangeInterval2);
			ranges.add(rangeInterval3);

			Collections.sort(ranges);

			Assert.assertEquals("(4,11)", ranges.get(0).toString());
			Assert.assertEquals("(5,10)", ranges.get(1).toString());
			Assert.assertEquals("(6,9)", ranges.get(2).toString());

			rangeInterval1 = null;
			rangeInterval2 = null;
			rangeInterval3 = null;

			ranges = null;		
	}

	
	//Tests the Sorting logic based on the custom comparison logic implemented in the Model RangeInterval class
	@Test
	public void testSortRanges3() {
		
			RangeInterval rangeInterval1 = new RangeInterval(1, 2);
			RangeInterval rangeInterval2 = new RangeInterval(2, 5);
			RangeInterval rangeInterval3 = new RangeInterval(4, 7);
			RangeInterval rangeInterval4 = new RangeInterval(3, 11);

			ArrayList<RangeInterval> ranges = new ArrayList<RangeInterval>();
			ranges.add(rangeInterval1);
			ranges.add(rangeInterval2);
			ranges.add(rangeInterval3);
			ranges.add(rangeInterval4);

			Collections.sort(ranges);

			System.out.println(ranges);

			Assert.assertEquals("[(1,2), (2,5), (3,11), (4,7)]", ranges.toString());

			rangeInterval1 = null;
			rangeInterval2 = null;
			rangeInterval3 = null;
			rangeInterval4 = null;

			ranges = null;		
	}
	
		
}	