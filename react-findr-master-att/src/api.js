import axios from "axios";

const api = axios.create({
    baseURL : "http://34.200.19.241:8082"
})

export default api;