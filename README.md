## Make Change Project

#### Description

- This program simulates a feature of a cash register that makes change.


#### Technologies Used
	- JAVA
	- Eclipse
	- Git/GitHub
	- Sublime Text Editor
	

#### Lessons Learned
    - Attention to detail, read and re-read requirements.
	- Commit often.
	- Testing the program ensuring the code runs as intended and catch some bugs early. 
	- Code a test to help streamline the deloping process.
	
#### Additional learning 

#### Important notes about all the code in this Repository 


#### How to run this program : This is a .java source code, command line project.  

You could open the project in an IDE and execute the main method using the IDE tools.

You can compile the project (.java) file on the command line, and then execute the compiled code (Ensure that the package is removed, 1st line in the source code, to ensure successful compiling).

The compilation and execution in the command line is subject to the proper working directory and installed JAVA Compiler and specific platform.

#### Compile the .java source file

javac MakeChange.java

#### Execute the compiled program.

java MakeChange



## Observation / Lesson Still To Learn


## Project requirements


### Make Change (Cash Register)

### Overview

In the cash register we will calculate the amount of change returned to a customer based on the purchase price and the amount tendered. We will also notify the attendant how many of each type of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer. 

Change will be provided using a combination of the largest bill and coin denominations as possible. 

Denominations that are not used will not be displayed.

*Hint: Mod operator*

#### User Story #1

The user is prompted asking for the price of the item.

#### User Story #2

The user is then prompted asking how much money was tendered by the customer.

#### User Story #3

Display an appropriate message if the customer provided too little money or the exact amount.

#### User Story #4

If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer. Denominations that are not used will not be displayed.

### Grading

This is a graded project. You are to have your project completed and pushed to Git by 0830 on Monday morning.  

If the code:
*  meets all stated requirements by the due date, you will receive 1 point.
*  meets most of the stated requirements by the due date, you may receive .5 point.
*  does not meet the stated requirements by the due date, you may receive 0 points.

Here are example test conditions:

* Amount: .67, Tendered: .50, Result: Error message
* Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
* Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
* Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
* Amount: any amount less than 20.00, Tendered: anything greater than amount: correct denominations for correct change.

If the project receives 0 points, resubmission for potential partial credit may, at the discretion of the instructor, be granted. Ignored assignments are given 0 points with no possibility for resubmission.

To turn in a project, you must push it to a GitHub repository named **MakeChangeProject**.  You must include a `README.md` describing how to run your program.

<hr>

## The following screenshots represent example executions of the program and the results.

![Example usage](01.png)
![Example usage](02.png)
![Example usage](03.png)


<hr>
