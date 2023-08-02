#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int test()
{
    int start;
    int destination;
    int distance;
    int count;

    cin >> start >> destination;
    distance = destination - start;

    int a = sqrt(distance);
    if (a * a == distance)
        return a * 2 - 1;
    if (a * (a + 1) < distance)
        return (a * 2) + 1;
    else
        return a * 2;
}

int main()
{
    int testn;
    // vector<int> result;
    cin >> testn;

    for (int i = 0; i < testn; i++)
    {
        // result.push_back(test());
        cout << test() << '\n';
    }

    /*for (int i = 0; i < result.size(); i++)
    {
        cout << result[i] << '\n';
    }*/

    return 0;
}