# Selenium Automation Testing Project :computer:
### $${\color[RGB]{0, 150, 255} Project\space for\space the\space  course\space Methods\space and\space Techniques\space of\space Software\space Testing \space}$$ 


This project uses Page Object Models, implicit waits and Maven dependencies.

## Running the Tests

To successfully run the tests, you need to add the path of the installed drivers to the system variables for:
- Chrome driver ([chromedriver](https://chromedriver.chromium.org/downloads)) with the variable name *ChromeDriverTest*
- Firefox driver ([geckodriver](https://github.com/mozilla/geckodriver/releases)) with the variable name *FirefoxDriverTest*

Once the drivers are installed and the system variables are set up, you can run the tests using Maven in the command line.
```
mvn test (Ctrl + Enter)
```
This command will execute all the tests in the project.

## Browser Selection

To change the browser in which the tests will be executed, there is a *BrowserSelection* class with a static attribute named *selectedBrowser*. You can pass a value of *Chrome* or *Firefox* to this attribute.

