import {useHistory} from "react-router-dom";
import {useState} from "react";
import {useEffect} from "react";
import customerRepository from "../../repositories/customerRepository";
import eventRepository from "../../repositories/eventRepository";


const CustomerAdd = () =>{
    const history = useHistory();
    const [formData, updateFormData] = useState({
        name: "",
    });

    const [events, setEvents] = useState();

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const category = formData.category;
        const author = formData.author;
        const availableCopies = formData.availableCopies;


        history.push("/customers");
    }

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    useEffect( ()=>{
        setEvents(eventRepository.fetchEvents());
    },[])

    return(
        <form onSubmit={onFormSubmit}>
            <input type="text" id="name" name="name" required onChange={handleChange}/>
            <input type="text" id="email" name="email" required onChange={handleChange}/>
            <input type="text" id="password" name="password" required onChange={handleChange}/>

            <select name="events" className="form-control" onChange={handleChange}>
                {events && events.map((term) =>{
                    return <option value={term.id}>{term.name}</option>
                })}
            </select>
        </form>
    )
}