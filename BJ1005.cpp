#include <iostream>
#include <vector>

class build
{
private:
    int buildTime;
    int totalBuildTime = -1;
    int level = 0;
    std::vector<int> con;

public:
    build(){};
    void setTime(int time) { buildTime = time; }
    void setTotalBuildTime(int time) { totalBuildTime = time; }
    void addCon(int n) { con.push_back(n); }
    void setlevel(int n) { level = n; }
    int getTime() { return buildTime; }
    int getTotalBuildTime() { return totalBuildTime; }
    int getCon(int n) { return (n < con.size()) ? con[n] : 0; };
    int getLevel() { return level; }
    int getConSize() { return con.size(); }
};

int test()
{
    // 입력 시작
    int buildNum;
    int conNum;
    int targetBuild;

    std::cin >> buildNum >> conNum;

    build buildings[buildNum];
    bool setlevel[buildNum];

    for (int i = 0; i < buildNum; i++)
    {
        int time;
        std::cin >> time;
        buildings[i].setTime(time);
    }

    for (int i = 0; i < conNum; i++)
    {
        int num, con;
        std::cin >> con >> num;
        buildings[num - 1].addCon(con - 1);
    }

    std::cin >> targetBuild;
    // 입력 끝

    // 알고리즘 시작
    int settingNum = 0; // level,totalTime 설정 완료된 건물 수

    for (int i = 0; i < buildNum; i++) // 선행조건 없는 건물들 찾아서 level 1로 설정
    {
        if (buildings[i].getConSize() == 0) // 선행조건 vector의 size가 0일시
        {
            buildings[i].setlevel(1);
            buildings[i].setTotalBuildTime(buildings[i].getTime()); // 자신의 건설시간 == 총 건설시간
            setlevel[i] = true;                                     // 세팅완료 테이블
            settingNum++;
        }
    }
    int num = 0;
    while (settingNum != buildNum) // 건물 갯수와 세팅 완료된 건물의 수가 같을떄 까지 반복
    {
        int err = 0;
        if (num >= buildNum)
            num = 0;
        if (setlevel[num] == true) // 세팅 완료된 건물일시 다음으로 건너 뜀
        {
            num++;
            continue;
        }
        int maxLevel = 0;                                     // 선행 조건 건물 중 가장 높은 level 저장
        int maxTime = 0;                                      // 선행 조건 건물 중 가장 큰 totalbuildtime 저장
        for (int i = 0; i < buildings[num].getConSize(); i++) // 선행 조건 갯수만큼 반복
        {
            if (buildings[buildings[num].getCon(i)].getLevel() == 0) // 선행 조건 중 아직 세팅 안된 건물 있을시 for문 break;
            {
                err = 1;
                break;
            }
            else
            {
                if (buildings[buildings[num].getCon(i)].getLevel() > maxLevel) // 현재 maxlevel보다 높을시 maxlevel에 저장
                    maxLevel = buildings[buildings[num].getCon(i)].getLevel();
                if (buildings[buildings[num].getCon(i)].getTotalBuildTime() > maxTime) // 현재 maxtime보다 클시 maxtime에 저장
                    maxTime = buildings[buildings[num].getCon(i)].getTotalBuildTime();
            }
        }
        if (err == 1) // 앞에 for문 break시 다음으로 건너뜀
        {
            num++;
            continue;
        }
        else
        {
            buildings[num].setlevel(maxLevel + 1);
            buildings[num].setTotalBuildTime(maxTime + buildings[num].getTime());
            setlevel[num] = true;
            num++;
            settingNum++;
        }
    }
    return buildings[targetBuild - 1].getTotalBuildTime();
}

int main()
{
    int testNum;
    std::cin >> testNum;
    std::vector<int> result;

    for (int i = 0; i < testNum; i++)
    {
        result.push_back(test());
    }
    for (int i = 0; i < testNum; i++)
    {
        std::cout << result[i] << '\n';
    }
}