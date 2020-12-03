import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';

const Species = props => {
    
    return (
        <div>
            <h1 className="my-5">{props.information.name} </h1>

            <p><strong>Classification:</strong> {props.information.classification}</p>
            <p><strong>Average Height:</strong> {props.information.average_height} cm</p>
            <p><strong>Hair Colors:</strong> {props.information.hair_colors}</p>
            <p><strong>Skin Colors:</strong> {props.information.skin_colors}</p>
        </div>
    );
}

export default Species;