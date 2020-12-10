const Product = require("../models/product.model");

module.exports.index = (request, response) => {
  response.json({
    message: "Hello World",
  });
};

module.exports.getAll = (req, res) => {
  Product.find()
    .then((allProducts) => res.json({ status: "ok", allProducts }))
    .catch((err) => {
      res.json({ message: "Something went wrong", err });
      console.log(err);
    });
};

module.exports.getOne = (req, res) => {
  Product.findOne({ _id: req.params._id })
    .then((product) => res.json({ status: "ok", product }))
    .catch((err) => {
      res.json({ message: "Something went wrong", err });
      console.log(err);
    });
};

module.exports.createProduct = (req, res) => {
  console.log(req.body);
  Product.create(req.body)
    .then((newProduct) => res.json({ status: "ok", newProduct }))
    .catch((err) => {
      res.json({ message: "Something went wrong", err });
      console.log(err);
    });
};

module.exports.updateProduct = (req, res) => {
  Product.findOneAndUpdate({ _id: req.params._id }, req.body, { new: true, runValidators: true })
    .then((updatedProduct) => res.json({ status: "ok", updatedProduct }))
    .catch((err) => {
      res.json({ message: "Something went wrong", err });
      console.log(err);
    });
};

module.exports.remove = (req, res) => {
  console.log(req.params);
  Product.deleteOne({ _id: req.params._id })
    .then((product) => res.json({ status: "ok", product }))
    .catch((err) => {
      res.json({ message: "Something went wrong", err });
      console.log(err);
    });
};
