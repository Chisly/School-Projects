#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	double total = 0;
	double annual = 0;
	double userInput = 0;
	double ar[2][4];

	cout << fixed << setprecision(2);

	for (int i = 0; i < 2; i++)
	{
		cout << "Enter Year " << i+1 << "'s quarterly earnings" << endl;

		for (int j = 0; j < 4; j++)
		{
			cin >> userInput;

			ar[i][j] = userInput;
		}
		cout << endl;
	}

	for (int i = 0; i < 2; i++)
	{
		cout << "Year " << i + 1 << "'s annual income" << endl;
		cout << "  Q1    Q2    Q3    Q4" << endl;
		for (int j = 0; j < 4; j++)
		{
			cout << "$" << ar[i][j] << " ";
			
			annual += ar[i][j];
		}
		cout << "|| Year Total: $" << annual << endl << endl;
		total += annual;
		annual = 0;
	}
	cout << "Total earnings were: $" << total << endl;

	return 0;
}