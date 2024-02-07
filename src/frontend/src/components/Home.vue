<script setup>
import { ref, onMounted } from 'vue'

const newStudent = ref({ student_id: 0,studentId: 0, student_name: '', student_surname: '', subject_id: 0 });
const newSubject = ref({ subjectId: 0, subjectName: '' });
const newGrade = ref({ grade_id: 0, studentId: 0, subjectId: 0, grade: 0 });

onMounted(async () => {

});

</script>

<template>
  <div>
    <!-- Formularz dodawania studenta -->
    <form @submit.prevent="addStudentForm" class="form-container">
      <h2 class="form-header">Dodaj Studenta</h2>
      <div class="form-group">
        <label for="studentId">Numer Albumu:</label>
        <input v-model="newStudent.studentId" type="text" id="studentId" class="form-input" required>
      </div>
      <div class="form-group">
        <label for="studentName">Imię:</label>
        <input v-model="newStudent.studentName" type="text" id="studentName" class="form-input" required>
      </div>
      <div class="form-group">
        <label for="studentSurname">Nazwisko:</label>
        <input v-model="newStudent.studentSurname" type="text" id="studentSurname" class="form-input" required>
      </div>
      <div class="form-group">
        <label for="subjectId">ID Przedmiotu:</label>
        <input v-model="newStudent.subjectId" type="number" id="subjectId" class="form-input" required>
      </div>
      <button type="submit" class="form-button">Dodaj Studenta</button>
    </form>

    <!-- Formularz dodawania przedmiotu -->
    <div>
      <form @submit.prevent="addSubjectForm" class="form-container">
        <h2 class="form-header">Dodaj Przedmiot</h2>
        <div class="form-group">
          <label for="subjectId">Id Przedmiotu:</label>
          <input v-model="newSubject.subjectId" type="text" id="subjectName" class="form-input" required>
        </div>
        <div class="form-group">
          <label for="subjectName">Nazwa Przedmiotu:</label>
          <input v-model="newSubject.subjectName" type="text" id="subjectName" class="form-input" required>
        </div>
        <button type="submit" class="form-button">Dodaj Przedmiot</button>
      </form>
    </div>

    <div>
      <!-- Formularz dodawania oceny -->
      <form @submit.prevent="addGradeForm" class="form-container">
        <h2 class="form-header">Dodaj Oceny</h2>
        <div class="form-group">
          <label for="studentId">Id Studenta:</label>
          <input v-model="newGrade.studentId" type="text" id="studentId" class="form-input" required>
        </div>
        <div class="form-group">
          <label for="subjectId">Id Przedmiotu:</label>
          <input v-model="newGrade.subjectId" type="text" id="subjectId" class="form-input" required>
        </div>
        <div class="form-group">
          <label for="grade">Ocena:</label>
          <input v-model="newGrade.grade" type="text" id="grade" class="form-input" required>
        </div>
        <button type="submit" class="form-button">Dodaj Oceny</button>
      </form>
    </div>

    <!-- Lista studentów z ocenami -->
    <div class="list-container">
      <h2 class="list-header">Lista Studentów z Ocena</h2>
      <table class="table">
        <thead>
        <tr>
          <th>ID Studenta</th>
          <th>Imię</th>
          <th>Nazwisko</th>
          <th>ID Przedmiotu</th>
          <th>Nazwa Przedmiotu</th>
          <th>Ocena</th>
          <th>Akcje</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="record in studentsWithGrades" :key="record.student_id">
          <td>{{ record.studentId }}</td>
          <td>{{ record.student_name }}</td>
          <td>{{ record.student_surname }}</td>
          <td>{{ record.subjectId }}</td>
          <td>{{ record.subjectName }}</td>
          <td>{{ record.grade }}</td>
          <td>
            <button @click="removeStudent(record.student_id)" class="action-button">Usuń</button>
            <button @click="editRecord(record)" class="action-button">Edytuj</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<style scoped>
.form-container {
  max-width: 400px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
}

.form-header {
  font-size: 1.5em;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

.form-input {
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.form-button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.action-button {
  background-color: #f44336;
  color: white;
  padding: 5px 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
.list-container {
  margin-top: 30px;
}

.list-header {
  font-size: 1.5em;
  margin-bottom: 10px;
}

.table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

.table th, .table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.table th {
  background-color: #4CAF50;
  color: white;
}

.table td {
  background-color: #f9f9f9;
}
</style>

