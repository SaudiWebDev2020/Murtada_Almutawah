import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';

const ProductView = props => {
  const [product, setProduct] = useState({});
  useEffect(() => {
    axios.get(`http://localhost:8000/api/product/${props._id}`).then(
      res => {
        // console.log(res.data.product);
        setProduct(res.data.product)
      }
    ).catch(err => console.log(err));

  }, [props._id])

  return (
    <div className="text-center my-5">
      <h1>{product.title}</h1>
      <p>Price: ${product.price}</p>
      <p>Description: {product.description}</p>
    </div>
  )
}

export default ProductView