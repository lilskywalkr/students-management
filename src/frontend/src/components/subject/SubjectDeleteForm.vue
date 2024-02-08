<script setup>
  import {ref} from "vue";
  import {useSubject} from "../../composable/useSubject.js";
  import {useGrade} from "../../composable/useGrade.js";

  // getting crud functions
  const {deleteSubject} = useSubject()
  const {deleteGradeBySubjectId} = useGrade()

  const emit = defineEmits(['handle-result'])

  const oldSubject = ref({ subjectId: 0, subjectName: '' });

  // composable function handling
  async function handleComposable() {
    await deleteGradeBySubjectId(oldSubject.value.subjectId);
    const result = await deleteSubject(oldSubject.value.subjectId);

    emit('handle-result', result);
  }
</script>

<template>
  <div>
    <form class="form-container">
      <h2 class="form-header">Usuń Przedmiot</h2>

      <div class="form-group">
        <label for="subjectId">Id Przedmiotu:</label>
        <input v-model="oldSubject.subjectId" type="text" id="subjectName" class="form-input" required>
      </div>

      <button @click.prevent="async () => {await handleComposable()}" class="form-button">Usuń Przedmiot</button>
    </form>
  </div>
</template>

<style scoped>

</style>