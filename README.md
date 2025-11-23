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

<img src="screenshots/login.png" alt="Login" width="49%"/> <img src="screenshots/add-exam.png" alt="Add Exam" width="49%"/>
<img src="screenshots/weak-topics.png" alt="Weak Topics" width="49%"/> <img src="screenshots/study-plan.png" alt="Study Plan" width="49%"/>
<img src="screenshots/credits.png" alt="Credits" width="100%"/>

---

### How to Run Locally

#### 1. Start Ollama + Model
```bash
# Install Ollama: https://ollama.com/download
ollama pull gemma2:2b
ollama serve
