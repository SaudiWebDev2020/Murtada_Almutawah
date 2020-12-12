import { navigate } from '@reach/router';
import React, { useState } from 'react'

const Form = props => {
  const { initialName, onSubmitAction, initialErrors } = props;
  const [name, setName] = useState(initialName)
  const [errors, setErrors] = useState(initialErrors)

  const handleOnSubmit = e => {
    e.preventDefault();
    onSubmitAction(name, setErrors);
  }

  const handleName = e => {
    setName(e.target.value);
    setErrors({});
  }
  return (
    <div className="card col-6 p-2">
      <form onSubmit={handleOnSubmit}>
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input type="text" className="form-control" id="name" onChange={handleName} value={name} />
          {errors.name ?
            <pre className="text-danger pl-2 pt-1">{errors.name.message}</pre> : ''}
        </div>
        <div className="d-flex justify-content-around">
          <div className="btn btn-outline-danger" onClick={e => navigate('/')}>Cancel</div>
          <button type="submit" className="btn btn-outline-primary">Submit</button>
        </div>
      </form>
    </div>
  )
}

export default Form
