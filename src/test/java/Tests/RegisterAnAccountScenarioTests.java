package Tests;

import Pages.CreateAccountPage;
import SetUp.SetUp;
import SetUp.Interactions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RegisterAnAccountScenarioTests {
    @BeforeClass
    public void setUp(){
        SetUp.setup();
    }

    @Test(priority = 1)
    public void verifyMessageForSuccessfullyRegisteredAccount(){
        Assert.assertEquals(CreateAccountPage.registerAnAccount(), "Thank you for registering with Main Website Store.");
    }
    @Test(priority = 2)
    public void verifyMessageForEmptyFirstNameField(){
        Assert.assertEquals(CreateAccountPage.emptyFirstNameField(), "This is a required field.");
    }
    @Test(priority = 3)
    public void verifyMessageForEmptyLastNameField(){
        Assert.assertEquals(CreateAccountPage.emptyLastNameField(), "This is a required field.");
    }
    @Test(priority = 4)
    public void verifyMessageForEmptyEmailField(){
        Assert.assertEquals(CreateAccountPage.emptyEmailField(), "This is a required field.");
    }
    @Test(priority = 5)
    public void verifyMessageForEmptyPasswordField(){
        Assert.assertEquals(CreateAccountPage.emptyPasswordField(true), "This is a required field.");
    }
    @Test(priority = 6)
    public void verifyTheMessageUnderConfirmationPasswordFieldWhenPasswordFieldIsEmpty(){
        Assert.assertEquals(CreateAccountPage.emptyPasswordField(false), "Please enter the same value again.");
    }
    @Test(priority = 7)
    public void verifyMessageForEmptyConfirmationPasswordField() {
        Assert.assertEquals(CreateAccountPage.emptyConfirmPasswordField(), "This is a required field.");
    }
    @Test(priority = 8)
    public void verifyMessageForDifferentPasswordInConfirmationPasswordField(){
        Assert.assertEquals(CreateAccountPage.differentPasswordInConfirmationPasswordField(), "Please enter the same value again.");
    }
    @Test(priority = 9)
    public void verifyMessageForRegisteringAnAccountThatAlreadyExists(){
        Assert.assertTrue(CreateAccountPage.registerAnAccountThatAlreadyExists());
    }
    @Test(priority = 10)
    public void verifyMessageForRegisteringAnAccountWithInvalidEmail(){
        Assert.assertEquals(CreateAccountPage.InvalidEmail(), "Please enter a valid email address (Ex: johndoe@domain.com).");
    }
    @Test(priority = 11)
    public void verifyMessageForPasswordThatContainsJustNumbers(){
        Assert.assertEquals(CreateAccountPage.writePasswordJustWithNumbers(true), "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.");
    }
    @Test(priority = 12)
    public void verifyTheStrengthOfPasswordThatContainsEightNumbers(){
        Assert.assertEquals(CreateAccountPage.writePasswordJustWithNumbers(false),"Password Strength: Weak");
    }
    @Test(priority = 13)
    public void verifyIfTheStrengthOfPasswordIsMedium(){
        Assert.assertEquals(CreateAccountPage.writePasswordWithMediumStrength(), "Password Strength: Medium");
    }
    @Test(priority = 14)
    public void verifyIfTheStrengthOfPasswordIsStrong() {
        Assert.assertEquals(CreateAccountPage.writePasswordWithStrongStrength(), "Password Strength: Strong");
    }
    @Test(priority = 15)
    public void verifyMessageForPasswordThatContainsFourLetters(){
        Assert.assertEquals(CreateAccountPage.writePasswordWithFourLetters(), "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");
    }
    @Test(priority = 16)
    public void verifyIfThePageTitleIsSpelledCorrectly(){
        Assert.assertTrue(CreateAccountPage.presentsOfPageTitle());
    }
    @Test(priority = 17)
    public void verifyIfTheSubtitlePersonalInformationIsSpelledCorrectly(){
        Assert.assertTrue(CreateAccountPage.presentsOfSubtitlePersonalInformation());
    }
    @Test(priority = 18)
    public void verifyIfTheSubtitleSignInInformationIsSpelledCorrectly(){
        Assert.assertTrue(CreateAccountPage.presentsOfSubtitleSignInInformation());
    }
    @Test(priority = 19)
    public void verifyIfTheLogoIsDisplayed(){
        Assert.assertTrue(Interactions.isDisplayed("/html/body/div[1]/header/div[2]/a/img"));
    }

    @AfterClass
    public void end() {
        SetUp.end();
    }
}
