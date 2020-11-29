import React,{ useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Content from './Components/Content';
import Tabs from './Components/Tabs';

function App() {
  const [current, setCurrent] = useState('Main');

  const updateContent = (click) => {
    // console.log(click);
    setCurrent(click);
  }

  return (
    <div className="container">
      <div className="row my-2">
        <Tabs _array={['Main','Test','Exact']} selected={current} responseToClick={updateContent} />
      </div>
      <div className="row my-2">
        <Content currentValue = {current} />
      </div>
    </div>
  );
}

export default App;
