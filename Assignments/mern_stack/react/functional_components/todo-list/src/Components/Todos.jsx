import 'bootstrap/dist/css/bootstrap.css';
import React, { useState } from 'react';

const Todos = props => {


  return (
    <ul className='list-group'>
      { props.todoList.map((todo, index) => {
        return <li className="list-group-item" key={index}>
          <form>
            <div className="form-check">
              <input id={`todo${index}`} className="form-check-input" type="checkbox" checked={todo.isChecked} onChange={e => props.checkedTodo(index)} />
             <label htmlFor={`todo${index}`} > { todo.isChecked ? <del>{todo.todo}</del>: todo.todo}</label>
              
              <div className="float-right">
                <div className="btn btn-danger  mr-2" onClick={e => props.deleteTodo(index)}> Delete </div>
              </div>
            
            </div>
          </form>
          </li>
      })}
    </ul>
  );
};

export default Todos;