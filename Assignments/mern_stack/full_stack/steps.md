# Steps

## Create Project

1. Create Folder with the name of the project
2. Initialize npm

   ```bash
   npm init -y
   ```

## Server

1. Install Dependance

   ```bash
   npm install express
   npm install mongoose
   npm install cors
   ```

2. Create Server File

   ```bash
   touch server.js
   ```

3. Create Server Structure
   Note: change name to project name.

   ```bash
   mkdir server
   cd server
   mkdir config controllers models routes
   touch config/mongoose.config.js
   touch controllers/name.controller.js
   touch models/name.model.js
   touch routes/name.routes.js
   ```

4. Configure server.js
   Note: Change the name to route file name

   ```js
   const express = require("express");
   const app = express();
   const port = 8000;

   const cors = require("cors");

   app.use(cors());

   app.use(express.json());
   app.use(express.urlencoded({ extended: true }));

   require("./server/config/mongoose.config");

   require("./server/routes/name.routes")(app);

   app.listen(port, () => console.log(`Listening on port: ${port}`));
   ```

5. Configure mongoose.config.js

## Client

1. Create a react client

   ```bash
   npx create-react-app client
   ```

2. Install dependencies

   ```bash
   cd client
   npm i @reach/router axios bootstrap
   ```

   Note: use npm install <Package_name> --legacy-peer-deps if you use npm v7 and try to install @reach/router

3. Create a Views folder in src if you want to keep the views in a folder
4. Create a Components folder in src if you want to reuse a components.
