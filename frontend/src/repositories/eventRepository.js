import axios from "../custom-axios/axios-event";

const eventRepository = {
    fetchEvents: () =>{
        return axios.get("/events");
    },
    addEvent: (eventForm)=>{
        return axios.post("/events/add/",eventForm)
    }
}

export default eventRepository;