// @flow
import axios from 'axios';

export class Article {
  articleID: number;
  title: string;
  imagelink: string;
  content: string;
  timestamp: string;
  ratingCount: number;
  categoryName: string;
  importance: boolean;
}

export class CreateArticle{
  title: string;
  imagelink: string;
  content: string;
  categoryName: string;
  important: boolean;
}

export class Comment{
  commentID: number;
  commentUser: string;
  content: string;
  timestamp: string;
  commentRatingCount: number;
}

export class CreateComment {
  commentUser: string;
  content: string;
  articleID: number;
}

class Categories{
  name: string;
}

class Count{
  count: number;
}

export class ArticleService {
  getNews(articleNumber: number): Promise<Article[]> {
    return axios.get('/news/page/'+articleNumber);
  }

  getCount(): Promise<Count[]> {
    return axios.get('/news/articleCount');
  }

  getCategoryCount(categoryName: string): Promise<Count[]> {
    return axios.get('/news/countArticles/'+categoryName);
  }

  getArticleByCategory(category: string, articleNumber: number): Promise<Article[]> {
    return axios.get('/news/category/'+category+'/'+articleNumber);
  }

  getArticleByID(articleID: number): Promise<Article[]> {
    return axios.get('/news/category/'+articleID);
  }

  getAllArticles(): Promise<Article[]> {
    return axios.get('/manage');
  }

  createComment(createComment: CreateComment): Promise<void> {
    return axios.post('/news/createComment/article', createComment);
  }

  updateRating(articleID: number, rating: number): Promise<void> {
    return axios.put('/news/rating'+articleID, {ratingCount: rating});
  }

  updateCommentRating(articleID: number, commentID: number, rating: number): Promise<void> {
    return axios.put('/news/rating/'+articleID+'/'+commentID,{commentRatingCount: rating});
  }

  getCommentsByArticle(articleID: number, sortByColumn: string, sortingOrder: string): Promise<Comment[]> {
    return axios.get('/news/comments/'+articleID+'/'+sortByColumn+'/'+sortingOrder);
  }

  getLiveFeed(): Promise<Article[]> {
    return axios.get('/news/liveFeed/');
  }

  createArticle(createArticle: CreateArticle): Promise<void> {
    return axios.post('/manage',createArticle);
  }

  updateArticle(articleID: number, article: Article): Promise<void> {
    return axios.put('/manage'+articleID, article);
  }

  deleteArticle(articleID: number): Promise<void> {
    return axios.delete('/manage/'+articleID);
  }

  filterByCategoryAndTitle(category: string, searchWord: string): Promise<Article[]> {
    return axios.get('/manage/filter'+category+'/'+searchWord);
  }

  filterArticles(articleName: string): Promise<Article[]> {
    return axios.get('/manage/filter'+articleName);
  }
}

class CategoryService {
  getAllCategories(): Promise<Categories[]> {
    return axios.get('/news/categories');
  }
}

export let articleService = new ArticleService();
export let categoryService = new CategoryService();
