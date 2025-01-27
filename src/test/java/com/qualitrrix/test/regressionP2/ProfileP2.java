package com.qualitrrix.test.regressionP2;

import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qualitrix.annotation.values.Author;
import com.qualitrix.client.QXClient;
import com.qualitrix.pageActions.CoursePageActions;
import com.qualitrix.pageActions.DikshaMainPageActions;
import com.qualitrix.pageActions.DownloadPageActions;
import com.qualitrix.pageActions.HomePageActions;
import com.qualitrix.pageActions.LibraryCourseContentPageActions;
import com.qualitrix.pageActions.LoginPageActions;
import com.qualitrix.pageActions.ProfileEditPageActions;
import com.qualitrix.pageActions.TrainingPageActions;

public class ProfileP2 {

	public DikshaMainPageActions getDikshaMainPageActions() {
		return new DikshaMainPageActions();
	}

	public LoginPageActions getLoginPageActions() {
		return new LoginPageActions();
	}

	public CoursePageActions getCoursePageActions() {
		return new CoursePageActions();
	}

	public LibraryCourseContentPageActions getLibraryPageActions() {
		return new LibraryCourseContentPageActions();
	}

	public HomePageActions getHomePageActions() {
		return new HomePageActions();
	}
	 public TrainingPageActions getTrainingPageActions() {
	        return new TrainingPageActions();
	    }
	 public DownloadPageActions getDownloadPageActions() {
	        return new DownloadPageActions();
	    }
	 public ProfileEditPageActions getProfileEditPageActions() {
	        return new ProfileEditPageActions();
	    }
	 // DikshaMainPageActions d=new DikshaMainPageActions();

	 
	@BeforeClass
	public void BeforeClass() {
		System.out.println("@BeforeClass");
		// QXClient.get().driver();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		// QXClient.get().driver();

	}
	 @Test()
	    public void noTermsAndConditionsCheckboxIsDisplayedInSelfInfoSection() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
	        System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 59, 2);
	        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 60, 2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
	        getLoginPageActions().loginToTheUser(Username, Password);

	        getHomePageActions().tapOnProfileTab();

	        getProfileEditPageActions().verifyNoTermsAndConditionsCheckboxInUpdateSelfInfoSection();

	    }
	@Test()
    public void verifyPostClickingOngoingCourseInProfilePageLandsOnCourseTOCPage() throws Exception {

        QXClient.get().driver();
        getDikshaMainPageActions().performUserOnBoarding();


        getHomePageActions().tapOnProfileTab();
        QXClient.get().gestures().swipeUp();
        QXClient.get().gestures().swipeUp();
        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
                properties.getProperty("excelpath"));

        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",45,2);
        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",46,2);


        getLoginPageActions().loginToTheUser(Username,Password);

        DikshaMainPageActions d=new DikshaMainPageActions();
        QXClient.get().gestures().closeApp();
        d.LaunchAppHomeScreen();
        getHomePageActions().tapOnDownloadTab();

        getHomePageActions().tapOnProfileTab();

        QXClient.get().gestures().swipeUp();

        getCoursePageActions().tapOnOngoingCourse();


    }
	  @Test()
	    public void validateCoursesUnderMoreBtnInMyLearningSectionOfProfile() throws Exception {

	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();

	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",36,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",37,2);


	        getLoginPageActions().loginToTheUser(Username,Password);

	        getHomePageActions().tapOnProfileTab();

	        getCoursePageActions().verifyOngoingAndCompletedCoursesUnderMyLearning();

	        getCoursePageActions().verifyMoreBtnAndCoursesUnderMoreBtnInProfile();

	    }
	 @Test()
	    public void verifyInCorrectOTPMsgFailedToValidateOTPMsgAndRemainingAttemptsMsgWhileUpdatingContactDetails() throws Exception {

	        QXClient.get().driver();
	        DikshaMainPageActions d = new DikshaMainPageActions();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
	        System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 111, 2);
	        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 112, 2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username, Password);

	        d.LaunchAppHomeScreen();

	        getHomePageActions().tapOnProfileTab();

	        getProfileEditPageActions().verifyIncorrectOTPMessageWhileUpdatingContactInformation();

	        getProfileEditPageActions().verifyFailedToValidateOTPMessageWhileUpdatingContactInformation();


	    }
	 @Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun =
			  true, description = "courseNameInProfileTab")
			  public void courseNameInProfileTab() throws Exception { 
				  QXClient.get().driver();
			  getDikshaMainPageActions().performUserOnBoarding();
			  getHomePageActions().tapOnProfileTab();
			  
			  
			  Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
			  properties.getProperty("excelpath"));
			  
			  String fetchExcelPathFromConfig=properties.getProperty("excelpath");
			  QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");
			  
			  String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",36,2); 
			  String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",37,2);

			  QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
			  getLoginPageActions().loginToTheUser(Username,Password);
			  DikshaMainPageActions d=new DikshaMainPageActions();
			  QXClient.get().gestures().closeApp();  
			    d.LaunchAppHomeScreen();
				  getHomePageActions().tapOnDownloadTab();

				  
			  getHomePageActions().tapOnProfileTab();
			  getCoursePageActions().verifyCoursesSectionInProfile();
			  
			  
			  }
	
	  @Test()
	    public void verifyPrefilledEmailIDInUserDeclarationForm() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",143,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",144,2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
	        getLoginPageActions().loginToTheUser(Username,Password);

	        QXClient.get().gestures().BlindWait(4000);
	        DikshaMainPageActions d=new DikshaMainPageActions();
	        QXClient.get().gestures().closeApp();
	        d.LaunchAppHomeScreen();
	        getHomePageActions().tapOnDownloadTab();

	        getHomePageActions().tapOnProfileTab();

	        getCoursePageActions().VerifySubmitDetailsForm();

	        getCoursePageActions().verifyEmailIdPrefilledInUserDeclarationForm();
	    }
	
	 @Test()
	    public void verifyLatestPrivacyPolicyAndTCCheckBoxInSubmitDetailsPage() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",2,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",3,2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
	        getLoginPageActions().loginToTheUser(Username,Password);

	        QXClient.get().gestures().BlindWait(4000);
	        DikshaMainPageActions d=new DikshaMainPageActions();
	        QXClient.get().gestures().closeApp();
	        d.LaunchAppHomeScreen();
	        getHomePageActions().tapOnDownloadTab();

	        getHomePageActions().tapOnProfileTab();

	        getCoursePageActions().VerifySubmitDetailsForm();

	        getCoursePageActions().verifyNewPricacyPolicyInSubmitDetailsForm();
	    }
	 @Test(enabled = true,  alwaysRun = true,
	            description = "Landed on Home page after changing Subrole in profile  ")
	    public void verifyLandingOnHomePagePostChangeOfSubroleInProfile() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();
	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
	        System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 43, 2);
	        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 44, 2);

	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username, Password);

	        getHomePageActions().tapOnProfileTab();

	        getProfileEditPageActions().changeSubRoleAndLandsOnHomePage();

	        getHomePageActions().verifySectionsInHomePage();


	    }
	 @Test()
	    public void validateErrorMessageForIncorrectMobileNoAndEmailAddressInSubmitDetailsPage() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",130,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",131,2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
	        getLoginPageActions().loginToTheUser(Username,Password);

	        //getHomePageActions().tapOnDownloadTab();

	        getHomePageActions().tapOnProfileTab();

	        getCoursePageActions().verifyErrorMessageInSubmitDetails();
	    }


	
	 @Author(name="Raju")

	    @Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun = true,description = "Verify updateProfileDetails")
	    public void verifyCustodianUserIsAbleToUpdateTheProfile() throws Exception {

	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",2,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",3,2);

	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username,Password);
	        DikshaMainPageActions d=new DikshaMainPageActions();
	        QXClient.get().gestures().closeApp();
	        d.LaunchAppHomeScreen();
	        getHomePageActions().tapOnDownloadTab();


	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getCoursePageActions().updateProfileDetails();


	    }
	 @Test()
		public void verifyConsentFormInSubmitDetails() throws Exception {
			QXClient.get().driver();
			getDikshaMainPageActions().performUserOnBoarding();
			getHomePageActions().tapOnProfileTab();


			Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
					properties.getProperty("excelpath"));

			String fetchExcelPathFromConfig=properties.getProperty("excelpath");
			QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

			String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",128,2);
			String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",129,2);
			QXClient.get().gestures().swipeUp();
			QXClient.get().gestures().swipeUp();
			getLoginPageActions().loginToTheUser(Username,Password);

			QXClient.get().gestures().BlindWait(4000);
			DikshaMainPageActions d=new DikshaMainPageActions();
			QXClient.get().gestures().closeApp();
			d.LaunchAppHomeScreen();
			getHomePageActions().tapOnDownloadTab();

			getHomePageActions().tapOnProfileTab();

			getCoursePageActions().VerifySubmitDetailsForm();
		}
		

	 @Author(name="Raju")

	    @Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun = true,description = "Verify updateUserOnBoardingValues")
	    public void updateUserOnBoardingValues() throws Exception {

	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",2,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",3,2);

	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username,Password);
	        DikshaMainPageActions d=new DikshaMainPageActions();
	        QXClient.get().gestures().closeApp();
	        d.LaunchAppHomeScreen();
	        getHomePageActions().tapOnDownloadTab();


	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getCoursePageActions().updateProfileDetails();


	    }

	
 


	 @Test()
	    public void verifyContentPreferenceLabelAndOtherSectionInProfileAreDisplayedSameWay() throws Exception {

	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",2,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",3,2);

	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username,Password);
	        DikshaMainPageActions d=new DikshaMainPageActions();
	        QXClient.get().gestures().closeApp();
	        d.LaunchAppHomeScreen();
	        getHomePageActions().tapOnDownloadTab();
	        getHomePageActions().tapOnProfileTab();

	        getProfileEditPageActions().verifyTwoSectionsOfProfilePage();


	    }

	 @Test()
	    public void verifyChooseContentPreferencesPageIsDisplayedProperly() throws Exception {
	        QXClient.get().driver();

	        getDikshaMainPageActions().performUserOnBoarding();

	        getHomePageActions().tapOnProfileTab();

	        getProfileEditPageActions().verifyChooseContentPreferencesLabelIsNotOverlapping();

	    }

	 @Test()
	    public void verifyConsentFormIsDisplayedForOldUserInProfilePage() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",130,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",131,2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
	        getLoginPageActions().loginToTheUser(Username,Password);

	        QXClient.get().gestures().BlindWait(4000);
	        DikshaMainPageActions d=new DikshaMainPageActions();
	        QXClient.get().gestures().closeApp();
	        d.LaunchAppHomeScreen();
	        getHomePageActions().tapOnDownloadTab();

	        getHomePageActions().tapOnProfileTab();

	        getCoursePageActions().VerifySubmitDetailsForm();
	    }

	
	@Test()
    public void validateEditButtonsInProfilePageAreDisplayedInCamelCasing() throws Exception {

        QXClient.get().driver();
        DikshaMainPageActions d = new DikshaMainPageActions();
        getDikshaMainPageActions().performUserOnBoarding();
        getHomePageActions().tapOnProfileTab();


        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
        System.out.println("@name:" +
                properties.getProperty("excelpath"));

        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 2, 2);
        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 3, 2);
        QXClient.get().gestures().swipeUp();
        QXClient.get().gestures().swipeUp();

        getLoginPageActions().loginToTheUser(Username, Password);

        getHomePageActions().tapOnProfileTab();

        getProfileEditPageActions().verifyFirstEditButtonInProfilePageIsInCamelCasing();

        getProfileEditPageActions().verifySecondEditButtonInProfilePageIsInCamelCasing();

    }
	
	  

	@Test()
    public void validateBlockClusterSchoolValuesAreDisplayedInCamelCasing() throws Exception {

        QXClient.get().driver();
        DikshaMainPageActions d = new DikshaMainPageActions();
        getDikshaMainPageActions().performUserOnBoarding();
        getHomePageActions().tapOnProfileTab();


        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
        System.out.println("@name:" +
                properties.getProperty("excelpath"));

        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 82, 2);
        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 83, 2);
        QXClient.get().gestures().swipeUp();
        QXClient.get().gestures().swipeUp();

        getLoginPageActions().loginToTheUser(Username, Password);

        getHomePageActions().tapOnProfileTab();

        getProfileEditPageActions().verifyBlockDisplayedInCamelCasing();

        getProfileEditPageActions().verifyClusterIsDisplayedInCamelCasing();

        getProfileEditPageActions().verifySchoolIsDisplayedInCamelCasing();

    }


	 @Test()
	    public void updateBCSValuesInProfile() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();
	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
	        System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 2, 2);
	        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 3, 2);

	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username, Password);

	        getHomePageActions().tapOnProfileTab();

	        getProfileEditPageActions().verifyEditAll5LocationFields();
	    }
	
	@Test()
    public void verifyUserIDReplacedWithDikshaIDBelowUserNameInProfilePage() throws Exception {

        QXClient.get().driver();
        getDikshaMainPageActions().performUserOnBoarding();
        DikshaMainPageActions d = new DikshaMainPageActions();
        getHomePageActions().tapOnProfileTab();
        QXClient.get().gestures().swipeUp();
        QXClient.get().gestures().swipeUp();
        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
        System.out.println("@name:" +
                properties.getProperty("excelpath"));

        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 2, 2);
        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 3, 2);

        getLoginPageActions().loginToTheUser(Username, Password);

        QXClient.get().gestures().closeApp();
        d.LaunchAppHomeScreen();

        getHomePageActions().tapOnProfileTab();

        getProfileEditPageActions().verifyUserIDReplacedWithDikshaIDBelowUserNameInProfilePage();
    }

	 @Test()
	    public void verifyDikshaIDRemainsSameAfterRefresh() throws Exception {

	        QXClient.get().driver();

	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
	        System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 2, 2);
	        String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 3, 2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username, Password);

	        getHomePageActions().tapOnProfileTab();

	        getProfileEditPageActions().verifyDikshaIDAndUserInProfilePage();

	        getProfileEditPageActions().validateTwoCharactersOfUsernameAndDikshaIDAreSameInProfile();


	    }


	 @Test()
	    public void verifyUIisNotBreakingInAnyPlaceOfProfilePage() throws Exception {

	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",2,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",3,2);

	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getLoginPageActions().loginToTheUser(Username,Password);
	        DikshaMainPageActions d=new DikshaMainPageActions();
	        QXClient.get().gestures().closeApp();
	        d.LaunchAppHomeScreen();
	        getHomePageActions().tapOnDownloadTab();


	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();

	        getCoursePageActions().updateProfileDetails();


	    }

	 @Test()
	    public void validateUserIsNotAbleSubmitDetailsWithoutSelectingTCCheckBox() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnProfileTab();
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();


	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",130,2);
	        String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",131,2);
	        QXClient.get().gestures().swipeUp();
	        QXClient.get().gestures().swipeUp();
	        getLoginPageActions().loginToTheUser(Username,Password);

	        //getHomePageActions().tapOnDownloadTab();

	        getHomePageActions().tapOnProfileTab();

	        getCoursePageActions().verifyMandatoryTCFieldAndUserNotAbleSubmitDetailsWithoutSelectingTCCheckbox();
	    }

    @Test()
    public void verifyNoProfileDetailsLabelAndNoDeviceLocationForGuestUserInProfile() throws Exception {

        QXClient.get().driver();
        getDikshaMainPageActions().performUserOnBoarding();
        getHomePageActions().tapOnProfileTab();

        getProfileEditPageActions().verifyGuestUserProfilePageLabels();

    }
    @Test()
    public void StateUserShouldBeAbleToEditAllValuesInTheProfilePage() throws Exception {
            QXClient.get().driver();
            getDikshaMainPageActions().performUserOnBoarding();
            getHomePageActions().tapOnProfileTab();
            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().swipeUp();


            Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
            System.out.println("@name:" +
                            properties.getProperty("excelpath"));

            String fetchExcelPathFromConfig = properties.getProperty("excelpath");
            QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

            String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 38, 2);
            String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 39, 2);
            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().swipeUp();
            getLoginPageActions().loginToTheUser(Username, Password);
            QXClient.get().gestures().closeappandrelaunchapp();

            getHomePageActions().tapOnProfileTab();

            getProfileEditPageActions().verifyStateUserShouldBeAbleToEditAllValuesInTheProfilepage();
    }
    
    
  
	          
    @Test()
    public void verifyUserIsAbleToUpdateClassAndMediumValuesInTheProfileAndValidateinLibraryTab() throws Exception {

            QXClient.get().driver();
            getDikshaMainPageActions().performUserOnBoarding();
            getHomePageActions().tapOnProfileTab();


            Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
            System.out.println("@name:" +
                            properties.getProperty("excelpath"));

            String fetchExcelPathFromConfig = properties.getProperty("excelpath");
            QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

            String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 17, 2);
            String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 18, 2);

            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().swipeUp();

            getLoginPageActions().loginToTheUser(Username, Password);
            DikshaMainPageActions d = new DikshaMainPageActions();
            QXClient.get().gestures().closeApp();
            d.LaunchAppHomeScreen();
            getHomePageActions().tapOnDownloadTab();


            getHomePageActions().tapOnProfileTab();
            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().swipeUp();
            getCoursePageActions().ValidateUpdatedClassAndMediumValuesInTheLibraryTabByClickingBackButton();
            QXClient.get().gestures().closeApp();
            d.LaunchAppHomeScreen();
            getCoursePageActions().VerifyUpdatedClassandMediumValuesLibrarytab();
            QXClient.get().gestures().closeApp();
            d.LaunchAppHomeScreen();
            getHomePageActions().tapOnDownloadTab();
            getHomePageActions().tapOnProfileTab();
            getCoursePageActions().verifyUserIsAbleToUpdateClassAndMediumValuesInTheProfile();
            QXClient.get().gestures().closeApp();
            d.LaunchAppHomeScreen();
            getCoursePageActions().VerifyUpdatedClassandMediumValuesLibrarytab();

    }
    
    @Test()
    public void verifyheaderisdisplayinlearnerpassbookprofile() throws Exception {
            QXClient.get().driver();
            getDikshaMainPageActions().performUserOnBoarding();
            getHomePageActions().tapOnProfileTab();


            Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
                            properties.getProperty("excelpath"));

            String fetchExcelPathFromConfig=properties.getProperty("excelpath");
            QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

            String Username =QXClient.get().excelUtils().getCellValue("Excel1","TestData",45,2);
            String Password =QXClient.get().excelUtils().getCellValue("Excel1", "TestData",46,2);

            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().swipeUp();
            getLoginPageActions().loginToTheUser(Username,Password);
            DikshaMainPageActions d=new DikshaMainPageActions();
            QXClient.get().gestures().closeApp();
            d.LaunchAppHomeScreen();
            //getHomePageActions().tapOnDownloadTab();


            getHomePageActions().tapOnProfileTab();
            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().swipeUp();
            QXClient.get().gestures().BlindWait(5000);

            getCoursePageActions().verifylearnerpassbook2();
            getCoursePageActions().verifylearnerpassbookcourse();


    }
    
    @Test()
	 public void verifysubmitdetailsbuttonandconsentpopupshouldnotdisplayedonProfilepage() throws Exception {

	         QXClient.get().driver();
	         DikshaMainPageActions d = new DikshaMainPageActions();
	         getDikshaMainPageActions().performUserOnBoarding();
	         getHomePageActions().tapOnProfileTab();
	         Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                                 properties.getProperty("excelpath"));

	                 String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	                 QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	                 String Username =QXClient.get().excelUtils().getCellValue("Excel1","Profile",2,2);
	                 String Password =QXClient.get().excelUtils().getCellValue("Excel1", "Profile",3,2);
	         String coursefetch =QXClient.get().excelUtils().getCellValue("Excel1", "Profile",4,2);
	                 QXClient.get().gestures().swipeUp();
	                 QXClient.get().gestures().swipeUp();
	                 getLoginPageActions().loginToTheUser(Username,Password);

	                 QXClient.get().gestures().BlindWait(4000);
	    	         QXClient.get().gestures().closeappandrelaunchapp();

	                 getHomePageActions().tapOnDownloadTab();

	                 getHomePageActions().tapOnProfileTab();

	                 getCoursePageActions().verifysubmitdetailsbuttonProfilepage();
	    	         QXClient.get().gestures().closeappandrelaunchapp();

            getHomePageActions().tapOnDownloadTab();

	         getHomePageActions().tapOnMenuBar();

	         getCoursePageActions().tapOnAddAnotherUser();

	         String FakeName=QXClient.get().gestures().generateRandomName();
	         String storeFakeNameEntered= getCoursePageActions().enterName(FakeName);
	         System.out.println(storeFakeNameEntered);
	         getCoursePageActions().tapOnAddUserBtn();
	         
	         QXClient.get().gestures().closeappandrelaunchapp();
	         getHomePageActions().tapOnMenuBar();

	         getCoursePageActions().tapOnMoreOption();
	         QXClient.get().gestures().generateXpathAndClickElement(storeFakeNameEntered);


	         getCoursePageActions().tapOnChangeUserWithoutProfile();

	         getCoursePageActions().tapOnTermsAndCondition();

	         getCoursePageActions().tapOnContinueForSwicthUser();
	         QXClient.get().gestures().closeappandrelaunchapp();

	         getHomePageActions().tapOnTrainingTab();

	   
	         

	         getHomePageActions().tapOnSearchIcon();
	         getHomePageActions().enterTextInSearchBar(coursefetch);

	         //QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement(coursefetch);
	         getTrainingPageActions().tapOnSearchedCoursePr();

	         getCoursePageActions().verifysubmitdetailsbuttonandconsentpopupshouldnotdisplayedonProfilepage();
	         }
    
    @Test()
	public void verifyLatestBatchWithCertificateDisplayInMyLearningSection() throws Exception {

		QXClient.get().driver();
		getDikshaMainPageActions().performUserOnBoardingAndClickSwitchToNewExperience();
		DikshaMainPageActions d = new DikshaMainPageActions();

		getHomePageActions().tapOnProfileTab();


		Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
		System.out.println("@name:" +
				properties.getProperty("excelpath"));

		String fetchExcelPathFromConfig = properties.getProperty("excelpath");
		QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

		String Username = QXClient.get().excelUtils().getCellValue("Excel1", "Profile", 19, 2);
		String Password = QXClient.get().excelUtils().getCellValue("Excel1", "Profile", 20, 2);

		QXClient.get().gestures().swipeUp();
		QXClient.get().gestures().swipeUp();

		getLoginPageActions().loginToTheUser(Username, Password);
		getHomePageActions().tapOnProfileTab();

		getTrainingPageActions().verifyCertificateForLatestBatchInMyLearning();

		QXClient.get().gestures().closeApp();
	}
    
    @Test()
    public void VerifyBothTheBatchWithCertificateIsShownInLearnerPassbookSection() throws Exception {
    	QXClient.get().driver();
    	getDikshaMainPageActions().performUserOnBoarding();
    	getHomePageActions().tapOnProfileTab();

    	getHomePageActions().tapOnProfileTab();


    	Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
    	System.out.println("@name:" +
    			properties.getProperty("excelpath"));

    	String fetchExcelPathFromConfig = properties.getProperty("excelpath");
    	QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

    	String Username = QXClient.get().excelUtils().getCellValue("Excel1", "Profile",2,5);
    	String Password = QXClient.get().excelUtils().getCellValue("Excel1", "Profile",3,5);
    	String coursefetch =QXClient.get().excelUtils().getCellValue("Excel1", "Profile",4,5);

    	QXClient.get().gestures().swipeUp();
    	QXClient.get().gestures().swipeUp();

    	getLoginPageActions().loginToTheUser(Username, Password);

    	getHomePageActions().tapOnTrainingTab();
    	getHomePageActions().tapOnSearchIcon();
    	getHomePageActions().enterTextInSearchBar(coursefetch);
    	QXClient.get().gestures().swipeUp();

    	getTrainingPageActions().tapOnNewCourseWithCertificate();
    	QXClient.get().gestures().closeappandrelaunchapp();
    	getHomePageActions().tapOnProfileTab();

    	getTrainingPageActions().VerifyBothTheBatchWithCertificateIsShownInLearnerPassbookSection();
    	getTrainingPageActions().VerificationonFirstBatchWithCertificate();
    	getTrainingPageActions().VerificationonSecondBatchWithCertificate();

    }
    
    @Test
    public void ValidateCustodianAndNonCustodianUsersAbleToEditAllTheValuesinProfilePAge() throws Exception {
        QXClient.get().driver();
        //getDikshaMainPageActions().performUserOnBoardingWithHeadTeacherAndOfficials();
        getDikshaMainPageActions().performUserOnBoarding();
        DikshaMainPageActions d = new DikshaMainPageActions();
        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") + "/configs/config.properties");
        System.out.println("@name:" +
              properties.getProperty("excelpath"));
        String fetchExcelPathFromConfig = properties.getProperty("excelpath");
        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");
        String externalID = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 92, 2);
        getHomePageActions().tapOnProfileTab();
        QXClient.get().gestures().swipeUp();
        QXClient.get().gestures().swipeUp();
        getLoginPageActions().verifySSOUserAbleToLoginUsingStateSystemUsingUsernameExternalID(externalID);
        d.LaunchAppHomeScreen();
        getHomePageActions().tapOnProfileTab();
        //getProfileEditPageActions().veriyNoLocationPopupWhenLoggedInWithSSOUser();
        getCoursePageActions().ValidateLocationfieldsinProfilePAge();
        QXClient.get().gestures().closeappandrelaunchapp();
        //getHomePageActions().tapOnProfileTab();
        getCoursePageActions().ValidateUpdatedLocationfieldsinProfilePage();
    }
}

	

