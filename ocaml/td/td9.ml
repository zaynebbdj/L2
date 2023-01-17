(*

let simple_triangle =
  let pi23 = 2.0 *. pi /. 3.0 in
    Forward 25.0 :: Turn pi23 ::
    Forward 25.0 :: Turn pi23 ::
    Forward 25.0 :: []

let simple_square = 
 	Forward 25.0 :: Turn pi2 ::
	Forward 25.0 :: Turn pi2 ::
	Forward 25.0 :: Turn pi2 ::
	Forward 25.0 :: []

let pentagone =
	Forward 25.0 :: Turn pi10 ::
	Forward 25.0 :: Turn pi10 ::
	Forward 25.0 :: Turn pi10 ::
	Forward 25.0 :: Turn pi10 ::
	Forward 25.0 :: []


let rec polygone n = 
	let pin = ( (2. *.pi )/. ( float_of_int n )) in
		let rec polygone_aux x i =
			if i=x then [] 
			else Forward 25.0 ::  Turn pin :: polygone_aux x (i+1) 
		in polygone_aux n 0

let rec square_spiral n d = 
	if n=0  then []
	else Forward d :: Turn pi2 :: square_spiral (n-1) (d*. 0.8)   
                                                                        *)