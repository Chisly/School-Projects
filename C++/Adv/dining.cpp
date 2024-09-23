//Ruben Bautista
//CECS 326 - Summer 2024

//Included libraries/headers
#include <iostream>
#include <thread>
#include <chrono>
#include <time.h>
#include <condition_variable>
#include <mutex>
using namespace std;

condition_variable cv;
mutex m;
bool ready = false;

//Initializes functions
int rand_num(int, int);
void philosopher(int);

int main(){
	//Gets randomizer seed
	srand(time(0));

	//Initializes philosophers with the possible chopsticks they can take
	thread p0(philosopher, 0);
	thread p1(philosopher, 1);
	thread p2(philosopher, 2);
	thread p3(philosopher, 3);
	thread p4(philosopher, 4);

	//Waits for all threads to finish before ending
	p0.join();
	p1.join();
	p2.join();
	p3.join();
	p4.join();
}

//Function used to get a random number within a given parameter
int rand_num(int min, int max){
	return rand()%(max-min)+min;
}

void philosopher(int philo_num){
	//While loop used to keep all threads going
	while(true) {
		//Period gets a number from 1 seconds to 3 seconds
		int period=rand_num(1, 3);

		//Prints philosopher status
		cout << "Philosopher " << philo_num << " is thinking.\n";

		//Puts the thread to sleep for 1-3 seconds
		this_thread::sleep_for(chrono::seconds(period));

		//Has 1 thread continue while making the others wait for the running thread to finish
		ready = true;
		unique_lock<mutex> lock(m);

		while(!ready) cv.wait(lock);
		//Gets another random number between 1-3 seconds
		period = rand_num(1, 3);

		//Updates philosopher status
		cout << "Philosopher " << philo_num << " is eating.\n";

		//Puts the thread to sleep for 1-3 seconds
		this_thread::sleep_for(chrono::seconds(period));

	}
}
