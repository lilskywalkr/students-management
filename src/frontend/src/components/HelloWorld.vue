<script setup>
import { ref, onMounted } from 'vue'

const props = defineProps(['msg']);
const helloMessage = ref('');

onMounted(() => {
  fetch("api/messages/hello").then(res => res.text()).then((data) => {helloMessage.value = data});
});

</script>

<template>
  <h1>{{ props.msg }}</h1>
  <p>{{helloMessage}}</p>
</template>

<style scoped>

</style>
