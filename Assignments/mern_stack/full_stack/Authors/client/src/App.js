import { Router } from "@reach/router";
import Main from "./Views/Main";
import NewAuthor from "./Views/NewAuthor";
import EditAuthor from "./Views/EditAuthor";

function App() {
  return (
    <>
      <div className="container">
        <h1>Favorite authors</h1>
        <Router>
          <Main path="/" />
          <NewAuthor path="/new" />
          <EditAuthor path="/edit/:_id" />
        </Router>
      </div>
    </>
  );
}

export default App;
