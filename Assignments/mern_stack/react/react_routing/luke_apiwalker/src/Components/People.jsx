import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';

const People = props => {
    
    return (
        <div>
            <h1 className="my-5">{props.information.name} </h1>

            <p><strong>Height:</strong> {props.information.height} cm</p>
            <p><strong>Mass:</strong> {props.information.mass} kg</p>
            <p><strong>Hair Color:</strong> {props.information.hair_color}</p>
            <p><strong>Skin Color:</strong> {props.information.skin_color}</p>
        </div>
    );
}

export default People;