import React,{useState} from 'react';
import axios from 'axios';

const Pokemon = props => {
    const [pokemons, setPokemons] = useState([]);

    const getPokemons = e =>{
        console.log('test');

        axios.get('https://pokeapi.co/api/v2/pokemon?limit=807')
        .then(response => response.data.results)
        .then(response => setPokemons(response))
        .catch(err=>console.log(err));
    }

    return(
        <div>
            <button onClick={getPokemons} >Fetch Pokemon</button>
            <ul>
                {
                    pokemons.map((pokemon,index)=>{
                        return <li key={index}> {pokemon.name} </li>
                    })
                }
            </ul>
        </div>
    );
};

export default Pokemon;