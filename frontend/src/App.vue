<template>
  <div id="app">
    <PageHeader />
    <router-view/>
  </div>
</template>

<script>
import PageHeader from './components/PageHeader';
export default {
  name: 'app',
  components: {
    PageHeader
  }
};
</script>

<style>
</style>
