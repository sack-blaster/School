import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('expData.dat', unpack=True)
plt.plot(x,y, 's', color='blue', linewidth=2.0, label=' Experimental Data')

x, y = np.loadtxt('bestFit.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=2.0, linestyle='-', label='Least Squares Best Fit')

plt.xlabel('1/r$^2$  (1/m$^2$)', fontsize=15)
plt.ylabel('F  (N)', fontsize=15)

plt.legend(loc='lower right', fontsize=15)

# Set x limits
plt.xlim(0,5)
# Set y limits
plt.ylim(0,3e-10)

# Set x and y ticks
#plt.xticks(np.arange(0,51,5))
#plt.yticks(np.arange(0,1001,100))

plt.savefig('least_squares_fit.py.pdf')

plt.show()
