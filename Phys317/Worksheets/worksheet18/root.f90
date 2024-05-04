Program Roots

IMPLICIT NONE

! Define variables
REAL :: f, x, x_0, x_1, e, diff, t, delta_t, fx, fx2
REAL, PARAMETER :: pi = ACOS(-1.0)
INTEGER :: n, i

e = 0.000001
i = 0

! Get user input
WRITE(*,*) 'Enter intital guess value: '
READ(*,*) x_0
WRITE(*,*) 'Enter number of iterations N: '
READ(*,*) n

! Create loop to find root of function
DO WHILE (i<=n)
    x_1 = x_0 - fx(x_0)/fx2(x_0)
    diff = ABS(x_1 - x_0)
    WRITE(*,*) 'it= ', i, ' diff= ', diff, ' x_new= ', x_1
    IF (diff <= e) goto 1000 ! End loop at this point
    IF (i==n) WRITE(*,*) 'Root not found -> calculation terminated' ! Account for errors
    x_0 = x_1
    i = i+1
END DO

1000 continue
END PROGRAM Roots

! Define f(x)
FUNCTION fx(x)
IMPLICIT NONE
REAL :: fx, x

fx = EXP(X) * LOG(x) - x**2 + 3*x**3 - 20.0*x

END FUNCTION fx

! Define f'(x)
FUNCTION fx2(x)
IMPLICIT NONE
REAL :: x, fx2

fx2 = EXP(X) * LOG(x) + EXP(x)/x - 2.0*x + 9.0*x**2 - 20.0

END FUNCTION fx2