/**
 * Start of a driver file to test cryptotree.cpp
 * CS 210 Summer 2024
 * @author Jacob Archer
 * @date Jun 2024
 */

#include "cryptotree.h"

#include <string>
#include <vector>
#include <iostream>

using namespace std;

/**
 * THIS DRIVER FILE IS ONLY A START!
 * IT IS CRITICAL THAT YOU ADD YOUR
 * OWN TEST CASES. MANY CASES ARE
 * HIDDEN ON GRADESCOPE.
 */

// cypto fork / branch consts used for testing
const vector<string> forks = {"singularity", 
                              "cash", 
                              "gold", 
                              "xt", 
                              "unlimited", 
                              "diamond", 
                              "private", 
                              "sv", 
                              "atom",
                              "boy",
                              "b2x",
                              "supercoin",
                              "blvck",
                              "abc",
                              "girl",
                              "candy",
                              "hot",
                              "stealth"};

/**
 * Print whether the given test case passed or failed
 * @param didPass - The test condition (true to pass, false to fail)
 * @param message - Description of what is being tested
 */
void asserts(bool didPass, string message) {
    if (didPass) {
        cout << "Passed: " << message << endl;
    } else {
        cout << "FAILED: " << message << endl;
        // Halts execution, comment out to
        // continue testing other parts
		// If you do comment this out, ignore the
		// "All test cases passed!" printout
        exit(EXIT_FAILURE);
    }
}

