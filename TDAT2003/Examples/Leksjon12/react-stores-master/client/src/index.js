// @flow

import ReactDOM from 'react-dom';
import * as React from 'react';
import { Component } from 'react-simplified';
import { HashRouter, Route, NavLink } from 'react-router-dom';
import { Alert, NavBar, Card, Row, Column, Button } from './widgets';
import { Student, studentStore } from './stores';

// Reload application when not in production environment
if (process.env.NODE_ENV !== 'production') {
  let script = document.createElement('script');
  script.src = '/reload/reload.js';
  if (document.body) document.body.appendChild(script);
}

import { createHashHistory } from 'history';
const history = createHashHistory(); // Use history.push(...) to programmatically change path, for instance after successfully saving a student

class Menu extends Component {
  render() {
    return (
      <NavBar brand="React example">
        <NavBar.Link to="/students">Students</NavBar.Link>
      </NavBar>
    );
  }
}

class Home extends Component {
  render() {
    return <Card title="React example"></Card>;
  }
}

class StudentList extends Component {
  render() {
    return (
      <Card title="Students">
        {studentStore.students.map(student => (
          <Row key={student.id}>
            <Column width={2}>
              <NavLink activeStyle={{ color: 'darkblue' }} exact to={'/students/' + student.id}>
                {student.firstName} {student.lastName}
              </NavLink>
            </Column>
            <Column>
              <NavLink activeStyle={{ color: 'darkblue' }} to={'/students/' + student.id + '/edit'}>
                edit
              </NavLink>
            </Column>
          </Row>
        ))}
      </Card>
    );
  }

  mounted() {
    studentStore.getStudents().catch((error: Error) => Alert.danger(error.message));
  }
}

class StudentDetails extends Component<{ match: { params: { id: number } } }> {
  render() {
    return (
      <Card title="Details">
        <Row>
          <Column width={2}>First name</Column>
          <Column>{studentStore.currentStudent.firstName}</Column>
        </Row>
        <Row>
          <Column width={2}>Last name</Column>
          <Column>{studentStore.currentStudent.lastName}</Column>
        </Row>
        <Row>
          <Column width={2}>Email</Column>
          <Column>{studentStore.currentStudent.email}</Column>
        </Row>
      </Card>
    );
  }

  mounted() {
    studentStore.getStudent(this.props.match.params.id).catch((error: Error) => Alert.danger(error.message));
  }
}

class StudentEdit extends Component<{ match: { params: { id: number } } }> {
  render() {
    return (
      <Card title="Edit">
        <form>
          <Row>
            <Column width={2}>First name</Column>
            <Column>
              <input
                type="text"
                value={studentStore.currentStudent.firstName}
                onChange={(event: SyntheticInputEvent<HTMLInputElement>) => {
                  studentStore.currentStudent.firstName = event.target.value;
                }}
              />
            </Column>
          </Row>
          <Row>
            <Column width={2}>Last name</Column>
            <Column>
              <input
                type="text"
                value={studentStore.currentStudent.lastName}
                onChange={(event: SyntheticInputEvent<HTMLInputElement>) => {
                  studentStore.currentStudent.lastName = event.target.value;
                }}
              />
            </Column>
          </Row>
          <Row>
            <Column width={2}>Email</Column>
            <Column>
              <input
                type="text"
                value={studentStore.currentStudent.email}
                onChange={(event: SyntheticInputEvent<HTMLInputElement>) => {
                  studentStore.currentStudent.email = event.target.value;
                }}
              />
            </Column>
          </Row>
          <Button.Danger onClick={this.save}>Save</Button.Danger>
        </form>
      </Card>
    );
  }

  mounted() {
    studentStore.getStudent(this.props.match.params.id).catch((error: Error) => Alert.danger(error.message));
  }

  save() {
    studentStore
      .updateStudent()
      .then(() => history.push('/students/' + studentStore.currentStudent.id))
      .catch((error: Error) => Alert.danger(error.message));
  }
}

const root = document.getElementById('root');
if (root)
  ReactDOM.render(
    <HashRouter>
      <div>
        <Alert />
        <Menu />
        <Route exact path="/" component={Home} />
        <Route path="/students" component={StudentList} />
        <Route exact path="/students/:id" component={StudentDetails} />
        <Route exact path="/students/:id/edit" component={StudentEdit} />
      </div>
    </HashRouter>,
    root
  );
