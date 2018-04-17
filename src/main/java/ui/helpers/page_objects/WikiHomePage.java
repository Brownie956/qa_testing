package ui.helpers.page_objects;

import org.openqa.selenium.By;

public class WikiHomePage extends Page {

    public static final String URL = "https://en.wikipedia.org/wiki/Main_Page";

    public static final By MENU_CONTENTS = By.xpath(".//li[@id='n-contents']/a");
}
