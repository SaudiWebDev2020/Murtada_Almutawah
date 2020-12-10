import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductForm from '../Components/ProductForm'
import ProductList from '../Components/ProductList'
// import { navigate } from '@reach/router';


const Main = () => {
  const [message, setMessage] = useState("Loading...")
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8000/api")
      .then(res => {
        setMessage(res.data.message)
        // console.log(res);
      })
  }, []);


  const addProduct = (product, setErr, reset) => {
    axios.post('http://localhost:8000/api/product/new', product)
      .then(res => {
        if (res.data.err) {
          setErr(res.data.err.errors)
        } else {
          reset();
          // console.log(res.data.newProduct)
          setProducts([...products, res.data.newProduct])
        }
      })
      .catch(err => {
        console.error(err)
      });
  }



  return (
    <div className="my-2">
      <h2 className="text-center">Product Manager</h2>
      <p className="text-center">Message from the backend: {message}</p>
      <ProductForm initialTitle="" initialPrice={0} initialDescription="" initialErrors={{}} onSubmitCall={addProduct} />
      <hr />

      <ProductList products={products} setProducts={setProducts} />
    </div>
  )
}

export default Main;