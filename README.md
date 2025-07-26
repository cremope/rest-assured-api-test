# rest-assured-api-test

Projeto de automação de testes de API utilizando RestAssured e Cucumber, executando via GitHub Actions e relatório do GitHub Pages.

## Dependências
- JDK: 17
- Apache Maven: 3.13.0
- Cucumber: 7.20.1
- JUnit: 5.11.3
- Allure Report: 2.29.0

## Instalação
Baixando as dependências

```bash
  cd rest-assured-api-test
  mvn install
```

## Rodando os testes
Para rodar os testes, rode o seguinte comando

```bash
  mvn clean verify test
```

## Relatório dos testes
Gerar o Allure Report

```bash
  allure serve target/allure-results
  allure serve --sigle-file target/allure-results
```

Apagar o Allure Report de execuções anteriores

```bash
  allure generate --clean --output target/allure-results
```

Para visualizar o relatório de testes [Clique aqui](https://cremope.github.io/rest-assured-api-test/)

## ScreenShots
<img src="https://github.com/cremope/rest-assured-api-test/blob/main/ScreenShots/Allure_Overview.png" width="400" /> 
<img src="https://github.com/cremope/rest-assured-api-test/blob/main/ScreenShots/Allure_Suites_OK.png" width="400" />