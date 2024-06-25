#include "cryptotree.h"
#include <iostream>

/**
 * Check if a crypto fork node is present in a crypto fork tree. 
 * 
 * @param  head the head / root CryptoForkNode of the crypto fork tree
 * @param  forkName the crypto fork name being searched
 * @return      true or false
 * @see         
 */
bool CryptoForkTree::isCryptoForkNodePresent(CryptoForkNode* head, string forkName) {
    if (!head) {
        return false;
    }
    if (head->getCryptoForkName() == forkName) {
        return true;
    }
    for (CryptoForkNode* child : head->getDirectForks()) {
        if (isCryptoForkNodePresent(child, forkName)) {
            return true;
        }
    }
    return false;
}

/**
 * Find all previous forks leading to a crypto fork node. 
 * 
 * @param  head          the head / root CryptoForkNode of the crypto fork tree
 * @param  forkName      the crypto fork name being searched
 * @param  previousforks a vector of fork names of all previous forks for the fork node
 *                       in the ascending order of their tree height
 *                       i.e., forks along the path starting from direct parent fork 
 *                       to the root node
 *                       If the fork tree is empty, or forkName is the head, or 
 *                       is not in the tree, previousForks should be empty after the search. 
 * @return               is crypto fork found
 * @see         
 */
bool CryptoForkTree::findPreviousForksLeadingToACryptoFork(CryptoForkNode* head, string forkName, vector<string> &previousForks) {
    if (!head) {
        return false;
    }
    if (head->getCryptoForkName() == forkName) {
        return true;
    }
    for (CryptoForkNode* child : head->getDirectForks()) {
        if (findPreviousForksLeadingToACryptoFork(child, forkName, previousForks)) {
            previousForks.push_back(head->getCryptoForkName());
            return true;
        }
    }
    return false;
}

/**
 * Find the level of a crypto fork in a crypto fork tree. 
 * 
 * <p>
 * The root node has a level of 0.
 * children of the head node passed in have
 * a level of the head plus 1, and so on and so forth... 
 * 
 * <p>
 * Assumption: forkName is unique among all fork names
 *
 * @param  head      the head / root CryptoForkNode of the fork tree
 * @param  forkName  the crypto fork name being searched
 * @param  headLevel the level of the head fork passed in 
 * @return  level of the CryptoForkNode in the fork tree
 *          returns CryptoForkNode::NOT_FOUND if forkName is not present
 * @see         
 */
int CryptoForkTree::findCryptoForkNodeLevel(CryptoForkNode* head, string forkName, int headLevel) {
    if (!head) {
        return CryptoForkNode::NOT_FOUND;
    }
    if (head->getCryptoForkName() == forkName) {
        return headLevel;
    }
    for (CryptoForkNode* child : head->getDirectForks()) {
        int level = findCryptoForkNodeLevel(child, forkName, headLevel + 1);
        if (level != CryptoForkNode::NOT_FOUND) {
            return level;
        }
    }
    return CryptoForkNode::NOT_FOUND;
}

/**
 * Find the closest shared ancestor of two forks f1 and f2. 
 * 
 * <p>
 * There are two possible fork relationships between two forks in the tree:
 * case 1: f1 or f2 is an ancestor of the other fork node; 
 * case 2: f1 or f2 is not an ancestor of the other fork node, 
 *         then they have at least one shared ancestor
 *
 * <p>
 * Assumption: f1_name and f2_name are unique among all fork names
 *
 * @param  head    the head / root CryptoForkNode of the fork tree
 * @param  f1_name name of fork node 1 being searched
 * @param  f2_name name of fork node 2 being searched 
 * @return   closest shared ancestor in the fork tree between fork node 1 and fork node 2
 *           if head is nullptr, returns nullptr
 *           if neither f1 nor f2 is present, returns nullptr           
 *           if f1 is present and f2 is not, returns f1
 *           if f2 is present and f1 is not, returns f2
 *           if f1 and f2 both are present, returns their closest shared ancestor
 *              if f1 is an ancestor of f2, returns f1
 *              else if f2 is an ancestor of f1, returns f2
 *              else returns the closest shared ancestor of f1 and f2
 * @see         
 */
