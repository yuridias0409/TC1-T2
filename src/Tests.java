import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tests {
	public static void main(String[] args) throws InterruptedException {
		String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath + "/lib/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
        
        /*Página Inicial*/
        String paginaInicial = userPath + "/Views/index.html";
        driver.get(paginaInicial);
        driver.manage().window().maximize();
        
        Thread.sleep(500);
        
        /*Teste Número 1*/
        System.out.println("------------------------------------------------");
        System.out.println("\nTeste 1 - Testanto Title da página Menu\n");
        
        /*Verifica Title*/
        String titleEsperadoMenu = "Menu";
        if(titleEsperadoMenu.compareTo(driver.getTitle()) == 0) {
        	System.out.println("Title correto: " + titleEsperadoMenu);
        	System.out.println("------------------------------------------------");
        }	else {
        	System.out.println("Title incorreto");
        	System.out.println("Title esperado: " + titleEsperadoMenu);
        	System.out.println("Title da página: " + driver.getTitle());
        	System.out.println("------------------------------------------------");
        }
        
        Thread.sleep(2000);
        
        /*Teste Número 2*/
        System.out.println("\nTeste 2 - Teste de Redirecionamento\n");
        
        /*Verificando redirecionamento*/
        String paginaPessoaMenu = userPath + "/Views/pessoaMenu.html";
        driver.findElement(By.linkText("Pessoas")).click(); //
        String paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        paginaPessoaMenu = paginaPessoaMenu.replace("\\", "/");
        
        if (paginaAtual.compareTo(paginaPessoaMenu)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
            System.out.println("------------------------------------------------");
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaPessoaMenu);
            System.out.println("------------------------------------------------");
        }
        
        /*Teste Número 3*/
        System.out.println("\nTeste 3 - Testanto Title da Página Menu Pessoas\n");
        
        /*Verifica Title*/
        String titleEsperadoPessoas = "Pessoas";
        if(titleEsperadoPessoas.compareTo(driver.getTitle()) == 0) {
        	System.out.println("Title correto: " + titleEsperadoPessoas);
        	System.out.println("------------------------------------------------");
        }	else {
        	System.out.println("Title incorreto");
        	System.out.println("Title esperado: " + titleEsperadoPessoas);
        	System.out.println("Title da página: " + driver.getTitle());
        	System.out.println("------------------------------------------------");
        }
        
        Thread.sleep(2000);
        
        /*Teste Número 4*/
        System.out.println("\nTeste 4 - Testanto Redirecionamento\n");
        
        String paginaPessoaForm = userPath + "/Views/FormPessoa.html";
        driver.findElement(By.linkText("Adionar Pessoa")).click(); //
        paginaPessoaForm = paginaPessoaForm.replace("\\", "/");
        
        /*Atualizando a página atual*/
        paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        
        if (paginaAtual.compareTo(paginaPessoaForm)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
            System.out.println("------------------------------------------------");
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaPessoaForm);
            System.out.println("------------------------------------------------");
        }
        
        /*Teste Número 5*/
        System.out.println("\nTeste 5 - Teste do Forms\n");
        
        /*Teste Required*/
        WebElement button = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        button.click();
        
        /*Elemento*/
        WebElement warning = driver.findElement(By.xpath("//*[@id=\"warning\"]"));
        
        String txtEmptyCPF = "*Este campo é requerido";
        String warningTxt = warning.getText();
        
        if(txtEmptyCPF.compareTo(warningTxt) == 0) {
        	System.out.println("\nO texto do CPF não está preenchido");
        }	else {
        	System.out.println("\nO texto do CPF está preenchido");
        }
        
        /*Preenchendo CPF*/
        System.out.println("\nPreenchendo o CPF");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cpfinput\"]")).sendKeys("183.284.778-07");
        button.click();
        System.out.println("Refazendo o Teste");
        Thread.sleep(1000);
        
        WebElement warningTeste2 = driver.findElement(By.xpath("//*[@id=\"warning\"]"));
              
        if(txtEmptyCPF.compareTo(warningTeste2.getText()) == 0) {
        	System.out.println("\nO texto do CPF não está preenchido");
        }	else {
        	System.out.println("\nO texto do CPF está preenchido");
        }
        
        
        /*Preenchendo os outros Campos*/
        Thread.sleep(2000);
        System.out.println("\nPreenchendo os outros campos");
        driver.findElement(By.xpath("//*[@id=\"nomeinput\"]")).sendKeys("Silvio Santos");
        driver.findElement(By.xpath("//*[@id=\"datainput\"]")).sendKeys("05/04/1998");
        driver.findElement(By.xpath("//*[@id=\"salarioinput\"]")).sendKeys("28000");
        driver.findElement(By.xpath("//*[@id=\"emailinput\"]")).sendKeys("silviosantos@hotmail.com");
        driver.findElement(By.xpath("//*[@id=\"telinput\"]")).sendKeys("51999448899");
        
        /*Testando drop-down list*/
        WebElement select = driver.findElement(By.xpath("//*[@id=\"sexoSelect\"]"));
        
        /*Verifica se o drop-down está aparecendo*/
        System.out.println("\nTestando o Drop-down");
        if(select.isDisplayed()) {
            System.out.println("\nDrop-down está na tela");
        }	else {
            System.out.println("Drop-down não está na tela");
        }
        
        /*Verifica se ela está ativa*/
        if(select.isEnabled()) {
            System.out.println("Drop-down está ativo");
        }	else {
            System.out.println("Drop-down está desativado");
        }
        
        /*Teste de preenchimento*/
        System.out.println("\nPreenchendo DropDown com Masculino\n");
        Thread.sleep(1000);
        driver.findElement(By.tagName("select")).sendKeys("Masculino");
        Thread.sleep(1000);
        System.out.println("\nPreenchendo DropDown com Feminino\n");
        Thread.sleep(1000);
        driver.findElement(By.tagName("select")).sendKeys("Feminino");
        Thread.sleep(1000);
        System.out.println("\nPreenchendo DropDown com Outros\n");
        System.out.println("------------------------------------------------");
        Thread.sleep(1000);
        driver.findElement(By.tagName("select")).sendKeys("Outros");
        Thread.sleep(1000);
        
        /*Retornando para a página anterior*/
        driver.navigate().back();
        Thread.sleep(2000);
               
        driver.navigate().back();
        Thread.sleep(2000);
        
        /*Teste número 6*/
        System.out.println("\nTeste 6 - Teste de Redirecionamento (backward)\n");
        
        /*Atualizando a página atual*/
        paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        paginaInicial = paginaInicial.replace("\\", "/");
        
        if (paginaAtual.compareTo(paginaInicial)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
            System.out.println("------------------------------------------------");
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaInicial);
            System.out.println("------------------------------------------------");
        }
        Thread.sleep(2000);
        
        /*Teste número 7*/
        System.out.println("\nTeste 7 - Redirecionamento correto (forward)\n");
        
        System.out.println("\nSaindo do Menu\n");
        
        String paginaSair = userPath + "/Views/sair.html";
        driver.findElement(By.linkText("Sair")).click();
        
        paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        paginaSair = paginaSair.replace("\\", "/");
        
        if (paginaAtual.compareTo(paginaSair)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaSair);
        }
        
        System.out.println("\nVoltando ao Menu\n");
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println("\nVoltando ao Sair\n");
        driver.navigate().forward();
        
        /*Atualizando a página atual*/
        paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        paginaSair = paginaSair.replace("\\", "/");
        
        if (paginaAtual.compareTo(paginaSair)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
            System.out.println("------------------------------------------------");
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaSair);
            System.out.println("------------------------------------------------");
        }
        
        /*Teste número 8*/
        System.out.println("\n Teste 8 - Testando outras navegações\n");
        
        driver.navigate().back();
        System.out.println("\nIndo para o Menu\n");
        /*Atualizando a página atual*/
        paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        paginaInicial = paginaInicial.replace("\\", "/");
        
        if (paginaAtual.compareTo(paginaInicial)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaInicial);
        }
        
        Thread.sleep(2000);
        
        System.out.println("\nIndo para Menu de Vacina \n");
        
        /*Verificando redirecionamento*/
        String paginaVacinaMenu = userPath + "/Views/vacinaMenu.html";
        paginaVacinaMenu = paginaVacinaMenu.replace("\\", "/");
        driver.findElement(By.linkText("Vacinas")).click();
        
        /*Atualizando a página atual*/
        paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        paginaInicial = paginaInicial.replace("\\", "/");     
        
        if (paginaAtual.compareTo(paginaVacinaMenu)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaVacinaMenu);
        }
        
        Thread.sleep(2000);
        
        System.out.println("\nIndo para Form de Vacina \n");
        
        /*Verificando redirecionamento*/
        String paginaFormVacina = userPath + "/Views/FormVacina.html";
        paginaFormVacina = paginaFormVacina.replace("\\", "/");
        driver.findElement(By.linkText("Adionar Vacina")).click();
        
        /*Atualizando a página atual*/
        paginaAtual = driver.getCurrentUrl();
        paginaAtual = paginaAtual.replace("file:///", "");
        paginaAtual = paginaAtual.replace("\\", "/");
        paginaInicial = paginaInicial.replace("\\", "/");     
        
        if (paginaAtual.compareTo(paginaFormVacina)==0){
            System.out.println("Redirecionamento correto: " + paginaAtual);
        }
        else{
            System.out.println("Redirecionamento errado");
            System.out.println("Redirecionamento: " + paginaAtual);
            System.out.println("Esperado:: " + paginaFormVacina);
        }
        
        System.out.println("\nTeste 8 - Teste do Forms\n");
        
        /*Teste Required*/
        WebElement buttonVacina = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        buttonVacina.click();
        
        /*Elemento*/
        WebElement warningVacina = driver.findElement(By.xpath("//*[@id=\"warningVacina\"]"));
        
        String txtEmptyCodigo = "*Este campo é requerido";
        warningTxt = warningVacina.getText();
        
        if(txtEmptyCodigo.compareTo(warningTxt) == 0) {
        	System.out.println("\nO texto do Código não está preenchido");
        }	else {
        	System.out.println("\nO texto do Código está preenchido");
        }
        
        /*Preenchendo Código*/
        
        System.out.println("\nPreenchendo o Código");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"codigoinput\"]")).sendKeys("1234");
        buttonVacina.click();
        System.out.println("Refazendo o Teste");
        Thread.sleep(1000);
        
        warningVacina = driver.findElement(By.xpath("//*[@id=\"warningVacina\"]"));
              
        if(txtEmptyCodigo.compareTo(warningVacina.getText()) == 0) {
        	System.out.println("\nO texto do Código não está preenchido");
        }	else {
        	System.out.println("\nO texto do Código está preenchido");
        }
        
        /*Preenchendo os outros campos*/
        System.out.println("\nPreenchendo os outros campos");
        driver.findElement(By.xpath("//*[@id=\"nomeinput\"]")).sendKeys("Coronavac");
        driver.findElement(By.xpath("//*[@id=\"precoinput\"]")).sendKeys("131");
        driver.findElement(By.xpath("//*[@id=\"idadeinput\"]")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"duracaoinput\"]")).sendKeys("2");
        
        /*Testando drop-down list*/
        select = driver.findElement(By.xpath("//*[@id=\"doencasSelect\"]"));
        
        /*Verifica se o drop-down está aparecendo*/
        System.out.println("\nTestando o Drop-down");
        if(select.isDisplayed()) {
            System.out.println("\nDrop-down está na tela");
        }	else {
            System.out.println("Drop-down não está na tela");
        }
        
        /*Verifica se ela está ativa*/
        if(select.isEnabled()) {
            System.out.println("Drop-down está ativo");
        }	else {
            System.out.println("Drop-down está desativado");
        }
        
        /*Teste de preenchimento*/
        System.out.println("\nPreenchendo DropDown com Coronavirus\n");
        Thread.sleep(1000);
        driver.findElement(By.tagName("select")).sendKeys("Coronavirus");
        Thread.sleep(1000);
        System.out.println("\nPreenchendo DropDown com Gripe\n");
        Thread.sleep(1000);
        driver.findElement(By.tagName("select")).sendKeys("Gripe");
        Thread.sleep(1000);
        System.out.println("\nPreenchendo DropDown com Febre Amarela\n");
        System.out.println("------------------------------------------------");
        Thread.sleep(1000);
        driver.findElement(By.tagName("select")).sendKeys("FebreAmarela");
        Thread.sleep(1000);
        
        
	}
}
