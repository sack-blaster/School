import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('rt.dat', unpack=True)
plt.plot(x,y, color='blue', linewidth=1.0, linestyle='-')
plt.xlabel('t (years)', fontsize=15)
plt.ylabel('r (AU)', fontsize=15)

plt.savefig('rt.pdf')

plt.show()