CryptoForkNode* CryptoForkTree::findClosestSharedAncestor(CryptoForkNode* head, string f1_name, string f2_name) {
    if (!head) {
        return nullptr;
    }
    if (head->getCryptoForkName() == f1_name || head->getCryptoForkName() == f2_name) {
        return head;
    }
    vector<CryptoForkNode*> ancestors;
    for (CryptoForkNode* child : head->getDirectForks()) {
        CryptoForkNode* ancestor = findClosestSharedAncestor(child, f1_name, f2_name);
        if (ancestor) {
            ancestors.push_back(ancestor);
        }
    }
    if (ancestors.size() == 2) {
        return head;
    } else if (ancestors.size() == 1) {
        return ancestors.front();
    } else {
        return nullptr;
    }
}

/**
 * Calculate the number of ancestors between fork node 1 and fork node 2. 
 * 
 * <p>
 * The number of ancestors between fork node 1 and fork node 2 can be calculated by: 
 *  number of edges between fork node 1 and closest shared ancestor + 
 *  number of edges between fork node 2 and closest shared ancestor - 1
 *
 * <p>
 * Assumption: f1_name and f2_name are unique among all fork names
 *
 * @param  head    the head / root CryptoForkNode of the fork tree
 * @param  f1_name name of fork node 1 being searched
 * @param  f2_name name of fork node 2 being searched 
 * @return   number of ancestors between fork node 1 and fork node 2
 *           returns CryptoForkNode::NOT_FOUND if either f1 or f2 is 
 *           not present in the chart
 * @see         
 */
int CryptoForkTree::findNumOfAncestorsBetween(CryptoForkNode* head, string f1_name, string f2_name) {
    if (!isCryptoForkNodePresent(head, f1_name) || !isCryptoForkNodePresent(head, f2_name)) {
        return CryptoForkNode::NOT_FOUND;
    }
    CryptoForkNode* ancestor = findClosestSharedAncestor(head, f1_name, f2_name);
    int level_f1 = findCryptoForkNodeLevel(head, f1_name, 0);
    int level_f2 = findCryptoForkNodeLevel(head, f2_name, 0);
    int level_ancestor = findCryptoForkNodeLevel(head, ancestor->getCryptoForkName(), 0);
    return (level_f1 - level_ancestor) + (level_f2 - level_ancestor) - 1;
}


/** Recursively delete a tree 
 *  The proper implementation of this function is also needed for
 *  passing the valgrind memory leaking test. 
 * 
 * <p>
 * Traversing from the head / root node, recursively deallocate 
 * the memory of the descendants from the leaf node level. 
 *
 * DO NOT worry about removing them from the vector directForks
 * 
 * Use post order traversal:
 * Delete / deallocate the children recursively
 * Delete / deallocate the current node after deleting its children
 *     Before deleting the current node, print its fork name and a new line
 *     The print here is for verifying the order of the deletion
 *
 *     This part will be autograded as well as manually inspected for grading
 * 
 * For example, with the following tree, the post order traversal
 * order would be 5 6 2 7 8 3 1, and the nodes should be deleted in that order
 *             1
 *           /    \
 *           2    3
 *          / \  / \
 *          5 6  7 8
 *
 * @param  head  the head / root CryptoForkNode of the crypto fork tree
 * @return   None 
 * 
 * @see         
 */
void CryptoForkTree::deleteCryptoForkTree(CryptoForkNode* head) {
    if (!head) {
        return;
    }
    for (CryptoForkNode* child : head->getDirectForks()) {
        deleteCryptoForkTree(child);
    }
    cout << head->getCryptoForkName() << endl;
    delete head;
}
