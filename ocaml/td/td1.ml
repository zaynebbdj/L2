let ajout_num s n = s^(string_of_int n)


let c x =x*.x
let distance x y z t = sqrt( c (  z -.  x) +. c ( t -.  y))

let appartientDisque x y  r = distance x y 0. 0. <= r

let sgn x = match x with 
|0.->0
|r-> if r<0. then -1 else 1

let abs x = sgn (float_of_int x) * x