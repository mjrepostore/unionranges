package com.ws.unionranges.model;

/** Model Java class representing a RangeInterval. 
 * @author Mahesh Jain
 * @version 1.0
 * @since 1.0
*/

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



    /** Compare the current object with other RangeInterval Object based on the content of the object.  
     * @param otherRangeInterval Other object to compare with. 
     * @return boolean value, returs true if contents match, else return false
     * 
    */

	@Override
    public boolean equals(Object otherRangeInterval) {
        return otherRangeInterval instanceof RangeInterval
        && this.lowerBound == ((RangeInterval) otherRangeInterval).lowerBound 
        && this.upperBound == ((RangeInterval) otherRangeInterval).upperBound;
    }

     /** Custome comparator object for RangeInterval Class.  
     * @param otherRangeInterval Other object to compare with. 
     * @return integer value based on the comparison logic. 
     * 
    */

    @Override
    public int compareTo(RangeInterval otherRangeInterval) {
         //check if the comparison object is null
    	java.util.Objects.requireNonNull(otherRangeInterval, "otherRangeInterval cannot be null for comparison");
        int outcome = Integer.compare(lowerBound, otherRangeInterval.lowerBound);
        return outcome == 0 ?
                Integer.compare(upperBound, otherRangeInterval.upperBound) : outcome;
    }

     // String representation of the RangeInterval Object
     
    @Override
    public String toString() {
        return "(" + lowerBound + "," + upperBound + ")";
    }

}