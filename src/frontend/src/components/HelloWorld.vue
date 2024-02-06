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
  await addStudent ({studentName: 'John', studentSurname: 'Doe', subjectId: 0, studentId: 123456});
});

</script>

<template>
  <p>{{helloMessage}}</p>
</template>

<style scoped>

</style>
