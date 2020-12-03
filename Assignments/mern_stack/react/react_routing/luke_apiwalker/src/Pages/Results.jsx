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

    const updatePage = (id, category) => {
        setId(id);
        setCategory(category);
    }

    console.log(id, category, 'From Results');

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
            });

    }, [id, category]);


    console.log(results)

    return (
        <>
            <Search category={category} id={id} onClickSearch={updatePage} />
            <div className='mx-5'>

                {isError ?
                    <div id="alert" class="alert alert-danger my-5" role="alert">These aren't the droids you're looking for</div>
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
                                            : ''
                }
            </div>
        </>
    );
}

export default Results;