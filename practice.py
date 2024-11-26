num = int(input("Enter : "))
swapnum = (((num & 0xF0) >> 4) | ((num & 0x0F) << 4))
print(swapnum)