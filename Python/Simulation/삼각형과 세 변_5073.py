import sys
input = sys.stdin.readline

while True:
    nums = list(map(int, input().split()))

    if sum(nums) == 0:
        break

    nums.sort(reverse=True)

    if nums[0] >= nums[1] + nums[2]:
        print("Invalid")
        continue

    if nums[0] == nums[1] and nums[1] == nums[2]:
        print("Equilateral")
        continue

    if (nums[0] == nums[1] and nums[1] != nums[2]) or (nums[0] != nums[1] and nums[1] == nums[2]):
        print("Isosceles")
        continue

    print("Scalene")