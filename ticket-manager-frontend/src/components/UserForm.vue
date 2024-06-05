<template>
  <div>
    <h2>Create User</h2>
    <form @submit.prevent="createUser">
      <input v-model="username" placeholder="Username" required />
      <input v-model="password" type="password" placeholder="Password" required />
      <button type="submit">Create User</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async createUser() {
      const response = await fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: this.username, password: this.password })
      });
      if (response.ok) {
        this.username = '';
        this.password = '';
        this.$emit('userCreated');
      }
    }
  }
};
</script>
