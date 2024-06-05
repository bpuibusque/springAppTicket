<template>
  <div>
    <h2>Create Ticket</h2>
    <form @submit.prevent="createTicket">
      <div>
        <label for="description">Description</label>
        <input type="text" v-model="description" required />
      </div>
      <button type="submit">Create Ticket</button>
    </form>
  </div>
</template>

<script>
export default {
  props: ['user'],
  data() {
    return {
      description: ''
    };
  },
  methods: {
    async createTicket() {
      try {
        const response = await fetch('http://localhost:8080/api/tickets', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ description: this.description, status: 'new', user: this.user })
        });
        if (response.ok) {
          alert('Ticket created successfully');
          this.$emit('ticketCreated');
        } else {
          alert('Failed to create ticket');
        }
      } catch (error) {
        console.error('Failed to create ticket:', error);
      }
    }
  }
};
</script>
