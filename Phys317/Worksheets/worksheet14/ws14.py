import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('LAttractor.dat', unpack=True)
plt.plot(x,y, color='blue', linewidth=1.0, linestyle='-', label='$x_0=10$, $y_0=10$, $z_0=-5$')

plt.xlabel('x', fontsize=15)
plt.ylabel('z(x)', fontsize=15)

plt.legend(loc='upper left', fontsize=15)

# Set x limits
plt.xlim(-20,25)
# Set y limits
plt.ylim(0,60)

plt.savefig('LAttractor.pdf')

plt.show()
