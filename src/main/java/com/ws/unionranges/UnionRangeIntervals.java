package com.ws.unionranges;

import java.util.*;
import com.ws.unionranges.model.RangeInterval;

public class UnionRangeIntervals{
	
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