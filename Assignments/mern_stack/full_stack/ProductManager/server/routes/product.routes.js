const ProductController = require("../controllers/product.controller");

module.exports = function (app) {
  app.get("/api", ProductController.index);
  app.get("/api/product", ProductController.getAll);
  app.post("/api/product/new", ProductController.addProduct);
};
