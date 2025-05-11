# 📍 Spotline

![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-brightgreen?logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-blue?logo=docker)
![Render](https://img.shields.io/badge/Deploy-Render-4E5D94?logo=render&logoColor=white)

Rastreamento de localização em tempo real via navegador.  
Construído com **Java + Spring Boot**, persiste localizações com `latitude`, `longitude`, `timestamp` e `userId` único por dispositivo. Ideal para estudo de geolocalização, backends com banco de dados e integração Docker/Render.

---

## 🚀 Tecnologias

- ✅ Java 21
- ✅ Spring Boot 3.4.5
- ✅ Spring Data JPA + Hibernate
- ✅ PostgreSQL
- ✅ Docker + Docker Compose
- ✅ Leaflet.js (mapas)
- ✅ Render (deploy gratuito)

---

## 📦 Rodando localmente com Docker Compose

1. Clone o projeto:

```bash
git clone https://github.com/andregnicoletti/spotline.git
cd spotline
```

2. Copie o arquivo de variáveis:

```bash
cp .env.local .env
```

3. Suba tudo com:

```bash
docker-compose --.env-file .env up --build
```

4. Acesse no navegador:

```
http://localhost:8080
```

A localização será enviada a cada minuto e salva no PostgreSQL.

---

## 🌍 Deploy gratuito no Render

### 1. Suba o projeto no GitHub
### 2. Crie um serviço Web no [https://render.com](https://render.com)
- Use o `Dockerfile` da raiz (já configurado com `-DskipTests`)
- Configure as variáveis de ambiente:

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://<host>:<port>/<database>
SPRING_DATASOURCE_USERNAME=<user>
SPRING_DATASOURCE_PASSWORD=<password>
```

Use a aba "Connection Details" do banco PostgreSQL no Render para obter esses valores.

---

## 🧭 Identificação Automática

O frontend gera um `userId` único (UUID) por dispositivo usando `localStorage`. Não precisa passar `userId` na URL.

```javascript
const userId = crypto.randomUUID(); // gerado 1x por navegador
```

---

## 🗺️ Visualização de Mapa

- A página `index.html` exibe um mapa com a posição atual
- Mapa renderizado com **Leaflet.js**
- Atualizações a cada 60 segundos automaticamente

---

## 🛡️ Segurança e Privacidade

- Nenhuma informação pessoal é coletada
- Apenas `userId`, coordenadas e timestamp são salvos

---

## 🧑‍💻 Autor

Desenvolvido com dedicação por **André Nicoletti**  
Contato: [LinkedIn](https://www.linkedin.com/in/seu-usuario)

---

🔥 Powered by Spring Boot • PostgreSQL • Docker • Render
