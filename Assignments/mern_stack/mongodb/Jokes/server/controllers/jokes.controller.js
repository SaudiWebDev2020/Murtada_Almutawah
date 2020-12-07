const Joke = require("../models/jokes.model");

module.exports.getAll = (req, res) => {
  // return a list of all jokes
  Joke.find()
    .then((allJokes) => res.json(allJokes))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};
module.exports.getOne = (req, res) => {
  // return the joke with matching "_id"
  Joke.find({ _id: req.params._id })
    .then((oneJoke) => {
      res.json(oneJoke);
    })
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};
module.exports.random = (req, res) => {
  // return a random joke
  // console.log("Random");
  Joke.count()
    .then((count) => {
      let random = Math.floor(Math.random() * count);

      // console.log(random);

      Joke.findOne()
        .skip(random)
        .then((oneJoke) => {
          res.json(oneJoke);
        })
        .catch((err) => res.json({ message: "Something went wrong inside", error: err }));
    })
    .catch((err) => res.json({ message: "Something went wrong outside", error: err }));
};
module.exports.create = (req, res) => {
  // create a new joke
  Joke.create(req.body)
    .then((newJoke) => res.json(newJoke))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};
module.exports.update = (req, res) => {
  // updates the joke with matching "_id"
  // new will return the new updated version.
  Joke.findOneAndUpdate({ _id: req.params._id }, req.body, { new: true, runValidators: true })
    .then((updatedJoke) => res.json(updatedJoke))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};
module.exports.delete = (req, res) => {
  // Remove the joke with matching "_id"
  Joke.deleteOne({ _id: req.params._id })
    .then((result) => res.json(result))
    .catch((err) => res.json({ message: "Something went wrong", error: err }));
};
