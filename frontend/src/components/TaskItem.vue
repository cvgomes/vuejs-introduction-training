<template>
  <div class="task-item" :class="{'is-complete':task.completed}" @click="markComplete">
    {{task.title}}
    <button class="del" @click.stop="$emit('delete-task')">X</button>
  </div>
</template>

<script>
export default {
  name: "TaskItem",
  props: ["task"],
  methods: {
    markComplete() {
      this.task.completed = ! this.task.completed;
    }
  }
};
</script>

<style scoped>
.task-item {
  background: #f4f4f4;
  padding: 10px;
  border-bottom: 1px #ccc dotted;
  user-select: none;
}
.is-complete {
  text-decoration: line-through;
}
.del {
  background: #f00;
  color: #fff;
  border: none;
  padding: 5px 9px;
  border-radius: 50%;
  cursor: pointer;
  float: right;
}
</style>
