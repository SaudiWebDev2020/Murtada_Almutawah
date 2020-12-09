import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductForm from '../Components/ProductForm'
import ProductList from '../Components/ProductList'

const Main = () => {
  const [message, setMessage] = useState("Loading...")
  const [products, setProducts] = useState([])
  const [loaded, setLoaded] = useState(false);

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
        setLoaded(true);
        // console.log(products);
      })
  }, [loaded]);

  const updateList = product => {
    // console.log([product, ...products]);
    setProducts([...products, product])
  }

  return (
    <div className="my-2">
      <h2 className="text-center">Product Manager</h2>
      <p className="text-center">Message from the backend: {message}</p>
      <ProductForm operation="create" updateList={updateList} />
      <hr />
      {loaded && <ProductList productList={products} LoadQ={setLoaded} />}
    </div>
  )
}

export default Main;