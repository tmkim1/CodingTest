# 그리디
# 거스름 돈 - 최소의 동전 개수 구하기

n = 1260
count = 0

# 큰 단위 화폐부터 차례대로 배열에 삽입
coin_types = [500, 100, 50 ,10]

for coin in coin_types:
    count += n // coin
    n %= coin

print(count)
