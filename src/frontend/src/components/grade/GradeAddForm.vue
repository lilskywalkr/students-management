<script setup>
  import {ref} from "vue";
  import {useGrade} from "../../composable/useGrade.js";

  // getting crud functions
  const {addGrade} = useGrade();

  const emit = defineEmits(['handle-result'])

  const newGrade = ref({  studentId: 0, subjectId: 0, grade: 0 });

  // composable function handling
  async function handleComposable() {
    const result = await addGrade({
      studentId: newGrade.value.studentId,
      subjectId: newGrade.value.subjectId,
      grade: newGrade.value.grade
    });

    emit('handle-result', result);
  }
</script>

<template>
  <div>
    <form class="form-container">
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
        <input v-model="newGrade.grade" type="number" id="grade" class="form-input" required>
      </div>

      <button @click.prevent="async () => {await handleComposable()}" class="form-button">Dodaj Oceny</button>
    </form>
  </div>
</template>

<style scoped>

</style>