<script setup>
import { ref, onMounted } from 'vue'
import StudentAddForm from "./student/StudentAddForm.vue";
import SubjectAddForm from "./subject/SubjectAddForm.vue";
import GradeAddForm from "./grade/GradeAddForm.vue";
import StudentDeleteForm from "./student/StudentDeleteForm.vue";
import SubjectDeleteForm from "./subject/SubjectDeleteForm.vue";
import {useSubject} from "../composable/useSubject.js";

const {getSubjectsAndGradesForStudent, getSubjectsAndAverageGrades} = useSubject()

const studentsWithGrades = ref([]);
const subjectsWithAverageGrades = ref([])

const studentId = ref('');

// refs for operation results communication
const message = ref("");

// emit function for handling rest functions result messages
const handleResult = (result) => {
  message.value = result?.message;
};

async function _getSubjectsAndGradesForStudent(id) {
  let res = null;
  if (id.length) {
    res = await getSubjectsAndGradesForStudent(id);
  }

  if (res?.flag) {
    studentsWithGrades.value = res?.message;
  }

}

async function _getSubjectsAndAverageGrades() {
  const res = await getSubjectsAndAverageGrades();

  if (res.flag) {
    subjectsWithAverageGrades.value = res.message;
  }
}

onMounted(async () => {
  //console.log(await getSubjectsAndGradesForStudent(123456));
  //console.log(await getSubjectsAndAverageGrades());
})

</script>

<template>
  <h1 class="result">{{ message }}</h1>
  <div class="form-wrapper">
    <StudentAddForm @handle-result="handleResult" />
    <GradeAddForm @handle-result="handleResult"/>
    <SubjectAddForm @handle-result="handleResult" />

    <StudentDeleteForm @handle-result="handleResult" />
    <SubjectDeleteForm @handle-result="handleResult" />
  </div>

  <div class="list-container">
    <h2 class="list-header">Lista przedmiotów z ocenami dla studenta</h2>

    <form>
      <label for="studentId">Id Studenta:</label>
      <input v-model="studentId" type="text" id="studentId" class="form-input">
      <button @click.prevent="async () => {await _getSubjectsAndGradesForStudent(studentId)}" class="form-button">Wybierz Studenta</button>
    </form>

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

      <tr v-for="(record, index) in studentsWithGrades" :key="index">
        <td>{{ record[0] }}</td>
        <td>{{ record[1] }}</td>
        <td>{{ record[2] }}</td>
        <td>{{ record[3] }}</td>
        <td>{{ record[4] }}</td>
        <td>{{ record[5] }}</td>
        <td>
          <button @click="" class="action-button">Edytuj</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>

  <div class="list-container">
    <h2 class="list-header">Lista przedmiotów ze średnią ocen</h2>

    <form>
      <button @click.prevent="async () => {await _getSubjectsAndAverageGrades()}" class="form-button">Wyświetl Przedmioty</button>
    </form>

    <table class="table">
      <thead>
      <tr>
        <th>ID Przedmiotu</th>
        <th>Nazwa Przedmiotu</th>
        <th>Średnia ocen</th>
      </tr>
      </thead>
      <tbody>

      <tr v-for="(record, index) in subjectsWithAverageGrades" :key="index">
        <td>{{ record[0] }}</td>
        <td>{{ record[1] }}</td>
        <td>{{ record[2] }}</td>
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
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  gap: 1vw;
  flex-flow: row wrap;
}
</style>

