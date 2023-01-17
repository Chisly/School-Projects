/***************
Ruben Bautista
Project 6
February 9, 2021
***************/
#include <stdio.h>

void input(struct StudentRecord *student);
void computeGrade(struct StudentRecord *student);
void output(const struct StudentRecord student);

struct StudentRecord	//Sets up set of variables to be accessed by other functions
{
	int sNum;
	int quiz1;
	int quiz2;
	int midterm;
	int final;
	float avgScore;
	char grade;
};
int main(void)	//Calls the other functions 5 times
{
	int i;
	struct StudentRecord a[5];
	
	for(i = 0; i < 5; i++)
	{
		input(&a[i]);
	}
	for(i = 0; i < 5; i++)
	{
		computeGrade(&a[i]);
	}
	for(i = 0; i < 5; i++)
	{
		output(a[i]);
	}

	return 0;
}

void input(struct StudentRecord *student)	//Prompts the user to enter values
{
	printf("Enter the student number:\n");
	scanf("%d", &student->sNum);
	
	printf("Enter two 10 point quizzes:\n");
	scanf("%d%d", &student->quiz1, &student->quiz2);
	
	printf("Enter the midterm and final exam grades. These are 100 point tests:\n");
	scanf("%d%d", &student->midterm, &student->final);
}

void computeGrade(struct StudentRecord *student)	//Calculates the avg by adding the scores after being weighed
{
	int sum;
	sum = student->quiz1 + student->quiz2;
	
	student->avgScore = ((float)sum *25/20)+((float)(student->midterm) *25/100)+((float)(student->final) *50/100);
	
	if(student->avgScore > 90)
		student->grade = 'A';
	else if(student->avgScore >= 80)
		student->grade = 'B';
	else if(student->avgScore >= 70)
		student->grade = 'C';
	else if(student->avgScore >= 60)
		student->grade = 'D';
	else
		student->grade = 'F';
}

void output(const struct StudentRecord student)	//Print the the outputs respectively
{
	printf("\nThe record for student number: %d\n", student.sNum);
	printf("The quiz grades are: %d %d\n", student.quiz1, student.quiz2);
	printf("The midterm and exam grades are: %d %d\n", student.midterm, student.final);
	printf("The numeric average is: %.2f\n", student.avgScore);
	printf("and the letter grade assigned is %c\n", student.grade);
}