<template>
  <div class="task-list">
    <div v-for="task in tasks" :key="task.id">
      <TaskItem :task="task" @delete-task="$emit('delete-task', task.id)"/>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import TaskItem from "@/components/TaskItem";

export default {
  name: "TaskList",
  components: {
    TaskItem
  },
  props: ["tasks"]
};
</script>

<style scoped>

</style>
