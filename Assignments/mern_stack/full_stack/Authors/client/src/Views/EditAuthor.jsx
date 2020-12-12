import React, { useState, useEffect } from 'react'
import Form from '../Components/Form'
import { Link, navigate } from '@reach/router';
import axios from 'axios';
import Axios from 'axios';


const EditAuthor = props => {
  const [name, setName] = useState('');
  const [loaded, setLoaded] = useState(false)

  useEffect(() => {
    axios.get(`http://localhost:8000/api/author/${props._id}`)
      .then(res => {
        // console.log(res.data.author.name);
        if (res.data.author) {
          setName(res.data.author.name)
          setLoaded(true);
        }
      }).catch(err => console.log(err));
  }, [props._id]);

  const updateAuthor = (name, setErr) => {
    console.log('updateAuthor', name);
    const author = { name };
    Axios.put(`http://localhost:8000/api/author/${props._id}`, author)
      .then(res => {
        if (res.data.err) {
          console.log(res.data.err.errors);
          // setErrors(res.data.err.errors)
          setErr(res.data.err.errors)
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
      <pre>Edit this author:</pre>
      { loaded ?
        <Form initialName={name} onSubmitAction={updateAuthor} initialErrors={{}} />
        :
        <> <p className="text-danger">We're sorry, but we could not find the author you are looking for. Would you like to add this author to our database?</p>
          <Link to='/new'>Add a new author</Link>
        </>
      }
    </>
  )
}

export default EditAuthor
