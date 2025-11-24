# Documentação da API de Tarefas

## Versionamento da API

A API utiliza versionamento por URL para garantir compatibilidade futura. A versão atual é **v1**.

Base URL: `http://localhost:8080/api/v1/tarefas`

## Endpoints

### 1. Listar todas as tarefas

- **GET** `/api/v1/tarefas`
- **Descrição:** Retorna uma lista de todas as tarefas.
- **Resposta:**
  - 200 OK: Lista de tarefas.

### 2. Consultar tarefa por ID

- **GET** `/api/v1/tarefas/{id}`
- **Parâmetros:**
  - `id` (path): ID da tarefa.
- **Resposta:**
  - 200 OK: Objeto da tarefa.
  - 404 Not Found: Tarefa não encontrada.

### 3. Criar nova tarefa

- **POST** `/api/v1/tarefas`
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

- **PUT** `/api/v1/tarefas/{id}`
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

- **DELETE** `/api/v1/tarefas/{id}`
- **Parâmetros:**
  - `id` (path): ID da tarefa.
- **Resposta:**
  - 200 OK: Tarefa excluída.
  - 404 Not Found: Tarefa não encontrada.

---

**Nota:** Para futuras versões, utilize o prefixo `/api/v2/tarefas` e assim por diante.

## Tratamento de Erros

- Quando um recurso não é encontrado: `Erro: Tarefa não encontrada: {id}. Verifique o ID informado.`
- Quando há erro de dados inválidos: `Erro: {mensagem do erro}. Corrija os dados enviados.`
- Para outros erros: `Erro interno. Tente novamente.`
