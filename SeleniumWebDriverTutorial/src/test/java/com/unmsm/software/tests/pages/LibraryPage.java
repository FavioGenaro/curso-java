package com.unmsm.software.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LibraryPage {
    private WebDriver driver;

    // Locators
    private By bookIdFieldLocator = By.id("bookId");
    private By userIdFieldLocator = By.id("userId");
    private By planIdFieldLocator = By.id("planId");
    private By passwordFieldLocator = By.id("password");
    private By loanTypeDropdownLocator = By.id("loanType");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");
    private By successMessageLocator = By.id("successMessageText");
    private By errorMessageLocator = By.id("errorText"); 

    public LibraryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setBookId(String bookId) {
        WebElement bookIdField = driver.findElement(bookIdFieldLocator);
        bookIdField.clear();
        bookIdField.sendKeys(bookId);
    }

    public void setUserId(String userId) {
        WebElement userIdField = driver.findElement(userIdFieldLocator);
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPlanId(String planId) {
        WebElement planIdField = driver.findElement(planIdFieldLocator);
        planIdField.clear();
        planIdField.sendKeys(planId);
    }

    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void selectLoanType(String loanType) {
        WebElement loanTypeDropdown = driver.findElement(loanTypeDropdownLocator);
        loanTypeDropdown.click();
        WebElement loanOption = driver.findElement(By.xpath("//option[text()='" + loanType + "']"));
        loanOption.click();
    }

    public void submit() {
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement successMessage = driver.findElement(successMessageLocator);
        return successMessage.isDisplayed();
    }
    
    public boolean isErrorMessageDisplayed() {
    	WebElement errorMessage = driver.findElement(errorMessageLocator);
        return errorMessage.isDisplayed();
    }
}
