import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue'),
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue'),
  },
  {
    path: '/board',
    name: 'Board',
    component: () => import('../views/Board.vue'),
  },
  {
    path: '/wish',
    name: 'Wish',
    component: () => import('../views/Wish.vue'),
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue'),
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: () => import('../views/SignUp.vue'),
  },
  {
    path: '/modifyInform',
    name: 'ModifyInform',
    component: () => import('../views/ModifyInform.vue'),
  },
  {
    path: '/aptdetail',
    name: 'AptDetail',
    component: () => import('../views/AptDetail.vue'),
  },
  {
    path: '/board/detail/:no',
    name: 'BoardDetail',
    component: () => import('@/components/board/BoardViewDetail.vue'),
  },
  {
    path: '/board/write',
    name: 'BoardWrite',
    component: () => import('@/components/board/BoardWrite.vue'),
  },
  {
    path: '/board/write/:no?',
    name: 'BoardUpdate',
    component: () => import('@/components/board/BoardWrite.vue'),
  },
  {
    path: '/store',
    name: 'Store',
    component: () => import('../views/Store.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
