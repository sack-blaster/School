/**
 * I the undersigned promise that the submitted assignment is my own work. While I was
free to discuss ideas with others, the work contained is my own. I recognize that
should this not be the case; I will be subject to penalties as outlined in the course
syllabus.
Name: Jacob Archer
Red ID: 824816519
 */

#ifndef PROMOTEDJERSEYSTACK_H
#define PROMOTEDJERSEYSTACK_H

#include <ctype.h>
#include <stdio.h>
#include <string>
#include <vector>
#include <stdexcept>

using namespace std;

class PromotedJersey {
private:
    string jersey;
    int promotedPrice;

public:
    PromotedJersey();

    PromotedJersey(string j, int p);

    inline string getJersey() const {
        return jersey;
    }

    inline int getPromotedPrice() const {
        return promotedPrice;
    }
};

class PromotedJerseyStack {
private:
    struct JerseyInfo {
        PromotedJersey jersey;
        int currentMin;
        int currentMax;
        JerseyInfo(PromotedJersey j, int min, int max) : jersey(j), currentMin(min), currentMax(max) {}
    };

    vector<JerseyInfo> stack;  // Vector to store jerseys along with current min and max prices

public:
    void push(string jersey, int price);

    PromotedJersey pop();

    PromotedJersey peek() const;

    PromotedJersey getHighestPricedPromotedJersey() const;

    PromotedJersey getLowestPricedPromotedJersey() const;
};

#endif // PROMOTEDJERSEYSTACK_H
