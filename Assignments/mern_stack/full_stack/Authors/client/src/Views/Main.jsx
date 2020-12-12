import React, { useState, useEffect } from 'react'
import { Link, navigate } from '@reach/router';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';

const Main = () => {
  const [authors, setAuthors] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8000/api/author')
      .then(res => setAuthors(res.data.authors))
      .catch(err => console.log(err))

  }, []);

  const deleteHandler = (_id) => {
    console.log(_id)
    axios.delete(`http://localhost:8000/api/author/${_id}`)
      .then(res => {
        console.log(res)
        setAuthors(authors.filter(authors => authors._id !== res.data.author._id));
      })
      .catch(err => console.log(err))
  }

  const compare = (a, b) => {
    var nameA = a.name.toUpperCase(); // ignore upper and lowercase
    var nameB = b.name.toUpperCase(); // ignore upper and lowercase
    if (nameA < nameB) {
      return -1;
    }
    if (nameA > nameB) {
      return 1;
    }

    // names must be equal
    return 0;
  }

  return (
    <div>
      <Link to="/new">Add an author</Link>
      <p>We have quotes by:</p>
      <table className="table table-hover text-center">
        <thead>
          <tr>
            <th>Author</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {authors.sort(compare).map((author, index) => {
            return <tr key={index}>
              <td>{author.name}</td>
              <td className="d-flex justify-content-around">
                <div className="btn btn-outline-success" onClick={e => navigate(`/edit/${author._id}`)}>Edit</div>
                <div className="btn btn-outline-danger" onClick={e => deleteHandler(author._id)}>Delete</div></td>
            </tr>
          })}
        </tbody>
      </table>
    </div >
  )
}

export default Main
