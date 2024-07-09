<template>
  <div id="app">
    <UsersList />
    <TicketsList />
  </div>
</template>

<script>
import UsersList from './components/UserList.vue';
import TicketsList from './components/TicketList.vue';

export default {
  name: 'App',
  components: {
    UsersList,
    TicketsList
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
