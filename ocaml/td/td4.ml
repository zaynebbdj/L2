let first (a,b) = a
let second (a,b) = b

let po_pair (x,y) =
  if x<=y then (x,y)
  else (y,x)
let is_empty (a,b) =
  if a>b then true
  else false

let inclus x (a,b) =
  if x>=a && x<= b then true
  else false
 
let intersection (x,y) (a,b) =
    if inclus a (x,y) && inclus b (x,y) then (a,b)
    else if inclus a (x,y) && (is_empty (a,b))=false then (a,y)
    else if inclus x (a,b) && inclus y (a,b) then (x,y)
    else if inclus x (a,b) && (is_empty (x,y))=false then (x,b)
    
    else (3.,2.)

let rec fibonacci_1 n =
  if (n=0 ||n=1) then 1
  else fibonacci_1 (n-1) +fibonacci_1 (n-2)
 
let rec fibonacci_2 n =
  if (n=1 ) then (1,1)
    
  else  let (a,b) = fibonacci_2 (n-1) in (b,a+b)
    

let applique2 x f = f (f x)

let applique2_2 f x = f(f x)
let rec applique_n n f x=
    if n<0 then failwith "entier negatif"
    else if n=0 then x
    else f ( applique_n (n-1) f x )
let frac_mul (a,b) (x,y) = (a*x,b*y)

let frac_add (a,b) (x,y) = (a*y+b*x,y*b)

let rec pgcd a b =
  if b=0 then a
  else if b=1 then 1
  else pgcd b (a mod b)

let frac_irr (a,b)= 
  if (b/ (pgcd a b) )<0 then ((-a)/ pgcd a b , -b/ (pgcd a b) )
  else (a/ (pgcd a b ), b/ (pgcd a b) )

let frac_eq (a,b) (x,y) =
  if frac_irr (a,b) = frac_irr (x,y) then true
  else false 
  