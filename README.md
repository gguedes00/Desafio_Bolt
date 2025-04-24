# ⚡ Bolt - Desafio Técnico

Sistema completo para ingestão e visualização dos 5 maiores geradores de energia elétrica do Brasil, baseado em dados abertos da ANEEL.

---

## 🧩 Tecnologias Utilizadas

### Backend
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Agendamento com `@Scheduled`
- Apache Commons CSV

### Frontend
- React 18 + Vite
- Tailwind CSS
- Axios

## 🚀 Como Executar

### 🛠 Backend (Spring Boot)

1. Configure o PostgreSQL e atualize o `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bolt
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
csv.import.url=https://dadosabertos.aneel.gov.br/path/to/ralie-usina.csv
```

2. Compile e execute:

```bash
cd BoltBackend
./mvnw clean install
./mvnw spring-boot:run
```

A API estará disponível em:  
📍 `http://localhost:8080/usina/top5`

---

### 💻 Frontend (React)

```bash
cd BoltFrontend
npm install
npm run dev
```

Acesse:  
📍 `http://localhost:5173`

---

## 📆 Job de Extração de Dados

A aplicação realiza automaticamente a extração dos dados abertos da ANEEL, em formato CSV, com as seguintes características:

- **Execução inicial automática** assim que a aplicação estiver pronta (via `ApplicationReadyEvent`)
- **Execução periódica** agendada a cada 1 hora usando a anotação `@Scheduled` com expressão `cron`
- A URL do CSV é parametrizada via `application.properties`, permitindo fácil alteração da fonte de dados

O processo de extração consiste em:

1. Download do CSV da ANEEL
2. Parse e tratamento dos dados utilizando **Apache Commons CSV**
3. Mapeamento para entidades JPA
4. Persistência no banco de dados PostgreSQL

Logs informativos indicam o sucesso ou falha de cada importação.

---

## 📡 API - Exposição de Dados

O backend expõe uma API RESTful que retorna os **5 maiores geradores de energia elétrica**, ordenados por potência outorgada.

### `GET /usina/top5`

- Retorna uma lista com os 5 maiores geradores
- Usa os dados extraídos e persistidos no banco
- Endpoint implementado com **Spring Web + Service Layer**, garantindo separação de responsabilidades e escalabilidade

#### Exemplo de resposta:

```json
[
  {
    "nomeEmpreendimento": "Usina X",
    "potenciaOrtorgadaMW": 9999.99,
    "modeloUsina": "Hidráulica",
    "uf": "SP"
  }
]
```

---

## 📝 Sobre

Este projeto foi desenvolvido como parte de um **desafio técnico**.

---

## 👨‍💻 Desenvolvido por

**Gabriel Guedes**
