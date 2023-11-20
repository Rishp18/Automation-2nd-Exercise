package Excutetestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Testcases.RegisterUser;
import base.BaseClass;

public class Signup extends BaseClass {

	public Signup() {
		PageFactory.initElements(driver, this);
	}
	@Test
	public void TestRegisteruser() throws InterruptedException {
		RegisterUser rc=new RegisterUser();
		rc.AddNewUser();
	}
}
