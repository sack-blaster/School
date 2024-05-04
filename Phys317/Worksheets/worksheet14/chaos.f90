PROGRAM Chaos

! This program solves the Lorenz equation to model deterministic chaos
! given a set of initial conditions and an interval of time.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  03/11/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: a, b, c, step, y_t0, d_x, d_y, d_z, delta_t, x_t0, x_t1, y_t1, z_t0, z_t1
INTEGER :: i, j

! Open output file
OPEN(unit=10, file='LAttractor.dat', status='unknown')

! Get user input for initial value variables
write(*,'(A)', advance='NO') 'Input value for x_0: '
read(*,*) x_t0
write(*,'(A)', advance='NO') 'Input value for y_0: '
read(*,*) y_t0
write(*,'(A)', advance='NO') 'Input value for z_0: '
read(*,*) z_t0

! Print out variables
WRITE(*,*) 'x_0= ', x_t0
WRITE(*,*) 'y_0= ', y_t0
WRITE(*,*) 'z_0= ', z_t0

! Define variables
a = 10
b = 28
c = 8.0 / 3.0
delta_t = 0.001

! Loop for each function
mainLoop: DO i=0, 100000
            step = i / 1000.0
            d_x = (a * (y_t0 - x_t0)) * delta_t
            d_y = (x_t0 * (b - z_t0) - y_t0) * delta_t
            d_z = ((x_t0 * y_t0) - c*z_t0) * delta_t
            WRITE(10,*) x_t0, z_t0
            x_t0 = d_x + x_t0
            y_t0 = d_y + y_t0
            z_t0 = d_z + z_t0
         END DO mainLoop
         
END PROGRAM Chaos