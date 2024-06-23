<template>
    <div class="order-details">
      <div class="order-header">
        <div class="order-avatar">
          <img src="../assets/lofi2.jpeg" alt="Order Avatar" />
        </div>
        <div class="order-info">
          <h1>{{ order?.description }}</h1>
          <h2>{{ order?.unit }}</h2>
          <div class="order-contact">
            <div class="order-contact-item">
              <i class="fas fa-envelope"></i>
              <p>{{ order?.quantity }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script lang="ts">
  import orderService from "@/services/OrderService";
  import Order from "@/types/Order";
  import { defineComponent, ref } from "vue";
  import { useRoute } from "vue-router";
  
  export default defineComponent({
    setup() {
      // question difference between useRouter and useRoute
      const route = useRoute();
      const id: string | string[] = route.params.id;
      let order = ref<Order>();
  
      orderService
        .getOrderById(id)
        .then((Response) => (order.value = Response));
  
      return {
        order,
      };
    },
  });
  </script>
  
  <style>
  .order-details {
    margin: 2rem auto;
    max-width: 800px;
    padding: 2rem;
    background-color: #f2f2f2;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    font-family: Arial, sans-serif;
    color: #333;
  }
  
  .order-header {
    display: flex;
    align-items: center;
    margin-bottom: 2rem;
  }
  
  .order-avatar {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    overflow: hidden;
    margin-right: 2rem;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }
  
  .order-avatar img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .order-info {
    display: flex;
    flex-direction: column;
  }
  
  .order-info h1 {
    font-size: 2.5rem;
    margin: 0;
  }
  
  .order-info h2 {
    font-size: 1.5rem;
    margin: 0;
    color: #666;
  }
  
  .order-contact {
    display: flex;
    margin-top: 1rem;
  }
  
  .order-contact-item {
    display: flex;
    align-items: center;
    margin-right: 1rem;
  }
  
  .order-contact-item i {
    font-size: 1.2rem;
  }
  
  .order-contact-item p {
    margin: 0 0 0 0.5rem;
  }
  
  .order-details-body {
    display: flex;
    flex-direction: column;
  }
  
  .order-details-section {
    margin-bottom: 2rem;
  }
  
  .order-details-section h2 {
    font-size: 1.8rem;
    margin-bottom: 1rem;
  }
  
  .order-details-section p {
    line-height: 1.5;
  }
  </style>