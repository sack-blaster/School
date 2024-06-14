/**
 * Driver file for CS 210 Program 2
 * @author 
 * @date Jun 2024
 *
 * Runs the student code and provides 1 test case.
 * This case may not test everything and it is
 * always recommended that you implement your own
 * tests. 
 * Driver files will not necessarily be
 * provided for all projects.
 */


#include <stdlib.h>
#include <iostream>

#include "promotedJerseyStack.h"

#define NHL_BRUINS "BRUINS"
#define NHL_AVALANCHE "AVALANCHE"
#define NHL_KINGS "KINGS"
#define NHL_RANGERS "RANGERS"

using namespace std;

bool equalsIgnoreCase(const string& a, const string& b) {
    unsigned int sz = a.size();
    if (b.size() != sz)
        return false;
    for (unsigned int i = 0; i < sz; ++i)
        if (tolower(a[i]) != tolower(b[i]))
            return false;
    return true;
}

void testHighestLowestPeek(string highestPricedJersey,
                          int highestPrice,
                          string lowestPricedJersey,
                          int lowestPrice,
                          string peekCity,
                          int peekCityPrice,
                          PromotedJerseyStack stack) {

    if (equalsIgnoreCase(stack.getHighestPricedPromotedJersey().getJersey(), highestPricedJersey)) {
        cout << "Stack highest priced model matches" << endl;
    } else {
        cout << "FAILED: Stack highest priced model does NOT match!" << endl;
        exit(EXIT_FAILURE);
    }

    if (stack.getHighestPricedPromotedJersey().getPromotedPrice() == highestPrice) {
        cout << "Stack highest priced model's price matches" << endl;
    } else {
        cout << "FAILED: Stack highest priced model's price does NOT match!" << endl;
        exit(EXIT_FAILURE);
    }

    if (equalsIgnoreCase(stack.getLowestPricedPromotedJersey().getJersey(), lowestPricedJersey)) {
        cout << "Stack lowest priced model matches" << endl;
    } else {
        cout << "FAILED: Stack lowest priced model does NOT match!" << endl;
        exit(EXIT_FAILURE);
    }

    if (stack.getLowestPricedPromotedJersey().getPromotedPrice() == lowestPrice) {
        cout << "Stack lowest priced model's price matches" << endl;
    } else {
        cout << "FAILED: Stack lowest priced model's price does NOT match!" << endl;
        exit(EXIT_FAILURE);
    }

    if (equalsIgnoreCase(stack.peek().getJersey(), peekCity)) {
        cout << "Stack peek matches" << endl;
    } else {
        cout << "FAILED: Stack peek does NOT match!" << endl;
        exit(EXIT_FAILURE);
    }

    if (stack.peek().getPromotedPrice() == peekCityPrice) {
        cout << "Stack peek price matches" << endl;
    } else {
        cout << "FAILED: Stack peek price does NOT match" << endl;
        exit(EXIT_FAILURE);
    }
}

int main(int argc, char **argv) {

    PromotedJerseyStack stack;

    cout << "Pushing " << NHL_KINGS << " at 350" << endl;
    stack.push(NHL_KINGS, 350);
    testHighestLowestPeek(NHL_KINGS, 350,
                          NHL_KINGS, 350,
                          NHL_KINGS, 350, stack);

    cout << endl << "Pushing " << NHL_AVALANCHE << " at 640" << endl;
    stack.push(NHL_AVALANCHE, 640);
    testHighestLowestPeek(NHL_AVALANCHE, 640,
                          NHL_KINGS, 350,
                          NHL_AVALANCHE, 640, stack);

    cout << endl << "Pushing " << NHL_BRUINS << " at 380" << endl;
    stack.push(NHL_BRUINS, 380);
    testHighestLowestPeek(NHL_AVALANCHE, 640,
                          NHL_KINGS, 350,
                          NHL_BRUINS, 380, stack);

    cout << endl << "Popping from stack" << endl;
    PromotedJersey popped = stack.pop();

    if (equalsIgnoreCase(popped.getJersey(), NHL_BRUINS)) {
        cout << "Popped jersey matches" << endl;
    } else {
        cout << "FAILED: Popped jersey does NOT match!" << endl;
        exit(EXIT_FAILURE);
    }

    if (popped.getPromotedPrice() == 380) {
        cout << "Popped price matches" << endl;
    } else {
        cout << "Popped price does NOT match" << endl;
        exit(EXIT_FAILURE);
    }

    testHighestLowestPeek(NHL_AVALANCHE, 640,
                          NHL_KINGS, 350,
                          NHL_AVALANCHE, 640, stack);

    cout << endl << "SUCCESS! All tests passed!" << endl;

    exit(EXIT_SUCCESS);
}
