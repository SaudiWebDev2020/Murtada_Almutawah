import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';
import { Link, navigate } from '@reach/router';
import DeleteButton from '../Components/DeleteButton';


const ProductView = props => {
  const [product, setProduct] = useState({});
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    axios.get(`http://localhost:8000/api/product/${props._id}`).then(
      res => {
        // console.log(res);
        setProduct(res.data.product);
        setLoaded(true);
      }
    ).catch(err => console.log(err));
  }, [props._id])


  const editPage = (_id) => {
    // console.log(_id)
    navigate(`/${_id}/edit`);
  }

  return (
    <>
      <Link className="btn btn-outline-dark mt-3" to={'/'}>main page</Link>
      { loaded ?
        <div className="text-center my-5 col-sm-8 offset-sm-2">
          <h1>{product.title}</h1>
          <p>Price: ${product.price}</p>
          <p>Description: {product.description}</p>
          < div className="d-flex justify-content-between justify-center" >
            <div className="btn btn-success  mr-2" onClick={e => editPage(product._id)}> Edit </div>

            <DeleteButton onDeleteCall={e => navigate('/')} product_id={product._id} />
          </div>
        </div> : ''
      }
    </>
  )
}

export default ProductView