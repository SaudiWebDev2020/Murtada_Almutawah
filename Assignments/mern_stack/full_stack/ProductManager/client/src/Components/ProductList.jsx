import React from 'react';
import axios from 'axios';

import 'bootstrap/dist/css/bootstrap.css';
import { Link, navigate } from '@reach/router';

const ProductList = props => {

  const deleteProduct = (_id) => {
    console.log(_id)
    axios.delete(`http://localhost:8000/api/product/${_id}`)
      .then(res => {
        console.log(res.data);
        // console.log(products);
        props.LoadQ(false);
      })
  }

  return (
    <div className="row">
      <div className="col-sm-8 offset-sm-2">
        <h1 className="text-center">All Product</h1>
        <ul className="list-group">
          {
            props.productList.slice(0).reverse().map((prod, index) => {

              return < li key={index} className="list-group-item text-center d-flex justify-content-between justify-center" >
                <Link className="align-self-center " to={`/${prod._id}`}>{prod.title} </Link>
                <div className="btn btn-danger  mr-2" onClick={e => deleteProduct(prod._id)}> Delete </div>
              </li>
            }
            )}
        </ul>
      </div>

    </div >
  )
}

export default ProductList
