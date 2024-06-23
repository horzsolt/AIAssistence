<template>
  <div class="card">
    <div class="card-header">
      <div class="card-header-left">
        <h2 class="card-title">{{ order.description }}</h2>
      </div>
      <div class="card-header-right">
        <button class="btn" @click="editOrder">Edit</button>
        <button class="btn" @click="deleteOrder">Delete</button>
        <button class="btn" @click="showDetails">Details</button>
      </div>
    </div>
    <div class="card-body">
      <div class="card-row">
        <div class="card-label">Unit:</div>
        <div class="card-value">{{ order.unit }}</div>
      </div>
      <div class="card-row">
        <div class="card-label">Quantity:</div>
        <div class="card-value">{{ order.quantity }}</div>
      </div>
    </div>
  </div>
</template>
<script lang="ts">
import orderService from "@/services/OrderService";
import Order from "@/types/Order";
import { defineComponent, PropType } from "vue";
import { useRouter } from "vue-router";

export default defineComponent({
  name: "OrderCard",
  props: {
    order: {
      type: Object as PropType<Order>,
      required: true,
    },
  },
  setup(props) {
    const router = useRouter();
    const showDetails = () => {
      router.push({ name: "details", params: { id: props.order.id } });
    };

    const editOrder = () => {
      router.push({
        name: "edit",
        params: { id: props.order.id },
      });
    };
    const deleteOrder = () => {
      orderService.delete(props.order.id).then(() => {
        window.location.reload;
      });
    };

    return {
      showDetails,
      editOrder,
      deleteOrder,
    };
  },
});
</script>
<style>
.card {
  background-color: #f9fafb;
  border-radius: 8px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  margin: 16px;
  overflow: hidden;
}

.card-header {
  background-color: #1890ff;
  color: #fff;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
}

.card-title {
  margin: 0;
  font-size: 24px;
}

.card-subtitle {
  margin: 0;
  font-size: 14px;
  opacity: 0.8;
}

.card-header-right {
  display: flex;
  align-items: center;
}

.btn {
  background-color: #fff;
  border: 1px solid #1890ff;
  border-radius: 4px;
  color: #1890ff;
  font-size: 14px;
  margin-left: 8px;
  padding: 8px 16px;
}

.btn:hover {
  background-color: #1890ff;
  color: #fff;
}

.card-body {
  padding: 16px;
}

.card-row {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
}

.card-label {
  font-size: 14px;
  font-weight: bold;
  width: 100px;
}

.card-value {
  font-size: 14px;
}
</style>