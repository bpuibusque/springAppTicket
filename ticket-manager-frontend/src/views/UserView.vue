<template>
  <div>
    <h1>User View</h1>
    <ticket-form :user="user" @ticketCreated="fetchTickets"></ticket-form>
    <user-tickets :user="user" ref="userTickets"></user-tickets>
  </div>
</template>

<script>
import TicketForm from '../components/TicketForm.vue';
import UserTickets from '../components/UserTickets.vue';

export default {
  name: 'UserView',
  components: {
    TicketForm,
    UserTickets
  },
  data() {
    return {
      user: {
        id: 1, 
        username: 'baba'
      }
    };
  },
  methods: {
    fetchTickets() {
      this.$refs.userTickets.fetchTickets();
    }
  }
};
</script>
