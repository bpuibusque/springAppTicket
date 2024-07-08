<template>
  <div>
    <h2>Tickets pour {{ user.username }}</h2>
    <ul>
      <li v-for="ticket in tickets" :key="ticket.id">{{ ticket.description }} - {{ ticket.status }}</li>
    </ul>
  </div>
</template>

<script>
import api from '../api';

export default {
  props: ['user'],
  data() {
    return {
      tickets: []
    };
  },
  async created() {
    try {
      const response = await api.get(`/tickets/user/${this.user.id}`);
      this.tickets = response.data;
    } catch (error) {
      console.error(error);
    }
  }
};
</script>
