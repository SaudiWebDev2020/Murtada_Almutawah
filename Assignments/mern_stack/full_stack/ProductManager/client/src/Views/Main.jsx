import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductForm from '../Components/ProductForm'

const Main = () => {
  const [message, setMessage] = useState("Loading...")
  useEffect(() => {
    axios.get("http://localhost:8000/api")
      .then(res => {
        setMessage(res.data.message)
        console.log(res);
      })
  }, []);
  console.log(message);
  return (
    <div className="my-2">
      <h2 className="text-center">Product Manager</h2>
      <p className="text-center">Message from the backend: {message}</p>
      <ProductForm />
    </div>
  )
}

export default Main;