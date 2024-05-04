import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('linear.dat', unpack=True)
plt.plot(x,y, 's', color='blue', linewidth=2.0, label='Measured Data')

#, linestyle='-',
#label='WS 19: $R=50\; \Omega$, $L=0.2\; H$, $U(0)=150\; V$')

x, y = np.loadtxt('best_fit.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=2.0, linestyle='-', label='Least Squares Fit')


plt.xlabel('1/d  (1/m)', fontsize=15)
plt.ylabel('B  ($\mu$T)', fontsize=15)

plt.legend(loc='lower right', fontsize=15)

# Set x limits
plt.xlim(0,7)
# Set y limits
#plt.ylim(0,0.014)

plt.savefig('least_squares_fit.py.pdf')

plt.show()
