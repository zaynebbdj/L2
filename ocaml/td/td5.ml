let singleton x = [x]

let positif n = 
  if n<0 then []
  else [n]

let rec rebour n =
  if n<0 then  []
  else n:: rebour (n-1)

let compteur n = List.tl ( List.rev (rebour n))  
let head liste = 
  if liste=[] then -1
  else List.hd liste

  let tail liste =
    if liste=[] then liste
    else List.tl liste 
    
let head_opt liste =
  if liste= [] then None
  else Some ( List.hd liste )
let tail_opt liste =
  if liste=[] then None
  else Some ( List.tl liste)
let rec cmp_firsts_aux i n f = 
    if i=n then [(f n)]
    else let l = cmp_firsts_aux  (i+1) n f in 
    (f i) :: l
let cmp_firsts f n = 
if n<=0 then []
else cmp_firsts_aux 1 n f

let rec compteur_aux i n = 
  if i=n then [n]
  else let l = compteur_aux  (i+1) n  in 
  i :: l
let compteur n = 
if n=0 then []
else compteur_aux 1 n

let rec cmp_firsts_aux i n f = 
  if i=n then [(f n)]
  else let l = cmp_firsts_aux  (i+1) n f in 
  (f i) :: l
  let is_letter c =
    if c >= 'a' && c <= 'z' || c >= 'A' && c <=  'Z' then true
    else false;;

let is_capital c =
    if c >= 'A' && c <= 'Z' then true
    else false;;

let to_lower_case x =
    if is_capital x then char_of_int (int_of_char x + 32)
    else x;;

let rec check_letter_aux s n =
    if n = -1 then true
    else if not (is_letter (String.get s n)) then false
    else check_letter_aux s (n-1);;

let check_letter s =
    if String.length s = 0 then false
    else check_letter_aux s ((String.length s)-1);;

let is_capital n =
  let a = int_of_char n in 
    if 65 <= a && a<=90  then true
    else false
let rec find_capital s n = 
  if n >= (String.length s) then n 
  else if is_capital (String.get s n) then n 
  else find_capital s (n+1) 
  let is_letter c =
    if c >= 'a' && c <= 'z' || c >= 'A' && c <=  'Z' then true
    else false;;

let is_capital c =
    if c >= 'A' && c <= 'Z' then true
    else false;;

let to_lower_case x =
    if is_capital x then char_of_int (int_of_char x + 32)
    else x;;

let rec check_letter_aux s n =
    if n = -1 then true
    else if not (is_letter (String.get s n)) then false
    else check_letter_aux s (n-1);;

let check_letter s =
    if String.length s = 0 then false
    else check_letter_aux s ((String.length s)-1);;

let rec caml_to_split_aux s n =
    if n = 0 then Char.escaped (to_lower_case (String.get s n))
    else if is_capital (String.get s n) then caml_to_split_aux s (n-1) 
        ^ " " ^ Char.escaped (to_lower_case (String.get s n))
    else caml_to_split_aux s (n-1) ^ Char.escaped (String.get s n);;

let caml_to_split s =
    if not (check_letter s) then ""
    else caml_to_split_aux s ((String.length s)-1);; 
    let is_letter c =
      if c >= 'a' && c <= 'z' || c >= 'A' && c <=  'Z' then true
      else false;;
  
  let is_capital c =
      if c >= 'A' && c <= 'Z' then true
      else false;;
  
  let to_lower_case x =
      if is_capital x then char_of_int (int_of_char x + 32)
      else x;;
  
  let rec check_letter_aux s n =
      if n = -1 then true
      else if not (is_letter (String.get s n)) then false
      else check_letter_aux s (n-1);;
  
  let check_letter s =
      if String.length s = 0 then false
      else check_letter_aux s ((String.length s)-1);;
  
  let rec caml_to_split_aux s n =
      if n = 0 then Char.escaped (to_lower_case (String.get s n))
      else if is_capital (String.get s n) then caml_to_split_aux s (n-1) 
          ^ " " ^ Char.escaped (to_lower_case (String.get s n))
      else caml_to_split_aux s (n-1) ^ Char.escaped (String.get s n);;
  
  let caml_to_split s =
      if not (check_letter s) then ""
      else caml_to_split_aux s ((String.length s)-1);;
  
  let caml_to_split_list s =
      let new_s = caml_to_split s in
      if new_s = "" then []
      else String.split_on_char ' ' new_s;;  
   