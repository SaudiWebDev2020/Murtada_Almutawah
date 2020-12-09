import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';
import { navigate } from '@reach/router';

const ProductForm = props => {
  const [title, setTitle] = useState(!props.product ? '' : props.product.title)
  const [price, setPrice] = useState(!props.product ? 0 : props.product.price);
  const [description, setDescription] = useState(!props.product ? '' : props.product.description)
  const [errors, setErrors] = useState({})

  const editProduct = e => {
    e.preventDefault();
    setErrors({})
    // console.log('This is Editing =).',);
    const product = { title, price, description }
    axios.put(`http://localhost:8000/api/product/${props.product._id}`, product)
      .then(res => {
        // console.log(res);

        if (res.data.err) {
          setErrors(res.data.err.errors)
        } else {
          // props.updateList(res.data.newProduct)
          setTitle('');
          setPrice(0);
          setDescription('');
          navigate(`/${props.product._id}`)
        }
      })
      .catch(err => {
        console.error(err)
      });

  }

  return (
    <div className="row my-3">
      <div className="col-sm-8 offset-sm-2">
        <form onSubmit={editProduct} >
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


          <input type="submit" value="Edit Product" className="btn btn-outline-primary btn-block mt-4" />


        </form>
      </div>
    </div>

  )
}

export default ProductForm
