// @flow
import axios from 'axios';

export class Article {
  articleID: number;
  title: string;
  imagelink: string;
  content: string;
  timestamp: string;
  rating: number;
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

class Categories{
  name: string;
}

class ArticleService {

}
