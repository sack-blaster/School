! This program examines the elastic scattering of photons off electrons. Utilizing New-
! ton’s root-finding technique, we will compute the roots of the Compton scattering 
! formula to determine the energy of X-ray photons that scatter off an electron.
! We will determine the energy E′ of the scattered X-ray photons using a given
! equation.
!
! History:
!       Version        Programmer      Date     Description/Comments
!       ------          -------         --      -------------------
!          1          Jacob Archer  04/08/2024  Code created from scratch
!
! SPECIAL REQUESTS: NONE

Program Compton

IMPLICIT NONE

! Define variables
REAL :: e, e_0, k, e_p1, phi, diff, f_ep, diff_lim, fp_ep, e_p, e_pf, e_ps
REAL, PARAMETER :: pi = ACOS(-1.0)
INTEGER :: n, i

! Open output file
OPEN(unit=10, file='FE_p.dat', status='unknown')

k = 2.5
e = 100.0
e_0 = 511.0
diff_lim = 0.00001
n = 30
e_ps = 0.0
e_pf = 150.0

! Get user input
WRITE(*,*) "Enter intital guess value (E'): "
READ(*,*) e_p
WRITE(*,*) 'Enter angle in degrees: '
READ(*,*) phi

phi = phi * (pi / 180)

! Create data for graph of f(e')
graph: DO WHILE (e_ps<=e_pf)
    WRITE(10,*)  e_ps, f_ep(e_ps, phi, k, e, e_0)
    e_ps = e_ps+1.0
END DO graph


! Create loop to find root of function
root: DO i=1, n
    e_p1 = e_p - f_ep(e_p, phi, k, e, e_0)/fp_ep(e_p, phi, k, e, e_0)
    diff = ABS(e_p1 - e_p)
    WRITE(*,*) 'it = ', i, ' Delta = ', diff, ' E_P = ', e_p1
    IF (diff <= diff_lim) goto 1000 ! End loop at this point
    e_p = e_p1
END DO root

CLOSE (unit=10)

1000 continue
END PROGRAM Compton

! Define f(e')
FUNCTION f_ep(e_p, phi, k, e, e_0)
IMPLICIT NONE
REAL, INTENT(IN) :: e_p, phi, k, e, e_0
REAL :: f_ep

f_ep = COS(phi) - (e**2 - e_p**2 + k**2 * (1.0 + (2.0*e_0)/k)) / (2.0*e*k*SQRT(1.0 + (2.0*e_0)/k))

END FUNCTION f_ep

! Define f'(e')
FUNCTION fp_ep(e_p, phi, k, e, e_0)
IMPLICIT NONE
REAL, INTENT(IN) :: e_p, phi, k, e, e_0
REAL :: fp_ep

fp_ep = (e_p / (e*k*SQRT(1.0 + (2.0*e_0)/k)))

END FUNCTION fp_ep







