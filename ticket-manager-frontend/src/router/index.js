import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import AdminView from '../views/AdminView.vue';
import UserView from '../views/UserView.vue';
import LoginPage from '../views/LoginPage.vue';
import RegisterPage from '../views/RegisterPage.vue';

const routes = [
  { path: '/', component: HomePage },
  { path: '/admin', component: AdminView, meta: { requiresAuth: true, role: 'admin' } },
  { path: '/user', component: UserView, meta: { requiresAuth: true, role: 'user' } },
  { path: '/login', component: LoginPage },
  { path: '/register', component: RegisterPage }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth);
  const role = to.matched.some(record => record.meta.role);
  const user = JSON.parse(localStorage.getItem('user')); // Supposons que l'utilisateur soit stocké dans localStorage après la connexion

  if (requiresAuth && !user) {
    next('/login');
  } else if (requiresAuth && user && role && user.role !== role) {
    next('/');
  } else {
    next();
  }
});

export default router;
