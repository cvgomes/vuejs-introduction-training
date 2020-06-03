<template>
  <div id="home-page">
    <TaskList :tasks="tasks" />
  </div>
</template>

<script>
// @ is an alias to /src
import TaskList from "@/components/TaskList";

export default {
  name: "HomePage",
  components: {
    TaskList
  },
  data() {
    return {
      tasks: [
        {
          id: 1,
          title: "Task One",
          completed: false
        },
        {
          id: 2,
          title: "Task Two",
          completed: true
        },
        {
          id: 3,
          title: "Task Three",
          completed: false
        }
      ]
    };
  }
};
</script>

<style scoped>
</style>
