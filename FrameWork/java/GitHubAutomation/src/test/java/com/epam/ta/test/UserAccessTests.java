package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.MainPage;
import com.epam.ta.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class UserAccessTests extends CommonConditions {
	@Test
	public void testLoginECatalog()
	{
		User testUser = UserCreator.withCredentialsFromProperty();
		String expectedLoginName = new MainPage(driver)
				.openPage()
				.clickEnterButton()
				.clickEnterWithEmailButton()
				.enterLoginDataAndClickEnterButton(testUser)
				.getLoginName();
		Assert.assertEquals(testUser.getUsername(), expectedLoginName);
	}

	@Test
	public void testNonCorrectLoginECatalog(){
		User testUser = UserCreator.withWrongUserData();
		String expectedLoginLabel = new MainPage(driver)
				.openPage()
				.clickEnterButton()
				.clickEnterWithEmailButton()
				.enterLoginDataAndClickEnterButton(testUser)
				.getExceptionLoginLabel();
		Assert.assertTrue(expectedLoginLabel.contains(testUser.getUsername()));
	}
}
