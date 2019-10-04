// @flow

class Complex {
  real: number;
  imag: number;

  constructor(real: number, img: number) {
    this.real = real;
    this.imag = img;
  }
}

/*
v elements as strings: [ '2 + 2i', '1 + 1i' ]
magnitude of v elements: [ 2.8284271247461903, 1.4142135623730951 ]
sum of v: Complex { real: 3, imag: 3 }
*/

let v = [new Complex(2, 2), new Complex(1, 1)];

console.log('v elements as strings:', JSON.stringify(v));