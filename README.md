# Payment System - Criptopay

## Descrição

O **Payment System** é um sistema de pagamentos robusto e flexível, em desenvolvimento, utilizando Java 17 com o framework Spring. O objetivo principal do projeto é fornecer uma API para realizar transferências diretas financeiras comuns, como pagamento por credito, debito e pix, como tambem de criptomoedas, integrando tecnologias modernas para garantir escalabilidade, segurança e facilidade de uso.

**ESTE REPOSITÓRIO PÚBLICO POSSUI FUNÇÕES LIMITADAS POR SER DE INTUITO DEMONSTRATIVO**

---

## Tecnologias Utilizadas até o momento

- **Java 17**: Linguagem principal para o desenvolvimento do sistema.
- **Spring Framework**: Framework usado para facilitar o desenvolvimento e a manutenção do projeto.
- **PostgreSQL**: Banco de dados relacional para armazenar informações das transações e usuários.
- **Docker**: Gerenciamento de contêineres para simplificar a configuração e a execução do ambiente do sistema.
- **Swagger**: Ao iniciar a aplicação, acesse http://localhost:8080/swagger-ui/ para ter acesso a documentação da aplicação.
---

## Funcionalidades (em desenvolvimento)
- **Transferências Financeira**: 
  - API permitirá a trasferencia financeira comum por meio dos End points específicos, como ```/credito``` e ```/debito```
  

- **Transferências Diretas de Criptomoedas**: 
  - API que permite realizar transferências de criptomoedas de forma rápida e segura entre contas.
  - Suporte a várias criptomoedas (funcionalidade planejada para futuras versões).
  
- **Autenticação e Autorização**:
  - Sistema de segurança robusto para proteger as transações e os dados do usuário (em progresso).

---

## Configuração do Ambiente

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Swagger](https://swagger.io/)

### Passo a Passo

1. Clone o repositório:

   ```bash
   git clone https://github.com/ThallesDaniel/payment-system.git
   cd payment-system
   ```

2. Configure as variáveis de ambiente necessárias no arquivo `application.properties` (localizado em `src/main/resources`):

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/payment_system
   spring.datasource.username=seu_usuario 
   spring.datasource.password=sua_senha
   #os dados de usuários são de acordo com o seus
   ```

3. Construa o projeto com Maven:

   ```bash
   mvn clean install
   ```

4. Execute o sistema com Docker:

   ```bash
   docker-compose up --build
   ```

---

## Endpoints Principais (em desenvolvimento)

| Método | Endpoint              | Descrição                                |
|--------|-----------------------|------------------------------------------|
| POST   | `/api/v1/user/register`       | Realiza o registro do usuário no sistema. |
| POST   | `/api/v1/auth/login`       | Realiza o login no sistema. |
| GET   | `/api/v1/user/verify`       | utilizada para verificar se o email é valido no sistema. |
| POST   | `/api/v1/transfer/cripto`       | Realiza transferência direta de criptomoedas. |
| POST   | `/api/v1/transfer/credito`       | Realiza transferência via cartão de crédito. |
| POST   | `/api/v1/transfer/debito`       | Realiza transferência via cartão de débito. |
| POST   | `/api/v1/transfer/pix`       | Realiza transferência via pix. |
| GET    | `/api/v1/transactions`   | Lista todas as transações realizadas.   |

---

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir **Issues** ou enviar um **Pull Request** com sugestões, melhorias ou correções.

---

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## Contato

Para mais informações, entre em contato:

- **Autor**: Thalles Daniel
- **E-mail**: contato@thallesdaniel.com
