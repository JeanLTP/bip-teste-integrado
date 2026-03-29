# MS Benefit Module 🏦

**Microserviço de Benefícios - Backend**

## 📋 Descrição

O **MS Benefit Module** é um microserviço desenvolvido em Spring Boot responsável por gerenciar a lógica de negócio relacionada a benefícios. Este módulo expõe uma API REST completa para operações de CRUD e oferece suporte a transferências de benefícios entre contas.

Este microserviço é consumido pelo **BFF Benefit Module**, que atua como intermediário com o frontend.

## 🏗️ Arquitetura

O projeto segue a arquitetura em **camadas** com padrões enterprise:

```
Presentation Layer (REST Controllers)
        ↓
Application/Service Layer
        ↓
Domain Layer (Business Logic)
        ↓
Infrastructure Layer (Database, Repositories)
        ↓
Database (H2)
```

### Camadas do Projeto

- **Resource**: Controllers REST que expõem os endpoints
- **Service**: Lógica de negócio e orquestração
- **Domain**: Entidades e modelos de dados
- **Repository**: Acesso a dados (JPA)
- **Mapping**: Conversão entre entidades e DTOs (MapStruct)

## 🚀 Como Usar

### Pré-requisitos

- Java 17+
- Maven 3.6+
- Banco de dados H2 (já incluído)

### Instalação e Execução

1. **Navegue até o diretório do projeto**:
   ```bash
   cd ms-benefit-module
   ```

2. **Compile o projeto**:
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em: `http://localhost:8081`

## 📡 Endpoints Disponíveis

### Benefícios - CRUD

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| **POST** | `/benefits` | Cria um novo benefício | ✅ |
| **GET** | `/benefits` | Lista todos os benefícios | ✅ |
| **GET** | `/benefits/{id}` | Obtém benefício por ID | ✅ |
| **PUT** | `/benefits/{id}` | Atualiza um benefício existente | ✅ |

## 🔧 Configuração

### application.properties

```ini
# Porta do servidor
server.port=8081

# Configuração do banco de dados H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Configuração JPA/Hibernate
spring.jpa.hibernate.ddl-auto=none
spring.jpa.defer-datasource-initialization=true

# Console H2
spring.h2.console.enabled=true
spring.jpa.show-sql=true
```

### Banco de Dados

O projeto utiliza **H2 Database** (banco de dados em memória). Os scripts de inicialização estão em:

- `src/main/resources/schema.sql`: Criação de tabelas
- `src/main/resources/data.sql`: Dados iniciais (seeds)

## 📦 Dependências Principais

| Dependência | Versão | Propósito |
|-------------|--------|----------|
| Spring Boot | 3.2.5 | Framework web |
| Spring Data JPA | - | Persistência de dados |
| H2 Database | - | Banco de dados em memória |
| MapStruct | 1.5.5.Final | Mapeamento de objetos |
| Lombok | - | Redução de código boilerplate |
| Swagger/OpenAPI | 2.6.0 | Documentação da API |
| Spring Boot Test | - | Testes unitários |

## 🧪 Testes

Execute os testes com:

```bash
mvn test
```

Os testes cobrem:
- ✅ Testes unitários de serviço
- ✅ Testes de integração de repositório
- ✅ Testes de endpoint REST

## 🗂️ Estrutura de Diretórios

```
ms-benefit-module/
├── src/
│   ├── main/
│   │   ├── java/com/example/backend/
│   │   │   ├── BackendApplication.java
│   │   │   ├── domain/
│   │   │   │   ├── entity/
│   │   │   │   │   └── BenefitEntity.java
│   │   │   │   ├── model/
│   │   │   │   │   └── BenefitDTO.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── BenefitService.java
│   │   │   │   │   └── impl/
│   │   │   │   │       └── BenefitServiceImpl.java
│   │   │   │   ├── resource/
│   │   │   │   │   ├── BenefitResource.java
│   │   │   │   │   └── impl/
│   │   │   │   │       └── BenefitResourceImpl.java
│   │   │   │   └── mapping/
│   │   │   │       └── BenefitMapper.java
│   │   │   └── infrastructure/
│   │   │       └── repository/
│   │   │           └── BenefitRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── schema.sql
│   │       └── data.sql
│   └── test/
│       └── java/...
├── pom.xml
└── README.md
```

