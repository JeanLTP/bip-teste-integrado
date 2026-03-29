# BFF Benefit Module 🎯

**Backend for Frontend - Módulo de Benefícios**

## 📋 Descrição

O **BFF Benefit Module** é um serviço de Backend for Frontend (BFF) desenvolvido em Spring Boot que funciona como um intermediário entre o frontend Angular e o microserviço de backend de benefícios. Este padrão arquitetural permite que o frontend se comunique com uma única API, enquanto o BFF orquestra as chamadas para o backend.

## 🏗️ Arquitetura

```
Frontend (Angular)
    ↓
BFF Benefit Module (Porta 8080)
    ↓
MS Benefit Module (Porta 8081)
```

### Camadas do Projeto

- **Resource**: Expõe endpoints REST para o frontend
- **Facade**: Orquestra as chamadas para o backend (padrão Facade)
- **Infrastructure/Client**: Cliente Feign para comunicação HTTP com o backend
- **Domain**: Modelos de dados (DTOs)

## 🚀 Como Usar

### Pré-requisitos

- Java 17+
- Maven 3.6+
- ms-benefit-module rodando na porta 8081

### Instalação e Execução

1. **Navegue até o diretório do projeto**:
   ```bash
   cd bff-benefit-module
   ```

2. **Compile o projeto**:
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em: `http://localhost:8080`

## 📡 Endpoints Disponíveis

### Benefícios

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| **GET** | `/api/v1/beneficios` | Lista todos os benefícios |
| **POST** | `/api/v1/beneficios` | Cria um novo benefício |
| **GET** | `/api/v1/beneficios/{id}` | Obtém benefício por ID |
| **PUT** | `/api/v1/beneficios/{id}` | Atualiza um benefício |

## 🔧 Configuração

### application.properties

```ini
# URL do backend de benefícios
benefit.backend.url=http://localhost:8081
```

## 📦 Dependências Principais

| Dependência | Versão | Propósito |
|-------------|--------|----------|
| Spring Boot | 3.2.5 | Framework web |
| Spring Cloud OpenFeign | - | Cliente HTTP declarativo |
| Spring Data JPA | - | Persistência de dados |
| H2 Database | - | Banco de dados em memória (testes) |
| Lombok | - | Redução de código boilerplate |
| Swagger/OpenAPI | 2.6.0 | Documentação da API |
| WireMock | 3.0.0 | Mock de serviços (testes) |
| REST Assured | - | Testes de integração |

## 🧪 Testes

Execute os testes com:

```bash
mvn test
```

Os testes utilizam **WireMock** para mockar as respostas do backend e **REST Assured** para facilitar os testes de integração.

### Estrutura de Testes

- `src/test/resources/wiremock/mappings/`: Definição dos mocks
- `src/test/resources/wiremock/__files/`: Arquivos de resposta JSON

## 🔌 Cliente Feign

O projeto utiliza **Spring Cloud OpenFeign** para comunicação com o backend:

```java
@FeignClient(name = "benefitBackend", url = "${benefit.backend.url}")
public interface BenefitClient {
    // Métodos para chamar endpoints do backend
}
```

## 📝 Padrão de Resposta

### Sucesso (2xx)
```json
{
  "id": 1,
  "name": "Vale Refeição",
  "description": "Benefício de refeição"
}
```

### Erro (4xx/5xx)
```json
{
  "error": "Descrição do erro",
  "timestamp": "2026-03-29T10:30:00Z"
}
```

## 🛠️ Ferramentas Complementares

### Swagger/OpenAPI
Acesse a documentação interativa em:
```
http://localhost:8080/swagger-ui.html
```

### H2 Console (Testes)
Durante a execução de testes, H2 oferece um console em:
```
http://localhost:8080/h2-console
```

## 📚 Estrutura de Diretórios

```
bff-benefit-module/
├── src/
│   ├── main/
│   │   ├── java/com/example/bff/
│   │   │   ├── BackendForFrontendApplication.java
│   │   │   ├── BeneficioController.java
│   │   │   ├── application/
│   │   │   │   └── facade/
│   │   │   │       └── BenefitFacade.java
│   │   │   ├── domain/
│   │   │   │   └── model/
│   │   │   │       └── BenefitDTO.java
│   │   │   └── infrastructure/
│   │   │       ├── client/
│   │   │       │   └── BenefitClient.java
│   │   │       └── exception/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/...
│       └── resources/
│           └── wiremock/
│               ├── mappings/
│               └── __files/
├── pom.xml
└── README.md
```

## 🤝 Integração com o Frontend

O frontend Angular se comunica com o BFF através de HTTP:

```typescript
// Exemplo de chamada do frontend
this.http.get('http://localhost:8080/api/v1/beneficios')
```

O BFF então redireciona a chamada para o backend:

```
GET http://localhost:8081/benefits
```

## 🐛 Troubleshooting

| Problema | Solução |
|----------|---------|
| Erro de conexão ao backend | Verifique se ms-benefit-module está rodando na porta 8081 |
| Porta 8080 já em uso | Configure `server.port` em application.properties |
| Dependency resolution failed | Execute `mvn clean install -U` |

## 📖 Documentação Adicional

- [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
- [Spring Boot REST](https://spring.io/guides/gs/rest-service/)
- [Padrão BFF](https://samnewman.io/patterns/architectural/bff/)

## 📝 Licença

Este projeto faz parte do desafio fullstack integrado da BIP.

---

**Última atualização**: 2026-03-29



