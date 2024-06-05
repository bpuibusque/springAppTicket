<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link>
      <router-link to="/admin">Admin</router-link>
      <router-link to="/user">User</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style>
nav {
  margin-bottom: 20px;
}
nav a {
  margin: 0 10px;
}
</style>
