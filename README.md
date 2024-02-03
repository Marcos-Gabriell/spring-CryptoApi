# CryptoApp

O CryptoApp  é uma aplicação para o gerenciamento de uma carteira de criptomoedas. A aplicação é construída em Java com Spring Boot e utiliza JDBC para interagir com um banco de dados H2 em memória ou o MySQL.A aplicação utiliza Vue.js para o frontend e Axios para realizar requisições HTTP.

![CryptoApp ](https://github.com/Marcos-Gabriell/spring-CryptoApi/blob/master/src/main/resources/static/projeto.jpg)

## Pré-requisitos

- Java 8 ou superior
- Spring Boot
- Maven

## Configuração do Projeto

1. Clone o repositório.

    ```bash
    git clone https://github.com/seu-usuario/cryptowallet-manager.git
    cd cryptowallet-manager
    ```

2. Construa e execute o projeto.

    ```bash
    mvn clean install
    java -jar target/cryptowallet-manager.jar
    ```

3. Acesse a aplicação no navegador.

    ```
    http://localhost:8080
    ```

## Inicialização com Dados de Exemplo

Ao iniciar o aplicativo, ele criará automaticamente algumas transações de exemplo na sua carteira. Isso é feito através do método `init` no `CoinController`.

## Funcionalidades

1. **Cadastrar Transação:**
   - Adicione novas transações à sua carteira, especificando a moeda, quantidade, preço e data.

2. **Visualizar Carteira:**
   - Veja uma lista completa de todas as transações realizadas, incluindo detalhes como a moeda, quantidade, preço unitário e data da transação.

3. **Atualizar Transação:**
   - Atualize os detalhes de uma transação existente, como a quantidade, preço ou moeda.

4. **Excluir Transação:**
   - Remova transações que não são mais relevantes ou precisas.

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Crie uma issue ou envie um pull request.
