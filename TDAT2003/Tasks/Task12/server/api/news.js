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

router.get("/",(req: Request, res: Response) => {
    console.log("/manage/ request from client");
    newsDao.getAllArticles((status, data) => {
        res.status(status);
        res.json(data);
    })
});

router.get("/category/:articleID", (req: Request, res: Response) => {
    console.log("/category/:articleID got request from client");
    newsDao.getArticleByID(req.params.articleID, (status, data) =>{
        res.status(status);
        res.json(data);
    })
});

router.get("/categories", (req: Request, res: Response) => {
    console.log("/Category request from client");
    newsDao.getAllCategories((status, data)=> {
        res.status(status);
        res.json(data);
    })
});

module.exports = router;