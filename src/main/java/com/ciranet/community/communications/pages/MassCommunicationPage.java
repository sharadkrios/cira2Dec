package com.ciranet.community.communications.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class MassCommunicationPage extends BasePage
{
	public MassCommunicationPage(WebDriver driver) 
	{
		super(driver);
	}

	Robot robot;

	@FindBy(xpath = "//dx-button[@title='Community Search']")
	public WebElement communityIcon;

	@FindBy(xpath = "//i[@class='dx-icon far fa-compass fa-2x']")
	WebElement navigationSearchIcon;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-menu']")
	WebElement toolbarMenu;

	@FindBy(xpath = "//div[@class='cc-community-search-component-container']//input")
	public WebElement communitysearchBox;

	@FindBy(xpath = "//div[@class='cc-community-search-component-container']//div[@class='dx-button-content']//i[@class='dx-icon fas fa-search']")
	public WebElement communitysearchButton;

	@FindBy(linkText = "Amberwood")
	public WebElement amberwoodLink;

	@FindBy(xpath = "//span[normalize-space()='Community']")
	WebElement communityMenu;

	@FindBy(xpath = "//span[normalize-space()='Communications']")
	WebElement communicationsMenu;

	@FindBy(xpath = "//span[normalize-space()='Mass Communications']")
	WebElement massCommunicationMenu;

	@FindBy(xpath="//h2[@class='page-header']")
	WebElement lblheader;

	@FindBy(xpath="//div[contains(@class, 'dx-loadindicator-icon')]")
	WebElement loaderIcon;

	@FindBy(xpath ="//i[@class='dx-icon fas fa-times']")
	WebElement communityAlertsClose;

	@FindBy(xpath = "(//div[contains(@class,'dx-dropdowneditor-icon')])[1]")
	WebElement fromDropdownClick;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content'][contains(.,'Scheduled Date')]")
	WebElement fromDropdownFirstValue;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content'][contains(.,'Processed Date')]")
	WebElement fromDropdownSecondValue;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[3]")
	WebElement fromDropdownDateSelection;

	@FindBy(xpath = "(//input[contains(@class,'dx-texteditor-input')])[4]")
	WebElement toDropdownDateSelection;

	@FindBy(xpath = "//span[@class='dx-button-text'][contains(.,'Search')]")
	WebElement searchButton;

	@FindBy(xpath = "//span[contains(.,'Schedule Communication')]")
	WebElement scheduleCommunicationButton;

	@FindBy(xpath = "//div[@class='dx-toolbar-items-container'][contains(.,'Schedule Communication')]")
	WebElement scheduleCommunicationpopup;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement scheduleCommunicationCloseButtton;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[4]")
	WebElement contactListClick;

	@FindBy(xpath = "//div[contains(text(),'All Contacts')]")
	WebElement contactListFirstValue;

	@FindBy(xpath = "//div[contains(text(),'Household Members')]")
	WebElement contactListSecondValue;

	@FindBy(xpath = "//div[@class='dx-texteditor-input-container dx-tag-container dx-native-click']")
	WebElement contactTypeClick;

	@FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[3]")
	WebElement contactTypeValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[6]")
	WebElement messageTypeClick;

	@FindBy(xpath = "//div[contains(text(),'Emergency Community Notification')]")
	WebElement messageTypeValue;

	@FindBy(xpath = "//span[normalize-space()='Refresh Recipients']")
	WebElement refreshRecipientsButton;

	@FindBy(xpath = "(//span[@class='dx-button-text'][normalize-space()='Reset'])[1]")
	WebElement resetButton;

	@FindBy(xpath = "(//input[@aria-label='Filter cell'])[3]")
	WebElement scheduledBysearchbox;

	@FindBy(xpath = "(//span[contains(.,'Steve Roebuck')])[1]")
	WebElement scheduledByHyperlink;

	@FindBy(xpath = "//span[normalize-space()='New Template']")
	WebElement newTemplateButton;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement newTemplateCloseButton;

	@FindBy(xpath = "(//input[@aria-label='Filter cell'])[4]")
	WebElement statuSsearchbox;

	@FindBy(xpath = "(//div[@class='dx-button-content'][contains(.,'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "(//span[normalize-space()='Re-Schedule']")
	WebElement reScheduleButton;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeButton;

	@FindBy(xpath = "//i[@class='dx-icon fas fa-chevron-right']")
	WebElement contentButton;
	
	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])[1]//td[4]")
	WebElement hyperlink;
	
	QuickSearch quickSearch = new QuickSearch(driver);
	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() 
	{
		try 
		{
			Robot robot = new Robot();

			// Press the Escape key
			robot.keyPress(KeyEvent.VK_ESCAPE);
			LoggerManager.info("Escape key pressed.");

			// Release the Escape key
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			LoggerManager.info("Escape key released.");
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Failed to press the Escape key: " + e.getMessage());
		}
	}

	public void selectStatusFilters() 
	{
		try 
		{
			// Wait for the status search box to be visible
			waitForElementToBeVisible(statuSsearchbox);
			LoggerManager.info("Status search box is visible.");

			// Click the search box
			clickElement(statuSsearchbox);
			LoggerManager.info("Clicked on the status search box.");

			// Clear any existing text in the search box
			statuSsearchbox.clear();
			LoggerManager.info("Cleared the status search box.");
		} 
		catch (Exception e) 
		{
			LoggerManager.error("An error occurred while selecting status filters: " + e.getMessage());
			throw e; // Optional: Re-throw the exception if needed for test reporting
		}
	}

	public void dropdownDateSelection() 
	{
		try 
		{
			// Wait for the "From" dropdown to be visible
			waitForElementToBeVisible(fromDropdownClick);
			LoggerManager.info("'From' dropdown is visible.");

			if (isElementDisplayed(fromDropdownClick)) 
			{
				// Select value in the "From" dropdown
				LoggerManager.info("Clicking 'From' dropdown.");
				clickElement(fromDropdownClick);
				clickElement(fromDropdownSecondValue);

				// Clear and input a date in the "From" date field
				LoggerManager.info("Selecting 'From' date.");
				fromDropdownDateSelection.clear();
				fromDropdownDateSelection.sendKeys("01/01/2020");

				// Clear and input today's date in the "To" date field
				LoggerManager.info("Selecting 'To' date.");
				clickElement(toDropdownDateSelection);
				toDropdownDateSelection.clear();

				// Get today's date in the required format
				LocalDate today = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String todayDate = today.format(formatter);

				// Input today's date in the "To" date field
				toDropdownDateSelection.sendKeys(todayDate);

				// Perform the search
				LoggerManager.info("Clicking search button.");
				clickElement(searchButton);

				// Wait for the loader icon to disappear
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Dropdown date selection and search completed successfully.");
			}
			else 
			{
				LoggerManager.warn("'From' dropdown is not displayed.");
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("An error occurred in dropdownDateSelection: " + e.getMessage());
			throw e; // Re-throw the exception if required for test reporting
		}
	}

	public void dropdownDateSelect() 
	{
		try 
		{
			// Wait for the "From" dropdown to be visible
			waitForElementToBeVisible(fromDropdownClick);
			LoggerManager.info("'From' dropdown is visible.");

			if (isElementDisplayed(fromDropdownClick)) 
			{
				// Click "From" dropdown and select the first value
				LoggerManager.info("Clicking 'From' dropdown and selecting the first value.");
				clickElement(fromDropdownClick);
				clickElement(fromDropdownFirstValue);

				// Clear and input a date in the "From" date field
				LoggerManager.info("Entering 'From' date: 01/01/2020.");
				fromDropdownDateSelection.clear();
				fromDropdownDateSelection.sendKeys("01/01/2020");

				// Clear and input today's date in the "To" date field
				LoggerManager.info("Entering today's date in 'To' field.");
				clickElement(toDropdownDateSelection);
				toDropdownDateSelection.clear();

				// Format today's date
				LocalDate today = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String todayDate = today.format(formatter);

				// Input today's date
				toDropdownDateSelection.sendKeys(todayDate);

				// Click the search button
				LoggerManager.info("Clicking the search button.");
				clickElement(searchButton);

				// Wait for the loader icon to disappear
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Dropdown date selection completed successfully.");
			}
			else 
			{
				LoggerManager.warn("'From' dropdown is not displayed or not interactable.");
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error occurred during dropdown date selection: " + e.getMessage());
			throw e; // Rethrow exception for further handling or test reporting
		}
	}


	public boolean verifySearchCommunity(String communitySearchKeyword) 
	{
		waitForInvisibility(loaderIcon);

		try 
		{
			waitForElementToBeVisible(communityIcon);

			// Perform community search
			quickSearch.searchCommunity(communitySearchKeyword);
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Community search completed for keyword: " + communitySearchKeyword);

			// Attempt to press Escape key to close any popups
			try 
			{
				LoggerManager.info("Attempting to press Escape key to close any popups.");
				pressEscapeKey(); // Assuming this method handles escape key events
			}
			catch (Exception e) 
			{
				LoggerManager.error("Error pressing the Escape key: " + e.getMessage() +e);
				throw new Exception("Failed to press Escape key", e); // Propagate the exception for better error handling
			}

			try 
			{
				waitForInvisibility(loaderIcon);
				waitForElementToBeVisible(communityAlertsClose);
				clickElement(communityAlertsClose);
				waitForInvisibility(loaderIcon);

				LoggerManager.info("Navigating to 'Mass Communication' through side navigation.");
				navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='Mass Communications']"), "Mass Communication");
				waitForInvisibility(loaderIcon);

				// Scroll and verify 'Mail Merge' menu visibility
				LoggerManager.info("Scrolling to locate 'Mass Communication' menu");
				waitForElementToBeVisible(massCommunicationMenu);
				waitForInvisibility(loaderIcon);

				LoggerManager.info("'Mass Communication' menu is visible; attempting to click.");
				clickElement(massCommunicationMenu);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully accessed 'Mass Communication' menu after community search.");
				
				boolean isHeaderCorrect= isElementDisplayed(lblheader);
				LoggerManager.info("Header text validation: " + (isHeaderCorrect ? "Passed" : "Failed"));

				return isHeaderCorrect;

			} 
			catch (Exception e) 
			{
				LoggerManager.error("An error occurred during navigation or menu access: " + e.getMessage());
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("An unexpected error occurred while verifying community search: " + e.getMessage() +e);
			return false;
		}
	}

	public boolean verifyFromScheduledDateDropdown() 
	{
		try 
		{
			// Wait for the "From" dropdown to be visible
			waitForElementToBeVisible(fromDropdownClick);
			LoggerManager.info("'From' dropdown is visible.");

			if (isElementDisplayed(fromDropdownClick)) 
			{
				// Click "From" dropdown and select the first value
				LoggerManager.info("Clicking 'From' dropdown and selecting the first value.");
				clickElement(fromDropdownClick);
				clickElement(fromDropdownFirstValue);

				// Clear and input a date in the "From" date field
				LoggerManager.info("Entering 'From' date: 01/01/2020.");
				fromDropdownDateSelection.clear();
				fromDropdownDateSelection.sendKeys("01/01/2020");

				// Clear and input today's date in the "To" date field
				LoggerManager.info("Entering today's date in 'To' field.");
				clickElement(toDropdownDateSelection);
				toDropdownDateSelection.clear();

				// Get today's date and format it
				LocalDate today = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String todayDate = today.format(formatter);

				// Input today's date
				LoggerManager.info("Setting 'To' date as: " + todayDate);
				toDropdownDateSelection.sendKeys(todayDate);

				// Click the search button
				LoggerManager.info("Clicking the search button.");
				clickElement(searchButton);

				// Wait for the loader icon to disappear
				waitForInvisibility(loaderIcon);

				LoggerManager.info("Date selection verified successfully.");
				return true;
			}
			else 
			{
				LoggerManager.warn("'From' dropdown is not displayed or interactable.");
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error during date dropdown verification: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyFromProcessedDateDropdown() 
	{
		try 
		{
			// Wait for the "From" dropdown to be visible
			waitForElementToBeVisible(fromDropdownClick);
			LoggerManager.info("'From' dropdown is visible.");

			if (isElementDisplayed(fromDropdownClick)) 
			{
				// Click "From" dropdown and select the second value
				LoggerManager.info("Clicking 'From' dropdown and selecting the second value.");
				clickElement(fromDropdownClick);
				clickElement(fromDropdownSecondValue);

				// Clear and input a date in the "From" date field
				LoggerManager.info("Entering 'From' date: 01/01/2020.");
				fromDropdownDateSelection.clear();
				fromDropdownDateSelection.sendKeys("01/01/2020");

				// Clear and input today's date in the "To" date field
				LoggerManager.info("Entering today's date in 'To' field.");
				clickElement(toDropdownDateSelection);
				toDropdownDateSelection.clear();

				// Get today's date and format it
				LocalDate today = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String todayDate = today.format(formatter);

				// Input today's date
				LoggerManager.info("Setting 'To' date as: " + todayDate);
				toDropdownDateSelection.sendKeys(todayDate);

				// Click the search button
				LoggerManager.info("Clicking the search button.");
				clickElement(searchButton);

				// Wait for the loader icon to disappear
				waitForInvisibility(loaderIcon);

				LoggerManager.info("Processed date dropdown verified successfully.");
				return true;
			}
			else 
			{
				LoggerManager.warn("'From' dropdown is not displayed or interactable.");
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error during processed date dropdown verification: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyScheduleCommunicationRefreshButton() 
	{
		try 
		{
			// Perform date selection before proceeding
			LoggerManager.info("Initiating date selection for scheduled communication.");
			dropdownDateSelection();

			// Wait for the Schedule Communication button to be visible and click it
			LoggerManager.info("Waiting for the 'Schedule Communication' button to be visible.");
			waitForElementToBeVisible(scheduleCommunicationButton);
			LoggerManager.info("Clicking the 'Schedule Communication' button.");
			clickElement(scheduleCommunicationButton);

			// Wait for the loader icon to disappear
			LoggerManager.info("Waiting for the loader to disappear.");
			waitForInvisibility(loaderIcon);
			waitForInvisibility(loaderIcon);

			// Verify if the Reset button is displayed
			LoggerManager.info("Checking if the 'Reset' button is displayed.");
			waitForElementToBeVisible(resetButton);

			if (isElementDisplayed(resetButton)) 
			{
				LoggerManager.info("Reset button is displayed. Clicking the button.");
				clickElement(resetButton);
				waitForInvisibility(loaderIcon);

				// Close the Schedule Communication dialog
				LoggerManager.info("Clicking the 'Close' button on the Schedule Communication dialog.");
				clickElement(scheduleCommunicationCloseButtton);

				LoggerManager.info("Schedule Communication refresh button verification completed successfully.");
				return true;
			}
			else 
			{
				LoggerManager.warn("Reset button is not displayed. Verification failed.");
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error occurred during date selection: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyScheduleCommunicationRefreshRecipientsButton() 
	{
		try 
		{
			// Perform date selection before proceeding
			LoggerManager.info("Initiating date selection for scheduled communication.");
			dropdownDateSelection();

			// Wait for the Schedule Communication button to be visible and click it
			LoggerManager.info("Waiting for the 'Schedule Communication' button to be visible.");
			waitForElementToBeVisible(scheduleCommunicationButton);
			LoggerManager.info("Clicking the 'Schedule Communication' button.");
			clickElement(scheduleCommunicationButton);

			// Wait for the loader icon to disappear
			LoggerManager.info("Waiting for the loader to disappear.");
			waitForInvisibility(loaderIcon);
			waitForInvisibility(loaderIcon);

			// Verify if the Refresh Recipients button is displayed
			LoggerManager.info("Checking if the 'Refresh Recipients' button is displayed.");
			waitForElementToBeVisible(refreshRecipientsButton);

			if (isElementDisplayed(refreshRecipientsButton)) 
			{
				LoggerManager.info("Refresh Recipients button is displayed. Clicking the button.");
				clickElement(refreshRecipientsButton);
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Refresh Recipients Button clicked successfully.");

				// Close the Schedule Communication dialog
				LoggerManager.info("Clicking the 'Close' button on the Schedule Communication dialog.");
				clickElement(scheduleCommunicationCloseButtton);

				LoggerManager.info("Schedule Communication refresh recipients button verification completed successfully.");
				return true;
			}
			else 
			{
				LoggerManager.warn("Refresh Recipients button is not displayed. Verification failed.");
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error occurred during date selection: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyScheduledByHyperlink() 
	{
		try 
		{
			// Perform date selection before proceeding
			LoggerManager.info("Initiating date selection for scheduled communication.");
			dropdownDateSelection();

			// Wait for the scheduled by search box to be visible and enter the search keyword
			LoggerManager.info("Waiting for the 'Scheduled By' search box to be visible.");
			waitForElementToBeVisible(scheduledBysearchbox);
			LoggerManager.info("Entering 'Steve Roebuck' in the 'Scheduled By' search box.");
			clickElement(scheduledBysearchbox);
			scheduledBysearchbox.clear();
			scheduledBysearchbox.sendKeys("Steve Roebuck");

			// Wait for loader icon to disappear
			LoggerManager.info("Waiting for the loader to disappear after entering search criteria.");
			waitForInvisibility(loaderIcon);

			// Verify if the 'Scheduled By' hyperlink is displayed
			LoggerManager.info("Checking if the 'Scheduled By' hyperlink is displayed.");

			if (isElementDisplayed(scheduledByHyperlink)) 
			{
				LoggerManager.info("Scheduled By hyperlink is displayed. Clicking the hyperlink.");
				clickElement(scheduledByHyperlink);
				waitForInvisibility(loaderIcon);

				// Press Escape key to close the new window or pop-up
				LoggerManager.info("Pressing the Escape key to close the opened window.");
				try 
				{
					pressEscapeKey();
				}
				catch (Exception e) 
				{
					LoggerManager.error("Error occurred while pressing Escape key: " + e.getMessage());
				}

				LoggerManager.info("Scheduled By hyperlink verification completed successfully.");
				return true;
			} 
			else 
			{
				LoggerManager.warn("Scheduled By hyperlink is not displayed. Verification failed.");
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error occurred during date selection: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyNewTemplateButton() 
	{
		try 
		{
			// Perform date selection before proceeding
			LoggerManager.info("Initiating date selection for the new template button functionality.");
			dropdownDateSelection();

			// Wait for the 'New Template' button to be visible
			LoggerManager.info("Waiting for the 'New Template' button to be visible.");
			waitForElementToBeVisible(newTemplateButton);

			// Check if the 'New Template' button is displayed
			LoggerManager.info("Checking if the 'New Template' button is displayed.");
			if (isElementDisplayed(newTemplateButton)) 
			{
				LoggerManager.info("New Template button is displayed. Clicking the button.");
				clickElement(newTemplateButton);
				waitForInvisibility(loaderIcon);

				// Close the new template modal or pop-up
				LoggerManager.info("Clicking the close button of the new template modal.");
				clickElement(newTemplateCloseButton);

				LoggerManager.info("New Template button functionality completed successfully.");
				return true;
			}
			else 
			{
				LoggerManager.warn("New Template button is not displayed. Verification failed.");
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error occurred during date selection: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyStatusCancel() 
	{
		try 
		{
			// Perform date selection
			LoggerManager.info("Initiating date selection for 'Cancelled' status verification.");
			dropdownDateSelect();
			waitForInvisibility(loaderIcon);

			// Apply status filters
			LoggerManager.info("Applying status filters.");
			selectStatusFilters();

			// Input the 'Cancelled' status into the search box
			LoggerManager.info("Entering 'Cancelled' status in the status search box.");
			statuSsearchbox.sendKeys("Cancelled");
			waitForInvisibility(loaderIcon);

			// Check if the action button is displayed
			LoggerManager.info("Checking if the action button is displayed for 'Cancelled' status.");
			if (isElementDisplayed(hyperlink)) 
			{
				LoggerManager.info("'Cancelled' status is verified successfully. No action button displayed.");
				return true;
			}
			else 
			{
				// If no action button is displayed, the status is successfully cancelled
				LoggerManager.warn("Action button is displayed, indicating 'Cancelled' status has an action associated.");
				return false;
			}

		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error occurred during date selection or status filter application: " + e.getMessage());
			return false;
			
		}
		
	}

	public boolean verifyStatusProcessed() throws Exception 
	{
		try 
		{
			// Log the initiation of status verification
			LoggerManager.info("Initiating verification for 'Processed' status.");

			// Perform date selection
			LoggerManager.info("Selecting date range for status verification.");
			dropdownDateSelect();
			waitForInvisibility(loaderIcon);

			// Apply status filters
			LoggerManager.info("Applying status filters for 'Processed' status.");
			selectStatusFilters();

			// Enter 'Processed' in the status search box
			LoggerManager.info("Entering 'Processed' in the status search box.");
			statuSsearchbox.sendKeys("Processed");
			waitForInvisibility(loaderIcon);

			// Wait for the action button to be visible and click it
			LoggerManager.info("Waiting for action button to be visible.");
			waitForElementToBeVisible(actionButton);
			clickElement(actionButton);
			waitForInvisibility(loaderIcon);

			// Wait for the close button to be visible
			LoggerManager.info("Waiting for close button to be visible.");
			waitForElementToBeVisible(closeButton);

			// If the close button is displayed, click it and return true
			if (isElementDisplayed(closeButton)) 
			{
				LoggerManager.info("Close button found, clicking and returning true.");
				clickElement(closeButton);
				return true;
			}
			else 
			{
				// If the close button is not displayed, return false
				LoggerManager.warn("Close button not found, returning false.");
				return false;
			}

		} 
		catch (Exception e) 
		{
			// Log the exception in case of an error
			LoggerManager.error("Exception encountered during 'Processed' status verification: " + e.getMessage());
			throw e;  // Rethrow the exception if you need to handle it at a higher level
		}
	}

	public boolean verifyStatusScheduled() throws Exception 
	{
		try 
		{
			// Log the initiation of status verification
			LoggerManager.info("Initiating verification for 'Scheduled' status.");

			// Perform date selection
			LoggerManager.info("Selecting date range for 'Scheduled' status verification.");
			dropdownDateSelect();
			waitForInvisibility(loaderIcon);

			// Apply status filters
			LoggerManager.info("Applying status filters for 'Scheduled' status.");
			selectStatusFilters();

			// Enter 'Scheduled' in the status search box
			LoggerManager.info("Entering 'Scheduled' in the status search box.");
			statuSsearchbox.sendKeys("Scheduled");
			waitForInvisibility(loaderIcon);

			// Wait for the action button to be visible and click it
			LoggerManager.info("Waiting for action button to be visible.");
			waitForElementToBeVisible(actionButton);
			clickElement(actionButton);
			waitForInvisibility(loaderIcon);

			// Wait for the close button to be visible
			LoggerManager.info("Waiting for close button to be visible.");
			waitForElementToBeVisible(closeButton);

			// If the close button is displayed, click it and return true
			if (isElementDisplayed(closeButton)) 
			{
				LoggerManager.info("Close button found, clicking and returning true.");
				clickElement(closeButton);
				return true;
			}
			else 
			{
				// If the close button is not displayed, return false
				LoggerManager.warn("Close button not found, returning false.");
				return false;
			}

		} 
		catch (Exception e) 
		{
			// Log the exception in case of an error
			LoggerManager.error("Exception encountered during 'Scheduled' status verification: " + e.getMessage());
			throw e;  // Rethrow the exception if you need to handle it at a higher level
		}
	}

	public boolean verifyStatusPendingApproval() throws Exception 
	{
		try 
		{
			// Log the initiation of status verification
			LoggerManager.info("Initiating verification for 'Pending Approval' status.");

			// Perform date selection
			LoggerManager.info("Selecting date range for 'Pending Approval' status verification.");
			dropdownDateSelect();
			waitForInvisibility(loaderIcon);

			// Apply status filters
			LoggerManager.info("Applying status filters for 'Pending Approval' status.");
			selectStatusFilters();

			// Enter 'Pending Approval' in the status search box
			LoggerManager.info("Entering 'Pending Approval' in the status search box.");
			statuSsearchbox.sendKeys("Pending Approval");
			waitForInvisibility(loaderIcon);

			// Wait for the action button to be visible and click it
			LoggerManager.info("Waiting for action button to be visible.");
			waitForElementToBeVisible(actionButton);
			clickElement(actionButton);
			waitForInvisibility(loaderIcon);

			// Wait for the close button to be visible
			LoggerManager.info("Waiting for close button to be visible.");
			waitForElementToBeVisible(closeButton);

			// If the close button is displayed, click it and return true
			if (isElementDisplayed(closeButton)) 
			{
				LoggerManager.info("Close button found, clicking and returning true.");
				clickElement(closeButton);
				return true;
			}
			else 
			{
				// If the close button is not displayed, return false
				LoggerManager.warn("Close button not found, returning false.");
				return false;
			}

		} 
		catch (Exception e) 
		{
			// Log the exception in case of an error
			LoggerManager.error("Exception encountered during 'Pending Approval' status verification: " + e.getMessage());
			throw e;  // Rethrow the exception if you need to handle it at a higher level
		}
	}
}