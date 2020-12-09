import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductEditForm from '../Components/ProductEditForm'
import { Link } from '@reach/router';

const ProductEdit = props => {
  const [message, setMessage] = useState("Loading...")
  const [product, setProduct] = useState([])
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    axios.get("http://localhost:8000/api")
      .then(res => {
        setMessage(res.data.message)
        // console.log(res);
      })
  }, []);

  useEffect(() => {
    axios.get(`http://localhost:8000/api/product/${props._id}`)
      .then(res => {
        // console.log(res.data);
        setProduct(res.data.product)
        setLoaded(true);
        console.log(product);
      })
  }, [loaded]);


  return (
    <>
      <Link className="btn btn-outline-dark mt-3 mr-2" to={`/${props._id}`}>Back</Link>
      <Link className="btn btn-outline-dark mt-3" to={'/'}>main page</Link>

      <div className="my-2">
        <h2 className="text-center">Edit Product</h2>
        <p className="text-center">Message from the backend: {message}</p>
        {loaded && <ProductEditForm product={product} />}
      </div>
    </>
  )
}

export default ProductEdit;