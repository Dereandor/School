// @flow
import { sharedComponentData } from 'react-simplified';
import axios from 'axios';

export class Student {
  id: number = 0;
  firstName: string = '';
  lastName: string = '';
  email: string = '';
}

class StudentStore {
  students: Student[] = [];
  currentStudent: Student = new Student();

  getStudents() {
    return axios.get<Student[]>('/students').then(response => (this.students = response.data));
  }

  getStudent(id: number) {
    return axios.get<Student>('/students/' + id).then(response => {
      this.currentStudent = response.data;

      // Update the students-array as well in case the row has changed
      let student = this.students.find(student => student.id == this.currentStudent.id);
      if (student) Object.assign(student, { ...this.currentStudent }); // Copy data from this.currentStudent to student
    });
  }

  updateStudent() {
    return axios.put('/students', this.currentStudent).then(() => {
      // Update the students-array
      let student = this.students.find(student => student.id == this.currentStudent.id);
      if (student) Object.assign(student, { ...this.currentStudent }); // Copy data from this.currentStudent to student
    });
  }
}
export let studentStore = sharedComponentData(new StudentStore());
