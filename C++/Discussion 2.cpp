/*****************
* Ruben Bautista
* Assignment #3
* March 18, 2021
******************/
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    double midterm;
    double final;
    double lab;
    double avgGrade;
    char input[5];
    char letter;

    do
    {
        cout << "Enter a midterm score.\n";
        cin >> midterm;

        cout << "Enter a final score.\n";
        cin >> final;

        cout << "Enter a lab score.\n";
        cin >> lab;

        avgGrade = (midterm + final + lab) / 3;

        if (avgGrade >= 90)
        {
            letter = 'A';
        }
        else if (avgGrade >= 80)
        {
            letter = 'B';
        }
        else if (avgGrade >= 70)
        {
            letter = 'C';
        }
        else if (avgGrade >= 60)
        {
            letter = 'D';
        }
        else
        {
            letter = 'F';
        }

        cout << fixed << setprecision(2);
        cout << "\nYour average grade was " << avgGrade << ".\n";
        cout << "Your letter grade is a(n) " << letter << ".\n";

        cout << "\nDo you have any other grades to input?\n";
        cin >> input;
        cout << endl;


    } while (input[0] == 'y' || input[0] == 'Y');
}