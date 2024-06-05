import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import AdminView from '../views/AdminView.vue';
import UserView from '../views/UserView.vue';
import LoginPage from '../views/LoginPage.vue';
import RegisterPage from '../views/RegisterPage.vue';

const routes = [
  { path: '/', component: HomePage },
  { path: '/admin', component: AdminView },
  { path: '/user', component: UserView },
  { path: '/login', component: LoginPage },
  { path: '/register', component: RegisterPage }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
