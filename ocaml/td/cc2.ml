(*Écrire la fonction f : int -> float telle que  
   f(0) = 2
   f(1) = 1
   f(n+1) = f(n-1)+7racine(f(n))  *)

let f1 n = 
  let rec aux i = match i with
  |0->(2.,-1.)
  |1->(1.,2.)
  |x-> let fn_1,fn_2 = aux(i-1) in 
      let fn = fn_2 +. 7. *. sqrt(fn_1) in fn,fn_1
in fst(aux n)  

let x = f1 0;;

(*Écrire la fonction f : int -> int telle que
f(0) = 4
f(1) = 1
f(2) = 1
f(n+1) = f(n) f(n-1) - f(n-2)   
*)  


let f n = 
  if n= 0 then 4
  else if n =1 then 1 
  else if n=2 then 2 else
    let rec aux i acc1 acc2 acc3 = 
      if i>n then acc3 else
        aux (i+1) acc2 acc3 (acc3*acc2-acc1)
    in aux 3 4 1 1;;    
(*Écrire la fonction translation : int list -> int -> int -> int list telle que translation v n t renvoie le vecteur v dont la n ième coordonnée a été translaté de t . On supposera n positif et on comptera à partir de 0. Si n est plus grand que la taille du vecteur, v ne sera pas modifié.

Par exemple translation [3;8;-9] 1 -5 renvoie   [3;3;-9].*)
let rec translation v n t = 
  let rec aux vecteur i pos ajout = match i,vecteur with 
    |(u,x::tail)->if u= pos then (x+ajout::tail) else x:: aux tail (i+1) pos ajout
    |(pos,[])->vecteur 
in aux v 0 n t 


(*Une base de données inefficace. A partir du type :

 type valeur = Name of string  |  Year of int

écrire une fonction   plus_un : (int*valeur) list-> (int*valeur) list telle que  plus_un b accroisse de 1 toutes les années de la base de données  b. Il faut donc renvoyer une nouvelle liste dans laquelle les couples  (x,Year y) sont remplacés par  (x,Year (y+1)).*)

type valeur = Name of string  | Year of int

let rec plus_un liste = match liste with
    |[]->[]
    |(x,Year n)::tail ->(x,Year (n+1)):: (plus_un tail )
    |m::tail2-> m:: (plus_un tail2)

(*
Écrire la fonction g : ('a * 'a -> 'b ) ->'a -> 'b  telle que g ait le bon type, n'importe quelle fonction convient.*)
let g f a = f(a,a)

(*Écrire la fonction récursive mul3 : 'a list -> 'a list telle que mul3 l renvoie la liste contenant les éléments de l dont la position est un multiple de 3. Par exemple  [1;2;3;4;5;6;7;8] = [1;4;7].*)
let rec mul3 liste = match liste with
    |[]-> []
    |r::[]->[r]
    |x::y::[]->[x]
    |u::v::w::tail-> u:: mul3 tail


