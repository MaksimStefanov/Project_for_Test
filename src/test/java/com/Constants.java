package com;

import org.openqa.selenium.By;

public class Constants {
    public static final String WEB_DRIVER_PROPERTY = "webdriver.chrome.driver";
    public static final String PATH_TO_CHROME = "src/test/resources/chromedriver.exe";
    public static final String WEB_DRIVER_PROPERTY_FIREFOX = "webdriver.gecko.driver";
    public static final String PATH_TO_FIREFOX = "src/test/resources/geckodriver.exe";
    public static final String BROWSER_NAME_PROPERTY = "browserName";
    public static final String FILE_PROPERTY ="default.properties";
    public static final String CONFIRMATION_CHECKBOX_X = "//*[@class='confirmation-checkbox']/child::label";
    public static final String SELECT_OPTIONS_X = "//*[@id='agegate-selector-options']";
    public static final String WELCOME_BUTTON_X = "//input[@type='submit']";
    public static final String EUROPE = "Europe";
    public static final String AUSTRALIA = "Australia";
    public static final String CHINA = "China";
    public static final String JAPAN = "Japan";
    public static final String GERMANY = "Germany";
    public static final String OTHER = "Other";
    public static final String UK = "United Kingdom";
    public static final String USA = "United States";
    public static final String FOOTER_ID = "primary-footer";
    public static final String BASE_URL = "https://www.yellowtailwine.com/";
    public static final String MAIN_PAGE_MENU_X = "//span[contains(text(),'Menu')]";
    public static final String MAIN_PAGE_ELEMENT_X = "//p[@class='header-sub-copy'][contains(text(),'We are')]";
    public static final String LEGAL_AGE_X = "//label[@for='confirm']";
    public static final String YELLOW_TAIL_LOGO_X = "//div[@class='top-nav -active']/descendant::img[@alt='Yellow tail logo']";
    public static final String SELECT_COUNTRY_X = "//li[@id='country-select']/a";
    public static final String WELCOME_TO_THE_WORLD = "//*[contains(text(),'to the world of')]";
    public static final String EXPECTED_URL_CHINA = "https://www.yellowtailwine.cn/";
    public static final String CHECKBOX_X = "//*[@class='fa fa-bars']/span";
    public static final String COUNTRY_CHINA = "//a[@data-key='CN']";
    public static final String COUNTRY_AUSTRALIA = "//a[@data-key='AU']";
    public static final String COUNTRY_USA = "//a[@data-key='US']";
    public static final String COCKTAILS_BUTTON_X = "//a[contains(text(),'Cocktails')]";
    public static final String WE_ARE_PASSIONATE_X = "//p[@class='header-sub-copy'][contains(text(),'We are')]";
    public static final String FIND_YOUR_WINE_X = "//*[@class='button home-button']";
    public static final String SELECT_COCTAILS_INIT_X = "//a[@class='selected']";
    public static final String RED_WINE = "//a[@data-value='red']";
    public static final String ROSE_WINE = "//a[@data-value='rose']";
    public static final String WHITE_WINE = "//a[@data-value='white']";
    public static final String SPARKLINE_WINE = "//a[@data-value='bubbles']";
    public static final String WHERE_TO_BUY = "//a[text()='Where to Buy']";
    public static final String SEARCH_FIELD = "locationName";
    public static final String SYDNEY = "Sydney";
    public static final String SEARCH_BUTTON_X = "//button[@class='search-submit']";
    public static final String STOCKISTS_X = "//*[contains(text(),'Stockists in your area')]";
    public static final String RECIPES_X = "//div[@class='tile recipe-tile']";
    public static final String RASPBERRY_COCKTAIL_X = "//img[@alt='Raspberry Rose']";
    public static final String FULL_RECIPE_X = "//img[@alt='Raspberry Rose']/parent::a/descendant::div[contains(text(),'Full recipe')]";
    public static final String INGREDIENTS_X = "//div[@class='ingredients']";


}