## 💡 Padrões de Projeto Utilizados

### 1. **Service Layer Pattern**
- `BenefitService`: Interface que define o contrato
- `BenefitServiceImpl`: Implementação da lógica de negócio

### 2. **Repository Pattern**
- Acesso aos dados através de `BenefitRepository` (JPA)

### 3. **Data Transfer Object (DTO)**
- `BenefitDTO`: Objeto para transferência de dados entre camadas

### 4. **Mapper Pattern**
- `BenefitMapper`: Conversão entre `BenefitEntity` e `BenefitDTO` usando MapStruct

### 5. **Resource/Controller Pattern**
- `BenefitResource`: Interface que define os endpoints
- `BenefitResourceImpl`: Implementação dos endpoints

## 📝 Exemplo de Uso

### Criar um novo benefício
```bash
curl -X POST http://localhost:8081/benefits \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Vale Refeição",
    "description": "Benefício de refeição para colaboradores"
  }'
```

Resposta:
```json
{
  "id": 1
}
```

### Listar todos os benefícios
```bash
curl -X GET http://localhost:8081/benefits
```

Resposta:
```json
[
  {
    "id": 1,
    "name": "Vale Refeição",
    "description": "Benefício de refeição para colaboradores"
  },
  {
    "id": 2,
    "name": "Vale Transporte",
    "description": "Benefício de transporte"
  }
]
```

### Buscar benefício por ID
```bash
curl -X GET http://localhost:8081/benefits/1
```

### Atualizar benefício
```bash
curl -X PUT http://localhost:8081/benefits/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Vale Refeição Premium",
    "description": "Benefício de refeição premium"
  }'
```

## 🔐 Segurança

### Validações Implementadas

- ✅ Validação de entrada em DTOs (annotations do Jakarta)
- ✅ Tratamento de exceções
- ✅ Verificação de integridade de dados

## 📊 Modelos de Dados

### BenefitEntity
```java
@Entity
public class BenefitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column
    private String description;
}
```

### BenefitDTO
```java
@Data
public class BenefitDTO {
    private Long id;
    private String name;
    private String description;
}
```

## 🛠️ Ferramentas Complementares

### Swagger/OpenAPI
Acesse a documentação interativa em:
```
http://localhost:8081/swagger-ui.html
```

### H2 Console
Acesse o console do banco de dados em:
```
http://localhost:8081/h2-console
```

**Credenciais:**
- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: (deixe em branco)

## 🚀 Fluxo de Integração com o BFF

```
1. Frontend faz requisição para BFF (porta 8080)
   GET /api/v1/beneficios
   
2. BFF recebe a requisição e a encaminha para o Microserviço (porta 8081)
   GET /benefits
   
3. Microserviço processa e retorna o resultado
   
4. BFF retorna a resposta para o Frontend
```

## 🐛 Troubleshooting

| Problema | Solução |
|----------|---------|
| Erro ao conectar ao banco de dados | Verifique se H2 está configurado em `application.properties` |
| Porta 8081 já em uso | Configure `server.port` em application.properties |
| Tabelas não existem | Execute `mvn clean install` para criar as tabelas com base em `schema.sql` |
| MapStruct não gera mappers | Adicione `@Mapper` à interface e use `mvn clean install` |

## 📈 Performance

- Banco em memória (H2) para desenvolvimento rápido
- Índices em chaves primárias
- Consultas otimizadas com JPA

## 📖 Documentação Adicional

- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MapStruct](https://mapstruct.org/)
- [OpenAPI 3.0](https://spec.openapis.org/oas/v3.0.0)
- [H2 Database](https://www.h2database.com/)

## 🔄 Fluxo de Dados

```
Request HTTP
    ↓
BenefitResource (Controller)
    ↓
BenefitService (Lógica de Negócio)
    ↓
BenefitRepository (Dados)
    ↓
H2 Database
    ↓
BenefitMapper (Conversão)
    ↓
BenefitDTO (Resposta)
```

## 📝 Licença

Este projeto faz parte do desafio fullstack integrado da BIP.

---

**Última atualização**: 2026-03-29

