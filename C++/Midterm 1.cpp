#include <iostream>
#include <iomanip>
using namespace std;

//first take user iput:
float input() {
    //float because it requires a decimals
    float pounds;
    //takes in the persons weight in lb
    cout << "Enter your weight in pounds, to exit enter 0:" << endl;

    cin >> pounds;
    return pounds;
}

//then convert pounds to kg
float pounds_kilo(float pounds) {
    float kilo;
    kilo = pounds * (0.45359237);
    return kilo;
}

// then convert the pounds to grams wich would be the same but * 1000
float pounds_gram(float pounds) {
    float gram;
    gram = pounds * (0.45359237) * 1000;
    return gram;
}

// Output final result of all the calculations to call in the do-while loop
void output(float pounds, float kilo, float gram) {
    cout << "Pounds(lb)=" << pounds << endl;
    cout << "Kilograms(Kg)= " << kilo << endl;
    cout << "Grams(gm) = " << gram << endl;
    cout << endl;
}

// the main function
int main() {
    float pounds;
    //doing a while loop untill they enter 0 to stop the code
    while (true) {
        // take the input of pounds entered
        pounds = input();
        //if it is false and it is less than zero it stops 
        if (pounds <= 0) {
            break;
        }
        //esle it will compute the vlaues for kilo and gram
        else {
            float kilo = 0, gram = 0;

            kilo = pounds_kilo(pounds);
            gram = pounds_gram(pounds);

            // call output method
            output(pounds, kilo, gram);

        }
    }

    return 0;
}