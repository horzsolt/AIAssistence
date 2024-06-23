<template>
    <div class="order-edit-form">
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="description">Description</label>
          <input type="text" id="description" v-model="editedOrder.description" required />
        </div>
        <div class="form-group">
          <label for="unit">Unit</label>
          <input type="text" id="unit" v-model="editedOrder.unit" required />
        </div>
        <div class="form-group">
          <label for="quantity">Quantity</label>
          <input type="text" id="quantity" v-model="editedOrder.quantity" required />
        </div>
        <div class="form-actions">
          <button type="submit">Save Changes</button>
          <button type="button" @click="cancelEdit">Cancel</button>
        </div>
      </form>
    </div>
  </template>
  
  <script lang="ts">
  import { defineComponent, ref } from "vue";
  import Order from "@/types/Order";
  import orderService from "@/services/OrderService";
  import { useRoute, useRouter } from "vue-router";
  
  export default defineComponent({
    name: "OrderEditForm",
    setup() {
      const editedOrder = ref<Order>();
      console.log(editedOrder);
      const route = useRoute();
      const router = useRouter();
      let id = route.params.id;
      orderService.getOrderById(id).then((response) => {
        editedOrder.value = response;
      });
  
      const submitForm = () => {
        orderService.edit(id, editedOrder.value).then(() => {
          router.push({ name: "home" });
        });
        window.location.reload;
      };
      const cancelEdit = () => {
        router.push({ name: "home" });
      };
  
      return {
        editedOrder,
        cancelEdit,
        submitForm,
      };
    },
  });
  </script>
  
  <style scoped>
  .employee-edit-form {
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    padding: 2rem;
  }
  
  .form-group {
    margin-bottom: 1rem;
  }
  
  label {
    display: block;
    font-size: 1.2rem;
    margin-bottom: 0.5rem;
  }
  
  input,
  textarea {
    border-radius: 3px;
    border: 1px solid #ccc;
    padding: 0.5rem;
    font-size: 1.2rem;
    width: 100%;
    box-sizing: border-box;
  }
  
  button {
    background-color: #007aff;
    color: #fff;
    border: none;
    border-radius: 3px;
    padding: 0.5rem 1rem;
    font-size: 1.2rem;
    cursor: pointer;
    margin-right: 1rem;
  }
  
  button:hover {
    background-color: #0062cc;
  }
  
  button[type="submit"] {
    background-color: #28a745;
  }
  
  button[type="submit"]:hover {
    background-color: #218838;
  }
  
  button[type="button"] {
    background-color: #dc3545;
  }
  
  button[type="button"]:hover {
    background-color: #c82333;
  }
  
  .form-actions {
    margin-top: 1rem;
    display: flex;
    justify-content: flex-end;
  }
  </style>