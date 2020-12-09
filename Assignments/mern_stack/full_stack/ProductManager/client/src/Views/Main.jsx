import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductForm from '../Components/ProductForm'
import ProductList from '../Components/ProductList'

const Main = () => {
  const [message, setMessage] = useState("Loading...")
  const [products, setProducts] = useState([])

  useEffect(() => {
    axios.get("http://localhost:8000/api")
      .then(res => {
        setMessage(res.data.message)
        // console.log(res);
      })
  }, []);

  useEffect(() => {
    axios.get("http://localhost:8000/api/product")
      .then(res => {
        // console.log(res.data);
        setProducts(res.data.allProducts)
        // console.log(products);
      })
  }, []);

  const updateList = product => {
    // console.log([product, ...products]);
    setProducts([...products, product])
  }

  return (
    <div className="my-2">
      <h2 className="text-center">Product Manager</h2>
      <p className="text-center">Message from the backend: {message}</p>
      <ProductForm updateList={updateList} />
      <hr />
      <ProductList productList={products} />
    </div>
  )
}

export default Main;