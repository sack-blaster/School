import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('integralEquation.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=1.0, linestyle='-', label='$\\xi=0$')
plt.xlabel('x', fontsize=15)
plt.ylabel('$\psi(x)$', fontsize=15)

#plt.legend(loc='lower left', fontsize=15)
plt.savefig('Fredholm.pdf')

plt.show()
