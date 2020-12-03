import ErrorPicture from '../Assets/NotTheDroids.png';

import 'bootstrap/dist/css/bootstrap.css';
import React, { useState, useEffect } from 'react';
import axios from 'axios';

// Components
import Search from '../Components/Search';

import Films from '../Components/Films';
import People from '../Components/People';
import Planets from '../Components/Planets';
import Species from '../Components/Species';
import Starships from '../Components/Starships';
import Vehicles from '../Components/Vehicles';

const Results = props => {
    const [results, setResults] = useState({})
    const [id, setId] = useState(props.id);
    const [category, setCategory] = useState(props.category);
    const [isError, setIsError] = useState()
    const [errorMassage, setErrorMassage] = useState('')

    const updatePage = (id, category) => {
        setId(id);
        setCategory(category);
    }

    // console.log(id, category, 'From Results');

    useEffect(() => {
        setResults({});
        setIsError();
        axios.get(`https://swapi.dev/api/${category}/${id}`)
            .then(response => {
                setResults(response.data);
                setIsError(false);
            })
            .catch(err => {
                console.log(err);
                setIsError(true);
                if (err.response && err.response.status === 404) {
                    setErrorMassage(`Error(${err.response.status}): Input not found`);
                } else if (err.response && err.response.status === 429) {
                    setErrorMassage(`Error(${err.response.status}): Too many requests. try tomorrow`);
                } else {
                    setErrorMassage(`Error(${err.response.status}): Another Error`);

                }
            });

    }, [id, category]);


    // console.log(results)

    return (
        <>
            <Search category={category} id={id} onClickSearch={updatePage} />
            <div className='mx-5'>

                {isError ?
                    <div id="alert" className="alert alert-danger my-5 text-center" role="alert">
                        <img src={ErrorPicture} alt="These aren't the droids you're looking for" />
                        <p>
                            {errorMassage}
                        </p>
                    </div>
                    : category === 'films' ?
                        <Films information={results} />
                        : category === 'people' ?
                            <People information={results} />
                            : category === 'planets' ?
                                <Planets information={results} />
                                : category === 'species' ?
                                    <Species information={results} />
                                    : category === 'starships' ?
                                        <Starships information={results} />
                                        : category === 'vehicles' ?
                                            <Vehicles information={results} />
                                            : ""
                }
            </div>
        </>
    );
}

export default Results;