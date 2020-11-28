import React,{useState} from 'react'

const BoxForm = props => {
    const [color, setColor] = useState([]);

    const handleSubmit = (e) => {
        e.preventDefault();
        // console.log('boxes',boxes);
        // console.log(e.target.color.value)
        props.onAddNew(e.target.color.value);
        console.log(color);
        setColor("");
    };

    return(
        <div className="mx-auto">
          <form className="form-inline" onSubmit={ handleSubmit }>
              <div className="form-group mb-2">
                <label className="" htmlFor="color">Color</label>
                <input className="form-control mx-2" type="text" name="color" id="color" onChange={(e) => {setColor(e.target.value)}} value={color}/>
              </div>
              <button className="btn btn-outline-secondary mb-2">Add</button>
          </form>
        </div>
    );
};

export default BoxForm