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
    });
});

router.get("/category/:articleID", (req: Request, res: Response) => {
    console.log("/category/:articleID got request from client");
    newsDao.getArticleByID(req.params.articleID, (status, data) =>{
        res.status(status);
        res.json(data);
    });
});

router.get("/categories", (req: Request, res: Response) => {
    console.log("/Category request from client");
    newsDao.getAllCategories((status, data)=> {
        res.status(status);
        res.json(data);
    });
});

router.post("/createComment/article", (req: Request, res: Response) => {
    console.log("POST-request from client");
    newsDao.createComment(req.body, (status, data) => {
        res.status(status);
        res.json(data);
    });
});

router.put("/rating/:articleID", (req: Request, res: Response) => {
    console.log("PUT-request from client");
    newsDao.updateRating(req.body, req.params.articleID, (status, data) => {
        res.status(status);
        res.json(data);
    });
});

router.put("/rating(:articleID/:commentID", (req: Request, res: Response) => {
    console.log("PUT-request received from client");
    newsDao.updateCommentRating(req.body, req.params.commentID, (status, data) => {
        res.status(status);
        res.json(data);
    });
});

router.get("/comments/:articleID")

module.exports = router;