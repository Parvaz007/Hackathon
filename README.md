# Hackathon
1st Hackathon
# ResultWise — Your AI-Powered Study Coach

[![Spring Boot + Ollama](https://img.shields.io/badge/Powered%20by-Spring%20Boot%20%2B%20Ollama-6DB33F)](https://spring.io/projects/spring-boot)

**Turn your exam results into a personalized study revolution.**

ResultWise is a beautiful, modern, and blazing-fast web app that analyzes your exam performance, identifies your **weak topics**, and generates **AI-powered study plans** — instantly.

Built with **Spring Boot**, **Ollama (local AI)**, and caffine.

---

### Features

- Add exams with detailed topic-wise performance
- Visual doughnut charts showing accuracy per topic
- AI-generated personalized study plans (powered by `gemma2:2b`)
- Lightning-fast local inference (no API keys, no cloud)
- Stunning glassmorphism UI with gradient magic
- Fully responsive — works perfectly on mobile & desktop
- Secure login & session management
- "Credits" page featuring Sir ChatGPT & Sir Grok

---

### Tech Stack

| Layer        | Technology                                      |
|--------------|--------------------------------------------------|
| Backend      | Spring Boot (Java)                               |
| Frontend     | HTML, CSS, JavaScript (Vanilla + Chart.js)      |
| AI Engine    | [Ollama](https://ollama.com) + `gemma2:2b`       |
| Database     | Neon Serverless Postgres |
| UI Design    | Glassmorphism + Gradient Animations              |

---

### Screenshots
### LOGIN
<img src="screenshot/Screenshot 2025-11-23 110051.png" alt="Login" width="100%"/> 

### CREDITS
<img src="screenshot/Screenshot 2025-11-23 110247.png" alt="Credits" width="100%"/>

### BREAKDOWN
<img src="screenshot/Screenshot 2025-11-23 110922.png" alt="Weak Topics" width="100%"/> 

### AI-POWERED STUDY PLAN
<img src="screenshot/Screenshot 2025-11-23 111214.png" alt="Study Plan" width="100%"/>


---

### How to Run Locally

```bash
# 1. Clone the repository
https://github.com/Parvaz007/Hackathon.git
cd H4akathon

# 2. Start Ollama + the fast AI model (runs locally, no internet needed after download)
ollama pull gemma2:2b
ollama run gemma2:2b "hello"
# Keep this terminal running (or run in background)

# 3. Start the Spring Boot backend
cd backend
./mvnw spring-boot:run
# On Windows, use: mvnw spring-boot:run

# 4.Start the frontend in VS-code via live-server extension
