#include "gtest/gtest.h"

#include "permutation.h"

int add(int a, int b){
    return a+b;
}

TEST(test1, c1){
    EXPECT_EQ(3, add(1,2));
}

void print_vector(vector<int>& a) {
    cout << '[';
    for (int i = 0; i < a.size(); i++) {
        cout << a[i];
        if (i < a.size() - 1) {
            cout << ", ";
        }
    }
    cout << ']' << endl;
}

TEST(test_permutation, c1) {
    vector<int> a{1, 2, 3, 4};

    cout << "P(4, 4): " << endl;
    for (auto& es : permutation(a)) {
        print_vector(es);
    }

    cout << "P(4, 2): " << endl;
    for (auto& es : permutation_k(a, 2)) {
        print_vector(es);
    }

    cout << "C(4, 2): " << endl;
    for (auto& es: combination_k(a, 2)) {
        print_vector(es);
    }

}

GTEST_API_ int main(int argc, char** argv){
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}