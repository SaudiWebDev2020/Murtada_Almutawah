import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { navigate } from '@reach/router';

const Search = props => {
    const [id,setId] = useState(props.id || 0);
    const [category,setCategory] = useState(props.category || 'planets');
    
    const searchHandeler = e => {
        e.preventDefault();
        // console.log(id,category,'from search');
        props.onClickSearch(id,category);
        navigate(`/${category.toLowerCase()}/${id}`);
        
    }


    return (
        <form className="form-inline justify-content-center mt-5">
                <label className="mx-1" htmlFor="category">Search For:</label>
                <div className="mx-1">
                    <select className="form-control" id="category" onChange={e => setCategory(e.target.value.toLowerCase())} value={category}>
                        <option>films</option>
                        <option>people</option>
                        <option>planets</option>
                        <option>species</option>
                        <option>starships</option>
                        <option>vehicles</option>
                    </select>
                </div>
                <label className="mx-1" htmlFor="id">ID:</label>
                <div className="mx-1">
                    <input className="form-control" type="number" name="id" id="id" onChange={e => setId(e.target.value)} value={id}/>
                </div>
            <button className="btn btn-primary mx-1" onClick={ searchHandeler }>Search</button>
        </form>
    );
}

export default Search;