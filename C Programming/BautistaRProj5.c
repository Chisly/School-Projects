#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

int validate(char str1[], char str2[]);
int convert(char str1[], char str2[]);

int main(void) 
{
	char str1[20];
	char str2[20];
	printf("Enter two positive integers:\n");
    scanf("%s %s", &str1, &str2);
	
	while(validate(str1, str2) == 0)	//If an input has something other than an integer, this runs
	{
		printf("Try again with positive integers only:\n");
		scanf("%s %s", &str1, &str2);
	}
	printf("The sum of both entries is:  %d\n", convert(str1, str2));
    return 0;
}
int validate(char str1[], char str2[])	//Checks to see if there is anything other than an integer
{
	int i;
	int flag = 2;
	for(i = 0; i < strlen(str1); i++)
	{
		if(str1[i] < 48 || str1[i] > 57)
		{
			flag = 1;
		}
	}
	for(i = 0; i < strlen(str2); i++)
	{
		if(str2[i] < 48 || str2[i] > 57)
		{
			flag = 1;
		}
	}
	if(flag != 1)
	{
		printf("Good Job\n");
		return 1;
	}
	else
	{
		printf("Invalid input detected\n");
		return 0;
	}
}
int convert(char str1[], char str2[])	//Converts strings to integers by subtracting 48 which is 0 in ASCII
{
	int i, j;
	int sum;
	int num1 = 0;
	int num2 = 0;
	int n = strlen(str1);
	int m = strlen(str2);
	
	for(i = 0; i < n; i++)
	{
		num1 = num1 * 10 + (str1[i] - 48);
	}
	for(j = 0; j < m; j++)
	{
		num2 = num2 * 10 + (str2[j] - 48);
	}
	
	sum = num1 + num2;
	
	return sum;
}