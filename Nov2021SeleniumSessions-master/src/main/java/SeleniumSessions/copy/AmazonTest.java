package SeleniumSessions.copy;

public class AmazonTest {

	public static void main(String[] args) {

        String browser = "chrome";
		BrowserUtil br = new BrowserUtil();
		
		br.launchBrowser(browser);
		br.enterUrl("https://www.amazon.com");
		String pageTitle = br.getPageTitle();
		if(pageTitle.contains("Amazon")) {
			System.out.println("title is correct...");
		}
		String pageUrl = br.getPageUrl();
		if(br.getPageUrl().contains("amazon")) {
			System.out.println("url is correct");
		}
		
		br.quitBrowser();

	}

}
