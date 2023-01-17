let rec f1 = function
|0 -> (0. , -1.)
|1 -> (0. , 0.)
|n -> let (fn_1 , fn_2) = f1 (n-1) in
		let fn =(cos fn_1) -. (sin fn_2) in 
		(fn,fn_1)

(*let rec f2 = function 
|0 -> (1 , -1)
|1 -> (1 , 1)
|n -> let (fn_1 , fn_2) =f2 (n-1) in
		let fn = n*fn_1-3+ fn_1 in *)
		

(*  f_aux(n) = (f(n),f(n-1))  *)

let rec f_aux = function 
| 0 -> (1,-1)
|1 -> (1 , 1)
|n -> let (fn_1 , fn_2) = f_aux (n-1) in
		let fn = (n-1)*fn_1-3+ fn_2 in
			(fn , fn_1) 
let f n =(f_aux n) 

let test = Printf.printf "salut"

		

let rec compteur_aux i n = 
	if i=n then [n]
	else let l = compteur_aux  (i+1) n  in 
	i :: l
let rec rebour n =
if n<0 then  []
else n:: rebour (n-1)



(* 
f(0) = "{}"
f(n) = "{"^f(n-1)^","^f(n-2)^...^f(0)^"}"

f(1)= {{}}
f(2)= {{{}},{}}
f(3)= ...
 *)

(* f_aux(n) = [f n; f(n-1); f(n-2); ... ; f 0] *)

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

let f n = List.hd (f_aux n)

let f n = match f_aux n with
    x::_ -> x
  | [] -> failwith "assertion error"

let _ = Printf.printf "%s\n" (f 0) (* printf dans les test : on veut afficher la valeur crée *)
let _ = print_endline (f 1)
let _ = print_endline (f 2)
let _ = print_endline (f 3)

let rec merge l1 l2 = match l1, l2 with
	|[],l2-> l2
	|l1,[]-> l1
	|x1::[],l2 -> x1::l2
	|h11::h12::t1 , h2::t2 -> h11::h12::h2::(merge t1 t2)
			   
(*
let rec rev_append l1 l2 =
			match l1 with
				[] -> l2
			| a :: l -> rev_append l (a :: l2)

let rev l = rev_append l []

let[@tail_mod_cons] rec init i last f =
			if i > last then []
			else if i = last then [f i]
			else
				let r1 = f i in
				let r2 = f (i+1) in
				r1 :: r2 :: init (i+2) last f


let rec present liste  k = match liste with
		|[]-> false
		|(x,valeur)::tail-> if x=k then true else (present tail k) ;
	
let rec  update liste k valeur = 
	if (present liste k) then let rec aux l p va = match l with
												|[]->[]
												|(x,v)::tail-> if x=p then (x,va):: (aux tail k va)
												else (x,v):: aux tail k va

											in aux liste k valeur
	else 	Liste.rev( (k,valeur)::(Liste.rev liste))		*)