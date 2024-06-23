<template>
    <div class="order-edit-form">
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="message">Chat message</label>
          <input
            type="text"
            id="chat"
            v-model="chat.message"
            required
          />
        </div>
        <div class="form-actions">
          <button type="submit">Send Message</button>
          <button type="button" @click="cancelEdit">Cancel</button>
        </div>
      </form>
    </div>
    <div>
      <response-card :chatResponse="chatResponse" />
    </div>
    <Footer></Footer>    
  </template>
  
  <script lang="ts">
    import { defineComponent, ref } from "vue";
    import ChatMessage from "@/types/ChatMessage";
    import assistanceService from "@/services/AssistanceService";
    import { useRouter } from "vue-router";
    import { uuid } from 'vue-uuid'; 
    import { useLogger } from "vue-logger-plugin";
    import ResponseCard from "@/components/ResponseCard.vue";
    import Footer from "@/components/FooterPage.vue";
    
    export default defineComponent({
      name: "AssistanceView",
      components: { ResponseCard, Footer },

      setup() {

        const chat = ref<ChatMessage>({
          id: uuid.v1(),
          message: "",
        });

        let chatResponse = ref<ChatMessage>({
          id: uuid.v1(),
          message: "",
        });

        const router = useRouter();
        const log = useLogger();
    
        const submitForm = () => {
          log.info('assistance is going to be called with: ', chat.value.message);          
          const response = assistanceService.getAssistance(chat.value.id, chat.value.message);
          chatResponse.value.id = chat.value.id;

          response.then((response) => {
            chatResponse.value.message = response;
          });
          
          window.location.reload;
        };
        const cancelEdit = () => {
          router.push({ name: "home" });
        };
    
        return {
          chat,
          chatResponse,
          cancelEdit,
          submitForm,
        };
      },
    });
  </script>
  
  <style scoped>
  .order-edit-form {
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