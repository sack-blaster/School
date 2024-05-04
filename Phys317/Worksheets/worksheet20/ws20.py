# Python script used to plot the probability density vs concentration
import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

#pyplot.yscale('exp')
x, y = np.loadtxt('NIMBUS7.dat', unpack=True)
plt.scatter(x,y)

x, y = np.loadtxt('NIMBUS7_BESTFIT.dat', unpack=True) 
plt.plot(x,y, color='blue', linewidth=2.0, linestyle='-')

plt.xlabel('Altitude  (km)', fontsize=15)
plt.ylabel('Ozone Mixing Ration  (ppmv)', fontsize=15)
#plt.legend(loc='lower right', fontsize=15)

# Set x limits
plt.xlim(15,45)
# Set x ticks
plt.xticks(np.arange(15,50,5))

# Set y limits
plt.ylim(2,12.01)

plt.savefig('NIMBUS7.dat.pdf')

plt.show()
