PROGRAM Comet

! This program calculates the position and velocity of a comet in 3 dimensions 
! at various points along it's orbit over one orbital period. The results will 
! satisfy Newton’s inverse-square law differential equations.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  03/20/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: t, delta_t, step, p, u, r_0, x_0, y_0, z_0, v_x0, v_y0, v_z0
REAL, PARAMETER :: pi=ACOS(-1.0)
INTEGER :: i, j

OPEN(unit=10, file='xy.dat', status='unknown') 

delta_t = 0.0001
p = 2.0 * pi
t = 0.0
u = 1.0
r_0 = 1.0

CALL INITIAL(x_0, y_0, z_0, v_x0, v_y0, v_z0)

DO WHILE (t <= p)
    WRITE(10,*) x_0, y_0
    r_0 = SQRT(x_0**2 + y_0**2 + z_0**2)
    x_0 = x_0 + v_x0 * delta_t 
    y_0 = y_0 + v_y0 * delta_t
    z_0 = z_0 + v_z0 * delta_t
    v_x0 = v_x0 - ((u*x_0)/r_0**3) * delta_t
    v_y0 = v_y0 - ((u*y_0)/r_0**3) * delta_t
    v_z0 = v_z0 - ((u*z_0)/r_0**3) * delta_t
    t = t + delta_t
END DO

CLOSE (unit=10)

END PROGRAM Comet

SUBROUTINE INITIAL (x_0, y_0, z_0, v_x0, v_y0, v_z0)
    IMPLICIT NONE
    REAL :: x_0, y_0, z_0, v_x0, v_y0, v_z0
    x_0 = 1.0
    y_0 = 0.0
    z_0 = 0.0
    v_x0 = 0.0
    v_y0 = 1.0
    v_z0 = 0.0
END SUBROUTINE INITIAL