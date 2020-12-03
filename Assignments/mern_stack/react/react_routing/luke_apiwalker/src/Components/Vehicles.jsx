import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';

const Vehicles = props => {
    
    return (
        <div>
            <h1 className="my-5">{props.information.name} </h1>
            <p><strong>Model:</strong> {props.information.model}</p>
            <p><strong>Manufacturer:</strong> {props.information.manufacturer}</p>
            <p><strong>Cost:</strong> {props.information.cost_in_credits} Galactic</p>
            <p><strong>Length:</strong> {props.information.length} m</p>
        </div>
    );
}

export default Vehicles;