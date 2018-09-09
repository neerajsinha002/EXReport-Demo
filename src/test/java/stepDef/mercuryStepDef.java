package stepDef;

import commons.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FlightFinderPage;
import pages.LoginPage;
import utility.ApplicationProperties;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class mercuryStepDef extends BasePage {

    private static String APPLICATION_USERID = ApplicationProperties.get("application.userid");
    private static String APPLICATION_PASSWORD = ApplicationProperties.get("application.password");
    private static LoginPage loginPage;
    private static FlightFinderPage flightFinderPage;

    public mercuryStepDef(){
        super();
    }
    @Before
    public void initializer(){
        driverInitialization();
        loginPage = new LoginPage();
    }

    @After
    public void closeSession() throws InterruptedException {
        //Reporter.getOutput(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        Thread.sleep(3000);
        driver.close();
    }

    @Given("User login to the application")
    public void user_login_to_the_application() {
        loginPage.loginApplication(APPLICATION_USERID, APPLICATION_PASSWORD);
    }

    @When("User selects the flight details")
    public void user_selects_the_flight_details(Map<String, String> flightDetails) {
        for (Map.Entry<String, String> keySet: flightDetails.entrySet()){
            System.out.println(keySet);
           if (keySet.getValue().contains(",")){
               List<String> items = Arrays.asList(keySet.getValue().split("\\s*,\\s*"));
               System.out.println(items);
           }
        }
    }

    @When("User selects the preferences")
    public void user_selects_the_preferences(Map<String, String> preferences) {

    }

    @Then("User clicks on continue button")
    public void user_clicks_in_continue_button() {

    }

    @Then("User selects the flight options")
    public void user_selects_the_flight_options() {

    }

    @Then("User enters the journey details")
    public void user_enters_the_journey_details() {

    }

}
