try:
    x = float('abc123')
    print('the conversion is complete')
except IOError:
    print('IOerror')
except ValueError:
    print('This caused value error')
print('the end')