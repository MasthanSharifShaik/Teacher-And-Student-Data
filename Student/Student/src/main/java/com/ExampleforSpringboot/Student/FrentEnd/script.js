// === Base URLs ===
const studentUrl = "http://localhost:8080/student";
const teacherUrl = "http://localhost:8080/teacher/add";

// === Tab Switching ===
function showTab(tab) {
  document.getElementById("studentSection").classList.add("hidden");
  document.getElementById("teacherSection").classList.add("hidden");
  document.getElementById("studentTab").classList.remove("active");
  document.getElementById("teacherTab").classList.remove("active");

  if (tab === "student") {
    document.getElementById("studentSection").classList.remove("hidden");
    document.getElementById("studentTab").classList.add("active");
  } else {
    document.getElementById("teacherSection").classList.remove("hidden");
    document.getElementById("teacherTab").classList.add("active");
  }
}

// === Student Functions ===
async function addStudent() {
  const name = document.getElementById("studentName").value;
  const age = document.getElementById("studentAge").value;
  if (!name || !age) return alert("Fill all fields!");

  const response = await fetch(studentUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, age })
  });
  alert(await response.text());
  getAllStudents();
}

async function getStudent() {
  const id = document.getElementById("studentId").value;
  if (!id) return alert("Enter an ID!");
  const res = await fetch(`${studentUrl}/${id}`);
  alert(await res.text());
}

async function getAllStudents() {
  try {
    const res = await fetch("http://localhost:8080/student/all");
    if (!res.ok) throw new Error("Failed to fetch students");

    const text = await res.text();
    const list = document.getElementById("studentList");
    list.innerHTML = "";

    if (!text.trim()) {
      list.innerHTML = "<li>No students found</li>";
      return;
    }

    // Split each student by blank lines or markers
    const studentBlocks = text.split("\n\n").filter(block => block.trim());

    studentBlocks.forEach(block => {
      const div = document.createElement("div");
      div.classList.add("student-block");

      const lines = block.split("\n").filter(line => line.trim());
      lines.forEach(line => {
        if (!line.toLowerCase().includes("here all student details")) {
          const p = document.createElement("p");
          p.textContent = line.trim();
          div.appendChild(p);
        }
      });


      list.appendChild(div);
    });
  } catch (err) {
    alert("Error loading students: " + err.message);
  }
}

// === Teacher Functions ===
async function addTeacher() {
  const name = document.getElementById("teacherName").value;
  const studentIdsInput = document.getElementById("teacherStudentIds").value;

  if (!name) return alert("Enter teacher name!");

  const studentIds = studentIdsInput
    ? studentIdsInput.split(",").map(id => parseInt(id.trim())).filter(id => !isNaN(id))
    : [];

  const response = await fetch(teacherUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, studentIds })
  });

  const text = await response.text();
  alert(text);
  document.getElementById("teacherName").value = "";
  document.getElementById("teacherStudentIds").value = "";
  getAllTeachers();
}

async function getTeacher() {
  const id = document.getElementById("teacherId").value;
  if (!id) return alert("Enter an ID!");

  try {
    const res = await fetch(`http://localhost:8080/teacher/${id}`);
    if (!res.ok) throw new Error("Teacher not found");
    const text = await res.text();
    alert(text);
  } catch (err) {
    alert("Error fetching teacher: " + err.message);
  }
}

async function getAllTeachers() {
  try {
    const res = await fetch("http://localhost:8080/teacher/all");
    if (!res.ok) throw new Error("No teachers found");

    const text = await res.text();
    const list = document.getElementById("teacherList");
    list.innerHTML = "";

    if (!text.trim()) {
      list.innerHTML = "<li>No teachers found</li>";
      return;
    }

    // Split teacher blocks by double newlines
    const teacherBlocks = text.split("\n\n").filter(block => block.trim());

    teacherBlocks.forEach(block => {
      const teacherDiv = document.createElement("div");
      teacherDiv.classList.add("teacher-block");

      // Split each teacher block into lines
      const lines = block.split("\n").filter(line => line.trim());

      lines.forEach(line => {
        const p = document.createElement("p");
        p.textContent = line;

        // Style students with indent
        if (line.trim().startsWith("Student")) {
          p.classList.add("student-line");
        }
        teacherDiv.appendChild(p);
      });

      list.appendChild(teacherDiv);
    });
  } catch (err) {
    alert("Error loading teacher list: " + err.message);
  }
}

// === Delete Student ===
async function deleteStudent() {
  const id = document.getElementById("deleteStudentId").value;
  if (!id) return alert("Enter a Student ID to delete!");

  try {
    const res = await fetch(`http://localhost:8080/student/${id}`, {
      method: "DELETE"
    });

    const text = await res.text();
    alert(text);
    document.getElementById("deleteStudentId").value = "";
    getAllStudents();
  } catch (err) {
    alert("Error deleting student: " + err.message);
  }
}

// === Delete Teacher ===
async function deleteTeacher() {
  const id = document.getElementById("deleteTeacherId").value;
  if (!id) return alert("Enter a Teacher ID to delete!");

  try {
    const res = await fetch(`http://localhost:8080/teacher/${id}`, {
      method: "DELETE"
    });

    const text = await res.text();
    alert(text);
    document.getElementById("deleteTeacherId").value = "";
    getAllTeachers();
  } catch (err) {
    alert("Error deleting teacher: " + err.message);
  }
}

