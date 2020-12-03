import '../App.css';
import Search from '../Components/Search';
import React, { useState } from 'react';



function App() {
  const [id, setId] = useState(1);
  const [category, setCategory] = useState('planets');

    const updatePage = (id, category) => {
        setId(id);
        setCategory(category);
    }

  return (
    <>
     <Search category={category} id={id} onClickSearch={updatePage} />
    
    </>
  );
}

export default App;
