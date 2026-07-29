#include <string>
#include <vector>
#include <algorithm>
using namespace std;
// 시간을 "HH:MM" 형식에서 분으로 변환하는 함수
int timeToMinutes(const string& time) {
    int hours = stoi(time.substr(0, 2));
    int minutes = stoi(time.substr(3, 2));
    return hours * 60 + minutes;
}

// 분을 다시 "HH:MM" 형식으로 변환하는 함수
string minutesToTime(int totalMinutes) {
    int hours = totalMinutes / 60;
    int minutes = totalMinutes % 60;
    string hourStr = (hours < 10 ? "0" : "") + to_string(hours);
    string minuteStr = (minutes < 10 ? "0" : "") + to_string(minutes);
    return hourStr + ":" + minuteStr;
}

string solution(int n, int t, int m, vector<string> timetable) {
    vector<int> crewTimes;

    // 대기자 시간표를 분 단위로 변환
    for (const string& time : timetable) {
        crewTimes.push_back(timeToMinutes(time));
    }

    // 대기자들을 시간 순으로 정렬
    sort(crewTimes.begin(), crewTimes.end());

    int busTime = 9 * 60;  // 첫 버스 출발 시간 09:00 (분 단위)
    int crewIndex = 0;     // 대기자 시간표 인덱스
    int lastCrewTime = 0;  // 마지막에 탑승한 대기자의 시간

    for (int i = 0; i < n; ++i) {
        int availableSeats = m;  // 각 셔틀의 좌석 수

        // 현재 셔틀버스 시간에 탈 수 있는 대기자들을 태움
        while (availableSeats > 0 && crewIndex < crewTimes.size() && crewTimes[crewIndex] <= busTime) {
            lastCrewTime = crewTimes[crewIndex];  // 마지막으로 탑승한 대기자 시간 갱신
            ++crewIndex;
            --availableSeats;
        }

        // 마지막 셔틀이라면
        if (i == n - 1) {
            if (availableSeats > 0) {
                // 좌석이 남아있으면 셔틀버스 시간에 맞춰 도착하면 됨
                return minutesToTime(busTime);
            } else {
                // 좌석이 꽉 찼다면 마지막으로 탄 사람보다 1분 일찍 도착해야 함
                return minutesToTime(lastCrewTime - 1);
            }
        }

        // 다음 셔틀 버스 시간 갱신
        busTime += t;
    }

    return "";

}
