import axios from "../custom-axios/axios-customer";

const customerRepository = {
    fetchCustomers: () =>{
        return axios.get("/customers");
    },
    addCustomer: (customerForm)=>{
        return axios.post("/customers/add/",customerForm)
    }
}
export default customerRepository;