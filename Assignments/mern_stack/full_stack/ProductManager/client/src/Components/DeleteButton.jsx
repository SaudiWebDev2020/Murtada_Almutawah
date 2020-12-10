import React from 'react'
import axios from 'axios';

const DeleteButton = props => {

  const deleteProduct = (_id) => {
    // console.log(_id)
    axios.delete(`http://localhost:8000/api/product/${_id}`)
      .then(res => {
        // console.log(res.data);
        props.onDeleteCall(_id);
      })
  }

  return (
    <div className="btn btn-danger  mr-2" onClick={e => deleteProduct(props.product_id)}> Delete </div>
  )
}

export default DeleteButton
