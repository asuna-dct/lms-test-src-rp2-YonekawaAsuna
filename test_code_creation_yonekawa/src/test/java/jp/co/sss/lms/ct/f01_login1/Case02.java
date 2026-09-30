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
import org.openqa.selenium.WebElement;

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

	
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
		webDriver.get("http://localhost:8080/lms");
		assertEquals("ログイン | LMS", webDriver.getTitle());
//		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		Files.copy(file.toPath(), Paths.get("./evidence/Case02_access.png"));
		getEvidence(new Object() {});
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
	void test02() throws IOException {
		// TODO ここに追加
		WebElement loginpass = webDriver.findElement(By.id("password"));
		WebElement loginId = webDriver.findElement(By.id("loginId"));
		WebElement loginButton = webDriver.findElement(By.cssSelector("input[type='submit']"));
		
		
//		
//			loginpass.clear();
//			loginpass.sendKeys("StudentAA01");
//			loginButton.click();
//		
//		
//		
//			assertEquals("StudentAA01", loginpass.getAttribute("required"), "エラーメッセージ「ログインIDは必須です。」が表示される。");
////			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////			Files.copy(file.toPath(), Paths.get("./evidence/Case02_notId.png"));
//			getEvidence(new Object() {});
//			
//
//			
//			loginId.clear();
//			loginId.sendKeys("StudentAA01");
//			loginButton.click();
//		
//	
//		
//			assertEquals("StudentAA01", loginId.getAttribute("required"), "エラーメッセージ「パスワードは必須です。」が表示される。");

		
		
			
			loginpass.sendKeys("aaaa");	
			loginId.sendKeys("aa0001");
			loginButton.click();
		
	
			WebElement error = webDriver.findElement(By.cssSelector(".help-inline.error"));
			assertEquals("* ログインに失敗しました。" , error.getText(), "エラーメッセージ「ログインに失敗しました。」が表示される。");
			getEvidence(new Object() {});
	
		
	}

}
