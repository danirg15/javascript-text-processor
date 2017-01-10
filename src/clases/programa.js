function chars dia(int d) 
{
	var chars resultado
		
	switch(d)
	{
		case 1: resultado = "lunes"; break
		case 2: resultado = "martes"; break
		case 3: resultado = "miercoles"; break
		case 4: resultado = "jueves"; break
		case 5: resultado = "viernes"; break
	}
	return resultado
}

var chars mi_dia
var int entrada

prompt(entrada)

mi_dia = dia(entrada)

write(mi_dia)
