import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('FE_p.dat', unpack=True)

plt.plot(x,y, color='blue', linewidth=2.0, linestyle='-',
label='E=??? keV, K=??? keV, $\phi=73^o$')

plt.xlabel("E??? ", fontsize=15)
plt.ylabel("F???? ", fontsize=15)

plt.legend(loc='lower left', fontsize=15)

# Set x limits
plt.xlim(0,160)
# Set y limits
plt.ylim(-1.5,1.5)

plt.savefig('FE_p.pdf')

plt.show()
