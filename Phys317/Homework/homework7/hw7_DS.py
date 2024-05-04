import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('D_t.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=2.0, linestyle='-', label='D(t)') 
x, y = np.loadtxt('S_t.dat', unpack=True)
plt.plot(x,y, color='red', linewidth=2.0, linestyle='--', label='S(t)') 


plt.xlabel('Time (arb. units)', fontsize=15)
plt.ylabel('Demand and Supply', fontsize=15)

plt.legend(loc='upper right', fontsize=15)

#Set x limits
plt.xlim(0,40)
# Set y limits
plt.ylim(0,5)

# Set x ticks
#plt.xticks(np.arange(0,201,20))

plt.savefig('DS.pdf')

plt.show()
