Program Nimbus

IMPLICIT NONE

! Define variables
REAL :: xsum, ysum, sumProd, ysumSQ, xsumSQ, x(20), y(20), a, b, residual, ase, bestFit, aseSum, aseFinal
INTEGER :: i, n

n = 20
aseSum = 0.0

! Open data files
OPEN(unit=10, file='NIMBUS7.dat', status='unknown')
OPEN(unit=20, file='NIMBUS7_BESTFIT.dat', status='unknown')

! Create array from data file
makeArray: DO i=1, n
            READ(10,*) x(i), y(i)
          END DO makeArray

! Define sums
xsum = SUM(x)
ysum = SUM(y)
sumProd = SUM(x*y)
xsumSQ = SUM(x**2)
ysumSQ = SUM(y**2)

! Define a and b
a = ((ysum*xsumSQ) - (xsum*sumProd)) / (n*xsumSQ - xsum**2)
b = ((n*sumProd) - (xsum*ysum)) / (n*xsumSQ - xsum**2)

! Output linear model and column names
WRITE(*,*) 'Linear model: ', a,' + ', b,'x'
WRITE(*,*) 'original original best fit residual'
WRITE(*,*) '   x        y         Y       r'

! Loop for output values
output: DO i=1, n
    bestFit = a + b*x(i)
    ase = (y(i) - bestFit)**2
    aseSum = aseSum + ase
    residual = y(i) - bestFit
    WRITE(*,*) x(i), y(i), bestFit, residual
    WRITE(20,*) x(i), bestFit
END DO output

! Calculate and output averaged squared error (chi)
aseFinal = (1.0/n) * aseSum
WRITE(*,*) 'Averaged squared error (chi) = ', aseFinal

END PROGRAM Nimbus









