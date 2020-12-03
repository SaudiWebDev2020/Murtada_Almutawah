import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';
import { Link } from '@reach/router';

const People = props => {
    const [homeWorld, setHomeWorld] = useState({})
    // const [homeWorldLink, setHomeWorldLink] = useState()

    useEffect(() => {


        axios.get(props.information.homeworld)
            .then(response => {
                setHomeWorld(response.data);
                // getIDofHomeWorld(props.information.homeworld);
            })
            .catch(err => {
                console.log(err);
            });

    });

    // const getIDofHomeWorld = link => {
    //     let spl = link;
    //     console.log('id', spl);
    //     return spl;
    // }

    // getIDofHomeWorld(props.information.homeworld);

    return (
        <div>
            <h1 className="my-5">{props.information.name} </h1>

            <p><strong>Height:</strong> {props.information.height} cm</p>
            <p><strong>Mass:</strong> {props.information.mass} kg</p>
            <p><strong>Hair Color:</strong> {props.information.hair_color}</p>
            <p><strong>Skin Color:</strong> {props.information.skin_color}</p>
            {/* <Link to="/"> {homeWorld.name} </Link> */}
            <a href={props.information.homeworld}> {homeWorld.name} </a>
        </div>
    );
}

export default People;