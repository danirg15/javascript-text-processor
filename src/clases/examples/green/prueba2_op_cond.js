//Prueba operador condicional, declaracion funciones, llamada de funciones, funcion sin retorno, operador suma, operador mayor, IF

function int mayor(int a, int b)
{
	var int resultado
	
	resultado = (a > b) ? (a) : (b)
			
	return resultado
}


function int adivina(int i, int j, int k) 
{	
	var int res
	
	res = ((i > 1) && (j > 10)) ? (4) : (k)
			
	return res
}


function bool hoyNoEsLunes(int dia)
{
	if(dia > 1) return 2 > 1
	
	return 1 > 2
}


function int suma(int a, int b)
{
	return a + b
}

function print(chars msg) 
{
	write(msg)
}


var int a
var int b
var int total

a = 7
b = 3

if(mayor(a, b) > 20) write("El a es mayor")


total = suma(2,3)


print("Hola Mundo")
