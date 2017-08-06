package Actions;

import Pages.ITVSigninPage;

/**
 * Created by admin on 29/07/2017.
 */


public class SigninAction {

    public static void Login(String userName, String passWord) throws Exception {
        System.out.println("ITVSIGNIN_PAGE: Entering username(Email):" + userName);
        ITVSigninPage.email.sendKeys(userName);
        System.out.println("ITVSIGNIN_PAGE: Entering password(Password):" + passWord);
        ITVSigninPage.password.sendKeys(passWord);
    }

    public static void clickSigninbtn() throws Exception {
        System.out.println("ITVSIGNIN_PAGE: Clicking the [SIGN_IN] button. \n");
        ITVSigninPage.submit.click();
    }
}

