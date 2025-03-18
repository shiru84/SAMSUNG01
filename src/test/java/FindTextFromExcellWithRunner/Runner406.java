package FindTextFromExcellWithRunner;


public class Runner406 {

    
    public static void main(String[] args) throws Exception {

        TestCaseUKOT406WithRunner.openBrowser();
        TestCaseUKOT406WithRunner.n=1;
        for (int i = 0; i<31; i++) {
            activityTest();
        }
        System.out.println("all done now!");
        TestCaseUKOT406WithRunner.quit();

    }

    private static void activityTest() throws Exception {
        TestCaseUKOT406WithRunner.goToPage(TestCaseUKOT406WithRunner.TESTING_ROW + TestCaseUKOT406WithRunner.n, TestCaseUKOT406WithRunner.TESTING_ITEM_URL_CELL);
        TestCaseUKOT406WithRunner.goToPage(TestCaseUKOT406WithRunner.TESTING_ROW + TestCaseUKOT406WithRunner.n, TestCaseUKOT406WithRunner.TESTING_URL_CELL);
        Thread.sleep(4000);
        TestCaseUKOT406WithRunner.expectedTEXT(TestCaseUKOT406WithRunner.TESTING_ROW + TestCaseUKOT406WithRunner.n, TestCaseUKOT406WithRunner.TESTING_DATA_CEL);
        TestCaseUKOT406WithRunner.findExpectedText(TestCaseUKOT406WithRunner.TEXT, TestCaseUKOT406WithRunner.TESTING_ROW + TestCaseUKOT406WithRunner.n, TestCaseUKOT406WithRunner.TEST_RESULT_CEL);
        TestCaseUKOT406WithRunner.removeItemFromCart(TestCaseUKOT406WithRunner.TESTING_ROW + TestCaseUKOT406WithRunner.n, TestCaseUKOT406WithRunner.TEST_RESULT_CEL);
        TestCaseUKOT406WithRunner.n = TestCaseUKOT406WithRunner.n + 1;
    }

    
}
