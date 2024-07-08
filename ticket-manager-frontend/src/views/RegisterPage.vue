<template>
  <div>
    <h2>Inscription</h2>
    <form @submit.prevent="register">
      <input v-model="username" placeholder="Nom d'utilisateur" required />
      <input v-model="password" type="password" placeholder="Mot de passe" required />
      <button type="submit">Inscription</button>
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
    async register() {
      try {
        await api.post('/users/register', {
          username: this.username,
          password: this.password
        });
        this.$router.push('/login');
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>
