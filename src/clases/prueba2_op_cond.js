//Prueba operador condicional, declaracion funciones, llamada de funciones, funcion sin retorno, operador suma, operador mayor, IF

function bool mayor(int a, int b)
{
	var bool resultado
	
	resultado = (a > b) ? (a) : (b)
	
	return resultado
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

if(mayor(a, b)) write("El 7 es mayor")


total = suma(2,3)


print("Hola Mundo")


