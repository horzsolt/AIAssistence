import HomeView from "@/views/HomeView.vue";
import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import AboutView from "@/views/AboutView.vue";
import AddOrderView from "@/views/AddOrderView.vue";
import AssistanceView from "@/views/AssistanceView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    component: AboutView,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/addorder",
    name: "addorder",
    component: AddOrderView,
  },
  {
    path: "/assistance",
    name: "assistance",
    component: AssistanceView,
  },
];

const router = createRouter({
  routes,
  history: createWebHistory(process.env.BASE_URL),
});

export default router;