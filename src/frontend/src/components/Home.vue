<script setup>
import { ref } from 'vue'
import StudentAddForm from "./student/StudentAddForm.vue";
import SubjectAddForm from "./subject/SubjectAddForm.vue";
import GradeAddForm from "./grade/GradeAddForm.vue";
import StudentDeleteForm from "./student/StudentDeleteForm.vue";
import SubjectDeleteForm from "./subject/SubjectDeleteForm.vue";
import ListAll from "./lists/ListAll.vue";
import ListAverage from "./lists/ListAverage.vue";

const studentId = ref('');

// refs for operation results communication
const message = ref("");

// emit function for handling rest functions result messages
const handleResult = (result) => {
  message.value = result?.message;
};

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

  <ListAll />
  <ListAverage />

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

