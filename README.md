# Reservas API

API Spring Boot para gerenciamento de reserva de ingressos com fluxo completo: criar evento → reservar ingresso → confirmar pagamento → obter tickets.

## Tecnologias

- Spring Boot 3.1.5
- Java 17
- Maven
- H2 Database (em memória)
- Docker

## Fluxo de Negócio

1. **Criar Evento** - `POST /events`
2. **Reservar Ingresso** - `POST /events/{eventId}/reservations`
3. **Confirmar Pagamento** - `POST /reservations/{reservationId}/confirm`
4. **Listar Ingressos** - `GET /tickets/{cpf}`

## Endpoints

### Events
- `GET /events` - Lista todos os eventos
- `POST /events` - Cria um novo evento

### Reservations
- `POST /events/{eventId}/reservations` - Cria uma reserva para um evento
- `POST /reservations/{reservationId}/confirm` - Confirma a reserva e processa o pagamento

### Tickets
- `GET /tickets/{cpf}` - Lista ingressos confirmados por CPF

## Como Executar

### Opção 1: Local (Maven)

```bash
# Instale Maven (se não tiver)
brew install maven  # macOS
# ou
apt-get install maven  # Linux

# Execute a aplicação
mvn clean install
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`

### Opção 2: Docker

```bash
# Construa a imagem
docker build -t reservas-api .

# Execute o container
docker run -p 8080:8080 reservas-api
```

### Opção 3: Docker Compose

```bash
# Execute com docker-compose
docker-compose up
```

## Usando a Coleção do Postman

1. Abra o Postman
2. Clique em "Import" no canto superior esquerdo
3. Selecione o arquivo `Reservas-API.postman_collection.json`
4. A coleção será importada com todas as requisições

### Variáveis do Postman

A coleção usa as seguintes variáveis (edite conforme necessário):

- `base_url` - URL base da API (padrão: `http://localhost:8080`)
- `event_id` - ID do evento (atualizado ao criar)
- `reservation_id` - ID da reserva (atualizado ao criar)
- `cpf` - CPF do cliente (padrão: `12345678900`)

## Exemplo de Fluxo no Postman

1. **Criar um Evento**
   - POST `/events`
   - Body: Nome, Data, Total de Ingressos, Preço
   - Copie o `id` retornado

2. **Criar uma Reserva**
   - POST `/events/{id}/reservations`
   - Body: CPF do cliente
   - Copie o `id` retornado

3. **Confirmar a Reserva (com Pagamento)**
   - POST `/reservations/{id}/confirm`
   - Body: Tipo de pagamento (PIX/CREDITO/BOLETO) e dados do pagamento
   - Selecione `CREDITO` ou `PIX` para teste rápido

4. **Listar Ingressos**
   - GET `/tickets/{cpf}`
   - Use o mesmo CPF da reserva

## Tipos de Pagamento

- **PIX** - Requer chave PIX (dados de exemplo: código QR)
- **CREDITO** - Requer número do cartão
- **BOLETO** - Requer número do boleto

## Banco de Dados

A API usa **H2 em memória**, o que significa:

- Dados são armazenados durante a execução
- Ao reiniciar a aplicação, os dados são perdidos
- Console H2 disponível em `http://localhost:8080/h2-console`
  - Usuário: `sa`
  - Senha: (deixe em branco)
  - JDBC URL: `jdbc:h2:mem:reservasdb`

## Estrutura do Projeto

```
projeto-software-2026-2-reservas/
├── src/
│   └── main/
│       ├── java/com/reservas/
│       │   ├── entity/          # Entidades JPA
│       │   ├── repository/      # Interfaces de persistência
│       │   ├── service/         # Lógica de negócio
│       │   ├── controller/      # Endpoints REST
│       │   ├── dto/             # Data Transfer Objects
│       │   └── ReservasApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
├── Dockerfile
├── docker-compose.yml
└── Reservas-API.postman_collection.json
```

## Tratamento de Erros

- **400 Bad Request** - Dados inválidos ou reserva em estado inválido
- **404 Not Found** - Evento ou reserva não encontrada
- **500 Internal Server Error** - Erro no servidor

## Notas

- Ingressos disponíveis são decrementados ao criar uma reserva
- Só é possível confirmar reservas em status PENDING
- O pagamento é registrado mas não é processado (apenas salvo no banco)
- Cada confirmação de pagamento gera um ticket (ingresso confirmado)
