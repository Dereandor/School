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

    updateRating(json: Object, articleID: number, callback: (status: string, data: string) => void) {
        let update = [json.rating, articleID];
        super.query("UPDATE article SET rating = ? WHERE articleID = ?",
            update, callback);
    }
}