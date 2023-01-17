let somme l =
  let rec sum l acc = match l with
   |[] -> acc
   |head::tail -> sum tail (acc+.head)
in sum l 0. ;;

let compte l =
  let rec trouve l acc = match l with
   |[] -> acc
   |head::tail -> if head ==true then trouve tail (acc+1) else trouve tail acc
in trouve l 0 ;;

let asso l a =
  let rec trouve l = match l with 
      |[] -> None
      |(x,y)::tail -> if x=a then Some y else trouve tail
      
  in trouve l  

let div2 l =
    let rec trouve l1 l2 = match l1 with
     |[] -> l2
     |head::tail -> if (head mod 2) =0 then (head/2)::( trouve tail l2) else trouve tail l2
in trouve l [] 


let get a = match a with
    |Some x ->x
    |None-> raise (Invalid_argument "Option.get")

let filter_map f l =
   let rec trouve l1 l2 = match l1 with
    |[] -> l2
    |head::tail -> if f head = None then trouve tail l2 else (get (f head))::(trouve tail l2)
in trouve l [] ;;


type jour_semaine = 
|Lundi
|Mardi
|Mercredi
|Jeudi
|Vendredi
|Samedi
|Dimanche
let int_of_jour j= match j with
|Lundi->1
|Mardi->2
|Mercredi->3
|Jeudi->4
|Vendredi->5
|Samedi->6
|Dimanche->7
let jour_of_int x = let nombre = (x mod 7) in 
if nombre=0 then Dimanche
else if nombre=1 then Lundi
else if nombre=2 then Mardi
else if nombre=3 then Mercredi
else if nombre = 4 then Jeudi
else if nombre =5 then Vendredi
else Samedi	
let jour_de_week_end a= (a==Samedi || a==Dimanche )

let nb_jour_avant_week_end a = match a with
|Lundi->5
|Mardi->4
|Mercredi->3
|Jeudi->2
|Vendredi->1
|Samedi->0
|Dimanche->0

let jour_suivant a = match a with
|Lundi->Mardi
|Mardi->Mercredi
|Mercredi->Jeudi
|Jeudi->Vendredi
|Vendredi->Samedi
|Samedi->Dimanche
|Dimanche->Lundi
let jour_apres j n = 
jour_of_int (n+ (int_of_jour j))


let nb_jour_avant_week_end_rec j = match j with
|Samedi-> 0
|Dimanche->0
|jour-> (6- int_of_jour jour)






let positions_paires l =
	let rec trouve l1 l2 acc= match l1 with 
		|[]->l2
		|head::tail-> if acc mod 2 =0 then head::trouve tail l2 (acc+1) else trouve tail l2 (acc+1)
	in trouve l [] 0

let positions_impaires l =
	let rec trouve l1 l2 acc= match l1 with 
		|[]->l2
		|head::tail-> if acc mod 2 =1 then head::trouve tail l2 (acc+1) else trouve tail l2 (acc+1)
	in trouve l [] 0
let coupe l =
	(positions_paires l,positions_impaires l)

let fusion l1 l2 =
	let rec inter1 liste1 liste2 l3 = match liste1 with
	|[]->if liste2=[] then l3 else let max2 = (List.hd liste2) in max2:: (inter1 liste1 (List.tl liste2) l3 )
	|head1::tail1-> let max1 = head1 in match liste2 with 
		|[]-> if liste1=[] then l3 else max1::(inter1 tail1 liste2 l3)
		|head2::tail2-> let max2 = head2 in if max1>=max2 then max2::( inter1 liste1 tail2 l3) else max1::(inter1 tail1 liste2 l3)
	in inter1 l1 l2 []

let rec tri_fusion l = 
    if List.length l = 0 || List.length l=1 then l else 
	let l1 = (positions_paires l) in let l2 = (positions_impaires l) in 
	fusion (tri_fusion l1) (tri_fusion l2)