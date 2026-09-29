package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {
	private WebDriver driver;
	
	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() throws IOException {
		// TODO ここに追加
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.get("http://localhost:8080/lms");
		assertEquals("ログイン | LMS", driver.getTitle());
//		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		Files.copy(file.toPath(), Paths.get("./evidence/Case02_access.png"));
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
	void test02() throws IOException {
		// TODO ここに追加
		WebElement loginpass = driver.findElement(By.name("col-lg-2 control-label"));
		WebElement loginId = driver.findElement(By.name("loginId"));
		WebElement loginButton = driver.findElement(By.className("btn btn-primary"));
		
		try  {
		
			loginpass.clear();
			loginpass.sendKeys("StudentAA01");
			loginButton.click();
		
		}catch(Exception e) {
		
			assertEquals("StudentAA01", loginpass.getAttribute("required"), "エラーメッセージ「ログインIDは必須です。」が表示される。");
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file.toPath(), Paths.get("./evidence/Case02_notId.png"));
			
		}
		
		try  {
			
			loginId.clear();
			loginId.sendKeys("StudentAA01");
			loginButton.click();
		
		}catch(Exception e) {
		
			assertEquals("StudentAA01", loginId.getAttribute("required"), "エラーメッセージ「パスワードは必須です。」が表示される。");
			File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file1.toPath(), Paths.get("./evidence/Case02_notPass.png"));
		
		}
		
		try  {
			
			loginpass.sendKeys("aaaa");	
			loginId.sendKeys("aa0001");
			loginButton.click();
		
		}catch(Exception e) {
		
			assertEquals("aaaa", loginId.getAttribute("login"), "エラーメッセージ「ログインに失敗しました。」が表示される。");
			File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file2.toPath(), Paths.get("./evidence/Case02_loginFailed.png"));
			
		}
		
	}

}
