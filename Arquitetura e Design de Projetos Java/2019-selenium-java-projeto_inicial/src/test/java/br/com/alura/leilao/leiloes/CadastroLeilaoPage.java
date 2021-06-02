package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private final WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = browser;

    }

    public void fechar() {
        this.browser.quit();
    }

}
