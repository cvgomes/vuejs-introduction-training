<template>
  <div id="app">
    <PageHeader />
    <router-view />
  </div>
</template>

<script>
// @ is an alias to /src
import PageHeader from "@/components/PageHeader";
export default {
  name: "app",
  components: {
    PageHeader
  }
};
</script>

<style>
</style>
