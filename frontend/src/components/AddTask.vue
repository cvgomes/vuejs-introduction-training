<template>
  <div>
    <form @submit.prevent="addTask">
      <input type="text" name="title" placeholder="Add Task ..." v-model="title" />
      <input type="submit" value="Submit" class="btn" />
    </form>
  </div>
</template>

<script>
export default {
  name: "AddTask",
  data() {
    return {
      title: ""
    };
  },
  methods: {
    addTask() {
      if(this.title === ""){
        return;
      }
      const newTask = {
        title: this.title,
        completed: false
      };
      this.$emit("add-task", newTask);
      this.title = "";
    }
  }
};
</script>

<style scoped>
form {
  display: flex;
}
input[type="text"] {
  flex: 9;
  padding: 5px;
}
input[type="submit"] {
  flex: 1;
}
.btn {
  display: inline-block;
  border: none;
  background: #555;
  color: #fff;
  padding: 7px 20px;
  cursor: pointer;
}
.btn:hover {
  background: #666;
}
</style>
