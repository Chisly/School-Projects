/*****************
* Ruben Bautista
* Assignment #7
* April 25, 2021
******************/
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class Student
{
	//Variables that can only be used in this class
private:
	double mid, final, lab;
	string studentName;
public:
	//Sets member variables to 0
	Student()
	{
		this->mid = 0;
		this->final = 0;
		this->lab = 0;
	}
	//Asks for student name
	void name()
	{
		cout << "Enter the student's name." << endl;
		//Used "getline" to store first and last names
		getline(cin, this->studentName);
	}
	//Prompts the user to enter scores and calls score() function
	void input()
	{
		cout << "Enter a midterm score." << endl;
		cin >> this->mid;

		cout << "Enter a final score." << endl;
		cin >> this->final;

		cout << "Enter a lab project score." << endl;
		cin >> this->lab;

		score();
	}
	//Calculates and displays the grades
	void score()
	{
		double avg;
		char letter;

		//Gets average by adding scores and dividing by 3
		avg = (this->mid + this->final + this->lab) / 3;

		//Decides letter grade based on score
		if (avg >= 90)
			letter = 'A';
		else if (avg >= 80)
			letter = 'B';
		else if (avg >= 70)
			letter = 'C';
		else if (avg >= 60)
			letter = 'D';
		else
			letter = 'F';

		cout << "\nStudent name: " << this->studentName << endl;
		//Tells user their average score and their letter grade.
		cout << fixed << setprecision(2) << "Student average is " << avg << ". That is a(n) " << letter << "." << endl;
	}
};

int main()
{
	Student profile;
	char input[5];

	//repeats function calls until user decides to stop
	do
	{
		//calls function in Grades class	
		profile.name();
		profile.input();

		//prompts user to enter whether or not they want to enter more scores
		cout << "\nDo you have more grades to input?" << endl;
		cin.ignore();
		cin.getline(input, 5);

	} while (input[0] == 'y' || input[0] == 'Y');

	return 0;
}