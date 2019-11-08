class Dao {
    contructor(pool){
        this.pool = pool;
    }

    query(sql, parameters, callback) {
        this.pool.getConnection((err, connection) => {
            console.log("Connected to MySQL DB");
            if(err) {
                console.log("Connection error");
                callback(500, {error: "problems connecting to db"});
            } else {
                console.log("Running query: " + sql);
                connection.query(sql, parameters, (err, rows) => {
                    connection.release();
                    if (err) {
                        console.log(err);
                        callback(500, {error: "query error"});
                    } else if(rows.length===0) {
                        console.log("empty");
                        callback(404, {error: "page not found"});
                    } else {
                        console.log("Returning result :" + "\n" + rows);
                        callback(200, rows);
                    }
                });
            }
        });
    }
};