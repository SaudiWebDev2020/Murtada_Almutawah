const Product = require("../models/product.model");

module.exports.index = (request, response) => {
  response.json({
    message: "Hello World",
  });
};

module.exports.getAll = (req, res) => {
  Product.find()
    .then((allProduct) => res.json({ status: "ok", allProduct }))
    .catch((err) => {
      res.json({ message: "Something went wrong", err });
      console.log(err);
    });
};

module.exports.addProduct = (req, res) => {
  console.log(req.body);
  Product.create(req.body)
    .then((newProduct) => res.json({ status: "ok", newProduct }))
    .catch((err) => {
      res.json({ message: "Something went wrong", err });
      console.log(err);
    });
};
