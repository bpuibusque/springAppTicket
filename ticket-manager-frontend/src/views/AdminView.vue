<template>
  <div>
    <h1>Liste des Tickets</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Titre</th>
          <th>Description</th>
          <th>Status</th>
          <th>Utilisateur</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="ticket in tickets" :key="ticket.id">
          <td>{{ ticket.id }}</td>
          <td>{{ ticket.title }}</td>
          <td>{{ ticket.description }}</td>
          <td>{{ ticket.status }}</td>
          <td>{{ ticket.user.username }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import api from '../api';

export default {
  data() {
    return {
      tickets: []
    };
  },
  async created() {
    try {
      const response = await api.get('/tickets');
      this.tickets = response.data;
    } catch (error) {
      console.error(error);
    }
  }
};
</script>
