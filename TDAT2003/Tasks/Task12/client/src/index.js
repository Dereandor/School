// @flow
/* eslint eqeqeq: "off" */


import * as React from 'react';
import { Component,sharedComponentData } from 'react-simplified';
import { HashRouter, Route, NavLink, Redirect,Switch } from 'react-router-dom';
import ReactDOM from 'react-dom';
import Popup from 'reactjs-popup';
var Base64 = require('js-base64').Base64;
import {
  Alert,
  ListGroup,
  NavBar,
  Oppsett,
  Input,
  Row,
  Column,
  ContainerFluid,
  Overskrift,
  ListGroupInline,
  CheckBox,
  Card
} from './widgets';
import { articleService, categoryService, Article, CreateArticle, CreateComment} from './services';

import createHashHistory from 'history/createHashHistory';
const history = createHashHistory(); // Use history.push(...) to programmatically change path, for instance after successfully saving a student
