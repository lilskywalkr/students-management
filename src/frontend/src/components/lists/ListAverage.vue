<script setup>
  import {ref} from "vue";
  import {useSubject} from "../../composable/useSubject.js";

  const subjectsWithAverageGrades = ref([])
  const {getSubjectsAndAverageGrades} = useSubject()

  async function _getSubjectsAndAverageGrades() {
    const res = await getSubjectsAndAverageGrades();

    if (res.flag) {
      subjectsWithAverageGrades.value = res.message;
    }
  }
</script>

<template>
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

</style>