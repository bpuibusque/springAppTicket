<template>
  <div>
    <h1>Admin View</h1>
    <user-list @userSelected="selectUser"></user-list>
    <user-tickets v-if="selectedUser" :user="selectedUser"></user-tickets>
  </div>
</template>

<script>
import UserList from '../components/UserList.vue';
import UserTickets from '../components/UserTickets.vue';

export default {
  name: 'AdminView',
  components: {
    UserList,
    UserTickets
  },
  data() {
    return {
      selectedUser: null
    };
  },
  methods: {
    selectUser(user) {
      this.selectedUser = user;
    }
  }
};
</script>
