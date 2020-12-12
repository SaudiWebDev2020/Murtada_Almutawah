const Author = require("../models/author.model");

module.exports.getAll = (req, res) => {
  // Find All Query
  Author.find()
    .then((authors) => res.json({ status: "Success", authors }))
    .catch((err) => res.json({ message: "Something went wrong while getting the authors", err }));
};

module.exports.getOne = (req, res) => {
  // Find One author Query
  Author.findOne({ _id: req.params._id })
    .then((author) => res.json({ status: "Success", author }))
    .catch((err) => res.json({ message: "Something went wrong while getting an author", err }));
};

module.exports.create = (req, res) => {
  // Create an author
  console.log(req.body);
  Author.create(req.body)
    .then((author) => res.json({ status: "Success", author }))
    .catch((err) => res.json({ message: "Something went wrong while creating", err }));
};

module.exports.update = (req, res) => {
  // Update an author
  Author.findOneAndUpdate({ _id: req.params._id }, req.body, { runValidators: true, new: true })
    .then((author) => res.json({ status: "Success", author }))
    .catch((err) => res.json({ message: "Something went wrong while creating", err }));
};

module.exports.remove = (req, res) => {
  // Delete an author
  Author.findOneAndDelete({ _id: req.params._id })
    .then((author) => res.json({ status: "Success", author }))
    .catch((err) => res.json({ message: "Something went wrong while creating", err }));
};
