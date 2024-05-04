Program gconstant

! This program  reads data from a given data table and uses the
! linear least-squares technique to fit that data with a best-fit model.
! It will also use the data to determine the value of G, the gravitational
! constant.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  05/1/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

! Define variables
REAL :: xsum, ysum, sumProd, ysumSQ, xsumSQ, a, b, dummy, gsum, gavg
INTEGER :: i, j, k, n, m=0, dim, AllocateStatus, DeAllocateStatus
REAL, allocatable :: x(:), y(:), g(:)

! Open data files
OPEN(unit=10, file='Fvsr.dat', status='unknown')
OPEN(unit=20, file='expData.dat', status='unknown')
OPEN(unit=30, file='bestFit.dat', status='unknown')

! Determine how much space needs to be allocated for arrays x and y
DO; READ(10,*,end=50) dummy, dummy; m=m+1
END DO
50 CONTINUE
dim = m ! Arrays need to have this dimension
REWIND(10)

! Allocate memory for arrays x and y
allocate(x(dim), stat=AllocateStatus)
if (AllocateStatus /=0) STOP 'Not enough memory'
allocate(y(dim), stat=AllocateStatus)
if (AllocateStatus /=0) STOP 'Not enough memory'
allocate(g(dim), stat=AllocateStatus)
if (AllocateStatus /=0) STOP 'Not enough memory'

n = dim

! Read data file
makeArray: DO i = 1, dim
            READ (10, *) x(i), y(i)
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

! Determine gravitational constant G from each data point
DO j=1, n
    g(j) = y(j) * x(j)**2
END DO

! Compute average G
gsum = SUM(g)
gavg = gsum / n

! Output to screen
WRITE(*,*) 'G=', gavg, 'N m^2 / kg^2'

! Loop to write to output files
output: DO k = 1, dim
          WRITE(20,*) x(k), y(k)
          WRITE(30,*) x(k), a+b*x(k)
        END DO output
        
END PROGRAM gconstant

