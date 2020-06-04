<template>
  <div>
    <form>
      <input type="text" name="title" placeholder="Add Task ..." />
      <input type="submit" value="Submit" class="btn" />
    </form>
  </div>
</template>

<script>
export default {
  name: "AddTask"
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
