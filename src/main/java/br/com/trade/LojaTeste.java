package br.com.trade;

import org.junit.Test;
import org.openqa.selenium.By;

public class LojaTeste extends TradeBaseTeste {
    public static void main(String[] args) {
    }
    @Test
    public void comprar() throws InterruptedException {
        driver.get(super.getBaseUrl());
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("div:nth-child(1) > .sc-bdfBwQ > .bcaJjD > img")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button")).click();
    }

    @Test
    public void verExtrato() throws InterruptedException {
        driver.get(super.getBaseUrl());
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button > img")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button:nth-child(1)")).click();
    }
}
