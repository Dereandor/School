const express = require('express');
const router = express.Router();
const mysql = require('mysql');
const bodyParser = require('body-parser');
const NewsDao = require('../dao/NewsDao');
const Base64 = require('js-base64').Base64;

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
    });
});

router.post("/", (req: Request, res: Response) => {
    console.log("POST-request from client");
    req.body.content = Base64.encode(req.body.content);
    newsDao.createArticle(req.body, (status, data) => {
        res.status(status);
        res.json(data);
    });
});

router.put("/:articleID", (req: Request, res: Response) => {
    console.log("PUT-request from client");
    req.body.content = Base64.encode(req.body.content);
    newsDao.updateArticle(req.body, req.params.articleID, (status, data) => {
        res.status(status);
        res.json(data);
    });
});

router.delete("/:articleID", (req: Request, res: Response) => {
    console.log("DELETE-request from client");
    newsDao.deleteArticle(req.params.articleID, (status, data) => {
        res.status(status);
        res.json(data);
    });
});

router.get("/filter/:categoryName/:searchWord", (req:Request, res: Response) => {
    console.log("GET-request from client");
    newsDao.filteredByCategoryAndTitle(req.params.categoryName, req.params.searchWord, (status, data) => {
        res.status(status);
        res.json(data);
    });
});

router.get("/filter/:search", (req: Request, res: Response) => {
    newsDao.filterArticles(req.params.search, (status, data) => {
        res.status(status);
        res.json(data);
    });
});