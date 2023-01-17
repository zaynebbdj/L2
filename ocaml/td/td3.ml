let rec puissance x i =
  if i=0 then 1.
  else if i>0 then x*.puissance x (i-1)
  else 1./. (x*.puissance x (-i-1) )
let rec factorial n =
    if n=1 then 1
    else n*factorial (n-1)
let rec stars n =
      if n=0 then ""
      else "*"^stars (n-1)
let rec compte_a_rebour n =
        if n=0 then string_of_int(n)
        else string_of_int(n)^" "^compte_a_rebour (n-1)
let rec compteur n =
          if n=1 then string_of_int(n)
          else compteur (n-1)^" "^string_of_int(n)
let rec sum_firsts n =
            if n=0 then 0
            else n+ sum_firsts (n-1) 
let rec fsum_firsts f n =
              if n=1 then f 1
              else (f n)+ fsum_firsts f (n-1)
let rec fcat_firsts f n =
                if n=1 then f 1
                else fcat_firsts f (n-1)^(f n)
let rec fprint_firsts f n =
  if n=1 then " "^string_of_int(f 1)
  else fprint_firsts f (n-1)^" "^string_of_int(f n)


let rec retourne_aux n s =
    if n=0 then Char.escaped (String.get s n )
    else  Char.escaped(String.get s n)^(retourne_aux (n-1) s );;
let rec retourne s =
      if s="" then ""
      else retourne_aux ((String.length s)-1) s  
let rec est_premier_aux n m =
  if  m=1 then true
  else if ( n mod m )=0 then false 
  else est_premier_aux n (m-1)
let est_premier x =
  if x=1 then false
  else if (est_premier_aux x (x-1) )=true  then true 
  else false

let rec nb_occurence_aux c s n =
  if s="" then 0
  else if n<0 then 0
 (*   else if n=0 && String.get s n =c then 1
    else if n=0 then 0 *)
  else if String.get s n =c  then 1+ nb_occurence_aux c s (n-1)
  else nb_occurence_aux c s (n-1)  


    
let rec nb_occurence c s=
    nb_occurence_aux c s ((String.length s) - 1)