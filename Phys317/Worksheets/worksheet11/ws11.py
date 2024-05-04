import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

# Use logarithmic  y-axis
# plt.yscale('log',base=10)

x, y = np.loadtxt('COVID19.dat', unpack=True)
plt.plot(x,y, color='blue', linewidth=2.0, linestyle='--', label='Data set 1')

plt.xlabel('Time  (Days)', fontsize=15)
plt.ylabel('COVID-19 Cases Reported in the US', fontsize=15)
plt.legend(loc='upper left', fontsize=15)
plt.title('COVID-19 Cases', fontsize=15)

# Set x limits
plt.xlim(0,40.0)

# Set x ticks
plt.xticks(np.arange(0,40.1,5))

# Set y limits
plt.ylim(-10000,500000)

# Set y ticks
plt.yticks(np.arange(0,500001,50000))

plt.text(1, 10000, 'March 1, 2020', rotation=90, fontsize=10)
plt.text(38, 250000, 'April 7, 2020', rotation=90, fontsize=10)
plt.savefig('COVID19.dat.pdf')

plt.show()
