# Python script used to plot the probability density vs concentration
import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch,
plt.figure(figsize=(8,6), dpi=100)

#pyplot.yscale('exp')
x, y = np.loadtxt('universe.dat', unpack=True)
plt.plot(x,y, color='orange', linewidth=2.0, linestyle='-', label=r'$\Omega_{\rm M}=0.30$, $\Omega_\Lambda=0.70$')

plt.xlabel('Age', fontsize=15)
plt.ylabel('Relative Size of the Universe', fontsize=15)
plt.legend(loc='lower center', fontsize=15)

# Set x limits 
plt.xlim(1,3)
# Set x ticks
#plt.xticks(np.arange(0,751,50))

# Set y limits
plt.ylim(1.0,4.0)

plt.savefig('universe.pdf')

plt.show()
