import "./App.css";
import Main from "./Views/Main";
import ProductView from "./Views/ProductView";
import { Router } from "@reach/router";

function App() {
  return (
    <div className="container">
      <Router>
        <Main path="/" />
        <ProductView path="/:_id" />
      </Router>
    </div>
  );
}

export default App;
