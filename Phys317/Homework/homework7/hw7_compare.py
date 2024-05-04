import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('P_t.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=2.0, linestyle='--', label='Numerical solution') 
x, y = np.loadtxt('P_analytic.dat', unpack=True)
plt.plot(x,y, color='red', linewidth=2.0, linestyle=':', label='Analytic solution') 

plt.xlabel('Time (arb. units)', fontsize=15)
plt.ylabel('P (arb. units)', fontsize=15)

plt.legend(loc='lower right', fontsize=15)

#Set x limits
plt.xlim(0,40)
# Set y limits
plt.ylim(0,40)

# Set x ticks
#plt.xticks(np.arange(0,201,20))

plt.savefig('P.pdf')

plt.show()
