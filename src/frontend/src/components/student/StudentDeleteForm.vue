<script setup>
  import {ref} from "vue";
  import {useStudent} from "../../composable/useStudent.js";
  import {useGrade} from "../../composable/useGrade.js";

  // getting crud functions
  const {deleteStudent} = useStudent();
  const {deleteGradeByStudentId} = useGrade()

  const emit = defineEmits(['handle-result'])

  const oldStudent = ref({ studentId: 0});

  // composable function handling
  async function handleComposable() {
    await deleteGradeByStudentId(oldStudent.value.studentId);
    const result = await deleteStudent(oldStudent.value.studentId);

    emit('handle-result', result);
  }
</script>

<template>
  <div>
    <form class="form-container">
      <h2 class="form-header">Usuń Studenta</h2>

      <div class="form-group">
        <label for="studentId">Numer Albumu:</label>
        <input v-model="oldStudent.studentId" type="text" id="studentId" class="form-input" required>
      </div>

      <button @click.prevent="async () => { await handleComposable() }" class="form-button">Usuń Studenta</button>
    </form>
  </div>
</template>

<style scoped>

</style>