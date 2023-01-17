#include <stdio.h>
#include <stdlib.h>
#include <time.h> 

int getTotal(int grades[], int size);
float getAverage(int grades[], int size);
void doSort(int a[], int n)

int main() 
{ 
	int i;
	
	for(i=0; i<=20; i++){
		printf("Be Safe\n");
	}
	
	
	return 0; 
} 
int getTotal(int grades[], int size)
{
		int i;
		int total = 0;
		for(i = 0; i < size; i++)
		{
			total = total + grades[i];
		}
		
		return total;
}
float getAverage(int grades[], int size)
{
	return (float) getTotal(grades,size)/ size;
}
void doSort(int a[], int n)
{
	int i, j;
	for(i = 0; i < n - 1; i++)
		for(j = i + 1; j < n; j++)
			if(a[i] > a[j])
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
}