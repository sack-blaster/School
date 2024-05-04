import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('xy.dat', unpack=True)
plt.plot(x,y, color='blue', linewidth=2.0, linestyle='-',
label='$x_0=1$, $y_0=0$, $z_0=0$, $\dot x_0=0$, $\dot y_0=1$, $\dot z_0=0$')

plt.xlabel('x  (scaled length)', fontsize=15)
plt.ylabel('y  (scaled length)', fontsize=15)

plt.legend(loc='lower left', fontsize=15)

# Set x limits
plt.xlim(-1.5,1.5)
# Set y limits
plt.ylim(-1.5,1.5)

plt.savefig('xy.pdf')

plt.show()
