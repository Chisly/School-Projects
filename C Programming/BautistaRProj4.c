#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void fillRandom(int grades[], int size);
void printArray(int grades[], int size);
float getAverage(int grades[], int size);
int getLargest(int grades[], int size);
int getMiddle(int grades[], int size);

int main(void)								//Calls functions to execute
{
	int grades[100];
	srand(time(NULL));
	
	fillRandom(grades, 100);
	printArray(grades, 100);
	printf("\nAverage is: %.2f\n", getAverage(grades,100));
	printf("Largest number is: %d\n", getLargest(grades,100));
	printf("\nMiddle Element is: %d\n", getMiddle(grades, 3));
	
	
	
	return 0;
}
void fillRandom ( int grades[], int size)	//Fills the array with random 2 digit numbers
{
	int i;
	for(i = 0; i < size; i++)
	{
		grades[i] = rand()%(99 - 10 + 1)+ 10;
	}
}
void printArray(int grades[], int size)		//Prints the array in columns of 10
{
	int i;
	printf("\n");
	
	for(i = 0; i < size; i++)
	{
		printf("G[%02d]=%d ", i, grades[i]);
		if((i+1)% 10==0)
			printf("\n");
	}
}
float getAverage(int grades[], int size)	//Calculates the sum of all array elements and then divides by array size.
{
	int i;
	float total = 0;
	float average;
	for(i = 0; i < size; i++)
	{
		total = total + grades[i];
	}
	average = total/size;

	return (float) average;
}
int getLargest(int grades[], int size)		//Checks every element within the array and finds the element with the largest value
{
	int i;
	int max = grades[0];
	for(i = 1; i < size; i++)
		if(grades[i] > max)
			max = grades[i];
			
	return max;
}
int getMiddle(int grades[], int size)		//Gets the first 3 elements of the array and returns the middle value
{
	int i;
	int mid;
	printf("Elements are: ");
	for(i = 0; i < size; i++)
	{
		if(i == 2)
			printf("%d", grades[i]);
		else
			printf("%d, ", grades[i]);
	}
	mid = grades[1];
	return mid;
}