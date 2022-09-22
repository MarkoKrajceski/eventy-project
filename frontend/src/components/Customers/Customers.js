import react, {useEffect, useState} from "react";
import customerRepository from "../../repositories/customerRepository";
import {Link, useHistory} from "react-router-dom";

const Customers  = () => {
    const [customers, setCustomers] = useState();

    useEffect( ()=>{
        setCustomers(customerRepository.fetchCustomers());
    },[])

    return (
        <div>
            <div>
                <Link to={"/customers/add"}>Add a customer</Link>
            </div>
            <div>
                {customers && customers.map((term) => {
                    return(
                        <div>{term.name}</div>
                    );
                })}
            </div>
        </div>
    );

}

export default Customers;