import 'bootstrap/dist/css/bootstrap.css';

import TodoForm from "./Components/TodoForm";
import Todos from "./Components/Todos";

import React, { useState,useEffect } from 'react';

function check(arr,id){

  let newArr = [...arr];
  console.log('before', newArr[id]);
  newArr[id].isChecked = !newArr[id].isChecked;
  console.log('After', newArr[id]);

  console.log('New Arr',newArr);
  return newArr;
}

function App() {
  const [todos, setTodos] = useState([]);

  useEffect(()=>{
    const data = localStorage.getItem('tier-list');
    if (data){
      setTodos(JSON.parse(data));
    }
  },[]);

  useEffect(() => {
    localStorage.setItem('tier-list',JSON.stringify(todos));
    },[todos]);


  const addTodo = (todo) => {
    setTodos([todo, ...todos])
  }

  const updateTodoToChecked = (todo_id) =>{
    console.log('test');
    setTodos(check(todos,todo_id));
  }


  const deleteTodo = (todo_id) => {
    let newArr = [] 
    for (let i = 0; i<todos.length;i++){
      if(i === todo_id){
        
      } else{
        newArr.push(todos[i])
      }
    }
    setTodos(newArr)
  }

  return (
    <div className="container">
        <TodoForm onAdd={addTodo}/>
        <Todos todoList={todos} checkedTodo={updateTodoToChecked} deleteTodo={deleteTodo} />
    </div>
  );
}

export default App;
