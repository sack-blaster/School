Program WoodSaxon

IMPLICIT NONE

! Define variables
REAL :: r_0, r_1, v_r, a, d, v_0, e_0, f_r, fp_r, diff, e
REAL, PARAMETER :: pi = ACOS(-1.0)
INTEGER :: n, i

v_0 = -53.0
d = 5.8571
a = 0.25
e_0 = -0.1
n = 30
i = 0
e = 0.00001

! Get user input
WRITE(*,*) 'Enter intital guess value: '
READ(*,*) r_0

! Create loop to find root of function
DO WHILE (i<=n)
    r_1 = r_0 - f_r(r_0, v_0, d, a, e_0)/fp_r(r_0, v_0, d, a)
    diff = ABS(r_1 - r_0)
    WRITE(*,*) 'it= ', i, ' diff= ', diff, ' x_new= ', r_1
    IF (diff <= e) goto 1000 ! End loop at this point
    IF (i==n) WRITE(*,*) 'Root not found -> calculation terminated' ! Account for errors
    r_0 = r_1
    i = i+1
END DO

1000 continue

! Output value
WRITE(*,10) r_1
10 FORMAT ('The radius of a U(238) nucleus is =', X, F6.3, X, 'fm')

END PROGRAM WoodSaxon

! Define f(r)
FUNCTION f_r(r_0, v_0, d, a, e_0)
IMPLICIT NONE
REAL :: f_r, r_0, v_0, d, a, e_0

f_r = v_0 * (1.0 / (1.0+EXP((r_0-d)/a))) - e_0

END FUNCTION f_r

! Define f'(r)
FUNCTION fp_r(r_0, v_0, d, a)
IMPLICIT NONE
REAL :: fp_r, r_0, v_0, d, a

fp_r = -((v_0*EXP((r_0-d)/a))/(a*((EXP((r_0-d)/a)+1)**2)))

END FUNCTION fp_r