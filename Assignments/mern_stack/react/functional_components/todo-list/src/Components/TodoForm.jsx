import 'bootstrap/dist/css/bootstrap.css';
import React, { useState } from 'react';

const TodoForm = props => {
  const [todo, setTodo] = useState('')
  const [isChecked,] = useState(false);

  const addTodo = e => {
    e.preventDefault();
    const todoItem = {todo,isChecked}
    props.onAdd(todoItem);
    setTodo('');
  }



  return (
      <form onSubmit={addTodo}>
        <div className="row my-2">
          <div className="form-group col-md-5 ml-auto">
              <input className="form-control" type="text" placeholder="Write what todo" onChange={e => setTodo(e.target.value)} value={todo} />
            </div>
            <div className="col-md-1 ml-2 mr-auto">
              <button className="btn btn-primary">Add</button>
            </div>
          </div>
      </form>
  );
};

export default TodoForm;