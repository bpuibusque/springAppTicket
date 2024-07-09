<template>
  <div>
    <h2>Users</h2>
    <ul>
      <li v-for="user in users" :key="user.id">{{ user.username }}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      users: []
    };
  },
  created() {
    axios.get('http://localhost:8080/api/users')
      .then(response => {
        this.users = response.data;
      })
      .catch(error => {
        console.error('There was an error fetching the users!', error);
      });
  }
};
</script>
