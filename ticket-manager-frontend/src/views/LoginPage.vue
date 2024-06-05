<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div>
        <label for="username">Username</label>
        <input type="text" v-model="username" required />
      </div>
      <div>
        <label for="password">Password</label>
        <input type="password" v-model="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
      <div id="app">
      <nav>
        <router-link to="/register">Register</router-link>
      </nav>
      <router-view/> 
      </div>
</div>
</template>

<script>
export default {
  name: 'LoginPage',
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async login() {
      try {
        const response = await fetch('http://localhost:8080/api/users/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ username: this.username, password: this.password })
        });
        if (response.ok) {
          const user = await response.json();
          localStorage.setItem('user', JSON.stringify(user));
          this.$router.push('/');
        } else {
          alert('Login failed');
        }
      } catch (error) {
        console.error('Failed to login:', error);
        alert('Login failed');
      }
    }
  }
};
</script>

<style scoped>
/* Ajoutez ici vos styles pour cette page */
</style>
