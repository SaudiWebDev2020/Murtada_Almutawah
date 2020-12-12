import React, { useState } from 'react'
import Form from '../Components/Form'
import { Link, navigate } from '@reach/router';
import Axios from 'axios';


const NewAuthor = () => {
  const [errors, setErrors] = useState({})

  const createAuthor = (name, setErr) => {
    console.log('object', name)
    const author = { name }
    Axios.post('http://localhost:8000/api/author/new', author)
      .then(res => {
        if (res.data.err) {
          console.log(res.data.err.errors);
          setErrors(res.data.err.errors)
          setErr(errors)
        } else {
          // console.log(res);
          navigate('/')
        }
      })
      .catch(err => console.log(err))
  }

  return (
    <>
      <Link to='/'>Home</Link>
      <pre>Add a new Author:</pre>
      <Form initialName='' onSubmitAction={createAuthor} initialErrors={errors} />
    </>
  )
}

export default NewAuthor