//TODO
int main(int argc, char **argv) {
    /*
     * Construct the following tree for testing
     * numbers are the indices into the const forks vector above.
     *                1
     *           /    \    \
     *           2    3    4
     *          / \  / \   \
     *          5 6  7 8   9
     *         /   \       \
     *         10  11      12
     * 
     *                  cash
     *           /        \       \
     *          gold        xt    unlimited
     *          / \         / \      \
     *     diamond private sv atom  boy
     *         /   \                 \
     *       b2x supercoin           blvck
     * 
     * post order traversal order:
     *   b2x diamond supercoin private gold sv atom xt blvck boy unlimited cash
     * 
     */

    CryptoForkNode *head = new CryptoForkNode(forks[1], vector<string>{forks[2], forks[3], forks[4]});
    CryptoForkNode *f2 = head->getDirectForks().at(0);
    CryptoForkNode *f3 = head->getDirectForks().at(1);
    CryptoForkNode *f4 = head->getDirectForks().at(2);

    f2->addForks(vector<string>{forks[5], forks[6]});
    f3->addForks(vector<string>{forks[7], forks[8]});
    f4->addFork(forks[9]);

    CryptoForkNode *f5 = f2->getDirectForks().at(0);
    CryptoForkNode *f6 = f2->getDirectForks().at(1);
    CryptoForkNode *f9 = f4->getDirectForks().at(0);

    f5->addFork(forks[10]);
    f6->addFork(forks[11]);
    f9->addFork(forks[12]);

    // IMPORTANT: This part will be autograded as well as manually inspected for grading

    // Begin Testing ---------------------------------------------------------------------
    // A few sample testing code are provided below
    
    // TODO: Test all CryptoForkTree functions
    //       according to the specifications in the comment section ABOVE each function signature. 
    // IMPORTANT: IN ADDITION to the TODOs below, 
    //            You MUST also construct at least one different tree 
    //            that is similar to the given example tree above for all your tests
    // Also make sure to check edge cases, such as empty tree, or one fork tree.

    // Test isCryptoForkNodePresent function ---------------------------------------------
    bool forkPresent = CryptoForkTree::isCryptoForkNodePresent(head, forks[6]);
    asserts(forkPresent, "Fork " + forks[6] + 
            " is present in tree, your code returned " + 
            (forkPresent ? "true" : "false"));
    forkPresent = CryptoForkTree::isCryptoForkNodePresent(head, forks[0]);
    asserts(forkPresent == false, "Fork " + forks[0] + 
            " is not present in tree, your code returned " + 
            (forkPresent ? "true" : "false"));

    // Additional test cases for isCryptoForkNodePresent
    forkPresent = CryptoForkTree::isCryptoForkNodePresent(head, forks[11]);
    asserts(forkPresent, "Fork " + forks[11] + 
            " is present in tree, your code returned " + 
            (forkPresent ? "true" : "false"));

    forkPresent = CryptoForkTree::isCryptoForkNodePresent(head, forks[13]);
    asserts(forkPresent == false, "Fork " + forks[13] + 
            " is not present in tree, your code returned " + 
            (forkPresent ? "true" : "false"));

    // Test findPreviousForksLeadingToACryptoFork function --------------------------------
    vector<string> previousForks; 
    forkPresent = CryptoForkTree::findPreviousForksLeadingToACryptoFork(head, forks[11], previousForks);
    asserts(forkPresent, "Fork " + forks[11] + " present in tree, your code returned " +
            (forkPresent ? "true" : "false")); 

    vector<string> expected_previous_forks{ forks[6], forks[2], forks[1] };
    asserts(previousForks == expected_previous_forks, 
            "Your code should return (" + forks[6] + " " + 
            forks[2] + " " + forks[1] + ") as ancestors of fork " + forks[11]);
    
    previousForks.clear();
    forkPresent = CryptoForkTree::findPreviousForksLeadingToACryptoFork(head, forks[0], previousForks);
    asserts(previousForks.size() == 0, "Fork " + forks[0] + 
            " is not present in tree, its ancestors should be empty");

    // Additional test cases for findPreviousForksLeadingToACryptoFork
    previousForks.clear();
    forkPresent = CryptoForkTree::findPreviousForksLeadingToACryptoFork(head, forks[10], previousForks);
    expected_previous_forks = { forks[5], forks[2], forks[1] };
    asserts(previousForks == expected_previous_forks, 
            "Your code should return (" + forks[5] + " " + 
            forks[2] + " " + forks[1] + ") as ancestors of fork " + forks[10]);

    previousForks.clear();
    forkPresent = CryptoForkTree::findPreviousForksLeadingToACryptoFork(head, forks[12], previousForks);
    expected_previous_forks = { forks[9], forks[4], forks[1] };
    asserts(previousForks == expected_previous_forks, 
            "Your code should return (" + forks[9] + " " + 
            forks[4] + " " + forks[1] + ") as ancestors of fork " + forks[12]);

    // Test findCryptoForkNodeLevel function ------------------------------------------------
    int forkLevel = CryptoForkTree::findCryptoForkNodeLevel(head, forks[4], 0);
    asserts(forkLevel == 1, "Level of Fork " + forks[4] + " should be 1, your code returns " +  
            to_string(forkLevel));

    forkLevel = CryptoForkTree::findCryptoForkNodeLevel(head, forks[11], 0);
    asserts(forkLevel == 3, "Level of Fork " + forks[11] + " should be 3, your code returns " +  
            to_string(forkLevel));

    // Additional test cases for findCryptoForkNodeLevel
    forkLevel = CryptoForkTree::findCryptoForkNodeLevel(head, forks[10], 0);
    asserts(forkLevel == 3, "Level of Fork " + forks[10] + " should be 3, your code returns " +  
            to_string(forkLevel));

    forkLevel = CryptoForkTree::findCryptoForkNodeLevel(head, forks[9], 0);
    asserts(forkLevel == 2, "Level of Fork " + forks[9] + " should be 2, your code returns " +  
            to_string(forkLevel));

    // Test findClosestSharedAncestor function ----------------------------------------------
    CryptoForkNode* ancestor = CryptoForkTree::findClosestSharedAncestor(head, forks[10], forks[11]);
    asserts(ancestor->getCryptoForkName() == forks[2], "Closest shared ancestor of " + forks[10] + " and " + forks[11] + " is " + forks[2]);

    ancestor = CryptoForkTree::findClosestSharedAncestor(head, forks[7], forks[8]);
    asserts(ancestor->getCryptoForkName() == forks[3], "Closest shared ancestor of " + forks[7] + " and " + forks[8] + " is " + forks[3]);

    // Additional test cases for findClosestSharedAncestor
    ancestor = CryptoForkTree::findClosestSharedAncestor(head, forks[10], forks[12]);
    asserts(ancestor->getCryptoForkName() == forks[1], "Closest shared ancestor of " + forks[10] + " and " + forks[12] + " is " + forks[1]);

    ancestor = CryptoForkTree::findClosestSharedAncestor(head, forks[5], forks[6]);
    asserts(ancestor->getCryptoForkName() == forks[2], "Closest shared ancestor of " + forks[5] + " and " + forks[6] + " is " + forks[2]);

    // Test findNumOfAncestorsBetween function -----------------------------------------------
    int numAncestors = CryptoForkTree::findNumOfAncestorsBetween(head, forks[10], forks[11]);
    asserts(numAncestors == 3, "Ancestors between " + forks[10] + " and " + forks[11] + 
            " should be 3, your code returns " + to_string(numAncestors));

    numAncestors = CryptoForkTree::findNumOfAncestorsBetween(head, forks[7], forks[8]);
    asserts(numAncestors == 1, "Ancestors between " + forks[7] + " and " + forks[8] + 
            " should be 1, your code returns " + to_string(numAncestors));

    // Additional test cases for findNumOfAncestorsBetween
    numAncestors = CryptoForkTree::findNumOfAncestorsBetween(head, forks[10], forks[12]);
    asserts(numAncestors == 5, "Ancestors between " + forks[10] + " and " + forks[12] + 
            " should be 5, your code returns " + to_string(numAncestors));

    numAncestors = CryptoForkTree::findNumOfAncestorsBetween(head, forks[5], forks[6]);
    asserts(numAncestors == 1, "Ancestors between " + forks[5] + " and " + forks[6] + 
            " should be 1, your code returns " + to_string(numAncestors));

    // Test deleteCryptoForkTree function ----------------------------------------------------
    CryptoForkTree::deleteCryptoForkTree(head);

    // Construct a different tree for further testing
    CryptoForkNode *newHead = new CryptoForkNode(forks[13], vector<string>{forks[14], forks[15]});
    CryptoForkNode *nf2 = newHead->getDirectForks().at(0);
    CryptoForkNode *nf3 = newHead->getDirectForks().at(1);
    nf2->addForks(vector<string>{forks[16]});
    nf3->addForks(vector<string>{forks[17]});

    asserts(CryptoForkTree::isCryptoForkNodePresent(newHead, forks[17]), "Fork " + forks[17] + " is present in new tree");
    asserts(!CryptoForkTree::isCryptoForkNodePresent(newHead, forks[10]), "Fork " + forks[10] + " is not present in new tree");

    previousForks.clear();
    asserts(CryptoForkTree::findPreviousForksLeadingToACryptoFork(newHead, forks[16], previousForks), "Finding previous forks for " + forks[16]);
    vector<string> expectedNewPreviousForks = {forks[14], forks[13]};
    asserts(previousForks == expectedNewPreviousForks, "Previous forks for " + forks[16] + " are correct in new tree");

    asserts(CryptoForkTree::findCryptoForkNodeLevel(newHead, forks[15], 0) == 1, "Level of fork " + forks[15] + " is 1 in new tree");
    asserts(CryptoForkTree::findCryptoForkNodeLevel(newHead, forks[17], 0) == 2, "Level of fork " + forks[17] + " is 2 in new tree");

    ancestor = CryptoForkTree::findClosestSharedAncestor(newHead, forks[16], forks[17]);
    asserts(ancestor->getCryptoForkName() == forks[13], "Closest shared ancestor of " + forks[16] + " and " + forks[17] + " is " + forks[13]);

    asserts(CryptoForkTree::findNumOfAncestorsBetween(newHead, forks[16], forks[17]) == 2, "Ancestors between " + forks[16] + " and " + forks[17] + " is 2");

    CryptoForkTree::deleteCryptoForkTree(newHead);

    cout << endl << "All test cases passed!" << endl;
}
