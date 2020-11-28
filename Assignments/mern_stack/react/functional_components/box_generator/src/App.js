import './App.css';
import bootstrap from 'bootstrap/dist/css/bootstrap.min.css'

import React,{useState} from 'react'

import Boxes from './Components/Boxes';
import BoxForm from './Components/BoxForm';

function App() {
  const [boxesList, setBoxesList] = useState([]);
  
  const updateBoxesList = (boxes) => {
    console.log('onUpdate', boxes)
    setBoxesList(oldArray => [...oldArray,boxes]);
    
  }

  return (
    <div className="container">
      <div className="row my-2">
        <BoxForm onAddNew={updateBoxesList} />
      </div>

      <div className="row my-2">
        <Boxes boxesList={boxesList}/>
      </div>
    </div>
  );
}

export default App;
