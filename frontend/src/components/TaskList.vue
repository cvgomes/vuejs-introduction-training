<template>
  <div class="task-list">
    <div v-for="task in tasks" v-bind:key="task.id">
      <TaskItem :task="task" />
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
