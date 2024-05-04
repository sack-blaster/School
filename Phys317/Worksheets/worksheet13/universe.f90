PROGRAM Universe

! This program solves the Friedman equation to yield the size of the universe
! from the current age of the universe to 10 times the current age of the
! universe.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  03/06/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: omega_m, omega_a, step, r_0, d_r, delta_t, x_t0, x_t1, r_1
INTEGER :: i

OPEN(unit=10, file='universe.dat', status='unknown')

WRITE(*,*) 'Enter Omega M and Omega A:'
READ(*,*) omega_m, omega_a

! Define variables
r_0 = 1.0
delta_t = 0.001
x_t0 = 1.0

rFunction: DO i=1, 9000
             step = (i / 1000.0) + 1.0
             d_r = ((-omega_m / (2*r_0**2)) + omega_a*r_0)
             r_1 = r_0 + (x_t0*delta_t)
             x_t1 = x_t0 + (d_r*delta_t)
             WRITE(10,*) step, r_0
             r_0 = r_1
             x_t0 = x_t1
           END DO rFunction
CLOSE(unit=10)

END PROGRAM Universe