import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';

const ProductForm = props => {
  const { initialTitle, initialPrice, initialDescription, initialErrors, onSubmitCall } = props

  const [title, setTitle] = useState(initialTitle) // props
  const [price, setPrice] = useState(initialPrice); // props 
  const [description, setDescription] = useState(initialDescription) // props
  const [errors, setErrors] = useState(initialErrors) // props 

  const onSubmitAction = e => {
    e.preventDefault();
    const product = { title, price, description }
    onSubmitCall(product, setErrors, reset)
  }

  const reset = () => {
    setTitle('');
    setPrice(0);
    setDescription('');
    setErrors({})
  }

  return (
    <div className="row my-3">
      <div className="col-sm-8 offset-sm-2">
        <form onSubmit={onSubmitAction}>
          <div className="form-group">
            <label>Title</label>
            <input type="text" className="form-control" name="title" id="title" onChange={e => setTitle(e.target.value)} value={title} />
            <p className="text-danger">{errors.title ? errors.title.message : ''}</p>
          </div>

          <div className="form-group">
            <label>Price</label>
            <input type="number" step="0.01" className="form-control" name="price" id="price" onChange={e => setPrice(e.target.value)} value={price} />
            <p className="text-danger">{errors.price ? errors.price.message : ''}</p>
          </div>

          <div className="form-group">
            <label>Description</label>
            <input type="text" className="form-control" name="description" id="description" onChange={e => setDescription(e.target.value)} value={description} />
            <p className="text-danger">{errors.description ? errors.description.message : ''}</p>
          </div>

          <input type="submit" value="Submit" className="btn btn-outline-success btn-block mt-4" />

        </form>
      </div>
    </div>

  )
}

export default ProductForm
