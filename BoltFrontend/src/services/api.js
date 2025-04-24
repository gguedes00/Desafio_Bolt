import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080"
});

export const getTop5Usinas = () => api.get("/usina/top5");
