<h1 align="center"> 📝 Conversor de Moedas </h1>

<div align="center">

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)

</div>
<br>

Este é um **conversor de moedas** interativo que funciona via console. Desenvolvido em Java com o *framework* Spring Boot, o projeto permite aos usuários converter valores entre diferentes moedas em tempo real, utilizando a API [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio mais recentes.

---

## ✨ Funcionalidades

- **Menu Interativo:** Interface de console simples e fácil de usar.
- **Conversões Múltiplas:** Suporte para diversas opções de conversão pré-definidas:
  - Real (BRL) ↔ Dólar Americano (USD)
  - Real (BRL) ↔ Iene Japonês (JPY)
  - Real (BRL) ↔ Peso Chileno (CLP)
- **Extensível:** O projeto pode ser facilmente estendido para incluir outras moedas disponíveis na API.
- **Taxas de Câmbio Atuais:** As conversões são feitas com base nas taxas de câmbio mais recentes fornecidas pela API.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **ExchangeRate-API:** Para consulta das taxas de câmbio.
- **Gson:** Para manipulação de dados JSON.
- **Dotenv-java:** Para gerenciamento de variáveis de ambiente (API Key).

---

## ⚙️ Pré-requisitos

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
- [Maven](https://maven.apache.org/download.cgi) 3.8 ou superior.
- Uma **chave de API** da [ExchangeRate-API](https://www.exchangerate-api.com/docs/java-api).
- Uma IDE de sua preferência (e.g., [IntelliJ IDEA](https://www.jetbrains.com/idea/), [VS Code](https://code.visualstudio.com/)).

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para rodar o projeto localmente:

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/biachristie/oracle-programa-one-g8/tree/main/Challenge_conversor_moedas
    cd Challenge_conversor_moedas
    ```

2.  **Crie o arquivo de variáveis de ambiente:**
    - Na raiz do projeto, crie um arquivo chamado `.env`.
    - Dentro deste arquivo, adicione sua chave da API da seguinte forma:
      ```
      EXCHANGE_API_KEY = SUA_CHAVE_DE_API_AQUI
      ```

3.  **Compile e execute o projeto:**
    - Abra um terminal na raiz do projeto e execute o seguinte comando Maven:
    ```bash
    mvn spring-boot:run
    ```

4.  **Use o conversor:**
    - O menu interativo será exibido no console. Siga as instruções para realizar as conversões desejadas.

---

## 📂 Estrutura do Projeto

``` bash
├───src
    ├───main
        ├───java
        │   └───br
        │       └───com
        │           └───alura
        │               └───conversor
        │                   ├───config
        │                   ├───model
        │                   ├───principal
        │                   └───service
        └───resources
```

O projeto está organizado nos seguintes pacotes:

-   `br.com.alura.conversor`: Pacote principal da aplicação.
    -   `ConversorApp.java`: Classe principal que inicializa a aplicação Spring Boot.
-   `br.com.alura.conversor.config`:
    -   `AppConfig.java`: Configurações de beans do Spring, como o `HttpClient`.
-   `br.com.alura.conversor.model`:
    -   `Conversor.java`: Classe que representa os dados da resposta da API.
    -   `CodigoMoeda.java`: Enum com os códigos e nomes das moedas suportadas.
-   `br.com.alura.conversor.principal`:
    -   `Principal.java`: Contém a lógica do menu interativo e a interação com o usuário.
-   `br.com.alura.conversor.service`:
    -   `ConsumoApi.java`: Responsável por fazer a requisição HTTP para a ExchangeRate-API.
    -   `ConversaoDados.java`: Orquestra o processo de conversão, consumindo a API e processando a resposta JSON.

---

## 📃 Licença

Este projeto está licenciado sob a MIT license.

---

## 👨‍💻 Autor

Beatriz Christie

- GitHub: [github.com/biachristie](https://www.github.com/biachristie)