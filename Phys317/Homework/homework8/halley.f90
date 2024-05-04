PROGRAM Halley

! This program calculates the position and velocity of a Halley's comet in 3 dimensions 
! at various points along it's orbit over one orbital period. The results will 
! satisfy Newton’s inverse-square law differential equations. Based on the findings of
! this code and the plots created by it, the maximum distance is approximately
! 35 AU, and the orbital period(perihelion to perihelion) is approximately 74 years. 
! Therefore, I estimate that the next perihelion of Halley's comet will be 
! sometime in 2060 or 2061.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  03/27/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

IMPLICIT NONE

REAL :: t, delta_t, step, p, u, r_0, x_0, y_0, z_0, v_x0, v_y0, v_z0
REAL, PARAMETER :: pi=ACOS(-1.0)
INTEGER :: i

OPEN(unit=10, file='yx.dat', status='unknown') 
OPEN(unit=20, file='rt.dat', status='unknown') 

delta_t = 0.00002
p = 80.0
t = 0.0
u = 4.0 * pi**2
i = 0

CALL INITIAL(x_0, y_0, z_0, v_x0, v_y0, v_z0)

DO WHILE (t <= p)
    IF (mod(i, 1000) == 0) THEN
        WRITE(10,*) y_0, x_0
        WRITE(20,*) t, r_0
    END IF
    
    r_0 = SQRT(x_0**2 + y_0**2 + z_0**2)
    x_0 = x_0 + v_x0 * delta_t 
    y_0 = y_0 + v_y0 * delta_t
    z_0 = z_0 + v_z0 * delta_t
    v_x0 = v_x0 - ((u*x_0)/r_0**3) * delta_t
    v_y0 = v_y0 - ((u*y_0)/r_0**3) * delta_t
    v_z0 = v_z0 - ((u*z_0)/r_0**3) * delta_t
    t = t + delta_t
    i = i+1
END DO

CLOSE (unit=10)
CLOSE (unit=20)

END PROGRAM Halley

SUBROUTINE INITIAL (x_0, y_0, z_0, v_x0, v_y0, v_z0)
    IMPLICIT NONE
    REAL, INTENT(OUT) :: x_0, y_0, z_0, v_x0, v_y0, v_z0
    x_0 = 0.325514
    y_0 = -0.459460
    z_0 = 0.166229
    v_x0 = -9.096111
    v_y0 = -6.916686
    v_z0 = -1.30572
END SUBROUTINE INITIAL