// @flow

import express from 'express';
import path from 'path';
import reload from 'reload';
import fs from 'fs';
import { type Student, StudentsModel, syncModels } from './models.js';

const public_path = path.join(__dirname, '/../../client/public');

let app = express();

app.use(express.static(public_path));
app.use(express.json()); // For parsing application/json

app.get('/students', (req: express$Request, res: express$Response) => {
  return StudentsModel.findAll().then(students => res.send(students));
});

app.get('/students/:id', (req: express$Request, res: express$Response) => {
  return StudentsModel.findOne({ where: { id: Number(req.params.id) } }).then(student =>
    student ? res.send(student) : res.sendStatus(404)
  );
});

app.put('/students', (req: { body: Student }, res: express$Response) => {
  // Respond with error if id is missing
  if (!req.body.id) return res.sendStatus(400);

  return StudentsModel.update(
    { firstName: req.body.firstName, lastName: req.body.lastName, email: req.body.email },
    { where: { id: req.body.id } }
  ).then(updated => (updated[0] /* affected rows */ > 0 ? res.sendStatus(200) : res.sendStatus(404)));
});

// The listen promise can be used to wait for the database connection and web server to start (for instance in your tests)
export let listen = new Promise<void>((resolve, reject) => {
  // Wait for Sequalize to connect to and initialize the database
  syncModels.then(() => {
    let call_listen = reloader => {
      app.listen(3000, (error: ?Error) => {
        if (error) reject(error.message);
        console.log('Express server started');
        // Start hot reload (refresh web page on client changes) when not in production environment
        if (reloader) {
          reloader.reload(); // Reload application on server restart
          fs.watch(public_path, () => reloader.reload());
        }
        resolve();
      });
    };
    // Setup hot reload (refresh web page on client changes) when not in production environment,
    // and then start the web server.
    if (process.env.NODE_ENV != 'production') reload(app).then(reloader => call_listen(reloader));
    else call_listen();
  });
});
