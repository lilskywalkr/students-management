<script setup>
import { ref, onMounted } from 'vue'

const helloMessage = ref('');

// Function to add a student
async function addStudent(studentData) {
  try {
    const res = await fetch("http://localhost:8080/api/students/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(studentData),
    });

    if (res.ok) {
      helloMessage.value = "Student added successfully!";
    } else {
      helloMessage.value = "Failed to add student";
      console.log(res);
    }
  } catch (err) {
    console.error("An error occurred: " + err.messages);
  }
}

// Function for deleting a student
async function deleteStudent(studentId) {
  try {
    const res = await fetch(`http://localhost:8080/api/students/${studentId}`, {
      method: "DELETE",
    });

    if (res.ok) {
      helloMessage.value = "Student deleted successfully!";
    } else {
      helloMessage.value = "Failed to delete student";
    }
  } catch (err) {
    console.error("An error occurred: " + err.message);
  }
}

// Function for adding a subject
async function addSubject(subjectData) {
  try {
    const res = await fetch("http://localhost:8080/api/subjects/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(subjectData),
    });

    if (res.ok) {
      helloMessage.value = "Subject added successfully!";
    } else {
      helloMessage.value = "Failed to add Subject";
      console.log(res);
    }
  } catch (err) {
    console.error("An error occurred: " + err.messages);
  }
}


// Function for deleting a subject
async function deleteSubject(subjectId) {
  try {
    const res = await fetch(`http://localhost:8080/api/subjects/${subjectId}`, {
      method: "DELETE",
    });

    if (res.ok) {
      helloMessage.value = "Subject deleted successfully!";
    } else {
      helloMessage.value = "Failed to delete subject";
    }
  } catch (err) {
    console.error("An error occurred: " + err.message);
  }
}

// Function for getting all subjects
async function getAllSubjects() {
  try {
    const res = await fetch("http://localhost:8080/api/subjects/get", {
      method: "GET",
    });

    if (res.ok) {
      console.log(await res.json());
      helloMessage.value = "Subjects fetched successfully!";
    } else {
      helloMessage.value = "Failed to fetch Subjects";
      console.log(res);
    }
  } catch (err) {
    console.error("An error occurred: " + err.messages);
  }
}

// Function for getting a specific object
async function getSubjectById(subjectId) {
  try {
    const res = await fetch(`http://localhost:8080/api/subjects/${subjectId}`, {
      method: "GET",
    });

    if (res.ok) {
      console.log(await res.json());
      helloMessage.value = "Subject fetched successfully!";
    } else {
      helloMessage.value = "Failed to fetch Subject";
      console.log(res);
    }
  } catch (err) {
    console.error("An error occurred: " + err.messages);
  }
}

// Function for adding a grade
async function addGrade(gradeData) {
  try {
    const res = await fetch("http://localhost:8080/api/grades/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(gradeData),
    });

    if (res.ok) {
      helloMessage.value = "Grade added successfully!";
    } else {
      helloMessage.value = "Failed to add grade";
      console.log(res);
    }
  } catch (err) {
    console.error("An error occurred: " + err.messages);
  }
}

async function deleteGradeBySubjectId(subjectId) {
  try {
    const res = await fetch(`http://localhost:8080/api/grades/${subjectId}`, {
      method: "DELETE",
    });

    if (res.ok) {
      helloMessage.value = "Grade deleted successfully!";
    } else {
      helloMessage.value = "Failed to delete grade";
    }
  } catch (err) {
    console.error("An error occurred: " + err.message);
  }
}

async function deleteGradeByStudentId(studentId) {
  try {
    const res = await fetch(`http://localhost:8080/api/grades/std/${studentId}`, {
      method: "DELETE",
    });

    if (res.ok) {
      helloMessage.value = "Grades deleted successfully!";
    } else {
      helloMessage.value = "Failed to delete grades";
    }
  } catch (err) {
    console.error("An error occurred: " + err.message);
  }
}


// testing connection
async function hello() {
  try {
    const res = await fetch("api/students/hello", {method: "GET"});
    helloMessage.value = await res.text();
  } catch (err) {
    console.error("An error occurred: " + err.messages);
  }
}

onMounted(async () => {
  //await hello();
  //await addStudent ({studentName: 'John', studentSurname: 'Doe', subjectId: 0, studentId: 123456});
});

</script>

<template>
  <p>{{helloMessage}}</p>

  <button @click="addStudent ({studentName: 'John', studentSurname: 'Doe', studentId: 123456})">Add John Doe</button><br>
  <button @click="deleteStudent(111222)">Delete Steve Smith</button><br>
  <button @click="addSubject({subjectId: 0, subjectName: 'English'})">Add English</button><br>
  <button @click="addSubject({subjectId: 1, subjectName: 'German'})">Add German</button><br>
  <button @click="deleteSubject(0)">Delete English</button><br>
  <button @click="getAllSubjects()">Get all subject</button><br>
  <button @click="getSubjectById(1)">Get the German</button><br>
  <button @click="addGrade({studentId: 123456, subjectId: 0, grade: 4})">Add grade 4 in English for John</button><br>
  <button @click="addGrade({studentId: 123456, subjectId: 0, grade: 5})">Add grade 5 in English for John</button><br>
  <button @click="addGrade({studentId: 123456, subjectId: 1, grade: 5})">Add grade 5 in German for John</button><br>
  <button @click="deleteGradeBySubjectId(0)">Delete English grades for students</button><br>
  <button @click="deleteGradeByStudentId(123456)">Delete all grades for John</button><br>
</template>

<style scoped>

</style>
