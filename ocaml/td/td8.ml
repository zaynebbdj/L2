type directive = TurnLeft | TurnRight
      | StepForward of int
      | StepBackward of int;;
type path = directive list;;

let inverse d = match d with 
|TurnLeft -> TurnRight
| TurnRight -> TurnLeft
| StepForward x -> StepBackward x
| StepBackward x-> StepForward x




let string_of_d d = match d with
| TurnLeft -> "Tourner à gauche"
| TurnRight -> "Tourner à droite"
| StepForward x -> "Avancer de "^(string_of_int x)^" pas"
| StepBackward x -> "Reculer de "^(string_of_int x)^" pas"

let rec string_of_path p = match p with 
|[]->""
|x::[]-> (string_of_d x )
|r::t -> (string_of_d r)^" ; "^( string_of_path t)

type orientation = North | South | East | West
type hunter = (int*int*orientation)


let string_of_orientation o = match o with 
|North-> "nord"
|South-> "sud"
|East-> "est"
|West->"ouest"

let string_of_hunter u = match u with
|(x,y,o)->"("^(string_of_int x)^","^(string_of_int y)^","^(string_of_orientation o)^")"
let tr o = match o with 
    |North -> East
    |South -> West
    |West -> North
    |East -> South
    
let tl o = match o with 
    |North -> West
    |South -> East
    |West -> South
    |East -> North    

let move (x,y,o) d= match d with 
|StepForward l -> if o=North then (x,y+l,o) else if o=South then (x,y-l,o) else if o=West then (x-l,y,o) else (x+l,y,o)
|StepBackward m-> if o=North then (x,y-m,o) else if o=South then (x,y+m,o) else if o=West then (x+m,y,o) else (x-m,y,o)
|TurnRight -> (x,y,(tr o))
|TurnLeft -> (x,y,(tl o))	




let rec finally h p = match p with
|[] -> h
|x::t ->  (finally (move h x) t) 

type obstacles = (int*int) list

let rec bloque liste (x,y,o) = match liste with 
|[]-> true
|debut::t -> let (a,b)=debut in 
		if a=x && b=y then false 
		else bloque t (x,y,o)

let move_with_obstacles liste h d =  
    if d=TurnLeft || d = TurnRight then move h d
else if ((bloque liste (move h d))==true) then (move h d)
else h




let rec finally_with_obstacles o h p = match p with 
|[] ->h
|x::t ->  (finally_with_obstacles o (move_with_obstacles o h x) t)

