import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';

const ProductForm = props => {
  const [title, setTitle] = useState('')
  const [price, setPrice] = useState(0);
  const [description, setDescription] = useState('')
  const [errors, setErrors] = useState({})


  const addProduct = e => {
    setErrors({})
    console.log('print add')
    e.preventDefault();
    const product = { title, price, description }
    // console.log(product)
    axios.post('http://localhost:8000/api/product/new', product)
      .then(res => {
        console.log(res);

        if (res.data.err) {
          setErrors(res.data.err.errors)
        } else {
          props.updateList(res.data.newProduct)
          setTitle('');
          setPrice(0);
          setDescription('');
        }
      })
      .catch(err => {
        console.error(err)
      });

  }
  return (
    <div className="row my-3">
      <div className="col-sm-8 offset-sm-2">
        <form onSubmit={addProduct}>
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

          <input type="submit" value="Add Product" className="btn btn-outline-success btn-block mt-4" />
        </form>
      </div>
    </div>

  )
}

export default ProductForm
