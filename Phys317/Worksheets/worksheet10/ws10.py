import numpy as np
import matplotlib.pyplot as plt

# Create a new figure of size 8x6 points, using 100 dots per inch
plt.figure(figsize=(8,6), dpi=100)

x, y = np.loadtxt('FourierTrExact.dat', unpack=True)
plt.plot(x,y, color='black', linewidth=2.0, linestyle='-', label='Exact')
x, y = np.loadtxt('FourierTrNum.dat', unpack=True)
plt.plot(x,y, color='red', linewidth=2.0, linestyle='--', label='Numerical')

plt.xlabel('$\omega$ (s$^{-1}$)', fontsize=15)
plt.ylabel('F($\omega$) (s)', fontsize=15)
plt.legend(loc='upper right', fontsize=15)

plt.savefig('Fourier.pdf')

plt.show()
