<script setup>
  import {ref} from "vue";
  import {useSubject} from "../../composable/useSubject.js";
  import {useGrade} from "../../composable/useGrade.js";

  const studentsWithGrades = ref([]);
  const studentId = ref('');
  const edit = ref(false);

  const {getSubjectsAndGradesForStudent} = useSubject()
  const {updateGradeByGradeId} = useGrade()

  async function _getSubjectsAndGradesForStudent(id) {
    let res = null;
    if (id.length) {
      res = await getSubjectsAndGradesForStudent(id);
    }

    if (res?.flag) {
      studentsWithGrades.value = res?.message;
    }

  }

  async function _updateGradeByGradeId(id, grade) {
    edit.value = false;
    await updateGradeByGradeId(id, grade);
  }
</script>

<template>
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
        <td><input :disabled="edit === false" v-model="record[5]" type="number" name="gradeId" id="gradeId" class="form-input"></td>
        <td>
          <button @click="edit = !edit" class="action-button">Edytuj</button>
          <button @click="async () => {await _updateGradeByGradeId(record[6], record[5])}" class="approve-button" >Zatwierdź</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>

</style>