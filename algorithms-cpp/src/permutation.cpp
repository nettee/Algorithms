#include <vector>
#include <algorithm>

using namespace std;

class Permutation {
public:
    static vector<vector<int>> permutation(vector<int>& nums) {
        vector<int> current(nums.begin(), nums.end());
        vector<vector<int>> res;
        backtrack(current, 0, res);
        return res;
    }

    // current[0..m) are chosen, current[m..N) are candidates
    static void backtrack(vector<int>& current, int m, vector<vector<int>>& res) {
        if (m == current.size()) {
            res.push_back(current);
            return;
        }

        for (int i = m; i < current.size(); i++) {
            swap(current[m], current[i]);
            backtrack(current, m + 1, res);
            swap(current[m], current[i]);
        }
    }
};

class Permutationk {
public:
    static vector<vector<int>> permutation(vector<int>& nums, int k) {
        vector<int> current(nums.begin(), nums.end());
        vector<vector<int>> res;
        backtrack(k, current, 0, res);
        return res;
    }

    // current[0..m) are chosen, current[m..N) are candidates
    static void backtrack(int k, vector<int>& current, int m, vector<vector<int>>& res) {
        if (m == k) {
            res.push_back(vector<int>(current.begin(), current.begin() + k));
            return;
        }

        for (int i = m; i < current.size(); i++) {
            swap(current[m], current[i]);
            backtrack(k, current, m + 1, res);
            swap(current[m], current[i]);
        }
    }
};

class Combinationk {
public:
    static vector<vector<int>> combination(vector<int>& nums, int k) {
        vector<int> current(nums.begin(), nums.end());
        sort(current.begin(), current.end());
        vector<vector<int>> res;
        backtrack(k, current, 0, 0, res);
        return res;
    }

    // current[0..m) are chosen, current[n..N) are candidates
    static void backtrack(int k, vector<int>& current, int m, int n, vector<vector<int>>& res) {
        if (m == k) {
            res.push_back(vector<int>(current.begin(), current.begin() + k));
            return;
        }

        for (int i = n; i < current.size(); i++) {
            swap(current[m], current[i]);
            backtrack(k, current, m+1, i+1, res);
            swap(current[m], current[i]);
        }
    }
};



vector<vector<int>> permutation(vector<int>& nums) {
    return Permutation::permutation(nums);
}

vector<vector<int>> permutation_k(vector<int>& nums, int k) {
    return Permutationk::permutation(nums, k);
}

vector<vector<int>> combination_k(vector<int>& nums, int k) {
    return Combinationk::combination(nums, k);
}


