<script setup>
import { ref, onMounted } from 'vue'

const helloMessage = ref('');

// testing connection
async function hello() {
  try {
    const res = await fetch("api/messages/hello", {method: "GET"});
    helloMessage.value = await res.text();
  } catch (err) {
    console.error("An error occurred: " + err.messages);
  }
}

onMounted(async () => {
  await hello();
});

</script>

<template>
  <p>{{helloMessage}}</p>
</template>

<style scoped>

</style>
