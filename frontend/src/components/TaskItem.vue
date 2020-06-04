<template>
  <div class="task-item" :class="{'is-complete':task.completed}">{{task.title}}</div>
</template>

<script>
export default {
  name: "TaskItem",
  props: ["task"]
};
</script>

<style scoped>
.task-item {
  background: #f4f4f4;
  padding: 10px;
  border-bottom: 1px #ccc dotted;
}
.is-complete {
  text-decoration: line-through;
}
</style>
