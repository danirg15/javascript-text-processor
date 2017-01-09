//Llamadas anidadas a funciones

function int suma(int a, int b) 
{
	return a + b
}

function int resta(int a, int b) 
{
	return a - b
}


var int total

total = suma(resta(10,3), suma(2,2)) // (10-3)  + (2 + 2)

