// @flow

let v1 = [1, 2, 3];
let v2 = [4,5,6];

/* 
2 + v1: [ 3, 4, 5 ]
2 * v1: [ 2, 4, 6 ]
mean of v1: 2
v1 dot v2: 32
sum of v1 + 2 * v2: 36
v1 as string: v1[0] = 1, v1[1] = 2, v1[2] = 3 
*/

function dotp(x,y) {
    function dotp_sum(a,b) { return a + b; }
    function dotp_times(a,i) { return x[i] * y[i]; }
    if (x.length != y.length)
        throw "can't find dot product: arrays have different lengths";
    return x.map(dotp_times).reduce(dotp_sum,0);
}

console.log('2 + v1:', v1.map(e=> 2 + e));
console.log('2 * v1:', v1.map(e=> 2 * e));
console.log('mean of v1:', v1.reduce((a,b) => a + b, 0) / v1.length);
console.log('v1 dot v2:', dotp(v1,v2));
console.log('sum of v1 + 2 * v2:', v1.reduce((a,b) => a + b, 0) + v2.map(e => 2 * e).reduce((a,b) => a + b, 0));
console.log('v1 as String:', v1.map((e,i) => 'v1[' + i + '] = ' + e).toString());
