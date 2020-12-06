// Express Configuration
const express = require("express");
const app = express();
const port = 8000;

// Faker Configuration
const faker = require("faker");

// Classes

class User {
  constructor() {
    this._id = faker.random.uuid();
    this.firstName = faker.name.firstName();
    this.lastName = faker.name.lastName();
    this.phoneNumber = faker.phone.phoneNumber();
    this.email = faker.internet.email();
    this.password = faker.internet.password();
  }
}

class Company {
  constructor() {
    this._id = faker.random.uuid();
    this.name = faker.company.companyName();
    this.address = {
      street: faker.address.streetAddress(),
      city: faker.address.city(),
      state: faker.address.state(),
      zipCode: faker.address.zipCode(),
      country: faker.address.country(),
    };
  }
}

// DB
const Users = [];
const Companies = [];

app.get("/api", (req, res) => {
  res.json({ status: "ok", Users, Companies });
});

app.get("/api/users/new", (req, res) => {
  let user = new User();
  Users.push(user);
  res.json(user);
});

app.get("/api/companies/new", (req, res) => {
  let company = new Company();
  Companies.push(company);
  res.json({ status: "ok", company });
});

app.get("/api/user/company", (req, res) => {
  let company = new Company();
  let user = new User();
  Companies.push(company);
  Users.push(user);
  res.json({ status: "ok", company, user });
});

const startMessage = (port) => {
  console.log("Server is locked and loaded on port " + port);
};

const server = app.listen(port, startMessage(port));
