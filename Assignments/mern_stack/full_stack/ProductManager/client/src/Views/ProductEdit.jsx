import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductForm from '../Components/ProductForm';
import { Link, navigate } from '@reach/router';

const ProductEdit = props => {
  const [message, setMessage] = useState("Loading...")
  const [loadedProduct, setLoadedProduct] = useState([])
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
        setLoadedProduct(res.data.product)
        setLoaded(true);
        console.log(loadedProduct);
      })
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);


  const updateProduct = (updatedProductVersion, setErr, reset) => {
    // console.log(loadedProduct, product1);
    axios.put(`http://localhost:8000/api/product/${loadedProduct._id}`, updatedProductVersion)
      .then(res => {
        if (res.data.err) {
          setErr(res.data.err.errors)
        } else {
          console.log(res)
          // props.updateList(res.data.newProduct)
          navigate(`/${res.data.updatedProduct._id}`)
        }
      })
      .catch(err => {
        console.error(err)
      });

  }

  return (
    <>
      <Link className="btn btn-outline-dark mt-3 mr-2" to={`/${props._id}`}>Back</Link>
      <Link className="btn btn-outline-dark mt-3" to={'/'}>main page</Link>

      <div className="my-2">
        <h2 className="text-center">Edit Product</h2>
        <p className="text-center">Message from the backend: {message}</p>
        {loaded && <ProductForm initialTitle={loadedProduct.title} initialPrice={loadedProduct.price} initialDescription={loadedProduct.description} initialErrors={{}} onSubmitCall={updateProduct} />}
      </div>
    </>
  )
}

export default ProductEdit;