<template>
  <div>
    <h2>Tickets for {{ user.username }}</h2>
    <ul>
      <li v-for="ticket in tickets" :key="ticket.id">{{ ticket.description }} - {{ ticket.status }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  props: ['user'],
  data() {
    return {
      tickets: []
    };
  },
  mounted() {
    this.fetchTickets();
  },
  methods: {
    async fetchTickets() {
      try {
        const response = await fetch(`http://localhost:8080/api/tickets/user/${this.user.id}`);
        if (!response.ok) {
          throw new Error('Network response was not ok ' + response.statusText);
        }
        const data = await response.json();
        if (data) {
          this.tickets = data;
        } else {
          console.error('No data received from the server');
        }
      } catch (error) {
        console.error('Failed to fetch tickets:', error);
      }
    }
  }
};
</script>
