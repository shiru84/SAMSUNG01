//package utilities;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class common {
//    public static boolean elementExistValue = false;
//    public static boolean elementVisibleValue = false;
//    public static boolean isAccessoryAkgn700Free = false;
//    public static boolean isAccessoryEnabled = false;
//    public static boolean stockStatus = false;
//    public static boolean assertResultValue = false;
//    public static boolean tradeinwanted = false;
//    public static boolean supwanted = false;
//    public static boolean scpluswanted = false;
//    public static boolean accessoryExistingResult = false;
//    public static boolean sCPlusExistingResult = false;
//    public static boolean priceFitsInRange = false;
//    public static boolean variableConnectivity = false;
//    public static boolean studentOutOfStock = false;
//    public static boolean showStopperValue = false;
//    public static boolean chatOfferClosed = false;
//    public static Boolean result;
//    public static String accessoryInTheBasket;
//    public static String tradeInDeviceInTheBasket;
//    public static String priceBeforeCart;
//    public static String priceInCart;
//    public static String textOutput;
//    public static String imageURL;
//    public static String environment;
//    public static String valueName;
//    public static String url;
//    public static String img;
//    public static String buttonLocator;
//    public static String disabledLocator;
//    public static String homepage;
//    public static String target;
//    public static String variableLocation;
//    public static String accessoryPrice;
//    public static String skuNumber;
//    public static String skuNumberInBasket;
//    public static String productNameInBasket;
//    public static String deviceName;
//    public static WebElement element;
//    public static int n;
//    public static int j;
//    public static int t;
//    public static int w;
//    public static int conditionalWaitTime = 15;
//    public static int implicitlyWaitTime = 15;
//    public static int waitDuration = 15;
//    public static List<Values> list = new ArrayList<Values>();
//    private static WebDriver driver;
//    static Properties prop = new Properties();
//    static String PROPERTIES_FILE = "src\\main\\resources\\configs\\config.properties";
//
//    public static boolean checkIfElementExists(String locator) {
//
//        elementExistValue = driver.findElements(By.xpath(locator)).size() != 0;
//        return elementExistValue;
//    }
//
//    public static WebElement convertToElement(String locator) {
//        WebDriverWait wait = new WebDriverWait(driver, conditionalWaitTime);
//        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//        return element;
//    }
//
//    public static void sendKeys(String locator, String property) throws Throwable {
//
//        int attempts = 0;
//        while (attempts < 4) {
//            try {
//                element = convertToElement(locator);
//                element.sendKeys(property);
//                break;
//            } catch (NoSuchElementException e) {
//                Type("NoSuchElementException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (TimeoutException e) {
//                Type("TimeoutException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (StaleElementReferenceException e) {
//                Type("StaleElementReferenceException catched! Retrying to click on element: " + locator);
//                literallyWait();
//                attempts++;
//            }
//        }
//    }
//
//    public static void scrollToElement(String locator) throws Exception {
//        element = convertToElement(locator);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//    public static String getTextOfElement(String locator) throws Throwable {
//        int attempts = 0;
//        while (attempts < 4) {
//            try {
//
//                element = convertToElement(locator);
//                textOutput = element.getText();
//                break;
//            } catch (NoSuchElementException e) {
//                Type("NoSuchElementException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (TimeoutException e) {
//                Type("TimeoutException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (StaleElementReferenceException e) {
//                Type("StaleElementReferenceException catched! Retrying to click on element: " + locator);
//                literallyWait();
//                attempts++;
//            }
//        }
//        return textOutput;
//    }
//
//    public static String getAttributeOfElement(String locator, String attributeName) throws Throwable {
//        int attempts = 0;
//        while (attempts < 4) {
//            try {
//                element = convertToElement(locator);
//                textOutput = element.getAttribute(attributeName);
//                break;
//            } catch (NoSuchElementException e) {
//                Type("NoSuchElementException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (TimeoutException e) {
//                Type("TimeoutException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (StaleElementReferenceException e) {
//                Type("StaleElementReferenceException catched! Retrying to click on element: " + locator);
//                literallyWait();
//                attempts++;
//            }
//        }
//        return textOutput;
//    }
//
//    public static boolean clickOnElementIfClickable(String locator) throws Throwable {
//        elementExistValue = checkIfElementClickable(locator);
//        if (elementExistValue == true) {
//            clickOnElement(locator);
//        }
//
//        return elementExistValue;
//    }
//
//    public static void clickOnElement(String locator) throws Throwable {
//
//        Actions actions = new Actions(driver);
//        int attempts = 0;
//        while (attempts < 4) {
//            try {
//                WebDriverWait wait = new WebDriverWait(driver, conditionalWaitTime);
//                element = wait.until(ExpectedConditions.elementToBeClickable(convertToElement(locator)));
//                actions.moveToElement(element).perform();
//                actions.moveToElement(element).click().perform();
//                break;
//            } catch (NoSuchElementException e) {
//                Type("NoSuchElementException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (TimeoutException e) {
//                Type("TimeoutException catched while checking if element is clickable! Retrying on locating the element: "
//                        + locator);
//                literallyWait();
//                attempts++;
//            } catch (StaleElementReferenceException e) {
//                Type("StaleElementReferenceException catched! Retrying to click on element: " + locator);
//                literallyWait();
//                attempts++;
//            }
//        }
//    }
//
//    public static boolean checkIfElementClickable(String locator) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, conditionalWaitTime);
//            element = wait.until(ExpectedConditions.elementToBeClickable(convertToElement(locator)));
//            return elementExistValue = true;
//        } catch (Exception e) {
//            return elementExistValue = false;
//        }
//    }
//
//    public static void assertStarter(String a, String b) {
//        assertResult(assertValues(a, b));
//    }
//
//    public static boolean assertValues(String a, String b) {
//        if (a.equals(b)) {
//            assertResultValue = true;
//        } else {
//            assertResultValue = false;
//        }
//        return assertResultValue;
//    }
//
//    public static void assertResult(boolean assertResultValue) {
//        Assert.assertTrue("Assertion result is unsuccessful!", assertResultValue);
//    }
//
//    public static void Type(String value) {
//        System.out.println(value);
//    }
//
//    public static void literallyWait() throws InterruptedException {
//        if (environment.contains("live")) {
//            t = 5000;
//        }
//        if (environment.equals("test")) {
//            t = 5000;
//        }
//
//        if (environment.equals("test-ie")) {
//            t = 5000;
//        }
//        // Type("Waiting for " + t / 1000 + " seconds");
//        Thread.sleep(t);
//    }
//
//    public static void implicitlyWait(int implicitlyWaitTime) {
//        driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
//    }
//
//    public static String deleteCharacters(String string, int a, int b) {
//        StringBuilder str = new StringBuilder(string);
//        str.delete(a, b);
//        String returnvalue = str.toString();
//        return returnvalue;
//    }
//
//    public static void exportToTxt(List<Values> list) throws IOException {
//        FileWriter writer = new FileWriter("output/output.txt");
//        for (Values v : list) {
//            writer.write(v.filter + "|" + v.f_id + "|" + v.r_id + "|" + v.sku + "|" + v.deviceName + "ß");
//        }
//        writer.close();
//    }
//
//    public static LocalDate getTheDate() {
//        LocalDate today = LocalDate.now();
//        return today;
//    }
//
//    public static void createNewExcel(List<Values> list) throws IOException {
//        try {
//            LocalDate today = getTheDate();
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("PFP filtered products");
//            Type("Converting data to Excel format.");
//            Type("Creating new Excel file. Any existing files ('output " + today + ".xlsx') will be overwritten!");
//            createHeadersInExcel(sheet);
//            int rownum = 1;
//            for (Values v : list) {
//                Row row = sheet.createRow(rownum++);
//                convertListToExcel(v, row);
//                tidyTheExcel(sheet);
//            }
//            writeDataToExcel(workbook, today);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void insertToExcel(List<Values> list) throws IOException {
//        try {
//            LocalDate today = getTheDate();
//            File existingTest = new File("output/output " + today + ".xlsx");
//            if (!existingTest.exists()) {
//                createNewExcel(list);
//            } else {
//                FileInputStream inputStream = new FileInputStream(new File("output/output " + today + ".xlsx"));
//                XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//                XSSFSheet sheet = workbook.getSheet("PFP filtered products");
//                Type("Inserting new data to the file: 'output " + today + ".xlsx'");
//                int rownum = sheet.getLastRowNum() + 1;
//                for (Values v : list) {
//                    Row row = sheet.createRow(rownum++);
//                    convertListToExcel(v, row);
//                    tidyTheExcel(sheet);
//                }
//                writeDataToExcel(workbook, today);
//            }
//        } catch (FileNotFoundException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void writeDataToExcel(XSSFWorkbook workbook, LocalDate today)
//            throws IOException, InterruptedException {
//        FileOutputStream outputStream = new FileOutputStream(new File("output/output " + today + ".xlsx"));
//        workbook.write(outputStream);
//        outputStream.close();
//        workbook.close();
//        Type("Data saved to the file: 'output " + today + ".xlsx'");
//        literallyWait();
//    }
//
//    public static void convertListToExcel(Values v, Row row) {
//        Cell cell = row.createCell(0);
//        cell.setCellValue(v.filter);
//        cell = row.createCell(1);
//        cell.setCellValue(v.f_id);
//        cell = row.createCell(2);
//        cell.setCellValue(v.r_id);
//        cell = row.createCell(3);
//        cell.setCellValue(v.sku);
//        cell = row.createCell(4);
//        cell.setCellValue(v.deviceName);
//    }
//
//    public static void createHeadersInExcel(XSSFSheet sheet) {
//
//        Row header = sheet.createRow(0);
//        header.createCell(0).setCellValue("Filter");
//        header.createCell(1).setCellValue("Filter ID");
//        header.createCell(2).setCellValue("Product ID");
//        header.createCell(3).setCellValue("SKU Number");
//        header.createCell(4).setCellValue("Product Name");
//    }
//
//    public static void tidyTheExcel(XSSFSheet sheet) {
//        sheet.autoSizeColumn(0);
//        sheet.autoSizeColumn(1);
//        sheet.autoSizeColumn(2);
//        sheet.autoSizeColumn(3);
//        sheet.autoSizeColumn(4);
//        sheet.createFreezePane(0, 1);
//    }
//
//    public static String trimAString(String string, int a, int b) {
//        char ch1 = string.charAt(a);
//        char ch2 = string.charAt(b);
//        String s1 = Character.toString(ch1);
//        String s2 = Character.toString(ch2);
//        String returnvalue = s1 + s2;
//        return returnvalue;
//    }
//
//    public static String deleteACharacter(String string, int a) {
//        StringBuilder str = new StringBuilder(string);
//        str.deleteCharAt(a);
//        String returnvalue = str.toString();
//        return returnvalue;
//    }
//
//    public static String deleteTextFromStringBetweenCharacters(String string, String firstcharactertobeerased) {
//        if (string.contains(firstcharactertobeerased)) {
//            int startIndex = string.indexOf(firstcharactertobeerased);
//            int endIndex = string.length();
//            String stringToBeReplaced = string.substring(startIndex, endIndex);
//            string = string.replace(stringToBeReplaced, "");
//        }
//        return string;
//    }
//
//    public static String getValueFromConfig(String variableName) throws Throwable {
//        Properties prop = new Properties();
//        prop.load(new FileInputStream(PROPERTIES_FILE));
//        valueName = prop.getProperty(variableName);
//        return valueName;
//    }
//
//    public static boolean checkForShowStopper() throws Throwable {
//        if (environment.equals("test")) {
//            showStopperValue = true;
//        } else {
//            showStopperValue = false;
//        }
//        return showStopperValue;
//    }
//
//    public static void checkForTitleAndMeta() throws Throwable {
//        if (!environment.equals("live")) {
//            literallyWait();
//        }
//        Type("Checking page title, meta keywords and meta description in " + homepage);
//        textOutput = driver.getTitle();
//        Type("Page title: " + textOutput);
//        textOutput = common.getAttributeOfElement("//meta[@name='keywords']", "content");
//        Type("Meta keywords: " + textOutput);
//        textOutput = common.getAttributeOfElement("//meta[@name='description']", "content");
//        Type("Meta description: " + textOutput);
//    }
//
//    public static void filterListReport(int variable) throws Throwable {
//        Type("Checking the products listed in " + homepage);
//        if (!environment.equals("live")) {
//            literallyWait();
//        }
//        int filterValueCount = driver.findElements(By.xpath(getValueFromConfig("location_pfp_filters")+"//label/span")).size();
//        Type("Total number of filters: " + filterValueCount);
//        List<WebElement> xpathFilterValues = driver.findElements(By.xpath(getValueFromConfig("location_pfp_filters")+"//label/span"));
//        List<WebElement> xpathFilterCodes = driver
//                .findElements(By.xpath(getValueFromConfig("location_pfp_filters") + "//input"));
//
//        for (int y = 0; y < filterValueCount; y++) {
//            if (999>variable) {
//                y = variable - 1;
//                filterValueCount = variable - 1;
//            }
//            WebElement namePerFilterElement = xpathFilterValues.get(y);
//            WebElement codePerFilterElement = xpathFilterCodes.get(y);
//
//            String filter = namePerFilterElement.getText();
//            String filterCode = codePerFilterElement.getAttribute("id");
//            Type("Working on the filter: #" + (y + 1) + "'" + filter + "'");
//            elementExistValue = selectFilter(filter, 1, filterCode);
//            if (elementExistValue == false) {
//                ListAllProducts();
//                callValueInsertion(filter, y);
//                insertToExcel(list);
//                Type("Clearing the data in RAM.");
//                list.clear();
//                selectFilter(filter, 0, filterCode);
//            }
//            if (elementExistValue == true) {
//                insertValues(filter, y, "#N/A",3);
//                insertToExcel(list);
//                Type("Clearing the data in RAM.");
//                list.clear();
//            }
//        }
//
//    }
//
//
//    public static boolean selectFilter(String filter, int key, String filterCode) throws Throwable {
//
//        String location_pfp_draft = getValueFromConfig("location_pfp_filters");
//        String location_pfp_filter = location_pfp_draft + "//input[@id='" + filterCode + "']/parent::div";
//        String location_pfp_filter_disabled_property = location_pfp_draft + "//input[@id='" + filterCode
//                + "'][@disabled='disabled']";
//        literallyWait();
//        elementExistValue = checkIfElementExists(location_pfp_filter_disabled_property);
//        if (elementExistValue == true) {
//            Type("Filter is not interactable! Skipping the test.");
//        } else {
//            common.clickOnElement(location_pfp_filter);
//            if (key == 1) {
//                Type("'" + filter + "' filter is selected");
//            }
//            if (key == 0) {
//                Type("'" + filter + "' filter selection is cleared");
//            }
//        }
//        return elementExistValue;
//    }
//
//    public static List<Values> callValueInsertion(String filter, int y) throws Throwable {
//
//        insertValues(filter, y, "location_pfp_product", 1);
//        insertValues(filter, y, "location_pfp_product_othersize", 2);
//        return list;
//    }
//
//    public static void insertValues(String filter, int y, String variableLocation, int key) throws Throwable {
//        if (key == 3) {
//            list.add(new Values(filter, y + 1, 0, "#N/A","#N/A"));
//            Type("Filter data successfully added to the list");
//        }
//        else {
//            int valueCount = driver.findElements(By.xpath(getValueFromConfig(variableLocation))).size();
//            List<WebElement> xpathValues = driver.findElements(By.xpath(getValueFromConfig(variableLocation)));
//            if (key == 1) {
//                Type("Total number of products listed with '" + filter + "' filter: " + (valueCount));
//            }
//            if (key == 2) {
//                Type("Total number of products listed as the secondary size option with '" + filter + "' filter: "
//                        + (valueCount));
//            }
//            for (int x = 0; x < valueCount; x++) {
//
//                WebElement valuePerElement = xpathValues.get(x);
//                String sku = valuePerElement.getAttribute("data-modelcode");
//                if (key == 1) {
//                    deviceName = valuePerElement.getText();
//                }
//                if (key == 2) {
//                    deviceName = "unknown";
//                    w = j + x + 1;
//                } else {
//                    w = x + 1;
//                }
//                list.add(new Values(filter, y + 1, w, sku, deviceName));
//                Type("Product data #" + w + " successfully added to the list");
//
//                if (key == 1 && (x == valueCount - 1)) {
//                    j = valueCount;
//                }
//            }
//
//        }}
//
//    public static void printValues(List<Values> list) {
//
//        for (Values v : list) {
//            System.out.println(v.filter + "|" + v.f_id + "|" + v.r_id + "|" + v.sku + "|" + v.deviceName + "ß");
//        }
//    }
//
//    public static boolean checkForMissingImageAltTags() throws Throwable {
//        if (!environment.equals("live")) {
//            literallyWait();
//        }
//        int imagesCount = driver.findElements(By.xpath("//img")).size();
//        Type("Checking images in " + homepage);
//        Type("Total number of images: " + imagesCount);
//        List<WebElement> images = driver.findElements(By.xpath("//img"));
//        ArrayList<String> mylist = new ArrayList<String>();
//        for (int x = 0; x < imagesCount; x++) {
//            WebElement image = images.get(x);
//            textOutput = image.getAttribute("alt");
//
//            if (((textOutput.equals("") || textOutput == null)) & !image.getAttribute("style").contains("hidden")) {
//                imageURL = deleteTextFromStringBetweenCharacters(image.getAttribute("src"), "?");
//                if (!imageURL.startsWith("data:image/") && !imageURL.contains("GetVisitorId")
//                        && !imageURL.contains("theme.zdassets.com/theme_assets") && !imageURL.isEmpty()) {
//                    mylist.add(imageURL);
//                }
//            }
//        }
//        List<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(mylist));
//        if (listWithoutDuplicates.size() == 0) {
//            Type("No missing image alt tags found!");
//            elementExistValue = true;
//        } else {
//            if (((listWithoutDuplicates.size() > 0)) && (listWithoutDuplicates.size() < 6)) {
//                Type("Number of images without alt tag: " + Integer.toString(listWithoutDuplicates.size()));
//                Type("Test status: Validated");
//                for (String element : listWithoutDuplicates) {
//                    Type(element);
//                }
//                elementExistValue = true;
//            } else {
//                Type("Number of images without alt tag: " + Integer.toString(listWithoutDuplicates.size()));
//                for (String element : listWithoutDuplicates) {
//                    Type(element);
//                }
//                elementExistValue = false;
//            }
//        }
//
//        return elementExistValue;
//
//    }
//
//    public static boolean checkForBrokenLinks() throws Throwable {
//        if (!environment.equals("live")) {
//            literallyWait();
//        }
//        List<String> excludeList;
//        List<String> list301;
//        ArrayList<String> mylist = new ArrayList<String>();
//        HttpURLConnection huc = null;
//        int respCode;
//        Type("Checking broken links in " + homepage);
//
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//
//        Iterator<WebElement> it = links.iterator();
//        while (it.hasNext()) {
//
//            url = it.next().getAttribute("href");
//
//            if (url == null || url.isEmpty()) {
//                continue;
//            }
//            excludeList = new ArrayList<String>();
//            excludeList.add("https://account.samsung.com/accounts/v1/Samsung_com_UK/signInGate");
//            excludeList.add("https://mcybersvc1.samsungcsportal.com:83/gb/history/search_history?ssoLogin=N%20");
//            excludeList.add("https://www.linkedin.com/company/samsung-electronics");
//            excludeList.add("http://eu.community.samsung.com/?category.id=uk");
//            excludeList.add("twitter.com");
//            excludeList.add("http://www.facebook.com");
//            excludeList.add("http://www.pinterest.com");
//            excludeList.add("javascript:void(0)");
//            excludeList.add("javascript:;");
//
//            list301 = new ArrayList<String>();
//            list301.add(
//                    "http://images.samsung.com/is/content/samsung/p5/common/energylabel/common-energylabel-rs68n8230b1-eu-energylabel.pdf");
//            list301.add(
//                    "http://images.samsung.com/is/content/samsung/p5/common/energylabel/common-energylabel-rs68n8230b1-eu-productfiche.pdf");
//            list301.add(
//                    "http://images.samsung.com/is/content/samsung/p5/common/energylabel/common-energylabel-rb38r7837s9-eu-energylabel.pdf");
//            list301.add(
//                    "http://images.samsung.com/is/content/samsung/p5/common/energylabel/common-energylabel-rb38r7837s9-eu-productfiche.pdf");
//            list301.add("https://www.samsung.com/uk/offer/online/mysamsung-offers-NCPU2CWZUEA8F/");
//            list301.add("https://www.linkedin.com/company/samsung-business-uk");
//            list301.add("http://displaysolutions.samsung.com/");
//
//            result = common.stringContainsItemFromList(url, excludeList);
//
//            if ((excludeList.contains(url) || result == true)
//                    || (url.contains("mailto:") && url.contains("@") && url.contains("."))) {
//                continue;
//            }
//
//            try {
////				Type(url);
//                huc = (HttpURLConnection) (new URL(url).openConnection());
//
//                huc.setRequestMethod("GET");
//
//                huc.connect();
//
//                respCode = huc.getResponseCode();
////Type ("returned the resp code as "+respCode);
//                if (respCode != 200) {
//                    if (!((respCode == 301 || respCode == 999) && list301.contains(url))) {
//                        mylist.add(url + " is a broken link. Error code : " + respCode);
//                    }
//                }
//
//            } catch (MalformedURLException e) {
//                Type(url);
//                e.printStackTrace(System.out);
//            } catch (IOException e) {
//                Type(url);
//                e.printStackTrace(System.out);
//            }
//        }
//        Type("Broken link list:");
//        List<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(mylist));
//        if (listWithoutDuplicates.size() == 0) {
//            Type("No broken links found!");
//            elementExistValue = true;
//        } else {
//            for (String element : listWithoutDuplicates) {
//                Type(element);
//            }
//            elementExistValue = false;
//        }
//        Type("Total number of links checked: " + links.size());
//        return elementExistValue;
//    }
//
//    public static Boolean stringContainsItemFromList(String inputStr, List<String> items) {
//        result = items.stream().anyMatch(inputStr::contains);
//        return result;
//    }
//
//    public static void checkFooterNote(String pageType) throws Throwable {
//
//        String targetFooterNoteText = getValueFromConfig("targetFooterNote" + pageType);
//        String currentFooterNoteText = getTextOfElement("//p[@class='tradein-paragraph']");
//        String targetTradeinTCLink = getValueFromConfig("targetTradeinTC" + pageType);
//        String currentFooterNoteLink = getAttributeOfElement(
//                "//p[@class='tradein-paragraph']//a[contains(text(),'T&Cs')]", "href");
//        if (!currentFooterNoteText.equals(targetFooterNoteText)) {
//            Type("Footer note doesn't match. Current footer note is: " + currentFooterNoteText);
//            assertStarter(targetFooterNoteText, currentFooterNoteText);
//        }
//        if (!targetTradeinTCLink.equals(currentFooterNoteLink)) {
//            Type("Footer note link doesn't match. Current footer note link is: " + currentFooterNoteLink);
//            assertStarter(targetTradeinTCLink, currentFooterNoteLink);
//        }
//    }
//
//    public static void Starter(String productname) throws Throwable {
//        driverLoader.setDriver();
//        driver = driverLoader.driver;
//        implicitlyWait(implicitlyWaitTime);
//        environmentLogin(productname);
//        abTestElementCheck(productname);
//        // collapseBanner();
//
//    }
//
//    public static String[] convertToDoubleStrings(String string1, String string2) {
//
//        String[] stringSet = new String[2];
//        stringSet[0] = string1;
//        stringSet[1] = string2;
//
//        return stringSet;
//
//    }
//
//    public static void studentStarter() throws Throwable {
//        driverLoader.setDriver();
//        driver = driverLoader.driver;
//        implicitlyWait(implicitlyWaitTime);
//
//    }
//
//    public static void navigateToStudentPage(String productname) throws Throwable {
//        studentLogin(productname);
//        abTestElementCheck(productname);
//        // collapseBanner();
//
//    }
//
//    public static boolean navigateToCategory(String category) throws Throwable {
//        common.literallyWait();
//        elementExistValue = checkIfElementExists("//strong[text()='" + category
//                + "']/parent::div/parent::div/parent::div/parent::div/parent::div//a[@data-layer-target='#shop-layer-getstock']");
//        if (elementExistValue == true) {
//            studentOutOfStock = true;
//            Type("Product is out of the stock! Skipping next test scenarios.");
//        } else {
//            studentOutOfStock = false;
//            clickOnElement("//strong[text()='" + category
//                    + "']/parent::div/parent::div/parent::div/parent::div/parent::div//a[@data-cta-type='buynow']");
//            Type("Navigating to product buy page.");
//        }
//        return studentOutOfStock;
//    }
//
//    public static String noteThePriceInTheBasket() throws Throwable {
//        elementExistValue = common.checkIfElementExists("//div[@class='product-price']/div");
//        if (elementExistValue == true) {
//            priceBeforeCart = getTextOfElement("//div[@class='product-price']/div");
//        } else {
//
//            elementExistValue = common.checkIfElementExists("//button[@class='s-btn-encased price-bar-cart-btn']");
//            if (elementExistValue == true) {
//
//                elementExistValue = common.checkIfElementExists("//span[contains(text(),'Item Added')]");
//                if (elementExistValue == true) {
//                    priceBeforeCart = String.valueOf(convertMoneyStringToNumber(getTextOfElement(
//                            "//span[contains(text(),'Item Added')]/parent::a/parent::div/parent::div/div[3]"))
//                            + convertMoneyStringToNumber(getTextOfElement(
//                            "//div[@class='hubble-product__total']//p[@class='hubble-product__total-text']/strong[2]")));
//                } else {
//                    priceBeforeCart = getTextOfElement(
//                            "//div[@class='hubble-product__total']//p[@class='hubble-product__total-text']/strong[2]");
//
//                }
//            } else {
//
//                priceBeforeCart = getTextOfElement("//strong[@class='pd-anchor-total']");
//            }
//        }
//        return priceBeforeCart;
//    }
//
//    public static void abTestElementCheck(String productname) throws Throwable {
//        String abTestStatus = getValueFromConfig("a_b_test_element_check");
//        if (abTestStatus.equals("true") || productname.contains("HMCT")) {
//            Type("A-B Test mode is on.");
//            String starterElement = getValueFromConfig("starterElement_" + productname);
//            elementExistValue = clickOnElementIfClickable(starterElement);
//            if (elementExistValue == true) {
//                Type("Starter element for " + productname + " is found! Continuing the test.");
//            } else {
//                abTestElementCheck2(productname, starterElement);
//            }
//        } else {
//            Type("A-B Test mode is off.");
//        }
//    }
//
//    public static void abTestElementCheck2(String productname, String starterElement) throws Throwable {
//        driver.navigate().refresh();
//        elementExistValue = clickOnElementIfClickable(starterElement);
//        if (elementExistValue == true) {
//            Type("Starter element for " + productname + " is found! Continuing the test.");
//        } else {
//            Type("Starter element for " + productname + " is not found! Restarting the test.");
//            driver.close();
//            Starter(productname);
//        }
//    }
//
//    public static void environmentLogin(String productname) throws Throwable {
//
//        if (productname.contains("www") && productname.contains("students")) {
//
//            environment = "livestudent";
//            homepage = productname;
//
//        } else {
//
//            if (productname.contains("www") && productname.contains("networks")) {
//
//                environment = "liveemployee";
//                homepage = productname;
//
//            } else {
//
//                if (productname.contains("www") || productname.contains("file")) {
//                    environment = "live";
//                    homepage = productname;
//                } else {
//                    if (productname.contains("p6-qa")) {
//                        environment = "test";
//                        homepage = productname;
//                    } else {
//                        if (productname.contains("qaweb.")) {
//                            environment = "test-ie";
//                            homepage = productname;
//                        } else {
//                            environment = getValueFromConfig("environment");
//                            if (environment.equals("live")) {
//                                homepage = "https://www.samsung.com/uk" + getValueFromConfig("website_" + productname);
//                            }
//                            if (environment.equals("test")) {
//                                homepage = "https://p6-qa.samsung.com/uk/"
//                                        + getValueFromConfig("website_" + productname);
//                            }
//                            if (environment.equals("test-ie")) {
//                                homepage = "https://qaweb.samsung.com/ie"
//                                        + getValueFromConfig("website_" + productname);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        Type("Test is running in " + environment + " environment!");
//
//        if (environment.contains("live")) {
//            driver.get(homepage);
//            driverLoader.insertCookie(environment);
//            driver.get(homepage);
//            if (environment.equals("livestudent") || environment.equals("liveemployee")) {
//                studentUserLoginIfNecessary();
//            }
//            literallyWait();
//        } else {
//
//            if (environment.equals("test")) {
//                driver.get("https://p6-qa.samsung.com/uk/");
//                testlogin(environment);
//                literallyWait();
//            }
//            if (environment.equals("test-ie")) {
//                driver.get("https://qaweb.samsung.com/ie");
//                testlogin(environment);
//                literallyWait();
//            }
//            driverLoader.insertCookie(environment);
//            driver.get(homepage);
//            if (environment.equals("test")) {
//                elementExistValue = common
//                        .clickOnElementIfClickable("//button[@an-ac='error popup:close'][contains(text(),'Close')]");
//                if (elementExistValue == false) {
//                    Type("Error popup window not located");
//                } else {
//                    Type("Error popup window located and closed");
//                }
//
//            }
//        }
//    }
//
//    public static void testlogin(String environment) throws Throwable {
//        sendKeys("//input[@id='username']", getValueFromConfig("user" + environment));
//        sendKeys("//input[@id='password']", getValueFromConfig("password" + environment));
//        clickOnElement("//button[@id='submit-button']");
//        Type("Test environment login is complete.");
//    }
//
//    public static void studentLogin(String productname) throws Throwable {
//        driver.get(getValueFromConfig("home_live") + getValueFromConfig("website_student"));
//        environment = getValueFromConfig("environment");
//        driverLoader.insertCookie(environment);
//        Type("Test is running in " + environment + " environment!");
//        studentUserLoginIfNecessary();
//        if (environment.equals("live")) {
//            driver.get(getValueFromConfig("home_live") + getValueFromConfig("website_student"));
//        }
//        if (environment.equals("test")) {
//            driver.get(getValueFromConfig("home_test") + getValueFromConfig("website_student"));
//            testlogin(environment);
//        }
//        studentUserLoginIfNecessary();
//        if (productname.equals("s10")) {
//            Type("Navigating to Galaxy S product range students page");
//            literallyWait();
//            common.clickOnElement("//a[@class='s-btn-toggler js-toggler js-depth1-link'][contains(text(),'MOBILE')]");
//            common.clickOnElement(
//                    "//div[@class='s-depth3-wrap']//a[@class='s-depth3-link'][contains(text(),'Smartphones')]");
//            literallyWait();
//            common.clickOnElement("//span[@class='filter-sort__arrow']");
//            common.clickOnElement("//p[contains(text(),'Galaxy S')]");
//            common.clickOnElement(
//                    "//div[@class='filter-sort__results-button']//button[@class='s-btn-encased s-btn-result'][contains(text(),'View Result')]");
//
//        }
//        if (!productname.equals("s10")) {
//            common.clickOnElement("//a[@class='s-btn-toggler js-toggler js-depth1-link'][(text()='"
//                    + getValueFromConfig("menucategory_" + productname) + "')]");
//            common.clickOnElement("//div[@class='s-depth3-wrap']//a[@class='s-depth3-link'][(text()='"
//                    + getValueFromConfig("iteminmenu_" + productname) + "')]");
//
//        }
//
//    }
//
//    public static void studentUserLoginIfNecessary() throws Throwable {
//
//        String loginButton = "//span[contains(text(),'LOGIN')]";
//        elementExistValue = common.checkIfElementExists(loginButton);
//        if (elementExistValue == true) {
//            clickOnElement(loginButton);
//            literallyWait();
//            sendKeys("//input[@id='iptLgnPlnID']", getValueFromConfig("studentuser"));
//            sendKeys("//input[@id='iptLgnPlnPD']", getValueFromConfig("studentpassword"));
//            clickOnElement(
//                    "//body/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/div[6]/div[1]/button[2]");
//            common.clickOnElementIfClickable("//button[@id='btnNotNow']");
//        }
//    }
//
//    public static void collapseBanner() throws Throwable {
//        elementExistValue = common.clickOnElementIfClickable("//button[@class='s-offer-close']");
//        if (elementExistValue == false) {
//            elementExistValue = common.clickOnElementIfClickable("//button[@class='arrow-cta openarrow']");
//        }
//        if (elementExistValue == true) {
//            Type("Top banner is minimized.");
//            common.literallyWait();
//        } else {
//            Type("No banner found.");
//        }
//    }
//
//    public static void ListAllProducts() throws Throwable {
//        String viewMore = "//a[@class='cta cta--outlined cta--black cta--icon js-pf-view-more-cta'][contains(text(),'View more')]";
//        literallyWait();
//        elementExistValue = common.clickOnElementIfClickable(viewMore);
//        if (elementExistValue == false) {
//            common.literallyWait();
//            Type("View More not found. Collecting product information.");
//        } else {
//            Type("View More found. Expanding the product list.");
//            ListAllProducts();
//        }
//
//    }
//
//    public static boolean checkStockAvailability() throws Throwable {
//
//        assertResultValue = false;
//        if (common.checkIfElementExists("//a[@class='product-details-anchor-navi__cta js-cta-buy']") == true) {
//            assertResultValue = true;
//            Type("Buy CTA code : 01");
//            String buyCtaText = getTextOfElement("//a[@class='product-details-anchor-navi__cta js-cta-buy']");
//            if (buyCtaText.equals("ADD TO CART")) {
//                stockStatus = true;
//                Type("Product is in the stock!");
//            } else {
//                stockStatus = false;
//                Type("Product is out of the stock! Skipping next test scenarios.");
//            }
//        } else {
//
//            if (common.checkIfElementExists("//a[@class='s-btn-encased s-blue js-buy-now blue']") == true) {
//                assertResultValue = true;
//                Type("Buy CTA code : 02");
//                String buyCtaText = getTextOfElement("//a[@class='s-btn-encased s-blue js-buy-now blue']");
//                if (buyCtaText.equals("ADD TO CART")) {
//                    stockStatus = true;
//                    Type("Product is in the stock!");
//                } else {
//                    stockStatus = false;
//                    Type("Product is out of the stock! Skipping next test scenarios.");
//                }
//            } else {
//
//                if (common.checkIfElementExists("//a[@class='product-details-anchor-navi__cta js-buy-now']") == true) {
//                    assertResultValue = true;
//                    Type("Buy CTA code : 03");
//                    String buyCtaText = getTextOfElement("//a[@class='product-details-anchor-navi__cta js-buy-now']");
//                    if (buyCtaText.equals("ADD TO CART")) {
//                        stockStatus = true;
//                        Type("Product is in the stock!");
//                    } else {
//                        stockStatus = false;
//                        Type("Product is out of the stock! Skipping next test scenarios.");
//                    }
//
//                } else {
//
//                    if (common.checkIfElementExists(
//                            "//a[@class='product-details-anchor-navi__cta js-cta-stock cm-s-popup-opener is-check-confirm']") == true) {
//                        assertResultValue = true;
//                        Type("Buy CTA code : 04");
//                        String buyCtaText = getTextOfElement(
//                                "//a[@class='product-details-anchor-navi__cta js-cta-stock cm-s-popup-opener is-check-confirm']");
//                        if (buyCtaText.equals("ADD TO CART")) {
//
//                            stockStatus = true;
//                            Type("Product is in the stock!");
//                        } else {
//                            stockStatus = false;
//                            Type("Product is out of the stock! Skipping next test scenarios.");
//                        }
//                    } else {
//
//                        if (common.checkIfElementExists(
//                                "//button[@class='s-btn-encased price-bar-cart-btn']//span[@class='s-cta-text']") == true) {
//                            assertResultValue = true;
//                            Type("Buy CTA code : 05");
//                            String buyCtaText = getTextOfElement(
//                                    "//button[@class='s-btn-encased price-bar-cart-btn']//span[@class='s-cta-text']");
//                            if (buyCtaText.equals("Pre Order") || buyCtaText.equals("ADD TO CART")) {
//
//                                stockStatus = true;
//                                Type("Product is in the stock!");
//                            } else {
//                                stockStatus = false;
//                                Type("Product is out of the stock! Skipping next test scenarios.");
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        common.assertResult(assertResultValue);
//        return stockStatus;
//    }
//
//    public static void checkThePriceRange(String product, String pageType) throws Throwable {
//        float priceBeforeCart = Float
//                .valueOf(common.noteThePriceInTheBasket().replaceAll("\\£", "").replaceAll("\\,", ""));
//        float minimumPrice = 99999;
//        float maximumPrice = 0;
//        minimumPrice = Float.valueOf(getValueFromConfig("minimumPrice_" + product));
//        maximumPrice = Float.valueOf(getValueFromConfig("maximumPrice_" + product));
//        if (pageType == "student") {
//            Type(pageType + " discount is found!");
//            float studentRate = (float) (9 / 10.0);
//            minimumPrice = minimumPrice * studentRate;
//            maximumPrice = maximumPrice * studentRate;
//        }
//        if (priceBeforeCart >= minimumPrice && priceBeforeCart <= maximumPrice) {
//            priceFitsInRange = true;
//        } else {
//            priceFitsInRange = false;
//        }
//        Type("Price for " + product + " is: £" + priceBeforeCart + ". Asserting if it is between £" + minimumPrice
//                + " and £" + maximumPrice);
//        assertResult(priceFitsInRange);
//    }
//
//    public static void clickOnFeature(String variable) throws Throwable {
//        boolean variableBoolean = !variable.equals("");
//        if (variableBoolean == true) {
//            literallyWait();
//            elementExistValue = clickOnElementIfClickable(
//                    "//span[@class='s-item'][contains(text(),'" + variable + "')]");
//            if (elementExistValue == false) {
//                clickOnElementIfClickable("//span[@class='s-rdo-text'][contains(text(),'" + variable + "')]");
//            }
//            Type(variable + " selected from the configurator.");
//        }
//    }
//
//    public static void clickOnColour(String variable) throws Throwable {
//        boolean variableBoolean = !variable.equals("");
//        if (variableBoolean == true) {
//            common.literallyWait();
//            variableLocation = "//span[@class='s-color-name'][contains(text(),'" + variable + "')]";
//            common.clickOnElement(variableLocation);
//            common.Type(variable + " selected from the configurator.");
//        }
//    }
//
//    public static void scrollNeeded() throws Throwable {
//        common.scrollToElement(variableLocation);
//
//    }
//
//    public static void clickOnDevice(String variable) throws Throwable {
//        boolean variableBoolean = !variable.equals("");
//        if (variableBoolean == true) {
//            literallyWait();
//            elementExistValue = clickOnElementIfClickable("//span[@class='s-item'][(text()='" + variable + "')]");
//            if (elementExistValue == false) {
//                clickOnElementIfClickable("//span[@class='s-rdo-text'][text()='" + variable + "']");
//            }
//            Type(variable + " selected from the configurator.");
//        }
//    }
//
//    public static void clickOnSUP() throws Throwable {
//        common.clickOnElement("//label[@class='s-checkbox-label']//span[@class='s-box']");
//    }
//
//    public static void clickOnSCP() throws Throwable {
//        elementExistValue = checkIfElementExists(
//                "//li[@class='hubble-product__options-list care_option_list js-care-layer hubble-pd-popup-opener is-async js-care-pop']//span[@class='s-label-inner']");
//        if (elementExistValue == true) {
//            S20.clickOnSCP();
//        } else {
//            chatOfferCheck();
//            common.clickOnElement(
//                    "//div[@class='product-details-simple__addon-item s-item-care']//div[@class='s-text-link-area']/a[1]");
//            common.clickOnElement("//span[@class='shop-care-layer__option-sbox-wrap']//span[@class='s-box']");
//            String checkBoxLocation = "//div[@class='shop-care-layer__check-content has-required-type']//span[@class='s-box']";
//            elementExistValue = common.checkIfElementExists(checkBoxLocation);
//            if (elementExistValue == true) {
//                common.scrollToElement(checkBoxLocation);
//                common.clickOnElement(checkBoxLocation);
//            } else {
//                common.scrollToElement("//div[@id='shop-care-layer']//button[@class='s-btn-encased s-blue']");
//            }
//
//            common.clickOnElement("//div[@id='shop-care-layer']//button[@class='s-btn-encased s-blue']");
//        }
//        Type("Samsung Care Plus added to the cart.");
//
//    }
//
//    public static void chatOfferCheck() throws Throwable {
//        if (chatOfferClosed == false) {
//            chatOfferClosed = common.checkIfElementClickable("//div[@class='options opt-2']");
//            if (chatOfferClosed == true) {
//                clickOnElement("//div[@class='options opt-2']");
//            }
//        }
//    }
//
//    public static String[] addAnotherDeviceFromFBT() throws Throwable {
//
//        accessoryInTheBasket = common.getTextOfElement(
//                "//span[@class='checkout_prc_summary']/parent::div/div[2]/div[3]//div[@class='selected_product_title']");
//        accessoryPrice = common.getTextOfElement(
//                "//span[@class='checkout_prc_summary']/parent::div/div[2]/div[3]//span[@class='selected_product_prc']");
//        common.clickOnElement("//span[@class='inc_add_to_basket_btn_text']");
//        literallyWait();
//        common.clickOnElement("//a[@class='inc_add_to_basket_btn your_basket']");
//        String[] stringSet = convertToDoubleStrings(accessoryInTheBasket, accessoryPrice);
//        Type("Accessory price is " + accessoryPrice);
//        Type(accessoryInTheBasket + " added to the cart as accessory.");
//        return stringSet;
//
//    }
//
//    public static String clickOnAccessory() throws Throwable {
//        elementExistValue = clickOnElementIfClickable(
//                "//h3[contains(text(),'Accessories')]/parent::div/parent::div//a[@data-layer-target='#shop-combo-addon-layer'][text()='Add to basket']");
//        if (elementExistValue == true) {
//            int n = 0;
//            do {
//                n++;
//                buttonLocator = "//li[" + n
//                        + "]//div[1]//div[1]//div[1]//strong[1][not(contains(text(),'AKG N700'))]/parent::div/parent::div/parent::div//span[text()='ADD ITEM']";
//                isAccessoryAkgn700Free = common.checkIfElementExists(buttonLocator);
//                if (isAccessoryAkgn700Free == true) {
//                    disabledLocator = "//li[" + n + "][@class='is-disabled']";
//                    isAccessoryEnabled = !common.checkIfElementExists(disabledLocator);
//                }
//            } while (isAccessoryAkgn700Free == false
//                    || (isAccessoryAkgn700Free == true && isAccessoryEnabled == false));
//
//            accessoryInTheBasket = common.getTextOfElement("//li[" + n + "]//div[1]//div[1]//div[1]//strong[1]");
//            chatOfferCheck();
//            common.clickOnElement("//li[" + n + "]//div[2]//button[1]//span[1]");
//            common.clickOnElement(
//                    "//div[@id='shop-combo-addon-layer']//span[@class='cta-btn__txt'][contains(text(),'CONFIRM')]");
//        } else {
//            elementExistValue = common
//                    .checkIfElementExists("//h3[@class='s-sub-title'][contains(text(),'Accessories')]");
//            if (elementExistValue == true) {
//                common.scrollToElement("//h3[@class='s-sub-title'][contains(text(),'Accessories')]");
//                int n = 0;
//                do {
//                    n++;
//                    buttonLocator = "//div[2]/ul[1]/li[" + n
//                            + "]/div[2]/strong[1][not(contains(text(),'AKG N700'))]/parent::div/parent::li/div[3]//button[1]//span[1]";
//                    isAccessoryAkgn700Free = common.checkIfElementExists(buttonLocator);
//                    if (isAccessoryAkgn700Free == true) {
//                        disabledLocator = "//li[" + n + "][@class='is-disabled']//span[contains(text(),'Coming soon')]";
//                        isAccessoryEnabled = !common.checkIfElementExists(disabledLocator);
//                    }
//                } while (isAccessoryAkgn700Free == false
//                        || (isAccessoryAkgn700Free == true && isAccessoryEnabled == false));
//                chatOfferCheck();
//                accessoryInTheBasket = common.getTextOfElement("//div[2]/ul[1]/li[" + n + "]/div[2]/strong[1]");
//                common.clickOnElement("//li[" + n + "]//div[3]//button[1]//span[1]");
//
//            } else {
//
//                elementExistValue = common.checkIfElementExists(
//                        "//span[@class='title_text'][contains(text(),'Frequently bought together')]");
//                if (elementExistValue == true) {
//                    accessoryInTheBasket = common.getTextOfElement(
//                            "//body[@class='cookie-warning']/div[@id='wrap']/div[@id='content']/div[@class='par parsys']/div[@class='sh-g-shopintg-product-detail section']/div[@id='increasingly_element']/div[@id='ic_bundle_pdp']/div[@id='ic_bundle_wrapper']/div[@class='ic_tab_prod_wrap']/div[@class='ic_product_wrapper']/div[@class='ic_product_parent_bundle']/div[@class='inc_product_checkout']/div[@class='ic_prod_checkout_float']/div[@class='prod_addon_wrapper']/div[3]/div[2]/div/div[1]");
//                    accessoryPrice = common.getTextOfElement(
//                            "//body[@class='cookie-warning']/div[@id='wrap']/div[@id='content']/div[@class='par parsys']/div[@class='sh-g-shopintg-product-detail section']/div/div[@id='finance-module']/div[@id='increasingly_element']/div[@id='ic_bundle_pdp']/div[@id='ic_bundle_wrapper']/div[@class='ic_tab_prod_wrap']/div[@class='ic_product_wrapper']/div[@class='ic_product_parent_bundle']/div[@class='inc_product_checkout']/div[@class='ic_prod_checkout_float']/div[@class='prod_addon_wrapper']/div[3]/div[2]/div[2]/span");
//                    Type("Accessory price is " + accessoryPrice);
//                    common.clickOnElement("//span[@class='inc_add_to_basket_btn_text']");
//                    common.clickOnElement("//a[@class='inc_add_to_basket_btn your_basket']");
//                } else {
//                    Type("Couldn't find an accessory to add to the basket!");
//                    assertResultValue = false;
//                    common.assertResult(assertResultValue);
//
//                }
//            }
//
//        }
//        Type(accessoryInTheBasket + " added to the cart as accessory.");
//        return accessoryInTheBasket;
//
//    }
//
//    public static String runTradeIn(String imeinumber) throws Throwable {
//        elementExistValue = common
//                .checkIfElementExists("//div[@class='s-box-option js-radio-wrap']//span[@class='js-s-option-text']");
//        if (elementExistValue == true) {
//            common.clickOnElement("//div[@class='s-box-option js-radio-wrap']//span[@class='js-s-option-text']");
//        } else {
//            elementExistValue = common.checkIfElementExists(
//                    "//a[@class='s-btn-text s-blue js-tradein-popup cm-s-popup-opener is-async js-tradein-btn js-added']");
//            if (elementExistValue == true) {
//                common.clickOnElement(
//                        "//a[@class='s-btn-text s-blue js-tradein-popup cm-s-popup-opener is-async js-tradein-btn js-added']");
//                common.clickOnElement("//li[1]/div[1]/label[1]/span[1]/span[1][@class='s-ly-tradein__brand-name']");
//                common.clickOnElement(
//                        "//div[@class='cm-s-layer__layer__box s-ly-step-brand']//button[@class='s-btn-encased s-blue']");
//                common.clickOnElement("//ul//li[1]//div[@class='shop-radio js-radio-wrap']//span[@class='s-box']");
//                tradeInDeviceInTheBasket = common.getTextOfElement("//ul/li[1]//span[2]//strong[1]");
//                common.clickOnElement(
//                        "//div[@class='cm-s-layer__layer__box s-ly-step-model']//button[@class='s-btn-encased s-blue']");
//                if (imeinumber != null) {
//                    common.clickOnElement("//input[@id='trade-imei']");
//                    common.sendKeys("//input[@id='trade-imei']", imeinumber);
//                    common.clickOnElement(
//                            "//div[@class='cm-s-layer__layer__box s-ly-step-code']//button[@class='s-btn-encased s-blue']");
//                }
//                elementExistValue = common.checkIfElementExists("//div[4]/div/div/label/span");
//                if (elementExistValue == true) {
//                    common.scrollToElement("//div[4]/div/div/label/span");
//                    common.clickOnElement("//div[4]/div/div/label/span");
//                } else {
//                    common.scrollToElement(
//                            "//div[contains(@class,'cm-s-layer__layer__box s-ly-step-apply')]//span[contains(@class,'cta-btn__txt')][contains(text(),'CONFIRM')]");
//                }
//                common.clickOnElement(
//                        "//div[contains(@class,'cm-s-layer__layer__box s-ly-step-apply')]//span[contains(@class,'cta-btn__txt')][contains(text(),'CONFIRM')]");
//            } else {
//                tradeInDeviceInTheBasket = S20.runTradeIn(imeinumber);
//            }
//        }
//        Type("Trade in device added: " + tradeInDeviceInTheBasket);
//        return tradeInDeviceInTheBasket;
//    }
//
//    public static void checkTradeInInBasket(String tradeInDeviceInTheBasket, boolean tradeinwanted) throws Throwable {
//        if (tradeinwanted == true) {
//            String tradeInDeviceInCart = common.getTextOfElement(
//                    "//div[@class='sc-prd-additional-cont']//div//p[@class='sc-prd-additional-cont-prod']");
//            Type("Trade in device in cart is: " + tradeInDeviceInCart);
//            common.assertStarter(tradeInDeviceInTheBasket, tradeInDeviceInCart);
//
//        }
//    }
//
//    public static void checkScplusInBasket(boolean scpluswanted) throws Exception {
//        if (scpluswanted == true) {
//            sCPlusExistingResult = common.checkIfElementExists(
//                    "//div[@class='sc-prd-additional-cont']//div//div[@class='sc-prd-additional-cont-list'][contains(text(),'Samsung Care+')]");
//
//            if (sCPlusExistingResult == true) {
//                Type("Samsung Care Plus found in the cart!");
//            }
//            assertResult(sCPlusExistingResult);
//        }
//    }
//
//    public static void checkAccessoryInBasket(String accessoryInTheBasket, boolean accessorywanted) throws Exception {
//        if (accessorywanted == true) {
//            accessoryExistingResult = common
//                    .checkIfElementExists("//h3[contains(text(),'" + accessoryInTheBasket + "')]");
//            if (accessoryExistingResult == true) {
//                Type("Accessory found in the cart: " + accessoryInTheBasket);
//            }
//            assertResult(accessoryExistingResult);
//        }
//    }
//
//    public static void compareValuesInBasket(String skuNumber, String devicename1) throws Throwable {
//
//        skuNumberInBasket = common.getTextOfElement("//p[@class='sc-product-ship-name']");
//        productNameInBasket = common.getTextOfElement(common.getValueFromConfig("location_productnameinbasket"))
//                .replaceAll("\\s", "");
//        if (!skuNumber.equals(skuNumberInBasket)) {
//            elementExistValue = checkIfElementExists(
//                    "//div[@class='shopping-cart-items-holder cart-items']/div//h3[@class='sc-product-name'][contains(text(),'"
//                            + devicename1 + "')]");
//            if (elementExistValue == true) {
//                skuNumberInBasket = common.getTextOfElement(
//                        "//div[@class='shopping-cart-items-holder cart-items']/div//h3[@class='sc-product-name'][contains(text(),'"
//                                + devicename1 + "')]/parent::div/p[@class='sc-product-ship-name']");
//                productNameInBasket = common.getTextOfElement(
//                        "//div[@class='shopping-cart-items-holder cart-items']/div//h3[@class='sc-product-name'][contains(text(),'"
//                                + devicename1 + "')]")
//                        .replaceAll("\\s", "");
//            } else {
//                skuNumberInBasket = common.getTextOfElement(
//                        "//div[@class='shopping-cart-items-holder cart-items']/div//h3[@class='sc-product-name'][contains(text(),'Galaxy S20 Ultra 128GB 5G')]/parent::div/p[@class='sc-product-ship-name']");
//                productNameInBasket = common.getTextOfElement(
//                        "//div[@class='shopping-cart-items-holder cart-items']/div//h3[@class='sc-product-name'][contains(text(),'Galaxy S20 Ultra 128GB 5G')]")
//                        .replaceAll("\\s", "").replaceAll("128GB", "");
//            }
//        }
//        deviceName = devicename1.replaceAll("\\s", "");
//        common.Type("Expected SKU number is: " + skuNumber);
//        common.Type("SKU number in the cart is: " + skuNumberInBasket);
//        common.Type("Expected device name is: " + deviceName);
//        common.Type("Device name in the cart is: " + productNameInBasket);
//        common.assertStarter(productNameInBasket, deviceName);
//        common.assertStarter(skuNumberInBasket, skuNumber);
//    }
//
//    public static float convertMoneyStringToNumber(String moneyvalue) {
//
//        float numberValue = Float.valueOf(moneyvalue.replaceAll("\\£", "").replaceAll("\\,", ""));
//        return numberValue;
//    }
//
//    public static void compareThePrice(String priceBeforeCart) throws Throwable {
//        if (priceBeforeCart == null) {
//            priceBeforeCart = common.noteThePriceInTheBasket();
//        }
//        elementExistValue = clickOnElementIfClickable(
//                "//a[@class='product-details-anchor-navi__cta js-buy-now']//span");
//        if (elementExistValue == false) {
//            clickOnElementIfClickable("//button[@class='s-btn-encased price-bar-cart-btn']");
//        }
//        literallyWait();
//        clickOnElementIfClickable("//a[@class='s-btn-encased']/span");
//        clickOnElementIfClickable("//div[@class='s-cta-wrap']//button[@class='s-btn-encased s-cta-blue']/span");
//        priceInCart = getTextOfElement("//p[@class='os-price-value os-price-value-size']");
//        elementExistValue = checkIfElementExists("//p[@class='os-price-value']");
//
//        if (!String.valueOf(convertMoneyStringToNumber(priceInCart))
//                .equals(String.valueOf((convertMoneyStringToNumber(priceBeforeCart)))) && elementExistValue == true) {
//            float priceBeforeCartValue = convertMoneyStringToNumber(priceBeforeCart);
//            float priceInCartValue = convertMoneyStringToNumber(priceInCart);
//            float discountIntValue = convertMoneyStringToNumber(getTextOfElement("//p[@class='os-price-value']"));
//            float priceInCartValueWithDiscount = priceInCartValue + discountIntValue;
//            priceInCart = String.valueOf(priceInCartValueWithDiscount);
//            priceBeforeCart = String.valueOf(priceBeforeCartValue);
//        }
//        priceInCart = String.valueOf(convertMoneyStringToNumber(priceInCart));
//        priceBeforeCart = String.valueOf((convertMoneyStringToNumber(priceBeforeCart)));
//        Type("Expected price is: £" + priceBeforeCart);
//        Type("Price in the cart is: £" + priceInCart);
//
//        assertStarter(priceBeforeCart, priceInCart);
//
//    }
//
//    public static void compareThePriceAddingAccessory(String priceBeforeCart, String accessoryPrice) throws Throwable {
//        priceBeforeCart = String
//                .valueOf(convertMoneyStringToNumber(priceBeforeCart) + convertMoneyStringToNumber(accessoryPrice));
//        Type("Device added from FBT section is included to the total shopping amount");
//        elementExistValue = clickOnElementIfClickable(
//                "//a[@class='product-details-anchor-navi__cta js-buy-now']//span");
//        if (elementExistValue == false) {
//            clickOnElementIfClickable("//button[@class='s-btn-encased price-bar-cart-btn']");
//        }
//        literallyWait();
//        clickOnElementIfClickable("//a[@class='s-btn-encased']/span");
//        clickOnElementIfClickable("//div[@class='s-cta-wrap']//button[@class='s-btn-encased s-cta-blue']/span");
//        priceInCart = getTextOfElement("//p[@class='os-price-value os-price-value-size']");
//        elementExistValue = checkIfElementExists("//p[@class='os-price-value']");
//
//        if (!String.valueOf(convertMoneyStringToNumber(priceInCart))
//                .equals(String.valueOf((convertMoneyStringToNumber(priceBeforeCart)))) && elementExistValue == true) {
//            float priceBeforeCartValue = convertMoneyStringToNumber(priceBeforeCart);
//            float priceInCartValue = convertMoneyStringToNumber(priceInCart);
//            float discountIntValue = convertMoneyStringToNumber(getTextOfElement("//p[@class='os-price-value']"));
//            float priceInCartValueWithDiscount = priceInCartValue + discountIntValue;
//            priceInCart = String.valueOf(priceInCartValueWithDiscount);
//            priceBeforeCart = String.valueOf(priceBeforeCartValue);
//        }
//        priceInCart = String.valueOf(convertMoneyStringToNumber(priceInCart));
//        priceBeforeCart = String.valueOf((convertMoneyStringToNumber(priceBeforeCart)));
//        Type("Expected price is: £" + priceBeforeCart);
//        Type("Price in the cart is: £" + priceInCart);
//
//        assertStarter(priceBeforeCart, priceInCart);
//
//    }
//}