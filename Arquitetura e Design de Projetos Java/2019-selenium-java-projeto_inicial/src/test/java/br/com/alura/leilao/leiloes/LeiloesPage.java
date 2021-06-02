package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class LeiloesPage {

    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private final WebDriver browser;

    public LeiloesPage(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = browser;

    }

    public void fechar() {
        this.browser.quit();
    }


    public CadastroLeilaoPage carregaFormulario() {
        this.browser.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(browser);
    }
}
