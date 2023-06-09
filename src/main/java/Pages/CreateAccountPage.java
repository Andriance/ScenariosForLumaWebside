package Pages;

import SetUp.Interactions;
import com.github.javafaker.Faker;

public class CreateAccountPage extends Interactions {
    static Faker faker = new Faker();

    protected static String firstName = faker.name().firstName();
    protected static String lastName = faker.name().lastName();
    protected static String emailAddress = faker.internet().emailAddress();

    public static String registerAnAccount() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName );
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "1122AAbb");
        typeIn("//*[@id=\"password-confirmation\"]", "1122AAbb");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getText("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    }

    public static String emptyFirstNameField() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button");
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "AneChi2412");
        typeIn("//*[@id=\"password-confirmation\"]", "AneChi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        return getText("//*[@id=\"firstname-error\"]");
    }

    public static String emptyLastNameField() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "AneChi2412");
        typeIn("//*[@id=\"password-confirmation\"]", "AneChi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        return getText("//*[@id=\"lastname-error\"]");
    }

    public static String emptyEmailField() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"password\"]", "AneChi2412");
        typeIn("//*[@id=\"password-confirmation\"]", "AneChi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        return getText("//*[@id=\"email_address-error\"]");
    }

    public static String emptyPasswordField(boolean flag) {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password-confirmation\"]", "AneChi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        if(flag==true){
            return getText("//*[@id=\"password-error\"]");
        } else {
            return getText("//*[@id=\"password-confirmation-error\"]");
        }
    }

    public static String emptyConfirmPasswordField() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "AneChi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        return getText("//*[@id=\"password-confirmation-error\"]");
    }

    public static String differentPasswordInConfirmationPasswordField() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "AneChi2412");
        typeIn("//*[@id=\"password-confirmation\"]", "Anechi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        return getText("//*[@id=\"password-confirmation-error\"]");
    }

    public static boolean registerAnAccountThatAlreadyExists() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", "Andriana");
        typeIn("//*[@id=\"lastname\"]", "Chichonovska");
        typeIn("//*[@id=\"email_address\"]", "ane_t_2005@hotmail.com");
        typeIn("//*[@id=\"password\"]", "AneChi2412");
        typeIn("//*[@id=\"password-confirmation\"]", "AneChi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        return getText("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div", "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
    }

    public static String InvalidEmail() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", "ane_t_2005hotmail.com");
        typeIn("//*[@id=\"password\"]", "AneChi2412");
        typeIn("//*[@id=\"password-confirmation\"]", "AneChi2412");
        clickOn("//*[@id=\"form-validate\"]/div/div[1]/button");
        return getText("//*[@id=\"email_address-error\"]");
    }

    public static String writePasswordJustWithNumbers(boolean flag) {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "12345678");
        if(flag==true){
            return getText("//*[@id=\"password-error\"]");
        } else {
            return getText("//*[@id=\"password-strength-meter\"]");
        }
    }

    public static String writePasswordWithMediumStrength() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "A123bbbb");
        return getText("//*[@id=\"password-strength-meter\"]");
    }

    public static String writePasswordWithStrongStrength() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "AAA123qqq");
        return getText("//*[@id=\"password-strength-meter\"]");
    }

    public static String writePasswordWithFourLetters() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        typeIn("//*[@id=\"firstname\"]", firstName);
        typeIn("//*[@id=\"lastname\"]", lastName);
        typeIn("//*[@id=\"email_address\"]", emailAddress);
        typeIn("//*[@id=\"password\"]", "abcd");
        return getText("//*[@id=\"password-error\"]");
    }

    public static boolean presentsOfPageTitle() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        return getText("//*[@id=\"maincontent\"]/div[1]/h1/span", "Create New Customer Account");
    }

    public static boolean presentsOfSubtitlePersonalInformation() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        return getText("//*[@id=\"form-validate\"]/fieldset[1]/legend", "Personal Information");
    }

    public static boolean presentsOfSubtitleSignInInformation() {
        clickOn("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
        return getText("//*[@id=\"form-validate\"]/fieldset[2]/legend", "Sign-in Information");
    }
}
