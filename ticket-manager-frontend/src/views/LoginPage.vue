<template>
  <div>
    <h2>Connexion</h2>
    <form @submit.prevent="login">
      <input v-model="username" placeholder="Nom d'utilisateur" required />
      <input v-model="password" type="password" placeholder="Mot de passe" required />
      <button type="submit">Connexion</button>
    </form>
  </div>
</template>

<script>
import api from '../api';

export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async login() {
      try {
        const response = await api.post('/users/login', {
          username: this.username,
          password: this.password
        });
        localStorage.setItem('user', JSON.stringify(response.data));
        this.$router.push('/');
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>
