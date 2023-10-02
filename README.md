# peoplegrove

Tools and Technologies :

Java (Programming Language) Selenium (UI automation tool) TestNG (unit testing tool) Maven (Build tool) Page Factory (Design Pattern) Test automation framework is developed using the above tools and technologies TestNG with Page Facotry design pattern.

Steps to import the Project :

Pre-requisites : Java JDK1.8, Maven,TestNG & Eclipse IDE(Mars and above) should be already installed in the system.

Clone the project from github or or greenhouse url into local workspace

Open Eclipse, File -> import -> Maven -> Existing projects in to workspace -> select the project cloned

If you see any error after import, right click on the project ->Maven -> Update Project

Open file TestNG.xml file and right click -> run as -> TestNG test

Automated browser will open and testcases will be executed.

At the end of the execution, we can navigate to target folder-> Surefire reports in the project.

We can see index.html, it can be opened as right click on index.html -> open with -> web browser, where u can see the failed and passed test steps.

(Here I have used the testNG reports I havent configured external reporting tools like extent or allure reports).

The framework also takes screenshot incase of any failed testcases, named as embedded0,1,2 and so on.

Logs for the test will also be available in TestReport->Logs -> testlog.log
