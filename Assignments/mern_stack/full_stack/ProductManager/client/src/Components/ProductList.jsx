import React, { useEffect, useState } from 'react'
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';
import { Link } from '@reach/router';
import DeleteButton from './DeleteButton';

const ProductList = props => {
  const { products, setProducts } = props
  const [loaded, setLoaded] = useState(props.load);

  useEffect(() => {
    axios.get("http://localhost:8000/api/product")
      .then(res => {
        setProducts(res.data.allProducts)
        setLoaded(true);
        // console.log(res.data);
      })
  }, [loaded, setProducts]);


  const removeFromDom = productID => {
    setProducts(products.filter(product => product._id !== productID));
    // props.updateList(productID);
  }

  return (
    <> { loaded &&
      <div className="col-sm-8 offset-sm-2">
        <h1 className="text-center">All Product</h1>
        <ul className="list-group">
          {
            products.slice(0).reverse().map((prod, index) => {
              return < li key={index} className="list-group-item text-center d-flex justify-content-between justify-center" >
                <Link className="align-self-center " to={`/${prod._id}`}>{prod.title} </Link>
                <DeleteButton onDeleteCall={removeFromDom} product_id={prod._id} />
              </li>
            }
            )}
        </ul>
      </div>}
    </>
  )
}

export default ProductList
