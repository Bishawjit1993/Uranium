package base;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase extends Driver {
	public String randomlySelectFromDropDown(WebElement element) {
		String value = null;
		Select select = new Select(element);
		int maxIndex = select.getOptions().size() - 1;
		int randomIndex = getRandomNumber(1, maxIndex);
		select.selectByIndex(randomIndex);
		value = select.getFirstSelectedOption().getText();
		return value;
	}

	public static int getRandomNumber(int min, int max) {
		int randomNumber = 0;
		Random random = new Random();
		randomNumber = random.nextInt(max + 1 - min) + min;
		return randomNumber;
	}
}
