import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';

const People = props => {
    
    return (
        <div>
            <h1 className="my-5">{props.information.name} </h1>

            <p><strong>Climate:</strong> {props.information.climate}</p>
            <p><strong>Terrain:</strong> {props.information.terrain}</p>
            <p><strong>Surface Water:</strong> {props.information.surface_water > 0 ? 'true':'false'}</p>
            <p><strong>Population:</strong> {props.information.population}</p>
        </div>
    );
}

export default People;