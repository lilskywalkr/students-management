<script setup>
import { ref, onMounted } from 'vue'
import StudentAddForm from "./student/StudentAddForm.vue";
import SubjectAddForm from "./subject/SubjectAddForm.vue";
import GradeAddForm from "./grade/GradeAddForm.vue";
import StudentDeleteForm from "./student/StudentDeleteForm.vue";
import SubjectDeleteForm from "./subject/SubjectDeleteForm.vue";

import {useSubject} from "../composable/useSubject.js";

const studentsWithGrades = ref([]);

const {getSubjectsAndGradesForStudent} = useSubject()

// refs for operation results communication
const message = ref("");

// emit function for handling rest functions result messages
const handleResult = (result) => {
  message.value = result?.message;
};

onMounted(async () => {
  console.log(await getSubjectsAndGradesForStudent(123456));
})

</script>

<template>
  <h1 class="result">{{ message }}</h1>
  <div class="form-wrapper">
    <StudentAddForm @handle-result="handleResult" />
    <StudentDeleteForm @handle-result="handleResult" />

    <SubjectAddForm @handle-result="handleResult" />
    <SubjectDeleteForm @handle-result="handleResult" />

    <GradeAddForm @handle-result="handleResult"/>
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
</template>

<style scoped>
.result {
  text-align: center;
  padding: 2vw;
  font-size: 3vw;
  color: #fff;
  letter-spacing: 0.7vw;
}

.form-wrapper {
  width: 100vw;
  display: flex;
  justify-content: space-around;
  flex-flow: row wrap;
}
</style>

