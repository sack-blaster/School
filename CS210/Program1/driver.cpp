/**
 * Driver file for CS 210 Program 1
 * @author 
 * @date June 2024
 *
 * Runs the test code with 3 test cases.
 *
 * These cases may not test everything the autograder tests 
 * and it is always recommended that you implement your own tests.
 * 
 * Driver files will not necessarily be
 * provided for all future assignments.
 */

#include "sortinventory.h"
#include <string>
#include <iostream>

#define TV "tv"
#define PHONE "phone"
#define BOOK "book"
#define PEN "pen"
#define SPEAKER "speaker"

using namespace std;

// a print helper
void printvector(string prefix, vector<string> v) {
    cout << prefix << " ";
    for (auto m: v)
        cout << m << ' ';
    cout << "\n";
}

// a unit test helper
void test_sorting(string mostPromoted, string leastPromoted, 
                  vector<string> inv, 
                  vector<string> expectedOut) {

    cout << "Most promoted: " << mostPromoted << 
            ", least promoted: " << leastPromoted << "\n";
    printvector("Online Inventory:", inv);

    vector<string> result_from_test = 
      SortInventory::sortInventory(inv, mostPromoted, leastPromoted);

    printvector("Expected:", expectedOut);
    printvector("Returned:", result_from_test);

    if (expectedOut != result_from_test)
        cout << "Test FAILED: Returned did not match expected" << endl;
    else
        cout << "Test Passed" << endl;
}

// test sorting inventory array with one element
void test_oneEleArr() {
    cout << "Test sorting an array with one element ..." << endl;
    test_sorting (TV, BOOK, // order
                  {BOOK}, // inventory
                  {BOOK}); // expected sorted inventory
}

// test sorting inventory array with two elements
void test_twoEleArr() {
    cout << "Test sorting an array with two elements ..." << endl;
    test_sorting (PHONE, BOOK, // order
                  {BOOK, PHONE}, // inventory
                  {PHONE, BOOK}); // expected sorted inventory
}

// test sorting inventory array with many elements
void test_multipleEleArr() {
    cout << "Test sorting an array with many elements ..." << endl;
    test_sorting (PHONE, PEN, // order
                  {TV, PEN, PHONE, PEN, BOOK,
                   PHONE, PEN, SPEAKER}, // inventory
                  {PHONE, PHONE, TV, BOOK, SPEAKER,
                   PEN, PEN, PEN}); // expected sorted inventory
}

int main() {
    test_oneEleArr();
    cout << endl;
    test_twoEleArr();
    cout << endl;
    test_multipleEleArr();
}
