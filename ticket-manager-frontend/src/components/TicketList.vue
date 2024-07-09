<template>
  <div>
    <h2>Tickets</h2>
    <ul>
      <li v-for="ticket in tickets" :key="ticket.id">
        {{ ticket.title }} - {{ ticket.description }} - {{ ticket.status }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      tickets: []
    };
  },
  created() {
    axios.get('http://localhost:8080/api/tickets')
      .then(response => {
        this.tickets = response.data;
      })
      .catch(error => {
        console.error('There was an error fetching the tickets!', error);
      });
  }
};
</script>
