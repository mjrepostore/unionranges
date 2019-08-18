package com.ws.unionranges;

import java.util.*;
import com.ws.unionranges.model.RangeInterval;

/** Core Java class which contains the algorithm to reduce the list of representation through union or merge logic. 
 * @author Mahesh Jain
 * @version 1.0
 * @since 1.0
*/

public class UnionRangeIntervals{
	
/** Executes the merge algorithm 
 * @param rangeIntervalList Accpeting the ArrayList of all the Range Intervals. 
 * @return Returning the reduce or normalize ArrayList of all the Range Intervals.
*/
	public static ArrayList<RangeInterval> mergeRangeIntervals(ArrayList<RangeInterval> rangeIntervalList) {

		Collections.sort(rangeIntervalList);
		ArrayList<RangeInterval> unionList = new ArrayList<RangeInterval>();

		int lowerBound = Integer.MAX_VALUE;
		int upperBound = Integer.MIN_VALUE;

		for(RangeInterval rangeInterval: rangeIntervalList){
			int currentLowerBound = rangeInterval.lowerBound;
			int currentUpperBound = rangeInterval.upperBound;

			if (currentLowerBound <= upperBound && currentUpperBound >  upperBound){
				upperBound = currentUpperBound;
			}

			if (currentLowerBound < lowerBound && currentUpperBound >= upperBound){
				lowerBound = currentLowerBound;
				upperBound = currentUpperBound;
			}

			if (currentLowerBound > upperBound){
				unionList.add(new RangeInterval(lowerBound, upperBound));
				lowerBound = currentLowerBound;
				upperBound = currentUpperBound;
			}

		}

		unionList.add(new RangeInterval(lowerBound, upperBound));
		return unionList;

	}


}