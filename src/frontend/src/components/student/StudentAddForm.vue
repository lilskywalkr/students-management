<script setup>
  import {ref} from "vue";
  import {useStudent} from "../../composable/useStudent.js";

  // getting crud functions
  const {addStudent} = useStudent();

  const emit = defineEmits(['handle-result'])

  const newStudent = ref({ studentId: 0, studentName: '', studentSurname: ''});

  // composable function handling
  async function handleComposable() {
    const result = await addStudent({
      studentName: newStudent.value.studentName,
      studentSurname: newStudent.value.studentSurname,
      studentId: newStudent.value.studentId
    });

    emit('handle-result', result);
  }
</script>

<template>
  <div>
    <form class="form-container">
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

      <button @click.prevent="async () => { await handleComposable() }" class="form-button">Dodaj Studenta</button>
    </form>
  </div>
</template>

<style scoped>

</style>