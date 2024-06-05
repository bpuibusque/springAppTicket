<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      error: null
    };
  },
  methods: {
    async register() {
      this.error = null;
      try {
        const response = await fetch('http://localhost:8080/api/users/register', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            username: this.username,
            password: this.password
          })
        });
        if (response.ok) {
          alert('User registered successfully');
          this.$router.push('/login');
        } else {
          const errorText = await response.text();
          this.error = `Failed to register: ${errorText}`;
        }
      } catch (error) {
        console.error('Error:', error);
        this.error = 'Error registering user';
      }
    }
  }
};
</script>
