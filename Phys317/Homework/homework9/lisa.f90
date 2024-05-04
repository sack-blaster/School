! This program solves a set of differential equations which describe the motion
! of three seperate spacecraft. These spacecraft are separated by millions of miles, 
! and LISA(Laser Interferometer Space Antenna) operates by relaying laser beams among 
! these crafts, combining signals to detect gravitational wave signatures. These waves 
! originate from distortions in spacetime caused by compact stellar binaries within 
! our Milky Way Galaxy and massive black holes in distant galaxies.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  04/10/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

Program Lisa

IMPLICIT NONE

! Define variables
REAL :: x_0, y_0, z_0, v_x0, v_y0, v_z0, delta_t, xi, t, r, eta, t_lim, r_0, r_dot
REAL, PARAMETER :: pi = ACOS(-1.0)
INTEGER :: n, i

eta = 4 * pi**2
t = 0.0
t_lim = 2.0 / SQRT(2.0)
r_0 = 0.0

! Get data from subroutine
CALL DATA1(x_0, y_0, z_0, v_x0, v_y0, v_z0)

! Get user input and display initial values
WRITE(*,*) 'Provide value for dt: '
READ(*,*) delta_t
WRITE(*,*) 'Initial position: ', x_0, y_0, z_0
WRITE(*,*) 'Initial velocity: ', v_x0, v_y0, v_z0
WRITE(*,*) 'Provide value for xi (e.g., 0 or 0.10): '
READ(*,*) xi
WRITE(*,*) 'Delta_t= ', delta_t
WRITE(*,*) 'eta= ', eta
WRITE(*,*) 'xi= ', xi


! Open output files
OPEN(unit=10, file='output.dat', status='unknown')

! Create loop to solve equations
DO WHILE (t <= t_lim)
    WRITE(10,*) x_0, z_0
    
    r_0 = SQRT(x_0**2 + y_0**2 + z_0**2)
    r_dot = (x_0*v_x0 + y_0*v_y0 + z_0*v_z0) / r_0
    x_0 = x_0 + v_x0 * delta_t 
    y_0 = y_0 + v_y0 * delta_t
    z_0 = z_0 + v_z0 * delta_t
    v_x0 = v_x0 - (((eta*x_0)/r_0**3) + xi*r_dot**2) * delta_t
    v_y0 = v_y0 - (((eta*y_0)/r_0**3) + xi*r_dot**2) * delta_t
    v_z0 = v_z0 - (((eta*z_0)/r_0**3) + xi*r_dot**2) * delta_t
    t = t + delta_t

END DO

CLOSE (unit=10)
! CLOSE (unit=20)

END PROGRAM Lisa

SUBROUTINE DATA1 (x_0, y_0, z_0, v_x0, v_y0, v_z0)
    IMPLICIT NONE
    REAL, INTENT(OUT) :: x_0, y_0, z_0, v_x0, v_y0, v_z0
    x_0 = 0.32551
    y_0 = -0.4595
    z_0 = 0.16623
    v_x0 = -9.09611
    v_y0 = -0.91669
    v_z0 =  -0.00572
END SUBROUTINE DATA1






