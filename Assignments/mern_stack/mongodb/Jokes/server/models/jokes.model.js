const mongoose = require("mongoose");

const JokeSchema = new mongoose.Schema(
  {
    setup: { type: String, required: [true, "Setup is required"], minlength: [10, "Setup must be 10 characters or longer"] },
    punchline: { type: String, required: [true, "Punchline is required"], minlength: [3, "Punchline must be 3 characters or longer"] },
  },
  { timestamps: true }
);

module.exports = mongoose.model("joke", JokeSchema);
