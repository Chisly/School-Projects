/*****************
Date~ 03/17/2021
Group Names~
Ruben Bautista
Genesis Navarro
******************/

#include <iostream>
#include <iomanip>


int main()
{
	char checka[50];
	int checksNumber = 0;
	float checkAmount = 0;
	float checkArray[20];
	float totalcheckAmount = 0;

	int billAmount = 0;
	float coinAmount = 0;
	int billName[7];
	int coinName[4];
	int billVal = 0;
	float coinVal = 0;
	float totalcashAmount = 0;


	float bankTotal = 0;

	//check if they have a check to deposit
	std::cout << "Do you have any checks to deposit? (Enter yes or no)" << std::endl;
	std::cin >> checka;

	//then run it through a loop for a y or n
	while (checka[0] != 'y' && checka[0] != 'n')
	{
		std::cout << "Invalid answer, please try again." << std::endl;
		std::cin >> checka;
	}//If user said "yes" to checks 
	if (checka[0] == 'y')
	{
		//once yes you enter how many you chose to deposit and enter the number
		std::cout << "You said Yes\n" << "Enter the number of checks you wish to deposit. (Max 20)" << std::endl;
		std::cin >> checksNumber;
		//then a for loop to go through the amount
		for (int i = 0; i < checksNumber; i++)
		{
			//how much a check has
			std::cout << "\nEnter amount on check " << i + 1 << std::endl;
			std::cin >> checkAmount;
			//set it into a arry
			checkArray[i] = checkAmount;
			//for one check and its amount
			std::cout << "The amount on check " << i + 1 << " is $" << checkArray[i] << std::endl;
			//the total amo
			totalcheckAmount = totalcheckAmount + checkArray[i];
		}
		std::cout << "\nThe total amount from the checks is $" << totalcheckAmount << std::endl;
		std::cout << "Do you wish to deposit cash?" << std::endl;
		std::cin >> checka;
		while (checka[0] != 'y' && checka[0] != 'n')
		{
			std::cout << "Invalid answer, please try again." << std::endl;
			std::cin >> checka;
		}//If user said "yes" to cash
		if (checka[0] == 'y')
		{
			std::cout << "Do you have any bills to deposit?" << std::endl;
			std::cin >> checka;
			while (checka[0] != 'y' && checka[0] != 'n')
			{
				std::cout << "Invalid answer, please try again." << std::endl;
				std::cin >> checka;
			}
			if (checka[0] == 'y')
			{
				std::cout << "\nEnter the bill amount being deposited." << std::endl;
				std::cin >> billAmount;

				//the amount cash bills being deposited
				std::cout << "How many hundred dollar bills are you depositing?" << std::endl;
				std::cin >> billName[0];
				std::cout << "How many fifty dollar bills are you depositing?" << std::endl;
				std::cin >> billName[1];
				std::cout << "How many twenty dollar bills are you depositing?" << std::endl;
				std::cin >> billName[2];
				std::cout << "How many ten dollar bills are you depositing?" << std::endl;
				std::cin >> billName[3];
				std::cout << "How many five dollar bills are you depositing?" << std::endl;
				std::cin >> billName[4];
				std::cout << "How many two dollar bills are you depositing?" << std::endl;
				std::cin >> billName[5];
				std::cout << "How many one dollar bills are you depositing?" << std::endl;
				std::cin >> billName[6];

				billVal = (billName[0] * 100);
				billVal = (billVal + (billName[1] * 50));
				billVal = (billVal + (billName[2] * 20));
				billVal = (billVal + (billName[3] * 10));
				billVal = (billVal + (billName[4] * 5));
				billVal = (billVal + (billName[5] * 2));
				billVal = (billVal + (billName[6] * 1));

				while (billVal != billAmount)
				{
					std::cout << "\nTypes of bills do not add up to amount depositing.\n";
					std::cout << "Please try again\n" << std::endl;
					std::cout << "Value entered: $" << billAmount << std::endl;

					std::cout << "How many hundred dollar bills are you depositing?" << std::endl;
					std::cin >> billName[0];
					std::cout << "How many fifty dollar bills are you depositing?" << std::endl;
					std::cin >> billName[1];
					std::cout << "How many twenty dollar bills are you depositing?" << std::endl;
					std::cin >> billName[2];
					std::cout << "How many ten dollar bills are you depositing?" << std::endl;
					std::cin >> billName[3];
					std::cout << "How many five dollar bills are you depositing?" << std::endl;
					std::cin >> billName[4];
					std::cout << "How many two dollar bills are you depositing?" << std::endl;
					std::cin >> billName[5];
					std::cout << "How many one dollar bills are you depositing?" << std::endl;
					std::cin >> billName[6];

					billVal = (billName[0] * 100);
					billVal = (billVal + (billName[1] * 50));
					billVal = (billVal + (billName[2] * 20));
					billVal = (billVal + (billName[3] * 10));
					billVal = (billVal + (billName[4] * 5));
					billVal = (billVal + (billName[5] * 2));
					billVal = (billVal + (billName[6] * 1));
				}
				if (billVal == billAmount)//what type of cash bills
				{
					std::cout << "\nYou've deposited\n" << billName[0] << " Hundreds\n";
					std::cout << billName[1] << " Fifties\n";
					std::cout << billName[2] << " Twenties\n";
					std::cout << billName[3] << " Tens\n";
					std::cout << billName[4] << " Fives\n";
					std::cout << billName[5] << " Twos\n";
					std::cout << billName[6] << " Ones\n" << std::endl;

					std::cout << "Do you have any coins to deposit?" << std::endl;
					std::cin >> checka;
					while (checka[0] != 'y' && checka[0] != 'n')
					{
						std::cout << "Invalid answer, please try again." << std::endl;
						std::cin >> checka;
					}
					if (checka[0] == 'y')
					{
						std::cout << "\nEnter the coin amount being deposited." << std::endl;
						std::cin >> coinAmount;
						coinAmount = coinAmount / 100;

						//the amount coins being deposited
						std::cout << "How many quarters are you depositing?" << std::endl;
						std::cin >> coinName[0];
						std::cout << "How many dimes are you depositing?" << std::endl;
						std::cin >> coinName[1];
						std::cout << "How many nickels are you depositing?" << std::endl;
						std::cin >> coinName[2];
						std::cout << "How many pennies are you depositing?" << std::endl;
						std::cin >> coinName[3];

						coinVal = (coinName[0] * 0.25);
						coinVal = (coinVal + (coinName[1] * 0.10));
						coinVal = (coinVal + (coinName[2] * 0.05));
						coinVal = (coinVal + (coinName[3] * 0.01));
						//what type of coins
						while (coinVal != coinAmount)
						{
							std::cout << "\nTypes of coins do not add up to amount depositing\n";
							std::cout << "Please try again\n" << std::endl;
							std::cout << "Value entered: $" << coinAmount << std::endl;

							std::cout << "How many quarters are you depositing?" << std::endl;
							std::cin >> coinName[0];
							std::cout << "How many dimes are you depositing?" << std::endl;
							std::cin >> coinName[1];
							std::cout << "How many nickels are you depositing?" << std::endl;
							std::cin >> coinName[2];
							std::cout << "How many pennies are you depositing?" << std::endl;
							std::cin >> coinName[3];

							coinVal = (coinName[0] * 0.25);
							coinVal = (coinVal + (coinName[1] * 0.10));
							coinVal = (coinVal + (coinName[2] * 0.05));
							coinVal = (coinVal + (coinName[3] * 0.01));
						}
						if (coinVal == coinAmount)
						{
							std::cout << "\nYou've deposited\n" << coinName[0] << " Quarters\n";
							std::cout << coinName[1] << " Dimes\n";
							std::cout << coinName[2] << " Nickels\n";
							std::cout << coinName[3] << " Pennies" << std::endl;

							totalcashAmount = billAmount + coinAmount;
							bankTotal = totalcheckAmount + totalcashAmount;
							std::cout << std::fixed;
							std::cout << "\n$" << std::setprecision(2) << totalcashAmount << " was successfully deposited.\n" << std::endl;
							std::cout << "Total amount deposited $" << bankTotal << std::endl;
						}
					}
					if (checka[0] == 'n')
					{
						std::cout << "No coins to deposit" << std::endl;

						totalcashAmount = billAmount;
						bankTotal = totalcheckAmount + totalcashAmount;
						std::cout << std::fixed;
						std::cout << "\n$" << std::setprecision(2) << totalcashAmount << " was successfully deposited.\n" << std::endl;
						std::cout << "Total amount deposited $" << bankTotal << std::endl;
					}
				}
			}
			if (checka[0] == 'n')
			{
				std::cout << "No bills to deposit" << std::endl;
				std::cout << "Do you have any coins to deposit?" << std::endl;
				std::cin >> checka;
				while (checka[0] != 'y' && checka[0] != 'n')
				{
					std::cout << "Invalid answer, please try again." << std::endl;
					std::cin >> checka;
				}
				if (checka[0] == 'y')
				{
					std::cout << "\nEnter the coin amount being deposited." << std::endl;
					std::cin >> coinAmount;
					coinAmount = coinAmount / 100;

					//the amount coins being deposited
					std::cout << "How many quarters are you depositing?" << std::endl;
					std::cin >> coinName[0];
					std::cout << "How many dimes are you depositing?" << std::endl;
					std::cin >> coinName[1];
					std::cout << "How many nickels are you depositing?" << std::endl;
					std::cin >> coinName[2];
					std::cout << "How many pennies are you depositing?" << std::endl;
					std::cin >> coinName[3];

					coinVal = (coinName[0] * 0.25);
					coinVal = (coinVal + (coinName[1] * 0.10));
					coinVal = (coinVal + (coinName[2] * 0.05));
					coinVal = (coinVal + (coinName[3] * 0.01));
					//what type of coins
					while (coinVal != coinAmount)
					{
						std::cout << "\nTypes of coins do not add up to amount depositing\n";
						std::cout << "Please try again\n" << std::endl;
						std::cout << "Value entered: $" << coinAmount << std::endl;

						std::cout << "How many quarters are you depositing?" << std::endl;
						std::cin >> coinName[0];
						std::cout << "How many dimes are you depositing?" << std::endl;
						std::cin >> coinName[1];
						std::cout << "How many nickels are you depositing?" << std::endl;
						std::cin >> coinName[2];
						std::cout << "How many pennies are you depositing?" << std::endl;
						std::cin >> coinName[3];

						coinVal = (coinName[0] * 0.25);
						coinVal = (coinVal + (coinName[1] * 0.10));
						coinVal = (coinVal + (coinName[2] * 0.05));
						coinVal = (coinVal + (coinName[3] * 0.01));
					}
					if (coinVal == coinAmount)
					{
						std::cout << "\nYou've deposited\n" << coinName[0] << " Quarters\n";
						std::cout << coinName[1] << " Dimes\n";
						std::cout << coinName[2] << " Nickels\n";
						std::cout << coinName[3] << " Pennies" << std::endl;

						totalcashAmount = coinAmount;
						bankTotal = totalcheckAmount + totalcashAmount;
						std::cout << std::fixed;
						std::cout << "\n$" << std::setprecision(2) << totalcashAmount << " was successfully deposited.\n" << std::endl;
						std::cout << "Total amount deposited $" << bankTotal << std::endl;
					}
				}
				if (checka[0] == 'n')
				{
					std::cout << "\nNo coins to deposit" << std::endl;
					std::cout << "No cash was deposited\n" << std::endl;

					std::cout << std::fixed;
					std::cout << "Total amount deposited $" << std::setprecision(2) << totalcheckAmount << std::endl;
				}
			}
		}
	}//If user said "no" to checks
	if (checka[0] == 'n')
	{
		std::cout << "No checks to deposit.\n" << std::endl;
		std::cout << "Do you wish to deposit cash?" << std::endl;
		std::cin >> checka;
		while (checka[0] != 'y' && checka[0] != 'n')
		{
			std::cout << "Invalid answer, please try again." << std::endl;
			std::cin >> checka;
		}//If user said "yes" to cash
		if (checka[0] == 'y')
		{
			std::cout << "Do you have any bills to deposit?" << std::endl;
			std::cin >> checka;
			while (checka[0] != 'y' && checka[0] != 'n')
			{
				std::cout << "Invalid answer, please try again." << std::endl;
				std::cin >> checka;
			}
			if (checka[0] == 'y')
			{
				std::cout << "\nEnter the bill amount being deposited." << std::endl;
				std::cin >> billAmount;

				//the amount cash bills being deposited
				std::cout << "How many hundred dollar bills are you depositing?" << std::endl;
				std::cin >> billName[0];
				std::cout << "How many fifty dollar bills are you depositing?" << std::endl;
				std::cin >> billName[1];
				std::cout << "How many twenty dollar bills are you depositing?" << std::endl;
				std::cin >> billName[2];
				std::cout << "How many ten dollar bills are you depositing?" << std::endl;
				std::cin >> billName[3];
				std::cout << "How many five dollar bills are you depositing?" << std::endl;
				std::cin >> billName[4];
				std::cout << "How many two dollar bills are you depositing?" << std::endl;
				std::cin >> billName[5];
				std::cout << "How many one dollar bills are you depositing?" << std::endl;
				std::cin >> billName[6];

				billVal = (billName[0] * 100);
				billVal = (billVal + (billName[1] * 50));
				billVal = (billVal + (billName[2] * 20));
				billVal = (billVal + (billName[3] * 10));
				billVal = (billVal + (billName[4] * 5));
				billVal = (billVal + (billName[5] * 2));
				billVal = (billVal + (billName[6] * 1));

				while (billVal != billAmount)
				{
					std::cout << "\nTypes of bills do not add up to amount depositing.\n";
					std::cout << "Please try again\n" << std::endl;
					std::cout << "Value entered: $" << billAmount << std::endl;

					std::cout << "How many hundred dollar bills are you depositing?" << std::endl;
					std::cin >> billName[0];
					std::cout << "How many fifty dollar bills are you depositing?" << std::endl;
					std::cin >> billName[1];
					std::cout << "How many twenty dollar bills are you depositing?" << std::endl;
					std::cin >> billName[2];
					std::cout << "How many ten dollar bills are you depositing?" << std::endl;
					std::cin >> billName[3];
					std::cout << "How many five dollar bills are you depositing?" << std::endl;
					std::cin >> billName[4];
					std::cout << "How many two dollar bills are you depositing?" << std::endl;
					std::cin >> billName[5];
					std::cout << "How many one dollar bills are you depositing?" << std::endl;
					std::cin >> billName[6];

					billVal = (billName[0] * 100);
					billVal = (billVal + (billName[1] * 50));
					billVal = (billVal + (billName[2] * 20));
					billVal = (billVal + (billName[3] * 10));
					billVal = (billVal + (billName[4] * 5));
					billVal = (billVal + (billName[5] * 2));
					billVal = (billVal + (billName[6] * 1));
				}
				if (billVal == billAmount)//what type of cash bills
				{
					std::cout << "\nYou've deposited\n" << billName[0] << " Hundreds\n";
					std::cout << billName[1] << " Fifties\n";
					std::cout << billName[2] << " Twenties\n";
					std::cout << billName[3] << " Tens\n";
					std::cout << billName[4] << " Fives\n";
					std::cout << billName[5] << " Twos\n";
					std::cout << billName[6] << " Ones\n" << std::endl;

					std::cout << "Do you have any coins to deposit?" << std::endl;
					std::cin >> checka;
					while (checka[0] != 'y' && checka[0] != 'n')
					{
						std::cout << "Invalid answer, please try again." << std::endl;
						std::cin >> checka;
					}
					if (checka[0] == 'y')
					{
						std::cout << "\nEnter the coin amount being deposited." << std::endl;
						std::cin >> coinAmount;
						coinAmount = coinAmount / 100;

						//the amount coins being deposited
						std::cout << "How many quarters are you depositing?" << std::endl;
						std::cin >> coinName[0];
						std::cout << "How many dimes are you depositing?" << std::endl;
						std::cin >> coinName[1];
						std::cout << "How many nickels are you depositing?" << std::endl;
						std::cin >> coinName[2];
						std::cout << "How many pennies are you depositing?" << std::endl;
						std::cin >> coinName[3];

						coinVal = (coinName[0] * 0.25);
						coinVal = (coinVal + (coinName[1] * 0.10));
						coinVal = (coinVal + (coinName[2] * 0.05));
						coinVal = (coinVal + (coinName[3] * 0.01));
						//what type of coins
						while (coinVal != coinAmount)
						{
							std::cout << "\nTypes of coins do not add up to amount depositing\n";
							std::cout << "Please try again\n" << std::endl;
							std::cout << "Value entered: $" << coinAmount << std::endl;

							std::cout << "How many quarters are you depositing?" << std::endl;
							std::cin >> coinName[0];
							std::cout << "How many dimes are you depositing?" << std::endl;
							std::cin >> coinName[1];
							std::cout << "How many nickels are you depositing?" << std::endl;
							std::cin >> coinName[2];
							std::cout << "How many pennies are you depositing?" << std::endl;
							std::cin >> coinName[3];

							coinVal = (coinName[0] * 0.25);
							coinVal = (coinVal + (coinName[1] * 0.10));
							coinVal = (coinVal + (coinName[2] * 0.05));
							coinVal = (coinVal + (coinName[3] * 0.01));
						}
						if (coinVal == coinAmount)
						{
							std::cout << "\nYou've deposited\n" << coinName[0] << " Quarters\n";
							std::cout << coinName[1] << " Dimes\n";
							std::cout << coinName[2] << " Nickels\n";
							std::cout << coinName[3] << " Pennies" << std::endl;

							totalcashAmount = billAmount + coinAmount;
							bankTotal = totalcheckAmount + totalcashAmount;
							std::cout << std::fixed;
							std::cout << "\n$" << std::setprecision(2) << totalcashAmount << " was successfully deposited.\n" << std::endl;
							std::cout << "Total amount deposited $" << bankTotal << std::endl;
						}
					}
					if (checka[0] == 'n')
					{
						std::cout << "No coins to deposit" << std::endl;

						totalcashAmount = billAmount;
						bankTotal = totalcheckAmount + totalcashAmount;
						std::cout << std::fixed;
						std::cout << "\n$" << std::setprecision(2) << totalcashAmount << " was successfully deposited.\n" << std::endl;
						std::cout << "Total amount deposited $" << bankTotal << std::endl;
					}
				}
			}
			if (checka[0] == 'n')
			{
				std::cout << "No bills to deposit" << std::endl; 
				std::cout << "Do you have any coins to deposit?" << std::endl;
				std::cin >> checka;
				while (checka[0] != 'y' && checka[0] != 'n')
				{
					std::cout << "Invalid answer, please try again." << std::endl;
					std::cin >> checka;
				}
				if (checka[0] == 'y')
				{
					std::cout << "\nEnter the coin amount being deposited." << std::endl;
					std::cin >> coinAmount;
					coinAmount = coinAmount / 100;

					//the amount coins being deposited
					std::cout << "How many quarters are you depositing?" << std::endl;
					std::cin >> coinName[0];
					std::cout << "How many dimes are you depositing?" << std::endl;
					std::cin >> coinName[1];
					std::cout << "How many nickels are you depositing?" << std::endl;
					std::cin >> coinName[2];
					std::cout << "How many pennies are you depositing?" << std::endl;
					std::cin >> coinName[3];

					coinVal = (coinName[0] * 0.25);
					coinVal = (coinVal + (coinName[1] * 0.10));
					coinVal = (coinVal + (coinName[2] * 0.05));
					coinVal = (coinVal + (coinName[3] * 0.01));
					//what type of coins
					while (coinVal != coinAmount)
					{
						std::cout << "\nTypes of coins do not add up to amount depositing\n";
						std::cout << "Please try again\n" << std::endl;
						std::cout << "Value entered: $" << coinAmount << std::endl;

						std::cout << "How many quarters are you depositing?" << std::endl;
						std::cin >> coinName[0];
						std::cout << "How many dimes are you depositing?" << std::endl;
						std::cin >> coinName[1];
						std::cout << "How many nickels are you depositing?" << std::endl;
						std::cin >> coinName[2];
						std::cout << "How many pennies are you depositing?" << std::endl;
						std::cin >> coinName[3];

						coinVal = (coinName[0] * 0.25);
						coinVal = (coinVal + (coinName[1] * 0.10));
						coinVal = (coinVal + (coinName[2] * 0.05));
						coinVal = (coinVal + (coinName[3] * 0.01));
					}
					if (coinVal == coinAmount)
					{
						std::cout << "\nYou've deposited\n" << coinName[0] << " Quarters\n";
						std::cout << coinName[1] << " Dimes\n";
						std::cout << coinName[2] << " Nickels\n";
						std::cout << coinName[3] << " Pennies" << std::endl;

						totalcashAmount = coinAmount;
						bankTotal = totalcheckAmount + totalcashAmount;
						std::cout << std::fixed;
						std::cout << "\n$" << std::setprecision(2) << totalcashAmount << " was successfully deposited.\n" << std::endl;
						std::cout << "Total amount deposited $" << bankTotal << std::endl;
					}
				}
				if (checka[0] == 'n')
				{
					std::cout << "\nNo coins to deposit" << std::endl;
					std::cout << "No cash was deposited\n" << std::endl;

					std::cout << std::fixed;
					std::cout << "Total amount deposited $" << std::setprecision(2) << totalcheckAmount << std::endl;
				}
			}
		}	
		if (checka[0] == 'n')
		{
			std::cout << "\nNo cash to to deposit" << std::endl;
			std::cout << "Nothing to deposit" << std::endl;
		}
	}
	return 0;
}