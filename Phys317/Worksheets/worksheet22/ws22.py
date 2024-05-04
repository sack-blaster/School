import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('xz1.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=1.0, linestyle='-', label='$\\xi=0$')
x, y = np.loadtxt('xz2.dat', unpack=True)
plt.plot(x,y, color='blue', linewidth=1.0, linestyle='-', label='$\\xi=0.015$')
plt.xlabel('x  (AU)', fontsize=15)
plt.ylabel('z  (AU)', fontsize=15)

plt.legend(loc='lower left', fontsize=15)
plt.savefig('lisa.pdf')

plt.show()
