// @flow
/* eslint eqeqeq: "off" */

import * as React from 'react';
import { Component } from 'react-simplified';
import { HashRouter, Route, NavLink } from 'react-router-dom';
import ReactDOM from 'react-dom';

class Student {
  id: number;
  static nextId = 1;

  firstName: string;
  lastName: string;
  email: string;

  constructor(firstName: string, lastName: string, email: string) {
    this.id = Student.nextId++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
let students = [
  new Student('Ola', 'Jensen', 'ola.jensen@ntnu.no'),
  new Student('Kari', 'Larsen', 'kari.larsen@ntnu.no')
];

class Courses {
  courseId: number;
  static nextCourseId = 1;
  
  courseName: string;
  courseCode: string;

  constructor(courseName: string, courseCode: string) {
    this.courseId = Courses.nextCourseId++;
    this.courseName = courseName;
    this.courseCode = courseCode;
  }
}
let courses = [
  new Courses('Systemutvikling 2 med web-applikasjoner', 'TDAT2003'),
  new Courses('Algoritmer og Datastrukturer', 'TDAT2005')
];

class Menu extends Component {
  render() {
    return (
      <table>
        <tbody>
          <tr>
            <td>
              <NavLink activeStyle={{ color: 'darkblue' }} exact to="/">
                React example
              </NavLink>
            </td>
            <td>
              <NavLink activeStyle={{ color: 'darkblue' }} to="/students">
                Students
              </NavLink>
            </td>
            <td>
              <NavLink activeStyle={{color: 'darkblue'}} to="/courses">
                Courses
              </NavLink>
            </td>
          </tr>
        </tbody>
      </table>
    );
  }
}

class Home extends Component {
  render() {
    return <div>React example with static pages</div>;
  }
}

class StudentList extends Component {
  render() {
    return (
      <ul>
        {students.map(student => (
          <li key={student.id}>
            <NavLink activeStyle={{ color: 'darkblue' }} to={'/students/' + student.id}>
              {student.firstName} {student.lastName}
            </NavLink>
          </li>
        ))}
      </ul>
    );
  }
}

class StudentDetails extends Component<{ match: { params: { id: number } } }> {
  render() {
    let student = students.find(student => student.id == this.props.match.params.id);
    if (!student) {
      console.error('Student not found'); // Until we have a warning/error system (next week)
      return null; // Return empty object (nothing to render)
    }
    return (
      <div>
        <ul>
          <li>First name: {student.firstName}</li>
          <li>Last name: {student.lastName}</li>
          <li>Email: {student.email}</li>
        </ul>
      </div>
    );
  }
}

class CourseList extends Component {
  render() {
    return (
      <ul>
        {courses.map(courses => (
          <li key={courses.courseId}>
            <NavLink activeStyle={{color: 'darkblue'}} to={'/courses/' + courses.courseId}>
            {courses.courseCode} {courses.courseName} 
            </NavLink>
          </li>
        ))}
      </ul>
    );
  }
}

class CourseDetails extends Component<{match: {params: {id: number} } }> {
  render() {
    let course = courses.find(course => course.courseId == this.props.match.params.id);
    if(!course) {
      console.error('class not found');
      return null;
    }
    return (
      <div>
        <ul>
          <li>Course name: {course.courseName}</li>
          <li>Course Code: {course.courseCode}</li>
        </ul>
      </div>
    )
  }
}

const root = document.getElementById('root');
if (root)
  ReactDOM.render(
    <HashRouter>
      <div>
        <Menu />
        <Route exact path="/" component={Home} />
        <Route path="/students" component={StudentList} />
        <Route path="/students/:id" component={StudentDetails} />
        <Route path="/courses" component={CourseList} />
        <Route path="/courses/:id" component={CourseDetails} />
      </div>
    </HashRouter>,
    root
  );
