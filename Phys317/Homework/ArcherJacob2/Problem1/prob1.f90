PROGRAM Euler

IMPLICIT NONE

! Initialize variables
REAL :: a_0, a_1, v_0, v_1, h_0, h_t, omega_m, t, lim, delta_t
REAL, PARAMETER :: pi=ACOS(-1.0)
INTEGER :: i, j

! Open output file
OPEN(unit=10, file='euler.dat', status='unknown', iostat=i) 

! Check for errors in opening the file
if (i /= 0) then
WRITE(*,*) 'Error opening file'
stop
endif

! Define variables
delta_t = 0.01
lim = 10
t = 0.0

! Obtain intitial values from subroutine
CALL cosmological_data(h_0, omega_m, a_0, v_0)

! Main loop to solve equations
DO WHILE (t <= lim)
    WRITE(10,*) a_0
    h_t = h_0*SQRT(omega_m/a_0**3)
    v_1 = v_0 + ((-1.0/a_0) - h_t*v_0)*delta_t
    a_1 = a_0 + (a_0*h_t)*delta_t
    t = t + delta_t
    a_0 = a_1
    v_0 = v_1
END DO

! Close output file 
CLOSE (unit=10)

END PROGRAM Euler

! Subroutine to give initial values 
SUBROUTINE cosmological_data(h_0, omega_m, a_0, v_0)
    IMPLICIT NONE
    REAL :: h_0, omega_m, a_0, v_0
    v_0 = 0.0
    a_0 = 1.0
    h_0 = 70.0
    omega_m = 0.3
END SUBROUTINE cosmological_data