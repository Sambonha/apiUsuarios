# 👥 API de Usuários

## 📖 Descrição do Projeto
Aplicação desenvolvida em **[Spring Boot](https://spring.io/projects/spring-boot)** com arquitetura de **API REST**, voltada para o **cadastro, autenticação e gerenciamento de usuários**.  

Tecnologias e recursos utilizados:  
- **[Spring Boot](https://spring.io/projects/spring-boot)** – Criação e configuração automática da aplicação  
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)** – Persistência e mapeamento objeto-relacional  
- **[PostgreSQL](https://www.postgresql.org/)** – Banco de dados relacional  
- **[JWT (JSON Web Token)](https://jwt.io/)** – Autenticação e autorização seguras  
- **[Lombok](https://projectlombok.org/)** – Redução de código boilerplate  
- **[Swagger](https://swagger.io/)** – Documentação interativa da API  
- **[Docker](https://www.docker.com/)** – Containerização da aplicação e banco de dados  
- **[CORS](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/CORS)** – Configuração de acesso entre aplicações frontend e backend  

---

## 🏗️ Organização do Projeto
O projeto segue uma estrutura organizada em camadas, aplicando boas práticas de **arquitetura limpa**:  

- **Entities** → Representam as entidades do domínio (usuário, perfil, etc.)  
- **Repositories** → Interfaces do Spring Data JPA responsáveis pelo acesso ao banco de dados  
- **Services** → Contêm a lógica de negócio e regras de autenticação  
- **Controllers** → Endpoints REST responsáveis por expor os serviços da API  
- **DTOs** → Objetos de transferência de dados para requests e responses  
- **Configurations** → Configurações de segurança, Swagger e CORS  
- **Security** → Implementações de autenticação e geração de tokens JWT  
- **Exceptions** → Tratamento centralizado de erros e respostas personalizadas  

---

## 🔐 Autenticação com JWT
A autenticação é baseada em **JWT (JSON Web Token)**, garantindo segurança e escalabilidade.  
Fluxo de autenticação:  
1. O usuário envia suas credenciais (login e senha) para o endpoint `/api/v1/auth/login`.  
2. O servidor valida as credenciais e gera um **token JWT** assinado.  
3. O token deve ser enviado no cabeçalho `Authorization` em cada requisição subsequente:  
   ```bash
   Authorization: Bearer <token>
   ```
4. O backend valida o token e autoriza o acesso às rotas protegidas.  

---

## 🐳 Execução com Docker
O projeto está preparado para execução em containers Docker.  

### 🧩 Pré-requisitos
- [Docker](https://www.docker.com/get-started) instalado  
- [Docker Compose](https://docs.docker.com/compose/) configurado  

### ▶️ Passos para execução
1. Clone o repositório:  
   ```bash
   git clone https://github.com/seuusuario/apiUsuarios.git
   cd apiUsuarios
   ```
2. Crie e suba os containers:  
   ```bash
   docker-compose up -d
   ```
3. Acesse a aplicação:  
   - API: [http://localhost:8080](http://localhost:8080)  
   - Swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  

---

## 🌱 Teoria: Arquitetura Limpa
A **[Arquitetura Limpa](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)**, proposta por **Robert C. Martin (Uncle Bob)**, organiza o sistema em camadas independentes, separando as **regras de negócio** dos **detalhes de infraestrutura**.  

Princípios principais:  
- **Independência de frameworks** → O domínio não depende de bibliotecas externas.  
- **Testabilidade** → Facilidade para escrever testes unitários.  
- **Independência de interface** → UI pode mudar sem afetar a lógica central.  
- **Independência de banco de dados** → A lógica de negócio não depende do banco escolhido.  

---

## 🧠 Teoria: Spring Boot
O **Spring Boot** simplifica o desenvolvimento de aplicações Java com configuração mínima e integração nativa com o ecossistema Spring.  

Principais benefícios:  
- **Auto Configuration** – Configura automaticamente componentes comuns.  
- **Embedded Server** – Executa a aplicação sem necessidade de deploy externo.  
- **Integração com Spring Security e Data** – Facilita autenticação e persistência.  
- **Production Ready** – Inclui métricas, health checks e monitoramento.  

---
