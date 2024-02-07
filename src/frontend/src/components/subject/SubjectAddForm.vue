<script setup>
  import {ref} from "vue";
  import {useSubject} from "../../composable/useSubject.js";

  // getting crud functions
  const {addSubject} = useSubject()

  const emit = defineEmits(['handle-result'])

  const newSubject = ref({ subjectId: 0, subjectName: '' });

  // composable function handling
  async function handleComposable() {
    const result = await addSubject({
      subjectId: newSubject.value.subjectId,
      subjectName: newSubject.value.subjectName
    });

    emit('handle-result', result);
  }
</script>

<template>
  <div>
    <form class="form-container">
      <h2 class="form-header">Dodaj Przedmiot</h2>

      <div class="form-group">
        <label for="subjectId">Id Przedmiotu:</label>
        <input v-model="newSubject.subjectId" type="text" id="subjectName" class="form-input" required>
      </div>

      <div class="form-group">
        <label for="subjectName">Nazwa Przedmiotu:</label>
        <input v-model="newSubject.subjectName" type="text" id="subjectName" class="form-input" required>
      </div>

      <button @click.prevent="async () => {await handleComposable()}" class="form-button">Dodaj Przedmiot</button>
    </form>
  </div>
</template>

<style scoped>

</style>