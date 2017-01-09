//AND, recursividad, return sin nada

var int total
var bool x


function saludo()
{
	write("Hola")
}

function despedida()
{
	write("Adios")
	return //sentencia opcional
}

function int factorialRecursivo (int n)	
{	
	return n + factorialRecursivo (n - 1)	// llamada recursiva
}




saludo()

total = factorialRecursivo(4)

x = "hola" && (total > 120) && (2 > 3)

despedida()
