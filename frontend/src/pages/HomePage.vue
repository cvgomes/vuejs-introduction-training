<template>
  <div id="home-page">
    <AddTask @add-task="addTask" />
    <TaskList :tasks="tasks" @delete-task="deleteTask"/>
  </div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";
import AddTask from "@/components/AddTask";
import TaskList from "@/components/TaskList";
import ConfigService from "@/services/ConfigService.js";

export default {
  name: "HomePage",
  components: {
    AddTask,
    TaskList
  },
  created(){
    axios.get("http://localhost:8080/tasks").then((response) => {
      this.tasks = response.data;
    })
  },
  data() {
    return {
      tasks: []
    };
  },
  methods: {
    addTask(task) {
      axios.post(ConfigService.api_url, task).then((response) => {
        this.tasks.push(response.data);
      })      
    },
    deleteTask(id) {
      axios.delete("http://localhost:8080/tasks/" + id).then(() => {
        this.tasks = this.tasks.filter(task => task.id !== id);
      });      
    }
  }
};
</script>

<style scoped>
</style>
