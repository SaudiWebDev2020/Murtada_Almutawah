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
   ```

2. Create Server File

   ```bash
   touch server.js
   ```

3. Create Server Structure

   ```bash
   mkdir server
   cd server
   mkdir config controllers models routes
   ```

4. Configure server.js

   ```js
   const express = require("express");
   const app = express();
   const port = 8000;

   app.listen(port, () => console.log(`Listening on port: ${port}`));
   ```

## Client

1. create a react client

   ```bash
   npx create-react-app client
   ```
