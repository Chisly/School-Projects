/*****************
* Ruben Bautista
* Assignment #9
* May 17, 2021
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
	//Gets score average
	double avg()
	{
		double avg = (this->mid + this->final + this->lab) / 3;

		return avg;
	}
	//Calculates and displays the grades
	char score()
	{
		//Sets local variable to average from avg function
		double avg = this->avg();
		char letter;

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

		return letter;
	}
	//Checks to see if student is passing
	string pass()
	{
		//Returns a string stating wheter or not the student is passing
		if (this->avg() >= 60)
			return "Passing";
		else
			return "Failing";
	}
	//Allows access to class functions
	friend ostream& operator<<(ostream& out, Student& kid);
	friend istream& operator>>(istream& in, Student& kid);
};
//Prints class variables and function outputs
ostream& operator<<(ostream& out, Student& kid)
{
	cout << "\nStudent Name: " << kid.studentName << endl;

	cout << fixed << setprecision(2) << "Student Average: " << kid.avg() << endl;
	cout << "Letter Grade: " << kid.score() << endl;
	cout << "Status: " << kid.pass() << endl;

	return out;
}
//Sets class variables
istream& operator>>(istream& in, Student& kid)
{
	cout << "Enter the student's name." << endl;
	//Used "getline" to store first and last names in one line
	getline(cin, kid.studentName);

	cout << "Enter a midterm score." << endl;
	cin >> kid.mid;

	cout << "Enter a final score." << endl;
	cin >> kid.final;

	cout << "Enter a lab project score." << endl;
	cin >> kid.lab;

	return in;
}

int main()
{
	Student profile;
	char input[5];

	//Repeats function calls until user decides to stop
	do
	{
		//Calls both operator functions
		cin >> profile;
		cout << profile;

		//Prompts user to enter whether or not they want to enter more scores
		cout << "\nDo you have more grades to input?" << endl;
		cin.ignore();
		cin.getline(input, 5);

	} while (input[0] == 'y' || input[0] == 'Y');

	return 0;
}