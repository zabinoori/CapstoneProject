package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilites.CommonUtility;
import tek.sdet.framework.utilites.DataGenerator;

public class RetailAccountSteps extends CommonUtility  {
	
	POMFactory factory = new POMFactory();


	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().account);
		logger.info("usesr cliked on account option");
		
	}
	@When("User update name {string} and phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String PhoneValue) {
		clearTextUsingSendKeys(factory.accountPage().nameField);
		sendText(factory.accountPage().nameField,nameValue);
		clearTextUsingSendKeys(factory.accountPage().phoneInputField);
		sendText(factory.accountPage().phoneInputField,PhoneValue);
		logger.info("user updated name and phone");
		
		
	}
	@When ("User click on update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().updateButton);
		logger.info("user clicked on Update button");
		
	}
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().perrsonalInformationUpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().perrsonalInformationUpdateMessage));
		logger.info("user profile information is updated");
		
	}
	
	@When ("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		
		List<Map<String, String>>passwordInformation = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordInput,passwordInformation.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordInput,passwordInformation.get(0).get("newPassword"));
		sendText(factory.accountPage().confrimPasswordInput,passwordInformation.get(0).get("confrimPassword"));
		logger.info("user entered password information");
	}
	@When("User click on change passowrd button")
	public void userClickOnChangePassowrdButton() {
		click(factory.accountPage().changePasswordButton);
		logger.info("User clicked on change Passwordbutton");
	
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expecedMessage) {
		if(expecedMessage.contains("Password")) {
		
		waitTillPresence(factory.accountPage().passwordUpdatedSuccessfullyMessage);
		Assert.assertEquals(expecedMessage, factory.accountPage().passwordUpdatedSuccessfullyMessage.getText());
		logger.info(expecedMessage + " is displayed");
	} else if (expecedMessage.contains("Payment Method added")) {
		
		waitTillPresence(factory.accountPage().paymentMethodAddedSucessfullyMessage);
		Assert.assertEquals(expecedMessage, factory.accountPage().paymentMethodAddedSucessfullyMessage.getText());
		logger.info(expecedMessage + "	is displayed");
		
		} else if (expecedMessage.contains("Payment Method updated")) {
			
			waitTillPresence(factory.accountPage().paymentMethodUpdatedSuccessfullyMessage);
			Assert.assertEquals(expecedMessage, factory.accountPage().paymentMethodUpdatedSuccessfullyMessage.getText());
			logger.info(expecedMessage + "	is displayed");
			
		} else if (expecedMessage.contains("Address Added Successfully")) {
			
			waitTillPresence(factory.accountPage().addAddressSuccessfullyMessage);
			Assert.assertEquals(expecedMessage,
					factory.accountPage().addAddressSuccessfullyMessage.getText());
			logger.info(expecedMessage + " is displayed");
		} else if(expecedMessage.contains("Address Updated Successfully")) {
			
			
			waitTillPresence(factory.accountPage().addressUpatedSuccessfullyMessage);
			Assert.assertEquals(expecedMessage,
					factory.accountPage().addressUpatedSuccessfullyMessage.getText());
			logger.info(expecedMessage + " is displayed");
		}
			
		}
	
	
	@When("User click on Add a payment method link")
	public void userClickOnAddPaymentMethodLink() {
		click (factory.accountPage().addPaymentMethodLink);
		logger.info("user clicked on add a payment method link");
	}
	
	@When("User fill Debit or Credit card information")
	public void userFillDebitorCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>>paymentInformation = dataTable.asMaps(String.class,String.class);
		sendText(factory.accountPage().cardNumberInput,paymentInformation.get(0).get("cardNameber"));
		sendText(factory.accountPage().nameOnCardInput, paymentInformation.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationonYearInput,paymentInformation.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationonMonthInput,paymentInformation.get(0).get("expirationMonth"));
		
		sendText(factory.accountPage().securityCodeInput,paymentInformation.get(0).get("securityCode"));
		logger.info("user entered required card information");
		
	}
	
	@When("User click on add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCardButton);
		logger.info("user clicked on Add your card button");
		
	}
	
	@When("User select card with ending {string}")
	public void userSelectCardWithEnding(String cardEndingNumber) {
		
		List<WebElement> cards = factory.accountPage().cardEndingNumber;
		for (WebElement card: cards) {
			if (card.getText().equals(cardEndingNumber))
				
				System.out.println(card.getText() + "=======================");
				click(card);
			logger.info(cardEndingNumber + " is selected");
			break;
		}
		
		
	}
	
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().CardEditButton);
		logger.info("user clikced on Edit option");
		
		
	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>>paymentInformation = dataTable.asMaps(String.class,String.class);
		clearTextUsingSendKeys(factory.accountPage().cardNumberInput);
		sendText(factory.accountPage().cardNumberInput,paymentInformation.get(0).get("cardNameber"));
		clearTextUsingSendKeys(factory.accountPage().nameOnCardInput);
		sendText(factory.accountPage().nameOnCardInput, paymentInformation.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationonYearInput,paymentInformation.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationonMonthInput,paymentInformation.get(0).get("expirationMonth"));
		
		clearTextUsingSendKeys(factory.accountPage().securityCodeInput);
		sendText(factory.accountPage().securityCodeInput,paymentInformation.get(0).get("securityCode"));
		logger.info("user entered required card information");
		
		
		
		
	}
	@When ("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		
		click(factory.accountPage().updateYourCardButton);
		logger.info("user clicked on Update your card button");
	
	
		}	
		
		@When("User click on remove option of card section")
		public void userClickOnRemoveOptionOfCardSection() {
			click(factory.accountPage().removeCardLink);
			logger.info("user clicked on remove option of card section");
		  
	}
		@Then("payment details should be removed")
		public void paymentDetailsShouldBeRemoved() {
			
			try {
			Assert.assertFalse(isElementDisplayed(factory.accountPage().cardPresent));
			logger.info("payment details removed from account");
			
		}catch(AssertionError e) {
			logger.info(e.getMessage());
			
		}
			
}

		@When("User click on Add address option")
		public void userClickOnAddAddressOption() {
			click (factory.accountPage().addAddressButton);
			logger.info("user clicked on Add Address option");		
		}
		
		@When("user fill new address form with below information")
		public void userFillNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> addressInformation = dataTable.asMaps(String.class,String.class);
		selectByVisibleText(factory.accountPage().countryDropDown, DataGenerator.addressGenerator(addressInformation.get(0).get("country")));
		clearTextUsingSendKeys(factory.accountPage().addressFullNameInput);
		selectByVisibleText(factory.accountPage().addressFullNameInput, DataGenerator.addressGenerator(addressInformation.get(0).get("fullName")));
		clearTextUsingSendKeys(factory.accountPage().adressPhoneNumberInput);
		selectByVisibleText(factory.accountPage().adressPhoneNumberInput, DataGenerator.addressGenerator(addressInformation.get(0).get("phoneNumber")));
		clearTextUsingSendKeys(factory.accountPage().adressInput);
		selectByVisibleText(factory.accountPage().adressInput, DataGenerator.addressGenerator(addressInformation.get(0).get("streetAddress")));
		clearTextUsingSendKeys(factory.accountPage().apartmentInput);
		selectByVisibleText(factory.accountPage().apartmentInput, DataGenerator.addressGenerator(addressInformation.get(0).get("apt")));
		clearTextUsingSendKeys(factory.accountPage().cityInput);
		selectByVisibleText(factory.accountPage().cityInput, DataGenerator.addressGenerator(addressInformation.get(0).get("city")));
		clearTextUsingSendKeys(factory.accountPage().stateInput);
		selectByVisibleText(factory.accountPage().stateInput, DataGenerator.addressGenerator(addressInformation.get(0).get("state")));
		clearTextUsingSendKeys(factory.accountPage().zipCodeInput);
		selectByVisibleText(factory.accountPage().zipCodeInput, DataGenerator.addressGenerator(addressInformation.get(0).get("zipcode")));
		
		logger.info("user filled the address form");
		
		}
		@When("user click add Your Address button")
		public void userClickAddYourAddressButton() {
			click(factory.accountPage().addYourAdress);
			logger.info("user clicked Add your Address button");
    
}
		@When("User click on edit address option")
		public void userClickOnEditAddressOption() {
			click(factory.accountPage().editAddressbutton);
			logger.info("user Clicked on edit address option");
			
		    
		}
		@When("User click update Your Address button")
		public void userClickUpdateYourAddressButton() {
		    click(factory.accountPage().updateAddressButton);
		    logger.info("user clicked on update your Address button");
		}
		
		@When("User click on remove option of Address section")
		public void userClickOnRemoveOptionOfAddressSection() {
			click(factory.accountPage().removeAddressOption);
			logger.info("user clicked on remove opton of address section");
		   
		}
		@Then("Address details should be removed")
		public void addressDetailsShouldBeRemoved() {

			try {
				Assert.assertFalse(isElementDisplayed(factory.accountPage().removeAddressOption));
				logger.info("Address details removed");
				
			}catch(AssertionError e) {
				logger.info(e.getMessage());
			
		   
		}}

}

