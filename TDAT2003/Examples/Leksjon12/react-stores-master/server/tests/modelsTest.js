// @flow

import { type Student, StudentsModel, syncModels } from '../src/models.js';

beforeAll(() => syncModels);

describe('Students test', () => {
  it('correct data', done => {
    StudentsModel.findAll().then(students => {
      expect(
        students
          .map(student => student.toJSON())
          .map((student: Student) => ({
            id: student.id,
            firstName: student.firstName,
            lastName: student.lastName,
            email: student.email
          }))
      ).toEqual([
        {
          id: 1,
          firstName: 'Ola',
          lastName: 'Jensen',
          email: 'ola.jensen@ntnu.no'
        },
        {
          id: 2,
          firstName: 'Kari',
          lastName: 'Larsen',
          email: 'kari.larsen@ntnu.no'
        }
      ]);
      done();
    });
  });
});
