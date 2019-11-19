// @flow

var express = require("express");
var bodyParser = require("body.parser");
var app = express();
import path from 'path';
app.use(bodyParser.json());

const public_path = path.join(__dirname, '/../../client/public');

const news = require("../api/news.js");

app.use(express.static(public_path));
app.use('/news', news);
app.use('/manage', manage);

app.listen(8080);
