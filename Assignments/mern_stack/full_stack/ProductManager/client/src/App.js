import "./App.css";
import Main from "./Views/Main";
import ProductView from "./Views/ProductView";
import ProductEdit from "./Views/ProductEdit";
import { Router } from "@reach/router";

function App() {
  return (
    <div className="container">
      <Router>
        <Main path="/" />
        <ProductView path="/:_id" />
        <ProductEdit path="/:_id/edit" />
      </Router>
    </div>
  );
}

export default App;
