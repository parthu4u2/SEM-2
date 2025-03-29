def tower_of_hanoi(n, start, helper, end):
    if (n == 1):
        print(f"Move disc {n} from {start} to {end} ")
        return

    tower_of_hanoi(n - 1, start, end, helper)
    print(f"Move disc {n} from {start} to {end} ")
    tower_of_hanoi(n - 1, helper, start, end)
n=int(input("Enter Number Of Disks"))

tower_of_hanoi(n, 'A', 'B', "C")