
package com.ws.unionranges;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import com.ws.unionranges.model.RangeInterval;
import java.util.Collections;
import java.util.ArrayList;
import com.ws.unionranges.UnionRangeIntervals;

/** Junit Test class for the testing the various union algorithm.  
 * @author Mahesh Jain
 * @version 1.0
 * @since 1.0
*/

public class RangeIntervalUnionTest{	


	//Test union with negative numbers 
	@Test
	public void testUnionRangeIntervalPositiveNegative() {
		
			RangeInterval rangeInterval1 = new RangeInterval(-5, 10);
			RangeInterval rangeInterval2 = new RangeInterval(-17, -19); //This allows the smaller number could be anythere in the pair. 
			RangeInterval rangeInterval3 = new RangeInterval(2, 5);
			RangeInterval rangeInterval4 = new RangeInterval(-3, 2);

			ArrayList<RangeInterval> ranges = new ArrayList<RangeInterval>();
			ranges.add(rangeInterval1);
			ranges.add(rangeInterval2);
			ranges.add(rangeInterval3);
			ranges.add(rangeInterval4);


			System.out.println("Ranges before merge: " + ranges);

			System.out.println("Ranges after merge:" + UnionRangeIntervals.mergeRangeIntervals(ranges));

			Assert.assertEquals("[(-19,-17), (-5,10)]", UnionRangeIntervals.mergeRangeIntervals(ranges).toString());

			rangeInterval1 = null;
			rangeInterval2 = null;
			rangeInterval3 = null;
			rangeInterval4 = null;

			ranges = null;		
	}

	//Test unions with inputs Range Intervals not overlapping with each other.
	@Test
	public void testUnionRangeInterval2() {
		
			RangeInterval rangeInterval1 = new RangeInterval(94133, 94133);
			RangeInterval rangeInterval2 = new RangeInterval(94200, 94299);
			RangeInterval rangeInterval3 = new RangeInterval(94600, 94699);

			ArrayList<RangeInterval> ranges = new ArrayList<RangeInterval>();
			ranges.add(rangeInterval1);
			ranges.add(rangeInterval2);
			ranges.add(rangeInterval3);
			
			System.out.println("Ranges before merge: " + ranges);

			System.out.println("Ranges after merge:" + UnionRangeIntervals.mergeRangeIntervals(ranges).toString());

			Assert.assertEquals("[(94133,94133), (94200,94299), (94600,94699)]", UnionRangeIntervals.mergeRangeIntervals(ranges).toString());
			
			rangeInterval1 = null;
			rangeInterval2 = null;
			rangeInterval3 = null;

			ranges = null;		
	}
	
	//Test unions with inputs Range Intervals actually overlapping each other causing algorithm to reduce the ranges

	@Test
	public void testUnionRangeInterval3() {
		
			RangeInterval rangeInterval1 = new RangeInterval(94133, 94133);
			RangeInterval rangeInterval2 = new RangeInterval(94200, 94299);
			RangeInterval rangeInterval3 = new RangeInterval(94226, 94399);

			ArrayList<RangeInterval> ranges = new ArrayList<RangeInterval>();
			ranges.add(rangeInterval1);
			ranges.add(rangeInterval2);
			ranges.add(rangeInterval3);
			
			System.out.println("Ranges before merge: " + ranges);

			System.out.println("Ranges after merge:" + UnionRangeIntervals.mergeRangeIntervals(ranges).toString());

			Assert.assertEquals("[(94133,94133), (94200,94399)]", UnionRangeIntervals.mergeRangeIntervals(ranges).toString());
			
			rangeInterval1 = null;
			rangeInterval2 = null;
			rangeInterval3 = null;

			ranges = null;		
	}
		
}