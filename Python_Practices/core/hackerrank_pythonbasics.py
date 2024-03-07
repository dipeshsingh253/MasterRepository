# If else python : https://www.hackerrank.com/challenges/py-if-else/problem

def if_else_python(n):
    if n % 2 == 1:
        print("Weird")
    elif n % 2 == 0 and n in range(2, 6):
        print("Not Weird")
    elif n % 2 == 0 and n in range(6, 21):
        print("Weird")
    elif n % 2 == 0 and n > 20:
        print("Not Weird")

if_else_python(3)

# write a function : https://www.hackerrank.com/challenges/write-a-function/problem

def is_leap(year):
    leap = False
    
    # Write your logic here
    if year % 4 == 0:
        if year % 100 == 0:
            if year % 400 == 0:
                leap = True
            else:
                leap = False
        else:
            leap = True
    else:
        leap = False
    
    
    return leap

print(is_leap(1990))

####################################################################################
# Basic data types
####################################################################################

# List comprehension : https://www.hackerrank.com/challenges/list-comprehensions/problem
x = 1
y = 2
z = 3
n =3
cords = [
    [i,j,k]
    for i in range(x+1)
    for j in range(y+1)
    for k in range(z+1)
    if i+j+k != n
]

print(cords)


# find second max in unsorted array : https://www.hackerrank.com/challenges/find-second-maximum-number-in-a-list/problem

max_scr = float('-inf')
prev = max_scr

for i in arr:
    if max_scr < i:
        prev = max_scr
        max_scr = i
    elif prev < i < max_scr:
        prev = i