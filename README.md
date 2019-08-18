# TECH CHALLENGE - Union of series of Number ranges

## Use Case:
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

# SOLUTION

## Tech Stack

- Core Technology:                    Java 12
- Build and packgaging framework:     Maven 3.6.1
- Test Framework:                     Junit 4.12/Sun
- Source code Repository              Git 2.20.1
- OS                                  OS X 10.14.3

## Requirements and Assumptions

- Ensure that Git,Maven and Java are setup in PATH variable. 

## Design Considerations 

- Algorithm is generic design to consider input as integers and will work with all the possible values within java Integer range including the negative numbers.  Zip codes are just one of the business use case which can leverage this algorithm.

## Code structure: 

- src/main/java/com/ws/unionranges/model/RangeInterval.java is a model Java class to represent a Number Range. 
- src/main/java/com/ws/unionranges/UnionRangeIntervals.java  is a core Java class which contains the algorithm to reduce the list of representation through union or merge logic. 
- src/test/java/com/ws/unionranges/modeltests/RangeIntervalModelTest.java  is a Junit Test class for the model class. 
- src/test/java/com/ws/unionranges/RangeIntervalUnionTest.java  is a Junit Test class testing various scenarios of the algorithm. 

## Testing steps
    git clone https://github.com/mjrepostore/unionranges.git - This will create a folder unionranges containing the project code.
    
    cd unionranges - Enter the project directory
    
    source setenv.sh - This will set Maven(mvn command) in the path. This is optional step if you have Maven in the path already.
    
    mvn test - This will compile and executed all the tests scenarios and output the results.
    
## Test scenarios; 

Test results will output the Range Intervals before the merge and after the after merge to see how the algorithm executes

- Scenario 1: Test with Negative numbers. 

Output: 
Ranges before merge: [(-5,10), (-19,-17), (2,5), (-3,2)]
Ranges after merge:[(-19,-17), (-5,10)]

- Scenario 2: Test with inputs Range Intervals not overlapping with each other.  

Ranges before merge: [(94133,94133), (94200,94299), (94600,94699)]
Ranges after merge:[(94133,94133), (94200,94299), (94600,94699)]

- Scenario 3: Test with inputs Range Intervals actually overlapping  each other causing algorithm to reduce the ranges

Ranges before merge: [(94133,94133), (94200,94299), (94226,94399)]
Ranges after merge:[(94133,94133), (94200,94399)]


## Time Complexity of the Algorithm

- Algorithm uses Sorting of ranges first followed by a merge together with time complexity of O(n*log(n)). 


## Space Complexity of the Algorithm

- Algorithm uses ArrayList for storage of Range Intervals and Custom Object model representing NumberRange together with space complexity of O(n). 
