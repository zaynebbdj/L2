let carre x = x*x
let pow7 n = n* carre n * carre(carre n)

let xor x y =
  if (x=true && y=false) ||(x=false && y=true) then true
  else false

let perimeter x y = x+.x+.y+.y  
let arg_min2 x y =
    if x<y then 1
    else 2 

let arg_min3 x y z =
      if z>x || z>y then arg_min2 x y
      else 3 
let arg_min4 x y z d =
        if d>x || d>y || d>z then arg_min3 x y z
        else 4    
let scalaire x y z d = x*.z +.y*.d
let proj_diag x y =x*.(sqrt 2.)/.2. +.y*.(sqrt 2.)/.2.
let opp_abs x = 
  if x<0 then x
  else (-1)*x
 
let opp_pred x =(-1)*pred x  

let opp_succ x = (-1)*succ x

let opp_fct f x = (-1)*f x

let min_arg2 f  = 
    if f 1 < f 2 then 1
    else 2
let min_arg3 f =
      if f 3 >= f 2 || f 3 >= f 1 then min_arg2 f
      else 3    
let min_arg4 f =
        if f 4 >= f 2 || f 4 >= f 1 || f 4 >= f 3 then min_arg3 f
        else 4  
let rec min_arg_n = fun n ->fun f->
          if n=1 then 1
          else (let min_arg =  min_arg_n (n-1) f  in
                if f min_arg<=f n then min_arg else n);;   
let applique2 f x = f (f x)            
