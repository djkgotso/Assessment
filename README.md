# Theoretical Exercise

1.	The difference between test case and a User story is User stories is that user story are short descriptions of functionality told from the user’s perspective. The focus is on why and how the user interacts with the software and test case is a set of conditions or variables under which a tester will determine whether a system under test satisfies requirements or works correctly. It Explains how to validate the execution of (non-)functional requirement. Contains more details.

2.	It should occur immediately when the new build is available.

3.	The type of Testing at an API Level is Integration Testing.

4.	Software Quality Engineer should be involved in the planning phases of the project and the advantage of involving QA early is:
      -	Testers will be more familiar with the software, as they are more involved with the evolution of the product in earlier phases.
      -	Test cases written during requirements and shared with the Dev team before the construction phase can help      developers to think outside the box and evaluate more chances of failure in their code.
      - The test environment can be prepared in advance, anticipating risks and preventing delays.
      - Involving quality assurance in all phases of the SDLC helps creating a ‘quality culture’ inside the organization.
5.	The ideal would be 80% of Automation and 30% for Manual. Example:
      -	Manual testing is not accurate at all times due to human error, hence it is less reliable.
      -	Automated testing is more reliable, as it is performed by tools and/or scripts.



# Test Cases

# TEST SCENARIOS

 - TC01_Validate the search by valid Movie Title
 - TC02_Validate the search by valid id
 - TC03_Verify the view/search movie using valid ID and valid apikey
 - TC04_Verify the view/search movie using invalid ID and valid apikey
 - TC05_Verify the view/search movie using valid ID and invalid apikey
 - TC06_Verify the view/search movie using invalid ID and invalid apikey
 
 
 <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="CRM Test Suite QA" >

<parameter name="run-id-param" value="162" />
<parameter name="save-screenshots" value="true" />
<parameter name="ExcelLocation" value="QA" />
<parameter name="databaseURL" value= "jdbc:mysql://10.0.0.80:3306/HelloFin"/>
<parameter name="user" value= "mark.r" /> 
<parameter name="password" value= "Dravenm1903!" /> 
<parameter name="posttotestRail" value= "No" /> 


<listeners>
    <listener class-name="Utility.ReportListener" />
</listeners>


<test name="Forgot Password">
    <classes>
      	<class name="CRM_Test_Cases.ForgotPassword"/>
    </classes>
</test> <!-- Test -->




