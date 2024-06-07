#ifndef SORTINV_H
#define SORTINV_H

#include <vector>
#include <string>

using namespace std;

class SortInventory {

public:
  /**
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
  static vector<string> sortInventory(vector<string> items, 
                                      string mostPromoted, 
                                      string leastPromoted);

};

#endif