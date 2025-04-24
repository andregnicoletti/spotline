# Spotline

Spotline é um projeto em Spring Boot com uma página HTML estática para capturar a localização de um usuário via navegador e enviar para um endpoint backend.

## Tecnologias

- Java 21 ou superior (projeto usa Java 24)
- Spring Boot 3.4.5
- Maven
- HTML + JavaScript (Geolocation API)

## Como funciona

1. Um HTML é servido automaticamente pela aplicação (`src/main/resources/static/index.html`).
2. Ao acessar a página, o usuário pode permitir o acesso à sua localização.
3. A localização é enviada para `POST /webhook/location` com os dados `latitude`, `longitude` e `timestamp`.

---

## Executar localmente

### 1. Clonar o projeto

```bash
git clone https://github.com/seuusuario/spotline.git
cd spotline
```

### 2. Rodar localmente

```bash
./mvnw spring-boot:run
```

Acesse: `http://localhost:8080/`

---

## Publicar no Render.com

### 1. Suba seu projeto para o GitHub

- Certifique-se de que o repositório está no GitHub (pode ser privado ou público).

### 2. Crie um Web Service no Render

- Acesse: [https://render.com](https://render.com)
- Clique em **New > Web Service**
- Escolha seu repositório GitHub com o projeto

### 3. Configure o deploy

- **Environment**: Java
- **Build Command**: `./mvnw clean install`
- **Start Command**: `java -jar target/spotline-0.0.1-SNAPSHOT.jar`
- Porta: o Render detecta automaticamente (`8080`)

### 4. Acesse sua aplicação online

Depois do deploy, você receberá um link HTTPS seguro como:

```
https://spotline.onrender.com
```

E o HTML estará acessível direto na raiz:

```
https://spotline.onrender.com/
```

---

## Melhorias futuras

- Armazenar localizações recebidas em banco de dados
- Exibir as localizações em mapa (Leaflet.js, Google Maps)
- Proteger acesso com autenticação/token
- Logar IP e user-agent para auditoria

---

Feito com ❤️ por [André Nicoletti](https://github.com/seuusuario)