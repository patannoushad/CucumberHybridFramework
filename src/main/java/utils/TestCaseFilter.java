package utils;

import java.io.File;
import java.util.List;
import java.util.Map;

public class TestCaseFilter {

    private static final List<Map<String, String>> testCases = ExcelReader.readExcel(System.getProperty("user.dir") +File.separator+"src" + File.separator + "main" + File.separator + "resources" +File.separator + "testData" + File.separator + "TestCases.xlsx");

    public static boolean shouldRunScenario(String scenarioName) {
        return testCases.stream()
                .anyMatch(tc -> tc.get("Test Description").equalsIgnoreCase(scenarioName)
                        && tc.get("RunByMode").equalsIgnoreCase("Automated"));
    }
}
