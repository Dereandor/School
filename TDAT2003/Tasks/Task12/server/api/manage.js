const express = require('express');
const router = express.Router();
const mysql = require('mysql');
const bodyParser = require('body-parser');
const NewsDao = require('../dao/NewsDao');

type Request = express$Request;
type Response = express$Response;

var pool = mysql.createPool({
    connectionLimit: 5,
    host: "mysql.stud.iie.ntnu.no",
    user: "torstehs",
    password: "Pzp58gsc",
    database: "torstehs",
    debug: false,
    multipleStatements: true
});

let newsDao = new NewsDao(pool);