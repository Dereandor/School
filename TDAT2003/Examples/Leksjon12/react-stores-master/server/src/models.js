// @flow

import Sequelize from 'sequelize';
import type { Model } from 'sequelize';

// Connect to mysql-database
let sequelize = new Sequelize('School', 'root', '', {
  host: process.env.CI ? 'mysql' : 'localhost', // The host is 'mysql' when running in gitlab CI
  dialect: 'mysql'
});

// Types for database table Students
export type Student = {
  id?: number,
  firstName: string,
  lastName: string,
  email: string
};

// Create database table Students
export let StudentsModel: Class<Model<Student>> = sequelize.define('Students', {
  id: { type: Sequelize.INTEGER, primaryKey: true, autoIncrement: true },
  firstName: Sequelize.STRING,
  lastName: Sequelize.STRING,
  email: Sequelize.STRING
});

// Drop tables and create test data when not in production environment
let production = process.env.NODE_ENV === 'production';
// The sync promise can be used to wait for the database to be ready (for instance in your tests)
export let syncModels = sequelize.sync({ force: production ? false : true }).then(() => {
  // Create test data when not in production environment
  if (!production)
    return StudentsModel.create({
      firstName: 'Ola',
      lastName: 'Jensen',
      email: 'ola.jensen@ntnu.no'
    }).then(() =>
      StudentsModel.create({
        firstName: 'Kari',
        lastName: 'Larsen',
        email: 'kari.larsen@ntnu.no'
      })
    );
});
