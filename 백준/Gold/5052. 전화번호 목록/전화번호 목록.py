import sys
input = sys.stdin.readline

def func(phone):
    for numbers in phone:
        pre = ""
        # pre에 number 하나씩 더하면서 접두어인지 확인
        for number in numbers:
            pre += number
            if pre in phone and pre != numbers:
                return "NO"
    return "YES"

T = int(input())
for _ in range(T):
    N = int(input())
    phone = {}
    for _ in range(N):
        # hasp map 만들기
        temp = input().strip()
        phone[temp] = 1

    print(func(phone))