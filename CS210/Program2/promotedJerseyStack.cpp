/**
 * I the undersigned promise that the submitted assignment is my own work. While I was
free to discuss ideas with others, the work contained is my own. I recognize that
should this not be the case; I will be subject to penalties as outlined in the course
syllabus.
Name: Jacob Archer
Red ID: 824816519
 */

#include "promotedJerseyStack.h"

// Implementing PromotedJersey methods
PromotedJersey::PromotedJersey() : jersey(""), promotedPrice(-1) {}

PromotedJersey::PromotedJersey(string j, int p) : jersey(j), promotedPrice(p) {}

// Implementing PromotedJerseyStack methods
void PromotedJerseyStack::push(string jersey, int price) {
    PromotedJersey pj(jersey, price);

    if (stack.empty()) {
        stack.emplace_back(pj, price, price);
    } else {
        int currentMin = min(price, stack.back().currentMin);
        int currentMax = max(price, stack.back().currentMax);
        stack.emplace_back(pj, currentMin, currentMax);
    }
}

PromotedJersey PromotedJerseyStack::pop() {
    if (stack.empty()) {
        throw logic_error("Promoted jersey stack is empty");
    }
    PromotedJersey topJersey = stack.back().jersey;
    stack.pop_back();
    return topJersey;
}

PromotedJersey PromotedJerseyStack::peek() const {
    if (stack.empty()) {
        throw logic_error("Promoted jersey stack is empty");
    }
    return stack.back().jersey;
}

PromotedJersey PromotedJerseyStack::getHighestPricedPromotedJersey() const {
    if (stack.empty()) {
        throw logic_error("Promoted jersey stack is empty");
    }
    int maxPrice = stack.back().currentMax;
    for (const auto& info : stack) {
        if (info.jersey.getPromotedPrice() == maxPrice) {
            return info.jersey;
        }
    }
    throw logic_error("Error retrieving the highest priced jersey");
}

PromotedJersey PromotedJerseyStack::getLowestPricedPromotedJersey() const {
    if (stack.empty()) {
        throw logic_error("Promoted jersey stack is empty");
    }
    int minPrice = stack.back().currentMin;
    for (const auto& info : stack) {
        if (info.jersey.getPromotedPrice() == minPrice) {
            return info.jersey;
        }
    }
    throw logic_error("Error retrieving the lowest priced jersey");
}
