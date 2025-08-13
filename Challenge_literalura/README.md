<h1 align="center"> 📝 LiterAlura </h1>

<div align="center">

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green) ![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)

</div>
<br>

**LiterAlura** é um catálogo de livros interativo que funciona via linha de comando. Desenvolvido em Java com Spring Boot, este projeto consome a API pública [Gutendex](https://gutendex.com/) para buscar informações sobre livros e autores, e persiste esses dados em um banco de dados PostgreSQL para consultas futuras.

Este projeto foi desenvolvido como parte de um desafio do Programa ONE, com o objetivo de praticar o consumo de APIs, manipulação de dados JSON e persistência com Spring Data JPA.

---

## ✨ Funcionalidades

O menu interativo oferece as seguintes opções:

1.  **Buscar livro pelo título:** Realiza uma busca na API Gutendex, exibe os dados do primeiro livro encontrado e o salva no banco de dados local.
2.  **Listar livros registrados:** Mostra todos os livros que foram salvos no banco de dados.
3.  **Listar livros em um determinado idioma:** Filtra e exibe os livros registrados por idioma (inglês, espanhol, francês, português).
4.  **Listar autores registrados:** Mostra todos os autores que foram salvos no banco de dados, junto com seus livros.
5.  **Listar autores vivos em um determinado ano:** Permite ao usuário inserir um ano e exibe uma lista de autores que estavam vivos naquele período.

---

## 🛠️ Tecnologias Utilizadas

-   **Java 17:** Linguagem principal do projeto.
-   **Spring Boot 3:** Framework para criação da aplicação standalone.
-   **Spring Data JPA:** Para persistência de dados e comunicação com o banco.
-   **PostgreSQL:** Banco de dados relacional para armazenar os livros e autores.
-   **Maven:** Gerenciador de dependências do projeto.
-   **Gutendex API:** Fonte externa para os dados dos livros.
-   **Jackson:** Biblioteca para manipulação e conversão de dados JSON.

---

## ⚙️ Pré-requisitos

-   **Java 17** ou superior instalado.
-   **Maven** configurado no seu ambiente.
-   Um servidor **PostgreSQL** ativo e rodando na sua máquina.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para rodar o projeto localmente:

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/biachristie/oracle-programa-one-g8/tree/main/Challenge_literalura
    cd Challenge_literalura
    ```

2.  **Crie e configure o banco de dados:**
    - Crie um banco de dados no seu SGBD (ex: `literalura_db`).

3. **Crie o arquivo de variáveis de ambiente**
    - Na raiz do projeto, crie um arquivo chamado `.env`.
    - Dentro deste arquivo, adicione sua chave da API da seguinte forma:

    ```
      DB_HOST = INSIRA O NOME DO HOST
      DB_NAME = INSIRA O NOME DO BANCO DE DADOS
      DB_PASSWORD = INSIRA A SENHA DO BANCO DE DADOS
      DB_USER = INSIRA O NOME DO USUÁRIO DO BANCO DE DADOS
    ```

4.  **Configure as variáveis de ambiente:**
    -   Abra o arquivo `src/main/resources/application.properties`.
    -   Adicione as propriedades com as suas credenciais do PostgreSQL:

    ```properties
    # Configuração do Banco de Dados
    spring.datasource.url=jdbc:postgresql://localhost:5432/${DB_NAME}
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PASSWORD}
    ```
5.  **Compile e execute o projeto:**
    -   Abra um terminal na raiz do projeto e execute o comando Maven:
    ```bash
    mvn spring-boot:run
    ```
6.  **Use a aplicação:**
    -   O menu interativo será exibido no console. Siga as instruções para explorar as funcionalidades.

---

## 📂 Estrutura do Projeto

```bash
|───src
    ├───main
        ├───java
        │   └───br
        │       └───com
        │           └───alura
        │               └───literalura
        │                   ├───config
        │                   ├───dto
        │                   ├───model
        │                   ├───principal
        │                   ├───repository
        │                   └───service
        └───resources
            └───db.migration
```

O projeto está organizado nos seguintes pacotes para manter uma arquitetura limpa e desacoplada:

-   `br.com.alura.literalura`: Pacote raiz da aplicação.
    -   `LiterAluraApplication.java`: Classe principal que inicializa o Spring Boot (`@SpringBootApplication`).
-   `br.com.alura.literalura.config`: Classes de configuração de Beans do Spring, como `HttpClient` e `ObjectMapper`.
-   `br.com.alura.literalura.dto`: Data Transfer Objects (Records) para mapear os dados recebidos da API de forma segura.
-   `br.com.alura.literalura.model`: Entidades JPA (`@Entity`) que representam as tabelas do banco de dados (`Livro`, `Autor`).
-   `br.com.alura.literalura.principal`: Contém a classe `Principal`, responsável pela interface com o usuário e pelo menu interativo.
-   `br.com.alura.literalura.repository`: Interfaces do Spring Data JPA (`JpaRepository`) para operações de CRUD no banco de dados.
-   `br.com.alura.literalura.service`: Camada de serviço que contém a lógica de negócio, como consumo da API, conversão de dados e orquestração das operações.

---

## 📃 Licença

Este projeto está licenciado sob a MIT License.

## 👨‍💻 Autor

**Beatriz Christie**

* GitHub: [github.com/biachristie](https://github.com/biachristie)