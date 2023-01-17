/***************
Ruben Bautista
Project 2
January 11, 2021
***************/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define UPPER_LIMIT		41
#define LOWER_LIMIT		21

int main(void)
{
    int count;
	int sampleSize;
	int r, c;
	int m;
	char space = ' ';
	char nextLine = '\n';
	char iniR = 'R';
	char iniB = 'B';
	char sym = '=';
 
	srand(time(NULL));
	sampleSize = rand() % (UPPER_LIMIT - LOWER_LIMIT + 1) + LOWER_LIMIT;

	if(sampleSize % 2 == 0) sampleSize++;

    count = (sampleSize-1)/2;
	m = (sampleSize-1)/2;
	
	printf("Ruben Bautista - Project 2\n\n");
	printf("Number of Lines: %d\n\n", sampleSize);
	for (r = 1; r <= sampleSize; r++)				//Calculates how many rows for top half
	{
		for (c = 1; c <= count; c++)				//Calculates how many spaces before putting an "R"
			putchar(space);
			count--;
			if(count == -1){
				for (c = 1; c <= sampleSize; c++)	//Places the special character in the middle of shape
					putchar(sym);
					putchar(nextLine);
					r = sampleSize;
			}
			else{
				for (c = 1; c <= 2 * r - 1; c++)	//Calculates how many "R"s to place per row
					putchar(iniR);
					putchar(nextLine);
			}
	}
	count = 1;
	for (r = 1; r <= sampleSize - 1; r++)			//Same thing as before but for bottom half
	{
		if(r == m + 1){								//Stops the program
			printf("\nRuben Bautista - End of Program");
			r = sampleSize - 1;
		}
		else{
			for (c = 1; c <= count; c++)
				if(count <= m)
					putchar(space);
					count++;
			for (c = 1; c <= 2 *(sampleSize - r)-  1; c++)
				if(c >= sampleSize)
					putchar(iniB);
					putchar(nextLine);
		}
	}
	return 0;
}