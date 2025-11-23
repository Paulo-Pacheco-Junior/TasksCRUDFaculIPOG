# Documentação da API de Tarefas

Base URL: `http://localhost:8080/ctask/`

## Endpoints

### 1. Listar todas as tarefas

- **GET** `/task`
- **Descrição:** Retorna uma lista de todas as tarefas.
- **Resposta:**
  - 200 OK: Lista de tarefas.

### 2. Consultar tarefa por ID

- **GET** `/task/{id}`
- **Parâmetros:**
  - `id` (path): ID da tarefa.
- **Resposta:**
  - 200 OK: Objeto da tarefa.
  - 404 Not Found: Tarefa não encontrada.

### 3. Criar nova tarefa

- **POST** `/task`
- **Body:**

```json
{
  "title": "Título da tarefa",
  "description": "Descrição da tarefa",
  "completed": false
}
```

- **Resposta:**
  - 200 OK: Objeto da tarefa.

### 4. Atualizar tarefa existente

- **PUT** `/task/{id}`
- **Parâmetros:**
  - `id` (path): ID da tarefa.
- **Body:**

```json
{
  "title": "Novo título",
  "description": "Nova descrição",
  "completed": true
}
```

- **Resposta:**
  - 200 OK: Objeto da tarefa.
  - 404 Not Found: Tarefa não encontrada.

### 5. Excluir tarefa

- **DELETE** `/task/{id}`
- **Parâmetros:**
  - `id` (path): ID da tarefa.
- **Resposta:**
  - 200 OK: Tarefa excluída.
  - 404 Not Found: Tarefa não encontrada.
