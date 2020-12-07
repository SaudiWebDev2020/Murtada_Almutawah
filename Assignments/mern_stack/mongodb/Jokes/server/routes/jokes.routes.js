const JokesController = require("../controllers/jokes.controller");

module.exports = (app) => {
  app.get("/api/jokes", JokesController.getAll);
  app.get("/api/jokes/random", JokesController.random);
  app.get("/api/jokes/:_id", JokesController.getOne);
  app.post("/api/jokes/new", JokesController.create);
  app.put("/api/jokes/update/:_id", JokesController.update);
  app.delete("/api/jokes/delete/:_id", JokesController.delete);
};
