package com.project_two_tests.steps;

import com.project_two_tests.pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsSteps {

    private WebDriver driver;
    private ProductsPage productsPage;

    private String createdTestProductCategoryName = "Stylish";

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        this.driver = new ChromeDriver();
        this.productsPage = new ProductsPage(driver);
    }

    @After
    public void after() {
        if(driver != null) {
            this.driver.quit();
        }
    }

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        this.productsPage.get();
    }

    @When("the data loads")
    public void theProductCategoryCardsLoaded() {
        this.productsPage.productCategoryCardsLoaded();
    }

    @Then("I should see product categories")
    public void iShouldSeeTheProductCategories() {
        assertTrue(this.productsPage.iShouldSeeTheProductCategories());
    }

    @And("I have opened the create form modal")
    public void iHaveOpenedTheCreateFormModal() {
        this.productsPage.clickOnCreateProductCategoryButton();
    }

    @When("I enter valid input")
    public void iEnterValidInput() {
        this.productsPage.enterInput(createdTestProductCategoryName);
    }

    @And("I press the submit button")
    public void iPressTheSubmitButton() {
        this.productsPage.clickOnModalSubmitButton();
    }

    @Then("the form submission should be successful")
    public void theFormSubmissionShouldBeSuccessful() {
        assertTrue(this.productsPage.containsProductCategoryWithName(createdTestProductCategoryName));
    }

    @And("the created product category should appear in the list of categories")
    public void theCreatedProductCategoryShouldAppearInTheListOfCategories() {
        assertTrue(this.productsPage.containsProductCategoryWithName(createdTestProductCategoryName));
    }
}
