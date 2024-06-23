<template>
    <div class="home">
      <h1>
        AI demo application by EtalonSoft<br />
        <br />
        Megrendelések
      </h1>
      <div v-for="(order, index) in orders" :key="index">
        <order-card :order="order" />
      </div>
      <Footer></Footer>
    </div>
  </template>
  
  <script lang="ts">
  import { defineComponent, ref } from "vue";
  import OrderCard from "@/components/OrderCard.vue";
  import Footer from "@/components/FooterPage.vue";
  import Order from "@/types/Order";
  import orderService from "@/services/OrderService";
  
  export default defineComponent({
    name: "HomeView",
    components: { OrderCard, Footer },
  
    setup() {
      let orders = ref<Order[]>([]);
  
      orderService.getAllOrders().then((response) => {
        orders.value = response;
      });
  
      return {
        orders,
      };
    },
  });
  </script>
  
  <style scoped>
  h1 {
    text-align: center;
    margin-bottom: 80 px;
  }
  </style>