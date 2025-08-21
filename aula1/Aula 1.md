# Aula 1 - Resumo

## Criação do Projeto Spring Boot
- Utilizamos o Spring Initializr para gerar a estrutura básica do projeto.
- O projeto foi criado com as seguintes configurações:
  - Linguagem: Java
  - Build tool: Maven
  - Versão do Java: 17 ou superior
  - Dependências principais: Spring Web

## Estrutura do Projeto
- O projeto segue a estrutura padrão do Spring Boot:
  - `src/main/java`: código-fonte principal
  - `src/main/resources`: arquivos de configuração e recursos
  - `src/test/java`: testes automatizados

## Implementação de Exemplo
- Criamos o controller `ExemploController` para expor endpoints REST.
- Implementamos um endpoint de soma que recebe dois números e retorna o resultado.
- Criamos a classe `SomaDTO` para transferir os dados da soma.

## Execução e Testes
- O projeto foi executado localmente usando o comando `./mvnw spring-boot:run`.
- Testamos os endpoints utilizando ferramentas como Postman ou o navegador.

## Versionamento
- O projeto foi versionado com Git e o commit inicial foi realizado.

---

Esses foram os principais tópicos abordados na Aula 1, incluindo a criação, estruturação e primeiros testes de um projeto Spring Boot.
