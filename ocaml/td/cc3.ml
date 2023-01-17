(*Écrire la fonction f : int -> int telle que  
f(0)= 1
f(1) = 1 
f(n+1) = 2 f(n) + 3f(n-1)  *)
let rec aux n = match n with 
|0-> (1,-1)
|1->(1,1)
|i-> let (fn_1,fn_2) = aux (n-1) in 
      let fn = 2*fn_1 + 3*fn_2 in fn,fn_1

let h (a,b) = a
let f n = h (aux n) ;;
(*Écrire la fonction val firsts : int -> int list telle que firsts n renvoie la liste des entiers de 0 à  n  (on supposera n positif ou nul). 

Par exemple  firsts 4 = [0; 1; 2; 3; 4].*)

let rec rebour n =
  if n<0 then  [0]
  else n:: rebour (n-1)

let firsts n = List.tl ( List.rev (rebour n))  

(*Écrire la fonction val create_matrix : int -> int -> int -> (int list) list telle que create_matrix m n i renvoie la matrice de taile mxn et d'éléments i représentée par une liste de m listes de n entiers i. On renverra [] si m  ou n sont nuls.*)
let rec liste n i =
  if n=1 then  [i]
  else i:: liste (n-1)  i  

let rec create_matrix m n i = match m,n with 
    |0,0->[]
    |0,i->[]
    |o,0->[]
    |1,x-> [(liste x i)]
    |x,v-> (liste v i) :: create_matrix (m-1) v i ;;

(*On se donne le type suivant :
type couleur = Bleu | RGB of int*int*int

Écrire une fonction mix : couleur -> couleur -> couleur, telle que mix c1 c2 renvoie le mélange des couleurs c1 et c2 au format RGB (la fonction doit donc forcément retourner un RGB et jamais un Bleu), c'est-à-dire que chaque composante du résultat est égale à la moyenne des deux couleurs en entrée (sur ladite composante).*)
type couleur = Bleu | RGB of int*int*int

let mix c1 c2  = match c1,c2 with 
    |Bleu,Bleu -> RGB (0,0,255)
    |Bleu, RGB (a,b,c) -> RGB ( (a)/2 , (b)/2 , (255+c) /2 )
    | RGB (a,b,c),Bleu -> RGB ( (a)/2 , (b)/2 , (255+c) /2 )
    |RGB (x,y,z), RGB (a,b,c) -> RGB ( (x+a)/2 , (y+b)/2 , (z+c) /2 );;
    
(*On se donne le type suivant : type nbar = Infini | Entier of int

Écrire une fonction produit : nbar -> nbar ->nbar, telle que produit a b renvoie le produit entre a et b. A noter que le produit entre 0 et l'infini est une forme indéterminée, on lèvera donc l'exception failwith "Forme indeterminee" dans ce cas-là*)
type nbar = Infini | Entier of int
let produit prims deux = match prims,deux with 
    |Infini, Infini -> Infini
    |Infini,Entier 0-> failwith ("Forme indeterminee")
    |Entier 0, Infini ->failwith ( "Forme indeterminee")
    |Infini, Entier l->Infini
    |Entier o, Infini -> Infini
    |Entier u, Entier v -> Entier (u*v)    
(*Écrire la fonction val triple_of_list : int list -> int*int*int telle que triple_of_list l renvoie le triplet composé des 3 premiers éléments de l. Si l a moins de 3 éléments alors les éléments manquant sont remplacés par 0.

Par exemple triple_of_list [1;2] = (1,2,0) *)
let triple_of_list l = match l with 
    |[]->(0,0,0)
    |x::y::z::tail->(x,y,z)
    |x::[]->(x,0,0)
    |x::y::[]->(x,y,0)
