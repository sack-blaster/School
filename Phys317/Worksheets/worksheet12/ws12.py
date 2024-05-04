# Python script used to plot the probability density vs concentration
import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch,
plt.figure(figsize=(8,6), dpi=100)

#pyplot.yscale('exp')
x, y = np.loadtxt('pesticides.dat', unpack=True)
plt.plot(x,y, color='blue', linewidth=2.0, linestyle='-', label=r'$\alpha=10^{-6}$, $\delta=0.01$, $\alpha_1=0.01$, $\alpha_2=0.03$')

plt.xlabel('t (Days)', fontsize=15)
plt.ylabel('P(t)', fontsize=15)
plt.legend(loc='lower center', fontsize=15)

# Set x limits 
plt.xlim(0,750)
# Set x ticks
plt.xticks(np.arange(0,751,50))

# Set y limits
plt.ylim(0.0,0.00014)

plt.savefig('pesticidespdf')

plt.show()
