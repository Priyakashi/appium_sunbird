package com.qualitrix.report.factory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qualitrix.annotation.values.Author;

/**
 * Created by Qualitrix on DD/MM/YYY.
 * @author Sandhya
 */

public class ExtentTestManager {

	private static ExtentTest extentTtest;
	public static ExtentReports extentReports;

	public static void InitReport(){
		extentReports = ExtentManager.getExtent();
	}

	public synchronized static ExtentTest createTest(String name, String description, String deviceId) {
		extentTtest = extentReports.createTest(name, description).assignCategory(deviceId);
		return extentTtest;
	}

	public synchronized static ExtentTest createTest(String name, String deviceId) {
		extentTtest = extentReports.createTest(name).assignCategory(deviceId);
		return extentTtest;
	}

	public synchronized static ExtentTest createTest(String name, String deviceId, Author author) {
		extentTtest = extentReports.createTest(name).assignCategory(deviceId).assignAuthor(author.name());
		return extentTtest;
	}
}

