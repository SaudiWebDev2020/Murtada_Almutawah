import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { Link } from '@reach/router';

const ProductList = props => {


  return (
    <div className="row">
      <div className="col-sm-8 offset-sm-2">
        <h1 className="text-center">All Product</h1>
        <ul className="list-group">
          {
            props.productList.slice(0).reverse().map((prod, index) => {

              return < li key={index} className="list-group-item text-center" > <Link to={`/${prod._id}`}>{prod.title} </Link> </li>
            }
            )}
        </ul>
      </div>

    </div >
  )
}

export default ProductList
