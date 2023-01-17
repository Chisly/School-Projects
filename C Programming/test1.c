#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() 
{
	/*int i;
	for(i=0; i<=20; i++){
		printf("Be Safe\n");
	}
	*/
	int i, n, tot;
	i=n;
	tot=1;
	while(i>0)
	{
		tot*=i;
		i--;
	}
	printf("Factorial of %d is %d\n",n,tot);
	
	return 0; 
} 