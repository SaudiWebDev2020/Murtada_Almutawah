import React,{useState} from 'react';


const Pokemon = props => {
    const [pokemons, setPokemons] = useState([]);

    const getPokemons = e =>{
        console.log('test');
        fetch('https://pokeapi.co/api/v2/pokemon?limit=807')
        .then(response => response.json())
        .then(response => {
            setPokemons(response.results)
            console.log(pokemons)
        })
        .catch(err => console.log(err));
    }

    return(
        <div>
            <button onClick={getPokemons} >Fetch Pokemon</button>
            <ul>
                {
                    pokemons.map((pokemon,index)=>{
                        return <li> {pokemon.name} </li>
                    })
                }
            </ul>
        </div>
    );
};

export default Pokemon;