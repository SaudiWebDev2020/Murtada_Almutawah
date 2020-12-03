import './App.css';

import People from './Pages/Results';
import SearchPage from './Pages/SearchPage';

import {Router} from '@reach/router';

function App() {
  return (
    <>
    <div className="container">
    <Router>
      <SearchPage path="/" />
      <People path="/:category/:id" />
    </Router>
    </div>
    </>
  );
}

export default App;
