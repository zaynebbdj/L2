type expr = Number of int 
| Variable of string 
|Minus of expr
|Add of expr*expr
|Multiply of expr*expr

let rec string_of_expr e = match e with
|Number i -> "Number "^(string_of_int i)
|Variable  s -> "Variable "^s
|Minus r -> "Minus ("^ (string_of_expr r )^")"
|Add  (a,b) -> "Add ("^(string_of_expr a)^","^ (string_of_expr b)^")"
|Multiply  (c,d) ->"Multiply ("^(string_of_expr c)^","^(string_of_expr d)^")"

let ex = Multiply ((Add ( Number 3  ,Minus (Variable "y" ) ))    , Number 5)

let rec eval_simple e = match e with 
|Number n -> n
|Variable v -> raise (Invalid_argument "Impossible à evaluer!")
|Minus r -> -(eval_simple r)
|Add (a,b) -> (eval_simple a) + (eval_simple b)
|Multiply (u,v) -> (eval_simple u)*(eval_simple v)



let number_of_int v = Number v

let rec eval_complex e = match e with 
    |Number n -> Number n
    |Variable v -> Variable v
    |Minus r ->  (let v = (eval_complex r ) in match v with 
                          |Number n -> Number (-n) 
                          |i-> Minus i )
    |Add (a,b) ->( let (u,v) =(eval_complex a , eval_complex b) in match (u,v) with 
                    |(Number n , Number m) -> number_of_int (n+m)
                    |(x,y) -> Add ((eval_complex x),(eval_complex y))  )
    
    |Multiply (i,j) ->(  let (u,v) =(eval_complex i , eval_complex j) in match (u,v) with 
                    |(Number n , Number m) -> number_of_int (n * m)
                    |(x,y) -> Multiply ((eval_complex x),(eval_complex y))    )  
                    
                    

  
    

    
  
  
















