package com.qualitrrix.test.regression;

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

public class ContentConsumption2 {

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
		public void verifyPageInsteadOfLocationInPDFContent() throws Exception {
			QXClient.get().driver();
			getDikshaMainPageActions().performUserOnBoarding();
			getHomePageActions().tapOnSearchIcon();
			getHomePageActions().enterTextInSearchBar("PDF_13.pdf");

			getTrainingPageActions().tapOnSearchedPDF();
			getLibraryPageActions().tapOnPlayIcon3();
			getLibraryPageActions().verifyPageReplacesLocationInContent();

		}

	    
	    
	    @Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun = true,
	    		description = "Verify UserAble to PrintPDFContent ")
	    		public void PrintIconInPDFContent() throws Exception {
	    		QXClient.get().driver();
	    		getDikshaMainPageActions().performUserOnBoarding();	 
	    		getHomePageActions().tapOnSearchIcon();
	    		getHomePageActions().enterTextInSearchBar("PDF_13.pdf");
	    		//QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement("PDF_13.pdf");
	    		getTrainingPageActions().tapOnSearchedPDF();
	    		getLibraryPageActions().tapOnPlayIcon3();
	    		getLibraryPageActions().printPDF();
	    		}    



		@Test()
		public void verifyPageNotFoundTextAndUserAbleToJumpToPageInEpubContent() throws Exception {

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

			String Username = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 2, 2);
			String Password = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 3, 2);


			getLoginPageActions().loginToTheUser(Username, Password);

			//getHomePageActions().tapOnTrainingTab();

			getHomePageActions().tapOnSearchIcon();
			getHomePageActions().enterTextInSearchBar("Epub content");

			getTrainingPageActions().tapOnEpubContent();

			getTrainingPageActions().verifyUserAbleToJumpToPagesAndPageNotFoundText();

		}



	@Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun = true,
	description = "Verify verifyZoomInZoomOut ")
	public void VerifyZoomOptionInPDFContent() throws Exception {
	QXClient.get().driver();
	getDikshaMainPageActions().performUserOnBoarding();
	getHomePageActions().tapOnSearchIcon();
	getHomePageActions().enterTextInSearchBar("PDF_13.pdf");
	//QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement("PDF_13.pdf");
	getTrainingPageActions().tapOnSearchedPDF();
	getLibraryPageActions().tapOnPlayIcon3();
	getLibraryPageActions().verifyZoomInZoomOut();
	}

	
	
	
	  @Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun = true,
	    		description = "Verify UserAble to verifyIconInPDFHamburgerMenu ")
	    		public void VerifyOptionInPDFContentInHamburgerMenu() throws Exception {
	    		QXClient.get().driver();
	    		getDikshaMainPageActions().performUserOnBoarding();	 
	    		getHomePageActions().tapOnSearchIcon();
	    		getHomePageActions().enterTextInSearchBar("PDF_13.pdf");
	    		//QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement("PDF_13.pdf");
	    		getTrainingPageActions().tapOnSearchedPDF();
	    		getLibraryPageActions().tapOnPlayIcon3();
	    		getLibraryPageActions().verifyIconInPDFHamburgerMenu();
	    		}
	   @Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun = true,
	            description = "Verify verifyNextAndPreviousBtnInPDF ")
	    public void VerifyNextAndPreviousPageInPDFContent() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();
	        getHomePageActions().tapOnSearchIcon();
	        getHomePageActions().enterTextInSearchBar("PDF_13.pdf");
	//QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement("PDF_13.pdf");
	        getTrainingPageActions().tapOnSearchedPDF();
	        getLibraryPageActions().tapOnPlayIcon3();
	        getLibraryPageActions().verifyNextAndPreviousBtnInPDF();
	    }

	   @Test()
	    public void verifyDownloadPopUpInHamburgerMenuOfContent() throws Exception {

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

	        //getHomePageActions().tapOnTrainingTab();

	        getHomePageActions().tapOnSearchIcon();
	        getHomePageActions().enterTextInSearchBar("PDF_13.pdf");
	        //QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement("PDF_13.pdf");
	        getTrainingPageActions().tapOnSearchedPDF();
	        getTrainingPageActions().verifyDownloadPopupOfContent();


	    }
	   
	   @Test(enabled = true, groups = {"SanityTest", "FunctionalTest"}, alwaysRun = true,
	            description = "Verify searchContentAndDownload ")
	    public void searchContentAndDownload() throws Exception {
	        QXClient.get().driver();
	        getDikshaMainPageActions().performUserOnBoarding();

	        Properties properties = QXClient.get().propUtils().getProperties(System.getProperty("user.dir") +"/configs/config.properties"); System.out.println("@name:" +
	                properties.getProperty("excelpath"));

	        String fetchExcelPathFromConfig=properties.getProperty("excelpath");
	        QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

	        String BookName =QXClient.get().excelUtils().getCellValue("Excel1","TestData",26,2);


	        getHomePageActions().tapOnSearchIcon();
	        getHomePageActions().enterTextInSearchBar(BookName);
	        //QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement(BookName);

	        getTrainingPageActions().tapOnSearchedBook();

	        getLibraryPageActions().tapOnDownloadBtn();
	        getTrainingPageActions().tapOnDownloadBtnInDownloadPopUp();
	        //getTrainingPageActions().verifyFileDownloadThroughNotification();
	        getTrainingPageActions().waitTillTheDownloadButtonDisappears();
	        QXClient.get().gestures().clkBackButton();
	        QXClient.get().gestures().clkBackButton();


	        getHomePageActions().tapOnDownloadTab();
	        getDownloadPageActions().verifyTheDownloadedBook();
	    }
	   
		  @Test()
		    public void verifyContentForRegionalLanguages() throws Exception {
		        QXClient.get().driver();
		        DikshaMainPageActions d = new DikshaMainPageActions();
		        getDikshaMainPageActions().performUserOnBoarding();
		        getHomePageActions().tapOnProfileTab();
		        QXClient.get().gestures().closeApp();
		        d.LaunchAppHomeScreen();

		        //getHomePageActions().tapOnTrainingTab();
		        getHomePageActions().tapOnSearchIcon();
		        getHomePageActions().enterTextInSearchBar("Resource");

		        getTrainingPageActions().verifyContentOfRegionallanguage();

		    }

		  
		  @Test()
			public void verifyContentDetails() throws Exception {

				QXClient.get().driver();
				getDikshaMainPageActions().performUserOnBoarding();

				getHomePageActions().tapOnDownloadTab();
				Properties properties = QXClient.get().propUtils()
						.getProperties(System.getProperty("user.dir") + "/configs/config.properties");
				System.out.println("@name:" + properties.getProperty("excelpath"));

				String fetchExcelPathFromConfig = properties.getProperty("excelpath");
				QXClient.get().excelUtils().open(fetchExcelPathFromConfig, "Excel1");

				String BookName = QXClient.get().excelUtils().getCellValue("Excel1", "TestData", 26, 2);
				getHomePageActions().tapOnTrainingTab();

				getHomePageActions().tapOnSearchIcon();
				getHomePageActions().enterTextInSearchBar(BookName);
				// QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement(BookName);
				getTrainingPageActions().tapOnSearchedBook();
				getTrainingPageActions().verifyContentDetailsInContentsPage();

			}

		  @Test()
		    public void verifyUserAbleToPlayEpubContentPostLogin() throws Exception {

		        QXClient.get().driver();
		        getDikshaMainPageActions().performUserOnBoarding();
		        DikshaMainPageActions d = new DikshaMainPageActions();
		        getHomePageActions().tapOnDownloadTab();
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
		        d.LaunchAppHomeScreen();
		        getHomePageActions().tapOnTrainingTab();

		        getHomePageActions().tapOnSearchIcon();
		        getHomePageActions().enterTextInSearchBar("Epub");
		        //QXClient.get().gestures().generateXpathUsingClassAndTextAndClickElement(CourseName);
		        getTrainingPageActions().tapOnEpubContent3();
		        getTrainingPageActions().verifyUserAbleToPlayEpubContent();

		    }
		  @Test()
		    public void verifyBackBtnIsWorkingFineInCollectionWithH5PContent () throws Exception {
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

		        DikshaMainPageActions d=new DikshaMainPageActions();

		        QXClient.get().gestures().closeApp();
		        d.LaunchAppHomeScreen();

		        getHomePageActions().tapOnSearchIcon();
		        getHomePageActions().enterTextInSearchBar("AutoH5PCollectionContent");

		        getTrainingPageActions().tapOnSearchedH5pCollection();

		        getTrainingPageActions().verifyH5PCollectionContentPage();

		        getTrainingPageActions().verifyPostSingleClickBackbtnUserShouldComeBackFromH5pContent();

		    }

		  @Test()
		    public void validateNextButtonIsWorkingFineForCollectionWithPDFContent() throws Exception {
		        QXClient.get().driver();
		        getDikshaMainPageActions().performUserOnBoarding();

		        getHomePageActions().tapOnTrainingTab();

		        getHomePageActions().tapOnSearchIcon();
		        getHomePageActions().enterTextInSearchBar("AutoPDFCollection");
		        getTrainingPageActions().tapOnSearchedPDFCollection();
		        getLibraryPageActions().tapOnPlayIcon4();
		        getLibraryPageActions().validateNextButtonIsWorkingFine();


		    }


}