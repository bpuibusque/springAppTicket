<template>
  <div>
    <h2>Users</h2>
    <ul>
      <li v-for="user in users" :key="user.id" @click="selectUser(user)">{{ user.username }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      users: []
    };
  },
  mounted() {
    this.fetchUsers();
  },
  methods: {
    async fetchUsers() {
      try {
        const response = await fetch('http://localhost:8080/api/users');
        if (!response.ok) {
          throw new Error('Network response was not ok ' + response.statusText);
        }
        const data = await response.json();
        if (data) {
          this.users = data;
        } else {
          console.error('No data received from the server');
        }
      } catch (error) {
        console.error('Failed to fetch users:', error);
      }
    },
    selectUser(user) {
      this.$emit('userSelected', user);
    }
  }
};
</script>
