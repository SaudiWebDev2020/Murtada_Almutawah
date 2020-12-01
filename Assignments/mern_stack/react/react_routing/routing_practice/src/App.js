import './App.css';
import {Router} from '@reach/router';

import HomePage from './Pages/HomePage';
import ReadInput from './Pages/ReadInput';
import ReadInputFontBg from './Pages/ReadInputFontBg';

function App() {
  return (
    <>
      <Router>
        <HomePage path='/home' />
        <ReadInput path='/:inp' />
        <ReadInputFontBg path='/:inp/:fontColor/:bgColor' />
      </Router>
    </>
  );
}

export default App;
