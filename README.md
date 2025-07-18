# 🚀 Encurtador de URL - API

API simples e eficiente para encurtar URLs, desenvolvida com **Spring Boot** e **MongoDB**.

---

## 📚 Endpoints

### 🔗 1. Encurtar URL

- **URL:** `/api/shorten-url`
- **Método:** `POST`
- **Body:** JSON
    ```json
    {
      "url": "https://github.com/vinisnzy"
    }
    ```
- **Resposta:** 
    ```json
    {
      "url": "http://localhost:8080/ABC123"
    }
    ```
- **Observação:** URLs encurtadas expiram automaticamente após **2 horas** da criação.

### ↩️ 2. Redirecionar para URL original

- **URL:** `/{id}`
- **Método:** `GET`
- **Descrição:** Redireciona para a URL original correspondente ao ID informado.

---

## ⚙️ Como rodar o projeto

1. **Clone o repositório:**
    ```
    git clone https://github.com/vinisnzy/url-shortener.git
    ```
2. **Entre na pasta do projeto:**
    ```
    cd url-shortener
    ```
3. **Configure o MongoDB:**
    - Certifique-se de que o MongoDB está rodando localmente na porta padrão (`mongodb://localhost:27017`).
    - Ou ajuste a string de conexão em `application.yml` conforme necessário.


4. **Compile e execute:**
    ```
    ./mvnw spring-boot:run
    ```
5. **Acesse a API:**  
   [http://localhost:8080](http://localhost:8080)

---

## 💡 Exemplos de uso

### Encurtar uma URL

```bash
curl -X POST http://localhost:8080/api/shorten-url \
     -H "Content-Type: application/json" \
     -d '{"url":"https://www.google.com"}'
```

### Redirecionar

Acesse no navegador:  
`http://localhost:8080/{id}`

---

## 🛠️ Tecnologias utilizadas

- **Java 21**
- **Spring Boot**
- **MongoDB**
- **Maven**

---

## ✨ Sobre

Este projeto foi desenvolvido para demonstrar uma API REST de encurtamento de URLs, utilizando persistência em **MongoDB** para armazenar os dados de forma simples e escalável.

---

