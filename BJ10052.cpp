#include <iostream>
#include <vector>
using namespace std;

class build
{
private:
    int buildTime;
    int totalBuildTime = -1;
    vector<int> con;

public:
    build() {}
    void setBuildTime(int n) { buildTime = n; }
    void setTotalBuildTime(int n) { totalBuildTime = n; }
    void addCon(int n) { con.push_back(n); }
    int getConSize() { return con.size(); }
    int getCon(int n) { return con[n]; }
    int getBuildTime() { return buildTime; }
    int getTotalBuildTIme() { return totalBuildTime; }
};

int findTotalTime(build buildings[], int targetNum)
{
    if (buildings[targetNum].getTotalBuildTIme() != -1)
        return buildings[targetNum].getTotalBuildTIme();
    if (buildings[targetNum].getConSize() == 0)
    {
        buildings[targetNum].setTotalBuildTime(buildings[targetNum].getBuildTime());
        return buildings[targetNum].getTotalBuildTIme();
    }
    int maxTime = 0;
    for (int i = 0; i < buildings[targetNum].getConSize(); i++)
    {
        int time = findTotalTime(buildings, buildings[targetNum].getCon(i));
        if (maxTime < time)
            maxTime = time;
    }
    buildings[targetNum].setTotalBuildTime(maxTime + buildings[targetNum].getBuildTime());
    return buildings[targetNum].getTotalBuildTIme();
}

int test()
{
    int buildNum;
    int conNum;
    int targetBuild;

    cin >> buildNum >> conNum;

    build buildings[buildNum];

    for (int i = 0; i < buildNum; i++)
    {
        int time;
        cin >> time;
        buildings[i].setBuildTime(time);
    }

    for (int i = 0; i < conNum; i++)
    {
        int num, con;
        cin >> con >> num;
        buildings[num - 1].addCon(con - 1);
    }

    cin >> targetBuild;
    targetBuild--;

    return findTotalTime(buildings, targetBuild);
}

int main()
{
    int testNum;
    cin >> testNum;
    vector<int> result;

    for (int i = 0; i < testNum; i++)
    {
        result.push_back(test());
    }
    for (int i = 0; i < testNum; i++)
    {
        cout << result[i] << '\n';
    }
    return 0;
}