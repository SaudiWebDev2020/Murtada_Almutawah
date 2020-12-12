const AuthorController = require("../controllers/author.controller");

module.exports = function (app) {
  app.get("/api/author", AuthorController.getAll);
  app.get("/api/author/:_id", AuthorController.getOne);
  app.delete("/api/author/:_id", AuthorController.remove);
  app.put("/api/author/:_id", AuthorController.update);
  app.post("/api/author/new", AuthorController.create);
};
