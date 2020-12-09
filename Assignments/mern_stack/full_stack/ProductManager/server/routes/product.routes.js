const ProductController = require("../controllers/product.controller");

module.exports = function (app) {
  app.get("/api", ProductController.index);
  app.get("/api/product", ProductController.getAll);
  app.get("/api/product/:_id", ProductController.getOne);
  app.delete("/api/product/:_id", ProductController.remove);
  app.put("/api/product/:_id", ProductController.updateProduct);
  app.post("/api/product/new", ProductController.createProduct);
};
