def solution(s):
    result = ""
    numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    
    n = ""
    for char in s:
        if char.isdecimal():
            result += char
        else:
            n += char
            if n in numbers:
                result += str(numbers.index(n))
                n = ""
    return int(result)