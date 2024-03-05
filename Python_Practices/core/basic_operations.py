# Here, I will practice basic operations in python, not required though who knows.

# Exercise 1: Calculate the multiplication and sum of two numbers
# Given two integer numbers, return their product only if the product is equal to or lower than 1000. Otherwise, return their sum.

def multiplication_or_sum(num_1, num_2):
    # calculate product of numbers
    product = num_1 * num_2
    if product <= 1000:
        return product
    else:
        return num_1 + num_2
    

# first condition
result = multiplication_or_sum(20, 30)
print("The result is", result)

# Second condition
result = multiplication_or_sum(40, 30)
print("The result is", result)

# Exercise 2: Print the sum of the current number and the previous number
# Write a program to iterate the first 10 numbers, and in each iteration, print the sum of the current and previous number.


def curr_prev_sum():
    prev = 0
    for curr in range(0,11):
        sum = prev + curr
        print("Previous number is ", prev, "Current number is ", curr, "and sum is :",sum)
        prev = curr


curr_prev_sum()

def float_or_int(string):
    try:
        # try to convert it into a int
        val = int(string)
        print("Input is an integera number ", val)
    except ValueError:
        try:
            val = float(string)
            print("Input is a float number ", val)
        except ValueError:
            print("Input is string value")

float_or_int("233")
float_or_int("134")
float_or_int("123.45")


# Exercise 3: Print characters from a string that are present at an even index number
# Write a program to accept a string from the user and display characters that are present at an even index number.
# For example, str = "pynative" so you should display ‘p’, ‘n’, ‘t’, ‘v’.

def char_at_even(string):
    for idx in range(0,len(string)-1,2):
        print(idx, string[idx])

char_at_even("evenandodd")

#Iterate through a string letter by letter

def iterate_string(string):
    size = len(string)
    for ch in string: 
        print(ch)
    for idx in range(0,size): # by using index
        print(string[idx])


iterate_string("dipesh is mighty god")

# Exercise 4: Remove first n characters from a string 

def remove_first_n_chars(string, n):
    x = string[n:] # string[n:] = remove first n chars from string while string[:n] = include first n chars from string
    return x

result = remove_first_n_chars("dipesh",2)
print(result)