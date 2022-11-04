import axios from "axios";

const api = axios.create({
    baseURL : "http://54.227.254.129:8080/"
})

export default api;