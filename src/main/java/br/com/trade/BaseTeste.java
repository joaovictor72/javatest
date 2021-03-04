package br.com.trade;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTeste implements IBaseTeste {

    protected WebDriver driver;

    private String usuario;
    private String senha;

    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setup() {
        String OS = System.getProperty("os.name", "generic").toLowerCase();

        String geckoDriver;
        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            geckoDriver = "geckodriver-macos";
        } else if (OS.indexOf("win") >= 0) {
            geckoDriver = "geckodriver-window.exe";
        } else if (OS.indexOf("nux") >= 0) {
            geckoDriver = "geckodriver-linux";
        } else {
            geckoDriver = "";
        }
        Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver/" + geckoDriver);
        System.setProperty("webdriver.gecko.driver", path.toString());
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
        login();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    public void login() {
        driver.manage().window().maximize();
        System.out.println(getBaseUrl());
        System.out.println(getUsuario());
        System.out.println(getSenha());
        esperarCincoSegundos();
        driver.get(getBaseUrl());
        driver.findElement(By.id("user-input")).clear();
        driver.findElement(By.id("user-input")).sendKeys(getUsuario());
        driver.findElement(By.id("password-input")).clear();
        driver.findElement(By.id("password-input")).sendKeys(getSenha());
        WebElement webElement = driver.findElement(By.cssSelector("button"));
        webElement.sendKeys(Keys.ENTER);
        esperarDezSegundos();
    }

    public static void esperarDezSegundos() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void esperarCincoSegundos() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void esperarDoisSegundos() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

