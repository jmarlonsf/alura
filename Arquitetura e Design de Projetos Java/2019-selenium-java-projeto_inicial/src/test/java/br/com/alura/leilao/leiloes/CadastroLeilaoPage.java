package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
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

    public LeiloesPage cadastrarLeilao(String nome, String valorInical, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInical);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browser.findElement(By.id("button-submit")).submit();

        return new LeiloesPage(browser);
    }
}
