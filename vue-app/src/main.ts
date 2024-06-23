import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import logger from "./logger";
//import store from "./store";

const app = createApp(App).use(router).use(logger);

app.config.errorHandler = (err, vm, info) => {
    console.error("Error:", err);
    console.error("Vue component:", vm);
    console.error("Additional info:", info);
  };

app.mount("#app");