const Dao = require("./Dao.js");

module.exports = class NewsDao extends Dao {
    createArticle(json: Object, callback: (status: string, data: string) => void) {
        let newArticle = [json.title, json.content, json.imagelink, json.important, json.categoryName];
        console.log("article", newArticle);
        super.query("INSERT INTO article VALUES (DEFAULT, ?, DEFAULT, ?, ?, ?, 0, ?)",
            newArticle, callback);
    }

    updateArticle(json: Object, articleID: number, callback: (status:string, data:string) => void) {
        let update = [json.title, json.content, json.imagelink, json.important, json.categoryName, articleID];
        super.query("UPDATE article SET title = ?, content = ?, imagelink = ?, important = ?, categoryName = ? WHERE articleID = ?",
            update, callback)
    }

    deleteArticle(articleID: number, callback: (status: string, data: string) => void) {
        super.query("DELETE FROM article WHERE articleID = ?", [articleID], callback);
    }

    getAllArticles(callback: (status: string, data: string) => void){
        super.query("SELECT articleID,title,categoryName FROM article ORDER BY articleID",
            [], callback);
    }

    getImportantArticles(callback: (status: string, data: string) => void) {
        super.query("SELECT articleID, title,rating,imagelink,categoryName FROM article WHERE important IS TRUE ORDER BY rating DESC, articleID DESC",
            [], callback);
    }

    getArticleByCategory(categoryName: string, callback: (status: string, data: string)=>void) {
        super.query("SELECT articleID, title, rating, imagelink, categoryName FROM article WHERE categoryName = ? ORDER BY rating DESC, articleID DESC",
            [categoryName], callback);
    }

    getAllCategories(callback: (status: string, data: string) => void) {
        super.query("SELECT name from category", [], callback);
    }

    getArticleByID(articleID: number, callback: (status: string, data: string) => void){
        super.query("SELECT articleID, title, content, DATE_FORMAT(timestamp, '%Y-%m-%d %H:%i') AS timestamp, rating, imagelink, categoryName, important FROM article WHERE articleID=?",
            [articleID], callback);
    }

    getNewestArticles(callback: (status: string, data: string) => void) {
        super.query("SELECT title, timestamp FROM article ORDER BY timestamp DESC LIMIT 10", [], callback);
    }

    updateRating(json: Object, articleID: number, callback: (status: string, data: string) => void) {
        let update = [json.rating, articleID];
        super.query("UPDATE article SET rating = ? WHERE articleID = ?",
            update, callback);
    }

    createComment(json: Object, callback: (status: string, data: string) => void) {
        let comment = [json.commentName, json.content, json.articleID];
        console.log("comment: ", comment);
        super.query("INSERT INTO comment VALUES(DEFAULT, ?, ?, ?, DEFAULT, 0)", comment, callback);
    }

    getCommentsByArticleID(articleID: number, sortByColumn: string, sortingOrder: string, callback: (status: string, data: string) => void) {
        console.log("comments for articleID: ", articleID);
        super.query("SELECT commentID, commentUser, content, DATE_FORMAT(timestamp, '%Y-%m-%d %H:%i') AS timestamp, commentRating FROM comment WHERE articleID = ? ORDER BY ${sortByColumn} ${sortingOrder}",
            [articleId], callback);
    }

    updateCommentRating(json: Object, commentID: number, callback: (status: string, data: string) => void) {
        let update = [json.commentRating, commentID];
        super.query("UPDATE comment SET commentRating = ? where commentID = ?", update, callback);
    }
}