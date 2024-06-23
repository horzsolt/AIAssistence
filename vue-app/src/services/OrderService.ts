import apiClient from "@/utils/apiClient";
import Order from "@/types/Order";
import { useLogger } from "vue-logger-plugin";

class OrderService {
  
  getAllOrders = (): Promise<Order[]> => {
    const retval = apiClient.get("/orders").then((response) => response.data);
    const log = useLogger();
    log.info('getAllOrders called with response: ', retval);

    return retval;
  };
  getOrderById = (id: any): Promise<Order> => {
    return apiClient.get('/orders/${id}').then((response) => response.data);
  };

  edit = (id: any, emp: any): Promise<Order> => {
    return apiClient
      .put('/orders/${id}', emp)
      .then((response) => response.data);
  };

  delete = async (id: any): Promise<Order> => {
    return await apiClient
      .delete('/orders/${id}')
      .then((response) => response.data);
  };

  save = (emp: any): Promise<Order> => {
    return apiClient.post('/orders', emp).then((response) => response.data);
  };
}

export default new OrderService();