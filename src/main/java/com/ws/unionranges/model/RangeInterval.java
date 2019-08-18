package com.ws.unionranges.model;

public class RangeInterval implements Comparable<RangeInterval>{

	
	//Added an assuption that the ranges are integers only. 

	public int lowerBound;
	public int upperBound;
	

	/*
	* This constructor is allowing the input variation to let inclue positive and negatives numbers as Range Intervals by using the Math library. 
	*/

	public RangeInterval(int firstNum, int secondNum){
		this.lowerBound = Math.min(firstNum, secondNum);
		this.upperBound = Math.max(firstNum, secondNum);
	}

	@Override
    public boolean equals(Object otherRangeInterval) {
        return otherRangeInterval instanceof RangeInterval
        && this.lowerBound == ((RangeInterval) otherRangeInterval).lowerBound 
        && this.upperBound == ((RangeInterval) otherRangeInterval).upperBound;
    }

    @Override
    public int compareTo(RangeInterval otherRangeInterval) {
         //check if the comparison object is null
    	java.util.Objects.requireNonNull(otherRangeInterval, "otherRangeInterval cannot be null for comparison");
        int outcome = Integer.compare(lowerBound, otherRangeInterval.lowerBound);
        return outcome == 0 ?
                Integer.compare(upperBound, otherRangeInterval.upperBound) : outcome;
    }

    @Override
    public String toString() {
        return "(" + lowerBound + "," + upperBound + ")";
    }

}