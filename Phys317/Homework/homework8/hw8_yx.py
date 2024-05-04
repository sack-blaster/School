import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('yx.dat', unpack=True)
plt.plot(x,y, color='blue', linewidth=1.0, linestyle='-')
plt.xlabel('x (AU)', fontsize=15)
plt.ylabel('y (AU)', fontsize=15)

plt.savefig('yx.pdf')

plt.show()
