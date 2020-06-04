<template>
  <div id="home-page">
    <AddTask @add-task="addTodo" />
    <TaskList :tasks="tasks" />
  </div>
</template>

<script>
// @ is an alias to /src
import AddTask from "@/components/AddTask";
import TaskList from "@/components/TaskList";

export default {
  name: "HomePage",
  components: {
    AddTask,
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
  },
  methods: {
    addTodo(task) {
      this.tasks.push(task);
    }
  }
};
</script>

<style scoped>
</style>
