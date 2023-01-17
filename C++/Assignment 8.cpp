#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	int i = 0, daysW = 0;
	double rate = 0, daily = 0, total = 0;

	cout << fixed << setprecision(2);

	cout << "Enter number of days worked." << endl;
	cin >> daysW;

	cout << "Enter your hourly rate." << endl;
	cin >> rate;

	int* dayArr = new int[daysW];

	for (i = 0; i < daysW; i++)
	{
		cout << "Enter amount of hours worked on day: " << i + 1 << endl;
		cin >> dayArr[i];
	}

	cout << "\nYour total earnings for each day are as follows.\n" << endl;
	for (i = 0; i < daysW; i++)
	{
		daily = (dayArr[i] * rate);
		total += daily;

		cout << "Day " << i + 1 << ": $" << daily << endl;
	}

	cout << "\nYour total earnings for the pay period are: $" << total << endl;

	return 0;
}