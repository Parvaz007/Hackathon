// Base URL of your backend
const BASE_URL = "http://localhost:8080";

// ---------------- REGISTER ----------------
async function register() {
    const username = document.getElementById("reg-username").value;
    const email = document.getElementById("reg-email").value;
    const password = document.getElementById("reg-password").value;

    const response = await fetch(`${BASE_URL}/auth/register`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username, email, password})
    });

    if (response.ok) {
        alert("Registration successful!");
        window.location.href = "login.html";
    } else {
        alert("Error registering user");
    }
}

// ---------------- LOGIN ----------------
async function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const response = await fetch(`${BASE_URL}/auth/login`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({email, password})
    });

    if (!response.ok) {
        alert("Invalid credentials");
        return;
    }

    alert("Login successful!");

    // Save email to local storage
    localStorage.setItem("email", email);

    // Fetch student ID
    const studentResp = await fetch(`${BASE_URL}/student/by-email/${email}`);
    if (!studentResp.ok) {
        alert("Could not fetch student details. Contact admin.");
        return;
    }

    const student = await studentResp.json();
    localStorage.setItem("studentId", student.id);

    window.location.href = "exam.html";
}

// ---------------- ADD TOPIC FIELD ----------------
function addTopic() {
    const div = document.createElement("div");
    div.innerHTML = `
        <input class="topicName" type="text" placeholder="Topic Name">
        <input class="correct" type="number" placeholder="Correct">
        <input class="wrong" type="number" placeholder="Wrong">
        <hr>
    `;
    document.getElementById("topics").appendChild(div);
}

// ---------------- SUBMIT EXAM ----------------
async function submitExam() {

    const studentId = localStorage.getItem("studentId");
    if (!studentId) {
        alert("Student ID missing! Please login again.");
        return;
    }

    const subject = document.getElementById("subject").value;
    const marksObt = parseInt(document.getElementById("marksObt").value);
    const marksTotal = parseInt(document.getElementById("marksTotal").value);
    const date = document.getElementById("date").value;

    const topicNames = document.getElementsByClassName("topicName");
    const correct = document.getElementsByClassName("correct");
    const wrong = document.getElementsByClassName("wrong");

    let topics = [];
    for (let i = 0; i < topicNames.length; i++) {
        topics.push({
            topicName: topicNames[i].value,
            correct: parseInt(correct[i].value),
            wrong: parseInt(wrong[i].value)
        });
    }

    const body = {
        studentId,
        subject,
        marksObt,
        marksTotal,
        date,
        topics
    };

    const response = await fetch(`${BASE_URL}/exam/add`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(body)
    });

    if (response.ok) {
        alert("Exam added successfully!");
    } else {
        alert("Error adding exam");
    }
}

// ---------------- LOAD WEAK TOPICS ----------------
async function loadWeakTopics() {
    const studentId = localStorage.getItem("studentId");

    const response = await fetch(`${BASE_URL}/exam/weak-topics/${studentId}`);
    const data = await response.json();

    const div = document.getElementById("weakTopics");
    div.innerHTML = "";

    data.forEach(t => {
        div.innerHTML += `
            <p><b>${t.topicName}</b> — Accuracy: ${t.accuracy.toFixed(2)}%</p>
        `;
    });
}

// ---------------- LOAD STUDY PLAN (LLM) ----------------
async function loadStudyPlan() {

    const studentId = localStorage.getItem("studentId");

    const response = await fetch(`${BASE_URL}/ai/study-plan/${studentId}`);
    const text = await response.text();

    document.getElementById("plan").innerText = text;
}
