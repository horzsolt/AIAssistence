import apiClient from "@/utils/apiClient";

class AssistanceService {
  
  getAssistance = (id: any, message: any): Promise<string> => {
    console.log("assistance backend is going to be called with message: ", message);
    const retval = apiClient.post('/assistance', {chatId: id, message: message}).then((response) => response.data);
    console.log('assistance backend response: ', retval);

    return retval;    
  };
}

export default new AssistanceService();