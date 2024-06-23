import axios, { AxiosInstance } from "axios";

const API_URL = "http://localhost:8080/";

const axiosInstance: AxiosInstance = axios.create({
  baseURL: API_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

/*axiosInstance.interceptors.request.use(request => {
  console.log('Starting Request', JSON.stringify(request, null, 2))
  return request
})

axiosInstance.interceptors.response.use(response => {
  console.log('Response:', JSON.stringify(response, null, 2))
  return response
})*/

export default axiosInstance;