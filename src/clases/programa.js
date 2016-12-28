function int FactorialRecursivo (int n)
{
	return n + FactorialRecursivo (n - 1)	
}


function chars test(int dia) 
{
	var chars mensaje
	var int numero
	var bool b

	numero = 7
	
	if(dia > numero) write("fallo")
	
	prompt(mensaje)
	
	

//	switch (dia)
//	{
//		case 1: write(mensaje + "lunes"); break
//		case 2: write(mensaje + "martes"); break
//		case 3: max = (dia > 2 && dia > 7) ? ("Miercoles") : ("?")
//		case 4: write(mensaje + "jueves") break;
//		case 5: write(mensaje + "viernes") break;
//	} 

	
	numero = FactorialRecursivo(dia)
	
	numero = ( (numero + 1) - (numero+1) )  
	
	return mensaje + numero
}
