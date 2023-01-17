

(* f(n) = f(n-1) - f(n-2) + 9f(n-3))
 f(n+1) = f(n) - f(n-1) + 9* f(n-2) *)


let g (a,b,c) = a

let rec f_aux2 n = match n with 
  | 0 -> (4,-1,-1)
  | 1 -> (4,4,-1)
  | 2 -> (1,4,4)
  | n -> let (fn_1 ,fn_2, fn_3 ) = f_aux2(n-1) in 
          let fn = fn_1 - fn_2 + 9 *fn_3 in  fn, fn_1,fn_2

let fn n  = g (f_aux2 n) ;;  

(*fait une fonction qui retourne la n-ième valeur de la suite de fibonacci en complexité lineaire*)

let rec fib n = match n with 
|0-> (0,-1)
|1->(1,0)
|i-> let (fn_1,fn_2) = fib (n-1) in 
      let fn = fn_1 + fn_2 in fn,fn_1

let h a b = a
let fibo n = h (fib n)      

let fib n = 
  if n<=0 then 0
  else if n=1 then 1
  else let rec aux i a b = 
    if i>n then b else aux (i+1) b (a+b) in 
    aux 2 1 1





let g1 (a,b) = a
let rec f_aux1 n = match n with 
  |0 ->(2.,-1.)
  |1->(1.,2.)
  |n-> let (fn_1, fn_2) = f_aux1 (n-1) in 
        let fn = fn_2 +. 7.*.sqrt(fn_1) in (fn,fn_1)
let f1 n = g1 (f_aux1 n)    


let rec f_aux n = match n with
  |0->(4,-1,-1)
  |1->(1,4,-1)
  |n-> let (fn_1,fn_2,fn_3) = f_aux (n-1) in 
        let fn = fn_1 * fn_2 - fn_3 in (fn,fn_1,fn_2)
let f n = g( f_aux n)

let translation v n t = 
  let rec aux vecteur i pos ajout = match i,vecteur with 
    |(u,x::tail)-> if u=pos then (x+ajout)::tail else x::(aux tail (i+1) pos ajout)
    |(pos,[])->vecteur in
    aux v 0 n t

type valeur = Name of string | Year of int
let rec plus_un liste = match liste with 
      |[]->[]
      |(entier,Year x):: tail1 -> (entier,Year (x+1)):: (plus_un tail1)
      |u::tail2 -> u::(plus_un tail2)

let g f a =f(a,a)

let rec mul3 liste = match liste with
  |[]->[]
  |k::[] -> [k]
  |u::v:: [] -> [u]
  |x::y::z::tail-> x:: (mul3 tail)

let rec merge l1 l2 = match l1,l2 with
  |([],l2)->l2
  |(l1,[])->l1
  |(i::[],taill)->i::taill
  |(x1::x2::tail1, m1::tail2)-> x1::x2::m1::(merge tail1 tail2) 

 
let rec present liste k v = match liste with 
  |[]->false
  |(x,y)::tail-> if x=k then true else present tail k v

(*let rec update liste k v = 
  if(present liste k v) then let rec aux liste entier valeur = match liste with
    |[]->[]
    |(x,y)::tail-> if x=entier then (x,valeur)::(aux tail entier valeur) else (x,y)::(aux tail entier valeur)
in aux liste k v 
else match liste with 
  |[]->[(k,v)]
  |u::tail-> u:: update tail k v*)


let p chaine = chaine.[1]
let rec abc l1 l2 = match l1,l2 with
  |([],l2)->l2
  |(l1,[])->l1
  |(x1::tail1,x2::tail2)-> if ((int_of_char (p x1)) > (int_of_char (p x2))) then  x2::( abc (x1::tail1) tail2) else abc tail1 (x2::tail2)
  
  let build_string l =
    let rec join = function
      [] -> ""
      | [x] -> Printf.sprintf "%s" x (* sprintf dans le code : on veut utiliser la valeur crée *)
    | x::t -> Printf.sprintf "%s,%s" x (join t)
    in Printf.sprintf "{%s}" (join l)
let rec f_aux = function
    0 -> ["{}"]
  | n -> let l = f_aux (n-1) in
    (build_string l)::l


let separe f l = 
  let rec aux liste boo = match liste with 
  |[]->[]
  |h::t-> if f h == boo then h:: (aux t boo) else (aux t boo)
in (aux l true ),(aux l false)


let rec filter f l = match l with 
|[] ->[]
|x::tail-> if f x = None then (filter f tail) else (x:: filter f tail)
let rec liste n i =
  if n<0 then  []
  else i:: liste (n-1) i   


(*fonction qui cree une liste de liste*)
let rec liste n i = 
  if n<0 then []
  else i:: liste (n-1) i

  

