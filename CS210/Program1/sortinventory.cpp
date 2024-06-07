#include "sortinventory.h"

/**
 * I the undersigned promise that the submitted assignment is my own work. While I was
 * free to discuss ideas with others, the work contained is my own. I recognize that
 * should this not be the case; I will be subject to penalties as outlined in the course
 * syllabus.
 * Name: Jacob Archer
 * Red ID: 824816519
 * 
 * @brief sort inventory solution 
 * 
 * @param items             online inventory array
 * @param mostPromoted      most promoted item which should be moved to the front
 * @param leastPromoted     least promoted item which should be moved to the end
 * @return vector<string>   sorted inventory according to first promoted and last promoted items
 *                          AND the order of all other items should be preserved
 * 
 * Time complexity - O(N), N is the size/length of the input vector size
 * Space complexity - O(1), size of auxiliary space used is a constant, as sorting is
 * done by swapping elements in the vector 
 */
vector<string> SortInventory::sortInventory(vector<string> items, 
                                            string mostPromoted, 
                                            string leastPromoted)
 {

    if (items.empty()) return items;

    // Helper function to convert string to lowercase. This will ensure case insensitivity.
    auto toLower = [](const string& s) -> string {
        string result = s;
        for (size_t i = 0; i < s.length(); ++i) {
            result[i] = tolower(s[i]);
        }
        return result;
    };

    string mostPromotedLower = toLower(mostPromoted);
    string leastPromotedLower = toLower(leastPromoted);

    // First pass: Identify positions
    int n = items.size();
    int writeIndex = 0;
    int readIndex = 0;

    for (int i = 0; i < n; ++i) {
        if (toLower(items[i]) == mostPromotedLower) {
            swap(items[writeIndex++], items[i]);
        }
    }

    readIndex = writeIndex;

    // Second pass: Handle least promoted items
    for (int i = writeIndex; i < n; ++i) {
        if (toLower(items[i]) != leastPromotedLower) {
            swap(items[readIndex++], items[i]);
        }
    }

    // Move leastPromoted items to the end
    for (int i = readIndex; i < n; ++i) {
        if (toLower(items[i]) == leastPromotedLower) {
            swap(items[readIndex++], items[i]);
        }
    }

    return items;
}
  
