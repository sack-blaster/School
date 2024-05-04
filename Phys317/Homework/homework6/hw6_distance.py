import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('distance.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=2.0, linestyle='-') 

plt.xlabel('Time (s)', fontsize=15)
plt.ylabel('Distance (m)', fontsize=15)

#Set x limits
plt.xlim(0,200)
# Set y limits
plt.ylim(0,12000)

# Set x ticks
plt.xticks(np.arange(0,201,20))

plt.savefig('distance.pdf')

plt.show()
