/***************
Ruben Bautista
Project 3
January 18, 2021
***************/
#include <stdio.h>
#include <stdlib.h>

float main(void)
{
	int i;
	int num_count = 0;
	float user_in;
	float min_in;
	float max_in;
	float average;
	float total = 0;
	

	for(i = 0; i < 1; i++){							//The for loop sets the min and max to user input
		printf("Input a number other than zero\n");
		printf("To end the program, enter zero\n");
		scanf("%f", &user_in);
		min_in = user_in;
		max_in = user_in;
		total = user_in + total;
		while(user_in != 0){						//Tallies up the number of entries
			printf("Input a number other than zero\n");
			scanf("%f", &user_in);
			num_count = num_count + 1;
			total = user_in + total;
			if(user_in == 0){						//Gets average and ends program
				average = total / num_count;
			}
			if(user_in != 0){						//Compares most recent user input to stored max and min values
				if(user_in < min_in){
					min_in = user_in;
				}
				if(user_in > max_in){
					max_in = user_in;
				}
			}
		}
	}
	printf("\nThe minimum entry was:		%.2f\n", min_in);
	printf("The maximum entry was:		%.2f\n", max_in);
	printf("The average of all entries was: %.2f\n", average);
	printf("\nCount: %d", num_count);
	return 0;
}