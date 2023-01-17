#include <iostream>
#include <iomanip>
#include <string>
#include <cstdlib>

using namespace std;

class List
{
private:

	typedef struct node
	{
		int year;
		string name;
		node* next;
	}* nodePtr;

	nodePtr head;
	nodePtr curr;
	nodePtr temp;

public:

	List()
	{
		head = NULL;
		curr = NULL;
		temp = NULL;
	}

	void addNode(string name, int addData)
	{
		nodePtr n = new node;
		n->next = NULL;
		n->year = addData;
		n->name = name;

		if (head != NULL)
		{
			curr = head;
			while (curr->next != NULL)
			{
				curr = curr->next;
			}
			curr->next = n;
		}
		else
		{
			head = n;
		}
	}

	void delNode(string delName, int delYear)
	{
		nodePtr delPtr = NULL;
		temp = head;
		curr = head;

		while (curr != NULL && (curr->name != delName || curr->year != delYear))
		{
			temp = curr;
			curr = curr->next;
		}
		if (curr == NULL)
		{
			cout << "\n'" << delName << " (" << delYear << ")' was not in the list" << endl;
			delete delPtr;
		}
		else
		{
			if (curr == head)
			{
				delPtr = curr;
				curr = curr->next;
				head = curr;
				delete delPtr;
				cout << "\n'" << delName << " (" << delYear << ")' was removed from list." << endl;
			}
			else
			{
				delPtr = curr;
				curr = curr->next;
				temp->next = curr;
				delete delPtr;
				cout << "\n'" << delName << " (" << delYear << ")' was removed from list." << endl;
			}
		}
	}

	void print()
	{
		curr = head;
		if (head == NULL)
		{
			cout << "\nList is empty." << endl;
			return;
		}
		else {
			cout << "\nAlbum List:\n" << endl;
			while (curr != NULL)
			{
				cout << curr->name << " (" << curr->year << ")" << endl;
				curr = curr->next;
			}
		}
	}

	void sort()
	{
		curr = head;
		int yHolder;
		string nHolder;

		if (head == NULL)
		{
			return;
		}
		else
		{
			while (curr != NULL)
			{
				temp = curr->next;

				while (temp != NULL)
				{
					if (curr->year > temp->year)
					{
						yHolder = curr->year;
						nHolder = curr->name;
						curr->year = temp->year;
						curr->name = temp->name;
						temp->year = yHolder;
						temp->name = nHolder;
					}
					temp = temp->next;
				}
				curr = curr->next;
			}
		}
	}
};

int main()
{
	List Album;
	string name;
	char choice;
	int year;
	int mChoice;
	do
	{
		cout << "Menu \n1) Add an Album \n2) Remove an Album \n3) Print List \n4) Quit" << endl;
		cout << "Choose an option" << endl;
		cin >> mChoice;
		if (mChoice != 1 && mChoice != 2 && mChoice != 3 && mChoice != 4)
		{
			cout << "Invalid Entry, Try Again" << endl;
			cin >> mChoice;
		}
		else
		{
			switch (mChoice)
			{
			case 1:
				cin.ignore();
				do {
					cout << "Enter a favorite album name:" << endl;
					getline(cin, name);
					cout << "Enter the year '" << name << "' was released:" << endl;
					cin >> year;
					Album.addNode(name, year);

					Album.sort();
					Album.print();

					cout << "\nDo you want to add another album? (y/n)" << endl;
					cin >> choice;
					cin.ignore();

					if (choice != 'n' && choice != 'N' && choice != 'y' && choice != 'Y')
					{
						while (choice != 'n' && choice != 'N' && choice != 'y' && choice != 'Y') {
							cout << "Invalid Entry, Please try again. (y/n)" << endl;
							cin >> choice;
						}
						cin.ignore();
					}
				} while (choice != 'n' && choice != 'N');

				Album.print();
				break;
			case 2:
				cin.ignore();
				do {
					cout << "What album do you want removed?" << endl;
					getline(cin, name);
					cout << "What year was it released?" << endl;
					cin >> year;
					Album.delNode(name, year);

					Album.sort();
					Album.print();

					cout << "\nDo you want to remove another album? (y/n)" << endl;
					cin >> choice;
					cin.ignore();

					if (choice != 'n' && choice != 'N' && choice != 'y' && choice != 'Y')
					{
						while (choice != 'n' && choice != 'N' && choice != 'y' && choice != 'Y') {
							cout << "Invalid Entry, Please try again. (y/n)" << endl;
							cin >> choice;
						}
						cin.ignore();
					}
				} while (choice != 'n' && choice != 'N');

				Album.print();
				break;
			case 3:
				Album.sort();
				Album.print();
				break;
			}
			cout << endl;
		}
	} while (mChoice != 4);
}