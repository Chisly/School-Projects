#include <iostream>
#include <string>
using namespace std;

class TwelveHourTime
{
public:

	TwelveHourTime(string inTime) : time(inTime)
	{}

	string twentyFourTime()
	{
		size_t space = time.find(" ");
		size_t colon = time.find(":");
		string temp = time;
		string newTime = "";

		if (temp[space + 1] == 'P')
		{
			for (int i = 0; i < colon; i++)
			{
				newTime += temp[i];
			}
			int twenty = stoi(newTime);
			twenty += 12;

			newTime = to_string(twenty);


			for (int j = colon; j < colon + 3; j++)
			{
				newTime += temp[j];
			}
		}
		else if (temp[0] == '1' && temp[1] == '2')
		{
			newTime = "00";
			for (int i = colon; i < colon + 3; i++)
			{
				newTime += temp[i];
			}
			return newTime;
		}
		else if (colon > 1)
		{

			for (int i = 0; i < colon + 3; i++)
			{
				newTime += temp[i];
			}


		}
		else {
			newTime = "0";
			for (int i = 0; i < colon + 3; i++)
			{
				newTime += temp[i];
			}

		}

		return newTime;
	}
private:
	string time;
};

class InvalidTime : public exception
{
public:
	InvalidTime()
	{}
	InvalidTime(string except) : bad(except)
	{}
private:
	string bad;
};


int main()
{
	TwelveHourTime sevenAM("7:00 AM");
	cout << sevenAM.twentyFourTime() << endl;   // prints "07:00"
	TwelveHourTime eightPM("8:30 PM");
	cout << eightPM.twentyFourTime() << endl;  // prints "20:30"
	try
	{
		TwelveHourTime bad("asef32422");
		// the previous line should throw an InvalidTime exception
	}
	catch (InvalidTime e) {
		cout << "caught error as expected" << endl;
	}

	return 0;
}