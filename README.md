# Gestão de Funcionários

Este é um projeto de um sistema simples para gerenciamento de funcionários, desenvolvido para fins de estudo e portfólio. A aplicação permite realizar operações básicas de CRUD (Create, Read, Update, Delete) para os funcionários.

## ✨ Funcionalidades

- [x] **Listar** todos os funcionários cadastrados.
- [x] **Buscar** um funcionário específico por seu ID.
- [x] **Adicionar** um novo funcionário ao sistema.
- [x] **Atualizar** as informações de um funcionário existente.
- [x] **Remover** um funcionário do sistema.

## 🛠️ Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias:

- **Java 8**: Linguagem de programação principal.
- **Spring Boot 2.5.1**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Para facilitar o acesso e a persistência de dados.
- **Thymeleaf**: Motor de templates para renderizar o frontend.
- **MySQL**: Banco de dados relacional.
- **Maven**: Ferramenta para gerenciamento de dependências e build do projeto.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar a aplicação em seu ambiente local.

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
- [JDK 8 ou superior](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven 3.6 ou superior](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- [MySQL](https://dev.mysql.com/downloads/installer/)

### Passos

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/gestaofuncionario.git
   cd gestaofuncionario
   ```

2. **Configure o Banco de Dados:**
   - Crie um banco de dados no seu servidor MySQL (ex: `gestao_funcionarios`).
   - Abra o arquivo `src/main/resources/application.properties`.
   - Atualize as propriedades de conexão com suas credenciais:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/gestao_funcionarios
     spring.datasource.username=seu_usuario_mysql
     spring.datasource.password=sua_senha_mysql
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Compile e instale as dependências com o Maven:**
   ```bash
   mvn clean install
   ```

4. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a aplicação:**
   A aplicação estará rodando em `http://localhost:8080`. Como o projeto utiliza Thymeleaf, você pode acessar as páginas web diretamente no seu navegador.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.


 
