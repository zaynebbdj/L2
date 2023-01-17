(*Écrire la fonction f : float -> int -> float telle que
 f(x,y)=cos(1x)+y ; 
   on ne traitera pas le cas x=0.*)

let f x y = cos(1./.x) +.(float_of_int y)

(*Écrire la fonction  f : float -> int -> float telle que f(x,y)=xcos(y) *)
let f x y = x*.cos(float_of_int y)

(*Écrire la fonction f : int -> int telle que 
   f(0) = 10 
   f(n+1) = f(n) -n *)
let rec f n = 
  if n=0 then 10
  else (f (n-1)) - (n-1)

(*  Écrire la fonction f : int -> float telle que :  
   f(0) = 0
   f(n+1) = f(n)+(1/n+1)*)
  let rec f n = 
    if n=0 then 0.
    else if n=1 then 1.
    else  f (n-1) +. (1./.( float_of_int n))   

(*Écrire la fonction f : int -> int  telle que  
   f(0) = 0
   f(1) = 0
   f(n+1) = 2 + f(n) - f(n-1)*)
let f n = 
  let rec aux i = match i with 
  |0->(0,-1)
  |1->(0,0)
  |x-> let fn_1,fn_2 = aux (i-1) in
        let fn = 2+ fn_1 - fn_2 in fn,fn_1    
in fst (aux n)    

(*Écrire la fonction f : int -> int telle que  
   f(0)=1
   f(1)=1
   f(n+1)=2f(n)+3f(n−1)*)
let f1 n = 
  let rec aux i = match i with
  |0->(1,-1)
  |1->(1,1)
  |x-> let fn_1,fn_2 = aux (n-1) in  
        let fn = 2*fn_1 +3* fn_2 in fn,fn_1 
in fst (aux n)

(*Écrire la fonction f : (int->int) -> (int->int) -> int telle que
    f(g,h)=g(h(0)) si h(0)>g(0) et h(g(0)) sinon.*)
let f g h =
  if(h(0)>g(0)) then g(h(0))
  else h(g(0))   
     
  
(*Écrire la fonction f : (int->int) -> int -> int telle que
    f(g,x)=g(g(x)) si g(x)>0 et g(x) sinon.*) 
let f g x=
  if g(x)>0 then g(g(x))
  else g(x)  
  
(*Écrire la fonction intervalle : int list -> int -> int -> bool telle que 
   intervalle l mini maxi renvoie true si tous les éléments de l
    sont compris dans l'intervalle [mini,maxi], et renvoie false sinon.*)  
let rec intervalle l min max =match l with
  |[]->true
  |x::tail -> if x>max || x<min then false else 
  intervalle tail min max

(*Écrire la fonction mult_list : int list -> int list -> int list telle que 
mult_list l1 l2 renvoie la multiplication terme à terme de l1 et l2. 
Si une liste est plus longue que l'autre, 
alors on s'arrête lorsque l'on arrive au bout de la plus petite. 
   Par exemple mult_list [3; 2; 1] [2; 1; 0; 4; 5] renvoie la liste  [6; 2; 0]*)  
let rec mult_list l1 l2 = match l1,l2 with
    |[],[]->[]
    |[],l2->l2
    |l1,[]->l1
    |x::tail1,y::tail2 -> (x*y):: mult_list tail1 tail2
          