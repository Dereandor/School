// @flow

let students = [{ name: 'Ola', grade: 'A' }, { name: 'Kari', grade: 'C' }, { name: 'Knut', grade: 'C' }];

/*
students elements as strings: [ 'Ola got A', 'Kari got C', 'Knut got C' ]
How many got C: 2
Percentage of C grades: 0.6666666666666666
Did anyone get A: Yes
Did anyone get F: No
*/

console.log('Students elements as strings:', students.map(function(e) {return e.name + " got " + e.grade}));

console.log('How many got C:', students.filter(e => e.grade === 'C').length);

console.log('Percentage of C grades:', students.filter(e => e.grade === 'C').length / students.length);

const grade = function(a,b) { 
    if (students.some(e => e.grade === b)) return 'Yes'; 
    else return 'No'
    }

console.log('Did anyone get A:', grade(students, 'A'));

console.log('Did anyone get F:', grade(students, 'F'));