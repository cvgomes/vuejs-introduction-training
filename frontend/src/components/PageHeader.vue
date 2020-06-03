<template>
  <header id="page-header-cmp">
      <h1>Tasks</h1>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link>
      </nav>
  </header>
</template>

<script>
export default {
  name: 'PageHeader',
};
</script>

<style scoped>
    header {
        background: #333;
        color: #fff;
        text-align: center;
        padding: 10px;
    }
    header h1 {
        margin-top: 8px;
        margin-bottom: 8px;
    }
    header a {
        color: #fff;
        padding: 3px;
    }
    nav a {
        color: #ccc;  
    }
    nav a.router-link-exact-active {
        font-weight: bold;
        color: #fff;  
    }
</style>
